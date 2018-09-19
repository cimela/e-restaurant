package com.github.cimela.e.restaurant.base.appserver;

import java.util.List;

import com.github.cimela.e.restaurant.base.model.GenericModelVO;

public class ListResponse<T extends GenericModelVO<?>> {
    private int total = -1;
    private List<T> data;

    public ListResponse() {
        super();
    }

    public ListResponse(List<T> data) {
        super();
        this.data = data;
    }

    public ListResponse(int total, List<T> data) {
        super();
        this.total = total;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
