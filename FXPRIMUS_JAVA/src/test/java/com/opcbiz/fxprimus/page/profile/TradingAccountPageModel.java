package com.opcbiz.fxprimus.page.profile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.pendCompleteRegis.AccountDetailDto;
import com.opcbiz.fxprimus.page.BaseModel;

public class TradingAccountPageModel extends BaseModel {

	@FindBy(id = "account_type")
	WebElement selectAccountType;

	@FindBy(xpath = "//*[contains(text(),'Variable')]/..")
	WebElement optionVariable;

//	@FindBy(xpath = "//*[contains(text(),'ECN')]/..")
	@FindBy(xpath = "//mat-option[contains(.,'ECN')]")
	WebElement optionEcn;

	@FindBy(id = "leverage")
	WebElement selectLeverage;

	@FindBy(xpath = "//span[contains(text(),'1:30')]/..")
	WebElement option130;

	@FindBy(id = "currency")
	WebElement selectDepositCurrency;

	@FindBy(xpath = "//span[contains(text(),'USD')]/..")
	WebElement optionUsd;

	@FindBy(xpath = "//span[contains(text(),'EUR')]/..")
	WebElement optionEur;

	@FindBy(xpath = "//span[contains(text(),'GBP')]/..")
	WebElement optionGbp;

	@FindBy(xpath = "//span[contains(text(),'SGD')]/..")
	WebElement optionSgd;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonProceed;

	public void clickSelectAccountType() {
		iwait(500);
		clickJs(selectAccountType);
		iwait(500);
	}

	public void clickOptionVariable() {
		click(optionVariable);
	}

	public void clickOptionEcn() {
		click(optionEcn);
	}

	public void clickSelectLeverage() {
		click(selectLeverage);
	}

	public void clickOption130() {
		try {
			click(option130);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void clickSelectDepositCurrency() {
		click(selectDepositCurrency);
	}

	public void clickOptionUsd() {
		click(optionUsd);
	}

	public void clickOptionEur() {
		click(optionEur);
	}

	public void clickOptionGbp() {
		click(optionGbp);
	}

	public void clickOptionSgd() {
		click(optionSgd);
	}

	public void clickButtonProceed() {
		click(buttonProceed);
		waitPageLoad(Constant.TRADING_KNOWLEDGE);
	}

	public void setSelectAccountType() {

	}

	public boolean isDisplayed(long timer) {
		for (int i = 0; i < timer; i += 500) {
			log("check after " + i + "millisecs ");
			iwait(500);
			if (this.getTitle().contains(Constant.TRADING_ACCOUNT)) {
				return true;
			}
		}
		return false;
	}

	public void load() {
		this.webDriver.get("https://client-area-ui.staging.k8s.fxprimus.tech/en/profile/trading-account");
		this.isDisplayed(10000);
	}

	public TradingAccountPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public boolean validate(AccountDetailDto accountDetailDto) {
		clickSelectAccountType();
		if (accountDetailDto.getAccountType().equals("Variable")) {
			clickOptionVariable();
		} else if (accountDetailDto.getAccountType().equals("ECN")) {
			clickOptionEcn();
		}

		clickSelectLeverage();
		clickOption130();

		clickSelectDepositCurrency();
		if (accountDetailDto.getDepositCurrency().equals("USD")) {
			clickOptionUsd();
		} else if (accountDetailDto.getDepositCurrency().equals("EUR")) {
			clickOptionEur();
		} else if (accountDetailDto.getDepositCurrency().equals("GBP")) {
			clickOptionGbp();
		} else if (accountDetailDto.getDepositCurrency().equals("SGD")) {
			clickOptionSgd();
		}
		return true;
//		clickButtonProceed();
	}

	public void inputData(AccountDetailDto accountDetailDto) {
		clickSelectAccountType();
		if (accountDetailDto.getAccountType().equals("Variable")) {
			clickOptionVariable();
		} else if (accountDetailDto.getAccountType().equals("ECN")) {
			clickOptionEcn();
		}

		clickSelectLeverage();
		clickAnyLeverage(accountDetailDto.getLeverage());

		scrollPage(100);
		clickSelectDepositCurrency();
		clickAnyCurrency(accountDetailDto.getDepositCurrency());
	}
	
	public boolean valideteLeverageCY() {
		boolean rs = false;
		clickSelectLeverage();
		if(isElementPresent("//span[contains(text(),'1:30')]/..")) {
			rs = true;
		}
		List<WebElement> elements= webDriver.findElements(By.xpath("//mat-option")); 
		if(elements.size()>1) {
			rs = false;
		}
		if(rs) {
			clickOption130();
		}
		return rs;
	}
	

	public void clickAnyLeverage(String leverage) {
		WebElement element = webDriver.findElement(By.xpath("//span[contains(text(),'" + leverage + "')]/.."));
		click(element);
		System.out.println("click: " + leverage);
	}

	public void clickAnyCurrency(String currency) {
		WebElement element = webDriver.findElement(By.xpath("//span[contains(text(),'" + currency + "')]/.."));
		click(element);
		System.out.println("click: " + currency);
	}

	public boolean isWaitDisplay() {
		for (int i = 0; i < 22; i++) {
			if (webDriver.getTitle().contains(Constant.TRADING_ACCOUNT)) {
				return true;
			} else {
				System.out.println("NOT isDisplay");
				iwait(500);
			}
		}
		return false;
	}

}
