package com.jiangfeixiang.shopmiaosha.service.impl;

import com.jiangfeixiang.shopmiaosha.dao.ItemDoMapper;
import com.jiangfeixiang.shopmiaosha.dao.ItemStockDoMapper;
import com.jiangfeixiang.shopmiaosha.dataobject.ItemDo;
import com.jiangfeixiang.shopmiaosha.dataobject.ItemStockDo;
import com.jiangfeixiang.shopmiaosha.service.ItemService;
import com.jiangfeixiang.shopmiaosha.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/9/0009 9:21
 * @param: $params$
 * @return: $returns$
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDoMapper itemDoMapper;

    @Autowired
    private ItemStockDoMapper itemStockDoMapper;


    /**
     * 创建商品
     * @param itemModel
     * @return
     */
    @Override
    public ItemModel createItem(ItemModel itemModel) {

        //插入商品
        ItemDo itemDo = converItemDoFromModel(itemModel);
        itemDoMapper.insertSelective(itemDo);
        //把item id拿到，方便给下边的itemStockDo
        itemModel.setId(itemDo.getId());

        //插入库存
        ItemStockDo itemStockDo = converItemStockDoFromModel(itemModel);
        itemStockDoMapper.insertSelective(itemStockDo);

        //直接返回插入的商品信息
        return getItemById(itemDo.getId());
    }

    /**
     * 拆解ItemModel-->ItemDo
     * @param itemModel
     * @return
     */
    private ItemDo converItemDoFromModel(ItemModel itemModel){
        ItemDo itemDo = new ItemDo();
        itemDo.setId(itemModel.getId());
        itemDo.setTitle(itemModel.getTitle());
        itemDo.setPrice(itemModel.getPrice());
        itemDo.setSales(itemModel.getSales());
        itemDo.setDescription(itemModel.getDescription());
        itemDo.setImgUrl(itemModel.getImgUrl());

        return itemDo;
    }

    /**
     * 拆解ItemModel-->ItemStockDo
     * @param itemModel
     * @return
     */
    private ItemStockDo converItemStockDoFromModel(ItemModel itemModel){
        ItemStockDo itemStockDo = new ItemStockDo();
        itemStockDo.setId(itemModel.getId());
        itemStockDo.setStock(itemModel.getStock());
        itemStockDo.setItemId(itemModel.getId());
        return itemStockDo;
    }


    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<ItemModel> listItem() {

        //查询所有商品
        List<ItemDo> itemDos = itemDoMapper.listItem();
        List<ItemModel> itemModels = itemDos.stream().map(itemDo -> {
            //查询对应库存
            ItemStockDo itemStockDo = itemStockDoMapper.selectByItemId(itemDo.getId());
            ItemModel itemModel = converItemModelFromItemStockDoAndItemDo(itemDo,itemStockDo);
            return itemModel;
        }).collect(Collectors.toList());

        return itemModels;
    }
    /**
     * 根据id查询商品详情
     * @param id
     * @return
     */
    @Override
    public ItemModel getItemById(Integer id) {

        ItemDo itemDo = itemDoMapper.selectByPrimaryKey(id);
        if (itemDo == null){
            return null;
        }
        //同时拿到库存数量,通过库存外键即itemId
        ItemStockDo itemStockDo = itemStockDoMapper.selectByItemId(itemDo.getId());

        //整合ItemStockDo和ItemDo --> ItemModel
        ItemModel itemModel = converItemModelFromItemStockDoAndItemDo(itemDo,itemStockDo);
        return itemModel;
    }

    /**
     * 整合ItemStockDo和ItemDo --> ItemModel
     * @param itemStockDo itemDo
     * @return
     */
    private ItemModel converItemModelFromItemStockDoAndItemDo(ItemDo itemDo,ItemStockDo itemStockDo){
        ItemModel itemModel = new ItemModel();
        /*itemModel.setId(itemDo.getId());
        itemModel.setTitle(itemDo.getTitle());
        itemModel.setPrice(itemDo.getPrice());
        itemModel.setSales(itemDo.getSales());
        itemModel.setDescription(itemDo.getDescription());
        itemModel.setImgUrl(itemDo.getImgUrl());
        itemModel.setStock(itemStockDo.getStock());*/
        BeanUtils.copyProperties(itemDo,itemModel);
        BeanUtils.copyProperties(itemStockDo,itemModel);
        return itemModel;
    }
}
