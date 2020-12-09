package com.opcbiz.fxprimus.page.profile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.internal.Utils;

import com.aventstack.extentreports.ExtentTest;
import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.OpcDto;
import com.opcbiz.fxprimus.page.BaseModel;
import com.opcbiz.fxprimus.utils.LogUtils;

public class PersonalDetailsPageModel extends BaseModel {

	ExtentTest extentTest;

	@FindBy(id = "language")
	WebElement selectLanguage;
	@FindBy(xpath = "//input[@placeholder='Search Language']")
	WebElement textBoxSearchLanguage;
	// @FindBy(xpath = "//mat-option[@role='option']")
	WebElement optionSearchLanguage;
	@FindBy(xpath = "//*[@id='language']//span/span")
	WebElement valueSearchLanguage;
	@FindBy(xpath = "//*[@id='gender']//span/span")
	WebElement valueGender;

	@FindBy(id = "state")
	public WebElement textBoxState;
	@FindBy(id = "zip")
	public WebElement textBoxZip;
	@FindBy(id = "city")
	public WebElement textBoxCity;
	@FindBy(id = "address")
	public WebElement textBoxAddress;

	@FindBy(xpath = "//*[@id='address']/../../../../../div/p/span")
	WebElement labelAddressError;

	@FindBy(xpath = "//*[@id='language']/../../../../../div/p/span")
	WebElement labelLanguageError;

	@FindBy(xpath = "//*[@id='city']/../../../../../div/p/span")
	WebElement labelCityError;

	@FindBy(xpath = "//*[@id='zip']/../../../../../div/p/span")
	WebElement labelZipError;

	@FindBy(xpath = "//*[@id='state']/../../../../../div/p/span")
	WebElement labelStateError;

	@FindBy(xpath = "//*[@id='dateOfBirth']/../../../../../div/p/span")
	WebElement labelDateOfBirthError;
	//
	public WebElement datepicker;

	@FindBy(id = "dateOfBirth")
	public WebElement dateOfBirth;
	@FindBy(xpath = "/html/body/div[3]/div[1]")
	public WebElement overlay;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	WebElement buttonOpenCalendar;

	@FindBy(id = "gender")
	WebElement selectGender;

	@FindBy(xpath = "//mat-option/span[contains(text(),'--')]")
	WebElement option__;
	@FindBy(xpath = "//mat-option[@role='option']/span/span[contains(text(),'Male')]")
	WebElement optionMale;
	@FindBy(xpath = "//mat-option[@role='option']/span/span[contains(text(),'Female')]")
	WebElement optionFemale;
	//*[@formcontrolname='politically_exposed']/mat-radio-button[1]  old
	@FindBy(xpath = "//*[@formcontrolname='politicallyExposed']/mat-radio-button[1]/label")
	WebElement radioPepYes;
	
	@FindBy(xpath = "//*[@formcontrolname='politically_exposed']/mat-radio-button[1]/label")
	WebElement radioPepYesIndividual;

	@FindBy(id = "mat-radio-2-input")
	WebElement radioPepYesInput;

	@FindBy(xpath = "//*[@formcontrolname='politicallyExposed']/mat-radio-button[2]/label")
	WebElement radioPepNo;
	
	@FindBy(xpath = "//*[@formcontrolname='politically_exposed']/mat-radio-button[2]/label")
	WebElement radioPepNoIndividual;

	@FindBy(id = "mat-radio-3-input")
	WebElement radioPepNoInput;

	@FindBy(xpath = "//*[@formcontrolname='usCitizenship']/mat-radio-button[1]/label")
	WebElement radioUsYes;
	
	@FindBy(xpath = "//*[@formcontrolname='us_citizen']/mat-radio-button[1]/label")
	WebElement radioUsYesIndividual;

	@FindBy(id = "mat-radio-5-input")
	WebElement radioUsYesInput;

	@FindBy(xpath = "//*[@formcontrolname='usCitizenship']/mat-radio-button[2]/label")
	WebElement radioUsNo;
	
	@FindBy(xpath = "//*[@formcontrolname='us_citizen']/mat-radio-button[2]/label")
	WebElement radioUsNoIndividual;

