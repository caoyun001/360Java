

# 今日授课目标

- 能够完成索引库的操作：新增、查询、删除
- 能够完成映射操作：配置映射，查看映射
- 能够完成文档的操作：新增、修改、删除
- 能完成请求体查询：基本查询、结果过滤、高亮查询，分页及排序

ES前置准备Lombok讲解

# 第一章 Elasticsearch集群

## 1.1 单点的问题

单台服务器，往往都有最大的负载能力，超过这个阈值，服务器性能就会大大降低甚至不可用。单点的elasticsearch也是一样，那单点的es服务器存在哪些可能出现的问题呢？

- 单台机器存储容量有限
- 单服务器容易出现单点故障，无法实现高可用
- 单服务的并发处理能力有限

所以，为了应对这些问题，我们需要对elasticsearch搭建集群

集群中节点数量没有限制，大于等于2个节点就可以看做是集群了。一般出于高性能及高可用方面来考虑集群中节点数量都是3个以上。

## 1.2 相关概念

### 1.2.1 集群 cluster

一个集群就是由一个或多个节点组织在一起，它们共同持有整个的数据，并一起提供索引和搜索功能。一个集群由一个唯一的名字标识，这个名字默认就是“Elasticsearch”。这个名字是重要的，因为一个节点只能通过指定某个集群的名字，来加入这个集群

### 1.2.2 节点 node

一个节点是集群中的一个服务，作为集群的一部分，它存储数据，参与集群的索引和搜索功能。和集群类似，一个节点也是由一个名字来标识的。这个名字对于管理工作来说挺重要的，因为在这个管理过程中，你会去确定网络中的哪些服务对应于Elasticsearch集群中的哪些节点。

一个节点可以通过配置集群名称的方式来加入一个指定的集群。默认情况下，每个节点都会被安排加入到一个叫做“Elasticsearch”的集群中，这意味着，如果你在你的网络中启动了若干个节点，并假定它们能够相互发现彼此，它们将会自动地形成并加入到一个叫做“Elasticsearch”的集群中。在一个集群里，只要你想，可以拥有任意多个节点。

### 1.2.3 分片和复制 shards&replicas(副本)

为了解决索引占用空间过大(1TB以上)这个问题，Elasticsearch提供了将索引划分成多份的能力，这些份就叫做分片。当你创建一个索引的时候，你可以指定你想要的分片的数量。

为了提高分片高可用，Elasticsearch允许创建分片的一份或多份拷贝，这些拷贝叫做复制分片，或者直接叫复制。

默认情况下，Elasticsearch中的每个索引被分片5个主分片和1个复制，这意味着，如果你的集群中至少有两个节点，你的索引将会有5个主分片和另外5个复制分片（1个完全拷贝），这样的话每个索引总共就有10个分片。

> ElasticSearch7.x之后，如果不指定索引分片，默认会创建1个分片

## 1.3 (伪)集群的搭建

### 1.3.1 准备三台Elasticsearch服务器

创建Elasticsearch-cluster文件夹，在内部复制三个Elasticsearch服务

### 1.3.2 修改每台服务器配置

修改Elasticsearch-cluster\node*\config\Elasticsearch.yml配置文件

#### node1节点：

```yaml
#节点1的配置信息：
#集群名称，保证唯一
cluster.name: my-Elasticsearch
#节点名称，必须不一样
node.name: node-1
#必须为本机的ip地址
network.host: 127.0.0.1
#服务端口号，在同一机器下必须不一样
http.port: 9201
#集群间通信端口号，在同一机器下必须不一样
transport.tcp.port: 9301
#设置集群自动发现机器ip集合
discovery.zen.ping.unicast.hosts: ["127.0.0.1:9301","127.0.0.1:9302","127.0.0.1:9303"]
```

#### node2节点：

```yaml
#节点2的配置信息：
#集群名称，保证唯一
cluster.name: my-Elasticsearch
#节点名称，必须不一样
node.name: node-2
#必须为本机的ip地址
network.host: 127.0.0.1
#服务端口号，在同一机器下必须不一样
http.port: 9202
#集群间通信端口号，在同一机器下必须不一样
transport.tcp.port: 9302
#设置集群自动发现机器ip集合
discovery.zen.ping.unicast.hosts: ["127.0.0.1:9301","127.0.0.1:9302","127.0.0.1:9303"]
```

#### node3节点：

```yaml
#节点3的配置信息：
#集群名称，保证唯一
cluster.name: my-Elasticsearch
#节点名称，必须不一样
node.name: node-3
#必须为本机的ip地址
network.host: 127.0.0.1
#服务端口号，在同一机器下必须不一样
http.port: 9203
#集群间通信端口号，在同一机器下必须不一样
transport.tcp.port: 9303
#设置集群自动发现机器ip集合
discovery.zen.ping.unicast.hosts: ["127.0.0.1:9301","127.0.0.1:9302","127.0.0.1:9303"]
```

### 1.3.3 启动各个节点服务器

双击cluster\node*\bin\Elasticsearch.bat

#### 启动节点1：

![image-20191114114927323](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191114114927323.png)

#### 启动节点2：

![image-20191114114952764](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191114114952764.png)

#### 启动节点3：

![image-20191114115022837](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191114115022837.png)

### 1.3.4 集群测试

#### 创建索引和配置映射

```json
PUT /heima2
{
    "settings":{},
    "mappings":{
        "goods":{
            "properties":{
                "title":{
                    "type":"text",
                    "analyzer":"ik_max_word"
                },
                "subtitle":{
                    "type":"text",
                    "analyzer":"ik_max_word"
                },
                "images":{
                    "type":"keyword",
                    "index":"false"
                },
                "price":{
                    "type":"float"
                }
            }
        }
    }
}
```

#### 添加文档

```json
POST /heima2/goods
{
    "title":"小米手机",
    "images":"http://image.leyou.com/12479122.jpg",
    "price":2699.00
}
```

#### 使用Elasticsearch-header查看集群情况

可以通过elasticsearch-head插件查看集群健康状态，有以下三个状态：![image-20191103013618826](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191103013618826.png)

```
green
```

所有的主分片和副本分片都已分配。你的集群是 100% 可用的。

```
yellow
```

所有的主分片已经分片了，但至少还有一个副本是缺失的。不会有数据丢失，所以搜索结果依然是完整的。不过，你的高可用性在某种程度上被弱化。如果 *更多的* 分片消失，你就会丢数据了。把 `yellow` 想象成一个需要及时调查的警告。

```
red
```

至少一个主分片（以及它的全部副本）都在缺失中。这意味着你在缺少数据：搜索只能返回部分数据，而分配到这个分片上的写入请求会返回一个异常。

