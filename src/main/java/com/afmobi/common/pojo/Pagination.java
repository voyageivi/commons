/*
 * TOP SECRET
 * Copyright 2006-2015 Transsion.com All right reserved. This software is the
 * confidential and proprietary information of Transsion.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Transsion.com.
 */
package com.afmobi.common.pojo;

import io.swagger.annotations.ApiParam;

/**
 * ClassName:Pagination Date: 2016年12月26日 上午10:40:19
 * 默认第一页为: 1
 * 可能通过 {@link Pagination#setIsBaseZero} 修改
 *
 * @author vincent
 * @see
 */
public class Pagination {
    private static boolean isBaseZero = false;
    @ApiParam(name = "page", value = "页码", defaultValue = "1", example = "1")
    Integer page;
    @ApiParam(name = "pagesize", value = "每页数量", defaultValue = "15", example = "15")
    Integer pagesize;

    public static void setIsBaseZero(boolean isBaseZero) {
        Pagination.isBaseZero = isBaseZero;
    }

    /**
     * default 0
     *
     * @return the page
     */
    public Integer getPage() {
        if (page == null) {
            page = 1;
        }
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    @ApiParam(hidden = true)
    public Integer getFrom() {
        return (getPage() - (isBaseZero ? 0 : 1)) * getPagesize();
    }

    /**
     * default 15
     *
     * @return the pagesize
     */
    public Integer getPagesize() {
        if (pagesize == null) {
            pagesize = 15;
        }
        return pagesize;
    }

    /**
     * @param pagesize the pagesize to set
     */
    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public void setRows(Integer pagesize) {
        this.pagesize = pagesize;
    }
}
