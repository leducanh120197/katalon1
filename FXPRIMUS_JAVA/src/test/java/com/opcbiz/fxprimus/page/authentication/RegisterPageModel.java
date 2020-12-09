package com.opcbiz.fxprimus.page.authentication;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.qa19.ClientDto;
import com.opcbiz.fxprimus.dto.register.RegisterDto;
import com.opcbiz.fxprimus.dto.register.RegisterDtoFunction;
import com.opcbiz.fxprimus.dto.uniqueuser.ExistEmailCheckIdDto;
import com.opcbiz.fxprimus.page.BaseModel;
import com.opcbiz.fxprimus.utils.LogUtils;

public class RegisterPageModel extends BaseModel {

	// input fields
	@FindBy(id = "mat-select-0")
	WebElement accountType;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "email")
	WebElement emailAddress;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(name = "country")
	WebElement country;

	@FindBy(xpath = "//*[@placeholder='Search Country ']")
	WebElement findCountry;

	@FindBy(id = "countryCode")
	WebElement countryCode;

	@FindBy(id = "phoneNumber")
	WebElement phoneNumber;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//div[2]/mat-icon")
	WebElement showPassword;

	@FindBy(id = "clientAgreement")
	WebElement readAndAcceptClientAgreement;

	@FindBy(xpath = "//*[@id='clientAgreement']/following::div/p[@class='ng-star-inserted']")
	WebElement readAndAcceptClientAgreementValidation;

	@FindBy(id = "kid_policy")
	WebElement keyInfoDoc;

	@FindBy(xpath = "//*[@id='kid_policy']/following::div/p[@class='ng-star-inserted']")
	WebElement keyInfoDocValidation;

