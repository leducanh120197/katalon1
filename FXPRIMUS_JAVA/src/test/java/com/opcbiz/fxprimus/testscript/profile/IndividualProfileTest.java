package com.opcbiz.fxprimus.testscript.profile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.ExcelFieldDto;
import com.opcbiz.fxprimus.dto.OpcDto;
import com.opcbiz.fxprimus.dto.register.IndiPersonDetailDto;
import com.opcbiz.fxprimus.dto.register.RegisterDto;
import com.opcbiz.fxprimus.page.authentication.EmailVarificationPageModel;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.page.profile.PersonalDetailsPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.webdriver.WebDriverFactory;

public class IndividualProfileTest extends BaseTest {
	private LoginPageModel loginPageModel;
	private PersonalDetailsPageModel personalDetailsPageModel;
	private DashboardPageModel dashboardPageModel;
	private RegisterPageModel registerPageModel;
	private EmailVarificationPageModel emailVarificationPageModel;

	



	@Test(priority = 1
//			, enabled = false
			)

//	@Parameters("pass")
	public void precondition() {
//			String pass) {
//		this.pass = pass;
		driver = WebDriverFactory.getDriver(Constant.SAFARI_MAC);

		loginPageModel = new LoginPageModel(driver);
		personalDetailsPageModel = new PersonalDetailsPageModel(driver);
		dashboardPageModel = new DashboardPageModel(driver);
		emailVarificationPageModel = new EmailVarificationPageModel(driver);
		registerPageModel = new RegisterPageModel(driver);

		prepareNewAccountGoToPersonalDetail();
	}


	@DataProvider(name = "preferredLanguage")
	public Object[][] dataProviderPreferredLanguage() {
		List<OpcDto> preferredLanguageDtos;

		preferredLanguageDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH,
				Constant.PREFERRED_LANGUAGE, OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] preferredLanguageDtoMatrix = new OpcDto[preferredLanguageDtos.size()][1];
		for (int i = 0; i < preferredLanguageDtos.size(); i++) {
			preferredLanguageDtoMatrix[i][0] = preferredLanguageDtos.get((i) % preferredLanguageDtos.size());
		}

