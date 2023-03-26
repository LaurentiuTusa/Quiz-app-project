package com;

import com.presenter.LoginPresenter;

import com.view.*;

public class Main {

    public static void main(String[] args){

        LoginPresenter loginPresenter= new LoginPresenter(new LoginView());

    }
}
