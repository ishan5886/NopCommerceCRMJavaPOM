package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.AllureReportListener.AllureReportListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(AllureReportListener.class)
public class LoginPageTest extends TestBase{
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		log.info("******************************Starting test case execution************************");
		
		initialization();
		loginPage =  new LoginPage();
	}
	
	

	@Test(priority=1, description="Verifying Login Page Title Test")  //description from testng
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Login Page Title")  //description from allure reports
	public void loginPageTitleTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** loginPageTitleTest *****************************************");
		String title = loginPage.validateLoginPageTitle();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals(title, "Your store. Login");
		System.out.println(title);
	}
	

	@Test(priority=2)
	public void AdminAreaLogoTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** AdminAreaLogoTest *****************************************");
		String logo = loginPage.validateAdminAreaLogo();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals(logo, "Admin area demo");
		
		System.out.println(logo);
	}
	
	
	@Test(priority=3)
	public void loginTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** loginTest *****************************************");
	
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		log.info("****************************** Browser is Closed *****************************************");
	}
	
	

}
