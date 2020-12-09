package com.opcbiz.fxprimus.dto.register;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

/**
 * @author toannl
 *
 */
public class IndiPersonDetailDto {

	/**
	 * 
	 */
	String id;
	String title;
	String preferredLanguage;
	String address;
	String cityTown;
	String zipPostalcode;
	String stateProvince;
	String dateOfBirth;
	String gender;
	String questionPolitically;
	String questionUsCitizenship;
	String checkboxAccept;
	String buttonProceedValidation;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();
		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("PREFERRED_LANGUAGE", "preferredLanguage", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADDRESS", "address", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CITY_TOWN", "cityTown", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ZIP_POSTALCODE", "zipPostalcode", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("STATE_PROVINCE", "stateProvince", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("DATE_OF_BIRTH", "dateOfBirth", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("GENDER", "gender", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_POLITICALLY", "questionPolitically",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_US_CITIZENSHIP", "questionUsCitizenship",
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

	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
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

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQuestionPolitically() {
		return questionPolitically;
	}

	public void setQuestionPolitically(String questionPolitically) {
		this.questionPolitically = questionPolitically;
	}

	public String getQuestionUsCitizenship() {
		return questionUsCitizenship;
	}

	public void setQuestionUsCitizenship(String questionUsCitizenship) {
		this.questionUsCitizenship = questionUsCitizenship;
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
	
	

	public void set(String fieldName, String value) {
		switch (fieldName) {

		case "id":
			this.setId(value);
			break;
		case "title":
			this.setTitle(value);
			break;
		case "preferredLanguage":
			this.setPreferredLanguage(value);
			break;
		case "address":
			this.setAddress(value);
			break;
		case "cityTown":
			this.setCityTown(value);
			break;
		case "zipPostalcode":
			this.setZipPostalcode(value);
			break;
		case "stateProvince":
			this.setStateProvince(value);
			break;
		case "dateOfBirth":
			this.setDateOfBirth(value);
			break;
		case "gender":
			this.setGender(value);
			break;
		case "questionPolitically":
			this.setQuestionPolitically(value);
			break;
		case "questionUsCitizenship":
			this.setQuestionUsCitizenship(value);
			break;
		case "checkboxAccept":
			this.setCheckboxAccept(value);
			break;
		case "buttonProceedValidation":
			this.setButtonProceedValidation(value);
			break;

		default:
			break;
		}
	}
	
	public String get(String fieldName) {
		String value = "";
			switch (fieldName) {

			case "id":
				value = this.getId();
				break;
			case "title":
				value = this.getTitle();
				break;
			case "preferredLanguage":
				value = this.getPreferredLanguage();
				break;
			case "address":
				value = this.getAddress();
				break;
			case "cityTown":
				value = this.getCityTown();
				break;
			case "zipPostalcode":
				value = this.getZipPostalcode();
				break;
			case "stateProvince":
				value = this.getStateProvince();
				break;
			case "dateOfBirth":
				value = this.getDateOfBirth();
				break;
			case "gender":
				value = this.getGender();
				break;
			case "questionPolitically":
				value = this.getQuestionPolitically();
				break;
			case "questionUsCitizenship":
				value = this.getQuestionUsCitizenship();
				break;
			case "checkboxAccept":
				value = this.getCheckboxAccept();
				break;
			case "buttonProceedValidation":
				value = this.getButtonProceedValidation();
				break;

			default:
				break;
			}
			return value;
		}

}
