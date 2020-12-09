package com.opcbiz.fxprimus.dto.register;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class RegisterDtoFunction {
	
	String id;

	String title;
	String accountType;
	String firstName;
	String lastName;
	String email;
	String country;
	String countryValidation;
	
	String phoneNumber;
	String password;
	String checkboxKID;
	String checkboxCA;
	String checkboxRP;
	String buttonRegisterNow;
	
	String verifyEmailAddressValidation;
	String loginOldMaValidation;
	String login;
	String loginValidation;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCheckboxKID() {
		return checkboxKID;
	}


	public void setCheckboxKID(String checkboxKID) {
		this.checkboxKID = checkboxKID;
	}


	public String getCheckboxCA() {
		return checkboxCA;
	}


	public void setCheckboxCA(String checkboxCA) {
		this.checkboxCA = checkboxCA;
	}


	public String getCheckboxRP() {
		return checkboxRP;
	}


	public void setCheckboxRp(String checkboxRP) {
		this.checkboxRP = checkboxRP;
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


	public String getLoginOldMaValidation() {
		return loginOldMaValidation;
	}


	public void setLoginOldMaValidation(String loginOldMaValidation) {
		this.loginOldMaValidation = loginOldMaValidation;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getLoginValidation() {
		return loginValidation;
	}


	public void setLoginValidation(String loginValidation) {
		this.loginValidation = loginValidation;
	}



	public String toString() {
		return this.getClass() + "\n" + "accountType: " + accountType + "\n" + "firstName: " + firstName + "\n"
				+ "lastName: " + lastName + "\n" + "email: " + email + "\n" + "country: " + country + "\n"
				+ "phoneNumber: " + phoneNumber + "\n" + "password: " + password + "\n";
	}
	
	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ACCOUNT_TYPE", "accountType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FIRST_NAAME", "firstName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LAST_NAME", "lastName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EMAIL", "email", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COUNTRY", "country", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COUNTRY_VALIDATION", "countryValidation", ExcelFieldDto.DataType.STRING, "STRING"));
		
		excelFieldDtoList.add(new ExcelFieldDto("PHONE_NUMBER", "phoneNumber", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PASSWORD", "password", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CHECKBOX_KID", "checkboxKID", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CHECKBOX_CA", "checkboxCA", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CHECKBOX_RP", "checkboxRP", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("BUTTON_REGISTER_NOW", "buttonRegisterNow", ExcelFieldDto.DataType.STRING, "STRING"));
		
		excelFieldDtoList.add(new ExcelFieldDto("VERIFY_EMAIL_ADRESS_VALIDATION", "verifyEmailAddressValidation", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LOGIN_OLD_MA_VALIDATION", "loginOldMaValidation", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LOGIN_ID", "login", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LOGIN_VALIDATION", "loginValidation", ExcelFieldDto.DataType.STRING, "STRING"));
		
		return excelFieldDtoList;
	}

}
