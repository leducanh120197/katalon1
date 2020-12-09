package com.opcbiz.fxprimus.page.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.OpcDto;
import com.opcbiz.fxprimus.dto.register.JointPersonDetailDto;
import com.opcbiz.fxprimus.utils.LogUtils;

public class PersonalDetailsJointPageModel extends PersonalDetailsPageModel {

	@FindBy(id = "jointFirstName")
	WebElement textBoxJointFirstName;
	@FindBy(id = "jointLastName")
	WebElement textBoxJointLastName;
	@FindBy(id = "jointEmail")
	WebElement textBoxJointEmail;
	@FindBy(id = "jointAddress")
	WebElement textBoxJointAddress;
	@FindBy(id = "jointCity")
	WebElement textBoxJointCity;
	@FindBy(id = "jointZip")
	WebElement textBoxJointZip;
	@FindBy(id = "jointState")
	WebElement textBoxJointState;
	@FindBy(id = "jointPhoneNumber")
	WebElement textBoxJointPhoneNumber;

	@FindBy(xpath = "//*[@id='jointFirstName']/../../../../../div/p/span")
	WebElement labelErrorJointFirstName;
	@FindBy(xpath = "//*[@id='jointLastName']/../../../../../div/p/span")
	WebElement labelErrorJointLastName;
	@FindBy(xpath = "//*[@id='jointEmail']/../../../../../div/p/span")
	WebElement labelErrorJointEmail;
	@FindBy(xpath = "//*[@id='jointAddress']/../../../../../div/p/span")
	WebElement labelErrorJointAddress;
	@FindBy(xpath = "//*[@id='jointCity']/../../../../../div/p/span")
	WebElement labelErrorJointCity;
	@FindBy(xpath = "//*[@id='jointZip']/../../../../../div/p/span")
	WebElement labelErrorJointZip;
	@FindBy(xpath = "//*[@id='jointState']/../../../../../div/p/span")
	WebElement labelErrorJointState;
	@FindBy(xpath = "//*[@id='jointPhoneNumber']/../../../../../../div/p/span")
	WebElement labelErrorJointPhoneNumber;

	@FindBy(xpath = "//*[@id='jointDateOfBirth']/../../../../../div/span")
	WebElement labelErrorJointDateOfBirth;

	@FindBy(xpath = "//form[2]//mat-select[@id='country']")
	WebElement selectJointCountry;
	@FindBy(xpath = "//form[2]//*[@id='country']//span/span")
	WebElement valueJointSearchCountry;

	@FindBy(xpath = "//form[2]//*[@id='country']/../../../../../div/p/span")
	WebElement labelJointCountryError;

//	WebElement textBoxSearchCountry; inheritance
//	WebElement optionSearchCountry; inheritance

	@FindBy(id = "jointDateOfBirth")
	WebElement datePickerJointDateOfBirth;

	@FindBy(id = "jointGender")
	WebElement selectJointGender;

	@FindBy(xpath = "//*[@id='jointGender']//span/span")
	WebElement valueJointGender;

	@FindBy(id = "jointLanguage")
	WebElement selectJointLanguage;

	@FindBy(xpath = "//*[@id='jointLanguage']/../../../../../div/p/span")
	WebElement labelErrorJointLanguage;

	@FindBy(xpath = "//button[contains(@class,'submit')]")
	WebElement buttonSubmit;

	@FindBy(xpath = "//mat-checkbox/label")
	WebElement checkboxCa;

	public PersonalDetailsJointPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public void setTextBoxJointFirstName(String textBoxJointFirstName) {
		type(textBoxJointFirstName, this.textBoxJointFirstName);
	}

	public void setTextBoxJointLastName(String textBoxJointLastName) {
		type(textBoxJointLastName, this.textBoxJointLastName);
	}

	public void setTextBoxJointEmail(String textBoxJointEmail) {
		type(textBoxJointEmail, this.textBoxJointEmail);
	}

	public void setTextBoxJointAddress(String textBoxJointAddress) {
		type(textBoxJointAddress, this.textBoxJointAddress);
	}

	public void setTextBoxJointCity(String textBoxJointCity) {
		type(textBoxJointCity, this.textBoxJointCity);
	}

