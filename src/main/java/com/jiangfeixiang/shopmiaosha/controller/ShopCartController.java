package com.jiangfeixiang.shopmiaosha.controller;

import com.jiangfeixiang.shopmiaosha.response.CommonReturnType;
import com.jiangfeixiang.shopmiaosha.service.ShopCartService;
import com.jiangfeixiang.shopmiaosha.service.model.ShopCartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/17/0017 18:35
 * @param: $params$
 * @return: $returns$
 */
@Controller
@RequestMapping("/cart")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;

    @RequestMapping(value = "/createCart")
    @ResponseBody
    public CommonReturnType addShopCart(@RequestParam(name = "userId") Integer userId,
                                        @RequestParam(name = "itemId") Integer itemId,
                                        @RequestParam(name = "title") String title,
                                        @RequestParam(name = "imgUrl") String imgUrl){

        ShopCartModel shopCartModel = new ShopCartModel();
        shopCartModel.setUserId(userId);
        shopCartModel.setItemId(itemId);
        shopCartModel.setTitle(title);
        shopCartModel.setImgUrl(imgUrl);
        shopCartService.addCart(shopCartModel);
        return CommonReturnType.success();
    }
}
