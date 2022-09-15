package com.kainos.ea.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee{
    private short number;
    private String fname;
    private String lname;
    private String postcode;
    private String address;
    private String nin;
    private String bankAccount;
    private double startingSalary;
    private boolean isManager;
    private String department;

    public Employee(@JsonProperty("fname") String fname,
                @JsonProperty("lname") String lname,
                @JsonProperty("postcode") String postcode,
                @JsonProperty("address") String address,
                @JsonProperty("nin") String nin,
                @JsonProperty("bankAccount") String bankAccount,
        @JsonProperty("startingSalary") double startingSalary,
        @JsonProperty("isManager") boolean isManager,
        @JsonProperty("department") String department) {
            this.setFname(fname);
            this.setLname(lname);
            this.setPostcode(postcode);
            this.setAddress(address);
            this.setNin(nin);
            this.setBankAccount(bankAccount);
            this.setStartingSalary(startingSalary);
            this.setIsManager(isManager);
            this.setDepartment(department);
        }


    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(double startingSalary) {
        this.startingSalary = startingSalary;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(boolean manager) {
        isManager = manager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int calcPay(){
        return (int) (getStartingSalary () / 12);
    }

    @Override
    public String toString(){
        String message =
                String.format("Employee %d: %s, %s, £%,.2f. "
                        ,
                        getNumber(), getFname(), getLname(), (float) getStartingSalary ());
        return message;
    }




}

