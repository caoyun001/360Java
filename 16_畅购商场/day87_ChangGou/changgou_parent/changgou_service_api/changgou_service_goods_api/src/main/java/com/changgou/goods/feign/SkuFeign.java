package com.changgou.goods.feign;

import com.changgou.entity.Result;
import com.changgou.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "goods")
@RequestMapping("/sku")
public interface SkuFeign {

    @GetMapping("/findBySpuId/{spuId}")
    public List<Sku> findBySpuId(@PathVariable("spuId") String spuId);

    @GetMapping
    public Result findAll();

    @GetMapping("/{id}")
    public Sku findById(@PathVariable("id") String id);

    /**
     * 扣减库存,增加销量
     * @param skuId  购买商品的库存id
     * @param num    购买数量
     */
    @GetMapping("/decrCount")
    public boolean decrCount(@RequestParam("skuId") String skuId, @RequestParam("num")Integer num);

    /**
     * 恢复库存, 恢复销量
     * @param skuId 恢复的库存id
     * @param num   恢复件数
     * @return
     */
    @GetMapping("/incrCount")
    public boolean incrCount(@RequestParam("skuId") String skuId, @RequestParam("num")Integer num);

}
