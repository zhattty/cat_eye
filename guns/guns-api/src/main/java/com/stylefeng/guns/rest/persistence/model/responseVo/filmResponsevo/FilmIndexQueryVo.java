package com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo;

import java.util.Map;

/**
 * Created by ZhangYao
 * Date 2019/4/21 Time 15:59
 */
public class FilmIndexQueryVo {
    /**
     *  0 表示正常
     *  1 查询失败无banner可加载
     *  999 系统异常请联系管理员
     */
   private int status;

   private String imgPre;

   private String msg;

   private Map<String, Object>  data;

    public FilmIndexQueryVo() {
    }

    public FilmIndexQueryVo(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FilmIndexQueryVo{" +
                "status=" + status +
                ", imgPre='" + imgPre + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
