package com.learnings.exceptions.models.ui.responses;

public class BankApiResponse {

    private String message;

    public BankApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
