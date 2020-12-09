package com.opcbiz.fxprimus.dto.register;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class JointPersonDetailDto {

	

	String id;
	String title;
	String language;
	String address;
	String cityTown;
	String zipPostalcode;
	String stateAcc1;
	String dateOfBirth;
	String genderAcc1;
	String questionPoliticallyCc1;
	String questionUsCitizenshipCc1;
	String firstName;
	String lastName;
	String email;
	String address2;
	String cityTown2;
	String zipPostalcode2;
	String stateAcc2;
	String country;
	String dateOfBirth2;
	String genderAcc2;
	String language2;
	String phoneNumber;
	String questionPoliticallyAcc2;
	String questionUsCitizenshipAcc2;
	String checkboxAccept;
	String buttonProceedValidation;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LANGUAGE", "language", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADDRESS", "address", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CITY_TOWN", "cityTown", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ZIP_POSTALCODE", "zipPostalcode", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("STATE_ACC1", "stateAcc1", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("DATE_OF_BIRTH", "dateOfBirth", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("GENDER_ACC1", "genderAcc1", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_POLITICALLY_CC1", "questionPoliticallyCc1",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_US_CITIZENSHIP_CC1", "questionUsCitizenshipCc1",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FIRST_NAME", "firstName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LAST_NAME", "lastName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EMAIL", "email", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADDRESS2", "address2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CITY_TOWN2", "cityTown2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ZIP_POSTALCODE2", "zipPostalcode2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("STATE_ACC2", "stateAcc2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COUNTRY", "country", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("DATE_OF_BIRTH2", "dateOfBirth2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("GENDER_ACC2", "genderAcc2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LANGUAGE2", "language2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("PHONE_NUMBER", "phoneNumber", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_POLITICALLY_ACC2", "questionPoliticallyAcc2",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_US_CITIZENSHIP_ACC2", "questionUsCitizenshipAcc2",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("CHECKBOX_ACCEPT", "checkboxAccept", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("BUTTON_PROCEED_VALIDATION", "buttonProceedValidation",
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityTown() {
		return cityTown;
	}

	public void setCityTown(String cityTown) {
		this.cityTown = cityTown;
	}

	public String getZipPostalcode() {
		return zipPostalcode;
	}

	public void setZipPostalcode(String zipPostalcode) {
		this.zipPostalcode = zipPostalcode;
	}

	public String getStateAcc1() {
		return stateAcc1;
	}

	public void setStateAcc1(String stateAcc1) {
		this.stateAcc1 = stateAcc1;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGenderAcc1() {
		return genderAcc1;
	}

	public void setGenderAcc1(String genderAcc1) {
		this.genderAcc1 = genderAcc1;
	}

	public String getQuestionPoliticallyCc1() {
		return questionPoliticallyCc1;
	}

	public void setQuestionPoliticallyCc1(String questionPoliticallyCc1) {
		this.questionPoliticallyCc1 = questionPoliticallyCc1;
	}

	public String getQuestionUsCitizenshipCc1() {
		return questionUsCitizenshipCc1;
	}

	public void setQuestionUsCitizenshipCc1(String questionUsCitizenshipCc1) {
		this.questionUsCitizenshipCc1 = questionUsCitizenshipCc1;
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

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCityTown2() {
		return cityTown2;
	}

	public void setCityTown2(String cityTown2) {
		this.cityTown2 = cityTown2;
	}

	public String getZipPostalcode2() {
		return zipPostalcode2;
	}

	public void setZipPostalcode2(String zipPostalcode2) {
		this.zipPostalcode2 = zipPostalcode2;
	}

	public String getStateAcc2() {
		return stateAcc2;
	}

	public void setStateAcc2(String stateAcc2) {
		this.stateAcc2 = stateAcc2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDateOfBirth2() {
		return dateOfBirth2;
	}

	public void setDateOfBirth2(String dateOfBirth2) {
		this.dateOfBirth2 = dateOfBirth2;
	}

	public String getGenderAcc2() {
		return genderAcc2;
	}

	public void setGenderAcc2(String genderAcc2) {
		this.genderAcc2 = genderAcc2;
	}

	public String getLanguage2() {
		return language2;
	}

	public void setLanguage2(String language2) {
		this.language2 = language2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getQuestionPoliticallyAcc2() {
		return questionPoliticallyAcc2;
	}

	public void setQuestionPoliticallyAcc2(String questionPoliticallyAcc2) {
		this.questionPoliticallyAcc2 = questionPoliticallyAcc2;
	}

	public String getQuestionUsCitizenshipAcc2() {
		return questionUsCitizenshipAcc2;
	}

	public void setQuestionUsCitizenshipAcc2(String questionUsCitizenshipAcc2) {
		this.questionUsCitizenshipAcc2 = questionUsCitizenshipAcc2;
	}

	public String getCheckboxAccept() {
		return checkboxAccept;
	}

	public void setCheckboxAccept(String checkboxAccept) {
		this.checkboxAccept = checkboxAccept;
	}

	public String getButtonProceedValidation() {
		return buttonProceedValidation;
	}

	public void setButtonProceedValidation(String buttonProceedValidation) {
		this.buttonProceedValidation = buttonProceedValidation;
	}
}
