package com.jiangfeixiang.shopmiaosha.controller.viewobject;

import java.math.BigDecimal;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/9/0009 10:11
 * @param: $params$
 * @return: $returns$
 */
public class ItemVO {
    private Integer id;
    /**
     * 商品名
     */
    private String title;
    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品描述
     */
    private String description;
    /**
     * 商品销量
     */
    private Integer sales;
    /**
     * 商品图片url
     */
    private String imgUrl;
    /**
     * 商品库存
     */
    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ItemVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", sales=" + sales +
                ", imgUrl='" + imgUrl + '\'' +
                ", stock=" + stock +
                '}';
    }
}