	public void setTextBoxJointZip(String textBoxJointZip) {
		type(textBoxJointZip, this.textBoxJointZip);
	}

	public void setTextBoxJointState(String textBoxJointState) {
		type(textBoxJointState, this.textBoxJointState);
	}

	public void setTextBoxJointPhoneNumber(String textBoxJointPhoneNumber) {
		type(textBoxJointPhoneNumber, this.textBoxJointPhoneNumber);
	}

	public void setDatePickerJointDateOfBirth(String string) {
		WebElement webElement;
		String xpathExpression = "//*[@id='jointDateOfBirth']";
		webElement = webDriver.findElement(By.xpath(xpathExpression));
		try {
			if (onMacSafari || onMacChrome) {
				scrollJs(webElement);
				clickJs(webElement);

			}
			if (onWinChrome) {
				webElement.click();
			}

		} catch (Exception exception) {
		}
//		xpathExp

		if (string.isEmpty() || string.equals("null")) {
//			click(this.datePickerJointDateOfBirth);
			click(overlay);
		} else {
//			click(this.datePickerJointDateOfBirth);
			this.datepicker = webDriver.findElement(By.xpath("(//*[@id='mat-datepicker-1']//td/div)[" + 1 + "]"));
			if (onWinChrome) {
				this.datepicker.click();
			}
//			x
			if (onMacChrome || onMacSafari) {
				clickJs(this.datepicker);
			}

		}

	}

	public void setSelectJointCountry(OpcDto opcDto) {
		if (onWinChrome) {
			click(selectJointCountry);
		}
		if (onMacChrome || onMacSafari) {
			iwait(999);
			clickJs(selectJointCountry);
			iwait(999);
		}
		if (opcDto.getInputData().equals("null")) {
//			return true;
			WebElement we = webDriver.findElement(By.xpath("//*[contains(@class, 'cdk-overlay-backdrop')]"));
			clickJs(we);

		} else {
			setTextBoxSearchCountry(opcDto.getInputData());
			iwait(999);
			
			if(!opcDto.getValidationType().equals("No_result_found")) {
				setOptionSearchCountry(opcDto.getInputData());
			}
			iwait(999);
		}

	}

	public void setButtonSubmit() {
		click(buttonSubmit);
		waitPageLoad(Constant.TRADING_ACCOUNT);
	}

	// value
	public String getValueCompanyName() {
		return this.companyName.getAttribute("value");
	}

	public String getValueTextBoxJointFirstName() {
		return this.textBoxJointFirstName.getAttribute("value");
	}

	public String getValueTextBoxJointLastName() {
		return this.textBoxJointLastName.getAttribute("value");
	}

	public String getValueTextBoxJointEmail() {
		return this.textBoxJointEmail.getAttribute("value");
	}

	public String getValueTextBoxJointAddress() {
		return this.textBoxJointAddress.getAttribute("value");
	}

	public String getValueTextBoxJointCity() {
		return this.textBoxJointCity.getAttribute("value");
	}

	public String getValueTextBoxJointZip() {
		return this.textBoxJointZip.getAttribute("value");
	}

	public String getValueTextBoxJointState() {
		return this.textBoxJointState.getAttribute("value");
	}

	public String getValueTextBoxJointPhoneNumber() {
		return this.textBoxJointPhoneNumber.getAttribute("value");
	}

	// error
	public String getLabelErrorJointFirstName() {
		return this.labelErrorJointFirstName.getText();
	}

	public String getLabelErrorJointLastName() {
		return this.labelErrorJointLastName.getText();
	}

	public String getLabelErrorJointEmail() {
		return this.labelErrorJointEmail.getText();
	}

	public String getLabelErrorJointAddress() {
		return this.labelErrorJointAddress.getText();
	}

	public String getLabelErrorJointCity() {
		return this.labelErrorJointCity.getText();
	}

	public String getLabelErrorJointZip() {
		return this.labelErrorJointZip.getText();
	}

	public String getLabelErrorJointState() {
		return this.labelErrorJointState.getText();
	}

	public String getLabelErrorJointPhoneNumber() {
		return this.labelErrorJointPhoneNumber.getText();
	}

