package com.opcbiz.fxprimus.dto.pendCompleteRegis;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class PersonalDetailDto {
	String id;
	String title;
	String preferredLanguageIn;
	String addressIn;
	String cityTownIn;
	String zipPostalcodeIn;
	String stateProvinceIn;
	String dateOfBirthIn;
	String genderIn;
	String questionPoliticallyAcc1Joint;
	String questionUsCitizenshipAcc1Joint;
	String firstNameJoint;
	String lastNameJoint;
	String emailJoint;
	String addressJoint;
	String cityTownJoint;
	String zipPostalcodeJoint;
	String stateAcc2Joint;
	String countryJoint;
	String dateOfBirthJoint;
	String genderJoint;
	String languageJoint;
	String phoneNumberJoint;
	String companyNameCorporate;
	String addressCorporate;
	String cityCorporate;
	String zipPostalcodeCorporate;
	String stateProvinceCorporate;
	String countryCorporate;
	String totalNumberOfDirectorsCorporate;
	String totalNumberOfShareholdersCorporate;
	String licencesYouHaveObtainedCorporate;
	String backgroundExperienceCorporate;
	String questionPolitically;
	String questionUsCitizenship;
	String checkboxAccept;
	String buttonProceed;
	String buttonProceedValidation;
	String dashboardIconValidation;
	String expected;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PREFERRED_LANGUAGE_IN", "preferredLanguageIn",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADDRESS_IN", "addressIn", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CITY_TOWN_IN", "cityTownIn", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("ZIP_POSTALCODE_IN", "zipPostalcodeIn", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("STATE_PROVINCE_IN", "stateProvinceIn", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("DATE_OF_BIRTH_IN", "dateOfBirthIn", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("GENDER_IN", "genderIn", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_POLITICALLY_ACC1_JOINT", "questionPoliticallyAcc1Joint",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_US_CITIZENSHIP_ACC1_JOINT", "questionUsCitizenshipAcc1Joint",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("FIRST_NAME_JOINT", "firstNameJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("LAST_NAME_JOINT", "lastNameJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EMAIL_JOINT", "emailJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ADDRESS_JOINT", "addressJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("CITY_TOWN_JOINT", "cityTownJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ZIP_POSTALCODE_JOINT", "zipPostalcodeJoint",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("STATE_ACC2_JOINT", "stateAcc2Joint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("COUNTRY_JOINT", "countryJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("DATE_OF_BIRTH_JOINT", "dateOfBirthJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("GENDER_JOINT", "genderJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("LANGUAGE_JOINT", "languageJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("PHONE_NUMBER_JOINT", "phoneNumberJoint", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COMPANY_NAME_CORPORATE", "companyNameCorporate",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("ADDRESS_CORPORATE", "addressCorporate", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("CITY_CORPORATE", "cityCorporate", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ZIP_POSTALCODE_CORPORATE", "zipPostalcodeCorporate",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("STATE_PROVINCE_CORPORATE", "stateProvinceCorporate",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("COUNTRY_CORPORATE", "countryCorporate", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TOTAL_NUMBER_OF_DIRECTORS_CORPORATE",
				"totalNumberOfDirectorsCorporate", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TOTAL_NUMBER_OF_SHAREHOLDERS_CORPORATE",
				"totalNumberOfShareholdersCorporate", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LICENCES_YOU_HAVE_OBTAINED_CORPORATE",
				"licencesYouHaveObtainedCorporate", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("BACKGROUND_EXPERIENCE_CORPORATE", "backgroundExperienceCorporate",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_POLITICALLY", "questionPolitically",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("QUESTION_US_CITIZENSHIP", "questionUsCitizenship",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("CHECKBOX_ACCEPT", "checkboxAccept", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("BUTTON_PROCEED", "buttonProceed", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("BUTTON_PROCEED_VALIDATION", "buttonProceedValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("DASHBOARD_ICON_VALIDATION", "dashboardIconValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EXPECTED", "expected", ExcelFieldDto.DataType.STRING, "STRING"));

		return excelFieldDtoList;
	}

	public PersonalDetailDto(String id, String title, String preferredLanguageIn, String addressIn, String cityTownIn,
			String zipPostalcodeIn, String stateProvinceIn, String dateOfBirthIn, String genderIn,
			String questionPoliticallyAcc1Joint, String questionUsCitizenshipAcc1Joint, String firstNameJoint,
			String lastNameJoint, String emailJoint, String addressJoint, String cityTownJoint,
			String zipPostalcodeJoint, String stateAcc2Joint, String countryJoint, String dateOfBirthJoint,
			String genderJoint, String languageJoint, String phoneNumberJoint, String companyNameCorporate,
			String addressCorporate, String cityCorporate, String zipPostalcodeCorporate, String stateProvinceCorporate,
			String countryCorporate, String totalNumberOfDirectorsCorporate, String totalNumberOfShareholdersCorporate,
			String licencesYouHaveObtainedCorporate, String backgroundExperienceCorporate, String questionPolitically,
			String questionUsCitizenship, String checkboxAccept, String buttonProceed, String buttonProceedValidation,
			String dashboardIconValidation, String expected) {
		super();
		this.id = id;
		this.title = title;
		this.preferredLanguageIn = preferredLanguageIn;
		this.addressIn = addressIn;
		this.cityTownIn = cityTownIn;
		this.zipPostalcodeIn = zipPostalcodeIn;
		this.stateProvinceIn = stateProvinceIn;
		this.dateOfBirthIn = dateOfBirthIn;
		this.genderIn = genderIn;
		this.questionPoliticallyAcc1Joint = questionPoliticallyAcc1Joint;
		this.questionUsCitizenshipAcc1Joint = questionUsCitizenshipAcc1Joint;
		this.firstNameJoint = firstNameJoint;
		this.lastNameJoint = lastNameJoint;
		this.emailJoint = emailJoint;
		this.addressJoint = addressJoint;
		this.cityTownJoint = cityTownJoint;
		this.zipPostalcodeJoint = zipPostalcodeJoint;
		this.stateAcc2Joint = stateAcc2Joint;
		this.countryJoint = countryJoint;
		this.dateOfBirthJoint = dateOfBirthJoint;
		this.genderJoint = genderJoint;
		this.languageJoint = languageJoint;
		this.phoneNumberJoint = phoneNumberJoint;
		this.companyNameCorporate = companyNameCorporate;
		this.addressCorporate = addressCorporate;
		this.cityCorporate = cityCorporate;
		this.zipPostalcodeCorporate = zipPostalcodeCorporate;
		this.stateProvinceCorporate = stateProvinceCorporate;
		this.countryCorporate = countryCorporate;
		this.totalNumberOfDirectorsCorporate = totalNumberOfDirectorsCorporate;
		this.totalNumberOfShareholdersCorporate = totalNumberOfShareholdersCorporate;
		this.licencesYouHaveObtainedCorporate = licencesYouHaveObtainedCorporate;
		this.backgroundExperienceCorporate = backgroundExperienceCorporate;
		this.questionPolitically = questionPolitically;
		this.questionUsCitizenship = questionUsCitizenship;
		this.checkboxAccept = checkboxAccept;
		this.buttonProceed = buttonProceed;
		this.buttonProceedValidation = buttonProceedValidation;
		this.dashboardIconValidation = dashboardIconValidation;
		this.expected = expected;
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

	public String getPreferredLanguageIn() {
		return preferredLanguageIn;
	}

	public void setPreferredLanguageIn(String preferredLanguageIn) {
		this.preferredLanguageIn = preferredLanguageIn;
	}

	public String getAddressIn() {
		return addressIn;
	}

	public void setAddressIn(String addressIn) {
		this.addressIn = addressIn;
	}

	public String getCityTownIn() {
		return cityTownIn;
	}

	public void setCityTownIn(String cityTownIn) {
		this.cityTownIn = cityTownIn;
	}

	public String getZipPostalcodeIn() {
		return zipPostalcodeIn;
	}

	public void setZipPostalcodeIn(String zipPostalcodeIn) {
		this.zipPostalcodeIn = zipPostalcodeIn;
	}

	public String getStateProvinceIn() {
		return stateProvinceIn;
	}

	public void setStateProvinceIn(String stateProvinceIn) {
		this.stateProvinceIn = stateProvinceIn;
	}

	public String getDateOfBirthIn() {
		return dateOfBirthIn;
	}

	public void setDateOfBirthIn(String dateOfBirthIn) {
		this.dateOfBirthIn = dateOfBirthIn;
	}

	public String getGenderIn() {
		return genderIn;
	}

	public void setGenderIn(String genderIn) {
		this.genderIn = genderIn;
	}

	public String getQuestionPoliticallyAcc1Joint() {
		return questionPoliticallyAcc1Joint;
	}

	public void setQuestionPoliticallyAcc1Joint(String questionPoliticallyAcc1Joint) {
		this.questionPoliticallyAcc1Joint = questionPoliticallyAcc1Joint;
	}

	public String getQuestionUsCitizenshipAcc1Joint() {
		return questionUsCitizenshipAcc1Joint;
	}

	public void setQuestionUsCitizenshipAcc1Joint(String questionUsCitizenshipAcc1Joint) {
		this.questionUsCitizenshipAcc1Joint = questionUsCitizenshipAcc1Joint;
	}

	public String getFirstNameJoint() {
		return firstNameJoint;
	}

	public void setFirstNameJoint(String firstNameJoint) {
		this.firstNameJoint = firstNameJoint;
	}

	public String getLastNameJoint() {
		return lastNameJoint;
	}

	public void setLastNameJoint(String lastNameJoint) {
		this.lastNameJoint = lastNameJoint;
	}

	public String getEmailJoint() {
		return emailJoint;
	}

	public void setEmailJoint(String emailJoint) {
		this.emailJoint = emailJoint;
	}

	public String getAddressJoint() {
		return addressJoint;
	}

	public void setAddressJoint(String addressJoint) {
		this.addressJoint = addressJoint;
	}

	public String getCityTownJoint() {
		return cityTownJoint;
	}

	public void setCityTownJoint(String cityTownJoint) {
		this.cityTownJoint = cityTownJoint;
	}

	public String getZipPostalcodeJoint() {
		return zipPostalcodeJoint;
	}

	public void setZipPostalcodeJoint(String zipPostalcodeJoint) {
		this.zipPostalcodeJoint = zipPostalcodeJoint;
	}

	public String getStateAcc2Joint() {
		return stateAcc2Joint;
	}

	public void setStateAcc2Joint(String stateAcc2Joint) {
		this.stateAcc2Joint = stateAcc2Joint;
	}

	public String getCountryJoint() {
		return countryJoint;
	}

	public void setCountryJoint(String countryJoint) {
		this.countryJoint = countryJoint;
	}

	public String getDateOfBirthJoint() {
		return dateOfBirthJoint;
	}

	public void setDateOfBirthJoint(String dateOfBirthJoint) {
		this.dateOfBirthJoint = dateOfBirthJoint;
	}

	public String getGenderJoint() {
		return genderJoint;
	}

	public void setGenderJoint(String genderJoint) {
		this.genderJoint = genderJoint;
	}

	public String getLanguageJoint() {
		return languageJoint;
	}

	public void setLanguageJoint(String languageJoint) {
		this.languageJoint = languageJoint;
	}

	public String getPhoneNumberJoint() {
		return phoneNumberJoint;
	}

	public void setPhoneNumberJoint(String phoneNumberJoint) {
		this.phoneNumberJoint = phoneNumberJoint;
	}

	public String getCompanyNameCorporate() {
		return companyNameCorporate;
	}

	public void setCompanyNameCorporate(String companyNameCorporate) {
		this.companyNameCorporate = companyNameCorporate;
	}

	public String getAddressCorporate() {
		return addressCorporate;
	}

	public void setAddressCorporate(String addressCorporate) {
		this.addressCorporate = addressCorporate;
	}

	public String getCityCorporate() {
		return cityCorporate;
	}

	public void setCityCorporate(String cityCorporate) {
		this.cityCorporate = cityCorporate;
	}

	public String getZipPostalcodeCorporate() {
		return zipPostalcodeCorporate;
	}

	public void setZipPostalcodeCorporate(String zipPostalcodeCorporate) {
		this.zipPostalcodeCorporate = zipPostalcodeCorporate;
	}

	public String getStateProvinceCorporate() {
		return stateProvinceCorporate;
	}

	public void setStateProvinceCorporate(String stateProvinceCorporate) {
		this.stateProvinceCorporate = stateProvinceCorporate;
	}

	public String getCountryCorporate() {
		return countryCorporate;
	}

	public void setCountryCorporate(String countryCorporate) {
		this.countryCorporate = countryCorporate;
	}

	public String getTotalNumberOfDirectorsCorporate() {
		return totalNumberOfDirectorsCorporate;
	}

	public void setTotalNumberOfDirectorsCorporate(String totalNumberOfDirectorsCorporate) {
		this.totalNumberOfDirectorsCorporate = totalNumberOfDirectorsCorporate;
	}

	public String getTotalNumberOfShareholdersCorporate() {
		return totalNumberOfShareholdersCorporate;
	}

	public void setTotalNumberOfShareholdersCorporate(String totalNumberOfShareholdersCorporate) {
		this.totalNumberOfShareholdersCorporate = totalNumberOfShareholdersCorporate;
	}

	public String getLicencesYouHaveObtainedCorporate() {
		return licencesYouHaveObtainedCorporate;
	}

	public void setLicencesYouHaveObtainedCorporate(String licencesYouHaveObtainedCorporate) {
		this.licencesYouHaveObtainedCorporate = licencesYouHaveObtainedCorporate;
	}

	public String getBackgroundExperienceCorporate() {
		return backgroundExperienceCorporate;
	}

	public void setBackgroundExperienceCorporate(String backgroundExperienceCorporate) {
		this.backgroundExperienceCorporate = backgroundExperienceCorporate;
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

	public String getButtonProceed() {
		return buttonProceed;
	}

	public void setButtonProceed(String buttonProceed) {
		this.buttonProceed = buttonProceed;
	}

	public String getButtonProceedValidation() {
		return buttonProceedValidation;
	}

	public void setButtonProceedValidation(String buttonProceedValidation) {
		this.buttonProceedValidation = buttonProceedValidation;
	}

	public String getDashboardIconValidation() {
		return dashboardIconValidation;
	}

	public void setDashboardIconValidation(String dashboardIconValidation) {
		this.dashboardIconValidation = dashboardIconValidation;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public PersonalDetailDto() {
		super();
	}
}
