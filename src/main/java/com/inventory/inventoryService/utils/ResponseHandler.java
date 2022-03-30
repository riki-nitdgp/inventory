package com.inventory.inventoryService.utils;

import com.inventory.inventoryService.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(Object responseObj) {
        HttpStatus status = HttpStatus.OK;
        boolean isSuccess = true;
        Response response = new Response(responseObj, isSuccess, status.value());
        return new ResponseEntity<Object>(response, status);
    }
}