# 第二章 ElasticSearch高级Rest客户端

前面章节，我们学习了大量的命令操作Elasticsearch，本章我们将详细的介绍Spirng Boot整合Elasticsearch，通过Java代码操作ElasticSearch。

![image-20191122092113324](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122092113324.png)

## 2.1 客户端开发环境搭建

Spring Boot集成Elasticsearch的时候，我们需要引入高阶客户端【elasticsearch-rest-high-level-client】【elasticsearch-rest-client】和【elasticsearch】来操作Elasticsearch，在引入起步依赖的时候，需要**严格注意**Elasticsearch和起步依赖的版本关系，否则在使用过程中会出很多问题

**搭建步骤：**

1. 创建SpringBoot的项目，勾选starter配置
2. 配置Maven依赖坐标
3. 将ElasticSearch的客户端对象，注入Spring的容器
4. 配置ElasticSearch，服务地址，端口号

**搭建过程：**

1. 创建SpringBoot的项目，勾选starter配置

   - 选黑马spring Initializr![image-20191121210620215](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191121210620215.png)
   - 配置项目信息![image-20191121210524408](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191121210524408.png)
   - 勾选starter，开发者工具、Lombok、配置文件映射处理器![image-20191121210727237](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191121210727237.png)

2. 配置Maven依赖坐标

   ```xml
   <!--elasticsearch的高级别rest客户端-->
   <dependency>
       <groupId>org.elasticsearch.client</groupId>
       <artifactId>elasticsearch-rest-high-level-client</artifactId>
       <version>6.8.0</version>
   </dependency>
   <!--elasticsearch的rest客户端-->
   <dependency>
       <groupId>org.elasticsearch.client</groupId>
       <artifactId>elasticsearch-rest-client</artifactId>
       <version>6.8.0</version>
   </dependency>
   <!--elasticsearch的核心jar包-->
   <dependency>
       <groupId>org.elasticsearch</groupId>
       <artifactId>elasticsearch</artifactId>
       <version>6.8.0</version>
   </dependency>
   ```

3. 将ElasticSearch的客户端对象，注入Spring的容器

   ```java
   @Configuration
   @ConfigurationProperties(prefix = "elasticsearch")
   @Component
   public class ElasticSearchConfig {
   
       private String host;
       private Integer port;
   
       //初始化RestHighLevelClient
       @Bean(destroyMethod = "close")
       public RestHighLevelClient client() {
           //RestClient客户端构建器对象
           RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost(host, port, "http"));
           //操作es的高级rest客户端对象
           RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restClientBuilder);
           return restHighLevelClient;
       }
   	//getter ,setter,toString..省略
   }
   ```

4. 配置ElasticSearch，服务地址，端口号

   ```properties
   # es服务地址
   elasticsearch.host=127.0.0.1
   # es服务端口
   elasticsearch.port=9200
   # 配置日志级别,开启debug日志
   logging.level.com.itheima=debug
   ```

   

## 2.2 创建索引索引库

### 1、新增索引库

目标：使用ElasticSearch的高阶客户端，编写Java代码，创建索引库

分析：

Java high level客户端的操作，是模仿我们通过发送请求调用RESTful接口调用的方式，本质还是请求获取响应。

```java
/**
 * 索引库操作：
 * 1.创建索引库
 * 2.查询索引库
 * 3.删除索引库
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo01IndexOperation {
    //注入ES客户端对象
    @Autowired
    private RestHighLevelClient client;
    /**
     * 目标：创建索引库
     * 1.创建请求对象
     *    设置索引库name
     * 2.客户端发送请求，获取响应对象
     * 3.打印响应对象中的返回结果
     * 4.关闭客户端，释放连接资源
     */
    @Test
    public void create() throws IOException {
        //1.创建请求对象，创建索引的请求
        CreateIndexRequest request = new CreateIndexRequest("heima3");
        //2.客户端发送请求，获取响应对象
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        //3.打印响应对象中的返回结果
        //返回index信息
        System.out.println("index:"+response.index());
        //acknowledged代表创建成功
        System.out.println("acknowledged:"+response.isAcknowledged());
        //4.关闭客户端，释放连接资源
        client.close();
    }
}
```

**执行结果**：

![image-20191121232203907](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191121232203907.png)

发送请求中，传入请求对象的同时还设置了一个RequestOptions对象的静态成员变量DEFAULT。其含义是，配置当前请求选项为默认值。

其中RequestOptions对象的作用是用来配置请求，主要配置项目有请求头，缓冲区大小(默认100M)，异常处理器(warningsHandler)。默认情况下，缓冲区大小100MB，请求头及异常处理器为空。

### 2、查看索引库

```java
/**
 * 查询索引
 * 1.创建请求对象：查看索引库
 *    设置索引库name
 * 2.客户端发送请求，获取响应对象
 * 3.打印响应结果
 * 4.关闭客户端，释放连接资源
 */
@Test
public void getIndex() throws IOException {
    //1.创建请求对象：查看索引库
    GetIndexRequest request = new GetIndexRequest("heima4");
    //2.客户端发送请求，获取响应对象
    GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
    //3.打印响应结果
    System.out.println("aliases: "+response.getAliases());
    System.out.println("settings: "+response.getSettings());
    System.out.println("mappings: "+response.getMappings());
    //4.关闭客户端，释放连接资源
    client.close();
}
```

**执行结果**：

![image-20191121232526055](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191121232526055.png)

### 3、删除索引库

```java
/**
 * 删除索引
 * 1.创建请求对象：删除索引库
 *    设置索引库name
 * 2.客户端发送请求，获取响应对象
 * 3.打印响应结果
 * 4.关闭客户端，释放连接资源
 */
@Test
public void delete() throws IOException {
    //1.创建请求对象：删除索引库
    DeleteIndexRequest request = new DeleteIndexRequest("heima2");
    //2.客户端发送请求，获取响应对象
    AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
    //3.打印响应结果
    System.out.println("acknowledged：："+response.isAcknowledged());
    //4.关闭客户端，释放连接资源
    client.close();
}
```

**执行结果**：![image-20191121232740488](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191121232740488.png)

## 2.3 配置映射

当配置Spring的ioc容器中的RestHighLevelClient对象的销毁执行方法之后，每次容器销毁对象时，必然会执行close方法，所以我们在使用完对象，可以不用每次手动关闭客户端。![image-20191121233944578](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191121233944578.png)

### 1、配置映射

RestHighLevelClient配置映射，与kibana略有区别。在客户端中配置映射，不支持设置类型type。不设置type，并不代表没有，而是默认的type为`_doc`。

