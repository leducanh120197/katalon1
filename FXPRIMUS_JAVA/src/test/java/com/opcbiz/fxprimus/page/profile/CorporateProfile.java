package com.opcbiz.fxprimus.page.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.page.BaseModel;

public class CorporateProfile extends BaseModel {

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
	
	
	public void inputData() {
		
	}

	public CorporateProfile(WebDriver webDriver) {
		super(webDriver);
	}

}
