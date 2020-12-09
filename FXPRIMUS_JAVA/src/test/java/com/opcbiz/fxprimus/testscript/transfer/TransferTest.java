package com.opcbiz.fxprimus.testscript.transfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.qa19.AccountDto;
import com.opcbiz.fxprimus.dto.qa19.QA19Dto;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.page.transfer.TransferPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.webdriver.WebDriverFactory;

public class TransferTest extends BaseTest {
	LoginPageModel loginPageModel;
	DashboardPageModel dashboardPageModel;
	TransferPageModel transferPageModel;

	List<AccountDto> listAccountDto;
	Map<String, List<AccountDto>> mapListAccountDto = new HashMap<String, List<AccountDto>>();
	Map<String, List<AccountDto>> mapListAccountDtoFromExcel;
	AccountDto accountRoot = new AccountDto(Constant.ROOT_MT4_ID, Constant.ROOT_ID, Constant.ROOT_EMAIL,
			Constant.ROOT_PASSWORD, Constant.ROOT_TYPE, "IB_INDI", Constant.ROOT_REF_ID);
	int noTestCaseQA19;
	int noTestCaseTransfer;
	String[] arrayTypeTransfer = { "USER ID", "USERNAME", "MT4 ID" };

	@DataProvider
	public QA19Dto[] dataProviderTransfer() {
		mapListAccountDtoFromExcel = new HashMap<String, List<AccountDto>>();
		List<AccountDto> listPartnerAccountDto;
		List<AccountDto> listClientAccountDto;
		List<AccountDto> listMixAccountDto;

		listPartnerAccountDto = ExcelUtils.getInstance().getDataFromExcel(Constant.QA19_LIST_ACCOUNT_DATA_PATH,
				Constant.PARTNER_UPPER, AccountDto.excelTemplate(), AccountDto.class);
		listClientAccountDto = ExcelUtils.getInstance().getDataFromExcel(Constant.QA19_LIST_ACCOUNT_DATA_PATH,
				Constant.CLIENT_UPPER, AccountDto.excelTemplate(), AccountDto.class);
		listMixAccountDto = ExcelUtils.getInstance().getDataFromExcel(Constant.QA19_LIST_ACCOUNT_DATA_PATH,
				Constant.QA19_ACCOUNT_MIX_DATA_SHEET, AccountDto.excelTemplate(), AccountDto.class);

		listPartnerAccountDto.add(0, accountRoot);
		listClientAccountDto.add(0, accountRoot);
		listMixAccountDto.add(0, accountRoot);

		mapListAccountDtoFromExcel.put("1", listClientAccountDto);
		mapListAccountDtoFromExcel.put("2", listPartnerAccountDto);
		mapListAccountDtoFromExcel.put("3", listMixAccountDto);

		List<QA19Dto> qA19Dtos;
		qA19Dtos = ExcelUtils.getInstance().getDataFromExcel(Constant.QA19_DATA_PATH, Constant.QA_19_DATA_SHEET,
				QA19Dto.excelTemplate(), QA19Dto.class);
		QA19Dto[] arrayQA19Dto = new QA19Dto[qA19Dtos.size()];
		for (int i = 0; i < qA19Dtos.size(); i++) {
			arrayQA19Dto[i] = qA19Dtos.get(i);
		}
		noTestCaseQA19 = 0;

		return arrayQA19Dto;
	}

	@Test(dataProvider = "dataProviderTransfer")
	public void transferTest(QA19Dto qA19Dto) {
		noTestCaseQA19 += 1;
		noTestCaseTransfer = 0;

		int startTestCase  = 0;
		int endTestCase = 1000;

		driver = WebDriverFactory.getDriver(Constant.CHROME);
		List<AccountDto> listAccountDtoFromExcel = mapListAccountDtoFromExcel.get(noTestCaseQA19 + "");
		for (AccountDto transferAccountDto : listAccountDtoFromExcel) {
//			if (isPartner(transferAccountDto) && isRoot(transferAccountDto)) { // transfer from root
			if (isPartner(transferAccountDto)) {
				if(noTestCaseQA19 == 2 && !isRoot(transferAccountDto)) { // No performed transfer from partner to root
					continue;
				}
				for (AccountDto receiveAccountDto : listAccountDtoFromExcel) {
					if (!transferAccountDto.equals(receiveAccountDto)) {
						noTestCaseTransfer += 1;
						System.out.println("noTestCaseTransfer: " + noTestCaseTransfer);
						loginAndTransfer(listAccountDtoFromExcel, transferAccountDto,
								receiveAccountDto, qA19Dto);
					}
				}
			} else {
				System.out.println(noTestCaseTransfer);
			}
		}
		driver.quit();
	}

