package com.jiangfeixiang.shopmiaosha.dao;

import com.jiangfeixiang.shopmiaosha.dataobject.ShopCartDo;

public interface ShopCartDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_cart
     *
     * @mbg.generated Sun Mar 17 21:22:10 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_cart
     *
     * @mbg.generated Sun Mar 17 21:22:10 CST 2019
     */
    int insert(ShopCartDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_cart
     *
     * @mbg.generated Sun Mar 17 21:22:10 CST 2019
     */
    int insertSelective(ShopCartDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_cart
     *
     * @mbg.generated Sun Mar 17 21:22:10 CST 2019
     */
    ShopCartDo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_cart
     *
     * @mbg.generated Sun Mar 17 21:22:10 CST 2019
     */
    int updateByPrimaryKeySelective(ShopCartDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shop_cart
     *
     * @mbg.generated Sun Mar 17 21:22:10 CST 2019
     */
    int updateByPrimaryKey(ShopCartDo record);
}