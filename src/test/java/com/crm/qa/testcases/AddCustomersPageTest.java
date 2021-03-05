package com.crm.qa.testcases;


import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.AllureReportListener.AllureReportListener;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddCustomersPage;
import com.crm.qa.pages.CustomersPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

@Listeners(AllureReportListener.class)
public class AddCustomersPageTest extends TestBase {
	Logger log = Logger.getLogger(AddCustomersPageTest.class);
	
	LoginPage loginPage;
	HomePage homePage;
	CustomersPage customersPage;
	AddCustomersPage addCustomersPage;
	
	String sheetName = "Customer";
	
	
	public AddCustomersPageTest() {
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
	    addCustomersPage = customersPage.clickOnAddNewCustomer();
		
	}
	
	
	 public String random_generator() {
		 
		 log.info("****************************** Generating Random String *****************************************");
	    	
	    	// create a string of all characters
	        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	        // create random string builder
	        StringBuilder sb = new StringBuilder();

	        // create an object of Random class
	        Random random = new Random();

	        // specify length of random string
	        int length = 8;

	        for(int i = 0; i < length; i++) {

	          // generate random index number
	          int index = random.nextInt(alphabet.length());

	          // get character specified by index
	          // from the string
	          char randomChar = alphabet.charAt(index);

	          // append the character to string builder
	          sb.append(randomChar);
	        }

	        String randomString = sb.toString();
	        System.out.println("Random String is: " + randomString);
			return randomString;

	      }
	 
	 @DataProvider
	 public Object[][] getNopTestData() throws InvalidFormatException {
		 
		 log.info("****************************** starting Data Provider *****************************************");
		 Object data[][] = TestUtil.getTestData(sheetName);
		 return data;
	 }

	

	@Test(priority=1, dataProvider="getNopTestData")
	public void addCustomer(String pwd,String fn,String ln,String gen,String birthdate,String compname,
							String mgrofvendor,String admincontentt) throws InterruptedException {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** addCustomer *****************************************");
		
		String random_email = random_generator() + "@gmail.com";
		
		Thread.sleep(5000);
		addCustomersPage.setEmail(random_email);
		addCustomersPage.setPassword(pwd);
		addCustomersPage.setFirstName(fn);
		addCustomersPage.setLastName(ln);
		addCustomersPage.setGender(gen);
		addCustomersPage.setDob(birthdate);
		addCustomersPage.setCompanyName(compname);
		//addCustomersPage.setCustomerRoles(custroles);
		addCustomersPage.setManagerOfVendor(mgrofvendor);
		addCustomersPage.setAdminContent(admincontentt);
		addCustomersPage.clickOnSave();
		
		
		Thread.sleep(5000);
		
		String message = driver.findElement(By.tagName("body")).getText();
		
		if(message.contains("customer has been added successfully.")) {
			
			Assert.assertTrue(true, "test case passed");
			
		}
		
		else {
			
			Assert.fail("Failed test case");
			
			try {
				TestUtil.takeScreenshotAtEndOfTest();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			}
		}
		
	}
		
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
		log.info("****************************** Closing Browser *****************************************");
		
	}
	
	

}
	
	
	
	


