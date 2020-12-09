package com.opcbiz.fxprimus.utils.elements;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class Option extends BaseElement {

	public Option(WebDriver webDriver) {
		super(webDriver);

	}

	public Option(WebDriver webDriver, String xpath, String nameElement) {
		super(webDriver, xpath, nameElement);
	}

}