```java
/**
 * 映射操作：
 * 1.配置映射，一共2种方式：
 *   第一种：使用XContentBuilder,构建请求体
 *   第二种：使用JSON字符串
 * 2.查看映射配置
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo02MappingOperation {
    //注入ES客户端对象
    @Autowired
    private RestHighLevelClient client;
    /**
     *目标：配置映射。第一种方式，使用XContentBuilder,构建请求体
     * 1.创建请求对象：配置映射
     *    设置索引库name
     *    设置配置映射请求体
     * 2.客户端发送请求，获取响应对象
     * 3.打印响应结果
     */
    @Test
    public void putMappingMethodOne() throws IOException {
        //1.创建请求对象：配置映射
        PutMappingRequest request = new PutMappingRequest("heima4");
        //构建请求体
        XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
        jsonBuilder.startObject()
                .startObject("properties")
                .startObject("title")
                .field("type","text").field("analyzer","ik_max_word")
                .endObject()
                .startObject("subtitle")
                .field("type","text").field("analyzer","ik_max_word")
                .endObject()
                .startObject("category")
                .field("type","keyword")
                .endObject()
                .startObject("brand")
                .field("type","keyword")
                .endObject()
                .startObject("images")
                .field("type","keyword").field("index",false)
                .endObject()
                .startObject("price")
                .field("type","float")
                .endObject()
                .endObject()
                .endObject();
        //设置请求体，source("请求体json构建器对象");
        request.source(jsonBuilder);
        //2.客户端发送请求，获取响应对象
        AcknowledgedResponse response = client.indices().putMapping(request, RequestOptions.DEFAULT);
        //3.打印响应结果
        System.out.println("acknowledged：："+response.isAcknowledged());
    }
}
```

**执行结果**：

![image-20191121235910870](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191121235910870.png)

<img src="11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122000230971.png" alt="image-20191122000230971" style="zoom: 25%;" />

第二种方式：

```java
/**
 *目标：配置映射。第二种方式，使用JSON字符串
 * 1.创建请求对象：配置映射
 *    设置索引库name
 *    设置配置映射请求体
 * 2.客户端发送请求，获取响应对象
 * 3.打印响应结果
 */
@Test
public void putMappingMethodTwo() throws IOException {
    //1.创建请求对象：配置映射
    PutMappingRequest request = new PutMappingRequest("heima5");
    //设置请求体，source("请求体json字符串"，"请求体的数据类型");
    request.source("{\"properties\":{\"title\":{\"type\":\"text\",\"analyzer\":\"ik_max_word\"},\"subtitle\":{\"type\":\"text\",\"analyzer\":\"ik_max_word\"},\"category\":{\"type\":\"keyword\"},\"brand\":{\"type\":\"keyword\"},\"price\":{\"type\":\"float\"},\"images\":{\"type\":\"keyword\",\"index\":false}}}", XContentType.JSON);
    //2.客户端发送请求，获取响应对象
    AcknowledgedResponse response = client.indices().putMapping(request, RequestOptions.DEFAULT);
    //3.打印响应结果
    System.out.println("acknowledged::"+response.isAcknowledged());
}
```

**执行结果**：

![image-20191122000946110](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122000946110.png)

### 2、查看映射

```java
/**
 * 查看映射
 * 1.创建请求对象：查看映射
 *    设置索引库name
 * 2.客户端发送请求，获取响应对象
 * 3.打印响应结果
 */
@Test
public void getMapping() throws IOException {
    //1.创建请求对象：查看映射
    GetMappingsRequest request = new GetMappingsRequest();
    //设置索引库name
    request.indices("heima4");
    //2.客户端发送请求，获取响应对象
    GetMappingsResponse response = client.indices().getMapping(request, RequestOptions.DEFAULT);
    //3.打印响应结果
    System.out.println("mappings::"+response.mappings());
   System.out.println("Source::"+response.mappings().get("heima4").getSourceAsMap());
}
```

**执行结果**：![image-20191122002009460](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122002009460.png)

## 2.4 文档操作

### 1、创建文档

创建实体：

```java
public class Goods {
    private Long id;//商品的唯一标识
    private String title;//标题
    private String subtitle;//子标题
    private String category;//分类
    private String brand;//品牌
    private Double price;//价格
    private String images;//图片地址
    //...getter , setter , toString
}
```

创建操作代码：

```java

/**
 * 文档操作：
 * 1.新增文档
 * 2.根据id查询文档
 * 3.修改文档
 * 4.删除文档
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo03DocumentOperation {
    //注入ES客户端对象
    @Autowired
    private RestHighLevelClient client;
    /**
     * 目标：新增文档
     * 1.创建请求对象：新增文档
     *    设置索引库name
     *    设置类型type
     *    设置主键id，不设置随机生成
     *    设置请求体
     * 2.客户端发送请求，获取响应对象
     * 3.打印响应结果
     */
    @Test
    public void createDoc() throws IOException {
        //1.创建请求对象：新增文档
        IndexRequest request = new IndexRequest();
        //设置索引库名称
        request.index("heima4");
        //设置type类型
        request.type("_doc");
        //设置主键id
        request.id("1");
        //构造Goods对象
        Goods good = new Goods(1l,"小米手机","小米","手机","小米",19999.0,"http://image.leyou.com/12479122.jpg");
        //对象转json
        String goodJsonStr = new ObjectMapper().writeValueAsString(good);
        //设置请求体.source("json请求字符串","请求体的数据类型");
        request.source(goodJsonStr,XContentType.JSON);
        //2.客户端发送请求，获取响应对象
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        //3.打印响应结果
        System.out.println("_index：："+response.getIndex());
        System.out.println("_type：："+response.getType());
        System.out.println("_id：："+response.getId());
        System.out.println("result：："+response.getResult());
    }
}
```

**执行结果**：

![image-20191122003719214](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122003719214.png)

**不设置主键ID：**

![image-20191122003857430](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122003857430.png)

### 2、修改文档

主键id相同，修改数据

