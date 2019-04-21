package com.jiangfeixiang.shopmiaosha.service;

import com.jiangfeixiang.shopmiaosha.service.model.ItemModel;
import com.jiangfeixiang.shopmiaosha.service.model.ItemModel;

import java.util.List;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/9/0009 9:21
 * @param: $params$
 * @return: $returns$
 */
public interface ItemService {

    /**
     * 创建商品,同时返回商品详情model
     * @param itemModel
     * @return
     */
    ItemModel createItem(ItemModel itemModel);

    /**
     * 查询所有商品
     * @return
     */
    List<ItemModel> listItem();

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    ItemModel getItemById(Integer id);
}
