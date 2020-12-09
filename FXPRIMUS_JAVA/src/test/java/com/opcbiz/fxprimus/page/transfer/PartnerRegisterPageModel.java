package com.opcbiz.fxprimus.page.transfer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.qa19.PartnerDto;
import com.opcbiz.fxprimus.page.BaseModel;

public class PartnerRegisterPageModel extends BaseModel {

	// input fields
	@FindBy(id = "mat-select-0")
	WebElement accountType;

	@FindBy(id = "email")
	WebElement emailAddress;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "web_url")
	WebElement webUrl;

	@FindBy(id = "mat-select-1")
	WebElement country;

	@FindBy(xpath = "//*[@placeholder=\"Search Country\"]")
	WebElement findCountry;

	@FindBy(id = "phone_number")
	WebElement phoneNumber;

	@FindBy(id = "skypeID")
	WebElement skypeId;

	@FindBy(xpath = "//*[@id=\"mat-checkbox-1\"]/label")
	WebElement promotions;

	// actions
	@FindBy(xpath = "//form/button")
	WebElement proceed;

	// other
	WebElement loginBtn;
	WebElement languageBtn;
	WebElement trader;
	WebElement affiliate;
	WebElement introducingBroker;

	public PartnerRegisterPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public void loadRegisterPartner(String type, String referralId) {
		if(type.contains(Constant.PARTNER_TYPE_AFFILIATE)) {
			this.webDriver.get(UrlConstant.PARTNER_AFFILIATE_REFERRAL_LINK + referralId);
		}
		else {
			this.webDriver.get(UrlConstant.PARTNER_IB_REFERRAL_LINK + referralId);
		}
	}


	public void inputData(PartnerDto partnerDto) {
		setAccountType(partnerDto.getAccountType());
		setEmailAddress(partnerDto.getEmailAddress());
		setPassword(partnerDto.getPassword());
		setFirstName(partnerDto.getFirstName());
		setLastName(partnerDto.getLastName());
		setCountry(partnerDto.getCountry());
		setPhoneNumber(partnerDto.getPhoneNumber());
		setReadAndAccept();
//		try {
//			setWebUrl(partnerDto.getWebsiteUrl());
//			setSkypeId(partnerDto.getSkypeId());
//		} catch (Exception e) {
//		}
	}

	/**
	 * method set data to input field account type
	 */
	public void setAccountType(String accountType) {
		click(this.accountType);
		String xpath = "//mat-option/span[contains(text(),\"" + accountType + "\")]";
		this.webDriver.findElement(By.xpath(xpath)).click();
	}

	/**
	 * method set data to input field email address
	 */
	public void setEmailAddress(String emailAddress) {
		type(emailAddress, this.emailAddress);
	}

	/**
	 * method set data to input field password
	 */
	public void setPassword(String password) {
		type(password, this.password);
	}

	/**
	 * method set data to input field first name
	 */
	public void setFirstName(String firstName) {
		type(firstName, this.firstName);
	}

	/**
	 * method set data to input field last name
	 */
	public void setLastName(String lastName) {
		type(lastName, this.lastName);
	}

	/**
	 * method set data to input field website url
	 */
	public void setWebUrl(String webUrl) {
		type(webUrl, this.webUrl);
	}

	/**
	 * method set data to input field country
	 */
	public void setCountry(String country) {
		click(this.country, 500);
		type(country, this.findCountry);
		WebElement webElementOption = this.webDriver
				.findElement(By.xpath("//mat-option/span[contains(text(),\"" + country + "\")]"));
		this.waitNClick(webElementOption);
	}

	/**
	 * method set data to input field phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		iwait(1000);
		type(phoneNumber, this.phoneNumber);
	}

	/**
	 * method set data to input field skype
	 */
	public void setSkypeId(String skypeId) {
		type(skypeId, this.skypeId);
	}

	/**
	 * method click to input checkbox read and accept client agreement
	 */
	public void setReadAndAccept() {
		click(this.promotions);
	}

	public void clickProceed() {
		this.proceed.click();
	}
}
