package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CustomersPage extends TestBase {
	
	@FindBy(xpath="//h1[@class='pull-left']//ancestor::div[@class='content-header clearfix']")
	WebElement customerPageLogo;
	
	@FindBy(xpath = "//a[@class='btn bg-blue']")
	WebElement btnAddNew;
	

	@FindBy(xpath = "//a[@href='#']//span[contains(text(),'Customers')]")
	WebElement customerMenu;
	
	//Initializing Page Objects
	public CustomersPage() 
		{
			PageFactory.initElements(driver, this);
		}
	
		
	public String verifyCustomerPageTitle() 
		{
		    	
		   return driver.getTitle(); 	
		}
	
	
	public String verifyCustomerPageLogo() 
	{
	    	
	   return customerPageLogo.getText();
	}
	
    public AddCustomersPage clickOnAddNewCustomer() 
    	{
    	
    		btnAddNew.click(); 
    		return new AddCustomersPage();
    		
    	}

    
}


    
    
    
    
