package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

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
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateAdminAreaLogo() {
		
		return adminlogo.getText();
		
	}
	
	public HomePage login(String em, String pwd) {
		
		email.clear();
		
		email.sendKeys(em);
		
		password.clear();
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	
	
	
	
	

}
