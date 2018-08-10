package com.sysco.Java_Web_UI_Automation.tests;


import com.sysco.Java_Web_UI_Automation.functions.Login;
import com.sysco.Java_Web_UI_Automation.functions.MyAccount;
import com.sysco.Java_Web_UI_Automation.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
    }

    @Test
    public void testLogin() throws Exception {

        SoftAssert softAssert = new SoftAssert();
        // Sample way to retrive data from excel
       // LoginData loginData = ExcelUtil.getLoginData("$as238l");

        //UI Automation  sample
        Login.loadLoginPage();

        Login.setBdayTwo();
        softAssert.assertEquals(Login.getErrorMessage(), "Sorry, your age or location does not permit you to enter at this time.");
        Login.setBdayOne();
        Login.clickMyAccount();
        softAssert.assertAll();
    }
        @Test(description = "verify invalid email and password", dependsOnMethods = "testLogin")
        public void invaliedEmailPassward () throws Exception {
            SoftAssert softAssert = new SoftAssert();
            MyAccount.myAccountInvalidFunction("jacob", "12345678");
            softAssert.assertEquals(MyAccount.emailAlert(), "Please enter a valid email address. For example johndoe@domain.com.");
            MyAccount.clearEmailAndPassword();
            softAssert.assertAll();
        }


        @Test(description = "verify invalied email", dependsOnMethods = "testLogin")
        public void invaliedEmail () throws Exception {
            SoftAssert softAssert = new SoftAssert();
            MyAccount.myAccountInvalidFunction("jacob.A@com", "abc");
            softAssert.assertEquals(MyAccount.emailAlert(), "Please enter a valid email address. For example johndoe@domain.com.");
            MyAccount.clearEmailAndPassword();
            softAssert.assertAll();
        }
        @Test(description = "verify valid email and password", dependsOnMethods = "invaliedEmailPassward")
        public void valiedEmailPassward() throws Exception {
            SoftAssert softAssert = new SoftAssert();
            MyAccount.myAccountValidFunction("williamjacob802@gmail.com", "12345678");
            softAssert.assertAll();
    }

}