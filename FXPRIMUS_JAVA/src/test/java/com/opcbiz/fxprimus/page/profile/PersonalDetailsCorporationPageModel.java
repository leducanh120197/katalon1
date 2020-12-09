package com.opcbiz.fxprimus.page.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.register.CorpPersonDetailDto;

public class PersonalDetailsCorporationPageModel extends PersonalDetailsPageModel{
	

	@FindBy(id = "companyName")
	WebElement textBoxCompanyName;
	@FindBy(id = "companyAddress")
	WebElement textBoxCompanyAddress;
	@FindBy(id = "city")
	WebElement textBoxCity;
	@FindBy(id = "postalCode")
	WebElement textBoxPostalCode;
	@FindBy(id = "state")
	WebElement textBoxState;
	@FindBy(id = "noOfDirectors")
	WebElement textBoxNoOfDirectors;
	@FindBy(id = "noOfShareholders")
	WebElement textBoxNoOfShareholders;
	@FindBy(id = "license")
	WebElement textBoxLicense;
	@FindBy(id = "background")
	WebElement textBoxBackground;
	
	@FindBy(xpath = "companyName")
	WebElement labelCompanyNameError;
	@FindBy(xpath = "companyAddress")
	WebElement labelCompanyAddressError;
	@FindBy(xpath = "city")
	WebElement labelCityError;
	@FindBy(xpath = "postalCode")
	WebElement labelPostalCodeError;
	@FindBy(xpath = "state")
	WebElement labelStateError;
	@FindBy(xpath = "noOfDirectors")
	WebElement labelNoOfDirectorsError;
	@FindBy(xpath = "noOfShareholders")
	WebElement labelNoOfShareholdersError;
	@FindBy(xpath = "license")
	WebElement labelLicenseError;
	@FindBy(xpath = "background")
	WebElement labelBackgroundError;
	
	@FindBy(id = "country")
	WebElement selectCountry;
	
	@FindBy(xpath = "//*[contains(@placeholder,'Search Country')]")
	WebElement textBoxSearchCountry;
	
	WebElement optionSearchCountry;
	
	@FindBy(xpath = "//*[@id='country']//span/span")
	WebElement valueSearchCountry;
	
	@FindBy(xpath = "//*[@id='country']/../../../../../div/p/span")
	WebElement labelCountryError;
	
	@FindBy(xpath = "//*[contains(text(),'PERSONAL DETAILS')]/..//*[@id='city']")
	WebElement cityPersonal;
	
	@FindBy(xpath = "//*[contains(text(),'PERSONAL DETAILS')]/..//*[@id='zip']")
	WebElement zipPersonal;
	
	@FindBy(xpath = "//*[contains(text(),'PERSONAL DETAILS')]/..//*[@id='state']")
	WebElement statePersonal;
	
	//fri
	@FindBy(xpath = "//*[@formcontrolname='politically_exposed']/mat-radio-button[1]/label")
	WebElement radioCorPepYes;

	@FindBy(id = "mat-radio-2-input")
	WebElement radioCorPepYesInput;

	@FindBy(xpath = "//*[@formcontrolname='politically_exposed']/mat-radio-button[2]/label")
	WebElement radioCorPepNo;

	@FindBy(id = "mat-radio-3-input")
	WebElement radioCorPepNoInput;

	@FindBy(xpath = "//*[@formcontrolname='us_citizen']/mat-radio-button[1]/label")
	WebElement radioCorUsYes;

	@FindBy(id = "mat-radio-5-input")
	WebElement radioCorUsYesInput;

	@FindBy(xpath = "//*[@formcontrolname='us_citizen']/mat-radio-button[2]/label")
	WebElement radioCorUsNo;

	@FindBy(id = "mat-radio-6-input")
	WebElement radioCorUsNoInput;

	@FindBy(xpath = "//*[@formcontrolname='us_citizen']/../../div/span")
	WebElement labelCorUsError;
	//friend
	
//	@FindBy(id = "license")
//	WebElement textBoxLicense;
	
	public String getLabelCountryError() {
		return this.labelCountryError.getText();
	}
	
	public String getValueSearchCountry() {
		return this.valueSearchCountry.getText();
	}
	
