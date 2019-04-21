package com.jiangfeixiang.shopmiaosha.service;

import com.jiangfeixiang.shopmiaosha.service.model.UserModel;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/2/0002 13:17
 * @param: $params$
 * @return: $returns$
 */
public interface UserService {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserModel getUserById(Integer id);

    /**
     * 用户注册
     * @param userModel
     * @return
     */
    void register(UserModel userModel);


    /**
     * 用户登录
     * @param telphone
     * @param password
     */
    void login(String telphone, String password);
}