	public boolean loginAndTransfer(List<AccountDto> listAccountDtoFromExcel, AccountDto transferAccountDto,
			AccountDto receiveAccountDto, QA19Dto qA19Dto) {

		loginPageModel = new LoginPageModel(driver);
		loginPageModel.loadPartnerLogin();
		inputDataAndClickLogin(transferAccountDto);

		transferPageModel = new TransferPageModel(driver);
		driverGetPartnerTransferLink();

		if (transferPageModel.waitPageTransferLoadGetTitle()) {

			if (!transferPageModel.isDisplay()) {
				if (loginPageModel.isDisplay()) {
					inputDataAndClickLogin(transferAccountDto);
					driverGetPartnerTransferLink();
				}
			}

			boolean canTransferInNetwork = canTransferInNetwork(listAccountDtoFromExcel, transferAccountDto,
					receiveAccountDto);

			for (int indexType = 0; indexType < arrayTypeTransfer.length; indexType++) {
			// for (int indexType = 1; indexType < 2; indexType++) {
				String typeOfTransfer = arrayTypeTransfer[indexType];
				String titleTestCaseUserId = "Transfer" + "_Network_" + (noTestCaseQA19) + "_" + (noTestCaseTransfer)
						+ "_" + (typeOfTransfer) + " - " + qA19Dto.getTitle();
				System.out.println(titleTestCaseUserId);
				extentTest = extentReport.createTest(titleTestCaseUserId);
				extentTestInfoAccount(transferAccountDto, receiveAccountDto, extentTest);

				boolean successTransfer;
				transferPageModel.inputData(typeOfTransfer, transferAccountDto, receiveAccountDto, extentTest);
				if (transferPageModel.buttonTransferDisabled()) {
					extentTest.info("can not transfer");
					successTransfer = false;
				} else {
					transferPageModel.clickTransferButton();
					try {
						WebDriverWait wait = new WebDriverWait(driver, 9);
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[contains(text(),'was successful')]")));
						extentTest.info("can transfer");
						successTransfer = true;
					} catch (Exception e) {
						System.out.println("NOT Your request was successful");
						successTransfer = false;
					}
				}
				if (canTransferInNetwork == successTransfer) {
					extentTest.pass("pass");
				} else {
					extentTest.fail("fail");
				}
				extentReport.flush();
			}

		} else {
			System.out.println("Not title MT4");
			String titleTestCase = "Transfer" + "_Network_" + (noTestCaseQA19) + "_" + (noTestCaseTransfer);
			System.out.println(titleTestCase);
			extentTest = extentReport.createTest(titleTestCase);
			extentTestInfoAccount(transferAccountDto, receiveAccountDto, extentTest);
			extentTest.info("can not load transfer");
			extentTest.fail("fail");
			extentReport.flush();
		}

		try {
			transferPageModel.logout();
		} catch (Exception e) {
			System.out.println();
		}
		return true;
	}

	public boolean loginAndTransferUserName(List<AccountDto> listAccountDtoFromExcel, AccountDto transferAccountDto,
			AccountDto receiveAccountDto, ExtentTest extentTest) {

		extentTestInfoAccount(transferAccountDto, receiveAccountDto, extentTest);

		loginPageModel = new LoginPageModel(driver);
		loginPageModel.loadPartnerLogin();
		inputDataAndClickLogin(transferAccountDto);

		transferPageModel = new TransferPageModel(driver);
		driverGetPartnerTransferLink();

		boolean successTransfer;
		if (transferPageModel.waitPageTransferLoadGetTitle()) {

			if (!transferPageModel.isDisplay()) {
				if (loginPageModel.isDisplay()) {
					inputDataAndClickLogin(transferAccountDto);

					driverGetPartnerTransferLink();
					transferPageModel.inputDataUserName(transferAccountDto, receiveAccountDto, extentTest);
				}
			}
			transferPageModel.inputDataUserName(transferAccountDto, receiveAccountDto, extentTest);
			if (transferPageModel.buttonTransferDisabled()) {
				extentTest.info("can not transfer");
				successTransfer = false;
			} else {
				transferPageModel.clickTransferButton();
				try {
					WebDriverWait wait = new WebDriverWait(driver, 9);
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[contains(text(),'was successful.')]")));
					extentTest.pass("pass");
					extentTest.info("can transfer");
					successTransfer = true;
				} catch (Exception e) {
					System.out.println("NOT Your request was successful");
					successTransfer = false;
				}
			}

			boolean canTransferInNetwork;
			if (receiveAccountDto.getID().equals(Constant.ROOT_ID)) {
				canTransferInNetwork = false;
			} else {
				canTransferInNetwork = canTransferInNetwork(listAccountDtoFromExcel, transferAccountDto,
						receiveAccountDto);
			}

			if (canTransferInNetwork == successTransfer) {
				successTransfer = true;
			} else {
				successTransfer = false;
			}
		} else {
			System.out.println("Not title MT4");
			extentTest.info("can not load transfer");
			successTransfer = false;
		}
		try {
			transferPageModel.logout();
		} catch (Exception e) {
			System.out.println();
		}

		return successTransfer;
	}

