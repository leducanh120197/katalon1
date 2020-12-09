package com.opcbiz.fxprimus.dto.pendCompleteRegis;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class RegisterDto {
	String id;
	String title;
	String url;
	String accountType;
	String firstName;
	String lastName;
	String email;
	String country;
	String phoneNumber;
	String password;
	String displayCheckboxValidation;
	String typeAccount;
	String buttonRegisterValidation;
	String profileOptionValidation;
	String dashboardValidation;

	

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("URL", "url", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ACCOUNT_TYPE", "accountType", ExcelFieldDto.DataType.STRING, "STRING"));
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
		excelFieldDtoList.add(new ExcelFieldDto("BUTTON_REGISTER_VALIDATION", "buttonRegisterValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PROFILE_OPTION_VALIDATION", "profileOptionValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("DASHBOARD_VALIDATION", "dashboardValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		return excelFieldDtoList;
	}
	public RegisterDto(String id, String title, String url, String accountType, String firstName, String lastName,
			String email, String country, String phoneNumber, String password, String displayCheckboxValidation,
			String typeAccount, String buttonRegisterValidation, String profileOptionValidation,
			String dashboardValidation) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.accountType = accountType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.displayCheckboxValidation = displayCheckboxValidation;
		this.typeAccount = typeAccount;
		this.buttonRegisterValidation = buttonRegisterValidation;
		this.profileOptionValidation = profileOptionValidation;
		this.dashboardValidation = dashboardValidation;
	}
	public RegisterDto() {
		super();
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

	public String getButtonRegisterValidation() {
		return buttonRegisterValidation;
	}

	public void setButtonRegisterValidation(String buttonRegisterValidation) {
		this.buttonRegisterValidation = buttonRegisterValidation;
	}

	public String getProfileOptionValidation() {
		return profileOptionValidation;
	}

	public void setProfileOptionValidation(String profileOptionValidation) {
		this.profileOptionValidation = profileOptionValidation;
	}

	public String getDashboardValidation() {
		return dashboardValidation;
	}

	public void setDashboardValidation(String dashboardValidation) {
		this.dashboardValidation = dashboardValidation;
	}
}
