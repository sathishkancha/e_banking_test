package com.e_banking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.e_banking.pageObjects.LoginPage;

public class TC_LoginTest_001  extends BaseClass{
	
	@Test
	public void loginTest() throws IOException{
		logger.info("Login test is starting");	
		driver.get(baseUrl);
		logger.info("url is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("username typed");
		lp.setPassword(password);
		logger.info("password typed");
		lp.clickSubmit();
		logger.info("loggin button clicked");
	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("title assertion passed");
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver,"loginTest");
			logger.info("title assertion failed");
		}
		logger.info("login Testcase is done");
	}

}
