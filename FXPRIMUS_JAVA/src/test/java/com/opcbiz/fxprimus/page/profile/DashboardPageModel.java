package com.opcbiz.fxprimus.page.profile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.page.BaseModel;

public class DashboardPageModel extends BaseModel {

	@FindBy(xpath = "(//span[@class='header-name']/a)[1]")
	WebElement headerUsernameLink;

	@FindBy(xpath = "(//*[@role='menuitem'])[2]")
	WebElement logout;

	@FindBy(xpath = "(//span[text() = 'Personal Details ']/../../../a)[1]")
	WebElement buttonPersonalDetails;

	@FindBy(xpath = "(//span[text() = 'Account Details ']/../../../a)[1]")
	WebElement buttonAccountDetails;

	@FindBy(xpath = "//*[@id=\"left-card\"]//div[7]")
	WebElement buttonQuestionnaire;

	@FindBy(id = "id")
	WebElement buttonKycDocuments;

	@FindBy(xpath = "//*[@id=\"header-username\"]/span")
	WebElement id;
	
	@FindBy(xpath = "//*[@id='side-card']//span[contains(.,'Registration Progress')]/..//mat-icon")
	WebElement buttonViewRegistrationProgressList;
	
	@FindBy(xpath = "//*[@id='side-card']//span[contains(.,'Account Details')]")
	WebElement buttonAccountDetailsInRegistrationProgress;
	
	
	@FindBy(xpath = "//mat-list-item[@id='profile']//mat-icon")
	WebElement buttonViewProfileList;
	
	
	@FindBy(xpath = "//*[@id='trading-account']")
	WebElement buttonAccountDetailsInProfile;
	
	

	public String getId() {
		String strId = this.id.getText();
		strId = strId.replace("(", "").replace(")", "");
		return strId;
	}

	public void setButtonPersonalDetails() {
		click(this.buttonPersonalDetails);
		waitPageLoad("Personal Details");
	}

	public void setButtonAccountDetails() {
		click(this.buttonAccountDetails);
	}

	public void setButtonQuestionnaire() {
		click(this.buttonQuestionnaire);
		System.out.println("Click: buttonQuestionnaire");
	}

	public void setButtonKycDocuments() {
		click(this.buttonKycDocuments);
	}

	public void load() {
		webDriver.get("https://client-area-ui.staging.k8s.fxprimus.tech/en/dashboard");
		if (isWaitDisplay()) {
		}
	}

	public void logoutDashboard() {
		iwait(333);

		click(headerUsernameLink);
		iwait(999);

		if (logout.isDisplayed()) {
			click(logout);
		} else {
			log("click 2nd time");
			click(headerUsernameLink);
			click(logout);
		}

	}

	public DashboardPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * method to check page is displayed
	 */
	public boolean isDisplayed() {
		if (this.getTitle().contains(Constant.DASHBOARD)) {
			return true;
		}
		return false;
	}

	public boolean isDisplayed(long timer) {
		for (int i = 0; i < timer; i += 500) {
			log("check after " + i + "millisecs ");
			if (this.getTitle().contains(Constant.DASHBOARD)) {
				return true;
			}
		}
		return false;
	}

	public static class AccountDevSing {
		public static By byLogout = By.xpath("//input[@value='Logout']");
	}

	public boolean isCompleted(String stepTh) {// step one step four
		iwait(2000);
		List<WebElement> comp = webDriver.findElements(
				By.xpath("//app-verification-stepper//div[@class='" + stepTh + "']/div[contains(@class,'completed')]"));
		if (comp.size() > 0) {
			return true;
		}
		return false;
	}

	public boolean isKycPendingReview() {
		List<WebElement> list = webDriver.findElements(By.xpath("//*[contains(text(),'(Pending Review)')]"));
		if (list.size() == 0) {
			return false;
		}
		return true;
	}

	public boolean isWaitDisplay() {
		for (int i = 0; i < 22; i++) {
			if (webDriver.getTitle().contains(Constant.DASHBOARD)) {
				System.out.println(Constant.DASHBOARD);
				return true;
			} else {
				System.out.println("NOT isWaitDisplay: " + Constant.DASHBOARD);
				iwait(500);
			}
		}
		return false;
	}
	
	public void clickViewRegistrationProgress() {
		click(buttonViewRegistrationProgressList);
	}
	
	public void clickAccountDetailsInSideCard() {
		click(buttonAccountDetailsInRegistrationProgress);
	}
	
	public void clickViewProfileList() {
		click(buttonViewProfileList);
	}
	
	public void clickAccountDetailsInProfile() {
		click(buttonAccountDetailsInProfile);
	}
	
}
