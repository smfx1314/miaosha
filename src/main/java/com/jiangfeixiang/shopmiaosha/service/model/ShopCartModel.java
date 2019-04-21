package com.jiangfeixiang.shopmiaosha.service.model;

import java.math.BigDecimal;

/**
 * @Author: 姜飞祥
 * @Description: 购物车
 * @Date: Create in 2019/3/17/0017 14:41
 * @param: $params$
 * @return: $returns$
 */
public class ShopCartModel {

    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 商品id
     */
    private Integer itemId;

    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品图片
     */
    private String imgUrl;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 商品数量
     */
    private Integer count;
    /**
     * 商品总价
     */
    private BigDecimal totalPrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShopCartModel{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
