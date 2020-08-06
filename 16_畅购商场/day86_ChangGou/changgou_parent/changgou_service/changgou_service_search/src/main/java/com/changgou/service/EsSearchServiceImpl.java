package com.changgou.service;

import com.alibaba.fastjson.JSON;
import com.changgou.pojo.SkuInfo;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EsSearchServiceImpl implements EsSearchService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Override
    public Map search(Map<String, String> searchMap) {
        Map result = new HashMap();
        if(searchMap==null){
            return result;
        }

        //构建综合搜索条件类，可以进行模糊搜索、精确搜索、范围搜索
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        if(StringUtils.isNotEmpty(searchMap.get("keywords"))){
            //需求1：根据搜索关键词在商品搜索页面的搜索框进行搜索， 类似于 mysql的select * from tb_sku where name like '%搜索关键词的分词%'
            boolQueryBuilder.must(QueryBuilders.matchQuery("name", searchMap.get("keywords")).operator(Operator.AND));//must相当于and， should相当于or， not相当于not
        }

        //需求5：根据品牌名称进行精确搜索，类似于mysql的select * from tb_sku where brand_name='品牌名称'
        if(StringUtils.isNotEmpty(searchMap.get("brand"))){
            boolQueryBuilder.filter(QueryBuilders.termQuery("brandName", searchMap.get("brand")));
        }

        //需求6：根据分类名称进行精确搜索，类似于mysql的select * from tb_sku where category_name='分类名称'
        if(StringUtils.isNotEmpty(searchMap.get("categoryName"))){
            boolQueryBuilder.filter(QueryBuilders.termQuery("categoryName", searchMap.get("categoryName")));
        }

        //需求7：根据规格进行精确搜索，类似于mysql的select * from tb_sku where spec_color='颜色名'
        for(String key : searchMap.keySet()){
            if(key.startsWith("spec_")){
                String specMapKey = key.substring(5);
                String specMapValue = searchMap.get(key);
                specMapValue = specMapValue.replace("%2B","+" );
                boolQueryBuilder.filter(QueryBuilders.termQuery("specMap."+specMapKey+".keyword", specMapValue));
            }
        }

        //需求8：根据价格进行范围搜索，类似于myqsl的select * from tb_sku where price between 100 and 200
        if(StringUtils.isNotEmpty(searchMap.get("price"))){
            String price = searchMap.get("price");
            String[] split = price.split("-");
            if(split.length==2){
                String lowPirce = split[0]; //获取最小价格
                String highPrice = split[1]; //获取最大价格
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(lowPirce).lte(highPrice));
            }
        }

        //构建顶级查询对象
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);

        //需求2.1：根据品牌进行分组, 设置分组。 类似于mysql的select brand_name from tb_sku group by brand_name
        String brandGroup = "brandGroup";
        TermsAggregationBuilder brandGroupBuilder = AggregationBuilders.terms(brandGroup).field("brandName");
        nativeSearchQueryBuilder.addAggregation(brandGroupBuilder);

        //需求3.1：根据分类名称进行分组，设置分组。类似于mysql的select category_name from tb_sku group byu category_name
        String cateGroup = "cateGroup";
        TermsAggregationBuilder cateGroupBuilder = AggregationBuilders.terms(cateGroup).field("categoryName");
        nativeSearchQueryBuilder.addAggregation(cateGroupBuilder);
        
        //需求4.1：根据规格进行分组，设置分组。类似于mysql的select spec from tb_sku group by spec
        String specGroup = "specGroup";
        TermsAggregationBuilder specGroupBuilder = AggregationBuilders.terms(specGroup).field("spec.keyword");
        nativeSearchQueryBuilder.addAggregation(specGroupBuilder);

        //需求9：搜索结果进行分页，类似于mysql的select * from tb_sku limit 10,20
        int pageNum = 1;
        int pageSize = 20;
        if(StringUtils.isNotEmpty(searchMap.get("pageNum"))){
            pageNum = Integer.valueOf(searchMap.get("pageNum"));
        }
        if(StringUtils.isNotEmpty(searchMap.get("pageSize"))){
            pageSize = Integer.valueOf(searchMap.get("pageSize"));
        }
        nativeSearchQueryBuilder.withPageable(PageRequest.of(pageNum-1, pageSize));

        //需求10：对搜索结果进行排序，类似于mysql的select * from tb_sku order by price desc|asc
        if(StringUtils.isNotEmpty(searchMap.get("sortField")) && StringUtils.isNotEmpty(searchMap.get("sortRule"))){
            String esField = searchMap.get("sortField");
            String sortRule = searchMap.get("sortRule");
            if("DESC".equalsIgnoreCase(sortRule)){
                nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort(esField).order(SortOrder.DESC));
            } else {
                nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort(esField).order(SortOrder.ASC));
            }
        }

        //需求11.1：对搜索结果的商品名称进行高亮显示， 设置高亮标签
        HighlightBuilder.Field highlightField = new HighlightBuilder.Field("name").preTags("<span style='color:red'>").postTags("</span>");
        nativeSearchQueryBuilder.withHighlightFields(highlightField);

        //执行搜索
       // List<SkuInfo> skuInfos = elasticsearchTemplate.queryForList(nativeSearchQueryBuilder.build(), SkuInfo.class);
        AggregatedPage<SkuInfo> searchResult = elasticsearchTemplate.queryForPage(nativeSearchQueryBuilder.build(), SkuInfo.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                SearchHit[] hits = searchResponse.getHits().getHits(); //搜索命中的结果集
                List<T> skuList = new ArrayList<>();
                long total = searchResponse.getHits().getTotalHits();//搜索命中的结果集的条数
                if (total > 0) {
                    for (SearchHit hit : hits) {
                        //获取搜索命中的每一条商品的JSON数据
                        String skuInfoJson = hit.getSourceAsString();
                        //将搜索商品的JSON字符串转为指定的类型
                        SkuInfo skuInfo = JSON.parseObject(skuInfoJson, SkuInfo.class);

                        //需求11.2：对搜索结果的商品名称进行高亮显示，获取高亮的名称，覆盖到原来没有高亮名称的skuinfo对象里
                        Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                        if(highlightFields!=null && highlightFields.size()>0){
                            HighlightField field = highlightFields.get("name");
                            String highlightName = field.getFragments()[0].toString();
                            skuInfo.setName(highlightName);
                        }

                        skuList.add((T) skuInfo);
                    }
                }

                return new AggregatedPageImpl<>(skuList, pageable, total, searchResponse.getAggregations());
            }
        });

        //需求2.2：根据品牌进行分组, 取品牌分组的结果
        StringTerms brandTerms = (StringTerms) searchResult.getAggregation(brandGroup);
        List<String> brandList = brandTerms.getBuckets().stream().map(bucket -> bucket.getKeyAsString()).collect(Collectors.toList());
