package com.opcbiz.fxprimus.page.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.page.BaseModel;

public class LoginPageModel extends BaseModel {

	@FindBy(xpath = "//*[contains(text(),'Open an Account')]/../..")
	WebElement openAccountBtn;
	By languageBtn;

	@FindBy(id = "username")
	WebElement textboxUsername;

	@FindBy(id = "password")
	WebElement textboxPassword;

	@FindBy(xpath = "//form/button")
	WebElement buttonLogin;

	public void load() {
		System.out.println("Loading login");
		this.webDriver.get("https://client-area-ui.staging.k8s.fxprimus.tech/en/login");
		System.out.println("Loaded login");
	}

	public void loadPartnerLogin() {
		this.webDriver.get("https://partners-area-ui.staging.k8s.fxprimus.tech/");
	}

	public void loadClientLogin() {
		this.webDriver.get("https://client-area-ui.staging.k8s.fxprimus.tech/");
	}

	public LoginPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public void setButtonLogin() {
		click(this.buttonLogin);
		// iwait(Constant.FIVESEC);
	}

	public void setTextboxUsername(String textboxusername) {
		type(textboxusername, this.textboxUsername);
	}

	public void setTextboxPassword(String textboxpassword) {
		type(textboxpassword, this.textboxPassword);
	}

	public void clickOpenAccount() {
		waitPageLoad(Constant.LOGIN);
		if(onMacSafari) {
			click(openAccountBtn);
		}
		else {
			click(openAccountBtn);
		}
	}

	public void selectLanguage() {

	}

	public void login(String username, String password) {
		setTextboxUsername(username);
		setTextboxPassword(password);
		setButtonLogin();
		afterClickLogin();
	}

	public void afterClickLogin() {
		for (int i = 0; i < 22; i++) {
			if (webDriver.getTitle().contains("Login")) {
				iwait(500);
			} else {
				System.out.println("login successfull");
				return;
			}
		}

	}

	public boolean checkUrlAfterLogin(String expect) {
		int count = 0;
		while (count < 9) {
			count++;
			iwait(500);
			if (this.getCurrentUrl().contains(expect)) {
				return true;
			}
		}
		return false;
	}

	public boolean isDisplay() {
		for (int i = 0; i < 22; i++) {
			if (webDriver.getTitle().contains("Login")) {
				return true;
			} else {
				iwait(500);

			}
		}
		return false;
	}

}
