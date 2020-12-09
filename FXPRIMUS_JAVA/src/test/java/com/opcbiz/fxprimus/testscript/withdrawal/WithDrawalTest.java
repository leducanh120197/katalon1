package com.opcbiz.fxprimus.testscript.withdrawal;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.qa20.BankDetailDto;
import com.opcbiz.fxprimus.dto.qa20.QA20AccountDto;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.profile.BankDetailsPageModel;
import com.opcbiz.fxprimus.page.withdrawal.WithDrawalPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.webdriver.WebDriverFactory;

public class WithDrawalTest extends BaseTest {
	int noTestCaseQA20;
	LoginPageModel loginPageModel;
	WithDrawalPageModel withDrawalPageModel;
	BankDetailsPageModel bankDetailsPageModel;
	BankDetailDto bankDetailDto = new BankDetailDto(Constant.BANK_NAME, Constant.BANK_ADDRESS,
			Constant.BANK_ACCOUNT_NUMBER, Constant.BANK_SWIFT_CODE, Constant.BANK_IBAN, Constant.BANK_COUNTRY);

	@DataProvider
	public QA20AccountDto[] dataProviderWithDrawal() {

		List<QA20AccountDto> listQA20AccountDto;

		listQA20AccountDto = ExcelUtils.getInstance().getDataFromExcel(Constant.QA_20_DATA_PATH,
				Constant.QA_20_DATA_SHEET, QA20AccountDto.excelTemplate(), QA20AccountDto.class);
		QA20AccountDto[] arrayQA20AccountDto = new QA20AccountDto[listQA20AccountDto.size()];
		for (int i = 0; i < listQA20AccountDto.size(); i++) {
			arrayQA20AccountDto[i] = listQA20AccountDto.get(i);
		}
		noTestCaseQA20 = 0;
		System.out.println("dataProviderWithDrawal");
		return arrayQA20AccountDto;
	}

