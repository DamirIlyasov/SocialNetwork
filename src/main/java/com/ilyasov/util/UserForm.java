package com.ilyasov.util;

import com.ilyasov.model.enums.Sex;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;


public class UserForm {

    private static final String BLANK_MESSAGE = "This field is mandatory";

    @NotBlank(message = BLANK_MESSAGE)
    @Email
    private String email;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(min = 7, max = 20, message = "Password should be from 7 to 20 symbols")
    private String password;

    private Sex sex;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(max = 30 , min = 2, message = "Firstname should be from 2 to 30 symbols")
    private String firstName;

    @NotBlank(message = BLANK_MESSAGE)
    @Size(max = 30 , min = 2, message = "Lastname should be from 2 to 30 symbols")
    private String lastName;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

}
