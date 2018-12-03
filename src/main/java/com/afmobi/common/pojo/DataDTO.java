package com.afmobi.common.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName:   DataDTO
 * Date:        2018-07-23 16:25
 *
 * @author Vincent
 */
@Data
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


    public void setCode(Integer code) {
        this.code = String.valueOf(code);
    }

}
