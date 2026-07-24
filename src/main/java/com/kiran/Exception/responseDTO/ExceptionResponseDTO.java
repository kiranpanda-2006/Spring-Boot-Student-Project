package com.kiran.Exception.responseDTO;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ExceptionResponseDTO {

    private LocalTime timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ExceptionResponseDTO(LocalTime timeStamp, int status, String error, String message,String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