	public void setOptionSearchCountry(String optionSearchCountry) {
		this.optionSearchCountry = this.webDriver.findElement(By.xpath(
				"//mat-option[@role='option']/span[text()=' "+optionSearchCountry+" ']"));
		click(this.optionSearchCountry);
	}
	public void setTextBoxSearchCountry(String textBoxSearchCountry) {
		this.textBoxSearchCountry.clear();
		type(textBoxSearchCountry, this.textBoxSearchCountry);
	}
	
	public void setSelectCountry() {
		click(selectCountry);
	}

	public void setTextBoxCompanyName(String textBoxCompanyName) {
		type(textBoxCompanyName, this.textBoxCompanyName);
	}

	public void setTextBoxCompanyAddress(String textBoxCompanyAddress) {
		type(textBoxCompanyAddress, this.textBoxCompanyAddress);
	}

	public void setTextBoxCity(String textBoxCity) {
		type(textBoxCity, this.textBoxCity);
	}

	public void setTextBoxPostalCode(String textBoxPostalCode) {
		type(textBoxPostalCode, this.textBoxPostalCode);
	}

	public void setTextBoxState(String textBoxState) {
		type(textBoxState, this.textBoxState);
	}

	public void setTextBoxNoOfDirectors(String textBoxNoOfDirectors) {
		type(textBoxNoOfDirectors, this.textBoxNoOfDirectors);
	}

	public void setTextBoxNoOfShareholders(String textBoxNoOfShareholders) {
		type(textBoxNoOfShareholders, this.textBoxNoOfShareholders);
	}

	public void setTextBoxLicense(String textBoxLicense) {
		type(textBoxLicense, this.textBoxLicense);
	}

	public void setTextBoxBackground(String textBoxBackground) {
		type(textBoxBackground, this.textBoxBackground);
	}
	
	public String getTextBoxCompanyName() {
		return this.textBoxCompanyName.getAttribute("value");
	}

	public String getTextBoxCompanyAddress() {
		return this.textBoxCompanyAddress.getAttribute("value");
	}

	public String getTextBoxCity() {
		return this.textBoxCity.getAttribute("value");
	}

	public String getTextBoxPostalCode() {
		return this.textBoxPostalCode.getAttribute("value");
	}

	public String getTextBoxState() {
		return this.textBoxState.getAttribute("value");
	}

	public String getTextBoxNoOfDirectors() {
		return this.textBoxNoOfDirectors.getAttribute("value");
	}

	public String getTextBoxNoOfShareholders() {
		return this.textBoxNoOfShareholders.getAttribute("value");
	}

	public String getTextBoxLicense() {
		return this.textBoxLicense.getAttribute("value");
	}

	public String getTextBoxBackground() {
		return this.textBoxBackground.getAttribute("value");
	}
	
	public String getLabelCompanyNameError() {
		return this.labelCompanyNameError.getText();
	}

	public String getLabelCompanyAddressError() {
		return this.labelCompanyAddressError.getText();
	}

	public String getLabelCityError() {
		return this.labelCityError.getText();
	}

	public String getLabelPostalCodeError() {
		return this.labelPostalCodeError.getText();
	}

	public String getLabelStateError() {
		return this.labelStateError.getText();
	}

	public String getLabelNoOfDirectorsError() {
		return this.labelNoOfDirectorsError.getText();
	}

	public String getLabelNoOfShareholdersError() {
		return this.labelNoOfShareholdersError.getText();
	}

	public String getLabelLicenseError() {
		return this.labelLicenseError.getText();
	}

	public String getLabelBackgroundError() {
		return this.labelBackgroundError.getText();
	}
	
	public void setRadioCorpPepYes() {
		if (onMacSafari) {
			clickJs(this.radioCorPepYes);
		}
		if (onMacChrome) {
			click(this.radioCorPepYes);
		}
		if (onWinChrome) {
			click(this.radioCorPepYes);
		}
	}

	public void setRadioCorpPepNo() {
		if (onMacChrome || onMacSafari) {
			clickJs(this.radioCorPepNo);
		}
		if (onMacChrome) {
			click(this.radioCorPepNo);
		}
		if (onWinChrome) {
			click(this.radioCorPepNo);
		}
	}
	
