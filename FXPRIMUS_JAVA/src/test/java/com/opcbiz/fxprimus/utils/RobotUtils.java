package com.opcbiz.fxprimus.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotUtils {
	public static void altF4() {
		System.out.println("Alt F4");
		Robot rb;
		try {
			rb = new Robot();
		    rb.keyPress(KeyEvent.VK_ALT);
		    rb.keyPress(KeyEvent.VK_F4);
		    rb.keyRelease(KeyEvent.VK_F4);
		    rb.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void esc() {
		System.out.println("Esc");
		Robot rb;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rb = new Robot();
		    rb.keyPress(KeyEvent.VK_ESCAPE);
		    rb.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
}
