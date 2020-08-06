package com.itheima.pojo;

import lombok.*;

/**
 * 使用构建者对象创建Goods对象
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GoodsThree {

    private Long id;//商品的唯一标识
    private String title;//标题
    private String category;//分类
    private String brand;//品牌
    private Double price;//价格
    private String images;//图片地址

    //获取构建器对象
    public static GoodsThree.GoodsThreeBuilder builder() {
        return new GoodsThree.GoodsThreeBuilder();
    }

    //GoodsThree对象构建器类
    public static class GoodsThreeBuilder {
        private Long id;
        private String title;
        private String category;
        private String brand;
        private Double price;
        private String images;

        GoodsThreeBuilder() {
        }

        public GoodsThree.GoodsThreeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public GoodsThree.GoodsThreeBuilder title(String title) {
            this.title = title;
            return this;
        }

        public GoodsThree.GoodsThreeBuilder category(String category) {
            this.category = category;
            return this;
        }

        public GoodsThree.GoodsThreeBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public GoodsThree.GoodsThreeBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public GoodsThree.GoodsThreeBuilder images(String images) {
            this.images = images;
            return this;
        }

        public GoodsThree build() {
            return new GoodsThree(this.id, this.title, this.category, this.brand, this.price, this.images);
        }

        public String toString() {
            return "GoodsThree.GoodsThreeBuilder(id=" + this.id + ", title=" + this.title + ", category=" + this.category + ", brand=" + this.brand + ", price=" + this.price + ", images=" + this.images + ")";
        }
    }
}
