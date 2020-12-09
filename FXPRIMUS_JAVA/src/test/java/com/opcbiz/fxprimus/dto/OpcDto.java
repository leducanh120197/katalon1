package com.opcbiz.fxprimus.dto;

import java.util.ArrayList;
import java.util.List;

public class OpcDto {
	String id;
	
	
	String title;
	String inputData;
	String validationValue;
	String validationType;
	
	String sheetName;// not get data from header

	
	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("INPUT_DATA", "inputData", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("VALIDATION_VALUE", "validationValue", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("VALIDATION_TYPE", "validationType", ExcelFieldDto.DataType.STRING, "STRING"));

		return excelFieldDtoList;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInputData() {
		return inputData;
	}

	public void setInputData(String inputData) {
		this.inputData = inputData;
	}

	public String getValidationValue() {
		return validationValue;
	}

	public void setValidationValue(String validationValue) {
		this.validationValue = validationValue;
	}

	public String getValidationType() {
		return validationType;
	}

	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}
	
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	
	public OpcDto(String id, String title, String inputData, String validationValue, String validationType,
			String sheetName) {
		super();
		this.id = id;
		this.title = title;
		this.inputData = inputData;
		this.validationValue = validationValue;
		this.validationType = validationType;
		this.sheetName = sheetName;
	}
}
