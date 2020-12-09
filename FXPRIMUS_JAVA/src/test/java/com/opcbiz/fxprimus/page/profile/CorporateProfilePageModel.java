package com.opcbiz.fxprimus.page.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.page.BaseModel;

public class CorporateProfilePageModel extends BaseModel {

	//Director
	
	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "background")
	WebElement background;

	@FindBy(id = "license")
	WebElement license;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "zip")
	WebElement zip;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "dateOfBirth")
	WebElement dateOfBirth;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "phoneNumber")
	WebElement phoneNumber;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "gender")
	WebElement gender;
	
	@FindBy(xpath = "//mat-option[@role='option']/span[contains(text(),'Male')]")
	WebElement optionMale;
	
	@FindBy(id = "country")
	WebElement country;
	
	@FindBy(xpath = "//*[contains(@placeholder,'Search Country')]")
	WebElement searchCountry;
	
	@FindBy(xpath = "//mat-option[@role='option']/span[text()=' Jordan ']")
	WebElement optionCountry;
	
	@FindBy(xpath = "//app-director//button[@type='submit']")
	WebElement directorSubmit;
	
	@FindBy(xpath = "//app-share-holder//*[@id='firstName'")
	  WebElement shareHolderFirstName;

	  @FindBy(xpath = "//app-share-holder//*[@id='background'")
	  WebElement shareHolderBackground;

	  @FindBy(xpath = "//app-share-holder//*[@id='license'")
	  WebElement shareHolderLicense;

	  @FindBy(xpath = "//app-share-holder//*[@id='lastName'")
	  WebElement shareHolderLastName;

	  @FindBy(xpath = "//app-share-holder//*[@id='zip'")
	  WebElement shareHolderZip;

	  @FindBy(xpath = "//app-share-holder//*[@id='state'")
	  WebElement shareHolderState;

	  @FindBy(xpath = "//app-share-holder//*[@id='address'")
	  WebElement shareHolderAddress;

	  @FindBy(xpath = "//app-share-holder//*[@id='username'")
	  WebElement shareHolderUsername;

	  @FindBy(xpath = "//app-share-holder//*[@id='dateOfBirth'")
	  WebElement shareHolderDateOfBirth;

	  @FindBy(xpath = "//app-share-holder//*[@id='password'")
	  WebElement shareHolderPassword;

	  @FindBy(xpath = "//app-share-holder//*[@id='phoneNumber'")
	  WebElement shareHolderPhoneNumber;

	  @FindBy(xpath = "//app-share-holder//*[@id='city'")
	  WebElement shareHolderCity;

	  @FindBy(xpath = "//app-share-holder//*[@id='email'")
	  WebElement shareHolderEmail;
	  
	  @FindBy(xpath = "//app-share-holder//*[@id='gender'")
	  WebElement shareHolderGender;
	  
	  @FindBy(xpath = "//mat-option[@role='option']/span[contains(text(),'Male')]'")
	  WebElement shareHolderOptionMale;
	  
	  @FindBy(xpath = "//app-share-holder//*[@id='country'")
	  WebElement shareHolderCountry;
	  
	  
	  @FindBy(xpath = "//app-share-holder//button[@type='submit']'")
	  WebElement shareHolderSubmit;
	
	public void inputData() {
		//Alex 	Ander	Oct 5, 1992	Male	Jordan	Amman	Anmic	12 ahac	123	14567899	abc@cbe.com.vn	UE	10
		type("Alex", firstName);
		type("Ander", lastName);
		
		click(dateOfBirth);
		WebElement webElement = webDriver.findElement(By.xpath("(//*[@id='mat-datepicker-0']//td/div)[1]"));
		click(webElement);
		
		click(gender);
		click(optionMale);
		type("Jordan", searchCountry);
		click(optionCountry);
		
		type("Amman", city);
		type("Anmic", state);
		type("12 ahac", address);
		type("123", zip);
		
		type("14567899", phoneNumber);
		
		type("a"+System.currentTimeMillis()+"@gmail.com", email);
		type("UE", license);
		type("10", background);
		
		click(directorSubmit);
		
	    type("Alex", shareHolderFirstName);
	    type("Ander", shareHolderLastName);
	    
	    click(shareHolderDateOfBirth);
	    webElement = webDriver.findElement(By.xpath("(//*[@id='mat-datepicker-0']//td/div)[1]"));
	    click(webElement);
	    
	    click(shareHolderGender);
	    click(optionMale);
	    type("Jordan", searchCountry);
	    click(optionCountry);
	    
	    type("Amman", shareHolderCity);
	    type("Anmic", shareHolderState);
	    type("12 ahac", shareHolderAddress);
	    type("123", shareHolderZip);
	    
	    type("14567899", shareHolderPhoneNumber);
	    
	    type("a"+System.currentTimeMillis()+"@gmail.com", shareHolderEmail);
	   
	    
	    click(shareHolderSubmit);
		
	}

	public CorporateProfilePageModel(WebDriver webDriver) {
		super(webDriver);
	}

}
