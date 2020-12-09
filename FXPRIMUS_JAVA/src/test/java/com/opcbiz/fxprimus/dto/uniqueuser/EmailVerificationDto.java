package com.opcbiz.fxprimus.dto.uniqueuser;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class EmailVerificationDto {
	String id;
	String title;
	String uniquePin;

	String uniquePinValidation;
	String buttonsVerifyEmailAdressValidation;
	
	String expectedResult;

	

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("UNIQUE_PIN", "uniquePin", ExcelFieldDto.DataType.STRING, "STRING"));

		excelFieldDtoList.add(new ExcelFieldDto("UNIQUE_PIN_VALIDATION", "uniquePinValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("BUTTONS_VERIFY_EMAIL_ADDRESS_VALIDATION",
				"buttonsVerifyEmailAdressValidation", ExcelFieldDto.DataType.STRING, "STRING"));
		
		excelFieldDtoList.add(new ExcelFieldDto("EXPECTED_RESULT",
				"expectedResult", ExcelFieldDto.DataType.STRING, "STRING"));
		

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
	
	public String toString() {
		return this.getClass()+"\n"+ "unique pin: " + this.getUniquePin() + "\n" +
				"unique Pin Validation: " + this.uniquePinValidation;
	}

	public String getButtonsVerifyEmailAdressValidation() {
		return buttonsVerifyEmailAdressValidation;
	}

	public void setButtonsVerifyEmailAdressValidation(String buttonsVerifyEmailAdressValidation) {
		this.buttonsVerifyEmailAdressValidation = buttonsVerifyEmailAdressValidation;
	}

	public String getUniquePin() {
		return uniquePin;
	}

	public void setUniquePin(String uniquePin) {
		this.uniquePin = uniquePin;
	}

	public String getUniquePinValidation() {
		return uniquePinValidation;
	}

	public void setUniquePinValidation(String uniquePinValidation) {
		this.uniquePinValidation = uniquePinValidation;
	}
	
	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
}
