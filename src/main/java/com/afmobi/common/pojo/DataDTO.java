package com.afmobi.common.pojo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName:   DataDTO
 * Date:        2018-07-23 16:25
 *
 * @author Vincent
 */
public class DataDTO<T> {
    @ApiModelProperty(notes = "响应码", example = "'200'")
    String code;
    @ApiModelProperty(notes = "详细解释")
    String desc;
    T data;

    /**
     * 成功返回数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> DataDTO<T> success(T data) {
        DataDTO<T> rtn = new DataDTO();
        rtn.setCode(200);
        rtn.setData(data);
        return rtn;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode(Integer code) {
        this.code = String.valueOf(code);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
