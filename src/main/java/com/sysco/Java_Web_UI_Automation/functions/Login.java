package com.sysco.Java_Web_UI_Automation.functions;

import com.sysco.Java_Web_UI_Automation.common.Constants;
import com.sysco.Java_Web_UI_Automation.pages.LoginPage;
import com.sysco.Java_Web_UI_Automation.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Login  {

    public static LoginPage ogmLoginPage = new LoginPage();


    public static void loadLoginPage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            ogmLoginPage.loadLoginPage(capabilities, Constants.APP_URL);
        } else {
            ogmLoginPage.loadLoginPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }


    public static void quiteDriver() {
        ogmLoginPage.quitDriver();
    }

    public static void loginToFtr() {

    }
}