```java
/**
 * 修改文档
 * 1.创建请求对象：修改文档
 *    设置索引库name
 *    设置类型type
 *    设置主键id，必须设置
 *    设置请求体
 * 2.客户端发送请求，获取响应对象
 * 3.打印响应结果
 */
@Test
public void updateDoc() throws IOException {
    //1.创建请求对象：修改文档
    UpdateRequest request = new UpdateRequest();
    //设置索引库名称
    request.index("heima4");
    //设置type类型
    request.type("_doc");
    //设置主键id
    request.id("1");
    //构造Goods对象
    Goods good = new Goods(1l,"大米手机"，"炒米","手机","小米",999.0,"http://image.leyou.com/12479122.jpg");
    //对象转json
    String goodJsonStr = new ObjectMapper().writeValueAsString(good);
    //设置请求体.source("json请求字符串","请求体的数据类型");
    request.doc(goodJsonStr,XContentType.JSON);
    //2.客户端发送请求，获取响应对象
    UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
    //3.打印响应结果
    System.out.println("_index：："+response.getIndex());
    System.out.println("_type：："+response.getType());
    System.out.println("_id：："+response.getId());
    System.out.println("result：："+response.getResult());
}
```

**执行结果**：

![image-20191122004144925](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122004144925.png)

### 3、根据id查询文档

```java
/**
 * 根据id查询文档
 * 1.创建请求对象：根据id查询文档
 *    设置索引库name
 *    设置类型type
 *    设置主键id
 * 2.客户端发送请求，获取响应对象
 * 3.打印响应结果
 */
@Test
public void getDoc() throws IOException {
    //1.创建请求对象：根据id查询文档
    GetRequest request = new GetRequest();
    //设置索引库name
    request.index("heima4");
    //设置类型type
    request.type("_doc");
    //设置主键id
    request.id("1");
    //2.客户端发送请求，获取响应对象
    GetResponse response = client.get(request, RequestOptions.DEFAULT);
    //3.打印响应结果
    //3.打印响应结果
    System.out.println("_index：："+response.getIndex());
    System.out.println("_type：："+response.getType());
    System.out.println("_id：："+response.getId());
    System.out.println("_source：："+response.getSourceAsString());
}
```

**执行结果**：

![image-20191122004701800](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122004701800.png)

### 4、删除文档

```java
/**
 * 删除文档
 * 1.创建请求对象：删除文档
 *    设置索引库name
 *    设置类型type
 *    设置主键id
 * 2.客户端发送请求，获取响应对象
 * 3.打印响应结果
 */
@Test
public void deleteDoc() throws IOException {
    //1.创建请求对象：删除文档
    DeleteRequest request = new DeleteRequest();
    request.index("heima4");
    request.id("1");
    request.type("_doc");
    //2.客户端发送请求，获取响应对象
    DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
    //3.打印响应结果
    System.out.println("_index：："+response.getIndex());
    System.out.println("_type：："+response.getType());
    System.out.println("_id：："+response.getId());
    System.out.println("_result：："+response.getResult());
}
```

**执行结果**：

![image-20191122004929567](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122004929567.png)

### 5、批量操作bulk

```java
/**
 * 批量操作
 * 1.批量新增
 * 2.批量删除
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo04BulkOperation {
    //注入ES客户端对象
    @Autowired
    private RestHighLevelClient client;
    /**
     * 目标：批量新增
     * 1.创建请求对象：批量操作
     * 2.批量操作中设置多个新增对象IndexRequest
     * 3.客户端发送请求，获取响应对象
     * 4.打印响应结果
     */
    @Test
    public void createDoc() throws IOException {
        //1.创建请求对象：批量操作
        BulkRequest request = new BulkRequest();
        //2.批量操作中设置多个新增对象IndexRequest
        IndexRequest addRequestOne = new IndexRequest().id("1").type("_doc").index("heima3").source(XContentType.JSON,"id",1L,"title","大米手机","category","手机","brand","小米","price","2699.00","images","http://baidu.com");
        request.add(addRequestOne);
        IndexRequest addRequestTwo = new IndexRequest().id("2").type("_doc").index("heima3").source(XContentType.JSON,"id",2L,"title","大米手机","category","手机","brand","小米","price","2699.00","images","http://baidu.com");
        request.add(addRequestTwo);
        //3.客户端发送请求，获取响应对象
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        //4.打印响应结果
        System.out.println("took::"+response.getTook());
        System.out.println("Items::"+response.getItems());
    }
    /**
     * 目标：批量删除
     * 1.创建请求对象：批量删除
     * 2.批量操作中设置多个删除对象DeleteRequest
     * 3.客户端发送请求，获取响应对象
     * 4.打印响应结果
     */
    @Test
    public void bulkDelete() throws IOException {
        //1.创建请求对象：批量删除
        BulkRequest request = new BulkRequest();
        //2.批量操作中设置多个删除对象DeleteRequest
        request.add(new DeleteRequest().id("1").type("_doc").index("heima3"));
        request.add(new DeleteRequest().id("2").type("_doc").index("heima3"));
        //3.客户端发送请求，获取响应对象
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        //4.打印响应结果
        System.out.println("took::"+response.getTook());
        System.out.println("Items::"+response.getItems());
    }
}

```

**执行结果**：

![image-20191122012009894](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122012009894.png)

# 第三章 高级Rest客户端-请求体查询

## 模拟数据

```java
/**
 * 初始化查询数据
 */
@Test
public void initData() throws IOException {
    //批量新增操作
    BulkRequest request = new BulkRequest();
    request.add(new IndexRequest().type("_doc").index("heima3").source(XContentType.JSON,"title","大米手机","images","http://image.leyou.com/12479122.jpg","price",3288,"category","手机","brand","小米"));
    request.add(new IndexRequest().type("_doc").index("heima3").source(XContentType.JSON,"title","小米手机","images","http://image.leyou.com/12479122.jpg","price",2699,"category","手机","brand","小米"));
    request.add(new IndexRequest().type("_doc").index("heima3").source(XContentType.JSON,"title","小米电视4A","images","http://image.leyou.com/12479122.jpg","price",4288,"category","手机","brand","小米"));
    request.add(new IndexRequest().type("_doc").index("heima3").source(XContentType.JSON,"title","华为手机","images", "http://image.leyou.com/12479122.jpg","price", 5288,"subtitle", "小米","category","手机","brand","小米"));
    request.add(new IndexRequest().type("_doc").index("heima3").source(XContentType.JSON,"title","apple手机","images","http://image.leyou.com/12479122.jpg","price",5899.00,"category","手机","brand","小米"));
    BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
    System.out.println("took::"+response.getTook());
    System.out.println("Items::"+response.getItems());
}
```

## 3.1 基本查询

### 1、匹配查询(matchAll)

