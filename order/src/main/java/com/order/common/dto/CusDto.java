package com.order.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CusDto implements Serializable {

    private Integer id;
    private Integer tableid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }
}
