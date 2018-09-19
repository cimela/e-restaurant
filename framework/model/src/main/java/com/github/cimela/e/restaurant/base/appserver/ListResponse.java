package com.github.cimela.e.restaurant.base.appserver;

import java.util.List;

import com.github.cimela.e.restaurant.base.model.GenericModelVO;

public class ListResponse<T extends GenericModelVO<?>> {
    private long total = -1;
    private List<T> data;

    public ListResponse() {
        super();
    }

    public ListResponse(List<T> data) {
        super();
        this.data = data;
    }

    public ListResponse(long total, List<T> data) {
        super();
        this.total = total;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
