package com.inventory.inventoryService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiError {
    private Integer status;
    private String message;
    private List<String> errors;
    private boolean isSuccess;

    public ApiError(Integer status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.isSuccess = false;
    }

    public ApiError(Integer status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
        this.isSuccess = false;
    }
}

