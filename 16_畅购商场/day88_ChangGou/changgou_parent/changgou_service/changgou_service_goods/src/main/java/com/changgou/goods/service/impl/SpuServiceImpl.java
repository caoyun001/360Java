package com.changgou.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.goods.dao.*;
import com.changgou.goods.pojo.*;
import com.changgou.goods.service.SpuService;
import com.changgou.util.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CategoryBrandMapper categoryBrandMapper;

    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<Spu> findAll() {
        return spuMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public Spu findById(String id){
        return  spuMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加
     * @param spu
     */
    @Override
    public void add(Spu spu){
        spuMapper.insert(spu);
    }


    /**
     * 修改
     * @param spu
     */
    @Override
    public void update(Spu spu){
        spuMapper.updateByPrimaryKey(spu);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        spuMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Spu> findList(Map<String, Object> searchMap){
        Example example = createExample(searchMap);
        return spuMapper.selectByExample(example);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Spu> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Spu>)spuMapper.selectAll();
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Spu> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Spu>)spuMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Spu.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 主键
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andEqualTo("id",searchMap.get("id"));
           	}
            // 货号
            if(searchMap.get("sn")!=null && !"".equals(searchMap.get("sn"))){
                criteria.andEqualTo("sn",searchMap.get("sn"));
           	}
            // SPU名
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
           	}
            // 副标题
            if(searchMap.get("caption")!=null && !"".equals(searchMap.get("caption"))){
                criteria.andLike("caption","%"+searchMap.get("caption")+"%");
           	}
            // 图片
            if(searchMap.get("image")!=null && !"".equals(searchMap.get("image"))){
                criteria.andLike("image","%"+searchMap.get("image")+"%");
           	}
            // 图片列表
            if(searchMap.get("images")!=null && !"".equals(searchMap.get("images"))){
                criteria.andLike("images","%"+searchMap.get("images")+"%");
           	}
            // 售后服务
            if(searchMap.get("saleService")!=null && !"".equals(searchMap.get("saleService"))){
                criteria.andLike("saleService","%"+searchMap.get("saleService")+"%");
           	}
            // 介绍
            if(searchMap.get("introduction")!=null && !"".equals(searchMap.get("introduction"))){
                criteria.andLike("introduction","%"+searchMap.get("introduction")+"%");
           	}
            // 规格列表
            if(searchMap.get("specItems")!=null && !"".equals(searchMap.get("specItems"))){
                criteria.andLike("specItems","%"+searchMap.get("specItems")+"%");
           	}
            // 参数列表
            if(searchMap.get("paraItems")!=null && !"".equals(searchMap.get("paraItems"))){
                criteria.andLike("paraItems","%"+searchMap.get("paraItems")+"%");
           	}
            // 是否上架
            if(searchMap.get("isMarketable")!=null && !"".equals(searchMap.get("isMarketable"))){
                criteria.andEqualTo("isMarketable",searchMap.get("isMarketable"));
           	}
            // 是否启用规格
            if(searchMap.get("isEnableSpec")!=null && !"".equals(searchMap.get("isEnableSpec"))){
                criteria.andEqualTo("isEnableSpec", searchMap.get("isEnableSpec"));
           	}
            // 是否删除
            if(searchMap.get("isDelete")!=null && !"".equals(searchMap.get("isDelete"))){
                criteria.andEqualTo("isDelete",searchMap.get("isDelete"));
           	}
            // 审核状态
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andEqualTo("status",searchMap.get("status"));
           	}

            // 品牌ID
            if(searchMap.get("brandId")!=null ){
                criteria.andEqualTo("brandId",searchMap.get("brandId"));
            }
            // 一级分类
            if(searchMap.get("category1Id")!=null ){
                criteria.andEqualTo("category1Id",searchMap.get("category1Id"));
            }
            // 二级分类
            if(searchMap.get("category2Id")!=null ){
                criteria.andEqualTo("category2Id",searchMap.get("category2Id"));
            }
            // 三级分类
            if(searchMap.get("category3Id")!=null ){
                criteria.andEqualTo("category3Id",searchMap.get("category3Id"));
            }
            // 模板ID
            if(searchMap.get("templateId")!=null ){
                criteria.andEqualTo("templateId",searchMap.get("templateId"));
            }
            // 运费模板id
            if(searchMap.get("freightId")!=null ){
                criteria.andEqualTo("freightId",searchMap.get("freightId"));
            }
            // 销量
            if(searchMap.get("saleNum")!=null ){
                criteria.andEqualTo("saleNum",searchMap.get("saleNum"));
            }
            // 评论数
            if(searchMap.get("commentNum")!=null ){
                criteria.andEqualTo("commentNum",searchMap.get("commentNum"));
            }

        }
        return example;
    }


    @Transactional
    @Override
    public void addGoods(Goods goods) {
        //1.保存SPU到表中
        goods.getSpu().setId(String.valueOf(idWorker.nextId())); //设置SPU表的主键ID由雪花算法生成
        spuMapper.insertSelective(goods.getSpu());


        //2.保存SKU到表中
        saveSkuList(goods);
    }

    private void saveSkuList(Goods goods) {
        Spu spu = goods.getSpu();
        Integer category3Id = spu.getCategory3Id();
        Category category = categoryMapper.selectByPrimaryKey(category3Id);//按照三级分类查询分类数据

        Integer brandId = spu.getBrandId();
        Brand brand = brandMapper.selectByPrimaryKey(brandId);//按照品牌ID查询品牌数据

        if(category!=null && brand!=null) {
            //处理分类与品牌表的关联关系，如果在中间表存在数据则忽略，如果不存在则新增关系数据
            CategoryBrand cb = new CategoryBrand();
            cb.setBrandId(brandId);
            cb.setCategoryId(category3Id);
            int count = categoryBrandMapper.selectCount(cb);
            if(count==0){
                categoryBrandMapper.insertSelective(cb);
            }
        }


        List<Sku> skuList = goods.getSkuList();
        if(skuList!=null && skuList.size()>0) {
            for (Sku sku : skuList) {
                sku.setId(String.valueOf(idWorker.nextId()));
                sku.setSpuId(spu.getId());
                //如果调用方传递规格字符串为空，要转JSON格式
                if(StringUtils.isEmpty(sku.getSpec())){
                    sku.setSpec("{}");
                }

                String skuName = spu.getName();
                String spec = sku.getSpec();
                Map<String,String> specMap = JSON.parseObject(spec, Map.class);
                if(specMap!=null && specMap.size()>0){
                    for(String key : specMap.keySet()){
                        skuName += " " + specMap.get(key);
                    }
                }
                sku.setName(skuName); //SKU名称的规则：spu的名称+sku的规格的值通过空格进行拼接
                sku.setCreateTime(new Date());
                sku.setUpdateTime(new Date());
                if(category!=null){
                    sku.setCategoryId(category3Id);
                    sku.setCategoryName(category.getName());
                }
                if(brand!=null){
                    sku.setBrandName(brand.getName());
                }
                skuMapper.insertSelective(sku);
            }
        }
    }


    @Override
    public Goods findBySpuId(String spuId) {
        //1.根据spuId查询spu
        Spu spu = spuMapper.selectByPrimaryKey(spuId);

        //2.根据spuId查询sku列表
        Example example = new Example(Sku.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("spuId", spuId);
        List<Sku> skuList = skuMapper.selectByExample(example);

        //3.封装goods
        Goods goods = new Goods();
        goods.setSpu(spu);
        goods.setSkuList(skuList);
        
        return goods;
    }

    @Transactional
    @Override
    public void updateGoods(Goods goods) {
        //1.更新spu数据
        spuMapper.updateByPrimaryKeySelective(goods.getSpu());

        //2.删除sku数据
        Example example = new Example(Sku.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("spuId", goods.getSpu().getId());
        skuMapper.deleteByExample(example);

        //3.新增sku数据
        saveSkuList(goods);
    }

    @Override
    public void auditGoods(String spuId) {
        //1.根据spuId查询spu数据
        Spu spu = spuMapper.selectByPrimaryKey(spuId);

        //2.设置状态为审核通过
        spu.setStatus("1");

        //3.执行更新
        spuMapper.updateByPrimaryKeySelective(spu);
    }


    @Override
    public void upGoods(String spuId) {
        //1.根据spuId查询spu数据
        Spu spu = spuMapper.selectByPrimaryKey(spuId);

        //2.判断当前商品状态是否审核通过，如果未通过抛异常
        if("0".equals(spu.getStatus())){
            throw new RuntimeException("未审核通过的商品不能上架！！！");
        }

        //3.设置状态为已上架
        spu.setIsMarketable("1");


        //4.执行更新
        spuMapper.updateByPrimaryKeySelective(spu);


        //5.将spuId存入到rabbitmq中
        rabbitTemplate.convertAndSend("goods_up_exchange", "", spuId);
    }


    @Override
    public void downGoods(String spuId) {
        //1.根据spuId查询spu
        Spu spu = spuMapper.selectByPrimaryKey(spuId);

        //2.判断当前商品的状态是否是已上架，如果是未上架的抛异常
        if("0".equals(spu.getIsMarketable())){
            throw new RuntimeException("只有上架的商品才能下架！！！");
        }

        //3.设置商品的状态为下架
        spu.setIsMarketable("0");

        //4.执行更新
        spuMapper.updateByPrimaryKeySelective(spu);

        //5.将spuId存入到rabbitmq中
        rabbitTemplate.convertAndSend("goods_down_exchange", "", spuId);
    }

    @Override
    public void deleteLogic(String spuId) {
        //1.根据spuid查询spu
        Spu spu = spuMapper.selectByPrimaryKey(spuId);

        //2.判断当前商品状态是否是已下架状态，如果是上架状态抛异常
        if("1".equals(spu.getIsMarketable())){
            throw  new RuntimeException("上架中的商品不能删除！！！");
        }

        //3.设置商品状态为已删除
        spu.setIsDelete("1");
        //设置商品为未审核
        spu.setStatus("0");

        //4.执行更新
        spuMapper.updateByPrimaryKeySelective(spu);
    }


    @Override
    public void restore(String spuId) {
        //1.根据spuId查询spu
        Spu spu = spuMapper.selectByPrimaryKey(spuId);

        //2.判断当前商品状态是否为逻辑删除状态，如果不是抛异常
        if("0".equals(spu.getIsDelete())){
            throw new RuntimeException("未删除的商品不需要恢复！！！");
        }


        //3.设置商品状态为未删除状态
        spu.setIsDelete("0");

        //4.执行更行
        spuMapper.updateByPrimaryKeySelective(spu);
    }


    @Transactional
    @Override
    public void deleteReal(String spuId) {
        //1.根据spuid查询spu
        Spu spu = spuMapper.selectByPrimaryKey(spuId);


        //2.判断当前商品状态是否是下架状态，如果不是抛异常
        if("1".equals(spu.getIsMarketable())){
            throw new RuntimeException("上架中的商品不能删除！！！");
        }


        //3.删除spu和sku
        spuMapper.deleteByPrimaryKey(spuId);
        Example example = new Example(Sku.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("spuId", spuId);
        skuMapper.deleteByExample(example);
    }
}
