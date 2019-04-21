package com.jiangfeixiang.shopmiaosha.response;

/**
 * @Author: 姜飞祥
 * @Description: 封装结果集成统一的json样式
 * @Date: Create in 2018/9/15 12:08
 * @param: $params$
 * @return: $returns$
 */
public class CommonReturnType {
    /**
     * 返回编码，0成功，1失败
     */
    private Integer code;

    /**
     * 返回信息，success成功，fail失败
     */
    private String status;

    /**
     * 返回的对象
     */
    private Object data;

    /**
     * 构造函数:成功并返回数据，返回信息，code
     * @param
     */
     private CommonReturnType(Integer code,String status,Object data) {
        this.status = status;
        this.code = code;
        this.data = data;
    }

    /**
     * 构造函数:失败并返回提示信息
     * @param status
     * @param code
     */
    private CommonReturnType(Integer code,String status){
        this.status=status;
        this.code=code;
    }

    /**
     * 成功并返回的数据
     * @return
     */
    public static CommonReturnType success(Object data) {

        return new CommonReturnType(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc(),data);
    }

    /**
     * 成功没有要返回的数据
     * @return
     */
    public static CommonReturnType success() {

        return new CommonReturnType(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }

    /**
     * 失败
     * @return
     */
    public static CommonReturnType fail() {

        return new CommonReturnType(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
