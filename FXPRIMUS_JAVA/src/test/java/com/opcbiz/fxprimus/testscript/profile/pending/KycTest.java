package com.opcbiz.fxprimus.testscript.profile.pending;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
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

public class KycTest extends BaseTest {
	private LoginPageModel loginPageModel;
	private RegisterPageModel registerPageModel;
	private DashboardPageModel dashboardPageModel;

//	private GooglePageModel googlePageModel;
//	private EmailVarificationPageModel emailVarificationPageModel;

//	private TradingAccountPageModel tradingAccountPageModel;
	private TradingKnowledgePageModel tradingKnowledgePageModel;
	private FinancialBackgroundPageModel financialBackgroundPageModel;
	private TradingAccountPageModel tradingAccountPageModel;

	private CorporateDocumentPageModel corporateDocumentPageModel;

//	List<CorpPersonDetailDto> listCorpPersonDetailDtos;
//	List<JointPersonDetailDto> listJointPersonDetailDtos;

	List<QuestionnaireDto> listQuestionnaireDtos;
	List<AccountDetailDto> listAccountDetailDtos;
	int noTestCase;

	@DataProvider(name = "dataProvidertest226")
	public Object[] dataProvidertest226() {
		RegisterDto individualRegisterDto = RegisterDto.getExampleIndividualCy();
		pause(5);
		RegisterDto jointRegisterDto = RegisterDto.getExampleJointCy();
		pause(5);
		RegisterDto corporateRegisterDto = RegisterDto.getExampleCorpCy();
		RegisterDto[] registerDtos = { individualRegisterDto, corporateRegisterDto, jointRegisterDto };

		listQuestionnaireDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_226,
				Constant.QUESTIONNAIRE_DATA_SHEET, QuestionnaireDto.excelTemplate(), QuestionnaireDto.class);
		listAccountDetailDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_226, Constant.ACCOUNT_DETAILS,
				AccountDetailDto.excelTemplate(), AccountDetailDto.class);
		String[] imageTypes = { "pdf", "jpg", "gif", "png" };

		Object[] mapStringObjectArray = new Object[registerDtos.length * 4];
		int i = 0;
		for (RegisterDto registerDto : registerDtos) {
			for (String imageType : imageTypes) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("registerDto", registerDto);
				map.put("imageType", imageType);
				mapStringObjectArray[i++] = map;

			}
		}

		noTestCase = 0;

		return mapStringObjectArray;
	}

	@BeforeTest
	public void beforeTest() {
		driver = WebDriverFactory.getDriver(Constant.CHROME);
	}

	@Test(dataProvider = "dataProvidertest226")
	public void test226(Map<String, Object> map) {
		noTestCase++;
		boolean result = true;

		RegisterDto registerDto = (RegisterDto) map.get("registerDto");
		QuestionnaireDto questionnaireDto = getQuestionnaireDto(registerDto);
		AccountDetailDto accountDetailDto = listAccountDetailDtos.get(0);
		
		String imageType = (String) map.get("imageType");

		loginPageModel = new LoginPageModel(driver);
		registerPageModel = new RegisterPageModel(driver);
		dashboardPageModel = new DashboardPageModel(driver);

		tradingKnowledgePageModel = new TradingKnowledgePageModel(driver);
		financialBackgroundPageModel = new FinancialBackgroundPageModel(driver);
		tradingAccountPageModel = new TradingAccountPageModel(driver);
		corporateDocumentPageModel = new CorporateDocumentPageModel(driver);

		String titleTestCase = "Registration Complete-" + Constant.CHROME + ": " + registerDto.getAccountType();
		extentTest = extentReport.createTest(titleTestCase);

		extentTest.info("Account: ");

		loginPageModel.load();

//		loginPageModel.clickOpenAccount();
//		String email = "qa_automation+" + System.currentTimeMillis() + "@fxprimus.tech";
//		registerDto.setEmail(email);
//		registerPageModel.inputDataAndRegister(registerDto);
//		dashboardPageModel.load();
		
		loginPageModel.login("qa_automation+24082020001@fxprimus.tech", "Lqa@12345");

//		completeQuestionnaireDto(questionnaireDto);
//		completeTradingAccount(accountDetailDto);
		
		corporateDocumentPageModel.load();
		
		result = completeKYC(registerDto.getAccountType(), imageType);

//		extentTest(registerDto);
		if (result) {
			extentTest.pass("PASS");
		} else {
			extentTest.fail("FAIL");
		}
		extentReport.flush();

		System.out.println();
	}

	public boolean completeKYC(String accountType, String imageType) {
		boolean rs = true;
		corporateDocumentPageModel.fillDataWithImageType(accountType, imageType);
		return rs;
	}

	public void completeQuestionnaireDto(QuestionnaireDto questionnaireDto) {

		tradingKnowledgePageModel.load();
		tradingKnowledgePageModel.fillData(questionnaireDto);
		tradingKnowledgePageModel.clickBtnProceed();

//		financialBackgroundPageModel.load();
//		financialBackgroundPageModel.fillDataIndividual(questionnaireDto);
//		financialBackgroundPageModel.clickBtnProceed();

	}

	public void completeTradingAccount(AccountDetailDto accountDetailDto ) {
		tradingAccountPageModel.load();
		boolean result = tradingAccountPageModel.validate(accountDetailDto);
		tradingAccountPageModel.clickButtonProceed();
		dashboardPageModel.load();

	}

	public QuestionnaireDto getQuestionnaireDto(RegisterDto registerDto) {
		int index = 0;
		if (registerDto.getAccountType().equals("Individual")) {
			index = 0;
		} else if (registerDto.getAccountType().equals("Corporate")) {
			index = 1;
		} else if (registerDto.getAccountType().equals("Joint")) {
			index = 2;
		}
		return listQuestionnaireDtos.get(index);
	}
	public void extentReport() {
		
	}

}
