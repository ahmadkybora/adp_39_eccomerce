package com.example.adp_39_eccomerce.Validations;

import android.widget.Toast;

import com.example.adp_39_eccomerce.Auth.LoginController;

public class AuthValidation {
    public static boolean validateLogin(String username, String password) {
        if(username == null || username.trim().length() == 0) {
            return false;
        }

        if(password == null || password.trim().length() == 0) {
            return false;
        }

        return true;
    }

    public static boolean validateRegister(String username, Integer mobile, String password, String confirm_password) {
        if(username == null || username.trim().length() <= 2) {
            return  false;
        }
        if(mobile == null || mobile.longValue() < 12) {
            return false;
        }
        if(password == null || password.trim().length() < 8) {
            return false;
        }
        if(confirm_password == null || confirm_password.trim().length() < 8 || !confirm_password.equals(password)) {
            return false;
        }
        return true;
    }
}
