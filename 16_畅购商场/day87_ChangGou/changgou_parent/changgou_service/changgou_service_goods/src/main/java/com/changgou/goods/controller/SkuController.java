package com.changgou.goods.controller;
import com.changgou.entity.PageResult;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.service.SkuService;
import com.changgou.goods.pojo.Sku;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin
@RequestMapping("/sku")
public class SkuController {


    @Autowired
    private SkuService skuService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Sku> skuList = skuService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",skuList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Sku findById(@PathVariable("id") String id){
        Sku sku = skuService.findById(id);
        return sku;
    }


    /***
     * 新增数据
     * @param sku
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Sku sku){
        skuService.add(sku);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param sku
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Sku sku,@PathVariable String id){
        sku.setId(id);
        skuService.update(sku);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        skuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Sku> list = skuService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<Sku> pageList = skuService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    
    @GetMapping("/findBySpuId/{spuId}")
    public List<Sku> findBySpuId(@PathVariable String spuId){
        Map<String, Object> searchMap  = new HashMap<>();
        searchMap.put("spuId", spuId);
        List<Sku> skuList = skuService.findList(searchMap);
        return skuList;
    }

    /**
     * 扣减库存,增加销量
     * @param skuId  购买商品的库存id
     * @param num    购买数量
     */
    @GetMapping("/decrCount")
    public boolean decrCount(@RequestParam("skuId") String skuId, @RequestParam("num")Integer num) {
        boolean flag = skuService.decrCount(skuId, num);
        return flag;
    }

    /**
     * 恢复库存, 恢复销量
     * @param skuId 恢复的库存id
     * @param num   恢复件数
     * @return
     */
    @GetMapping("/incrCount")
    public boolean incrCount(@RequestParam("skuId") String skuId, @RequestParam("num")Integer num) {
        boolean flag = skuService.incrCount(skuId, num);
        return flag;
    }

}