```java
/**
 * 请求体查询-基本查询
 * 1.查询所有
 * 2.match查询，带分词器的查询
 * 3.multi_match查询，查询多个字段
 * 4.term查询，关键词精确匹配
 * 5.terms查询，多个关键词精确匹配
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05RequestBodyQuery_Basic {
    //注入ES客户端对象
    @Autowired
    private RestHighLevelClient client;

    /**
     * 查询所有
     * 1.创建请求对象：查询所有
     *    设置索引库name
     *    设置类型type
     * 2.创建查询请求体构建器
     *    设置请求体
     * 3.客户端发送请求，获取响应对象
     * 4.打印响应结果
     */
    @Test
    public void matchAllQuery() throws IOException {
        //1.创建请求对象：查询所有
        SearchRequest request = new SearchRequest();
        request.types("_doc");
        request.indices("heima4");
        //2.创建查询请求体构建器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置查询方式：matchAll
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        //设置请求体
        request.source(sourceBuilder);
        //3.客户端发送请求，获取响应对象
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.打印响应结果
        SearchHits hits = response.getHits();
        System.out.println("took::"+response.getTook());
        System.out.println("time_out::"+response.isTimedOut());
        System.out.println("total::"+hits.getTotalHits());
        System.out.println("max_score::"+hits.getMaxScore());
        System.out.println("hits::::>>");
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);
        }
        System.out.println("<<::::");
    }  
}
```

**执行结果**：

![image-20191122013303768](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122013303768.png)

### 2、匹配查询(match)

```java
/**
 * 匹配查询，带分词器的查询
 * 分词后关键词之间的关系，or(默认)，and
 * 1.创建请求对象：匹配查询
 *    设置索引库name
 *    设置类型type
 * 2.创建查询请求体构建器
 *    设置请求体
 * 3.客户端发送请求，获取响应对象
 * 4.打印响应结果
 */
@Test
public void matchQuery() throws IOException {
    //1.创建请求对象：匹配查询
    SearchRequest request = new SearchRequest();
    request.types("_doc");
    request.indices("heima4");
    //2.创建查询请求体构建器
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //匹配查询，设置分词后关键词的查询关系，默认是or
    MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "小米手机")
            .operator(Operator.AND);
    sourceBuilder.query(matchQueryBuilder);
    //设置请求体
    request.source(sourceBuilder);
    //3.客户端发送请求，获取响应对象
    SearchResponse response = client.search(request, RequestOptions.DEFAULT);
    //4.打印响应结果
    printResult(response);
}
//打印结果信息
public void printResult(SearchResponse response) {
    SearchHits hits = response.getHits();
    System.out.println("took::"+response.getTook());
    System.out.println("time_out::"+response.isTimedOut());
    System.out.println("total::"+hits.getTotalHits());
    System.out.println("max_score::"+hits.getMaxScore());
    System.out.println("hits::::>>");
    for (SearchHit hit : hits) {
        String sourceAsString = hit.getSourceAsString();
        System.out.println(sourceAsString);
    }
    System.out.println("<<::::");
}
```

**执行结果**：

### 3、匹配查询(multi_match)

```java
/**
 * 多字段匹配查询，查询title和subtitle
 * 1.创建请求对象：多字段匹配查询
 *    设置索引库name
 *    设置类型type
 * 2.创建查询请求体构建器
 *    设置请求体
 * 3.客户端发送请求，获取响应对象
 * 4.打印响应结果
 */
@Test
public void mulitMatchQuery() throws IOException {
    //1.创建请求对象
    SearchRequest request = new SearchRequest();
    request.types("_doc");
    request.indices("heima4");
    //2.创建查询请求体构建器
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //设置查询方式：多字段匹配查询
    MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("小米", "title", "subtitle");
    sourceBuilder.query(multiMatchQueryBuilder);
    //设置请求体
    request.source(sourceBuilder);
    //3.客户端发送请求，获取响应对象
    SearchResponse response = client.search(request, RequestOptions.DEFAULT);
    //4.打印响应结果
    printResult(response);
}
```

**执行结果**：

![image-20191122013946092](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122013946092.png)

### 4、关键词精确匹配查询(term)

```java
/**
 * 关键词精确查询
 * 1.创建请求对象：关键词精确查询
 *    设置索引库name
 *    设置类型type
 * 2.创建查询请求体构建器
 *    设置请求体
 * 3.客户端发送请求，获取响应对象
 * 4.打印响应结果
 */
@Test
public void termQuery() throws IOException {
    //1.创建请求对象
    SearchRequest request = new SearchRequest();
    request.types("_doc");
    request.indices("heima4");
    //2.创建查询请求体构建器
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //设置查询方式：关键词精确查询
    sourceBuilder.query(QueryBuilders.termQuery("title", "小米"));
    //设置请求体
    request.source(sourceBuilder);
    //3.客户端发送请求，获取响应对象
    SearchResponse response = client.search(request, RequestOptions.DEFAULT);
    //4.打印响应结果
    printResult(response);
}
```

**执行结果**：

![image-20191122014719332](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122014719332.png)

### 5、多关键词精确匹配查询(terms)

```java
/**
 * 多关键词精确查询
 * 1.创建请求对象：多关键词精确查询
 *    设置索引库name
 *    设置类型type
 * 2.创建查询请求体构建器
 *    设置请求体
 * 3.客户端发送请求，获取响应对象
 * 4.打印响应结果
 */
@Test
public void termsQuery() throws IOException {
    //1.创建请求对象
    SearchRequest request = new SearchRequest();
    request.types("_doc");
    request.indices("heima4");
    //2.创建查询请求体构建器
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //设置查询方式：多关键词精确查询
    sourceBuilder.query( QueryBuilders.termsQuery("title", "手机", "小米"));
    //设置请求体
    request.source(sourceBuilder);
    //3.客户端发送请求，获取响应对象
    SearchResponse response = client.search(request, RequestOptions.DEFAULT);
    //4.打印响应结果
    printResult(response);
}
```

**执行结果**：

![image-20191122014933746](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122014933746.png)

## 3.2 结果过滤，排序，分页

```java
/**
 * 请求体查询-查询结果排除，分页，排序
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo06RequestBodyQuery_includes {
    //注入ES客户端对象
    @Autowired
    private RestHighLevelClient client;

    /**
     * 查询结果的排除
     * 1.创建请求对象：查询所有
     *    设置索引库name
     *    设置类型type
     * 2.创建查询请求体构建器
     *    设置请求体
     * 3.客户端发送请求，获取响应对象
     * 4.打印响应结果
     */
    @Test
    public void includesSources() throws IOException {
        //1.创建请求对象
        SearchRequest request = new SearchRequest();
        request.types("_doc");
        request.indices("heima4");
        //2.创建查询请求体构建器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置查询方式
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        //设置过滤条件，包含和排除
        String[] includes = {"title","price","images"};
        String[] excludes = {"images"};
        sourceBuilder.fetchSource(includes,excludes);
        //设置排序
        FieldSortBuilder sortBuilder = SortBuilders.fieldSort("price");
        //设置排序降序
        sortBuilder.order(SortOrder.DESC);
        sourceBuilder.sort(sortBuilder);
        //设置分页
        sourceBuilder.from(0);//当前页起始索引
        sourceBuilder.size(5);//每页显示多少条
        //设置请求体
        request.source(sourceBuilder);
        //3.客户端发送请求，获取响应对象
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.打印响应结果
        printResult(response);
    }
    public void printResult(SearchResponse response) {
        SearchHits hits = response.getHits();
        System.out.println("took::"+response.getTook());
        System.out.println("time_out::"+response.isTimedOut());
        System.out.println("total::"+hits.getTotalHits());
        System.out.println("max_score::"+hits.getMaxScore());
        System.out.println("hits::::>>");
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);
        }
        System.out.println("<<::::");
    }
}
```

