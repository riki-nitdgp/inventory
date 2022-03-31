package com.inventory.inventoryService.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;



@Data
@JsonInclude(Include.NON_NULL)
public class Response {

    private Object data;
    private boolean success;
    private int status;

    private Paginator pageInfo;

    public Response(Object data, boolean success, int status, Paginator pageInfo) {
        this.data = data;
        this.success = success;
        this.status = status;
        this.pageInfo = pageInfo;
    }

    public Response(Object data, boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }

}
