package com.opcbiz.fxprimus.page.transfer;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.qa19.AccountDto;
import com.opcbiz.fxprimus.page.BaseModel;

public class TransferPageModel extends BaseModel {
	public TransferPageModel(WebDriver webDriver) {
		super(webDriver);
	}
	@FindBy(id = "transferFrom")
	WebElement selectTransferFrom;
	
	@FindBy(xpath = "//*[@id='transferFrom']//div[@class='mat-select-arrow']")
	WebElement selectTransferFromArrow;

	@FindBy(id = "mat-option-5")
	WebElement optionTransferFrom;

	@FindBy(id = "userType")
	WebElement selectUserType;

	@FindBy(id = "partnerType")
	WebElement selectPartnerType;

	@FindBy(id = "transferTo")
	WebElement transferTo;

	@FindBy(id = "amount")
	WebElement amount;

	@FindBy(id = "comments")
	WebElement comments;

	@FindBy(xpath = "//app-mt4-transfer//button")
	WebElement transferButton;

	@FindBy(xpath = "//app-mt4-transfer//button[@disabled]")
	WebElement transferButtonDisabled;
	
	//logout 
	@FindBy(xpath = "(//span[@class='header-name']/a)[1]")
	WebElement headerUsernameLink;
	@FindBy(xpath = "(//*[@role='menuitem'])[2]")
	WebElement logout;
	
	@FindBy(xpath = "//*[@id='left-card']//span[contains(text(), 'does not belong')]")
	WebElement errorMess;

	public void inputDataUserId(AccountDto accountDtoFrom, AccountDto accountDtoTo, ExtentTest extentTest) {
		System.out.println("input data - doing");
		String userType = accountDtoTo.getType().contains(Constant.PARTNER_UPPER) ? "PARTNER" : "TRADER";
		String transferTo = accountDtoTo.getID();
		int amount = new Random().nextInt(5) + 1;
		String strAmount = amount + "";
		String comments = accountDtoFrom.getID() + " => " + accountDtoTo.getID();

		if(waitForJStoLoad()) {
			clickSelectTransferFrom();
		}
		String strTransferFrom = getTextAndClickOptionTransferFrom();
		clickSelectUserType();
		
		clickOptionWithContainsText(userType);
		
		clickSelectAccountType();
		clickOptionWithContainsText("USER ID");
		setTransferTo(transferTo);
		setAmount(strAmount);
		setComments(comments);

		extentTest.info("Transfer infomation:");
		extentTest.info("Transfer from: " + strTransferFrom);
		extentTest.info("User type: " + userType);
		extentTest.info("Transfer to: UserId " + transferTo);
		extentTest.info("Amount: " + strAmount);
		extentTest.info("Comments: " + comments);
		System.out.println("input data - done");
	}
	public void inputDataUserName(AccountDto accountDtoFrom, AccountDto accountDtoTo, ExtentTest extentTest) {
		System.out.println("input data - doing");
		String userType = accountDtoTo.getType().contains(Constant.PARTNER_UPPER) ? "PARTNER" : "TRADER";
		String transferTo = accountDtoTo.getEmail();
		int amount = new Random().nextInt(5) + 1;
		String strAmount = amount + "";
		String comments = accountDtoFrom.getID() + " => " + accountDtoTo.getID();

		if(waitForJStoLoad()) {
			clickSelectTransferFrom();
		}
		String strTransferFrom = getTextAndClickOptionTransferFrom();
		clickSelectUserType();
		
		clickOptionWithContainsText(userType);
		
		clickSelectAccountType();
		clickOptionWithContainsText("USERNAME");
		setTransferTo(transferTo);
		setAmount(strAmount);
		setComments(comments);

		extentTest.info("Transfer infomation:");
		extentTest.info("Transfer from: " + strTransferFrom);
		extentTest.info("User type: " + userType);
		extentTest.info("Transfer to: UserName " + transferTo);
		extentTest.info("Amount: " + strAmount);
		extentTest.info("Comments: " + comments);
		System.out.println("input data - done");
	}
	