	public void setRadioCorpPep(String option) {
		if (option.equals("Yes")) {
			setRadioCorpPepYes();
		}
		if (option.equals("No")) {
			setRadioCorpPepNo();
		}
	}
	public void setRadioCorpUsYes() {
		if (onMacSafari) {
			clickJs(this.radioCorUsYes);
		}
		if (onMacChrome) {
			click(this.radioCorUsYes);
		}
		if (onWinChrome) {
			click(this.radioCorUsYes);
		}
	}

	public void setRadioCorpUsNo() {
		if (onMacSafari) {
			clickJs(this.radioCorUsNo);
		}
		if (onMacChrome) {
			click(this.radioCorUsNo);
		}
		if (onWinChrome) {
			click(this.radioCorUsNo);
		}
	}
	
	public void setRadioCorpUs(String option) {
		if (option.equals("Yes")) {
			setRadioCorpUsYes();
		}
		if (option.equals("No")) {
			setRadioCorpUsNo();
		}
	}
	
	public PersonalDetailsCorporationPageModel(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public PersonalDetailsCorporationPageModel(WebDriver driver, ExtentTest extentTest) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	public boolean validateButtonProceed(CorpPersonDetailDto corpPersonDetailDto) {
		setTextBoxCompanyName(corpPersonDetailDto.getCompanyName());
		setTextBoxCompanyAddress(corpPersonDetailDto.getCompanyAddress());
		setTextBoxCity(corpPersonDetailDto.getCity());
		setTextBoxPostalCode (corpPersonDetailDto.getCompanyZipPostalcode());
		setTextBoxState(corpPersonDetailDto.getCompanyStateProvince());
		
		//country
		setSelectCountry();
		//setTextBoxSearchCountry(Keys.ESCAPE + "");
		setTextBoxSearchCountry(corpPersonDetailDto.getCountry());
		setOptionSearchCountry(corpPersonDetailDto.getCountry());
		
		setTextBoxNoOfDirectors(corpPersonDetailDto.getTotalNumberOfDirectors());
		setTextBoxNoOfShareholders(corpPersonDetailDto.getTotalNumberOfShareholders());
		setLicense(corpPersonDetailDto.getLicencesYouHaveObtained()); 
		setBackground(corpPersonDetailDto.getBackgroundExperience());
		
		setSelectLanguage();
		setTextBoxSearchLanguage(corpPersonDetailDto.getPreferredLanguage());
		setOptionSearchLanguage(corpPersonDetailDto.getPreferredLanguage());
		setTextBoxAddress(corpPersonDetailDto.getAddress());
//		setTextBoxCity(corpPersonDetailDto.getCityTown());
//		setTextBoxZip(corpPersonDetailDto.getZipPostalcode());
//		setTextBoxState(corpPersonDetailDto.getStateProvince());
		
		type(corpPersonDetailDto.getCityTown(), cityPersonal);
		type(corpPersonDetailDto.getZipPostalcode(),zipPersonal);
		type(corpPersonDetailDto.getStateProvince(),statePersonal);

		setDateOfBirth(corpPersonDetailDto.getDateOfBirth());
		
		setSelectGender();
		if (corpPersonDetailDto.getGender().isEmpty()) {
			setOption__();
		} else if (corpPersonDetailDto.getGender().equals("Male")) {
			setOptionMale();
		} else if (corpPersonDetailDto.getGender().equals("Female")) {
			setOptionFemale();
		}

		setRadioCorpPep(corpPersonDetailDto.getQuestionPolitically());
		setRadioCorpUs(corpPersonDetailDto.getQuestionUsCitizenship());
		
		//setCheckboxCa(corpPersonDetailDto.getCheckboxAccept());
		String xpathExpression = "//*[@formcontrolname='agreements']/label";
		clickJs(webDriver.findElement(By.xpath(xpathExpression)));
	
		boolean result = true;
		boolean isActive = corpPersonDetailDto.getButtonProceedValidation().equals("active");	
		boolean isEnabled = buttonProceed.isEnabled();
		result = isActive == isEnabled;
		return result;
	}
	
	public boolean validateShowCorporateProfile() {
		for(int i =0;i<9;i++) {
			iwait(Constant.IN01SEC);
			if(webDriver.getTitle().contains("Corporate Profile")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validateButtonProceedFunction(CorpPersonDetailDto corpPersonDetailDto) {
		validateButtonProceed(corpPersonDetailDto);
		setButtonProceed();
		waitPageLoad(Constant.TRADING_ACCOUNT);
		 
		return validateShowCorporateProfile();
	}
}
