package com.jiangfeixiang.shopmiaosha.controller;

import com.jiangfeixiang.shopmiaosha.controller.viewobject.ItemVO;
import com.jiangfeixiang.shopmiaosha.response.CommonReturnType;
import com.jiangfeixiang.shopmiaosha.service.ItemService;
import com.jiangfeixiang.shopmiaosha.service.model.ItemModel;
import com.jiangfeixiang.shopmiaosha.response.CommonReturnType;
import com.jiangfeixiang.shopmiaosha.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/9/0009 9:11
 * @param: $params$
 * @return: $returns$
 */
@Controller
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 创建商品
     * @param title
     * @param price
     * @param description
     * @param sales
     * @param imgUrl
     * @param stock
     * @return
     */
    @RequestMapping(value = "/createItem")
    @ResponseBody
    public CommonReturnType createItem(@RequestParam(name = "title") String title,
                                       @RequestParam(name = "price") BigDecimal price,
                                       @RequestParam(name = "description") String description,
                                       @RequestParam(name = "sales") Integer sales,
                                       @RequestParam(name = "imgUrl") String imgUrl,
                                       @RequestParam(name = "stock") Integer stock){

        //封装ItemModel创建商品
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setPrice(price);
        itemModel.setDescription(description);
        itemModel.setSales(sales);
        itemModel.setImgUrl(imgUrl);
        itemModel.setStock(stock);
        ItemModel item = itemService.createItem(itemModel);

        //转换itemvo
        ItemVO itemVO = converItemVOFromModel(itemModel);

        return CommonReturnType.success(itemVO);
    }
    /**
     * 封装ItemVO
     * @param itemModel
     * @return
     */
    private ItemVO converItemVOFromModel(ItemModel itemModel){
        ItemVO itemVO = new ItemVO();
        if (itemVO !=null){
            BeanUtils.copyProperties(itemModel,itemVO);
        }
        return itemVO;
    }


    /**
     * 根据id查询商品详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/getItemById")
    @ResponseBody
    public CommonReturnType getItemById(@RequestParam(name = "id") Integer id){

        ItemModel itemModel = itemService.getItemById(id);
        System.out.println(itemModel);

        return CommonReturnType.success(itemModel);
    }


    /**
     * 查询所有商品
     * @return
     */
    @RequestMapping(value = "/listItem")
    @ResponseBody
    public CommonReturnType listItem(){

        List<ItemModel> itemModels = itemService.listItem();

        return CommonReturnType.success(itemModels);
    }
}
