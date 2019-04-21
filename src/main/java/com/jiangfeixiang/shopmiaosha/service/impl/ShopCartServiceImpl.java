package com.jiangfeixiang.shopmiaosha.service.impl;

import com.jiangfeixiang.shopmiaosha.dao.ShopCartDoMapper;
import com.jiangfeixiang.shopmiaosha.dataobject.ShopCartDo;
import com.jiangfeixiang.shopmiaosha.service.ShopCartService;
import com.jiangfeixiang.shopmiaosha.service.model.ShopCartModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/17/0017 18:13
 * @param: $params$
 * @return: $returns$
 */
@Service
@Transactional
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartDoMapper shopCartDoMapper;

    @Override
    public void addCart(ShopCartModel shopCartModel) {
        ShopCartDo shopCartDo = converShopCartDoFromShopCartModel(shopCartModel);
        shopCartDoMapper.insertSelective(shopCartDo);
    }

    /**
     * 拆解shopCartModel-->shopCartDo
     * @param shopCartModel
     * @return
     */
    private ShopCartDo converShopCartDoFromShopCartModel(ShopCartModel shopCartModel){
        ShopCartDo shopCartDo = new ShopCartDo();
        /*shopCartDo.setUserId(shopCartModel.getUserId());
        shopCartDo.setItemId(shopCartModel.getItemId());
        shopCartDo.setTitle(shopCartModel.getTitle());
        shopCartDo.setImgurl(shopCartModel.getImgUrl());
        shopCartDo.setTotalprice(shopCartModel.getTotalPrice());
        shopCartDo.setCount(shopCartModel.getCount());*/
        BeanUtils.copyProperties(shopCartModel,shopCartDo);
        return shopCartDo;
    }

    @Override
    public List<ShopCartModel> listShopCart() {
        return null;
    }
}
