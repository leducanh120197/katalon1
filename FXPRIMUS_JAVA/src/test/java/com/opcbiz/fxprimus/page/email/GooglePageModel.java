package com.opcbiz.fxprimus.page.email;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.page.BaseModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;

public class GooglePageModel extends BaseModel {

	// input fields
	@FindBy(xpath = "//div[@class='h-c-header__cta']//a[contains(text(),'Sign in')]")
	WebElement signIn;

	@FindBy(id = "identifierId")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "identifierNext")
	WebElement next;

	@FindBy(id = "passwordNext")
	WebElement passwordNext;

	@FindBy(xpath = "(//span[contains(text(),'Welcome to FXPRIMUS! Please Verify')])[2]")
	WebElement welcomeMail;

	@FindBy(xpath = "//a[contains(text(),'GO TO MEMBERS AREA')]")
	WebElement goToMemArea;

	@FindBy(xpath = "//a[contains(text(),'GO TO') and contains(text(),'AREA')]")
	WebElement goToArea;

	// validation fields
	// @FindBy(xpath = "(//span[contains(text(),'Unique PIN: ')])[2]")
	@FindBy(xpath = "//h2[contains(text(),'Welcome to FXPRIMUS! Please Verify Your Email Address. Unique PIN')]")
	WebElement pin;

	@FindBy(xpath = "//*[@id=\"digitCode\"]")
	WebElement uniquePin;