	public boolean validateJointField(OpcDto opcDto) {
		 
		if(!opcDto.getSheetName().equals(Constant.COUNTRY)) {
			load();
		}
		switch (opcDto.getSheetName()) {

		case Constant.FIRST_NAME:
			return validateJointFirstName(opcDto);

		case Constant.LAST_NAME:
			return validateJointLastName(opcDto);

		case Constant.EMAIL:
			return validateJointEmail(opcDto);

		case Constant.ADDRESS:
			return validateJointAddress(opcDto);

		case Constant.CITY_TOWN:
			return validateJointCity(opcDto);

		case Constant.ZIP_POSTALCODE:
			return validateJointZip(opcDto);

		case Constant.STATE:
			return validateJointState(opcDto);

		case Constant.DATE_OF_BIRTH:
			return validateJointDateOfBirth(opcDto);

		case Constant.COUNTRY:
			return validateJointCountry(opcDto);

		case Constant.GENDER:
			return validateJointGender(opcDto);

		case Constant.LANGUAGE:
			return validateJointLanguage(opcDto);

		case Constant.PHONE_NUMBER:
			return validateJointPhoneNumber(opcDto);

		case Constant.QUESTION_POLITICALLY_ACC2:
			return validateJointQuestionPoliticallyAcc2(opcDto);

		case Constant.QUESTION_US_CITIZENSHIP_ACC2:
			return validateJointQuestionUsCitizenshipAcc2(opcDto);

		}
		return false;
	}

