package com.changgou.goods.controller;
import com.changgou.entity.PageResult;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Goods;
import com.changgou.goods.service.SpuService;
import com.changgou.goods.pojo.Spu;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin
@RequestMapping("/spu")
public class SpuController {


    @Autowired
    private SpuService spuService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<Spu> spuList = spuService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",spuList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Spu findById(@PathVariable("id") String id){
        Spu spu = spuService.findById(id);
        return spu;
    }


    /***
     * 新增数据
     * @param spu
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Spu spu){
        spuService.add(spu);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param spu
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Spu spu,@PathVariable String id){
        spu.setId(id);
        spuService.update(spu);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        spuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<Spu> list = spuService.findList(searchMap);
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
        Page<Spu> pageList = spuService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }


    @PostMapping("/addGoods")
    public Result addGoods(@RequestBody Goods goods){
        spuService.addGoods(goods);
        return new Result(true, StatusCode.OK, "添加商品成功");
    }


    @GetMapping("/findBySpuId/{spuId}")
    public Result findBySpuId(@PathVariable String spuId){
        Goods goods = spuService.findBySpuId(spuId);
        return new Result(true, StatusCode.OK, "根据spuId查询商品成功", goods);
    }


    @PostMapping("/updateGoods")
    public Result updateGoods(@RequestBody Goods goods){
        spuService.updateGoods(goods);
        return new Result(true, StatusCode.OK, "更新商品成功");
    }

    @PostMapping("/auditGoods/{spuId}")
    public Result auditGoods(@PathVariable String spuId){
        spuService.auditGoods(spuId);
        return new Result(true, StatusCode.OK, "审核商品通过");
    }

    @PostMapping("/upGoods/{spuId}")
    public Result upGoods(@PathVariable String spuId){
        spuService.upGoods(spuId);
        return new Result(true, StatusCode.OK, "商品上架成功");
    }

    @PostMapping("/downGoods/{spuId}")
    public Result downGoods(@PathVariable String spuId){
        spuService.downGoods(spuId);
        return new Result(true, StatusCode.OK, "商品下架成功");
    }

    @PostMapping("/deleteLogic/{spuId}")
    public Result deleteLogic(@PathVariable String spuId){
        spuService.deleteLogic(spuId);
        return new Result(true, StatusCode.OK, "逻辑删除商品成功");
    }

    @PostMapping("/restore/{spuId}")
    public Result restore(@PathVariable String spuId){
        spuService.restore(spuId);
        return new Result(true, StatusCode.OK, "恢复逻辑删除的商品成功");
    }

    @PostMapping("/deleteReal/{spuId}")
    public Result deleteReal(@PathVariable String spuId){
        spuService.deleteReal(spuId);
        return new Result(true, StatusCode.OK, "物理删除商品成功");
    }
}
