package com.cn.jjk.controller;

import java.io.Serializable;

/**
 * 通过此对象封装服务端控制层要向客户端 响应的数据(正确或错误的数据)
 */
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 1786367477077601769L;
    /** 状态码:1表示正确,0表示错误,.... */
    private Integer state = 1;
    /** 状态码对应的消息描述 */
    private String message;
    /**
     * 服务端要客户端呈现的具体数据,例如 可以是一个查询的结果
     */
    private Object data;

    public JsonResult() {
        // TODO Auto-generated constructor stub
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(String message, Object data) {
        super();
        this.message = message;
        this.data = data;
    }

    public JsonResult(Integer state, String message, Object data) {
        super();
        this.state = state;
        this.message = message;
        this.data = data;
    }

    // 出现异常时可以通过此构造方法封装数据
    public JsonResult(Throwable e) {
        this.state = 0;
        this.message = e.getMessage();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
    }

}
