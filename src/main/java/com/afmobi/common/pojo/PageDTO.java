package com.afmobi.common.pojo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * ClassName: PageDTO Date: 2018-06-06 11:17
 *
 * @author Vincent
 */
public class PageDTO<T> {
    int total;
    List<T> rows;

    /**
     * @return the totle
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the totle to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
    public void setTotal(long total) {
        this.total = (int)total;
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

    /**
     * @param rows the rows to set
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public static <T> PageDTO<T> of(List<T> rows,int total){
        PageDTO<T> rtn=new PageDTO<T>();
        rtn.setTotal(total);
        rtn.setRows(rows);
        return rtn;
    }
}
