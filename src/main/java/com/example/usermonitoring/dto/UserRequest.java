package com.example.usermonitoring.dto;

import com.example.usermonitoring.validation.NationalCode;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank(message = "نام الزامی است")
    private String firstName;

    @NotBlank(message = "نام خانوادگی الزامی است")
    private String lastName;

    @NotBlank(message = "کد ملی الزامی است")
    @NationalCode
    private String nationalId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}