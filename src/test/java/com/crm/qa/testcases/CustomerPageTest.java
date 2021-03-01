package com.crm.qa.testcases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddCustomersPage;
import com.crm.qa.pages.CustomersPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CustomerPageTest extends TestBase {
	
	Logger log = Logger.getLogger(CustomerPageTest.class);
	
	LoginPage loginPage;
	HomePage homePage;
	CustomersPage customersPage;
	AddCustomersPage addCustomersPage;
	
	
	public CustomerPageTest() {
		super();
	}
		
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		log.info("******************************Starting test case execution************************");
		
		initialization();
		customersPage = new CustomersPage();
	    loginPage  = new LoginPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    customersPage = homePage.clickOnCustomersMenuItem();
		
	}
	
	

	@Test(priority=1)
	public void CustomersPageTitleTest() throws InterruptedException {	
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** CustomersPageTitleTest *****************************************");
		String custPagetitle =  customersPage.verifyCustomerPageTitle();
		Thread.sleep(10000);
		Assert.assertEquals(custPagetitle, "Customers / nopCommerce administration");
		System.out.println(custPagetitle);
	}
	

	@Test(priority=2)
	public void CustomersPageLogoTest() throws InterruptedException {	
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** CustomersPageLogoTest *****************************************");
		String custPagelogo =  customersPage.verifyCustomerPageLogo();
		Thread.sleep(10000);
		Assert.assertEquals(custPagelogo, "Customers");
		System.out.println(custPagelogo);
	}
	
	
	@Test(priority=3)
	public void clickOnAddNewCustomerTest() throws InterruptedException  {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** clickOnAddNewCustomerTest *****************************************");
		addCustomersPage = customersPage.clickOnAddNewCustomer();
		Thread.sleep(15000);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		log.info("****************************** Closing Browser*****************************************");
		driver.quit();
	}
	
	

}
	
	
	
	


