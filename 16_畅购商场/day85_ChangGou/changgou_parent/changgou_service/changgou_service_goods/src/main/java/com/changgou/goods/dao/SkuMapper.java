package com.changgou.goods.dao;

import com.changgou.goods.pojo.Sku;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface SkuMapper extends Mapper<Sku> {

    /**
     * 扣减库存, 增加销量
     * @param skuId
     * @param num
     * @return
     */
    @Update("update tb_sku set num=num-#{num}, sale_num= sale_num + #{num} where id=#{skuId} and num>=#{num}")
    public int  decrCount(@Param("skuId") String skuId, @Param("num") Integer num);

    /**
     * 恢复库存, 恢复销量
     * @param skuId
     * @param num
     * @return
     */
    @Update("update tb_sku set num=num+#{num}, sale_num= sale_num - #{num} where id=#{skuId}")
    public int  incrCount(@Param("skuId") String skuId, @Param("num") Integer num);

}
