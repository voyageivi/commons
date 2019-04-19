package com.afmobi.common.pojo;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * ClassName:   KeyValueVO
 * Date:        2019-04-11 11:07
 *
 * @author Vincent
 */
@Data
public class KeyValueVO<T1, T2> {
    @ApiParam("键")
    T1 key;
    @ApiParam("值")
    T2 value;

    public static <T1, T2> KeyValueVO<T1, T2> of(T1 key, T2 value) {
        KeyValueVO<T1, T2> rtn = new KeyValueVO<T1, T2>();
        rtn.setKey(key);
        rtn.setValue(value);
        return rtn;
    }
}