**执行结果**：

![image-20191122015832308](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122015832308.png)

## 3.3 高级查询

### 1、布尔查询(bool)

目标：查询title中必须包含小米，一定不含有电视，应该含有手机的所有商品

```java
/**
 * 请求体查询-高级别查询
 * 1.布尔查询
 * 2.范围查询
 * 3.模糊查询
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo07QueryHighLevel {
    //注入ES客户端对象
    @Autowired
    private RestHighLevelClient client;
    /**
     * 目标：布尔查询，多条件组合查询
     * 1.创建请求对象：查询所有
     *    设置索引库name
     *    设置类型type
     * 2.创建查询请求体构建器
     *    设置请求体
     * 3.客户端发送请求，获取响应对象
     * 4.打印响应结果
     */
    @Test
    public void boolQuery() throws IOException {
        //1.创建请求对象
        SearchRequest request = new SearchRequest();
        request.types("_doc");
        request.indices("heima4");
        //2.创建查询请求体构建器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //构建查询方式：布尔查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //必须包含小米
        boolQueryBuilder.must(QueryBuilders.matchQuery("title","小米"));
        //必须不含电视
        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("title","电视"));
        //应该含有手机
        boolQueryBuilder.should(QueryBuilders.matchQuery("title","手机"));
        //设置查询方式
        sourceBuilder.query(boolQueryBuilder);
        //设置请求体
        request.source(sourceBuilder);
        //3.客户端发送请求，获取响应对象
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //4.打印响应结果
        printResult(response);
    }
}
```

**执行结果**：

![image-20191122094929544](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122094929544.png)

### 2、范围查询(range)

目标：查询价格大于2千，小于4千的所有商品

```java
/**
 * 范围查询
 * 1.创建请求对象：范围查询
 *    设置索引库name
 *    设置类型type
 * 2.创建查询请求体构建器
 *    设置请求体
 * 3.客户端发送请求，获取响应对象
 * 4.打印响应结果
 */
@Test
public void rangeQuery() throws IOException {
    //1.创建请求对象
    SearchRequest request = new SearchRequest();
    request.types("_doc");
    request.indices("heima4");
    //2.创建查询请求体构建器
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //构建查询方式：范围查询
    RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price");
    //大于2千
    rangeQueryBuilder.gt(2000);
    //小于4千
    rangeQueryBuilder.lt(4000);
    //设置查询方式
    sourceBuilder.query(rangeQueryBuilder);
    //设置请求体
    request.source(sourceBuilder);
    //3.客户端发送请求，获取响应对象
    SearchResponse response = client.search(request, RequestOptions.DEFAULT);
    //4.打印响应结果
    printResult(response);
}
```

**执行结果**：

![image-20191122095920085](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122095920085.png)

### 3、模糊查询(fuzzy)

```java
/**
 * 模糊查询，查询包含apple关键词的所有商品，完成模糊查询appla
 * 1.创建请求对象：模糊查询
 *    设置索引库name
 *    设置类型type
 * 2.创建查询请求体构建器
 *    设置请求体
 * 3.客户端发送请求，获取响应对象
 * 4.打印响应结果
 */
@Test
public void fuzzyQuery() throws IOException {
    //1.创建请求对象
    SearchRequest request = new SearchRequest().types("_doc").indices("heima4");
    //2.创建查询请求体构建器
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    //构建查询方式：模糊查询
    FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("title", "appla");
    //设置偏差值
    fuzzyQueryBuilder.fuzziness(Fuzziness.ONE);
    //设置查询方式
    sourceBuilder.query(fuzzyQueryBuilder);
    //设置请求体
    request.source(sourceBuilder);
    //3.客户端发送请求，获取响应对象
    SearchResponse response = client.search(request, RequestOptions.DEFAULT);
    //4.打印响应结果
    printResult(response);
}
```

**执行结果**：

![image-20191122100748821](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122100748821.png)

## 3.4 高亮查询(Highlighter)

```java
/**
 * 请求体查询-高亮查询
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo08HighLighterQuery {
    //注入ES客户端对象
    @Autowired
    private RestHighLevelClient client;
    /**
     * 高亮查询，对查询关键词进行高亮
     * 1.创建请求对象：高亮查询
     *    设置索引库name
     *    设置类型type
     * 2.创建查询请求体构建器
     *    设置请求体
     * 3.客户端发送请求，获取响应对象
     * 4.打印响应结果
     */
    @Test
    public void highLighterQuery() throws IOException {
        //1.创建请求对象
        SearchRequest request = new SearchRequest().types("_doc").indices("heima4");
        //2.创建查询请求体构建器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //构建查询方式：高亮查询
        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("title", "小米");
        //设置查询方式
        sourceBuilder.query(termsQueryBuilder);
        //构建高亮字段
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");//设置标签前缀
        highlightBuilder.postTags("</font>");//设置标签后缀
        highlightBuilder.field("title");//设置高亮字段
        //设置高亮构建对象
        sourceBuilder.highlighter(highlightBuilder);
        //设置请求体
        request.source(sourceBuilder);
        //3.客户端发送请求，获取响应对象
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        //4.打印响应结果
        SearchHits hits = response.getHits();
        System.out.println("took::"+response.getTook());
        System.out.println("time_out::"+response.isTimedOut());
        System.out.println("total::"+hits.getTotalHits());
        System.out.println("max_score::"+hits.getMaxScore());
        System.out.println("hits::::>>");
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);
            //打印高亮结果
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            System.out.println(highlightFields);
        }
        System.out.println("<<::::");
    }
}
```

**执行结果**：

![image-20191122101256579](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122101256579.png)

# 第四章 Spring Data ElasticSearch 使用

## 4.1 Spring Data ElasticSearch简介

### 4.1.1 什么是Spring Data