//        List<StringTerms.Bucket> buckets = brandTerms.getBuckets();
//        List<String> brandList = new ArrayList<>();
//        if(buckets!=null && buckets.size()>0) {
//            for (StringTerms.Bucket bucket : buckets) {
//                String brandName = bucket.getKeyAsString();
//                brandList.add(brandName);
//            }
//        }

        //需求3.2：根据分类名称进行分组，取出分类的聚合结果。
        StringTerms cateTerms = (StringTerms) searchResult.getAggregation(cateGroup);
        List<String> cateList = cateTerms.getBuckets().stream().map(bucket -> bucket.getKeyAsString()).collect(Collectors.toList());
        
        //需求4.2：根据规格进行分组，取出规格的聚合结果。
        StringTerms specTerms = (StringTerms) searchResult.getAggregation(specGroup);
        List<StringTerms.Bucket> specBuckets = specTerms.getBuckets();
        Map<String, Set<String>> specMap = new HashMap<>();
        if(specBuckets!=null && specBuckets.size()>0){
            Set<String> set = null;
            for (StringTerms.Bucket specBucket : specBuckets) {
                String specJson = specBucket.getKeyAsString();
                Map<String,String> map = JSON.parseObject(specJson,Map.class);
                if(map!=null && map.size()>0){
                    for(String key : map.keySet()){
                        if(!specMap.containsKey(key)){
                            set = new HashSet<>();
                        } else {
                            set = specMap.get(key);
                        }
                        set.add(map.get(key));
                        specMap.put(key, set);
                    }
                }
            }
        }

        result.put("rows", searchResult.getContent()); //搜索结果列表，默认显示10条，除非手动指定pageSize
        result.put("total", searchResult.getTotalElements()); //搜索结果的总条数
        result.put("totalPage", searchResult.getTotalPages() ); //总页数，默认的1页，除非手动操作分页
        result.put("brandList", brandList); //品牌名称分组结果集，这个结果集返回的格式类似于['华为','中兴','苹果','小米']
        result.put("cateList", cateList);//分类名称分组结果集，这个结果集返回的格式类似于['手机','老花镜','拉杆箱']
        result.put("specList", specMap);//规格的分组结果集， 这个结果集返回的格式类似于{'颜色':['红色','黑色'],'尺码':['8寸','12寸'],'屏幕类型':['LED','非LEF']}
        result.put("pageNum",  pageNum);//当前页码
        result.put("pageSize", pageSize);//每页显示多少条
        return result;
    }
}
