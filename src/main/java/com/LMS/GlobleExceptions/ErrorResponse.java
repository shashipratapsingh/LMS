package com.LMS.GlobleExceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ErrorResponse {
    // Getters and setters
    private int status;
    private String message;
    private Date timestamp;

    public ErrorResponse(int status, String message, Date timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

}