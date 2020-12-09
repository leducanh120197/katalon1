package com.opcbiz.fxprimus.dto.migration;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class RegisterDto {
	String id;
	

	String title;
	String url;
	String accountType;
	String regulatorType;
	String firstName;
	String lastName;
	String email;
	String country;
	String phoneNumber;
	String password;
	String displayCheckboxValidation;
	String typeAccount;
	String buttonRegisterNow;
	String verifyEmailAddressValidation;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("URL", "url", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ACCOUNT_TYPE", "accountType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("REGULATOR_TYPE", "regulatorType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FIRST_NAME", "firstName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LAST_NAME", "lastName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EMAIL", "email", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COUNTRY", "country", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("PHONE_NUMBER", "phoneNumber", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PASSWORD", "password", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("DISPLAY_CHECKBOX_VALIDATION", "displayCheckboxValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("TYPE_ACCOUNT", "typeAccount", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("BUTTON_REGISTER_NOW", "buttonRegisterNow", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("VERIFY_EMAIL_ADDRESS_VALIDATION", "verifyEmailAddressValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getRegulatorType() {
		return regulatorType;
	}

	public void setRegulatorType(String regulatorType) {
		this.regulatorType = regulatorType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayCheckboxValidation() {
		return displayCheckboxValidation;
	}

	public void setDisplayCheckboxValidation(String displayCheckboxValidation) {
		this.displayCheckboxValidation = displayCheckboxValidation;
	}

	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

	public String getButtonRegisterNow() {
		return buttonRegisterNow;
	}

	public void setButtonRegisterNow(String buttonRegisterNow) {
		this.buttonRegisterNow = buttonRegisterNow;
	}

	public String getVerifyEmailAddressValidation() {
		return verifyEmailAddressValidation;
	}

	public void setVerifyEmailAddressValidation(String verifyEmailAddressValidation) {
		this.verifyEmailAddressValidation = verifyEmailAddressValidation;
	}
}
