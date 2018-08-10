package com.sysco.Java_Web_UI_Automation.functions;

import com.sysco.Java_Web_UI_Automation.pages.MyAccountPage;


public class MyAccount {
    public static MyAccountPage myAccount = new MyAccountPage();

    public static void myAccountInvalidFunction(String email , String password) {
        myAccount.setLogin(email, password);
    }
    public static String emailAlert(){
        return myAccount.emailAlert();
    }
    public static void clearEmailAndPassword(){
        myAccount.clearEmailAndPassword();
    }
    public static String emptyAlert(){
        return myAccount.emptyAlert();
    }
    public static void myAccountValidFunction(String email, String password) {
        myAccount.setLogin(email,password);
    }
}
