package com.opcbiz.fxprimus.utils.elements;

import org.openqa.selenium.WebDriver;

public class Button extends BaseElement {

	public Button(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void click() {
		webElement.click();
	}

}
