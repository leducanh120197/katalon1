package com.opcbiz.fxprimus.page.withdrawal;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.page.BaseModel;

public class WithDrawalPageModel extends BaseModel {

	@FindBy(xpath = "//a/b[contains(text(),'Bank Account Details')]")
	WebElement bankAccountDetails;

	@FindBy(xpath = "(//span[@class='header-name']/a)[1]")
	WebElement headerUsernameLink;

	@FindBy(xpath = "(//*[@role='menuitem'])[2]")
	WebElement logout;

	@FindBy(id = "startDate")
	WebElement startDate;

	// WITHDRAWAL
	@FindBy(id = "mt4Id")
	WebElement withDrawalFrom;

//	@FindBy(xpath = "//span[@class='mat-option-text']")
	@FindBy(id = "mat-option-0")
	WebElement withDrawalFromOption;

	@FindBy(id = "amount")
	WebElement amount;

	@FindBy(xpath = "//*[@id=\"left-card\"]//span[contains(text(),'CONFIRM')]")
	WebElement confirmButton;
	// HISTORY
	@FindBy(xpath = "//*[@id=\"mat-datepicker-0\"]//div[@class = 'mat-calendar-body-cell-content mat-calendar-body-today']")
	WebElement startDateToDay;

	@FindBy(id = "endDate")
	WebElement endDate;

	@FindBy(xpath = "//*[@id=\"mat-datepicker-1\"]//div[@class = 'mat-calendar-body-cell-content mat-calendar-body-today']")
	WebElement endDateToDay;

	@FindBy(xpath = "//*[@id='left-card']//span[contains(text(),'VIEW HISTORY')]")
	WebElement viewHistoryButton;
	
	// HISTORY RESULT
	@FindBy(xpath = "//button[@aria-label='Next page' and not (@disabled)]")
	WebElement nextPageButtonNotDisabled;
	
	@FindBy(xpath = "//div[@class = 'mat-paginator-range-label']")
	WebElement numberOfrecords;
	
	

	public WithDrawalPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public boolean isDisplayWithDrawalTitle() {
		String title = "";
		boolean flag = false;
		for (int time = 0; time < 10000;) {
			title = webDriver.getTitle();
			System.out.println(title);
			if (title.equals(Constant.WITHDRAWAL)) {
				flag = true;
				break;
			}
			iwait(500);
			time = time + 500;
		}
		return flag;
	}

	public boolean isDisplayBankAccountDetails() {
		try {
			webDriver.findElement(By.xpath("//a/b[contains(text(),'Bank Account Details')]"));
			System.out.println("isDisplayBankAccountDetails");
			return true;
		} catch (Exception e) {
			System.out.println("NOT - isDisplayBankAccountDetails");
			return false;
		}
	}

	public void clickBankAccountDetails() {
		click(bankAccountDetails);
		System.out.println("clickBankAccountDetails");
	}

	// WITHDRAWAL
	public void setWithDrawalFrom() {
		if(waitForJStoLoad()) {
			iwait(1000);
			click(this.withDrawalFrom, 500);
		}
		click(this.withDrawalFromOption, 200);
	}
	
	public String getWithDrawalFrom() {
		if(waitForJStoLoad()) {
			iwait(1000);
			click(this.withDrawalFrom, 500);
		}
		iwait(2000);
		return getText(this.withDrawalFromOption);
	}

	public void setAmount(String amount) {
		type(amount, this.amount);
	}

	public void inputDataWithDrawal(int amount) {
		setWithDrawalFrom();
		setAmount(amount + "");
		System.out.println("inputDataWithDrawal");
	}

	public void clickConfirmButton() {
		click(500, this.confirmButton);
		System.out.println("clickConfirmButton");
	}

	// HISTORY
	public void setStartDateToday() {
		click(this.startDate, 200);
		click(this.startDateToDay);
	}

	public void setEndDateToDay() {
		click(this.endDate, 200);
		click(this.endDateToDay);
	}

	public void clickViewHistoryButton() {
		click(500, this.viewHistoryButton);
	}

	public void inputDataHistoryToDay() {
		setStartDateToday();
		setEndDateToDay();
	}

	public boolean isDisplayNoResult() {
		String xpathDisplayNoResult = "//*[@id='left-card']//span[contains(text(),'There are no results matching your search.')]";
		return isElementPresent(xpathDisplayNoResult, 500);
	}
	public String getNumberOfrecords() {
		return getText(this.numberOfrecords);
	}
	public boolean disabledNextPage() {
		String xpathNextPageButton = "//button[@aria-label='Next page' and @disabled]";
		return isElementPresent(xpathNextPageButton, 500);
	}
	public void clickNextPageButton() {
		click(this.nextPageButtonNotDisabled);
	}
	public int getTotalHistoryToDay() {
		int totalHistory = 0;
		
		if (isDisplayNoResult()) {
			return totalHistory;
		}else {
			String numberOfRecords = getNumberOfrecords();
			String[] records = numberOfRecords.split("of ");
			totalHistory= Integer.parseInt(records[1]);
			return totalHistory;
		}
	}
	public double getTotalMoney() {
		String getWithDrawalFromToString =  getWithDrawalFrom();
		String[] moneys = getWithDrawalFromToString.split(" ");
		double totalMoney= Double.parseDouble(moneys[moneys.length-1]);
		return totalMoney;
	}
//	public int getTotalHistoryToDayabbababa() {
//		int totalHistory = 0;
//
//		if (isDisplayNoResult()) {
//			return totalHistory;
//		}else {
//			while(!disabledNextPage()) {
//				clickNextPageButton();
//			}
//			
//			return totalHistory;
//		}
//		
//		
//	}

	public void logout() {
		click(headerUsernameLink);
		click(logout);
		System.out.println("logout");
	}
}
