package com.acat.java.mvvm;

import android.util.Patterns;

public class User {

    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        if (email==null) {
            return "";
        }
        return email;
    }

    public String getPassword() {
        if (password==null) {
            return "";
        }
        return password;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }

    public boolean isPasswordGreaterThanFive() {
        return getPassword().length() > 5;
    }

    public boolean isValidationSuccess() {
        return isEmailValid()&&isPasswordGreaterThanFive();
    }
}
