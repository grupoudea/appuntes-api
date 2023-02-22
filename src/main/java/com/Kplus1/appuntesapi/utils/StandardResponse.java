package com.Kplus1.appuntesapi.utils;

import lombok.Data;

@Data
public class StandardResponse<T> {
    private String description;
    private String message;
    private T body;
    public StandardResponse() {
    }

    public StandardResponse(T body, String message) {
        this.message = message;
        this.body = body;
    }

    public StandardResponse(T body) {
        this.body = body;
    }

    public StandardResponse(String message, String description) {
        this.description = description;
        this.message = message;
    }
}

