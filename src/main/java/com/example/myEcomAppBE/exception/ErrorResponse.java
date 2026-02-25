package com.example.myEcomAppBE.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int responseCode;
    private String message;
    private LocalDateTime timeStamp;

    public ErrorResponse(int responseCode, String message, LocalDateTime timeStamp){
        this.responseCode = responseCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
