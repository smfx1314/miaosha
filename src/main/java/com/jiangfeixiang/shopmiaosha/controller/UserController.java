package com.jiangfeixiang.shopmiaosha.controller;

import com.jiangfeixiang.shopmiaosha.controller.viewobject.UserVO;
import com.jiangfeixiang.shopmiaosha.response.CommonReturnType;
import com.jiangfeixiang.shopmiaosha.service.UserService;
import com.jiangfeixiang.shopmiaosha.service.model.UserModel;
import com.jiangfeixiang.shopmiaosha.util.MyMD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/2/0002 13:17
 * @param: $params$
 * @return: $returns$
 */
@Controller
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id")Integer id){
        if (id !=null){
            UserModel userModel = userService.getUserById(id);
            UserVO userVO = converFromModel(userModel);
            return CommonReturnType.success(userVO);
        }
        return null;
    }

    /**
     * 封装userVo
     * @param userModel
     * @return
     */
    private UserVO converFromModel(UserModel userModel){
        UserVO userVO = new UserVO();
        if (userModel !=null){
            BeanUtils.copyProperties(userModel,userVO);
        }
        return userVO;
    }




    /**
     * 用户注册
     * @param name
     * @param gender
     * @param age
     * @param telphone
     * @param password
     * @return
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "name")String name,
                                     @RequestParam(name = "gender")Integer gender,
                                     @RequestParam(name = "age")Integer age,
                                     @RequestParam(name = "telphone")String telphone,
                                     @RequestParam(name = "password")String password){

        //注册，把参数都封装到UserModel中
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(gender);
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setPassword(MyMD5Util.md5Password(password));
        userService.register(userModel);
        System.out.println("1234");
        return CommonReturnType.success();
    }


    /**
     * 用户登录，通过手机号和密码登录
     * @param telphone
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public CommonReturnType login(@RequestParam("telphone") String telphone,
                                  @RequestParam("password") String password,
                                  ServletContext servletContext){

        //把传递过来的密码进行加密
        userService.login(telphone,MyMD5Util.md5Password(password));

        return CommonReturnType.success();
    }
}
