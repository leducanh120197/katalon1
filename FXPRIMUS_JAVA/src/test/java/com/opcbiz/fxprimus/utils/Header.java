package com.opcbiz.fxprimus.utils;

public class Header {
	String path;
	String sheetName;
	boolean refer;
	
	public Header() {
		super();
	}
	public Header(String path, String sheetName, boolean refer) {
		super();
		this.path = path;
		this.sheetName = sheetName;
		this.refer = refer;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public boolean isRefer() {
		return refer;
	}
	public void setRefer(boolean refer) {
		this.refer = refer;
	}
}
