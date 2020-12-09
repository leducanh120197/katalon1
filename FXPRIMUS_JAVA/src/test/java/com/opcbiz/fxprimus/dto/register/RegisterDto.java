package com.opcbiz.fxprimus.dto.register;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class RegisterDto {

	String id;
	String title;
	String accountType;

	String firstName;
	String firstNameValidation;
	String lastName;
	String lastNameValidation;
	String email;
	String emailValidation;
	String usernameValidation;

	String country;
	String countryValidation;
	String phoneNumber;
	String phoneNumberValidation;
	String password;
	String passwordValidation;
	String eyeButton;
	String eyeButtonValidation;
	String regulator;
	String displayCheckboxValidation;
	String checkboxId;
	String checkboxIdValidation;

	String checkboxCA;
	String checkboxAValidation;
	String checkboxRp;
	String checkboxRpValidation;

	String registerNowValidation;

	public String toString() {
		return this.getClass() + "\n" + "accountType: " + accountType + "\n" + "firstName: " + firstName + "\n"
				+ "lastName: " + lastName + "\n" + "email: " + email + "\n" + "country: " + country + "\n"
				+ "phoneNumber: " + phoneNumber + "\n" + "password: " + password + "\n";
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstNameValidation() {
		return firstNameValidation;
	}

	public void setFirstNameValidation(String firstNameValidation) {
		this.firstNameValidation = firstNameValidation;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastNameValidation() {
		return lastNameValidation;
	}

	public void setLastNameValidation(String lastNameValidation) {
		this.lastNameValidation = lastNameValidation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailValidation() {
		return emailValidation;
	}

	public void setEmailValidation(String emailValidation) {
		this.emailValidation = emailValidation;
	}

	public String getEyeButton() {
		return eyeButton;
	}

	public void setEyeButton(String eyeButton) {
		this.eyeButton = eyeButton;
	}

	public String getEyeButtonValidation() {
		return eyeButtonValidation;
	}

	public void setEyeButtonValidation(String eyeButtonValidation) {
		this.eyeButtonValidation = eyeButtonValidation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryValidation() {
		return countryValidation;
	}

	public void setCountryValidation(String countryValidation) {
		this.countryValidation = countryValidation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumberValidation() {
		return phoneNumberValidation;
	}

	public void setPhoneNumberValidation(String phoneNumberValidation) {
		this.phoneNumberValidation = phoneNumberValidation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordValidation() {
		return passwordValidation;
	}

	public void setPasswordValidation(String passwordValidation) {
		this.passwordValidation = passwordValidation;
	}

	public String getRegulator() {
		return regulator;
	}

	public void setRegulator(String regulator) {
		this.regulator = regulator;
	}

	public String getCheckboxId() {
		return checkboxId;
	}

	public void setCheckboxId(String checkboxId) {
		this.checkboxId = checkboxId;
	}

	public String getCheckboxIdValidation() {
		return checkboxIdValidation;
	}

	public void setCheckboxIdValidation(String checkboxIdValidation) {
		this.checkboxIdValidation = checkboxIdValidation;
	}

	public String getCheckboxA() {
		return checkboxCA;
	}

	public void setCheckboxCA(String checkboxCA) {
		this.checkboxCA = checkboxCA;
	}

	public String getCheckboxAValidation() {
		return checkboxAValidation;
	}

	public void setCheckboxAValidation(String checkboxAValidation) {
		this.checkboxAValidation = checkboxAValidation;
	}

	public String getCheckboxRp() {
		return checkboxRp;
	}

	public void setCheckboxRp(String checkboxRp) {
		this.checkboxRp = checkboxRp;
	}

	public String getCheckboxRpValidation() {
		return checkboxRpValidation;
	}

	public void setCheckboxRpValidation(String checkboxRpValidation) {
		this.checkboxRpValidation = checkboxRpValidation;
	}

	public String getDisplayCheckboxValidation() {
		return displayCheckboxValidation;
	}

	public void setDisplayCheckboxValidation(String displayCheckboxValidation) {
		this.displayCheckboxValidation = displayCheckboxValidation;
	}

	public String getRegisterNowValidation() {
		return registerNowValidation;
	}

	public void setRegisterNowValidation(String registerNowValidation) {
		this.registerNowValidation = registerNowValidation;
	}

	public String getUsernameValidation() {
		return usernameValidation;
	}

	public void setUsernameValidation(String usernameValidation) {
		this.usernameValidation = usernameValidation;
	}

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ACCOUNT_TYPE", "accountType", ExcelFieldDto.DataType.STRING, "STRING"));

		excelFieldDtoList.add(new ExcelFieldDto("FIRST_NAME", "firstName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FIRST_NAME_VALIDATION", "firstNameValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LAST_NAME", "lastName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LAST_NAME_VALIDATION", "lastNameValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EMAIL", "email", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("EMAIL_VALIDATION", "emailValidation", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("USERNAME_VALIDATION", "usernameValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COUNTRY", "country", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("COUNTRY_VALIDATION", "countryValidation", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("PHONE_NUMBER", "phoneNumber", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PHONE_NUMBER_VALIDATION", "phoneNumberValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PASSWORD", "password", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PASSWORD_VALIDATION", "passwordValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EYE_BUTTON", "eyeButton", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EYE_BUTTON_VALIDATION", "eyeButtonValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("REGULATOR", "regulator", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("DISPLAY_CHECKBOX_VALIDATION", "displayCheckboxValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));

		excelFieldDtoList.add(new ExcelFieldDto("CHECKBOXKID", "checkboxId", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CHECKBOXKID_VALIDATION", "checkboxIdValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CHECKBOXCA", "checkboxCA", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CHECKBOXCA_VALIDATION", "checkboxAValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CHECKBOXRP", "checkboxRp", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CHECKBOXRP_VALIDATION", "checkboxRpValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("REGISTER_NOW_VALIDATION", "registerNowValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));

		return excelFieldDtoList;
	}

	public static RegisterDto getExample() {
		RegisterDto registerDto = new RegisterDto();
		// Corporate test auto truong.vu+04@opcbiz.com truong.vu+04@opcbiz.com Croatia
		// 385 34598542 Testauto01@ x x x click
// qa_automation+1589441061930@fxprimus.tech
		registerDto.accountType = "Corporate";
		registerDto.firstName = "test";
		registerDto.lastName = "auto";
		registerDto.email = "truong.vu+04" + System.currentTimeMillis() / 100000 + "@opcbiz.com";
		registerDto.password = "Testauto01@";
		registerDto.phoneNumber = "34598542";
		registerDto.country = "Croatia";
		registerDto.checkboxId = "x";
		registerDto.checkboxCA = "x";
		registerDto.checkboxRp = "x";

		return registerDto;
	}

	public static RegisterDto getExample(String fieldName, String value) {
		RegisterDto registerDto = new RegisterDto();
		registerDto.accountType = value;
		registerDto.firstName = "test";
		registerDto.lastName = "auto";
//		registerDto.email = "qa_automation+04" + System.currentTimeMillis()  + "@fxprimus.tech";
		registerDto.email = "truong.vu+" + System.currentTimeMillis() + "@opcbiz.com";
		registerDto.password = "Testauto01@";
		registerDto.phoneNumber = "34598542";
		registerDto.country = "Croatia";
		registerDto.checkboxId = "x";
		registerDto.checkboxCA = "x";
		registerDto.checkboxRp = "x";
        return registerDto;
	}
	

	public static RegisterDto getExampleCorpCy() {
		RegisterDto registerDto = new RegisterDto();
		registerDto.accountType = "Corporate";
		registerDto.firstName = "test";
		registerDto.lastName = "auto";
		registerDto.email = "qa_automation+" + System.currentTimeMillis()  + "@fxprimus.tech";
		registerDto.password = "Testauto01@";
		registerDto.phoneNumber = "34598542";
		registerDto.country = "Austria";
		registerDto.checkboxId = "x";
		registerDto.checkboxCA = "x";
		registerDto.checkboxRp = "x";
        return registerDto;
	}
	
	public static RegisterDto getExampleJointCy() {
		RegisterDto registerDto = new RegisterDto();
		registerDto.accountType = "Joint";
		registerDto.firstName = "test";
		registerDto.lastName = "auto";
		registerDto.email = "qa_automation+" + System.currentTimeMillis()  + "@fxprimus.tech";
		registerDto.password = "Testauto01@";
		registerDto.phoneNumber = "34598542";
		registerDto.country = "Hungary";
		registerDto.checkboxId = "x";
		registerDto.checkboxCA = "x";
		registerDto.checkboxRp = "x";
        return registerDto;
	}
	public static RegisterDto getExampleIndividualCy() {
		RegisterDto registerDto = new RegisterDto();
		registerDto.accountType = "Individual";
		registerDto.firstName = "test";
		registerDto.lastName = "auto";
		registerDto.email = "qa_automation+" + System.currentTimeMillis()  + "@fxprimus.tech";
		registerDto.password = "Testauto01@";
		registerDto.phoneNumber = "34598542";
		registerDto.country = "Hungary";
		registerDto.checkboxId = "x";
		registerDto.checkboxCA = "x";
		registerDto.checkboxRp = "x";
        return registerDto;
	}
}
