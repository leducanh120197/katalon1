package com.opcbiz.fxprimus.dto.pendCompleteRegis;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class EmailVerificationDto {
	String id;
	String url;
	String title;
	String uniquePin;
	String buttonVerifyEmail;
	String verifyEmailValidation;
	String expected;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("URL", "url", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("UNIQUE_PIN", "uniquePin", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("BUTTON_VERIFY_EMAIL", "buttonVerifyEmail", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("VERIFY_EMAIL_VALIDATION", "verifyEmailValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EXPECTED", "expected", ExcelFieldDto.DataType.STRING, "STRING"));
		return excelFieldDtoList;
	}

	public EmailVerificationDto() {
		super();
	}

	public EmailVerificationDto(String id, String url, String title, String uniquePin, String buttonVerifyEmail,
			String verifyEmailValidation, String expected) {
		super();
		this.id = id;
		this.url = url;
		this.title = title;
		this.uniquePin = uniquePin;
		this.buttonVerifyEmail = buttonVerifyEmail;
		this.verifyEmailValidation = verifyEmailValidation;
		this.expected = expected;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUniquePin() {
		return uniquePin;
	}

	public void setUniquePin(String uniquePin) {
		this.uniquePin = uniquePin;
	}

	public String getButtonVerifyEmail() {
		return buttonVerifyEmail;
	}

	public void setButtonVerifyEmail(String buttonVerifyEmail) {
		this.buttonVerifyEmail = buttonVerifyEmail;
	}

	public String getVerifyEmailValidation() {
		return verifyEmailValidation;
	}

	public void setVerifyEmailValidation(String verifyEmailValidation) {
		this.verifyEmailValidation = verifyEmailValidation;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}
}
