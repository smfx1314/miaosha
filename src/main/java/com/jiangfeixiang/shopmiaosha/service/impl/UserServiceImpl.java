package com.jiangfeixiang.shopmiaosha.service.impl;

import com.jiangfeixiang.shopmiaosha.dao.UserDoMapper;
import com.jiangfeixiang.shopmiaosha.dao.UserPasswordDoMapper;
import com.jiangfeixiang.shopmiaosha.dataobject.UserDo;
import com.jiangfeixiang.shopmiaosha.dataobject.UserPasswordDo;
import com.jiangfeixiang.shopmiaosha.service.UserService;
import com.jiangfeixiang.shopmiaosha.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 姜飞祥
 * @Description:
 * @Date: Create in 2019/3/2/0002 13:17
 * @param: $params$
 * @return: $returns$
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDoMapper userDoMapper;

    @Autowired
    private UserPasswordDoMapper userPasswordDoMapper;

    /**
     * 根据id查询用户
     * @param id
     */
    @Override
    public UserModel getUserById(Integer id) {
        //获取用户信息
        UserDo userDo = userDoMapper.selectByPrimaryKey(id);

        //通过用户外键获取对应密码
        UserPasswordDo userPasswordDo = userPasswordDoMapper.selectByUserId(userDo.getId());

        //封装到UserModel中
        UserModel userModel = converFromDataObject(userDo, userPasswordDo);

        return userModel;
    }

    /**
     * 封装userDo和userpasswordDo
     * @param userDo
     * @param userPasswordDo
     * @return
     */
    private UserModel converFromDataObject(UserDo userDo,UserPasswordDo userPasswordDo){
        UserModel userModel = new UserModel();
        if (userModel !=null){
            userModel.setId(userDo.getId());
            userModel.setName(userDo.getName());
            userModel.setGender(userDo.getGender());
            userModel.setAge(userDo.getAge());
            userModel.setTelphone(userDo.getTelphone());
            userModel.setRegisterMode(userDo.getRegisterMode());
            userModel.setThirdPartyId(userDo.getThirdPartyId());
        }
        if (userPasswordDo !=null){
            userModel.setPassword(userPasswordDo.getPassword());
        }
        return userModel;
    }


    /**
     * 用户注册
     * @param userModel
     * @return
     */
    @Override
    public void register(UserModel userModel){
        if (StringUtils.isEmpty(userModel.getName())
                || userModel.getAge() == null
                || userModel.getGender() == null
                || StringUtils.isEmpty(userModel.getTelphone())){
            return;
        }


        /**
         * 注册
         */
        //实现model-->userDo
        UserDo userDo = converUserFromModel(userModel);
        userDoMapper.insertSelective(userDo);
        //获取自增id，为下面userPasswordDo的外键user_id传值
        userModel.setId(userDo.getId());
        System.out.println(userModel);

        //实现model-->userPasswordDo
        UserPasswordDo userPasswordDo = converPassworFromModel(userModel);
        userPasswordDoMapper.insertSelective(userPasswordDo);
        //System.out.println(userPasswordDo);
    }

    /**
     * 拆解userModel-->userDo
     * @param userModel
     * @return
     */
    private UserDo converUserFromModel(UserModel userModel){
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(userModel,userDo);
        return userDo;
    }

    /**
     * 拆解userModel-->userPassword
     * @param userModel
     * @return
     */
    private UserPasswordDo converPassworFromModel(UserModel userModel){
        UserPasswordDo userPasswordDo = new UserPasswordDo();
        userPasswordDo.setPassword(userModel.getPassword());
        userPasswordDo.setUserId(userModel.getId());
        return userPasswordDo;
    }


    /**
     * 用户登录，根据手机号和密码查询
     * @param telphone
     * @param password
     */
    @Override
    public void login(String telphone, String password) {
        //第一步：根据手机号查询用户信息
        UserDo userDo = userDoMapper.selectByTelphone(telphone);

        //第二步：通过上面查询的用户信息中的id查询密码
        UserPasswordDo userPasswordDo = userPasswordDoMapper.selectByPrimaryKey(userDo.getId());

        //第三步：把userDo和UserPasswordDo封装UserModel
        UserModel userModel = converFromDataObject(userDo, userPasswordDo);

        //第四步：判断前端传递的加密密码是否和userModel中的加密密码一致,相等直接返回即可
        if (StringUtils.equals(password,userModel.getPassword())){
            return;
        }
    }
}
