package com.acat.java.mvvm;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> errorEmail = new MutableLiveData<>();
    public MutableLiveData<String> errorPassword = new MutableLiveData<>();

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    public LoginViewModel() {

    }

    public MutableLiveData<Integer> busy;
    public LiveData<Integer> getBusy() {
        if (busy==null) {
            busy = new MutableLiveData<>();
            busy.setValue(8); //8 = View.GONE
        }
        return busy;
    }

    private MutableLiveData<User> userMutableLiveData;
    public LiveData<User> getUser() {
        if (userMutableLiveData==null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void validateOnLoginClicked() {
        busy.setValue(0); //0 = View.VISIBLE
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User user = new User(email.getValue(), password.getValue());

                if (!user.isEmailValid()) {
                    errorEmail.setValue("Enter a valid Email Address");
                }
                else {
                    errorEmail.setValue(null);
                }

                if (!user.isPasswordGreaterThanFive()) {
                    errorPassword.setValue("Password length must be greater than 5");
                }
                else {
                    errorPassword.setValue(null);
                }
                userMutableLiveData.setValue(user);
                busy.setValue(8); //8 = View.GONE
            }
        }, 1000); //1000 = 1s
    }
}
