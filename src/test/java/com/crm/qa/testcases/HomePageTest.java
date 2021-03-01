package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CustomersPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CustomersPage customersPage;
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	
	public HomePageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		
		log.info("******************************Starting test case execution************************");
		
		initialization();
	    loginPage  = new LoginPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	

	@Test(priority=1)
	public void homePageTitleTest() throws InterruptedException {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** homePageTitleTest *****************************************");
		String homePagetitle =  homePage.verifyHomePageTitle();
		Thread.sleep(10000);
		Assert.assertEquals(homePagetitle, "Dashboard / nopCommerce administration");
		System.out.println(homePagetitle);
	}
	

	@Test(priority=2)
	public void clickOnCustomersMenuTest() throws InterruptedException {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** clickOnCustomersMenuTest *****************************************");
		
		homePage.clickOnCustomersMenu();
		Thread.sleep(10000);
	}
	
	
	@Test(priority=3)
	public void clickOnCustomersMenuItem() throws InterruptedException  {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** clickOnCustomersMenuItemTest *****************************************");
		
		
//		homePage.clickOnCustomersMenu();
		Thread.sleep(10000);
		customersPage = homePage.clickOnCustomersMenuItem();
		Thread.sleep(15000);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		log.info("****************************** Closing Browser*****************************************");
		
	}
	
	

}
	
	
	
	


