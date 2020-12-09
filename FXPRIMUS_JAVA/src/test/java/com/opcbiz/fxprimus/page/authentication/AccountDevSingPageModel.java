package com.opcbiz.fxprimus.page.authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.page.BaseModel;

public class AccountDevSingPageModel extends BaseModel{
	
	@FindBy(xpath = "//input[@value='Logout']")
	public WebElement logOutLink;
	
	@FindBy(id = "hs-eu-confirmation-button")
	public WebElement accept;
	
	@FindBy(xpath = "//*[@href='/en/Site/Logout']/i/..")
	public WebElement logOutBtn;
	
	@FindBy(id = "SecQuestion_answer")
	public WebElement answer;
	
	@FindBy(xpath = "//*[@id='yw0']/input")
	public WebElement submit;
	
	
	//*[@id="SecQuestion_answer"]
	
	
	//*[@id=""]
	
	
	public AccountDevSingPageModel(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
}
