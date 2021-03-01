package com.crm.qa.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class AddCustomersPage extends TestBase {


	@FindBy(xpath="//input[@id='Email']")
	WebElement custEmail;   			
	
	@FindBy(xpath= "//input[@id='Password']")
	WebElement custpassword;   	
	
	
	@FindBy(xpath= "//*[@id='SelectedCustomerRoleIds_taglist']//ancestor::div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement customerroles;
	
	@FindBy(xpath= "//li[contains(text(),'Administrators')]")
	WebElement lstitemAdministrators;
	
	@FindBy(xpath= "//li[contains(text(),'Registered')]")
	WebElement lstitemRegistered;
	
	@FindBy(xpath="//*[@id='SelectedCustomerRoleIds_taglist']/li[]/span[2]")
	WebElement deleterole;
	
	@FindBy(xpath= "//li[contains(text(),'Guests')]")
	WebElement lstitemGuests;
	
	@FindBy(xpath= "//li[contains(text(),'Vendors')]")
	WebElement lstitemVendors;
	
	@FindBy(xpath= "//*[@id='VendorId']")
	WebElement drpmgrOfVendor;
	
	@FindBy(id= "Gender_Male")
	WebElement malegender;
	
	@FindBy(id= "Gender_Female")
	WebElement femalegender;
	
	@FindBy(xpath= "//input[@id='FirstName']")
	WebElement firstname;
	
	
	@FindBy(xpath= "//input[@id='LastName']")
	WebElement lastname;
	
	@FindBy(xpath= "//input[@id='DateOfBirth']")
	WebElement dateofbirth;
	
	@FindBy(xpath= "//input[@id='Company']")
	WebElement companyname;
	
	@FindBy(xpath=  "//textarea[@id='AdminComment']")
	WebElement admincontent;
	
	@FindBy(xpath=  "//button[@name='save']")
	WebElement savebtn;
	
	 
	
	//Initializing Page Objects
	public AddCustomersPage() 
		{
			PageFactory.initElements(driver, this);
		}
	
		
//	public String verifyCustomerPageTitle() 
//		{
//		    	
//		   return driver.getTitle(); 	
//		}
	
	

    public void setEmail(String email) {
    	
    	custEmail.sendKeys(email);
    	
    }
        

    public void setPassword(String password) {
    	
    	custpassword.sendKeys(password);
    }
        

   /* public void setCustomerRoles(String role) throws InterruptedException {
    	
    	
    	customerroles.click();
        Thread.sleep(3000);
        WebElement listitem;
        
		if(role=="Registered") 
        {
        	 listitem = lstitemRegistered;
        	 
        	
        }
           
        else if(role=="Administrators") {
        	
        	listitem = lstitemAdministrators;
        	
        }
   
        else if(role=="Guests") {
        	
        	// Here user can be Registered( or) Guest, only one
        	
        	
        	Thread.sleep(10000);
        
        	
        	deleterole.click();
      	
        	listitem = lstitemGuests;  
        	
        	
        	
        }
          
           
        else if(role=="Registered") {
        	
        	listitem = lstitemRegistered;
        	
        
        }
            
        else if(role=="Vendors") {
        	
        	listitem = lstitemVendors;
        	
        }
            
        else {
        	
        	 listitem = lstitemGuests;
     
        }
        
 
//        
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", listitem);
    	
    }*/
        

    public void setManagerOfVendor(String value) {
    	
    	Select drp= new Select(drpmgrOfVendor);
    	drp.selectByVisibleText(value);
    	
    }
        
    

    public void setGender(String gender) {

    	
        if(gender=="Male") {
        	
        	malegender.click();
        }
            
        else if(gender=="Female") {
        	
        	femalegender.click();
        	
        }
        else {
        	
        	malegender.click();
        }
          

    }

    public void setFirstName(String fname) {
    	
    	firstname.sendKeys(fname);
    }
    	

    public void setLastName(String lname) {
    	
    	lastname.sendKeys(lname);
    }
    	

    public void setDob(String dob) {
       dateofbirth.sendKeys(dob);
    }
    
    public void setCompanyName(String comname) {
        companyname.sendKeys(comname);
    }
    

    public void setAdminContent(String content) {
    	admincontent.sendKeys(content);
    }

    public void clickOnSave() {
    	savebtn.click();
    }
        
    
       	
    	
    }


    
    
    
    
