package com.changgou.service;

import com.alibaba.fastjson.JSON;
import com.changgou.goods.feign.CategoryFeign;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.goods.feign.SpuFeign;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.pojo.Sku;
import com.changgou.goods.pojo.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PageServiceImpl implements  PageService{

    @Autowired
    private SpuFeign spuFeign;
    
    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private CategoryFeign categoryFeign;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${pagepath}")
    private String pagepath;

    @Override
    public Map buildPageData(String spuId) {
        Map pageData = new HashMap();

        //查询获取spu数据
        Spu spu = spuFeign.findById(spuId);
        if(spu==null){
            throw new RuntimeException("数据不存在！spuId:"+spuId);
        }
        pageData.put("spu", spu);


        //查询获取sku数据
        List<Sku> skuList = skuFeign.findBySpuId(spuId);
        pageData.put("skuList",  skuList);


        //查询获取三级分类数据
        Integer category1Id = spu.getCategory1Id();
        Integer category2Id = spu.getCategory2Id();
        Integer category3Id = spu.getCategory3Id();
        Category category1 = categoryFeign.findById(category1Id);
        Category category2 = categoryFeign.findById(category2Id);
        Category category3 = categoryFeign.findById(category3Id);
        pageData.put("category1", category1);
        pageData.put("category2", category2);
        pageData.put("category3", category3);

        //查询获取轮播图数据
        List<Map> imgList = JSON.parseArray(spu.getImages(), Map.class);
        List<String> imageList = new ArrayList<>();
        if(imgList!=null && imgList.size()>0){
            for (Map map : imgList) {
                String url = String.valueOf(map.get("url"));
                imageList.add(url);
            }
        }
        pageData.put("imageList", imageList);


        //查询获取规格列表数据
        Map specificationList = JSON.parseObject(spu.getSpecItems(), Map.class);
        pageData.put("specificationList", specificationList);

        return pageData;
    }

    @Override
    public void createPageHtml(String spuId) {
        FileWriter writer = null;
        try {
            Map pageData = buildPageData(spuId);
            Context context = new Context();
            context.setVariables(pageData);//为模板引擎设置数据


            File file = new File(pagepath); //判断目录是否存在
            if(!file.exists()){
                file.mkdirs();
            }

            writer = new FileWriter(pagepath + "/" + spuId + ".html");

            //利用模板引擎技术生成静态化页面到本地磁盘路径上
            templateEngine.process("item", context, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
