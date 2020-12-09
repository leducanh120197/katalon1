package com.opcbiz.fxprimus.page.authentication;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.uniqueuser.ExistEmailCheckIdDto;
import com.opcbiz.fxprimus.dto.uniqueuser.ExistEmailDto;
import com.opcbiz.fxprimus.page.BaseModel;

public class AffiliateRegisterPageModel extends BaseModel{
	//mat-select-0 id acctype
	@FindBy(id = "mat-select-0")
	WebElement accountType;
	
	@FindBy(id = "referral_id")
	WebElement referredId;

	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(xpath = "//*[contains(text(),'Username exist')]")
	WebElement emailUsernameExist;
	
	//id="username"
	
	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "last_name")
	WebElement lastName;

	//id="web_url"
	
	@FindBy(id = "mat-select-1")
	WebElement country;
	
	@FindBy(id = "mat-input-11")
	WebElement findCountry;
	
	@FindBy(id = "phone_number")
	WebElement phoneNumber;

	@FindBy(id = "mat-checkbox-1")
	WebElement checkboxRP;
	
	@FindBy(xpath = "//mat-checkbox[@formcontrolname='kid_policy']")
	WebElement checkboxKID;
	
	

	@FindBy(xpath = "//form/button")
	WebElement buttonProceed;
	
	public void load() {
		this.webDriver.get(UrlConstant.AFILIATE_REGISTER_PAGE);
	}
	
	public String getEmailUsernameExistValidationMesssage() {
		try {
			return emailUsernameExist.getText();
		} catch (Exception e) {
			return "";
		} 
	}
	
	public void setAccountType(String accountType) {
		click(this.accountType);
		String xpath = "//mat-option/span[contains(text(),'" + accountType + "')]";
		this.webDriver.findElement(By.xpath(xpath)).click();
    }
	
	public void setReferredId(String referredId) {
        type(this.referredId, referredId);
    }

    public void setEmail(String email) {
    	this.email.clear();
		type(email, this.email);
		type(firstName,"");
		iwait(Constant.ONESEC);
    }

    public void setPassword(String password) {
        type(this.password, password);
    }

    public void setFirstName(String firstName) {
        type(this.firstName, firstName);
    }

    public void setLastName(String lastName) {
        type(this.lastName, lastName);
    }

    public void setCountry(String country) {
    	click(this.country, 500);
		type(country, this.findCountry);
		WebElement webElementOption = this.webDriver
				.findElement(By.xpath("//mat-option/span[contains(text(),'" + country + "')]"));
		this.waitNClick(webElementOption);
    }

    public void setPhoneNumber(String phoneNumber) {
        type(this.phoneNumber, phoneNumber);
    }

    public void setCheckboxRP() {
        click(this.checkboxRP);
    }
    public void setCheckboxKID() {
        click(this.checkboxKID);
    }

    public void setButtonProceed() {
    	click(this.buttonProceed,Constant.FIVESEC);
    }
    public void inputData(ExistEmailDto existEmailDto) {
    	setAccountType(existEmailDto.getAccountType());
    	//setReferredId(existEmailDto.getPartnersReferredId());
    	setEmail(existEmailDto.getEmail());
    	setPassword(existEmailDto.getPassword());
    	setFirstName(existEmailDto.getFirstName());
    	setLastName(existEmailDto.getLastName());
    	setCountry(existEmailDto.getCountry());
    	setPhoneNumber(existEmailDto.getPhoneNumber());
    	List<String> displayop = Arrays.asList(existEmailDto.
				getDisplayCheckboxValidation().split(","));
//		if(displayop.contains("CA"))
		if(displayop.contains("KID"))
			setCheckboxKID();
		if(displayop.contains("RP"))
			setCheckboxRP();
    	setButtonProceed();
    	
    }
    
    public boolean checkExistEmail(String expected) {
    	String actual = getEmailUsernameExistValidationMesssage();
    	return actual.contains(expected);
    }
    
    public void inputDataForCheck(ExistEmailCheckIdDto existEmailCheckIdDto) {
    	setAccountType(existEmailCheckIdDto.getAccountType());
    	setCountry(existEmailCheckIdDto.getCountry());
    	setEmail(existEmailCheckIdDto.getEmail());
    }
	public AffiliateRegisterPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public boolean isDisplayed() {
		if(this.getTitle().contains(Constant.AFFILIATE_REG)) {
			return true;
		}
		return false;
	}
	public boolean isDisplayed(long timer) {
		for(int i =0; i < timer; i+= 500) {
			log("check after "+ i + "millisecs ");
			if(this.getTitle().contains(Constant.AFFILIATE_REG)) {
				return true;
			}
		}
		return false;
	}

}
