package com.opcbiz.fxprimus.page.authentication;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.uniqueuser.EmailVerificationDto;
import com.opcbiz.fxprimus.page.BaseModel;
import com.opcbiz.fxprimus.page.email.GooglePageModel;

public class EmailVarificationPageModel extends BaseModel {

	

	@FindBy(id = "digitCode")
	WebElement digitCode;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement verifyMail;

	@FindBy(xpath = "//p[@class='ng-star-inserted']/span")
	WebElement digitCodeValidation;

	public EmailVarificationPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * method to check page is displayed
	 */
	public boolean isDisplayed() {
		if(this.getTitle().contains(Constant.VERIFICATION)) {
			return true;
		}
		return false;
	}
	
	public boolean isDisplayed(long timer) {
		for(int i =0; i < timer; i+= 500) {
			log("check after "+ i + "millisecs ");
			iwait(500);
			if(this.getTitle().contains(Constant.VERIFICATION)) {
				return true;
			}
		}
		return false;
	}
	
	
	public String getDigitCodeValidation() {
		return this.digitCodeValidation.getText();
	}

	public String getVerifyMailValidation() {
		if (this.verifyMail.isEnabled())
			return Constant.ACTIVE;
		return Constant.INACTIVE;
	}

	public void action(String pin) {
		clear(digitCode);
		type(pin, this.digitCode);// type key
		click(verifyMail,5000);
		
	}
	
	public void action() {
		type(Keys.BACK_SPACE, this.digitCode);// type key
		click(verifyMail,5000);
		
	}

	public void inputData(EmailVerificationDto emailVerificationDto) {
		type("#",this.digitCode);
		this.digitCode.clear();
		type(emailVerificationDto.getUniquePin(), this.digitCode);
		//click(verifyMail);
	}
	
	public void inputDataAndRegister(EmailVerificationDto emailVerificationDto) {
		type("#",this.digitCode);
		this.digitCode.clear();
		type(emailVerificationDto.getUniquePin(), this.digitCode);
		click(verifyMail);
	}

	/**
	 * method check validation message in unique pin field with expectation
	 */
	public boolean isValidUniquePin(EmailVerificationDto emailVerificationDto) {
		log(emailVerificationDto.getUniquePinValidation());
		if(emailVerificationDto.getId().equals("EV_003")) {
			if(6==this.digitCode.getAttribute("value").length()) {
				return true;
			}
			return false;
		}
		
		log(this.getDigitCodeValidation());
		if (this.getDigitCodeValidation().equals(emailVerificationDto.getUniquePinValidation())) {
			return true;
		}
		return false;
	}

	/**
	 * method check validation button is active or not
	 */
	public boolean isValidButtonVerify(EmailVerificationDto emailVerificationDto) {
		if (emailVerificationDto.getButtonsVerifyEmailAdressValidation().equals(this.getVerifyMailValidation())) {
			return true;
		}
		return false;
	}

}
