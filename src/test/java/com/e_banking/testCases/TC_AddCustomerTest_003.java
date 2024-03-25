package com.e_banking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.e_banking.pageObjects.LoginPage;
import com.e_banking.pageObjects.AddCustomerPage;
public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		logger.info("test case add customer getting executed");
		LoginPage lp=new LoginPage(driver);
		driver.get(baseUrl);
		lp.setUserName(userName);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(10000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		driver.manage().window().maximize();
		
		logger.info("providing customer details....");
		Thread.sleep(3000);
		
		addcust.custName("Abhi");
		addcust.custgender("male");
		addcust.custdob("10","15","2001");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		logger.info("test case add customer done");
	}
	
	
}
