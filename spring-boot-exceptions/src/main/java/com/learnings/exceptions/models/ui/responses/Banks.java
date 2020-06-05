package com.learnings.exceptions.models.ui.responses;

public class Banks {

    private String bankNo;
    private String bankName;
    private String bankId;

    public Banks() {
    }

    public Banks(String bankNo, String bankName, String bankId) {
        this.bankNo = bankNo;
        this.bankName = bankName;
        this.bankId = bankId;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
}