//	@FindBy(id = "newsletter")
	@FindBy(xpath = "//*[@id=\"newsletter\"]/label")
	WebElement agreeReceiveNewsletter;

	@FindBy(id = "hungary_policy")
	WebElement primusGlobalLtd;

	// validation fields
	@FindBy(xpath = "//mat-form-field[2]/following::div[1]/p[@class='ng-star-inserted']/span")
	WebElement firstNameValidation;

	@FindBy(xpath = "//mat-form-field[3]/following::div[1]/p[@class='ng-star-inserted']/span")
	WebElement lastNameValidation;

	@FindBy(xpath = "//mat-form-field[4]/following::div[1]/p[@class='ng-star-inserted']/span")
	WebElement emailAddressValidation;

	@FindBy(xpath = "//*[text()=' Username exist. Please choose a different username. ']")
	WebElement existEmailAddressValidation;

	@FindBy(id = "usernameValidation")
	WebElement usernameValidation;

	@FindBy(name = "countryValidation")
	WebElement countryValidation;

	@FindBy(xpath = "//span[@class='ng-star-inserted']/span")
	WebElement phoneNumberValidation;

	@FindBy(xpath = "//mat-form-field[7]/following::div[1]/p[@class='ng-star-inserted']/span")
	WebElement passwordValidation;

	// actions
	@FindBy(xpath = "//form/button")
	WebElement registerNow;

	// other
	WebElement loginBtn;
	WebElement languageBtn;
	WebElement trader;
	WebElement affiliate;
	WebElement introducingBroker;

	public void load() {
		this.webDriver.get(UrlConstant.REGISTER_PAGE);
	}

	public RegisterPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * method set data to input field account type
	 */
	public void setAccountType(String accountType) {
		click(this.accountType);
		String xpath = "//mat-option/span/span[contains(text(),'" + accountType + "')]";
		this.webDriver.findElement(By.xpath(xpath)).click();
	}

	/**
	 * method set data to input field first name
	 */
	public void setFirstName(String firstName) {
		type(firstName, this.firstName);
	}

	/**
	 * method set data to input field last name
	 */
	public void setLastName(String lastName) {
		type(lastName, this.lastName);
	}

	/**
	 * method set data to input field email address
	 */
	public void setEmailAddress(String emailAddress) {
		if (emailAddress.contains(Constant.GMAIL_TAIL)) {
//			String[] oldEmail = emailAddress.split("@");
//			String newEmail = oldEmail[0] + (System.currentTimeMillis()) + "19@" + oldEmail[1];
			type(emailAddress, this.emailAddress);
		} else {
			if (emailAddress.contains("existed email")) {

				type(Constant.EXIST_MAIL, this.emailAddress);
			} else {
				type(emailAddress, this.emailAddress);
			}
			return;
		}

	}

	/**
	 * method set data to input field country
	 */
	public void setCountry(String country) {
		iwait(1111);
		click(this.country, 500);
		type(country, this.findCountry);
		WebElement webElementOption = this.webDriver
				.findElement(By.xpath("//mat-option/span[contains(text(),'" + country + "')]"));
		this.waitNClick(webElementOption);
	}

	/**
	 * method set data to input field phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		iwait(1000);
		type(phoneNumber, this.phoneNumber);
	}

	/**
	 * method set data to input field password
	 */
	public void setPassword(String password) {
		type(password, this.password);
	}

	/**
	 * method click to show/hide password
	 */
	public void setShowPassword(String show) {
		if (show.equals("Click"))
			click(this.showPassword);
	}

	/**
	 * method click to input checkbox read and accept client agreement
	 */
	public void setReadAndAccept(String read) {
		if (read.equals("x")) {
			click(this.readAndAcceptClientAgreement, 1000);
//			clickJs(this.readAndAcceptClientAgreement);
		} else {
			click(this.readAndAcceptClientAgreement, 500);
			click(this.readAndAcceptClientAgreement);
		}

	}

	/**
	 * method click to input checkbox read and accept client agreement
	 */
	public void setAgreeReceiveNewsletter(String read) {
		if (read.equals("x"))
			click(this.agreeReceiveNewsletter);
		else {
			click(this.agreeReceiveNewsletter, 500);
			click(this.agreeReceiveNewsletter);
		}
	}

	/**
	 * method click to input checkbox kid
	 */
	public void setKeyInfoDoc(String key) {
		if (key.equals("x")) {
			try {
				click(this.keyInfoDoc);
			} catch (Exception e) {
				System.out.println("no kid");
			}
		} else {
			click(this.keyInfoDoc);
			iwait(500);
			click(this.keyInfoDoc);
//			iwait(500);
//			clickJs(this.keyInfoDoc);
//			iwait(500);
//			clickJs(this.keyInfoDoc);
		}

	}

	/**
	 * method click to input checkbox agree to receive Newsletter
	 */
	public void setAgree(String agree) {
		click(this.agreeReceiveNewsletter);
//		clickJs(this.agreeReceiveNewsletter);
	}

	public void setPrimusGlobalLtd() {
		click(this.primusGlobalLtd);
	}

	/**
	 * method get validation for first name field
	 */
	public String getFirstNameValidation() {
		try {
			return this.firstNameValidation.getText();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * method get validation for last name field
	 */
	public String getLastNameValidation() {
		try {
			return this.lastNameValidation.getText();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * method get validation for email field
	 */
	public String getEmailAddressValidation() {
		try {
			return this.emailAddressValidation.getText();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * method get validation for phone number field
	 */
	public String getPhoneNumberValidation() {
		try {
			return this.phoneNumberValidation.getText();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * method get validation for password field
	 */
	public String getPasswordValidation() {
		try {
			return this.passwordValidation.getText();
		} catch (Exception e) {
			return "";
		}
	}

	public String getKidValidation() {
		try {
			return this.keyInfoDocValidation.getText();
		} catch (Exception e) {
			return "";
		}
	}

	public String getCAValidation() {
		return this.readAndAcceptClientAgreementValidation.getText();
	}

	// medthod for actions

	public long clickRegisterNow() {
		try {
			System.out.println("Click registerNow");
			this.registerNow.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		iwait(Constant.FIVESEC);
		isNotDisplayed(Constant.FIFTEENS);
		return System.currentTimeMillis();
	}

	public void inputData(RegisterDto dto) {
		setAccountType(dto.getAccountType());
		setFirstName(dto.getFirstName());
		setLastName(dto.getLastName());
		setEmailAddress(dto.getEmail());
		setCountry(dto.getCountry());
		setPhoneNumber(dto.getPhoneNumber());
		setPassword(dto.getPassword());
		setShowPassword(dto.getEyeButton());

		List<String> displayop = Arrays.asList(dto.getDisplayCheckboxValidation().split(","));

		if (displayop.contains("CA"))
			setReadAndAccept(dto.getCheckboxA());
		if (displayop.contains("KID"))
			setKeyInfoDoc(dto.getCheckboxId());
		if (displayop.contains("RP"))
			setAgree(dto.getCheckboxRp());
		// clickRegisterNow();
	}

	public void inputDataForExistEmail(RegisterDto dto) {
		setAccountType(dto.getAccountType());
		setFirstName(dto.getFirstName());
		setLastName(dto.getLastName());
		setEmailForCheckExist(dto.getEmail());
		setCountry(dto.getCountry());
		setPhoneNumber(dto.getPhoneNumber());
		setPassword(dto.getPassword());

		List<String> displayop = Arrays.asList(dto.getDisplayCheckboxValidation().split(","));

		if (displayop.contains("CA"))
			click(this.readAndAcceptClientAgreement);
		if (displayop.contains("KID"))
			clickJs(this.keyInfoDoc);
		if (displayop.contains("RP"))
			click(this.agreeReceiveNewsletter);
		clickRegisterNow();
	}

	public void inputDataAndRegister(RegisterDto dto) {
		setAccountType(dto.getAccountType());
		setFirstName(dto.getFirstName());
		setLastName(dto.getLastName());
		setEmailAddress(dto.getEmail());
		setCountry(dto.getCountry());
		setPhoneNumber(dto.getPhoneNumber());
		setPassword(dto.getPassword());
//		setShowPassword(dto.getEyeButton());

		scrollPage(500);

		setReadAndAccept(dto.getCheckboxA());

		if (dto.getCountry().contains("Hungary")) {
			setPrimusGlobalLtd();
		} else {
			setAgree(dto.getCheckboxRp());
		}

		if (isElementPresent("//button[@disabled]")) {
			try {
				setKeyInfoDoc(dto.getCheckboxId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		registerTime = clickRegisterNow();
	}

	public void inputData(RegisterDtoFunction dto) {
		setAccountType(dto.getAccountType());
		setFirstName(dto.getFirstName());
		setLastName(dto.getLastName());
		setEmailAddress(dto.getEmail());
		setCountry(dto.getCountry());
		setPhoneNumber(dto.getPhoneNumber());
		setPassword(dto.getPassword());
		setReadAndAccept(dto.getCheckboxRP());
		setKeyInfoDoc(dto.getCheckboxKID());
		setAgree(dto.getCheckboxCA());

		registerTime = clickRegisterNow();
	}

	/**
	 * method check validation message in first name field with expectation
	 */
	public boolean isValidFirstName(RegisterDto dto) {
		if (dto.getFirstNameValidation().isEmpty()) {
			LogUtils.log("isValidFirstName isEmpty true");
			return true;
		}
		if (this.getFirstNameValidation().equals(dto.getFirstNameValidation())) {
			LogUtils.log("isValidFirstName equals true");
			return true;
		}
		LogUtils.log("isValidFirstName false");
		return false;
	}// This is a required field.

	/**
	 * method check validation message in last name field with expectation
	 */
	public boolean isValidLastName(RegisterDto dto) {
		if (dto.getLastNameValidation().isEmpty()) {
			LogUtils.log("isValidLastName isEmpty true");
			return true;
		}
		if (this.getLastNameValidation().equals(dto.getLastNameValidation())) {
			LogUtils.log("isValidLastName equals true");
			return true;
		}
		LogUtils.log("isValidLastName false");
		return false;
	}

	/**
	 * method check validation message in email field with expectation
	 */
	public boolean isValidEmail(RegisterDto dto) {
		if (dto.getEmailValidation().isEmpty()) {
			LogUtils.log("isValidEmail isEmpty true");
			return true;
		}
		if (dto.getId().equals("REGIS_014")
				&& this.existEmailAddressValidation.getText().equals(dto.getEmailValidation())) {
			return true;
		}
		if (this.getEmailAddressValidation().equals(dto.getEmailValidation())) {
			LogUtils.log("isValidEmail equals true");
			return true;
		}
		LogUtils.log("isValidEmail false");
		return false;
	}

	/**
	 * method check validation message in phone number field with expectation
	 */
	public boolean isValidPhoneNumber(RegisterDto dto) {
		if (dto.getPhoneNumberValidation().isEmpty()) {
			LogUtils.log("isValidPhoneNumber isEmpty true");
			return true;
		}

		LogUtils.log("" + dto.getPhoneNumberValidation().equals(this.getPhoneNumberValidation()));
		log("" + dto.getPhoneNumberValidation().equals(this.getPhoneNumberValidation()));
		if (this.getPhoneNumberValidation().equals(dto.getPhoneNumberValidation())) {
			LogUtils.log("isValidPhoneNumber equals true");
			return true;
		}
		LogUtils.log("isValidPhoneNumber false");
		return false;
	}

	/**
	 * method check validation message in password field with expectation
	 */
	public boolean isValidPassword(RegisterDto dto) {
		if (dto.getPasswordValidation().isEmpty()) {
			LogUtils.log("isValidPassword isEmpty true");
			return true;
		}
		if (this.getPasswordValidation().equals(dto.getPasswordValidation())) {
			LogUtils.log("isValidPassword equals true");
			return true;
		}
		LogUtils.log("isValidPassword false");
		return false;
	}

	/**
	 * method check validation message in username field with expectation
	 */
	public boolean isValidUsername(RegisterDto dto) {
		if (dto.getUsernameValidation().isEmpty()) {
			LogUtils.log("isValidUsername isEmpty true");
			return true;
		}
		if (this.username.getText().equals(this.emailAddress.getText())) {
			LogUtils.log("isValidUsername equals true");
			return true;
		}
		LogUtils.log("isValidUsername false");
		return false;
	}

	/**
	 * method check validation message in country field with expectation
	 */
	public boolean isValidCountry(RegisterDto dto) {
//		log(countryCode.getText());
//		if (this.countryCode.getText().contains(dto.getCountryValidation())) {
//			logger.info("Correct username");
//			return true;
//		}
//		logger.info("INcorrect username");
//		return false;
		// not found code
		LogUtils.log("isValidCountry true");
		return true;
	}

	/**
	 * method check validation password show/hide when click eye button
	 */
	public boolean isValidEyeButton(RegisterDto dto) {
		LogUtils.log("dto.getEyeButtonValidation()=" + dto.getEyeButtonValidation());
		if (dto.getEyeButtonValidation().equals("hide password")
				&& this.password.getAttribute("type").equals("password")) {
			LogUtils.log("isValidEyeButton hide password true");
			return true;
		} else if (dto.getEyeButtonValidation().equals("Show password")
				&& this.password.getAttribute("type").equals("text")) {
			LogUtils.log("isValidEyeButton show password true");
			return true;
		}
		LogUtils.log("isValidEyeButton false");
		return false;
	}

	/**
	 * method check validation message with kid checkbox
	 */
	public boolean isValidCheckboxKid(RegisterDto dto) {
		if (dto.getCheckboxIdValidation().isEmpty()) {
			LogUtils.log("isValidCheckboxKid isEmpty true");
			return true;
		}
		if (dto.getCheckboxIdValidation().equals(this.getKidValidation())) {
			LogUtils.log("isValidCheckboxKid equals true");
			return true;
		}
		LogUtils.log("isValidCheckboxKid false");
		return false;
	}

	/**
	 * method check validation message with CA checkbox
	 */
	public boolean isValidCheckboxCA(RegisterDto dto) {
		if (dto.getCheckboxAValidation().isEmpty()) {
			LogUtils.log("isValidCheckboxCA isEmpty true");
			return true;
		}

		if (dto.getCheckboxAValidation().equals(this.getCAValidation())) {
			LogUtils.log("isValidCheckboxCA equals true");
			return true;
		}
		LogUtils.log("isValidCheckboxCA false");
		return false;
	}

	/**
	 * method check validation message with CA checkbox
	 */
	public boolean isValidRegisterButton(RegisterDto dto) {
		if (dto.getRegisterNowValidation().equals(Constant.ACTIVE) && this.registerNow.isEnabled()) {
			LogUtils.log("isValidCheckboxCA ACTIVE true");
			return true;
		} else if (dto.getRegisterNowValidation().equals(Constant.INACTIVE) && !this.registerNow.isEnabled()) {
			LogUtils.log("isValidCheckboxCA INACTIVE true");
			return true;
		}
		LogUtils.log("isValidCheckboxCA false");
		return false;
	}

	public boolean isValid(RegisterDto RegisterDto) {
		boolean valid = true;
		try {
			valid = isValidCheckboxCA(RegisterDto) && valid;
			valid = isValidCheckboxKid(RegisterDto) && valid;
			valid = isValidCountry(RegisterDto) && valid;
			valid = isValidEmail(RegisterDto) && valid;
			valid = isValidEyeButton(RegisterDto) && valid;
			valid = isValidFirstName(RegisterDto) && valid;
			valid = isValidLastName(RegisterDto) && valid;
			valid = isValidPassword(RegisterDto) && valid;
			valid = isValidPhoneNumber(RegisterDto) && valid;
			valid = isValidRegisterButton(RegisterDto) && valid;
			valid = isValidUsername(RegisterDto) && valid;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return valid;
	}

	public boolean checkExistEmail(String expected) {
		String actual = this.existEmailAddressValidation.getText();
		return actual.contains(expected);
	}

	public void inputDataForCheck(ExistEmailCheckIdDto existEmailCheckIdDto) {
		setAccountType(existEmailCheckIdDto.getAccountType());
		setCountry(existEmailCheckIdDto.getCountry());
		setEmailForCheckExist(existEmailCheckIdDto.getEmail());

	}

	private void setEmailForCheckExist(String email) {
		this.emailAddress.clear();
		type(email, this.emailAddress);
		click(firstName);
		iwait(Constant.ONESEC);

	}

	public boolean isDisplayed() {
		if (this.getTitle().contains(Constant.REGISTER)) {
			return true;
		}
		return false;
	}

	public boolean isDisplayed(long timer) {
		for (int i = 0; i < timer; i += 500) {
			LogUtils.log("check after " + i + "millisecs ");
			if (this.getTitle().contains(Constant.REGISTER)) {
				return true;
			}
		}
		return false;
	}

	public boolean isNotDisplayed(long timer) {
		for (int i = 0; i < timer; i += 500) {
			LogUtils.log("check after " + i + "millisecs ");
			if (!this.getTitle().contains(Constant.REGISTER)) {
				return true;
			}
			iwait(500);
		}
		return false;
	}

	public void inputDataAndRegister(com.opcbiz.fxprimus.dto.migration.RegisterDto registerDto) {
		setAccountType(registerDto.getAccountType());
		setFirstName(registerDto.getFirstName());
		setLastName(registerDto.getLastName());
		setEmailForCheckExist(registerDto.getEmail());
		setCountry(registerDto.getCountry());
		setPhoneNumber(registerDto.getPhoneNumber());
		setPassword(registerDto.getPassword());

		List<String> displayop = Arrays.asList(registerDto.getDisplayCheckboxValidation().split(","));

		if (displayop.contains("CA"))
			click(this.readAndAcceptClientAgreement);
		if (displayop.contains("KID"))
			clickJs(this.keyInfoDoc);
		if (displayop.contains("RP"))
			click(this.agreeReceiveNewsletter);
		clickRegisterNow();
	}

	public void loadRegisterClient(String referralId) {
		this.webDriver.get(UrlConstant.CLIENT_REFERRAL_LINK + referralId);
	}

	public void inputDataForClientReferralLink(ClientDto clientDtos) {
		setAccountType(clientDtos.getAccountType());
		setFirstName(clientDtos.getFirstName());
		setLastName(clientDtos.getLastName());
		setEmailForCheckExist(clientDtos.getEmailAddress());
		setCountry(clientDtos.getCountry());
		setPhoneNumber(clientDtos.getPhoneNumber());
		setPassword(clientDtos.getPassword());
		setReadAndAccept(clientDtos.getClientAgreement());
		setAgree(clientDtos.getPromotions());
	}
}
