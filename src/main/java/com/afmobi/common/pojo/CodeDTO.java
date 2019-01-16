package com.afmobi.common.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * ClassName:   CodeDTO
 * Date:        2018-07-18 14:04
 *
 * @author Vincent
 */
@ApiModel(value = "code", description = "数据返回code")
@Data
public class CodeDTO {
    String code;
    String desc;

    public static CodeDTO success() {
        CodeDTO rtn = new CodeDTO();
        rtn.setCode("200");
        return rtn;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode(int code) {
        this.code = String.valueOf(code);
    }

}
