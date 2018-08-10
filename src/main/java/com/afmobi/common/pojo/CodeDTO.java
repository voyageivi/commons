package com.afmobi.common.pojo;

import io.swagger.annotations.ApiModel;

/**
 * ClassName:   CodeDTO
 * Date:        2018-07-18 14:04
 *
 * @author Vincent
 */
@ApiModel(value = "code", description = "数据返回code")
public class CodeDTO {
    String code;
    String desc;

    public static CodeDTO success() {
        CodeDTO rtn = new CodeDTO();
        rtn.setCode("200");
        return rtn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(Integer code) {
        setCode(String.valueOf(code));
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