		return preferredLanguageDtoMatrix;
	}
	@Test(priority = 2, dataProvider = "preferredLanguage"
//			, enabled = false
			)

	public void preferredLanguage(OpcDto opcDto) {

//		if(xaviReturn(opcDto))
//			return;

		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));

		boolean result = true;
		personalDetailsPageModel.setSelectLanguage();
		if (opcDto.getInputData().isEmpty() || opcDto.getInputData().equals("null")) {
			personalDetailsPageModel.setTextBoxSearchLanguage(Keys.ESCAPE + "");
		} else {
			personalDetailsPageModel.setTextBoxSearchLanguage(opcDto.getInputData());
			personalDetailsPageModel.setOptionSearchLanguage(opcDto.getInputData());
		}
		if (opcDto.getValidationType().equals("On_field")) {

			result = personalDetailsPageModel.getValueSearchLanguage().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getValueSearchLanguage());
			extentTest.info(opcDto.getValidationValue());
		}
		else if (opcDto.getValidationType().equals("No_result_found")) {
			result = personalDetailsPageModel.getNoResultsFoundGetText().equals(opcDto.getValidationValue());
		}
		else {
			result = personalDetailsPageModel.getLabelLanguageError().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getLabelLanguageError());
			extentTest.info(opcDto.getValidationValue());
		}
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	@DataProvider(name = "address")
	public Object[][] dataProviderAddress() {
		List<OpcDto> addressDtos;

		addressDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH, Constant.ADDRESS,
				OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] addressDtoMatrix = new OpcDto[addressDtos.size()][1];
		for (int i = 0; i < addressDtos.size(); i++) {
			addressDtoMatrix[i][0] = addressDtos.get((i) % addressDtos.size());
		}

		return addressDtoMatrix;
	}

	@Test(priority = 3, dataProvider = "address"
//			, enabled = false
			)
	public void address(OpcDto opcDto) {
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));

		if (opcDto.getInputData().isEmpty()  || opcDto.getInputData().equals("null")) {
			personalDetailsPageModel.textBoxAddress.click();
			personalDetailsPageModel.textBoxCity.click();
		} else {
			personalDetailsPageModel.setTextBoxAddress(opcDto.getInputData());
		}

		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			result = personalDetailsPageModel.getTextBoxAddressValue().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getTextBoxAddressValue());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = personalDetailsPageModel.getLabelAddressError().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getLabelAddressError());
			extentTest.info(opcDto.getValidationValue());
		}
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	@DataProvider(name = "cityTown")
	public Object[][] dataProviderCityTown() {
		List<OpcDto> cityTownDtos;

		cityTownDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH, Constant.CITY_TOWN,
				OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] cityTownDtoMatrix = new OpcDto[cityTownDtos.size()][1];
		for (int i = 0; i < cityTownDtos.size(); i++) {
			cityTownDtoMatrix[i][0] = cityTownDtos.get((i) % cityTownDtos.size());
		}

		return cityTownDtoMatrix;
	}

	@Test(priority = 4, dataProvider = "cityTown"
//			, enabled = false
			)
	public void cityTown(OpcDto opcDto) {
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));

		if (opcDto.getInputData().isEmpty() || opcDto.getInputData().equals("null")) {
			personalDetailsPageModel.textBoxCity.click();
			personalDetailsPageModel.textBoxAddress.click();

		} else {
			personalDetailsPageModel.setTextBoxCity(opcDto.getInputData());
		}

		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			result = personalDetailsPageModel.getTextBoxCityTownValue().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getTextBoxCityTownValue());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = personalDetailsPageModel.getLabelCityError().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getLabelCityError());
			extentTest.info(opcDto.getValidationValue());
		}
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	@DataProvider(name = "zip")
	public Object[][] dataProviderZip() {
		List<OpcDto> zipDtos;

		zipDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH, Constant.ZIP_POSTALCODE,
				OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] zipDtoMatrix = new OpcDto[zipDtos.size()][1];
		for (int i = 0; i < zipDtos.size(); i++) {
			zipDtoMatrix[i][0] = zipDtos.get((i) % zipDtos.size());
		}

		return zipDtoMatrix;
	}

	@Test(priority = 5, dataProvider = "zip"
//			, enabled = false
			)
	public void zip(OpcDto opcDto) {
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));

		if (opcDto.getInputData().isEmpty() || opcDto.getInputData().equals("null")) {
			personalDetailsPageModel.textBoxZip.click();
			personalDetailsPageModel.textBoxAddress.click();

		} else {
			personalDetailsPageModel.setTextBoxZip(opcDto.getInputData());
		}

		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			result = personalDetailsPageModel.getTextBoxZipValue().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getTextBoxZipValue());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = personalDetailsPageModel.getLabelZipError().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getLabelZipError());
			extentTest.info(opcDto.getValidationValue());
		}
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	@DataProvider(name = "state")
	public Object[][] dataProviderState() {
		List<OpcDto> stateDtos;

		stateDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH, Constant.STATE_PROVINCE,
				OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] stateDtoMatrix = new OpcDto[stateDtos.size()][1];
		for (int i = 0; i < stateDtos.size(); i++) {
			stateDtoMatrix[i][0] = stateDtos.get((i) % stateDtos.size());
		}

		return stateDtoMatrix;
	}

	@Test(priority = 6, dataProvider = "state"
//			, enabled = false
			)
	public void state(OpcDto opcDto) {
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));

		if (opcDto.getInputData().isEmpty() || opcDto.getInputData().equals("null")) {
			personalDetailsPageModel.textBoxState.click();
			personalDetailsPageModel.textBoxAddress.click();

		} else {
			personalDetailsPageModel.setTextBoxState(opcDto.getInputData());
		}

		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			if(opcDto.getValidationValue().equals("null")) {
				opcDto.setValidationValue("");
			}

			result = personalDetailsPageModel.getTextBoxStateValue().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getTextBoxStateValue());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = personalDetailsPageModel.getLabelStateError().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getLabelStateError());
			extentTest.info(opcDto.getValidationValue());
		}
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	@DataProvider(name = "dateOfBirth")
	public Object[][] dataProviderDateOfBirth() {
		List<OpcDto> dateOfBirthDtos;

		dateOfBirthDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH, Constant.DATE_OF_BIRTH,
				OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] dateOfBirthDtoMatrix = new OpcDto[dateOfBirthDtos.size()][1];
		for (int i = 0; i < dateOfBirthDtos.size(); i++) {
			dateOfBirthDtoMatrix[i][0] = dateOfBirthDtos.get((i) % dateOfBirthDtos.size());
		}

		return dateOfBirthDtoMatrix;
	}

	@Test(priority = 7, dataProvider = "dateOfBirth"
//			, enabled = false
			)
	public void dateOfBirth(OpcDto opcDto) {
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));

		personalDetailsPageModel.setDateOfBirth(opcDto.getInputData());


		boolean result;
		if (opcDto.getValidationType().equals("On_field")) {

			result = opcDto.getValidationValue().contains(personalDetailsPageModel.getDayInTextBoxDateOfBirthValue());
			extentTest.info(personalDetailsPageModel.getTextBoxDateOfBirthValue());
			extentTest.info(opcDto.getValidationValue());
		} else {
			result = personalDetailsPageModel.getLabelDateOfBirthError().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getLabelDateOfBirthError());
			extentTest.info(opcDto.getValidationValue());
		}
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	@DataProvider(name = "gender")
	public Object[][] dataProviderGender() {
		List<OpcDto> genderDtos;

		genderDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH, Constant.GENDER,
				OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] genderDtoMatrix = new OpcDto[genderDtos.size()][1];
		for (int i = 0; i < genderDtos.size(); i++) {
			genderDtoMatrix[i][0] = genderDtos.get((i) % genderDtos.size());
		}

		return genderDtoMatrix;
	}

	@Test(priority = 8, dataProvider = "gender"
//			, enabled = false
			)
	public void gender(OpcDto opcDto) {
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));

		personalDetailsPageModel.setSelectGender();
		if (opcDto.getInputData().isEmpty() || opcDto.getInputData().equals("null")) {
			personalDetailsPageModel.setOption__();
		} else if (opcDto.getInputData().equals("Male")) {
			personalDetailsPageModel.setOptionMale();
		} else if (opcDto.getInputData().equals("Female")) {
			personalDetailsPageModel.setOptionFemale();
		}

		boolean result = true;
		if (opcDto.getValidationType().equals("On_field")) {

			result = personalDetailsPageModel.getValueGender().equals(opcDto.getValidationValue());
			extentTest.info(personalDetailsPageModel.getValueGender());
			extentTest.info(opcDto.getValidationValue());
		} else {

		}
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	@DataProvider(name = "questionPolitically")
	public Object[][] dataProviderQuestionPolitically() {
		List<OpcDto> questionPoliticallyDtos;

		questionPoliticallyDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH,
				Constant.QUESTION_POLITICALLY, OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] questionPoliticallyDtoMatrix = new OpcDto[questionPoliticallyDtos.size()][1];
		for (int i = 0; i < questionPoliticallyDtos.size(); i++) {
			questionPoliticallyDtoMatrix[i][0] = questionPoliticallyDtos.get((i) % questionPoliticallyDtos.size());
		}

		return questionPoliticallyDtoMatrix;
	}

	@Test(priority = 9, dataProvider = "questionPolitically"
//			, enabled = false
			)
	public void questionPolitically(OpcDto opcDto) {
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));
		personalDetailsPageModel.setRadioPep(opcDto.getInputData());
		boolean result = true;
		if (opcDto.getValidationType().equals(Constant.VALIDATION_TYPE_IS_SELECTED)) {
//			String opcDtoGetValidationValue = opcDto.getValidationValue();
			result = personalDetailsPageModel.getRadioPep(opcDto.getInputData());
			extentTest.info(opcDto.getValidationValue());
		} else {

		}
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	@DataProvider(name = "questionUsCitizenship")
	public Object[][] dataProviderQuestionUsCitizenship() {
		List<OpcDto> questionUsCitizenshipDtos;

		questionUsCitizenshipDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH,
				Constant.QUESTION_US_CITIZENSHIP, OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] questionUsCitizenshipDtoMatrix = new OpcDto[questionUsCitizenshipDtos.size()][1];
		for (int i = 0; i < questionUsCitizenshipDtos.size(); i++) {
			questionUsCitizenshipDtoMatrix[i][0] = questionUsCitizenshipDtos
					.get((i) % questionUsCitizenshipDtos.size());
		}

		return questionUsCitizenshipDtoMatrix;
	}

	@Test(priority = 10, dataProvider = "questionUsCitizenship"
//			, enabled = false
			)
	public void questionUsCitizenship(OpcDto opcDto) {
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));
		personalDetailsPageModel.setRadioUs(opcDto.getInputData());
		boolean result = true;
		if (opcDto.getValidationType().equals(Constant.VALIDATION_TYPE_IS_SINGLE_CHOICE)) {
			if(opcDto.getValidationValue().isEmpty()) {
				result = !personalDetailsPageModel.isSelectedRadioUsNo() &&
						!personalDetailsPageModel.isSelectedRadioUsYes();
			}else {

			}

			extentTest.info("" + personalDetailsPageModel.getRadioPep(opcDto.getInputData()));
			extentTest.info(opcDto.getValidationValue());
		} else if (opcDto.getValidationType().equals(Constant.VALIDATION_TYPE_IS_ERROR)) {
			result = personalDetailsPageModel.getLabelUsError().contains(opcDto.getValidationValue());
		}
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	@DataProvider(name = "checkboxAccept")
	public Object[][] dataProviderCheckboxAccept() {
		List<OpcDto> checkboxAcceptDtos;

		checkboxAcceptDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH,
				Constant.CHECKBOX_ACCEPT, OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] checkboxAcceptDtoMatrix = new OpcDto[checkboxAcceptDtos.size()][1];
		for (int i = 0; i < checkboxAcceptDtos.size(); i++) {
			checkboxAcceptDtoMatrix[i][0] = checkboxAcceptDtos.get((i) % checkboxAcceptDtos.size());
		}

		return checkboxAcceptDtoMatrix;
	}

	@Test(priority = 11, dataProvider = "checkboxAccept"
//			, enabled = false
			)
	public void checkboxAccept(OpcDto opcDto) {
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));
		personalDetailsPageModel.setCheckboxCa(opcDto.getInputData());
		boolean result = true;
		if (opcDto.getValidationType().equals(Constant.VALIDATION_TYPE_IS_ERROR)) {
			result = opcDto.getValidationValue().equals(personalDetailsPageModel.getLabelCheckboxCaError());
			extentTest.info("" + personalDetailsPageModel.getLabelCheckboxCaError());
		}


		extentTest.info(opcDto.getValidationValue());
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}

	

	@Test(priority = 12, dataProvider = "buttonProceed"
//			, enabled = false
			)
	public void buttonProceed(IndiPersonDetailDto indiPersonDetailDto) {
		extentTest = extentReport.createTest(indiPersonDetailDto.getId() + " " + indiPersonDetailDto.getTitle());
		personalDetailsPageModel.load();
		personalDetailsPageModel.setSelectLanguage();
		personalDetailsPageModel.setTextBoxSearchLanguage(indiPersonDetailDto.getPreferredLanguage());
		personalDetailsPageModel.setOptionSearchLanguage(indiPersonDetailDto.getPreferredLanguage());

		personalDetailsPageModel.setTextBoxAddress(indiPersonDetailDto.getAddress());
		personalDetailsPageModel.setTextBoxCity(indiPersonDetailDto.getCityTown());
		personalDetailsPageModel.setTextBoxZip(indiPersonDetailDto.getZipPostalcode());
		personalDetailsPageModel.setTextBoxState(indiPersonDetailDto.getStateProvince());
		personalDetailsPageModel.setDateOfBirth(indiPersonDetailDto.getDateOfBirth());

		personalDetailsPageModel.setSelectGender();
		if (indiPersonDetailDto.getGender().isEmpty() || indiPersonDetailDto.getGender().equals("null")) {
			personalDetailsPageModel.setOption__();
		} else if (indiPersonDetailDto.getGender().equals("Male")) {
			personalDetailsPageModel.setOptionMale();
		} else if (indiPersonDetailDto.getGender().equals("Female")) {
			personalDetailsPageModel.setOptionFemale();
		}

		personalDetailsPageModel.setRadioPepIndividual(indiPersonDetailDto.getQuestionPolitically());

		personalDetailsPageModel.setRadioUsIndividual(indiPersonDetailDto.getQuestionUsCitizenship());

		personalDetailsPageModel.setCheckboxCa(indiPersonDetailDto.getCheckboxAccept());
		boolean result = true;
			//result = indiPersonDetailDto.getButtonProceedValidation().equals(personalDetailsPageModel.getLabelCheckboxCaError());
		boolean isActive = indiPersonDetailDto.getButtonProceedValidation().equals("active");
		boolean isEnabled = personalDetailsPageModel.buttonProceed.isEnabled();
		result = isActive == isEnabled;


			extentTest.info("active "+isActive);
			extentTest.info("enabled "+ isEnabled);
		if (result) {
			extentTest.pass("pass");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
	}




	@DataProvider(name = "proceedButtonFunction")
	public Object[][] dataProviderProceedButtonFunction() {
		List<OpcDto> proceedButtonFunctionDtos;
		proceedButtonFunctionDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH,
				Constant.PROCEED_BUTTON_FUNCTION, OpcDto.excelTemplate(), OpcDto.class);

		OpcDto[][] proceedButtonFunctionDtoMatrix = new OpcDto[proceedButtonFunctionDtos.size()][1];
		for (int i = 0; i < proceedButtonFunctionDtos.size(); i++) {
			proceedButtonFunctionDtoMatrix[i][0] = proceedButtonFunctionDtos.get((i) % proceedButtonFunctionDtos.size());
		}

		return proceedButtonFunctionDtoMatrix;
	}
	@Test(priority = 13
//			, enabled = false
			)
	public void after() {
		driver.quit();
	}


	@Test(priority = 14
//			,enabled = false
			)
	public void beforeProceedButtonFunction() {
		driver = WebDriverFactory.getDriver(Constant.CHROME_MAC);

		loginPageModel = new LoginPageModel(driver);
		registerPageModel = new RegisterPageModel(this.driver);
		emailVarificationPageModel = new EmailVarificationPageModel(driver);
		personalDetailsPageModel = new PersonalDetailsPageModel(driver);
		dashboardPageModel = new DashboardPageModel(driver);
	}
	

	@Test(priority = 15, dataProvider = "buttonProceed"
//			,enabled = false
			)
	public void proceedButtonFunction(IndiPersonDetailDto indiPersonDetailDto) {
		if(indiPersonDetailDto.getButtonProceedValidation().equals("active")) {

//			if(!(indiPersonDetailDto.getId().contains("16")||
//					indiPersonDetailDto.getId().contains("17")||
//					indiPersonDetailDto.getId().contains("18"))) {
//				return;
//			}
			//register
			prepareNewAccountGoToPersonalDetail();

			// cpy from buttonProceed @Test
			extentTest = extentReport.createTest(indiPersonDetailDto.getId() + " " + indiPersonDetailDto.getTitle()  + " active" );

			personalDetailsPageModel.setSelectLanguage();
			personalDetailsPageModel.setTextBoxSearchLanguage(indiPersonDetailDto.getPreferredLanguage());
			personalDetailsPageModel.setOptionSearchLanguage(indiPersonDetailDto.getPreferredLanguage());

			personalDetailsPageModel.setTextBoxAddress(indiPersonDetailDto.getAddress());
			personalDetailsPageModel.setTextBoxCity(indiPersonDetailDto.getCityTown());
			personalDetailsPageModel.setTextBoxZip(indiPersonDetailDto.getZipPostalcode());
 			personalDetailsPageModel.setTextBoxState(indiPersonDetailDto.getStateProvince());
			personalDetailsPageModel.setDateOfBirth(indiPersonDetailDto.getDateOfBirth());

			personalDetailsPageModel.setSelectGender();
			if (indiPersonDetailDto.getGender().isEmpty() || indiPersonDetailDto.getGender().equals("null")) {
				personalDetailsPageModel.setOption__();
			} else if (indiPersonDetailDto.getGender().equals("Male")) {
				personalDetailsPageModel.setOptionMale();
			} else if (indiPersonDetailDto.getGender().equals("Female")) {
				personalDetailsPageModel.setOptionFemale();
			}

			personalDetailsPageModel.setRadioPepIndividual(indiPersonDetailDto.getQuestionPolitically());

			personalDetailsPageModel.setRadioUsIndividual(indiPersonDetailDto.getQuestionUsCitizenship());

			personalDetailsPageModel.setCheckboxCa(indiPersonDetailDto.getCheckboxAccept());
			// end cpy from buttonProceed @Test

			personalDetailsPageModel.setButtonProceed();
			try {
				WebDriverWait wait = new WebDriverWait(driver, 9);
			    wait.until(ExpectedConditions.visibilityOfElementLocated
			              (By.xpath("//*[contains(text(),'Your request was successful.')]")));
			    extentTest.pass("pass");
			} catch (Exception e) {
				extentTest.fail("fail");
			}
			extentReport.flush();
//
			dashboardPageModel.logoutDashboard();
		}


	}



	@Test(priority = 16
//			, enabled = false
			)
	public void afterProceedButtonFunction() {
		driver.quit();
	}

	public void prepareNewAccountGoToPersonalDetail() {

		com.opcbiz.fxprimus.dto.register.RegisterDto registerDtoIndividual =
				com.opcbiz.fxprimus.dto.register.RegisterDto.getExample("accountType","Individual");
		loginPageModel.load();

		loginPageModel.clickOpenAccount();

		registerPageModel.inputDataAndRegister(registerDtoIndividual);
//
		emailVarificationPageModel.isDisplayed(Constant.FIFTEENS);
		loginPageModel.load();
		//loginPageModel.login(registerDtoIndividual.getEmail(), registerDtoIndividual.getPassword());
		dashboardPageModel.setButtonPersonalDetails();

	}
	
	@DataProvider(name = "buttonProceed")
	public Object[][] dataProviderButtonProceed() {
		List<IndiPersonDetailDto> indiPersonDetailDtos;

		HashMap<String, List<OpcDto>> hashMapStringListOpcDto = new HashMap<String, List<OpcDto>>();

		List<ExcelFieldDto> indiPersonDetailDtoExcelTemplate = IndiPersonDetailDto.excelTemplate();
		for (ExcelFieldDto excelFieldDto : indiPersonDetailDtoExcelTemplate) {
//			if (excelFieldDto.equals("id") || excelFieldDto.equals("title")) {
//				continue;
//			}
//			else {
				List<OpcDto> listOpcDto = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH,
						excelFieldDto.getHeaderName(), OpcDto.excelTemplate(), OpcDto.class);
				hashMapStringListOpcDto.put(excelFieldDto.getHeaderName(), listOpcDto);
//			}
		}
		// a sheet
		indiPersonDetailDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_DATA_PATH,
				Constant.BUTTON_PROCEED, IndiPersonDetailDto.excelTemplate(), IndiPersonDetailDto.class);



		IndiPersonDetailDto[][] indiPersonDetailDtoMatrix = new IndiPersonDetailDto[indiPersonDetailDtos.size()][1];
		for (int i = 0; i < indiPersonDetailDtos.size(); i++) {

			// a row
			IndiPersonDetailDto indiPersonDetailDtosGetI = indiPersonDetailDtos.get(i);
			ObjectMapper oMapper = new ObjectMapper();
			@SuppressWarnings("unchecked")
			Map<String, Object> indiPersonDetailDtosGetIMapClass = oMapper.convertValue(indiPersonDetailDtosGetI,
					Map.class);

			for (String keyInSet : indiPersonDetailDtosGetIMapClass.keySet())
			{
				for (ExcelFieldDto excelFieldDto : indiPersonDetailDtoExcelTemplate) {
					if (keyInSet.equals("id") || keyInSet.equals("title")) {
						continue;
					} else if (excelFieldDto.getFieldName().equals(keyInSet)) {
						String id = "" + indiPersonDetailDtosGetIMapClass.get(excelFieldDto.getFieldName());
						// preferredLanguage=LA_003
						List<OpcDto> listOpcDto = hashMapStringListOpcDto.get(excelFieldDto.getHeaderName());
						for (OpcDto opcDto : listOpcDto) {
							if (opcDto.getId().equals(id)) {
								String inputData = opcDto.getInputData();
								indiPersonDetailDtosGetIMapClass.put(excelFieldDto.getFieldName(), inputData);
								System.out.println();
							}

						}
						System.out.println();
					}
				}
			}
			indiPersonDetailDtosGetI = oMapper.convertValue(indiPersonDetailDtosGetIMapClass,
					IndiPersonDetailDto.class);
			indiPersonDetailDtos.set(i, indiPersonDetailDtosGetI);


			indiPersonDetailDtoMatrix[i][0] = indiPersonDetailDtos.get((i) % indiPersonDetailDtos.size());
		}

		return indiPersonDetailDtoMatrix;
	}
}
