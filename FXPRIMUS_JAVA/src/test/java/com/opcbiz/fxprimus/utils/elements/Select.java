package com.opcbiz.fxprimus.utils.elements;

import org.openqa.selenium.WebDriver;

public class Select extends BaseElement {
	 

	public Select(WebDriver webDriver) {
		super(webDriver);
	}
	public Select(WebDriver webDriver, String xpath, String nameElement) {
		super(webDriver, xpath, nameElement);
		
	}
	public void set(Option option) {
		this.click();
		option.click();
	}
	public void clickSelect() {
		this.click();
	}
	
}
