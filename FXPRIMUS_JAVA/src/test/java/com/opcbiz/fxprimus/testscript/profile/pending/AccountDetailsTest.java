package com.opcbiz.fxprimus.testscript.profile.pending;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.pendCompleteRegis.AccountDetailDto;

import com.opcbiz.fxprimus.dto.register.RegisterDto;
import com.opcbiz.fxprimus.page.authentication.EmailVarificationPageModel;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.email.GooglePageModel;

import com.opcbiz.fxprimus.page.profile.DashboardPageModel;

import com.opcbiz.fxprimus.page.profile.TradingAccountPageModel;

import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.webdriver.WebDriverFactory;

public class AccountDetailsTest extends BaseTest {
	private LoginPageModel loginPageModel;
	private RegisterPageModel registerPageModel;
	private DashboardPageModel dashboardPageModel;

	private GooglePageModel googlePageModel;
	private EmailVarificationPageModel emailVarificationPageModel;

	private TradingAccountPageModel tradingAccountPageModel;

	int noTestCase;

	@DataProvider(name = "dataProvidertest227")
	public Object[] dataProvidertest227() {
		List<AccountDetailDto> listAccountDetailDtos;
		List<RegisterDto> listRegisterDto;

		listRegisterDto = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_227_DATA_PATH,
				Constant.REGISTER_TEST_DATA_SHEET, RegisterDto.excelTemplate(), RegisterDto.class);

		listAccountDetailDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_227_DATA_PATH,
				Constant.ACCOUNT_DETAILS, AccountDetailDto.excelTemplate(), AccountDetailDto.class);

		Object[] mapStringObjectArray = new Object[listRegisterDto.size() * listAccountDetailDtos.size() / 2];
		int i = 0;
		for (RegisterDto registerDto : listRegisterDto) {
			for (AccountDetailDto accountDetailDto : listAccountDetailDtos) {
				if (sameRegulator(registerDto.getTitle(), accountDetailDto.getTitle())) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("registerDto", registerDto);
					map.put("accountDetailDto", accountDetailDto);
					mapStringObjectArray[i++] = map;
				} else {
					System.out.println("no same");
				}
			}
		}
		noTestCase = 0;
		return mapStringObjectArray;
	}

	@BeforeTest
	public void beforeTest() {
		driver = WebDriverFactory.getDriver(Constant.CHROME);
	}

	@Test(dataProvider = "dataProvidertest227")
	public void test226(Map<String, Object> map) {
		String browser = Constant.CHROME;
		RegisterDto registerDto = (RegisterDto) map.get("registerDto");
		AccountDetailDto accountDetailDto = (AccountDetailDto) map.get("accountDetailDto");
		noTestCase++;

//		if (noTestCase < 103 || noTestCase > 150) {
//			return;
//		}

		boolean result = true;
		loginPageModel = new LoginPageModel(driver);
		registerPageModel = new RegisterPageModel(driver);
		dashboardPageModel = new DashboardPageModel(driver);
		tradingAccountPageModel = new TradingAccountPageModel(driver);
		String regulator = "";
		loginPageModel.load();

		loginPageModel.clickOpenAccount();

		String email = "qa_automation+" + System.currentTimeMillis() + "@fxprimus.tech";
		registerDto.setEmail(email);

		registerPageModel.inputDataAndRegister(registerDto);

		tradingAccountPageModel.load();

		if (isCY(registerDto.getTitle())) {
			regulator = "CY";
		} else {
			regulator = "VU";
		}

		String titleTestCase = "Account detail " + noTestCase + " : " + browser + "_" + regulator + "_"
				+ registerDto.getAccountType();
		extentTest = extentReport.createTest(titleTestCase);

		extentTest.info("Regulator: " + regulator);
		extentTest.info("Type: " + registerDto.getAccountType());
		extentTest.info("Email: " + registerDto.getEmail());
		extentTest.info("Password: " + registerDto.getPassword());

		extentTest.info("Account type: " + accountDetailDto.getAccountType());
		extentTest.info("Leverage: " + accountDetailDto.getLeverage());
		extentTest.info("Deposit Currency: " + accountDetailDto.getDepositCurrency());

		extentTest.info("____________________");

		if (navigationMenu()) {
			extentTest.info("Navigation menu: Successfull");
		} else {
			extentTest.info("Navigation menu: Fail");
			result = false;
		}
		if (dashboard()) {
			extentTest.info("Dashboard: Successfull");
		} else {
			extentTest.info("Dashboard: Fail");
			result = false;
		}

		if (sidebarMenu()) {
			extentTest.info("Sidebar menu: Successfull");
		} else {
			extentTest.info("Sidebar menu: Fail");
			result = false;
		}

		if (isCY(registerDto.getTitle())) {
			if (tradingAccountPageModel.valideteLeverageCY()) {
				tradingAccountPageModel.load();
				extentTest.info("Only 1:30: Successfull");
			} else {
				result = false;
				extentTest.info("Only 1:30: Fail");
			}
		}

		try {
			tradingAccountPageModel.inputData(accountDetailDto);
			tradingAccountPageModel.clickButtonProceed();
			dashboardPageModel.load();
			if (dashboardPageModel.isCompleted("step three")) {
				extentTest.info("Account Details: Successfull");
			} else {
				System.out.println();
			}
		} catch (Exception e) {
			result = false;
			extentTest.info("Account Details: Fail");
			e.printStackTrace();
		}
		if (result) {
			extentTest.pass("PASS");
		} else {
			extentTest.fail("FAIL");
		}
		extentReport.flush();

		dashboardPageModel.logout();
	}

	public void googlePageModelLoadAndverifyInEmail(RegisterDto registerDto) {
		if (googlePageModel.isWaitDisplay("Email Verification | FXPRIMUS")) {
			System.out.println("googlePageModel.isWaitDisplay");
		}
		googlePageModel.load();
		boolean verifySuccess = googlePageModel.verifyInEmail(Constant.GMAIL_QA_AUTOMATION,
				Constant.GMAIL_QA_AUTOMATION_PASSWORD);
		if (!verifySuccess) {
			return;
		}

		if (emailVarificationPageModel.isDisplayed(15)) {

		} else if (loginPageModel.waitPageLoad("Login")) {
			loginPageModel.login(registerDto.getEmail(), registerDto.getPassword());
		}
		emailVarificationPageModel.action(googlePageModel.getPin());
	}

	public boolean tradingAccountIsDisplayed() {
		if (tradingAccountPageModel.isWaitDisplay()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean navigationMenu() {
		dashboardPageModel.load();
		tradingAccountPageModel.load();
		return tradingAccountIsDisplayed();
	}

	public boolean dashboard() {
		dashboardPageModel.load();
		dashboardPageModel.setButtonAccountDetails();
		return tradingAccountIsDisplayed();
	}

	public boolean sidebarMenu() {
		dashboardPageModel.load();

		dashboardPageModel.clickViewRegistrationProgress();
		dashboardPageModel.clickAccountDetailsInSideCard();

//		dashboardPageModel.clickViewProfileList();
//		dashboardPageModel.clickAccountDetailsInProfile();
		return tradingAccountIsDisplayed();
	}

	public boolean isCY(String regulator) {
		return regulator.contains("regulator CY");
	}

	public boolean isVU(String regulator) {
		return regulator.contains("regulator VU");
	}

	public boolean sameRegulator(String registerTitle, String accountDetailTitle) {

		if (isCY(registerTitle) && isCY(accountDetailTitle)) {
			return true;
		}
		if (isVU(registerTitle) && isVU(accountDetailTitle)) {
			return true;
		}

		return false;
	}
}
