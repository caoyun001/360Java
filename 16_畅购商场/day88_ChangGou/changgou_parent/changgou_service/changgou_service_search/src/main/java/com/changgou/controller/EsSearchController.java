package com.changgou.controller;

import com.changgou.entity.Page;
import com.changgou.service.EsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/search")
public class EsSearchController {

    @Autowired
    private EsSearchService esSearchService;

    @GetMapping("/list")
    public String search(@RequestParam Map<String,String> searchMap, Model model){
        if(searchMap!=null && searchMap.size()>0){
            for(String key : searchMap.keySet()){
                if(key.startsWith("spec_")){
                    String val = searchMap.get(key);
                    val = val.replace("+", "%2B");
                    searchMap.put(key,val );
                }
            }
        }


        Map result = esSearchService.search(searchMap);
        model.addAttribute("result", result); //将搜索结果集和筛选条件集合添加到模型中
        model.addAttribute("searchMap", searchMap); //将请求的参数回显到模型中

        Long total = Long.valueOf(String.valueOf(result.get("total")));
        Integer pageNum = Integer.valueOf(String.valueOf(result.get("pageNum")));
        Page page = new Page(total, pageNum, Page.pageSize);
        model.addAttribute("page", page); //将分页对象存放到模型中

        //URL的回显
        StringBuilder url = new StringBuilder();
        url.append("/search/list");
        // http://localhost:900/search/list?keywords=手机&brand=华为
        if(searchMap!=null && searchMap.size()>0){
            url.append("?");
            int flag = 0;
            for(String key : searchMap.keySet()){

                //当页面搜索条件参数名是排序及分页页码时，不参与URL的拼接回显
                if(!key.equals("sortField")&&!key.equals("sortRule")&&!key.equals("pageNum")){
                    if(flag!=0){
                        url.append("&");
                    }
                    url.append( key +"=" + searchMap.get(key));
                    flag ++;
                }

            }
        }
        model.addAttribute("url", url);

        return "search";
    }
}
