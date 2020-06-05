package com.learnings.exceptions.models.ui.restmodels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BankBranchDetailsRequest {

    @NotNull(message = "IFSC code cannot be Empty")
    @Size(min = 11,max = 11,message = "IFSC code cannot be less than or greater then 11 characters")
    private String ifscCode;
    @NotNull(message = "Bank Id cannot be empty")
    private String bankId;
    @NotNull(message = "BankBranch cannot be empty")
    @Size(min = 2 , message = "Bank Branch need to greater than 2 characters")
    private String bankBranch;
    @NotNull(message = "Branch Address cannot be Empty")
    @Size(max=150)
    private String branchAddress;
    @NotNull(message = "City cannot be Empty")
    private String city;
    @NotNull(message = "District cannot be Empty")
    private String district;
    @NotNull(message = "State cannot be Empty")
    private String state;
    @NotNull(message = "Bank Name cannot be Empty")
    private String bankName;

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
