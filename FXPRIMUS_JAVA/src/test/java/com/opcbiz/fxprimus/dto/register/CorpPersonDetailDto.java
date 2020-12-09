package com.opcbiz.fxprimus.dto.register;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class CorpPersonDetailDto {
	String id;
	String title;
	String companyName;
	String companyAddress;
	String city;
	String companyZipPostalcode;
	String companyStateProvince;
	String country;
	String totalNumberOfDirectors;
	String totalNumberOfShareholders;
	String licencesYouHaveObtained;
	String backgroundExperience;
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
		excelFieldDtoList
				.add(new ExcelFieldDto("COMPANY_NAME", "companyName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("COMPANY_ADDRESS", "companyAddress", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CITY", "city", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COMPANY_ZIP_POSTALCODE", "companyZipPostalcode",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COMPANY_STATE_PROVINCE", "companyStateProvince",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COUNTRY", "country", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TOTAL_NUMBER_OF_DIRECTORS", "totalNumberOfDirectors",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TOTAL_NUMBER_OF_SHAREHOLDERS", "totalNumberOfShareholders",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LICENCES_YOU_HAVE_OBTAINED", "licencesYouHaveObtained",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("BACKGROUND_EXPERIENCE", "backgroundExperience",
				ExcelFieldDto.DataType.STRING, "STRING"));
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyZipPostalcode() {
		return companyZipPostalcode;
	}

	public void setCompanyZipPostalcode(String companyZipPostalcode) {
		this.companyZipPostalcode = companyZipPostalcode;
	}

	public String getCompanyStateProvince() {
		return companyStateProvince;
	}

	public void setCompanyStateProvince(String companyStateProvince) {
		this.companyStateProvince = companyStateProvince;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTotalNumberOfDirectors() {
		return totalNumberOfDirectors;
	}

	public void setTotalNumberOfDirectors(String totalNumberOfDirectors) {
		this.totalNumberOfDirectors = totalNumberOfDirectors;
	}

	public String getTotalNumberOfShareholders() {
		return totalNumberOfShareholders;
	}

	public void setTotalNumberOfShareholders(String totalNumberOfShareholders) {
		this.totalNumberOfShareholders = totalNumberOfShareholders;
	}

	public String getLicencesYouHaveObtained() {
		return licencesYouHaveObtained;
	}

	public void setLicencesYouHaveObtained(String licencesYouHaveObtained) {
		this.licencesYouHaveObtained = licencesYouHaveObtained;
	}

	public String getBackgroundExperience() {
		return backgroundExperience;
	}

	public void setBackgroundExperience(String backgroundExperience) {
		this.backgroundExperience = backgroundExperience;
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
	public CorpPersonDetailDto(String id, String title, String companyName, String companyAddress, String city,
			String companyZipPostalcode, String companyStateProvince, String country, String totalNumberOfDirectors,
			String totalNumberOfShareholders, String licencesYouHaveObtained, String backgroundExperience,
			String preferredLanguage, String address, String cityTown, String zipPostalcode, String stateProvince,
			String dateOfBirth, String gender, String questionPolitically, String questionUsCitizenship,
			String checkboxAccept, String buttonProceedValidation) {
//		super();
		this.id = id;
		this.title = title;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.city = city;
		this.companyZipPostalcode = companyZipPostalcode;
		this.companyStateProvince = companyStateProvince;
		this.country = country;
		this.totalNumberOfDirectors = totalNumberOfDirectors;
		this.totalNumberOfShareholders = totalNumberOfShareholders;
		this.licencesYouHaveObtained = licencesYouHaveObtained;
		this.backgroundExperience = backgroundExperience;
		this.preferredLanguage = preferredLanguage;
		this.address = address;
		this.cityTown = cityTown;
		this.zipPostalcode = zipPostalcode;
		this.stateProvince = stateProvince;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.questionPolitically = questionPolitically;
		this.questionUsCitizenship = questionUsCitizenship;
		this.checkboxAccept = checkboxAccept;
		this.buttonProceedValidation = buttonProceedValidation;
	}
	
}
