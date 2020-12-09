package com.opcbiz.fxprimus.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicConfigurator.configure();
		Logger ourLogger = LogManager.getLogger("ourLogger");

		// create a FileAppender object and
		// associate the file name to which you want the logs
		// to be directed to.
		// You will also have to set a layout also, here
		// We have chosen a SimpleLayout
		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile("logfile"+System.currentTimeMillis()
				+ ".txt");
		fileAppender.setLayout(new SimpleLayout());

		// Add the appender to our Logger Object.
		// from now onwards all the logs will be directed
		// to file mentioned by FileAppender
		ourLogger.addAppender(fileAppender);
		fileAppender.activateOptions();

		// lets print some log 10 times
		int x = 0;
		while (x < 11) {
			ourLogger.debug("This is just a log that I want to print " + x);
			x++;
		}

	}
	// replaceSmth("driver.findElement(By.xpath(\"//button/span/span\"))");

	public static String replaceSmth(String chuoi) {
		String temp = "";

		// temp = chuoi.replace("driver.findElement(By.", "@FindBy(");

		// temp = temp.replace(String.valueOf(temp.charAt(temp.indexOf("("))) , "=");

		// temp = temp.replace(String.valueOf(temp.charAt(temp.lastIndexOf(")",
		// temp.length()))), "");

		temp = chuoi.replace("(", "");
		temp = temp.replace("driver.findElementBy.", "@FindBy(");
		temp = temp.replace("xpath", "xpath=");
		temp = temp.replace("))", ")");
		String webConCat = temp.substring(14);
		webConCat = webConCat.replace("/", "");
		webConCat = webConCat.replace("\"", "");
		webConCat = webConCat.replace(")", "");
		webConCat = webConCat.replace("\\", "");
		temp = temp.concat("\nWebElement webElement" + webConCat + ";");

		System.out.println(temp);

		return temp;
	}

}
