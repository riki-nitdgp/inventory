package com.inventory.inventoryService.models;

import lombok.Data;


@Data
public class Response {

    private Object data;
    private boolean success;
    private int status;

    public Response(Object data, boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }

}
