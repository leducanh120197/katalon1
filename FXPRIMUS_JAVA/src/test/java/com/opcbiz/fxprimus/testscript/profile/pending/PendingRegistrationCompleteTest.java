package com.opcbiz.fxprimus.testscript.profile.pending;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.pendCompleteRegis.AccountDetailDto;
import com.opcbiz.fxprimus.dto.pendCompleteRegis.QuestionnaireDto;
import com.opcbiz.fxprimus.dto.register.CorpPersonDetailDto;
import com.opcbiz.fxprimus.dto.register.JointPersonDetailDto;
import com.opcbiz.fxprimus.dto.register.RegisterDto;
import com.opcbiz.fxprimus.page.authentication.EmailVarificationPageModel;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.email.GooglePageModel;
import com.opcbiz.fxprimus.page.profile.CorporateDocumentPageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.page.profile.FinancialBackgroundPageModel;
import com.opcbiz.fxprimus.page.profile.PersonalDetailsCorporationPageModel;
import com.opcbiz.fxprimus.page.profile.PersonalDetailsJointPageModel;
import com.opcbiz.fxprimus.page.profile.PersonalDetailsPageModel;
import com.opcbiz.fxprimus.page.profile.TradingAccountPageModel;
import com.opcbiz.fxprimus.page.profile.TradingKnowledgePageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.webdriver.WebDriverFactory;

public class PendingRegistrationCompleteTest extends BaseTest{
	private LoginPageModel loginPageModel;
	private RegisterPageModel registerPageModel;
	private DashboardPageModel dashboardPageModel;

	private GooglePageModel googlePageModel;
	private EmailVarificationPageModel emailVarificationPageModel;
	private PersonalDetailsPageModel personalDetailsPageModel;
	private PersonalDetailsCorporationPageModel personalDetailsCorporationPageModel;
	private PersonalDetailsJointPageModel personalDetailsJointPageModel;
	private TradingAccountPageModel tradingAccountPageModel;
	private TradingKnowledgePageModel tradingKnowledge;
	private FinancialBackgroundPageModel financialBackgroundPageModel;
	private CorporateDocumentPageModel corporateDocumentPageModel;
	
