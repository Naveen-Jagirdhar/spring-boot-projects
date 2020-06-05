package com.learnings.exceptions.models.ui.restmodels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BankDetails {

    @NotNull(message = "Bank Name cannot be Empty")
    @Size(min = 3 , max = 150 , message = "Bank Name Attribute should range  between 3 and 150")
    private String bankName;

    @NotNull(message = "Bank Id cannot be Empty")
    private String bankId;

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
