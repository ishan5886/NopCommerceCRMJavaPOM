package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

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
	
	
	public HomePageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
	    loginPage  = new LoginPage();
	    homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	

	@Test(priority=1)
	public void homePageTitleTest() throws InterruptedException {										
		String homePagetitle =  homePage.verifyHomePageTitle();
		Thread.sleep(10000);
		Assert.assertEquals(homePagetitle, "Dashboard / nopCommerce administration");
		System.out.println(homePagetitle);
	}
	

	@Test(priority=2)
	public void clickOnCustomersMenuTest() throws InterruptedException {
		
		homePage.clickOnCustomersMenu();
		Thread.sleep(10000);
	}
	
	
	@Test(priority=3)
	public void clickOnCustomersMenuItem() throws InterruptedException  {
		
//		homePage.clickOnCustomersMenu();
		Thread.sleep(10000);
		customersPage = homePage.clickOnCustomersMenuItem();
		Thread.sleep(15000);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
	
	
	
	