	List<CorpPersonDetailDto> listCorpPersonDetailDtos;
	List<JointPersonDetailDto> listJointPersonDetailDtos;
	List<QuestionnaireDto> listQuestionnaireDtos;
	List<AccountDetailDto> listAccountDetailDtos;
	int noTestCase;
	@DataProvider(name = "dataProvidertest226")
	public RegisterDto[] dataProvidertest226() {
		RegisterDto individualRegisterDto = RegisterDto.getExampleIndividualCy();
		pause(5);
		RegisterDto jointRegisterDto = RegisterDto.getExampleJointCy();
		pause(5);
		RegisterDto corporateRegisterDto = RegisterDto.getExampleCorpCy();
		RegisterDto[] registerDtos = { individualRegisterDto, corporateRegisterDto, jointRegisterDto };

		listCorpPersonDetailDtos = ExcelUtils.getInstance().getDataFromExcel(
				Constant.MA_225_CORPORATE_DATA_PATH, Constant.BUTTON_PROCEED_CORPORATE,
				CorpPersonDetailDto.excelTemplate(), CorpPersonDetailDto.class);
		listJointPersonDetailDtos = ExcelUtils.getInstance().getDataFromExcel(
				Constant.MA_225_JOINT_DATA_PATH, Constant.BUTTON_PROCEED,
				JointPersonDetailDto.excelTemplate(), JointPersonDetailDto.class);
		listQuestionnaireDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_226,
				Constant.QUESTIONNAIRE_DATA_SHEET, QuestionnaireDto.excelTemplate(), QuestionnaireDto.class);
		listAccountDetailDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_226, Constant.ACCOUNT_DETAILS,
				AccountDetailDto.excelTemplate(), AccountDetailDto.class);
		noTestCase = 0;
		return registerDtos;
	}

	@Test(dataProvider = "dataProvidertest226")
	public void test226(RegisterDto registerDto) {
		noTestCase++;
//		if(noTestCase !=3) {
//			return;
//		}
		String browser = Constant.SAFARI_MAC;
		driver = WebDriverFactory.getDriver(browser);
		
		loginPageModel = new LoginPageModel(driver);
		registerPageModel = new RegisterPageModel(driver);
		dashboardPageModel = new DashboardPageModel(driver);
		
		googlePageModel = new GooglePageModel(driver);
		emailVarificationPageModel = new EmailVarificationPageModel(driver);
		personalDetailsPageModel = new PersonalDetailsPageModel(driver);
		personalDetailsCorporationPageModel = new PersonalDetailsCorporationPageModel(driver);
		personalDetailsJointPageModel = new PersonalDetailsJointPageModel(driver);
		tradingAccountPageModel = new TradingAccountPageModel(driver);
		tradingKnowledge = new TradingKnowledgePageModel(driver);
		financialBackgroundPageModel = new FinancialBackgroundPageModel(driver);
		corporateDocumentPageModel = new CorporateDocumentPageModel(driver);
		List<Boolean> listCompleteRegistrationResult = new ArrayList<Boolean>();
		List<Boolean> listCompleteRegistrationResultNotMail = new ArrayList<Boolean>();
		
		String titleTestCase = "Registration Complete-"+browser+": " + registerDto.getAccountType();
		extentTest = extentReport.createTest(titleTestCase);
		
		
		
		loginPageModel.load();

		loginPageModel.clickOpenAccount();
		registerPageModel.inputDataAndRegister(registerDto);
		googlePageModelLoadAndverifyInEmail(registerDto);
		
//		loginPageModel.login("qa_automation+1592820267126@fxprimus.tech", "Testauto01@");

		if (!dashboardPageModel.isWaitDisplay()) {
		}

		listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step one"));
		
		if(registerDto.getAccountType().equals("Individual")) {
			listCompleteRegistrationResultNotMail = individualCompleteRegistration();
		}else if (registerDto.getAccountType().equals("Corporate")) {
			listCompleteRegistrationResultNotMail = corporateCompleteRegistration();
		}else if (registerDto.getAccountType().equals("Joint")) {
			listCompleteRegistrationResultNotMail = jointCompleteRegistration();
			System.out.println("Joint");
		}
		listCompleteRegistrationResult.addAll(listCompleteRegistrationResultNotMail);
		
		extentTest(listCompleteRegistrationResult, registerDto);
		
		System.out.println();
	}

	public void googlePageModelLoadAndverifyInEmail(RegisterDto registerDto) {
		if(googlePageModel.isWaitDisplay("Email Verification | FXPRIMUS")) {
			System.out.println("googlePageModel.isWaitDisplay");
		}
		WebDriver chromeDriver = WebDriverFactory.getDriver(Constant.CHROME_MAC);
		googlePageModel = new GooglePageModel(chromeDriver);
		googlePageModel.load();
		boolean verifySuccess = googlePageModel.verifyInEmail(Constant.GMAIL_QA_AUTOMATION, Constant.GMAIL_QA_AUTOMATION_PASSWORD);
		if(googlePageModel.getPin() == null) {
			System.out.println(googlePageModel.getPin() + "null");
		}
		System.out.println(googlePageModel.getPin());
		if (!verifySuccess) {
			return;
		}

		if (emailVarificationPageModel.isDisplayed(15)) {

		} else if (loginPageModel.waitPageLoad("Login")) {
			loginPageModel.login(registerDto.getEmail(), registerDto.getPassword());
		}
		emailVarificationPageModel.action(googlePageModel.getPin());
		chromeDriver.quit();
		
//		googlePageModel.load();
//		boolean verifySuccess = googlePageModel.verifyInEmail(Constant.GMAIL_QA_AUTOMATION,
//				Constant.GMAIL_QA_AUTOMATION_PASSWORD);
//		if (!verifySuccess) {
//			return;
//		}
//
//		if (emailVarificationPageModel.isDisplayed(15)) {
//
//		} else if (loginPageModel.waitPageLoad("Login")) {
//			loginPageModel.login(registerDto.getEmail(), registerDto.getPassword());
//		}
//		emailVarificationPageModel.action(googlePageModel.getPin());
	}
	
	public List<Boolean> individualCompleteRegistration() {
		List<Boolean> listCompleteRegistrationResult = new ArrayList<Boolean>();
		QuestionnaireDto questionnaireDto = listQuestionnaireDtos.get(0);
		AccountDetailDto accountDetailDto = listAccountDetailDtos.get(0);
			
			try {
				dashboardPageModel.setButtonPersonalDetails();
				if (personalDetailsPageModel.isWaitDisplay()) { }
				personalDetailsPageModel.fillDataIndividual();
				personalDetailsPageModel.setButtonProceed();
				personalDetailsPageModel.waitPageLoad(Constant.TRADING_ACCOUNT);
				dashboardPageModel.load();
				listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step two"));
			} catch (Exception e) {
				listCompleteRegistrationResult.add(false);
				e.printStackTrace();
			}
	
			try {
				tradingAccountPageModel.load();
				boolean result = tradingAccountPageModel.validate(accountDetailDto);
				tradingAccountPageModel.clickButtonProceed();
				dashboardPageModel.load();
				listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step three"));
			} catch (Exception e) {
				listCompleteRegistrationResult.add(false);//
				e.printStackTrace();
			}
			
			try {
				tradingKnowledge.load();
				tradingKnowledge.fillData(questionnaireDto);
				tradingKnowledge.clickBtnProceed();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			try {
				financialBackgroundPageModel.load();
				financialBackgroundPageModel.fillDataIndividual(questionnaireDto);
				financialBackgroundPageModel.clickBtnProceed();
				dashboardPageModel.load();
				listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step four"));
			} catch (Exception e) {
				listCompleteRegistrationResult.add(false);//
				e.printStackTrace();
			}

		try {
			corporateDocumentPageModel.load();
			corporateDocumentPageModel.fillDataIndividual();
		} catch (Exception e) {
			e.printStackTrace();
		}

		dashboardPageModel.load();
		listCompleteRegistrationResult.add(dashboardPageModel.isKycPendingReview());
		return listCompleteRegistrationResult;
	}
	
	public List<Boolean> corporateCompleteRegistration() {
		List<Boolean> listCompleteRegistrationResult = new ArrayList<Boolean>();
		QuestionnaireDto questionnaireDto = listQuestionnaireDtos.get(1);
		AccountDetailDto accountDetailDto = listAccountDetailDtos.get(1);
		CorpPersonDetailDto corpPersonDetailDto = listCorpPersonDetailDtos.get(17);
		
		try {
			dashboardPageModel.setButtonPersonalDetails();
			if (personalDetailsPageModel.isWaitDisplay()) { }
			personalDetailsCorporationPageModel.validateButtonProceed(corpPersonDetailDto);
			personalDetailsPageModel.setButtonProceed();
			personalDetailsPageModel.waitPageLoad(Constant.TRADING_ACCOUNT);
			dashboardPageModel.load();
			listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step two"));
		} catch (Exception e) {
			listCompleteRegistrationResult.add(false);
			e.printStackTrace();
		}

		try {
			tradingAccountPageModel.load();
			boolean result = tradingAccountPageModel.validate(accountDetailDto);
			tradingAccountPageModel.clickButtonProceed();
			dashboardPageModel.load();
			listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step three"));
		} catch (Exception e) {
			listCompleteRegistrationResult.add(false);
			e.printStackTrace();
		}

		try {
			tradingKnowledge.load();
			tradingKnowledge.fillData(questionnaireDto);
			tradingKnowledge.clickBtnProceed();
		} catch (Exception e) {
			e.printStackTrace();
		} 

		try {
			financialBackgroundPageModel.load();
			financialBackgroundPageModel.fillDataCorporate(questionnaireDto);
			financialBackgroundPageModel.clickBtnProceed();
			dashboardPageModel.load();
			listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step four"));
		} catch (Exception e) {
			listCompleteRegistrationResult.add(false);
			e.printStackTrace();
		}

		try {
			corporateDocumentPageModel.load();
			corporateDocumentPageModel.fillDataIndividual();
		} catch (Exception e) {
			e.printStackTrace();
		}

		dashboardPageModel.load();
		listCompleteRegistrationResult.add(dashboardPageModel.isKycPendingReview());
		System.out.println();
		return listCompleteRegistrationResult;
	}
	
	public List<Boolean> jointCompleteRegistration() {
		List<Boolean> listCompleteRegistrationResult = new ArrayList<Boolean>();
		QuestionnaireDto questionnaireDto = listQuestionnaireDtos.get(2);
		AccountDetailDto accountDetailDto = listAccountDetailDtos.get(2);
		JointPersonDetailDto jointPersonDetailDto = listJointPersonDetailDtos.get(17);
		jointPersonDetailDto.setGenderAcc1("Male");
		
		try {
			dashboardPageModel.setButtonPersonalDetails();
			if (personalDetailsPageModel.isWaitDisplay()) { }
			personalDetailsJointPageModel.validateButtonProceed(jointPersonDetailDto);
			personalDetailsJointPageModel.setButtonSubmit();
			dashboardPageModel.load();
			listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step two"));
		} catch (Exception e) {
			listCompleteRegistrationResult.add(false);
			e.printStackTrace();
		}

		try {
			tradingAccountPageModel.load();
			boolean result = tradingAccountPageModel.validate(accountDetailDto);
			tradingAccountPageModel.clickButtonProceed();
			dashboardPageModel.load();
			listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step three"));
		} catch (Exception e) {
			listCompleteRegistrationResult.add(false);
			e.printStackTrace();
		}

		try {
			tradingKnowledge.load();
			tradingKnowledge.fillData(questionnaireDto);
			tradingKnowledge.clickBtnProceed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			financialBackgroundPageModel.load();
			financialBackgroundPageModel.fillDataIndividual(questionnaireDto);
			financialBackgroundPageModel.clickBtnProceed();
			dashboardPageModel.load();
			dashboardPageModel.load();
			listCompleteRegistrationResult.add(dashboardPageModel.isCompleted("step four"));
		} catch (Exception e) {
			listCompleteRegistrationResult.add(false);
			e.printStackTrace();
		}

		try {
			corporateDocumentPageModel.load();
			corporateDocumentPageModel.fillDataJoit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		dashboardPageModel.load();
		listCompleteRegistrationResult.add(dashboardPageModel.isKycPendingReview());
		return listCompleteRegistrationResult;
	}
	
	public void extentTest(List<Boolean> listCompleteRegistrationResult, RegisterDto registerDto) {
		extentTest.info("Account type: " + registerDto.getAccountType());
		extentTest.info("Email: " + registerDto.getEmail());
		extentTest.info("Password: " + registerDto.getPassword());
		extentTest.info("______________________________");
		if(listCompleteRegistrationResult.get(0)) {
			extentTest.pass("Email Verification: " + "successful");
		}else {
			extentTest.fail("Email Verification: " + "fail");
		}
		if(listCompleteRegistrationResult.get(1)) {
			extentTest.pass("Account Details: " + "successful");
		}else {
			extentTest.fail("Account Details: " + "fail");
		}
		if(listCompleteRegistrationResult.get(2)) {
			extentTest.pass("Trading Account: " + "successful");
		}else {
			extentTest.fail("Trading Account: " + "fail");
		}
		if(listCompleteRegistrationResult.get(3)) {
			extentTest.pass("Questionnaire: " + "successful");
		}else {
			extentTest.fail("Questionnaire: " + "fail");
		}
		if(listCompleteRegistrationResult.get(4)) {
			extentTest.pass("KYC Documents: " + "successful");
		}else {
			extentTest.fail("KYC Documents: " + "fail");
		}
		
		boolean testReult = true;
		for (Boolean boolean1 : listCompleteRegistrationResult) {
			if(!boolean1) {
				testReult =  false;
			}
		}
		if(testReult) {
			extentTest.pass("PASS");
		}else {
			extentTest.fail("FAIL");
		}
		extentReport.flush();
	}
}
