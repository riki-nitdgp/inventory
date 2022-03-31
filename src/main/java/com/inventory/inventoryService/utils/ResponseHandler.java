package com.inventory.inventoryService.utils;

import com.inventory.inventoryService.models.ApiError;
import com.inventory.inventoryService.models.Paginator;
import com.inventory.inventoryService.models.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(Object responseObj,  Paginator pageInfo) {
        HttpStatus status = HttpStatus.OK;
        boolean isSuccess = true;
        Response response = new Response(responseObj, isSuccess, status.value(), pageInfo);
        return new ResponseEntity<Object>(response, status);
    }

    public static ResponseEntity<Object> generateResponse(Object responseObj) {
        HttpStatus status = HttpStatus.OK;
        boolean isSuccess = true;
        Response response = new Response(responseObj, isSuccess, status.value());
        return new ResponseEntity<Object>(response, status);
    }

    public static ResponseEntity<Object> generateErrorResponse(Exception ex, HttpStatus httpStatus, String error) {
        ApiError apiError = new ApiError(httpStatus, ex.getMessage(), error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    public static ResponseEntity<Object> generateErrorResponse(Exception ex, HttpStatus httpStatus, List errors) {
        ApiError apiError = new ApiError(httpStatus, ex.getMessage(), errors);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
