package com.opcbiz.fxprimus.testscript.authentication;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.migration.MigrationValidationDto;
import com.opcbiz.fxprimus.dto.migration.RegisterDto;
import com.opcbiz.fxprimus.page.authentication.AccountDevSingPageModel;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.email.GooglePageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.EmailUtils;
import com.opcbiz.fxprimus.utils.ExcelUtils;

public class MigrationTest extends BaseTest {

	private RegisterPageModel registerPageModel;
	private GooglePageModel googlePageModel;
	private LoginPageModel loginPageModel;
	private DashboardPageModel dashboardPageModel;
	private AccountDevSingPageModel accountDevSingPageModel;
	private List<String> savedRegisterEmail;
	List<RegisterDto> registerDtos;

	@DataProvider(name = "register")
	public Object[][] dataProviderRegister() {
		registerDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MIGRATION_DATA_PATH,
				Constant.NEW_EMAIL_DATA_SHEET, RegisterDto.excelTemplate(), RegisterDto.class);

		savedRegisterEmail = new ArrayList<String>();

		RegisterDto[][] registerDtosMatrix = new RegisterDto[registerDtos.size()][1];
		for (int i = 0; i < registerDtos.size(); i++) {
			registerDtosMatrix[i][0] = registerDtos.get((i + 3) % registerDtos.size());
			String newEmail = EmailUtils.get(registerDtos.get(i).getEmail());
			savedRegisterEmail.add(newEmail);
			registerDtosMatrix[i][0].setEmail(newEmail);
		}
		return registerDtosMatrix;
	}

	@Test(priority = 1, dataProvider = "register", enabled = false)
	public void register(RegisterDto registerDto) {
		registerPageModel = new RegisterPageModel(driver);
		registerPageModel.load();
		registerPageModel.inputDataAndRegister(registerDto);

		googlePageModel = new GooglePageModel(driver);
		this.driver.get(UrlConstant.GMAIL_PAGE);
		boolean verifySuccess = googlePageModel.verifyInEmail("qa_automation@fxprimus.tech", "}V75nBXEaRgB");
		if (!verifySuccess) {

		}

		// CY sendkey pin
		// logout
	}

	@DataProvider(name = "migration")
	public Object[][] dataProviderMigration() {
		List<MigrationValidationDto> migrationValidationDtos;

		migrationValidationDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MIGRATION_DATA_PATH,
				Constant.MIGRATION_DATA_SHEET, MigrationValidationDto.excelTemplate(), MigrationValidationDto.class);

		MigrationValidationDto[][] migrationValidationDtoMatrix = new MigrationValidationDto[migrationValidationDtos
				.size()][1];
		for (int i = 0; i < migrationValidationDtos.size(); i++) {
			migrationValidationDtoMatrix[i][0] = migrationValidationDtos.get((i) % migrationValidationDtos.size());
		}
		
		
		
		registerDtos = new ArrayList<RegisterDto>();
		RegisterDto dto0 = new RegisterDto();
		dto0.setAccountType("Individual");
		;
		dto0.setRegulatorType("CY");
		dto0.setEmail("qa_automation+2241587352@fxprimus.tech");// estonia
		dto0.setPassword("Testauto01@");
		registerDtos.add(dto0);

		RegisterDto dto1 = new RegisterDto();
		dto1.setAccountType("Individual");
		;
		dto1.setRegulatorType("ZA");
		dto1.setEmail("qa_automation+2241587354771025@fxprimus.tech");// South Afri individual 2241587354771024
		dto1.setPassword("Testauto01@");
		registerDtos.add(dto1);

		RegisterDto dto2 = new RegisterDto();
		dto2.setAccountType("Individual");
		;
		dto2.setRegulatorType("VU");
		dto2.setEmail("qa_automation+2241587356401561@fxprimus.tech");// ALBANI
		dto2.setPassword("Testauto01@");
		registerDtos.add(dto2);

		RegisterDto dto3 = new RegisterDto();
		dto3.setAccountType("Corporate");
		;
		dto3.setRegulatorType("CY");
		dto3.setEmail("qa_automation+2241587357073032@fxprimus.tech");// Denmark
		dto3.setPassword("Testauto01@");
		registerDtos.add(dto3);

		RegisterDto dto4 = new RegisterDto();
		dto4.setAccountType("Corporate");
		;
		dto4.setRegulatorType("ZA");
		dto4.setEmail("qa_automation+228005241@fxprimus.tech");// NIGERIA
		dto4.setPassword("Testauto01@");
		registerDtos.add(dto4);

		RegisterDto dto5 = new RegisterDto();
		dto5.setAccountType("Corporate");
		;
		dto5.setRegulatorType("VU");
		dto5.setEmail("qa_automation+229006501@fxprimus.tech");// Andorra
		dto5.setPassword("Testauto01@");
		registerDtos.add(dto5);

		RegisterDto dto6 = new RegisterDto();
		dto6.setAccountType("Joint");
		;
		dto6.setRegulatorType("CY");
		dto6.setEmail("qa_automation+230007671@fxprimus.tech");// Latvia
		dto6.setPassword("Testauto01@");
		registerDtos.add(dto6);

		RegisterDto dto7 = new RegisterDto();
		dto7.setAccountType("Joint");
		;
		dto7.setRegulatorType("ZA");
		dto7.setEmail("qa_automation+231008241@fxprimus.tech");// Tanzania
		dto7.setPassword("Testauto01@");
		registerDtos.add(dto7);

		RegisterDto dto8 = new RegisterDto();
		dto8.setAccountType("Joint");
		;
		dto8.setRegulatorType("VU");
		dto8.setEmail("qa_automation+232009501@fxprimus.tech");// Aruba
		dto8.setPassword("Testauto01@");
		registerDtos.add(dto8);
		return migrationValidationDtoMatrix;

	}

	@Test(priority = 2, dataProvider = "migration")
	public void migrateValidationDto(MigrationValidationDto migrationValidationDto) {
		dashboardPageModel = new DashboardPageModel(driver);
		loginPageModel = new LoginPageModel(driver);
		accountDevSingPageModel = new AccountDevSingPageModel(driver);

		for (RegisterDto registerDto : registerDtos) {
			if (registerDto.getRegulatorType().equals(migrationValidationDto.getRegulatorType())) {
				
				this.driver = new SafariDriver();
				extentTest = extentReport.createTest(migrationValidationDto.getId() + " "
						+ migrationValidationDto.getRegulatorType() + " "  + registerDto.getAccountType() + " "  + migrationValidationDto.getTitle());
				loginPageModel = new LoginPageModel(driver);
				loginPageModel.load();
				loginPageModel.login(registerDto.getEmail(), registerDto.getPassword());
				
				
				String expect = migrationValidationDto.getMigrationValidation();// http://account-dev-sing-2.fxprimus.tech/en/user/overview
				
				boolean resultForEachCase = loginPageModel.checkUrlAfterLogin(expect);
				extentTest.info("actual "+this.driver.getCurrentUrl());
				extentTest.info("expect " + expect);
				if (resultForEachCase) {
					extentTest.pass("pass");
				} else {
					extentTest.fail("fail");
				}
				extentReport.flush();
				this.driver.quit();
				//this.driver.manage().deleteAllCookies();
//				if (migrationValidationDto.getRegulatorType().equals("CY"))
//					dashboardPageModel.logoutDashboard();
//				else {
//					try {
//						click(accountDevSingPageModel.logOutBtn);
//						
//					}catch (Exception e) {
//						try {
//							accountDevSingPageModel.accept.click();
//						} catch (Exception ee) {}
//						try {
//							accountDevSingPageModel.answer.sendKeys("a");
//							accountDevSingPageModel.submit.click();
//						} catch (Exception eee) {}
//						accountDevSingPageModel.logOutBtn.click();
//					}
//				}
			}
		}

	}

}
