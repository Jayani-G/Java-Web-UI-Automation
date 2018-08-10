package com.sysco.Java_Web_UI_Automation.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class LoginPage {
    protected static SyscoLabUI syscoLabUIOgm;
    private By txtGoogleSearch = By.id("lst-ib");
    private By myAccount = By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul/li");
    private By txtUN = By.id("email");
    private By txtPW = By.id("pass");
    private By btnLogin = By.id("send2");
    private By btnYes = By.id("send2");


    public static void loadLoginPage(Capabilities capabilities, String url) {
        syscoLabUIOgm = new SyscoLabWUI(capabilities);
        syscoLabUIOgm.navigateTo(url);
        syscoLabUIOgm.driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (syscoLabUIOgm != null) {
            syscoLabUIOgm.quit();
        }
    }


    public void enterText(String searchString) {
        syscoLabUIOgm.sendKeys(txtGoogleSearch, searchString);
    }

}
