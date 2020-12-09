package com.opcbiz.fxprimus.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.utils.LogUtils;

//import com.opcbiz.fxprimus.utils.OperatingSystem;

public class BaseModel {

	protected WebDriver webDriver;
	public boolean onMacSafari = true;
	public boolean onMacChrome = false;
	public boolean onWinChrome = false;

	/**
	 * method return web title
	 */
	public String getTitle() {
		System.out.println(webDriver.getTitle());
		return webDriver.getTitle();
	}

	/**
	 * method return web title
	 */
	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	/**
	 * method to wait a few second and click into element
	 */
	public static void iwait(long timer) {
		try {
			System.out.println("wait in " + timer + " milisecs");
			Thread.sleep(timer);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * method to click into element and wait a few second
	 */
	public void click(WebElement webElement, long timer) {
		System.out.println("click");
		webElement.click();
		iwait(timer);

	}

	/**
	 * method to wait a few second and click into element
	 */
	public void click(long timer, WebElement webElement) {
		iwait(timer);
		System.out.println("click in " + timer + " miliseconds");
		webElement.click();
	}

	/**
	 * method to wait a second and click into element
	 */
	public void waitNClick(WebElement webElement) {
		System.out.println("click in a second");
		iwait(1000);
		webElement.click();
	}

	/**
	 * method to click into element
	 */
	public void click(WebElement webElement) {
		String webElementoString = webElement.toString();
		if (webElementoString.contains("->")) {
			webElementoString = webElementoString.split("->")[1].replace("]]", "]");
		}
		System.out.println("click " + webElementoString);
		webElement.click();
//		if(OperatingSystem.isMac()) {
//			clickJs(webElement);
//		}
//		if(OperatingSystem.isWindows()) {
//			webElement.click();
//		}

	}

	/**
	 * method to click into element by js
	 */
	public void clickJs(WebElement webElement) {
		LogUtils.log("click " + webElement);
		JavascriptExecutor executor = (JavascriptExecutor) this.webDriver;
		executor.executeScript("arguments[0].click();", webElement);
		// arguments[0].removeAttribute('disabled')
	}

	public boolean waitForJStoLoad() {

		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					Long tmlLong = (Long) executor.executeScript("return jQuery.active");
					return (tmlLong == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return executor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return webDriverWait.until(jQueryLoad) && webDriverWait.until(jsLoad);
	}

	public String getText(WebElement webElement) {
		return webElement.getText();
	}

	/**
	 * method to click into element by js
	 */
	public void removeAttributeByJs(WebElement webElement, String attribute) {
		JavascriptExecutor executor = (JavascriptExecutor) this.webDriver;
		executor.executeScript("arguments[0].removeAttribute('" + attribute + "');", webElement);
	}

	/**
	 * method to type into element
	 */
	public void type(String keysToSend, WebElement webElement) {
		String webElementoString = webElement.toString();
		if (webElementoString.contains("->")) {
			webElementoString = webElementoString.split("->")[1].replace("]", "");
		}
		LogUtils.log("type " + keysToSend + " into " + webElementoString);
		webElement.sendKeys(keysToSend);
	}

	/**
	 * method to type into element
	 */
//	public void type(WebElement webElement, String keysToSend) {
//		System.out.println("type " + keysToSend + " into " + webElement);
//		webElement.sendKeys(keysToSend);
//	}

	public void type(WebElement webElement, String keysToSend) {
		String webElementoString = webElement.toString();
		if (webElementoString.contains("->")) {
			webElementoString = webElementoString.split("->")[1].replace("]", "");
		}
		System.out.println("type " + keysToSend + " into " + webElementoString);

		webElement.sendKeys(keysToSend);
	}

	public void typeJs(String keysToSend, WebElement webElement) {
		JavascriptExecutor executor = (JavascriptExecutor) this.webDriver;
//		executor.executeScript("document.getElementById('elementID').setAttribute('value', 'new value for element')");
		executor.executeScript("arguments[0].setAttribute('value', '" + keysToSend + "')", webElement);
	}

	public void typeJs(Keys keysToSend, WebElement webElement) {
		JavascriptExecutor executor = (JavascriptExecutor) this.webDriver;
		executor.executeScript("arguments[0].setAttribute('value', '" + keysToSend + "')", webElement);
	}

	public void scrollJs(WebElement webElement) {
		JavascriptExecutor executor = (JavascriptExecutor) this.webDriver;
		executor.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}

	/**
	 * method to clear into element
	 */
	public void clear(WebElement webElement) {
		System.out.println("clear " + webElement);
		webElement.clear();
	}

	/**
	 * method to type into element
	 */
	public void type(Keys keysToSend, WebElement webElement) {
		System.out.println("type " + keysToSend);
		webElement.sendKeys(keysToSend);
	}

	/**
	 * method to log information
	 */
	public void log(String message) {
		System.out.println(message);
	}

	/**
	 * method to log information
	 */
	public void log(String message, String suffix) {
		for (int i = 0; i < 9; i++) {
			message += suffix;
		}
		System.out.println(message);
	}

	/**
	 * method to wait Page loading
	 */
	public boolean waitPageLoad(String getTitle) {
		for (int i = 0; i < 22; i++) {
			if (webDriver.getTitle().contains(getTitle)) {
				return true;
			} else {
				iwait(500);
				log(getTitle);
			}
		}
		return false;
	}

	public void waitJsLoad() {
		WebDriverWait wait = new WebDriverWait(webDriver, 9);
//		wait.until( new Predicate<WebDriver>() {
//            public boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
//            }
//        }

	}

	public WebElement findElementByXpath(String xpathExpression) {
		log("findElementByXpath String:" + xpathExpression);
		return webDriver.findElement(By.xpath(xpathExpression));
	}

	public WebElement findElementById(String id) {
		log("findElementById String:" + id);
		return webDriver.findElement(By.id(id));
	}

	public BaseModel(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(this.webDriver, this);
	}

	// temporary data when testing
	public static long registerTime;

	public static long getRegisterTime() {
		return registerTime;
	}

	/**
	 * method to shut Down Popup
	 */
	@FindBy(xpath = "//*[@id='mat-dialog-0']//button")
	WebElement popUpContinue0;
	@FindBy(xpath = "//*[@id='mat-dialog-1']//button")
	WebElement popUpContinue1;

	public void shutDownPopupRedirected() {
		if (!isPopupOnePresent()) {
			try {
				click(200, this.popUpContinue0);
			} catch (Exception e) {
				e.getMessage();
				try {
					click(200, this.popUpContinue1);
					click(100, this.popUpContinue0);
				} catch (Exception e2) {
					e2.getMessage();
				}
			}
		} else {
			try {
				click(200, this.popUpContinue1);
				click(100, this.popUpContinue0);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	public boolean isPopupOnePresent() {
		try {
			webDriver.findElement(By.xpath("//*[@id='mat-dialog-1']//button"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void quit(long timer) {
		iwait(1000);
		webDriver.quit();
	}

	public void clickOptionWithContainsText(String containsText) {
		String xpath = "(//mat-option)/span[contains(text(),'" + containsText + "')]";
		webDriver.findElement(By.xpath(xpath)).click();
	}

	public boolean isElementPresent(String xpath, long timer) {
		for (int i = 0; i < timer; i = i + 500) {

			try {
				webDriver.findElement(By.xpath(xpath));
				System.out.println("isElementPresent: " + xpath);
				return true;
			} catch (Exception e) {
				System.out.println("Not " + xpath);
				iwait(500);
			}
		}
		return false;
	}

	public boolean isElementPresent(String xpath) {
		webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			webDriver.findElement(By.xpath(xpath));
			System.out.println("isElementPresent: " + xpath);
			return true;
		} catch (Exception e) {
			System.out.println("Not " + xpath);
		}
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return false;
	}

	public boolean isElementPresent(By locator) {
		try {
			webDriver.findElement(locator);
			System.out.println("isElementPresent: " + locator);
			return true;
		} catch (Exception e) {
			System.out.println("Not " + locator);
		}
		return false;
	}

	// logout
	@FindBy(xpath = "(//span[@class='header-name']/a)[1]")
	WebElement headerUsernameLink;
	@FindBy(xpath = "(//*[@role='menuitem'])[2]")
	WebElement logout;

	public void logout() {
		iwait(2000);
		click(headerUsernameLink);
		click(logout);
		System.out.println("logout");
	}

	public boolean isWaitDisplay(String title) {
		for (int i = 0; i < 20; i++) {
			if (webDriver.getTitle().contains(title)) {
				System.out.println("isWaitDisplay" + title);
				return true;
			} else {
				System.out.println("NOT isWaitDisplay" + title);
				iwait(500);
			}
		}
		return false;
	}

	public boolean isDisplayed(String title) {
		if (this.getTitle().contains(title)) {
			System.out.println("isDisplayed" + title);
			return true;
		}
		System.out.println("NOT isDisplayed" + title);
		return false;
	}

	public void checkErrorPageAndQuit() {
		if (webDriver.getTitle().contains("ERROR")) {
			System.out.println(getTitle());
			webDriver.quit();
		}
	}

	public void uploadImageThroughMacosWindow() {
		JavascriptExecutor executor = (JavascriptExecutor) this.webDriver;
		executor.executeScript("document.addEventListener('click', function(evt) {"
				+ "      if (evt.target.type === 'file')" + "        evt.preventDefault();" + "    }, true)" + " ");
	}

	public void scrollPage(int length) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0," + length + ")");
	}
}
