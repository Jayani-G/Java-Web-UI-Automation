package com.sysco.Java_Web_UI_Automation.tests;

import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.sysco.Java_Web_UI_Automation.functions.AgeValidation;
import com.sysco.Java_Web_UI_Automation.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class AgeValidationTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "SiteLoading - ValidLogin");
        AgeValidation.navigateToUrl();
    }

    @AfterClass
    public void afterClass() {
        AgeValidation.quiteDriver();
    }


    @Test(description = "OGM-0002", alwaysRun = true)
    public void testLoginWithOutBirthDay(SoftAssert softAssert) {
        softAssert = new SoftAssert();

        AgeValidation.clickbtnEnter();


        softAssert.assertAll();
    }

    @Test(description = "OGM-0003", dependsOnMethods = "testLoginWithOutBirthDay", alwaysRun = true)
    public void testLoginWithInvalidAge() {
        SoftAssert softAssert = new SoftAssert();

        AgeValidation.setDate();
        AgeValidation.setMonth();
        AgeValidation.setInvalidYear();
        AgeValidation.clickbtnEnter();


        softAssert.assertAll();
    }

    @Test(description = "OGM-0004", dependsOnMethods = "testLoginWithInvalidAge", alwaysRun = true)
    public void testLoginWithValidAge() {
        SoftAssert softAssert = new SoftAssert();

        AgeValidation.setDate();
        AgeValidation.setMonth();
        AgeValidation.setValidYear();
        AgeValidation.clickbtnEnter();

    }

}

