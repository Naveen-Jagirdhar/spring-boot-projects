package com.learnings.exceptions.utils;

import java.util.Date;
import java.util.List;

public class ErrorResponse {

    private List<String> message;
    private Date timeStamp;

    public ErrorResponse(List<String> message, Date timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