	@FindBy(id = "mat-radio-6-input")
	WebElement radioUsNoInput;

	@FindBy(xpath = "//*[@formcontrolname='usCitizenship']/../../div/span")
	WebElement labelUsError;

	@FindBy(xpath = "//*[@formcontrolname='agreements']/label")
	WebElement checkboxCa;

	@FindBy(xpath = "//*[@id='mat-checkbox-1-input']/../../../../div/span")
	WebElement labelCheckboxCaError;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement buttonProceed;

	@FindBy(id = "companyName")
	WebElement companyName;

	@FindBy(xpath = "//*[@id='companyName']/../../../../../div/p/span")
	WebElement labelCompanyNameError;

	@FindBy(id = "companyAddress")
	WebElement addressCorporate;

	@FindBy(xpath = "//*[@id='companyAddress']/../../../../../div/p/span")
	WebElement labelAddressCorporateError;

	@FindBy(xpath = "//*[contains(text(),'COMPANY DETAILS')]/..//*[@id='city']")
	WebElement cityCompany;

	@FindBy(xpath = "//*[contains(text(),'COMPANY DETAILS')]/..//*[@id='city']/../../../../../div/p/span")
	WebElement labelCityCompanyError;

	@FindBy(id = "postalCode")
	WebElement postalCode;

	@FindBy(xpath = "//*[@id='postalCode']/../../../../../div/p/span")
	WebElement labelPostalCodeError;

	@FindBy(id = "country")
	WebElement selectCountry;

	@FindBy(xpath = "//*[contains(@placeholder,'Search Country')]")
	WebElement textBoxSearchCountry;

	WebElement optionSearchCountry;

	@FindBy(xpath = "//*[@id='country']//span/span")
	WebElement valueSearchCountry;

	@FindBy(xpath = "//*[@id='country']/../../../../../div/p/span")
	WebElement labelCountryError;

	@FindBy(id = "noOfDirectors")
	WebElement textBoxNoOfDirectors;

	@FindBy(xpath = "//*[@id='noOfDirectors']/../../../../../div/p/span")
	WebElement labelNoOfDirectorsError;

	@FindBy(id = "noOfShareholders")
	WebElement textBoxNoOfShareholders;

	@FindBy(xpath = "//*[@id='noOfShareholders']/../../../../../div/p/span")
	WebElement labelNoOfShareholdersError;

	@FindBy(id = "license")
	WebElement textBoxLicense;

	@FindBy(id = "background")
	WebElement textBoxBackground;
	
	@FindBy(xpath = "//*[contains(text(),'No results found!')]")
	WebElement noResultsFound;

	public void load() {
		this.webDriver.get("https://client-area-ui.staging.k8s.fxprimus.tech/en/profile");
		iwait(999);
	}
	
	public String getNoResultsFoundGetText() {
		return this.noResultsFound.getText();
	}

	public void setBackground(String background) {
		this.textBoxBackground.clear();
		type(background, this.textBoxBackground);
	}

	public String getValueBackground() {
		return this.textBoxBackground.getAttribute("value");
	}

	public void setLicense(String license) {
		this.textBoxLicense.clear();
		type(license, this.textBoxLicense);
	}

	public String getValueLicense() {
		return this.textBoxLicense.getAttribute("value");
	}

	public String getLabelNoOfShareholdersError() {
		return this.labelNoOfShareholdersError.getText();
	}

	public void setNoOfShareholders(String noOfShareholders) {
		this.textBoxNoOfShareholders.clear();
		type(noOfShareholders, this.textBoxNoOfShareholders);
	}

	public String getValueNoOfShareholders() {
		return this.textBoxNoOfShareholders.getAttribute("value");
	}

	public void setNoOfDirectors(String noOfDirectors) {
		this.textBoxNoOfDirectors.clear();
		type(noOfDirectors, this.textBoxNoOfDirectors);
	}

	public String getValueNoOfDirectors() {
		return this.textBoxNoOfDirectors.getAttribute("value");
	}

	public String getLabelNoOfDirectorsError() {
		return this.labelNoOfDirectorsError.getText();
	}

