package com.les.decisionsupport.base.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class Pagination extends Page{
    private long pageSize=20;
    private long maxPageSize = 50;
    private String sort="desc";
    private long currentPage=1;

    private long total;
    @JsonIgnore
    private long records;
    @JsonIgnore
    private long offset;


    public <T> List<T> setData(List<T> data, long records) {
        this.total = records;
        return data;
    }

    public void setPageSize(long size) {
        this.pageSize = size;
    }

    public long getOffset() {
    	if(pageSize*(currentPage-1)>0) {
    		return pageSize*(currentPage-1);
    	}else {
    		return 0;
    	}
    }
}
