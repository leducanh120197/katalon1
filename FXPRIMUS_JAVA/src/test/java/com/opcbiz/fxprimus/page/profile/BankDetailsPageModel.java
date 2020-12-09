package com.opcbiz.fxprimus.page.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.dto.qa20.BankDetailDto;
import com.opcbiz.fxprimus.page.BaseModel;

public class BankDetailsPageModel extends BaseModel {
	public BankDetailsPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(id = "bank_name")
	WebElement bankName;

	@FindBy(id = "bank_address")
	WebElement bankAddress;

	@FindBy(id = "bank_acc_no")
	WebElement bankAccountNumber;

	@FindBy(id = "bank_swift_code")
	WebElement bankSwiftCode;

	@FindBy(id = "bank_iban")
	WebElement bankIban;

	@FindBy(id = "bank_country")
	WebElement country;

	@FindBy(id = "mat-input-9")
	WebElement findCountry;

	@FindBy(xpath = "//*[@id='left-card']//span[contains(text(),'SUBMIT')]")
	WebElement submitButton;

	public void setBankName(String bankName) {
		type(bankName, this.bankName);
	}

	public void setBankAddress(String bankAddress) {
		type(bankAddress, this.bankAddress);
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		type(bankAccountNumber, this.bankAccountNumber);
	}

	public void setBankSwiftCode(String bankSwiftCode) {
		type(bankSwiftCode, this.bankSwiftCode);
	}

	public void setBankIban(String bankIban) {
		type(bankIban, this.bankIban);
	}

	public void setCountry(String country) {
		click(this.country, 500);
		type(country, this.findCountry);
		WebElement webElementOption = this.webDriver
				.findElement(By.xpath("//mat-option/span[contains(text(),\"" + country + "\")]"));
		this.waitNClick(webElementOption);
	}

	public void clickSubmitButton() {
		click(submitButton);
		System.out.println("clickSubmitButton");
	}
	
	public void inputData(BankDetailDto bankDetailDto) {
		System.out.println("inputData Bank detail - doing");
		setBankName(bankDetailDto.getBankName());
		setBankAddress(bankDetailDto.getBankAddress());
		setBankAccountNumber(bankDetailDto.getBankAccountNumber());
		setBankSwiftCode(bankDetailDto.getBankSwiftCode());
		setBankIban(bankDetailDto.getBankIban());
		setCountry(bankDetailDto.getBankCountry());
		System.out.println("inputData Bank detail - done");
	}

}
