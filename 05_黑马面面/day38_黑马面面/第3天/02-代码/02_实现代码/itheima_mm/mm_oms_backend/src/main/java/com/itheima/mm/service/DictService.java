package com.itheima.mm.service;

import com.itheima.mm.pojo.Dict;

import java.util.List;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/15
 * @description ：数据字典业务接口
 * @version: 1.0
 */
public interface DictService {
	List<Dict> selectListByType(Integer typeId);
}