//	@FindBy(xpath = "//app-emailverification//button/span")
//	WebElement verifyButton;
	@FindBy(xpath = "//div/form/button")
	WebElement verifyButton;

	private String pinField;

	public GooglePageModel(WebDriver webDriver) {
		super(webDriver);
	}

	// actions

	/**
	 * method click to sign in button
	 */
	public void clickSignIn() {
		click(this.signIn, 2222);
	}

	/**
	 * method set email
	 */
	public void setEmail(String email) {
		type(email, this.email);
	}

	/**
	 * method set password
	 */
	public void setPassword(String password) {
		type(password, this.password);
	}

	/**
	 * method click to next button
	 */
	public void clickNext() {
		click(this.next, 1000);
	}

	/**
	 * method click to next button type password
	 */
	public void clickPasswordNext() {
		click(500, this.passwordNext);
	}

	/**
	 * method click to read welcome email
	 */
	public void selectWelcomeMail() {
		try {
			waitNClick(this.welcomeMail);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * method get pin in email content
	 */
	public String getPin() {
//		String pin = this.pin.getText();
//		pin = pin.replace("Unique PIN: ", "");
//		return pin;
		return pinField;
	}

	public void setPin() {
		pinField = this.pin.getText();
		String[] content = pinField.split("Unique PIN: ");
		pinField = content[1];
	}

	/**
	 * method click to forward to login system
	 */
	public void goToMemArea() {
		waitNClick(this.goToMemArea);
	}

	public void goToArea() {
		waitNClick(this.goToArea);
	}

	/**
	 * method click to sign in button
	 */
	public void setUniquePin(String uniquePin) {
		type(uniquePin, this.uniquePin);

	}

	/**
	 * method set email
	 */
	public void clickVerifyButton() {
		click(this.verifyButton, 1000);
	}

	/**
	 * method to verify by email
	 */
	public boolean verifyInEmail() {
		this.clickSignIn();
		ArrayList<String> tabs2 = new ArrayList<String>(this.webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs2.get(1));

		this.setEmail(Constant.GMAIL);
		this.clickNext();
		this.setPassword(Constant.GMAIL_PASSWORD);
		this.clickPasswordNext();

		if (!isExistUnreadEmail()) {
			return false;
		}

		this.selectWelcomeMail();
		this.setPin();
		this.goToMemArea();// 1 more tab
		ArrayList<String> tabs22 = new ArrayList<String>(this.webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs22.get(2));

		return true;

	}

	/**
	 * method to verify by email
	 */
	public boolean verifyInEmail(String emailStr, String passwordStr) {
		String gmailHomeTab;
		String welcomeTab = "";
		gmailHomeTab = this.webDriver.getWindowHandle();
		
		this.clickSignIn();
		ArrayList<String> listTabs = new ArrayList<String>(this.webDriver.getWindowHandles());
		for(String tab : listTabs) {
			if(!tab.equals(gmailHomeTab)) {
				welcomeTab = tab;
				webDriver.switchTo().window(tab);
			}
		}
		

		this.setEmail(emailStr);
		this.clickNext();
		iwait(1000);
		this.setPassword(passwordStr);
		iwait(1000);
		this.clickPasswordNext();

		if (!isExistUnreadEmail()) {
			return false;
		}

		this.selectWelcomeMail();

//		String pin = this.getPin();
//		this.goToArea();
		this.setPin();
		this.goToMemArea();// 1 more tab
		ArrayList<String> listTabs3 = new ArrayList<String>(this.webDriver.getWindowHandles());
		for(String tab : listTabs3) {
			if(!tab.equals(gmailHomeTab) && !tab.equals(welcomeTab)) {
				webDriver.switchTo().window(tab);
			}
		}

		System.out.println();
		return true;

	}

	public void load() {
		this.webDriver.get(UrlConstant.GMAIL_PAGE);
	}

	public void signIn() {
		this.clickSignIn();
	}

	boolean isExistUnreadEmail() {
//		registerTime = System.currentTimeMillis();
//		iwait(2222);
//
////		List<WebElement> unreadMails = this.webDriver.findElements(By.xpath("//span[@class='bq3']"));
//		List<WebElement> unreadMails = this.webDriver
//				.findElements(By.xpath("//table/tbody/tr/td[9]/span/span[@class='bq3']"));

		// registerTime = System.currentTimeMillis();
		waitPageLoad("Inbox");

		List<WebElement> unreadMails = this.webDriver.findElements(By.xpath("//span[@class='bq3']"));

		List<String> unreadMailsTime = new ArrayList<String>();
		for (WebElement webElement : unreadMails) {
			try {
				String webElementGetText = webElement.getText();
				System.out.println(webElementGetText);
				char firstCharacter = webElementGetText.charAt(0);
				if (Character.isDigit(firstCharacter)) {
					unreadMailsTime.add(webElementGetText);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("----1");
			}
		}
		// no unread mail
		if (unreadMails.size() == 0) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		Date resultdate = new Date(registerTime);
//			System.out.println(sdf.format(resultdate));
		String registerTimeStr = sdf.format(resultdate);

		// registerTimeStr = "3:33 PM";
		for (String emailTime : unreadMailsTime) {
			// has new email
			if (emailTime.compareTo(registerTimeStr) >= 0) {
				log("emailTime:" + emailTime + "-" + registerTimeStr + ":registerTimeStr");
				return true;
			}
		}
		// no new email
		return false;
	}

	public DashboardPageModel verifyInEmailWithPin(String emailStr, String passwordStr) {
		((JavascriptExecutor) webDriver)
				.executeScript("window.open('https://www.google.com/intl/en/gmail/about/#','_blank');");
		ArrayList<String> tabs = new ArrayList<String>(this.webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs.get(1));
		this.clickSignIn();

		ArrayList<String> tabs2 = new ArrayList<String>(this.webDriver.getWindowHandles());

		webDriver.switchTo().window(tabs2.get(2));

		this.setEmail(emailStr);
		this.clickNext();
		iwait(1000);
		this.setPassword(passwordStr);
		iwait(1000);
		this.clickPasswordNext();

		if (!isExistUnreadEmail()) {
			System.out.println("Not exist unread email");
		}
		String pin = "";
		try {
			iwait(3000);
			this.selectWelcomeMail();
			iwait(1000);
			this.setPin();
			pin = this.getPin();
			iwait(1000);
		} catch (Exception e) {
			e.getMessage();
//			this.selectWelcomeMail();
//			pin = this.getPin();
		}

		webDriver.switchTo().window(tabs2.get(0));

		this.setUniquePin(pin);
		this.clickVerifyButton();
		iwait(1000);
		return new DashboardPageModel(webDriver);
	}
}