Spring Data是一个用于==简化持久层数据访问==的开源框架。其**主要目标是使得对数据的访问变得方便快捷**。 Spring Data可以极大的简化数据操作的写法，可以在几乎不用写实现的情况下，实现对数据的访问和操作。包括CRUD外，还包括如分页、排序等一些常用的功能，几乎可以节省持久层代码80%以上的编码工作量。

Spring Data的官网：http://projects.spring.io/spring-data/

Spring Data常用的功能模块如下：

<img src="11-ElasticSearch%25E7%25AC%25AC%25E4%25BA%258C%25E5%25A4%25A9.assets/image-20191104052346521.png" alt="image-20191104052346521" style="zoom:50%;" />

### 4.1.2 什么是Spring Data ElasticSearch

Spring Data ElasticSearch 基于 spring data API 简化 elasticSearch操作，将原始操作elasticSearch的客户端API 进行封装 。Spring Data为Elasticsearch项目提供集成搜索引擎。Spring Data Elasticsearch POJO的关键功能区域为中心的模型与Elastichsearch交互文档和轻松地编写一个存储库数据访问层。

官方网站：<http://projects.spring.io/spring-data-elasticsearch/> 

![image-20191122091942717](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191122091942717.png)

> 用来操作ElasticSearch的框架，使得开发更加便捷

## 4.2 环境搭建

### **实现步骤：**

1. 创建SpringBoot的项目
2. 勾选starter依赖坐标
3. 编写持久层接口GoodDao，编写pojo实体类
4. 配置文件，集群配置，ElasticSearch服务地址http://127.0.0.1:9300

### 实现过程：

1. 创建SpringBoot的项目![image-20191104044237968](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191104044237968-1574385402816.png)

2. 勾选starter依赖坐标![image-20191104044402055](11-ElasticSearch%E7%AC%AC%E4%BA%8C%E5%A4%A9.assets/image-20191104044402055-1574385402816.png)

3. 编写持久层接口GoodDao，编写pojo实体类

   ```java
   public interface GoodDao {
   }
   ```

   pojo实体类，商品good

   ```java
   public class Good {
       private Long id;//商品的唯一标识
       private String title;//标题
       private String category;//分类
       private String brand;//品牌
       private Double price;//价格
       private String images;//图片地址
   	//getter，setter，toString
   }
   ```

   

4. 配置文件，集群配置，ElasticSearch服务地址http://127.0.0.1:9300

   ```properties
   # 配置集群名称
   spring.data.elasticsearch.cluster-name=elasticsearch
   # 配置es的服务地址
   spring.data.elasticsearch.cluster-nodes=127.0.0.1:9300
   ```


## 4.3 常用操作

### 1、创建索引库操作

几个用到的注解：

- @Document：声明索引库配置
  - indexName：索引库名称
  - type：类型名称，默认是“docs”
  - shards：分片数量，默认5
  - replicas：副本数量，默认1
- @Id：声明实体类的id
- @Field：声明字段属性
  - type：字段的数据类型 
  - analyzer：指定分词器类型
  - index：是否创建索引 默认为true
  - store:是否存储 默认为false

实体类配置：

```java
/**
 * 商品实体类
 * @Document() 注解作用：定义一个索引库，一个类型
 * indexName属性：指定索引库的名称
 * type属性：指定类型名称
 * shards属性：指定分片数
 * replicas属性：指定复制副本数
 */
@Document(indexName = "heima4",type = "goods",shards = 5,replicas = 1)
public class Good {
    //必须有id,这里的id是全局唯一的标识,等同于es中的“_id”
    @Id
    private Long id;
    /**
     * type: 字段数据类型
     * analyzer: 分词器类型
     * index: 是否索引(默认值：true)
     * store: 是否存储(默认值：false)
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;//标题
    @Field(type = FieldType.Keyword)
    private String category;//分类
    @Field(type = FieldType.Keyword)
    private String brand;//品牌
    @Field(type = FieldType.Double)
    private Double price;//价格
    @Field(type = FieldType.Keyword,index = false)
    private String images;//图片地址
	//getter ,setter ,toString
}
```



测试类：

```java
/**
 * 目标：完成创建索引，配置映射
 * 1.注入ElasticSearchTemplate对象
 * 2.配置Good实体类
 * 3.调用创建索引的方法createIndex()
 *   调用配置映射的方法PutMapping()
 *   测试删除索引方法deleteIndex()
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataEsIndex {

    //注入ElasticSearchTemplate模板对象
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    //创建索引，配置映射
    @Test
    public void createIndexAndPutMapping() {
        //创建索引
        boolean indexResult = elasticsearchTemplate.createIndex(Good.class);
        System.out.println("创建索引结果："+indexResult);
        //创建配置映射
        elasticsearchTemplate.putMapping(Good.class);
        System.out.println("配置映射结果："+indexResult);
    }
    //删除索引
    @Test
    public void deleteIndex(){
        elasticsearchTemplate.deleteIndex(Good.class);
    }
}
```



### 2、文档的常见增删改查

继承ElasticsearchRespository模板接口

```java
/**
 *  继承持久层接口的ElasticSearch的模板接口
 */
public interface GoodDao extends ElasticsearchRepository<Good,Long> {
    
}
```



测试类代码：

```java
/**
 * 目标：完成基本的增删改查操作
 * 新增、修改、删除、根据id查询、查询所有、分页查询
 * 步骤：
 * 1.dao层接口继承ElasticSearchRepository的模板接口
 * 2.编写业务层的所有方法
 * 3.测试所有方法
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataEsGoodCRUD {

    //注入Good业务层实现类
    @Autowired
    private GoodDao goodDao;
    /**
     * 新增
     */
    @Test
    public void save(){
        Good good = new Good();
        good.setId(1l);
        good.setTitle("小米手机");
        good.setCategory("手机");
        good.setBrand("小米");
        good.setPrice(19999.0);
        good.setImages("http://image.leyou.com/12479122.jpg");
        goodDao.save(good);
    }
    //修改
    @Test
    public void update(){
        Good good = new Good();
        good.setId(1l);
        good.setTitle("小米手机");
        good.setCategory("手机");
        good.setBrand("小米");
        good.setPrice(9999.0);
        good.setImages("http://image.leyou.com/12479122.jpg");
        goodDao.save(good);
    }
    //删除
    @Test
    public void delete(){
        Good good = new Good();
        good.setId(1l);
        goodDao.delete(good);
    }
    //根据id查询
    @Test
    public void findById(){
        Good good = goodDao.findById(2l).get();
        System.out.println(good);
    }
    //查询所有
    @Test
    public void findAll(){
        Iterable<Good> goods = goodDao.findAll();
        for (Good good : goods) {
            System.out.println(good);
        }
    }
    //批量新增
    @Test
    public void saveAll(){
        List<Good> goodList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Good good = new Good();
            good.setId((long) i);
            good.setTitle("["+i+"]小米手机");
            good.setCategory("手机");
            good.setBrand("小米");
            good.setPrice(19999.0+i);
            good.setImages("http://image.leyou.com/12479122.jpg");
            goodList.add(good);
        }
        goodDao.saveAll(goodList);
    }
    //分页查询
    @Test
    public void findByPageable(){
        //设置排序(排序方式，正序还是倒序，排序的id)
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        int currentPage=2;//当前页
        int pageSize = 100;//每页显示多少条
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize,sort);
        //分页查询
        Page<Good> goodPage = goodDao.findAll(pageRequest);
        for (Good good : goodPage.getContent()) {
            System.out.println(good);
        }
    }
}
```

