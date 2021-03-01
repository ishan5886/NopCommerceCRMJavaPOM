package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//li[@class='account-info']//ancestor::ul[@class='nav navbar-nav']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//span[@class='menu-item-title'][contains(text(),'Customers')]")
	WebElement customerMenuItem;
	

	@FindBy(xpath = "//a[@href='#']//span[contains(text(),'Customers')]")
	WebElement customerMenu;
	
	//Initializing Page Objects
	public HomePage() 
		{
			PageFactory.initElements(driver, this);
		}
	
		
	public String verifyHomePageTitle() 
		{
		    	
		   return driver.getTitle(); 	
		}
	
    public void clickOnCustomersMenu() 
    	{
    	
    	 customerMenu.click(); 	
    	}

    
    public CustomersPage clickOnCustomersMenuItem() 
    {
    	
    	 customerMenu.click();
    	 customerMenuItem.click(); 	
    	 return new CustomersPage();
    }

    
}


    
    
    
    