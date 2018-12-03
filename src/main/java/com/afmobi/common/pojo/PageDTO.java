package com.afmobi.common.pojo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ClassName: PageDTO Date: 2018-06-06 11:17
 *
 * @author Vincent
 */
@ApiModel("Page")
@Data
public class PageDTO<T> {
    @ApiModelProperty("总数")
    int total;
    @ApiModelProperty("行数据")
    List<T> rows;

    public void setTotal(long total) {
        this.total = (int) total;
    }

    /**
     * @return the rows
     */
    public List<T> getRows() {
        if (rows == null) {
            rows = Lists.newArrayList();
        }
        return rows;
    }


    public static <T> PageDTO<T> of(List<T> rows, int total) {
        PageDTO<T> rtn = new PageDTO<T>();
        rtn.setTotal(total);
        rtn.setRows(rows);
        return rtn;
    }
}
