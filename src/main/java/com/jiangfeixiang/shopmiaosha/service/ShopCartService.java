package com.jiangfeixiang.shopmiaosha.service;

import com.jiangfeixiang.shopmiaosha.service.model.ShopCartModel;
import com.jiangfeixiang.shopmiaosha.service.model.ShopCartModel;

import java.util.List;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/17/0017 18:09
 * @param: $params$
 * @return: $returns$
 */
public interface ShopCartService {
    /**
     * 加入购物车
     * @param shopCartModel
     */
    void addCart(ShopCartModel shopCartModel);

    List<ShopCartModel> listShopCart();
}
