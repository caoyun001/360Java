package com.changgou.order.service.impl;

import com.changgou.entity.Constants;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.goods.feign.SpuFeign;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.pojo.Spu;
import com.changgou.order.pojo.OrderItem;
import com.changgou.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private SpuFeign spuFeign;


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * hash结构
     *   key : 用户名 (redis的key)
     *   value :  map类型
     *               key : skuId
     *               value : 商品条目
     */
    @Override
    public void add(String username, String skuId, Integer num) {

        //从redis缓存中查找当前用户的购物车的该商品
        OrderItem orderItem = (OrderItem) redisTemplate.boundHashOps(Constants.REDIS_CART + username).get(skuId);

        //如果缓存中的存在该商品，更新商品的数量及总价格到缓存中
        if(orderItem!=null){
            orderItem.setNum(orderItem.getNum()+num); //计算购物车中商品的总数量
            //如果前端传入后台的商品数量为负数，导致num计算后仍未负数，那么从缓存中移除该商品
            if(orderItem.getNum()<=0){
                redisTemplate.boundHashOps(Constants.REDIS_CART + username).delete(skuId);
                return;
            }
            orderItem.setMoney(orderItem.getPrice()*orderItem.getNum()); //计算购物车中商品价格小计
            orderItem.setPayMoney(orderItem.getPrice()*orderItem.getNum());//计算购物车中商品结算价格小计
        } else {
            //如果缓存中的不存在该商品，添加商品到缓存中
            orderItem = buildOrderItem(skuId, num);
        }

        //将数据重新更新到reids缓存中
        redisTemplate.boundHashOps(Constants.REDIS_CART + username).put(skuId, orderItem);
    }

    private OrderItem buildOrderItem(String skuId, Integer num){
        OrderItem orderItem = new OrderItem();
        Sku sku = skuFeign.findById(skuId);
        if(sku!=null){
            Spu spu = spuFeign.findById(sku.getSpuId());
            if(spu!=null){
                orderItem.setName(sku.getName());
                orderItem.setSkuId(skuId);
                orderItem.setSpuId(sku.getSpuId());
                orderItem.setNum(num);
                orderItem.setPrice(sku.getPrice());
                orderItem.setImage(sku.getImage());
                orderItem.setMoney(sku.getPrice()*num);
                orderItem.setPayMoney(sku.getPrice()*num);
                orderItem.setChecked(false); //设置购物车条目为未选中
                orderItem.setWeight(sku.getWeight());

                orderItem.setCategoryId1(spu.getCategory1Id());
                orderItem.setCategoryId2(spu.getCategory2Id());
                orderItem.setCategoryId3(spu.getCategory3Id());
            }
        }
        return orderItem;
    }


    @Override
    public Map list(String username) {
        Map result = new HashMap();
        List<OrderItem> orderItemList = redisTemplate.boundHashOps(Constants.REDIS_CART + username).values();
        result.put("orderItemList", orderItemList);

        Integer totalNum = 0; //总商品数量
        Integer totalPrice = 0; //总商品价格
        if(orderItemList!=null && orderItemList.size()>0){
            for (OrderItem orderItem : orderItemList) {
                //if(orderItem.isChecked()){
                    totalNum += orderItem.getNum();
                    totalPrice += orderItem.getPayMoney();
                //}
            }
        }
        result.put("totalNum", totalNum);
        result.put("totalPrice", totalPrice);

        return result;
    }


    @Override
    public void delete(String username, String skuId) {
        redisTemplate.boundHashOps(Constants.REDIS_CART + username).delete(skuId);
    }


    @Override
    public void updateChecked(String username, String skuId, Boolean checked) {
        //查询缓存中已经存在的商品条目
        OrderItem orderItem = (OrderItem) redisTemplate.boundHashOps(Constants.REDIS_CART + username).get(skuId);

        //更新商品条目的选中状态值
        if(orderItem!=null){
            orderItem.setChecked(checked);
            redisTemplate.boundHashOps(Constants.REDIS_CART + username).put(skuId, orderItem);
        }

    }
}
