package com.opcbiz.fxprimus.utils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class LogUtils {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void main(String[] args) {
		System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
	}
	static boolean firstTime = true;
	private static Logger ourLogger;
	static void initLoggerBasicConfiguratorFileAppender() {
		BasicConfigurator.configure();
		ourLogger = LogManager.getLogger("ourLogger");

		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile("logfile1591092162926.txt");
		fileAppender.setLayout(new SimpleLayout());
		ourLogger.addAppender(fileAppender);
		fileAppender.activateOptions();
		firstTime = false;
	}

	public static void log(String message) {
		System.out.println(message);
//		if(firstTime) {
//			initLoggerBasicConfiguratorFileAppender();
//		}
//		ourLogger.debug(System.currentTimeMillis()+"-"+ message);
	}




	public static void println(String string) {
		System.out.println(string);
	}

	public static void print(String string) {
		System.out.print(string);
	}

	public static void infoLine() {
		print(ANSI_CYAN + "[INFO] " + ANSI_RESET);
		println("------------------------------------------------------------------------");
	}

	public static void infoLine(String string) {
		int stringLength = string.length();
		int tabSpace = 72 - stringLength;

		int halftabSpace = tabSpace / 2;
		print(ANSI_CYAN + "[INFO] " + ANSI_RESET);
		loop_(halftabSpace);
		print(string);
		if (tabSpace % 2 == 1)
			loop_(halftabSpace + 1);
		else
			loop_(halftabSpace);
		println("");
		infoLine();
	}

	static void loop_(int n) {
		for (int i = 0; i < n; i++) {
			print("-");
		}
	}
}
/*
 * [INFO] Scanning for projects... [INFO] [INFO] ---------------------------<
 * lqa:testNgDemo >--------------------------- [INFO] Building testNgDemo
 * 0.0.1-SNAPSHOT [INFO] --------------------------------[ jar
 * ]--------------------------------- [INFO] [INFO] ---
 * maven-clean-plugin:2.5:clean (default-clean) @ testNgDemo --- [INFO] Deleting
 * E:\eclipse-workspace\new\testscript\target [INFO]
 * ------------------------------------------------------------------------
 * [INFO] BUILD SUCCESS [INFO]
 * ------------------------------------------------------------------------
 * [INFO] Total time: 0.449 s [INFO] Finished at: 2020-05-12T15:45:07+07:00
 * [INFO]
 * ------------------------------------------------------------------------
 */
