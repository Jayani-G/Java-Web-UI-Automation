package com.sysco.Java_Web_UI_Automation.pages;

import org.openqa.selenium.By;


public class MyAccountPage extends LoginPage {

    private By emailField = By.id("email");
    private By passwordFeild = By.id("pass");
    private By LoginBtn = By.xpath("//*[@id=\"send2\"]/span/span");
    private By emailAlert = By.id("advice-validate-email-email");
    private By emptyAlert = By.id("advice-required-entry-email");

    public void setLogin(String email, String password) {
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.sendKeys(emailField, email);
        syscoLabUIOgm.sleep(3);
        syscoLabUIOgm.sendKeys(passwordFeild, password);
        syscoLabUIOgm.sleep(2);
        syscoLabUIOgm.click(LoginBtn);
    }
        public String emailAlert () {
            return syscoLabUIOgm.getText(emailAlert);
        }
        public void clearEmailAndPassword () {
            syscoLabUIOgm.clear(emailField);
            syscoLabUIOgm.clear(passwordFeild);
        }
        public String emptyAlert(){
        return syscoLabUIOgm.getText(emptyAlert);
    }

}