	public void inputData(String typeOfTransfer, AccountDto accountDtoFrom, AccountDto accountDtoTo, ExtentTest extentTest) {
		System.out.println("input data - doing");
		String userType = accountDtoTo.getType().contains(Constant.PARTNER_UPPER) ? "PARTNER" : "TRADER";
		String transferTo = "";
		switch (typeOfTransfer) {
		case "USER ID":
			transferTo = accountDtoTo.getID();
			break;
		case "USERNAME":
			transferTo = accountDtoTo.getEmail().replace("+", "%2B");
			break;
		case "MT4":
			transferTo = accountDtoTo.getMt4();
			break;
		}
		int amount = new Random().nextInt(5) + 1;
		String amountToString = amount + "";
		String comments = accountDtoFrom.getID() + " => " + accountDtoTo.getID();

		if(waitForJStoLoad()) {
			clickSelectTransferFrom();
		}
		String transferFromToString = getTextAndClickOptionTransferFrom();
		clickSelectUserType();
		clickOptionWithContainsText(userType);
		clickSelectAccountType();
		clickOptionWithContainsText(typeOfTransfer);
		setTransferTo(transferTo);
		setAmount(amountToString);
		setComments(comments);
		String errorMess = "";
		for(int i = 0;i<6; i++) {
			try {
				errorMess = getMessError();
				break;
			}catch (Exception e) {
				iwait(500);
			}
		}

		extentTest.info("Transfer infomation:");
		extentTest.info("Transfer from: " + transferFromToString);
		extentTest.info("User type: " + userType);
		extentTest.info("Type: " + typeOfTransfer);
		extentTest.info("Transfer to: " + transferTo);
		extentTest.info("Amount: " + amountToString);
		extentTest.info("Comments: " + comments);
		extentTest.info("Message: " + errorMess);
		System.out.println("input data - done");
	}
	public String getMessError() {
//		String mess = webDriver.findElement(By.xpath("//*[@id=\"left-card\"]/app-mt4-transfer/div/div[2]/form/div[3]/div/div/span")).getText();
		String errorMess = getText(this.errorMess);
		return errorMess;
	}

	public void clickSelectTransferFrom() {
		iwait(1000);
		clickJs(this.selectTransferFrom);
	}

	public String getTextAndClickOptionTransferFrom() {
		String getText = "";
		if(!optionTransferFormPresent()) {
			clickSelectTransferFromArrow();
		}
		getText = getText(this.optionTransferFrom);
		click(this.optionTransferFrom, 500);
		return getText;
	}

	public void clickSelectUserType() {
		click(this.selectUserType, 500);
	}

	public void clickSelectAccountType() {
		click(this.selectPartnerType, 500);
	}

	public void setTransferTo(String transferTo) {
		type(transferTo, this.transferTo);
	}

	public void setAmount(String amount) {
		type(amount, this.amount);
	}

	public void setComments(String comments) {
		type(comments, this.comments);
	}

	public void clickTransferButton() {
		click(this.transferButton, 500);
		System.out.println("clickTransferButton");
	}
	public void clickSelectTransferFromArrow() {
		click(this.selectTransferFromArrow);
	}

	public boolean optionTransferFormPresent(){
		try {
			webDriver.findElement(By.id("mat-option-5"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean buttonTransferDisabled()
	{
		boolean flag = true;
		for(int i=0;i<5;i++) {
			try {
				webDriver.findElement(By.xpath("//app-mt4-transfer//button[@disabled]"));
				iwait(500);
				flag = true;
			} catch (Exception e) {
				flag = false;
				break;
			}
		}
		System.out.println("buttonTransferDisabled - " + flag);
		return flag;
	}
	public boolean waitPageTransferLoadGetTitle() {
		String title = "";
		boolean flag = false;
		for(int time = 0; time < 10000;) {
			iwait(500);
			title = webDriver.getTitle();
			System.out.println(title);
			if(title.equals(Constant.TRANSFER)) {
				flag = true;
				break;
			}
			time = time+500;
		}
		return flag;
	}
	public boolean isDisplay() {
		for(int i = 0; i<22; i++) {
			if(webDriver.getTitle().contains("Transfer")) {
				return true;
			}
			else {
				iwait(500);
				
			}
		}
		return false;
	}

	public void logout() {
		iwait(2000);
		click(headerUsernameLink);
		click(logout);
		System.out.println("logout");
	}
}
