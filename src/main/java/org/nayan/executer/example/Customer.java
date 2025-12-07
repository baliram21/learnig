package org.nayan.executer.example;

public class Customer {
    private String name;
    private Long mobile;
    private String email;
    private String policyNumber;

    private Double policyAmount;
    private String message;

    public Customer(String name, Long mobile, String email, String policyNumber, Double policyAmount) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.policyNumber = policyNumber;
        this.policyAmount = policyAmount;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Double getPolicyAmount() {
        return policyAmount;
    }

    public void setPolicyAmount(Double policyAmount) {
        this.policyAmount = policyAmount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", policyAmount=" + policyAmount +
                ", message='" + message + '\'' +
                '}';
    }
}
