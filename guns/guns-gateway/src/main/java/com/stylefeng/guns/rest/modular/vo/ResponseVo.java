package com.stylefeng.guns.rest.modular.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ClassName: ResponseVo
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/23  15:55
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo<T> {
    /**
     * 0-成功   1-业务异常   999-系统异常
     */
    private int status;
    private String msg;
    private T data;

    public static<T> ResponseVo success(String msg) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.setStatus(0);
        responseVo.setMsg(msg);
        return responseVo;
    }

    public static<T> ResponseVo success(T t) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.setStatus(0);
        responseVo.setData(t);
        return responseVo;
    }

    public static<T> ResponseVo fail(String msg) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.setStatus(1);
        responseVo.setMsg(msg);
        return responseVo;
    }


    public static<T> ResponseVo systemExp(String msg) {
        ResponseVo<T> responseVo = new ResponseVo<>();
        responseVo.setStatus(999);
        responseVo.setMsg(msg);
        return responseVo;
    }

}