	public String getLabelCountryError() {
		return this.labelCountryError.getText();
	}

	public String getValueSearchCountry() {
		return this.valueSearchCountry.getText();
	}

	public void setOptionSearchCountry(String optionSearchCountry) {
		this.optionSearchCountry = this.webDriver
				.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + optionSearchCountry + " ']"));
		if (onWinChrome) {
			click(this.optionSearchCountry);
		}
		if (onMacChrome || onMacSafari) {
			clickJs(this.optionSearchCountry);
		}
	}

	public void setTextBoxSearchCountry(String textBoxSearchCountry) {
		this.textBoxSearchCountry.clear();
		if (onWinChrome) {
			type(textBoxSearchCountry, this.textBoxSearchCountry);
//			type(Keys.ENTER, this.textBoxSearchCountry);
		}
		if (onMacChrome || onMacSafari) {
			typeJs(textBoxSearchCountry, this.textBoxSearchCountry);
//			typeJs(Keys.ENTER, this.textBoxSearchCountry);
		}
	}

	public void setSelectCountry() {
		click(selectCountry);
	}

	public void setPostalCode(String postalCode) {
		this.postalCode.clear();
		type(postalCode, this.postalCode);
	}

	public String getValuePostalCode() {
		try {
			return this.postalCode.getAttribute("value");
		} catch (Exception e) {
			return "";
		}
	}

	public String getLabelPostalCodeError() {
		return this.labelPostalCodeError.getText();
	}

	public void setCityCompany(String cityCompany) {
		this.cityCompany.clear();
		type(cityCompany, this.cityCompany);
	}

	public String getValueCityCompany() {
		try {
			return this.cityCompany.getAttribute("value");
		} catch (Exception e) {
			return "";
		}
	}

	public String getLabelCityCompanyError() {
		return this.labelCityCompanyError.getText();
	}

	public void setAddressCorporate(String addressCorporate) {
		this.addressCorporate.clear();
		type(addressCorporate, this.addressCorporate);
	}

	public String getValueAddressCorporate() {
		try {
			return this.addressCorporate.getAttribute("value");
		} catch (Exception e) {
			return "";
		}
	}

	public String getLabelAddressCorporateError() {
		return this.labelAddressCorporateError.getText();
	}

	public void setCompanyName(String companyName) {
		this.companyName.clear();
		type(companyName, this.companyName);
	}

	public String getValueCompanyName() {
		try {
			return this.companyName.getAttribute("value");
		} catch (Exception e) {
			return "";
		}
	}

	public String getLabelCompanyNameError() {
		return this.labelCompanyNameError.getText();
	}

	public void setCheckboxCa(String string) {
		if (string.isEmpty() || string.equals("null")) {

		} else if (string.equals("click-click")) {
			click(checkboxCa);
			iwait(Constant.HALFSEC);
			click(checkboxCa);
		} else {
			if(onMacSafari) {
				clickJs(checkboxCa);
			}else {
				click(checkboxCa);
			}
			
		}

	}

	public String getLabelCheckboxCaError() {
		return this.labelCheckboxCaError.getText();
	}

	public String getTextBoxStateValue() {
		try {
			return this.textBoxState.getAttribute("value");
		} catch (Exception e) {
			return "";
		}
	}

	public String getLabelStateError() {
		try {
			String error = this.labelStateError.getText();
			return error;
		} catch (Exception e) {
		}
		return "";
	}

	public String getTextBoxDateOfBirthValue() {
		
		return this.dateOfBirth.getAttribute("value");
	}

	public String getLabelDateOfBirthError() {
		return this.labelDateOfBirthError.getText();
	}

	public String getTextBoxZipValue() {
		return this.textBoxZip.getAttribute("value");
	}

	public String getLabelZipError() {
		return this.labelZipError.getText();
	}

	public String getTextBoxCityTownValue() {
		try {
			return this.textBoxCity.getAttribute("value");
		} catch (Exception e) {
			return "";
		}
	}

	public String getLabelCityError() {
		return this.labelCityError.getText();
	}

	public String getLabelAddressError() {
		return this.labelAddressError.getText();
	}

	public String getTextBoxAddressValue() {
		return this.textBoxAddress.getAttribute("value");
	}

	public boolean isSelectedRadioPepYes() {
		return this.radioPepYesInput.isSelected();
	}

	public boolean isSelectedRadioPepNo() {
		return this.radioPepNoInput.isSelected();
	}

	public boolean isSelectedRadioUsYes() {
		return this.radioUsYesInput.isSelected();
	}

	public boolean isSelectedRadioUsNo() {
		return this.radioUsNoInput.isSelected();
	}

	public void setRadioPepYes() {
		if (onMacSafari) {
			clickJs(this.radioPepYes);
		}
		if (onMacChrome) {
			clickJs(this.radioPepYes);
		}
		if (onWinChrome) {
			click(this.radioPepYes);
		}
	}

	public void setRadioPepNo() {
		if (onMacChrome || onMacSafari) {
			clickJs(this.radioPepNo);
		}
		if (onMacChrome) {
			clickJs(this.radioPepNo);
		}
		if (onWinChrome) {
			click(this.radioPepNo);
		}
	}
	public void setRadioPepYesIndividual() {
		if (onMacSafari) {
			clickJs(this.radioPepYesIndividual);
		}
		if (onMacChrome) {
			clickJs(this.radioPepYesIndividual);
		}
		if (onWinChrome) {
			click(this.radioPepYesIndividual);
		}
	}

	public void setRadioPepNoIndividual() {
		if (onMacChrome || onMacSafari) {
			clickJs(this.radioPepNoIndividual);
		}
		if (onMacChrome) {
			clickJs(this.radioPepNoIndividual);
		}
		if (onWinChrome) {
			click(this.radioPepNoIndividual);
		}
	}

	public void setRadioUsYes() {
		if (onMacSafari) {
			clickJs(this.radioUsYes);
		}
		if (onMacChrome) {
			clickJs(this.radioUsYes);
		}
		if (onWinChrome) {
			click(this.radioUsYes);
		}
	}

	public void setRadioUsNo() {
		if (onMacSafari) {
			clickJs(this.radioUsNo);
		}
		if (onMacChrome) {
			clickJs(this.radioUsNo);
		}
		if (onWinChrome) {
			click(this.radioUsNo);
		}
	}
	
	public void setRadioUsYesIndividual() {
		if (onMacSafari) {
			clickJs(this.radioUsYesIndividual);
		}
		if (onMacChrome) {
			clickJs(this.radioUsYesIndividual);
		}
		if (onWinChrome) {
			click(this.radioUsYesIndividual);
		}
	}

	public void setRadioUsNoIndividual() {
		if (onMacSafari) {
			clickJs(this.radioUsNoIndividual);
		}
		if (onMacChrome) {
			clickJs(this.radioUsNoIndividual);
		}
		if (onWinChrome) {
			click(this.radioUsNoIndividual);
		}
	}

	public void setButtonOpenCalendar() {
		if (onMacChrome || onMacSafari) {
			clickJs(this.buttonOpenCalendar);
		}
		if (onWinChrome) {
			click(this.buttonOpenCalendar);
		}
	}

	public void setDatepicker(String datepicker) {
		String[] g = datepicker.split(" ");
		// String month = g[0];
		String day = g[1].replace(",", "");
		// String year = g[2];
//		this.datepicker = webDriver.findElement(By.xpath("(//*[@id='mat-datepicker-0']//td/div)[" + day + "]"));
		this.datepicker = webDriver.findElement(By.xpath("(//*[@id='mat-datepicker-0']//td/div)[" + 1 + "]"));
		// this.datepicker.click();
		clickJs(this.datepicker);
	}

	public void setDatepicker() {
		String xpath = "(//*[@id='mat-datepicker-0']//td/div)[" + 1 + "]";
		this.datepicker = webDriver.findElement(By.xpath(xpath));
		this.datepicker.click();
	}

	public void setOption__() {
		clickJs(this.option__);
	}

	public void setOptionMale() {
		clickJs(this.optionMale);
	}

	public void setOptionFemale() {
		clickJs(this.optionFemale);
	}

	public void setSelectGender() {
		clickJs(this.selectGender);
	}

	public void setSelectLanguage() {
		if(onMacSafari) {
			clickJs(this.selectLanguage);
		}
		else {
			click(this.selectLanguage);
		} 
	}

	public void setTextBoxSearchLanguage(String textBoxSearchLanguage) {
		this.textBoxSearchLanguage.clear();
		type(textBoxSearchLanguage, this.textBoxSearchLanguage);
	}

	public void setOptionSearchLanguage(String textBoxSearchLanguage) {
		this.optionSearchLanguage = this.webDriver
				.findElement(By.xpath("//mat-option[@role='option']/span[text()=' " + textBoxSearchLanguage + " ']"));
		if(onMacSafari) {
			clickJs(this.optionSearchLanguage);
		}
		else {
			click(this.optionSearchLanguage);
		}
		
	}

	public void setButtonProceed() {
		if(onMacSafari) {
			clickJs(this.buttonProceed);
		}
		else {
			click(this.buttonProceed);
		}
	}

	public void setTextBoxState(String textBoxState) {
		this.textBoxState.clear();
		type(textBoxState, this.textBoxState);
	}

	public void setTextBoxZip(String textBoxZip) {
		this.textBoxZip.clear();
		type(textBoxZip, this.textBoxZip);
	}

	public void setTextBoxCity(String textBoxCity) {
		clear(this.textBoxCity);
		type(textBoxCity, this.textBoxCity);
	}

	public void setTextBoxAddress(String textBoxAddress) {
		clear(this.textBoxAddress);
		type(textBoxAddress, this.textBoxAddress);
	}

	public String getValueSearchLanguage() {
		return this.valueSearchLanguage.getText();
	}

	public String getLabelLanguageError() {
		return this.labelLanguageError.getText();
	}

	public String getValueGender() {
		try {
			String text = this.valueGender.getText();
			return text;
		} catch (Exception e) {
		}
		return "null";
	}

	public void inputData(String string) {// setTextBoxAddress();
		// setTextBoxCity();
		// setTextBoxZip();
		// setTextBoxState();
		// setButtonProceed();
	}

	public void setDataToField(String fieldName, String fieldValue) {
		switch (fieldName) {
		case "address":
			setTextBoxAddress(fieldValue);
			break;
		}
	}

	public void checkDataInField(String fieldName, String fieldValue) {
		switch (fieldName) {
		case "address":
			// get(fieldValue);
			break;
		}
	}

	public void setRadioPep(String option) {
		if (option.equals("Yes")) {
			setRadioPepYes();
		}
		if (option.equals("No")) {
			setRadioPepNo();
		}
	}
	public void setRadioPepIndividual(String option) {
		if (option.equals("Yes")) {
			setRadioPepYesIndividual();
		}
		if (option.equals("No")) {
			setRadioPepNoIndividual();
		}
	}

	public boolean getRadioPep(String option) {
		if (option.equals("yes")) {
			return this.radioPepYesInput.isSelected();
		}
		if (option.equals("no")) {
			return this.radioPepNoInput.isSelected();
		}
		return false;
	}

	public void setRadioUs(String option) {
		if (option.equals("Yes")) {
			setRadioUsYes();
		}
		if (option.equals("No")) {
			setRadioUsNo();
		}
	}
	public void setRadioUsIndividual(String option) {
		if (option.equals("Yes")) {
			setRadioUsYesIndividual();
		}
		if (option.equals("No")) {
			setRadioUsNoIndividual();
		}
	}

	public boolean getRadioUs(String option) {
		if (option.equals("Yes")) {
			return this.radioUsYesInput.isSelected();
		}
		if (option.equals("No")) {
			return this.radioUsNoInput.isSelected();
		}
		return false;
	}

	public String getLabelUsError() {
		return this.labelUsError.getText();
	}

	public PersonalDetailsPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public PersonalDetailsPageModel(WebDriver webDriver, ExtentTest extentTest) {
		super(webDriver);
		this.extentTest = extentTest;
	}

	public void setDateOfBirth(String string) {
		if (string.isEmpty() || string.equals("null")) {

			textBoxAddress.click();
			// dateOfBirth.click();
			// dateOfBirth.click();
			// overlay.click();
			clickJs(dateOfBirth);
			if (onMacChrome || onMacSafari) {
				clickJs(overlay);
			}
			if (onWinChrome) {
				click(overlay);
			}

		} else {
			setButtonOpenCalendar();
			setDatepicker(string);
		}

	}

	public boolean validateField(OpcDto opcDto) {
//		if(!opcDto.getSheetName().equals(Constant.COUNTRY)) {
			load();	
//		}
		LogUtils.log(opcDto.getSheetName());
		switch (opcDto.getSheetName()) {

		case Constant.COMPANY_NAME:
			return validateCompanyName(opcDto);

		case Constant.ADDRESS:
			return validateAddressCorporate(opcDto);

		case Constant.CITY:
			return validateCityCompany(opcDto);

		case Constant.ZIP_POSTALCODE:
			return validatePostalCode(opcDto);

		case Constant.COUNTRY:
			return validateCountry(opcDto);

		case Constant.TOTAL_NUMBER_OF_DIRECTORS:
			return validateNoOfDirectors(opcDto);

		case Constant.TOTAL_NUMBER_OF_SHAREHOLDERS:
			return validateNoOfShareholders(opcDto);

		case Constant.LICENCES_YOU_HAVE_OBTAINED:
			return validateLicense(opcDto);

		case Constant.BACKGROUND_EXPERIENCE:
			return validateBackground(opcDto);

		}

		return true;
	}

	public boolean validateCompanyName(OpcDto opcDto) {
		LogUtils.log("opcDto.getInputData(): "+opcDto.getInputData());
		if (opcDto.getInputData().equals("null")) {
			setCompanyName("");
			textBoxAddress.click();
		} else {
			setCompanyName(opcDto.getInputData());
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			result = this.getValueCompanyName().equals(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + this.getValueCompanyName());
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		} else {
			result = this.getLabelCompanyNameError().equals(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + this.getLabelCompanyNameError());
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		}

		return result;
	}

	public boolean validateAddressCorporate(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setAddressCorporate("");
			textBoxAddress.click();
		} else {
			setAddressCorporate(opcDto.getInputData());
		}

		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {
			result = getValueAddressCorporate().equals(opcDto.getValidationValue());
			extentTest.info(getValueAddressCorporate());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = getLabelAddressCorporateError().equals(opcDto.getValidationValue());
			extentTest.info(getLabelAddressCorporateError());
			extentTest.info(opcDto.getValidationValue());
		}

		return result;
	}

	public boolean validateCityCompany(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setCityCompany("");
			textBoxAddress.click();
		} else {
			setCityCompany(opcDto.getInputData());
		}
		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			result = getValueCityCompany().equals(opcDto.getValidationValue());
			extentTest.info(getValueCityCompany());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = getLabelCityCompanyError().equals(opcDto.getValidationValue());
			extentTest.info(getLabelCityCompanyError());
			extentTest.info(opcDto.getValidationValue());
		}
		return result;
	}

	public boolean validatePostalCode(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setPostalCode("");
			textBoxAddress.click();
		} else {
			setPostalCode(opcDto.getInputData());
		}

		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			result = getValuePostalCode().equals(opcDto.getValidationValue());
			extentTest.info(getValuePostalCode());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = getLabelPostalCodeError().equals(opcDto.getValidationValue());
			extentTest.info(getLabelPostalCodeError());
			extentTest.info(opcDto.getValidationValue());
		}
		return result;
	}

	public boolean validateCountry(OpcDto opcDto) {
//		if(opcDto.getInputData().startsWith("An")) {
//			return true;
//		}
		setSelectCountry();
		if (opcDto.getInputData().equals("null")) {
			setTextBoxSearchCountry(Keys.ESCAPE + "");
		} else {
			setTextBoxSearchCountry(opcDto.getInputData());
			if(!opcDto.getValidationType().equals("No_result_found")) {
				setOptionSearchCountry(opcDto.getInputData());
			}
		}

		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			result = getValueSearchCountry().equals(opcDto.getValidationValue());
			extentTest.info(getValueSearchCountry());
			extentTest.info(opcDto.getValidationValue());
		} 
		else if (opcDto.getValidationType().equals("No_result_found")){
			result = getNoResultsFoundGetText().equals(opcDto.getValidationValue());
			extentTest.info(getNoResultsFoundGetText());
			extentTest.info(opcDto.getValidationValue());
			load();
		}
		else {
			result = getLabelCountryError().equals(opcDto.getValidationValue());
			extentTest.info(getLabelCountryError());
			extentTest.info(opcDto.getValidationValue());
		}
		return result;
	}

	public boolean validateNoOfDirectors(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setNoOfDirectors("");
			textBoxAddress.click();
		} else {
			setNoOfDirectors(opcDto.getInputData());
		}

		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			result = getValueNoOfDirectors().equals(opcDto.getValidationValue());
			extentTest.info(getValueNoOfDirectors());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = getLabelNoOfDirectorsError().equals(opcDto.getValidationValue());
			extentTest.info(getLabelNoOfDirectorsError());
			extentTest.info(opcDto.getValidationValue());
		}
		return result;

	}

	public boolean validateNoOfShareholders(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setNoOfShareholders("");
			textBoxAddress.click();
		} else {
			setNoOfShareholders(opcDto.getInputData());
		}

		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			result = getValueNoOfShareholders().equals(opcDto.getValidationValue());
			extentTest.info(getValueNoOfShareholders());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = getLabelNoOfShareholdersError().equals(opcDto.getValidationValue());
			extentTest.info(getLabelNoOfShareholdersError());
			extentTest.info(opcDto.getValidationValue());
		}
		return result;

	}

	public boolean validateLicense(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {

		} else {
			setLicense(opcDto.getInputData());
		}
		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			if (opcDto.getValidationValue().equals("null")) {
				result = getValueLicense().isEmpty();
			} else {
				result = getValueLicense().equals(opcDto.getValidationValue());
			}
			extentTest.info(getValueLicense());
			extentTest.info(opcDto.getValidationValue());
		} else {

		}
		return result;
	}

	public boolean validateBackground(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {

		} else {
			setBackground(opcDto.getInputData());
		}
		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			if (opcDto.getValidationValue().equals("null")) {
				result = getValueBackground().isEmpty();
			} else {
				result = getValueBackground().equals(opcDto.getValidationValue());
			}
			extentTest.info(getValueBackground());
			extentTest.info(opcDto.getValidationValue());
		} else {

		}
		return result;
	}

	public String getDayInTextBoxDateOfBirthValue() {
		String date = getTextBoxDateOfBirthValue();
		String[] g = date.split(" ");
		// String month = g[0];
		String day = g[1].replace(",", "");
		return day;
	}

	// public boolean validateButtonProceed(CorpPersonDetailDto corpPersonDetailDto)
	// {
	// boolean result = true;
	// setCompanyName(corpPersonDetailDto.getCompanyName());
	// setAddressCorporate(corpPersonDetailDto.getCompanyAddress());
	// setCityCompany(corpPersonDetailDto.getCity());
	// setPostalCode(corpPersonDetailDto.getCompanyZipPostalcode());
	// this.state
	// corpPersonDetailDto.getCompanyStateProvince()
	// return result;
	//
	// }

	public void fillDataIndividual() {
		setSelectLanguage();
		setTextBoxSearchLanguage("English");
		setOptionSearchLanguage("English");
		setTextBoxAddress("Cau Giay,  Xuan Thuy Street, Lang Ha Ward");
		setTextBoxCity("HaNoi");
		setTextBoxZip("123lotus");
		setTextBoxState("banca");
		setDateOfBirth("Apr 1, 2002");
		setSelectGender();
		setOptionFemale();
		setRadioPepIndividual("Yes");
		setRadioUsIndividual("No");
		setCheckboxCa("Check");
	}

	public boolean isWaitDisplay() {
		for (int i = 0; i < 22; i++) {
			if (webDriver.getTitle().contains("Personal Details")) {
				return true;
			} else {
				System.out.println("NOT isDisplay");
				iwait(500);
			}
		}
		return false;
	}
}
