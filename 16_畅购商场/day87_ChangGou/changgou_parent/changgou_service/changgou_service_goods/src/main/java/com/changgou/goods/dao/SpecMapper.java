package com.changgou.goods.dao;

import com.changgou.goods.pojo.Spec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecMapper extends Mapper<Spec> {


    @Select("select * from tb_spec where template_id in (select template_id from tb_category where name=#{cateName})")
    List<Spec> findByCateName(@Param("cateName") String cagteName);

}
