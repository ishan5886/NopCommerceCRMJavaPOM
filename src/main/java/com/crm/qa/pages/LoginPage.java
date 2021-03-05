package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{
	
	//Page Factory - Object Repository
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="Password")
	WebElement password;
	
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//h1//ancestor::div[@class='page-title']")
	WebElement adminlogo;
	
	
	
	//Initializing Page Objects
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	@Step("getting login page title method")
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateAdminAreaLogo() {
		
		return adminlogo.getText();
		
	}
	
	@Step("login with username: {0} and password: {1 }")  //{0} will enter username in Allure Reports and {1} will enter password
	public HomePage login(String em, String pwd) {
		
		email.clear();
		
		email.sendKeys(em);
		
		password.clear();
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	
	
	
	
	

}