### 3、Search查询

ElasticSearch的search方法中QueryBuilders，就是第一章中的查询对象构建对象QueryBuilders。QueryBuilders具备的能力，search方法都具备。所以，在这里重复内容不赘述，仅举例term查询。

```java
/**
 * 目标：搜索
 * term查询、match查询，match_all查询...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataEsSearch {

    //注入Good业务层实现类
    @Autowired
    private GoodDao goodDao;

    /**
     * term查询
     * search(termQueryBuilder) 调用搜索方法，参数查询构建器对象
     */
    @Test
    public void termQuery(){
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小米");
        Iterable<Good> goods = goodDao.search(termQueryBuilder);
        for (Good g : goods) {
            System.out.println(g);
        }
    }
    /**
     * term查询加分页
     */
    @Test
    public void termQueryByPage(){
        int currentPage= 0 ;
        int pageSize = 5;
        //设置查询分页
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize);
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", "小米");
        Iterable<Good> goods = goodDao.search(termQueryBuilder,pageRequest);
        for (Good g : goods) {
            System.out.println(g);
        }
    }
}
```



### 4、自定义方法名称查询

GoodsRepository提供了非常强大的自定义查询功能；只要遵循SpringData提供的语法，我们可以任意定义方法声明；

查询语法：findBy+字段名+Keyword+字段名+....

| Keyword        | Sample                                     | Elasticsearch Query String                                   |
| -------------- | ------------------------------------------ | ------------------------------------------------------------ |
| `And`          | `findByNameAndPrice`                       | `{"bool" : {"must" : [ {"field" : {"name" : "?"}}, {"field" : {"price" : "?"}} ]}}` |
| `Or`           | `findByNameOrPrice`                        | `{"bool" : {"should" : [ {"field" : {"name" : "?"}}, {"field" : {"price" : "?"}} ]}}` |
| `Is`           | `findByName`                               | `{"bool" : {"must" : {"field" : {"name" : "?"}}}}`           |
| `Not`          | `findByNameNot`                            | `{"bool" : {"must_not" : {"field" : {"name" : "?"}}}}`       |
| `Between`      | `findByPriceBetween`                       | `{"bool" : {"must" : {"range" : {"price" : {"from" : ?,"to" : ?,"include_lower" : true,"include_upper" : true}}}}}` |
| `Before`       | `findByPriceBefore`                        | `{"bool" : {"must" : {"range" : {"price" : {"from" : null,"to" : ?,"include_lower" : true,"include_upper" : true}}}}}` |
| `After`        | `findByPriceAfter`                         | `{"bool" : {"must" : {"range" : {"price" : {"from" : ?,"to" : null,"include_lower" : true,"include_upper" : true}}}}}` |
| `Like`         | `findByNameLike`                           | `{"bool" : {"must" : {"field" : {"name" : {"query" : "?*","analyze_wildcard" : true}}}}}` |
| `StartingWith` | `findByNameStartingWith`                   | `{"bool" : {"must" : {"field" : {"name" : {"query" : "?*","analyze_wildcard" : true}}}}}` |
| `EndingWith`   | findByNameEndingWith                       | `{"bool" : {"must" : {"field" : {"name" : {"query" : "*?","analyze_wildcard" : true}}}}}` |
| `In`           | `findByNameIn(Collection<String>names)`    | `{"bool" : {"must" : {"bool" : {"should" : [ {"field" : {"name" : "?"}}, {"field" : {"name" : "?"}} ]}}}}` |
| `NotIn`        | `findByNameNotIn(Collection<String>names)` | `{"bool" : {"must_not" : {"bool" : {"should" : {"field" : {"name" : "?"}}}}}}` |
| `OrderBy`      | `findByNameOrderByNameDesc`                | `{"sort" : [{ "name" : {"order" : "desc"} }],"bool" : {"must" : {"field" : {"name" : "?"}}}` |

持久层接口：

```java
/**
 *  ElasticsearchRepository 持久层操作ElasticSearch的模板接口
 */
public interface GoodDao extends ElasticsearchRepository<Good,Long> {
    /**
     * 根据title和价格查询，and的关系
     */
    List<Good> findAllByTitleAndPrice(String title,Double price);
    /**
     * 根据商品价格范围查询
     * 最低价格lowPrice
     * 最高价格highPrice
     */
    List<Good> findByPriceBetween(Double lowPrice,Double highPrice);
}
```



测试类：

```java
/**
 * 自定义方法名称查询测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdataEsCustomMethodQuery {

    //注入Good业务层实现类
    @Autowired
    private GoodDao goodDao;

    /**
     * 根据标题及价格查询
     * 要求价格等于20023且标题的内容包含小米关键词
     */
    @Test
    public void findAllByTitleAndPrice(){
        String title = "小米";
        Double price = 20023.0;
        List<Good> goods = goodDao.findAllByTitleAndPrice(title, price);
        for (Good g : goods) {
            System.out.println(g);
        }
    }
    /**
     * 根据价格范围查询
     * 要求商品价格再3000，到20000之间
     */
    @Test
    public void findPriceBetween(){
        double lowPrice = 3000.0;//最低价
        double highPrice = 20000.0;//最高价
        List<Good> goods = goodDao.findByPriceBetween(lowPrice, highPrice);
        for (Good g : goods) {
            Systemout.println(g);
        }
    }
}
```

# 总结

1. 能够完成索引库的操作：新增、查询、删除
2. 能够完成映射操作：配置映射，查看映射
3. 能够完成文档的操作：新增、修改、删除
4. 能完成请求体查询：基本查询、结果过滤、高亮查询，分页及排序
5. 脑裂
6. 聚合