	public boolean validateJointFirstName(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setTextBoxJointFirstName("");
			textBoxCity.click();
		} else {
			setTextBoxJointFirstName(opcDto.getInputData());
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			result = this.getValueTextBoxJointFirstName().contains(opcDto.getValidationValue());
			extentTest.info(this.getValueTextBoxJointFirstName());
			extentTest.info(opcDto.getValidationValue());
		} else {
			String error = this.getLabelErrorJointFirstName();
			result = error.contains(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + error);
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointLastName(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setTextBoxJointLastName("");
			textBoxAddress.click();
		} else {
			setTextBoxJointLastName(opcDto.getInputData());
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			result = this.getValueTextBoxJointLastName().contains(opcDto.getValidationValue());
			extentTest.info(this.getValueTextBoxJointLastName());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = this.getLabelErrorJointLastName().contains(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + this.getLabelErrorJointLastName());
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointEmail(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setTextBoxJointEmail("");
			textBoxAddress.click();
		} else {
			setTextBoxJointEmail(opcDto.getInputData());
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			result = this.getValueTextBoxJointEmail().contains(opcDto.getValidationValue());
			extentTest.info(this.getValueTextBoxJointEmail());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = this.getLabelErrorJointEmail().contains(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + this.getLabelErrorJointEmail());
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointAddress(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setTextBoxJointAddress("");
			textBoxAddress.click();
		} else {
			setTextBoxJointAddress(opcDto.getInputData());
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			result = this.getValueTextBoxJointAddress().contains(opcDto.getValidationValue());
			extentTest.info(this.getValueTextBoxJointAddress());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = this.getLabelErrorJointAddress().contains(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + this.getLabelErrorJointAddress());
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointCity(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setTextBoxJointCity("");
			textBoxCity.click();
		} else {
			setTextBoxJointCity(opcDto.getInputData());
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			result = this.getValueTextBoxJointCity().contains(opcDto.getValidationValue());
			extentTest.info(this.getValueTextBoxJointCity());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = this.getLabelErrorJointCity().contains(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + this.getLabelErrorJointCity());
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointZip(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setTextBoxJointZip("");
			textBoxZip.click();
		} else {
			setTextBoxJointZip(opcDto.getInputData());
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			result = this.getValueTextBoxJointZip().contains(opcDto.getValidationValue());
			extentTest.info(this.getValueTextBoxJointZip());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = this.getLabelErrorJointZip().contains(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + this.getLabelErrorJointZip());
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointState(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setTextBoxJointState("");
			textBoxState.click();
		} else {
			setTextBoxJointState(opcDto.getInputData());
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {
			if (opcDto.getValidationValue().equals("null")) {
				opcDto.setValidationValue("");
			}
			result = this.getValueTextBoxJointState().contains(opcDto.getValidationValue());
			extentTest.info(this.getValueTextBoxJointState());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = this.getLabelErrorJointState().contains(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + this.getLabelErrorJointState());
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointCountry(OpcDto opcDto) {
		setSelectJointCountry(opcDto);
		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {
			String text = this.valueJointSearchCountry.getText();
			result = text.equals(opcDto.getValidationValue());
			extentTest.info(text);
			extentTest.info(opcDto.getValidationValue());
			
		}
		else if (opcDto.getValidationType().equals("No_result_found")){
			result = getNoResultsFoundGetText().equals(opcDto.getValidationValue());
			extentTest.info(getNoResultsFoundGetText());
			extentTest.info(opcDto.getValidationValue());
			load();
		}
		
		else {
			String text = this.labelJointCountryError.getText();
			result = text.equals(opcDto.getValidationValue());
			extentTest.info(getLabelCountryError());
			extentTest.info(opcDto.getValidationValue());
		}
		return result;
		
//		return false;
	}

	private boolean validateJointDateOfBirth(OpcDto opcDto) {
		setDatePickerJointDateOfBirth(opcDto.getInputData());
		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {
			String text = this.datePickerJointDateOfBirth.getAttribute("value");
			result = text.equals(opcDto.getValidationValue());
			extentTest.info(text);
			extentTest.info(opcDto.getValidationValue());
		} else {
			String text = this.labelErrorJointDateOfBirth.getText();
			result = text.equals(opcDto.getValidationValue());
			extentTest.info(text);
			extentTest.info(opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointGender(OpcDto opcDto) {
		if (opcDto.getInputData().equals("Male")) {
			if (onMacChrome || onMacSafari) {
				clickJs(selectJointGender);
				clickJs(optionMale);
			}
			if (onWinChrome) {
				click(selectJointGender);
				click(optionMale);
			}

		}
		if (opcDto.getInputData().equals("Female")) {
			if (onMacChrome || onMacSafari) {
				clickJs(selectJointGender);
				clickJs(optionFemale);
			}
			if (onWinChrome) {
				click(selectJointGender);
				click(optionFemale);
			}

		}
		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {
			if (opcDto.getInputData().equals("null")) {
				return true;
			}
			String text = this.valueJointGender.getText();
			result = text.equals(opcDto.getValidationValue());
			extentTest.info(text);
			extentTest.info(opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointLanguage(OpcDto opcDto) {
		if (onMacChrome || onMacSafari) {
			iwait(2222);
			scrollJs(selectJointLanguage);
			clickJs(selectJointLanguage);
		}
		if (onWinChrome) {
			click(selectJointLanguage);
		}

		if (opcDto.getInputData().equals("null")) {
			WebElement webElement = webDriver.findElement(By.xpath("//span[contains(text(),'--')]/.."));
			clickJs(webElement);
		} else {
			WebElement webElement = webDriver
					.findElement(By.xpath("//span[contains(text(),'" + opcDto.getInputData() + "')]/.."));
			clickJs(webElement);
		}
		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {
			String text = webDriver
					.findElement(By.xpath("//span[contains(text(),'" + opcDto.getValidationValue() + "')]/.."))
					.getText();
			result = text.equals(opcDto.getValidationValue());
			extentTest.info(text);
			extentTest.info(opcDto.getValidationValue());
		} else {
			String text = this.labelErrorJointLanguage.getText();
			result = text.equals(opcDto.getValidationValue());
			extentTest.info(text);
			extentTest.info(opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointPhoneNumber(OpcDto opcDto) {
		if (opcDto.getInputData().equals("null")) {
			setTextBoxJointPhoneNumber("");
			textBoxAddress.click();
		} else {
			setTextBoxJointPhoneNumber(opcDto.getInputData());
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			result = this.getValueTextBoxJointPhoneNumber().contains(opcDto.getValidationValue());
			extentTest.info(this.getValueTextBoxJointPhoneNumber());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = this.getLabelErrorJointPhoneNumber().contains(opcDto.getValidationValue());
			extentTest.info("Actual:\t" + this.getLabelErrorJointPhoneNumber());
			extentTest.info("Expected:\t" + opcDto.getValidationValue());
		}
		return result;
	}

	private boolean validateJointQuestionPoliticallyAcc2(OpcDto opcDto) {
		if (opcDto.getValidationType().equals("single_choice")) {
			if (opcDto.getInputData().equals("yes")) {
				WebElement webElement = webDriver.findElement(
						By.xpath("//mat-radio-group[@formcontrolname='jointPoliticallyExposed']/mat-radio-button[1]"));
				if(onMacChrome) {
					click(webElement);
				}
				else {
					click(webElement);
				}
			}
			if (opcDto.getInputData().equals("no")) {
				WebElement webElement = webDriver.findElement(
						By.xpath("//mat-radio-group[@formcontrolname='jointPoliticallyExposed']/mat-radio-button[2]"));
				click(webElement);
			}
			boolean selected = true;
			if (opcDto.getValidationValue().equals("yes")) {
				WebElement webElement = webDriver.findElement(By
						.xpath("//mat-radio-group[@formcontrolname='jointPoliticallyExposed']/mat-radio-button[1]//input"));
				selected = webElement.isSelected();
			}
			if (opcDto.getValidationValue().equals("no")) {
				WebElement webElement = webDriver.findElement(By
						.xpath("//mat-radio-group[@formcontrolname='jointPoliticallyExposed']/mat-radio-button[2]//input"));
				selected = webElement.isSelected();
			}
			if (opcDto.getValidationValue().equals("null")) {
				opcDto.setValidationValue("");
			}

			return selected;
		}

		return true;
	}

	private boolean validateJointQuestionUsCitizenshipAcc2(OpcDto opcDto) {
		if (opcDto.getValidationType().equals("single_choice")) {
			if (opcDto.getInputData().equals("yes")) {
				WebElement webElement = webDriver.findElement(
						By.xpath("//mat-radio-group[@formcontrolname='jointUsCitizenship']/mat-radio-button[1]"));
				click(webElement);
			}
			if (opcDto.getInputData().equals("no")) {
				WebElement webElement = webDriver.findElement(
						By.xpath("//mat-radio-group[@formcontrolname='jointUsCitizenship']/mat-radio-button[2]"));
				click(webElement);
			}

			boolean selected = true;
			if (opcDto.getValidationValue().equals("yes")) {
				WebElement webElement = webDriver.findElement(
						By.xpath("//mat-radio-group[@formcontrolname='jointUsCitizenship']/mat-radio-button[1]//input"));
				selected = webElement.isSelected();
			}
			if (opcDto.getValidationValue().equals("no")) {
				WebElement webElement = webDriver.findElement(
						By.xpath("//mat-radio-group[@formcontrolname='jointUsCitizenship']/mat-radio-button[2]//input"));
				selected = webElement.isSelected();
			}

			return selected;
		}
		return true;
	}

	// 13 Afar Ba Dinh, Lac Long Quan Street, Lang Thuong Ward, Binh Thanh , Ba Vi
	// District, 123 Tay Son, 02 Son Tay HaNoi 123ab 123ab May 1,2002 yes yes Leana
	// Marid LeanaMarid@gmail.com 123, massco Olasca 123 maha Germany May 1,2002
	// Male English 1256740 yes no check active
	public boolean validateButtonProceed(JointPersonDetailDto jointPersonDetailDto) {
		load();

		// 11 | click | css=.mat-select-value > .ng-tns-c37-48 |
		click(webDriver.findElement(By.id("language")));
		// 12 | click | css=#mat-option-479 > .mat-option-text |
		click(webDriver.findElement(By.xpath("//mat-option/span[text()=' Afar ']")));

		setTextBoxAddress(jointPersonDetailDto.getAddress());
		setTextBoxCity(jointPersonDetailDto.getCityTown());
		setTextBoxZip(jointPersonDetailDto.getZipPostalcode());
		setTextBoxState("abc");
		// setDateOfBirth(jointPersonDetailDto.getDateOfBirth());
		click(webDriver.findElement(By.xpath("//form[1]//mat-datepicker-toggle/button")));

		click(webDriver.findElement(By.xpath("//*[@id='mat-datepicker-0']//tr[1]/td[2]/div")));

		setSelectGender();
		if (jointPersonDetailDto.getGenderAcc1().isEmpty()) {
			setOption__();
		} else if (jointPersonDetailDto.getGenderAcc1().equals("Male")) {
			setOptionMale();
		} else if (jointPersonDetailDto.getGenderAcc1().equals("Female")) {
			setOptionFemale();
		}

		setRadioPep(jointPersonDetailDto.getQuestionPoliticallyCc1());
		setRadioUs(jointPersonDetailDto.getQuestionUsCitizenshipCc1());

		LogUtils.log("Done for profile. Start info joint");
		
		setTextBoxJointAddress(jointPersonDetailDto.getAddress2());
		setTextBoxJointEmail(jointPersonDetailDto.getEmail());
		setTextBoxJointFirstName(jointPersonDetailDto.getFirstName());
		setTextBoxJointLastName(jointPersonDetailDto.getLastName());

		setTextBoxJointCity(jointPersonDetailDto.getCityTown2());
		setTextBoxJointState(jointPersonDetailDto.getStateAcc2());
		setTextBoxJointZip(jointPersonDetailDto.getZipPostalcode2());

		setSelectJointCountry(new OpcDto("", "", jointPersonDetailDto.getCountry(), "", "", ""));

		setDatePickerJointDateOfBirth(jointPersonDetailDto.getDateOfBirth2());

		setTextBoxJointPhoneNumber(jointPersonDetailDto.getPhoneNumber());

		if (jointPersonDetailDto.getGenderAcc2().equals("Male")) {
			if (onMacChrome || onMacSafari) {
				clickJs(selectJointGender);
				clickJs(optionMale);
			}
			if (onWinChrome) {
				click(selectJointGender);
				click(optionMale);
			}

		}
		if (jointPersonDetailDto.getGenderAcc2().equals("Female")) {
			clickJs(selectJointGender);
			clickJs(optionFemale);
		}

		clickJs(selectJointLanguage);
		if (!jointPersonDetailDto.getLanguage2().equals("null")) {
			WebElement webElement = webDriver
					.findElement(By.xpath("//span[contains(text(),'" + jointPersonDetailDto.getLanguage2() + "')]/.."));
			clickJs(webElement);
		}

		if (jointPersonDetailDto.getQuestionPoliticallyAcc2().equals("Yes")) {
			WebElement webElement = webDriver.findElement(
					By.xpath("//mat-radio-group[@formcontrolname='jointPoliticallyExposed']/mat-radio-button[1]/label"));

			if (onWinChrome) {
				click(webElement);
			}
			if (onMacChrome || onMacSafari) {
				clickJs(webElement);
			}
		}
		if (jointPersonDetailDto.getQuestionPoliticallyAcc2().equals("No")) {
			WebElement webElement = webDriver.findElement(
					By.xpath("//mat-radio-group[@formcontrolname='jointPoliticallyExposed']/mat-radio-button[2]/label"));
			if (onWinChrome) {
				click(webElement);
			}
			if (onMacChrome || onMacSafari) {
				clickJs(webElement);
			}
		}
		if (jointPersonDetailDto.getQuestionUsCitizenshipAcc2().equals("Yes")) {
			WebElement webElement = webDriver.findElement(
					By.xpath("//mat-radio-group[@formcontrolname='jointUsCitizenship']/mat-radio-button[1]/label"));
			if (onWinChrome) {
				click(webElement);
			}
			if (onMacChrome || onMacSafari) {
				clickJs(webElement);
			}
		}
		if (jointPersonDetailDto.getQuestionUsCitizenshipAcc2().equals("No")) {
			WebElement webElement = webDriver.findElement(
					By.xpath("//mat-radio-group[@formcontrolname='jointUsCitizenship']/mat-radio-button[2]/label"));
			if (onWinChrome) {
				click(webElement);
			}
			if (onMacChrome || onMacSafari) {
				clickJs(webElement);
			}
		}

		if (onWinChrome) {
			click(checkboxCa);
		}
		if (onMacChrome || onMacSafari) {
			clickJs(checkboxCa);
		}
 
		//click(checkboxCa);
		
 
		boolean result = true;
		boolean inputActive = jointPersonDetailDto.getButtonProceedValidation().equals("active");
		result = buttonSubmit.isEnabled() == inputActive;
		return result;
	}

	public void setExtentTest(ExtentTest extentTest) {
		this.extentTest = extentTest;
	}

}