	@Test(dataProvider = "dataProviderWithDrawal")
	public void withDrawalTest(QA20AccountDto qA20AccountDto) {
		noTestCaseQA20++;
		double totalMoneyBeforeWithDrawal = 0;
		double totalMoneyAfterWithDrawal = 0;
		int amount = new Random().nextInt(2) + 1;
		amount = 1;
		int totalHistoryBeforeWithDrawal = 0;
		int totalHistoryAfterWithDrawal = 0;

		if (noTestCaseQA20 <= 14) {
			return;
		}

		loginPageModel = new LoginPageModel(driver);
		loginPageModel.loadPartnerLogin();
		inputDataAndClickLogin(qA20AccountDto);
		String qA20AccountDtoType = qA20AccountDto.getType();

		withDrawalPageModel = new WithDrawalPageModel(driver);

		driverGetWithDrawlLink(qA20AccountDtoType);
		if (withDrawalPageModel.isDisplayWithDrawalTitle()) {
			if (withDrawalPageModel.isDisplayBankAccountDetails()) { // fill bank detail
				withDrawalPageModel.clickBankAccountDetails();
				bankDetailsPageModel = new BankDetailsPageModel(driver);
				bankDetailsPageModel.inputData(bankDetailDto);
				bankDetailsPageModel.clickSubmitButton();
				driverGetWithDrawlLink(qA20AccountDtoType);
			}
			else {
				System.out.println("No bank detail");
			}
			totalMoneyBeforeWithDrawal = withDrawalPageModel.getTotalMoney();
			viewHistoryToDay();
			totalHistoryBeforeWithDrawal = withDrawalPageModel.getTotalHistoryToDay();
			try {
				driverGetWithDrawlLink(qA20AccountDtoType);
				withDrawalPageModel.inputDataWithDrawal(amount);
				withDrawalPageModel.clickConfirmButton();
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[contains(text(),'equest was successful.')]")));
//					totalMoneyBeforeWithDrawal = getTotalMoneyFromMoneyToString(getMoneyToString);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			driverGetWithDrawlLink(qA20AccountDtoType);
			driverGetWithDrawlLink(qA20AccountDtoType);
			totalMoneyAfterWithDrawal = withDrawalPageModel.getTotalMoney();
			viewHistoryToDay();
			totalHistoryAfterWithDrawal = withDrawalPageModel.getTotalHistoryToDay();
			boolean result = getResult(totalMoneyBeforeWithDrawal, totalMoneyAfterWithDrawal, amount,
					totalHistoryBeforeWithDrawal, totalHistoryAfterWithDrawal);

			String titleTestCase = "WD" + "_" + (noTestCaseQA20) + " - " + "Group test cases Withdrawal";
			System.out.println(titleTestCase);
			extentTest = extentReport.createTest(titleTestCase);
			extentTestInfo(extentTest, qA20AccountDto, totalMoneyBeforeWithDrawal, totalMoneyAfterWithDrawal, amount,
					totalHistoryBeforeWithDrawal, totalHistoryAfterWithDrawal);

			if (result) {
				extentTest.pass("PASS");
			} else {
				extentTest.fail("FAIL");
			}
		} else {
			System.out.println("Can not load withdrawal page");
			extentTest.info("Can not load withdrawal page");
			extentTest.fail("FAIL");
		}
		System.out.println();
		extentReport.flush();
		try {
			withDrawalPageModel.logout();
		} catch (Exception e) {
			System.out.println();
		}

	}

	@BeforeTest
	public void beforeTest() {
		driver = WebDriverFactory.getDriver(Constant.CHROME);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public void extentTestInfo(ExtentTest extentTest, QA20AccountDto qA20AccountDto, double moneyBefore,
			double moneyAfter, int amount, int historyBefore, int historyAfter) {
		extentTest.info("ID: " + qA20AccountDto.getId());
		extentTest.info("Email: " + qA20AccountDto.getEmail());
		extentTest.info("Password: " + qA20AccountDto.getPassWord());
		extentTest.info("Money before withdrawal: " + moneyBefore);
		extentTest.info("Total records in history before withdrawal: " + historyBefore);
		extentTest.info("Amount: " + amount);
		extentTest.info("Money after withdrawal: " + moneyAfter);
		extentTest.info("Total records in history after withdrawal:  " + historyAfter);
	}

	public void inputDataAndClickLogin(QA20AccountDto loginQA20AccountDto) {
		loginPageModel.setTextboxUsername(loginQA20AccountDto.getEmail());
		loginPageModel.setTextboxPassword(loginQA20AccountDto.getPassWord());
		loginPageModel.setButtonLogin();
		loginPageModel.afterClickLogin();
	}

	public void driverGetWithDrawlLink(String type) {
		if (type.contains(Constant.CLIENT_UPPER)) {
			this.driver.get(UrlConstant.WITHDRAWAL_CLIENT_LINK);
			System.out.println("this.driver.get(UrlConstant.WITHDRAWAL_PARTNER_LINK);");
		} else {
			this.driver.get(UrlConstant.WITHDRAWAL_PARTNER_LINK);
			System.out.println("this.driver.get(UrlConstant.WITHDRAWAL_PARTNER_LINK);");
		}
	}

	public void driverGetWithDrawlHistoryLink(String type) {
		if (type.contains(Constant.CLIENT_UPPER)) {
			this.driver.get(UrlConstant.WITHDRAWAL_HISTORY_CLIENT_LINK);
			System.out.println("this.driver.get(UrlConstant.WITHDRAWAL_HISTORY_CLIENT_LINK);");
		} else {
			this.driver.get(UrlConstant.WITHDRAWAL_HISTORY_PARTNER_LINK);
			System.out.println("this.driver.get(UrlConstant.WITHDRAWAL_HISTORY_PARTNER_LINK);");
		}
	}

	public void driverGetWithDrawlHistoryLinkPartner() {
		this.driver.get(UrlConstant.WITHDRAWAL_HISTORY_PARTNER_LINK);
		System.out.println("this.driver.get(UrlConstant.WITHDRAWAL_HISTORY_PARTNER_LINK);");
	}

	public boolean getResult(double moneyBefore, double moneyAfter, int amount, int historyBefore, int historyAfter) {
		if ((moneyBefore - amount) == moneyAfter && (historyBefore + 1) == historyAfter) {
			return true;
		}
		return false;
	}

	public void viewHistoryToDay() {
		driverGetWithDrawlHistoryLinkPartner();
		withDrawalPageModel.inputDataHistoryToDay();
		withDrawalPageModel.clickViewHistoryButton();
	}

	public double getTotalMoneyFromMoneyToString(String money) {
		String[] moneys = money.split(" ");
		double totalMoney = Double.parseDouble(moneys[moneys.length - 1]);
		return totalMoney;
	}
}
