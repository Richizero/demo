package com.example.demo.utils;

import org.springframework.http.ResponseEntity;


public class ApiResponse<T> {
    private String message;
    private T data;
    private Boolean error;
    private Integer status;
    private ResponseEntity<T> responseEntity;

    class Body {
        public String message;
        public T data;
        public Boolean error;
    }

    public ApiResponse(String message, T data, Boolean error, Integer status) {
        this.message = message;
        this.data = data;
        this.error = error;
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
    public ResponseEntity getResponseEntity() {
        Body body = new Body();
        body.data = data;
        body.message = message;
        body.error = error;
        return ResponseEntity.status(status).body(body);
    }
}