	public boolean canTransferInNetwork(List<AccountDto> ListAccountDto, AccountDto transferAccountDto,
			AccountDto receiveAccountDto) {
		System.out.println("canTransferInNetwork - doing");
		if (receiveAccountDto.getID().equals(Constant.ROOT_ID)) {
			System.out.println("receiveAccountDto is ROOT");
			return false;
		}

		boolean flag = true;
		String refIdaccountDtoTo = receiveAccountDto.getRefId(); // 50000230

		List<String> vetical = new ArrayList<String>();
		vetical.add(receiveAccountDto.getRefId());
		int count = 0;
		while (!refIdaccountDtoTo.equals(Constant.ROOT_ID)) { // 50000230 != 50000175
			for (AccountDto accountDto : ListAccountDto) {
				if (refIdaccountDtoTo.equals(accountDto.getID())) { // 50000230 = 50000230
					refIdaccountDtoTo = accountDto.getRefId(); // 50000230 -> 50000175
					vetical.add(refIdaccountDtoTo);
					break;
				}
				count++;
			}

			if (count > 200) {
				System.out.println();
			}
		}
		if (vetical.contains(transferAccountDto.getID())) {
			flag = true;
		} else {
			flag = false;
		}
		System.out.println("canTransferInNetwork - " + flag);
		return flag;
	}

	public boolean isPartner(AccountDto transferAccountDto) {
		String type = transferAccountDto.getType();
		if (type.contains(Constant.PARTNER_UPPER)) {
			return true;
		}
		return false;
	}

	public boolean isRoot(AccountDto transferAccountDto) {
		String getRefId = transferAccountDto.getRefId();
		if (getRefId.contains(Constant.ROOT_REF_ID)) {
			return true;
		}
		return false;
	}

	public void inputDataAndClickLogin(AccountDto LoginAccountDto) {
		loginPageModel.setTextboxUsername(LoginAccountDto.getEmail());
		loginPageModel.setTextboxPassword(LoginAccountDto.getPassWord());
		loginPageModel.setButtonLogin();
		loginPageModel.afterClickLogin();
	}

	public void driverGetPartnerTransferLink() {
		this.driver.get(UrlConstant.PARTNER_TRANSFER_LINK);
		System.out.println("this.driver.get(UrlConstant.PARTNER_TRANSFER_LINK);");
	}

	public void extentTestInfoAccount(AccountDto transferAccountDto, AccountDto receiveAccountDto,
			ExtentTest extentTest) {
		extentTest.info("FROM: ");
		extentTest.info("Account ID: " + transferAccountDto.getID());
		extentTest.info("Account Email: " + transferAccountDto.getEmail());
		extentTest.info("Account Password: " + transferAccountDto.getPassWord());
		extentTest.info("Account Type: " + transferAccountDto.getType());
		extentTest.info("Referral ID: " + transferAccountDto.getRefId());
		extentTest.info("____________________");
		extentTest.info("To: ");
		extentTest.info("Account ID: " + receiveAccountDto.getID());
		extentTest.info("Account Email: " + receiveAccountDto.getEmail());
		extentTest.info("Account Password: " + receiveAccountDto.getPassWord());
		extentTest.info("Account Type: " + receiveAccountDto.getType());
		extentTest.info("Referral ID: " + receiveAccountDto.getRefId());
		extentTest.info("____________________");
	}
}
