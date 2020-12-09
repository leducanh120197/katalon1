package com.opcbiz.fxprimus.utils.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {
	protected String nameElement;
	protected WebDriver webDriver;
	protected WebElement webElement;
	
	public BaseElement(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public BaseElement(WebDriver webDriver, String xpath, String nameElement) {
		this.webDriver = webDriver;
		this.webElement = webDriver.findElement(By.xpath(xpath));
		System.out.println(nameElement);
	}
	
	public void findBy(String by, String input) {
		
	}
	
	public void findById(String id) {
		this.webElement = webDriver.findElement(By.id(id));
	}
	public void findByXpath(String xpathExpression) {
		this.webElement = webDriver.findElement(By.xpath(xpathExpression));
	}
	public void setByXpath(String xpathExpression) {
		this.webElement = webDriver.findElement(By.xpath(xpathExpression));
	}
	public void click() {
		this.webElement.click();
		System.out.println("Click: " + nameElement);
	}

	
	
}
