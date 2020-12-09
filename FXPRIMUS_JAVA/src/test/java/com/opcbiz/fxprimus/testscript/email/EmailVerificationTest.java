package com.opcbiz.fxprimus.testscript.email;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.register.RegisterDto;
import com.opcbiz.fxprimus.dto.uniqueuser.EmailVerificationDto;
import com.opcbiz.fxprimus.page.authentication.EmailVarificationPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.email.GooglePageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;

public class EmailVerificationTest extends BaseTest   {
	
	RegisterPageModel registerPageModel;
	GooglePageModel googlePageModel;
	EmailVarificationPageModel emailVarificationPageModel;
	DashboardPageModel dashboardPageModel;

	@DataProvider(name = "emailVerificationDataProvider")
	public Object[][] dataProviderEmailVerifycation() throws ClassNotFoundException {
		List<EmailVerificationDto> emailVerificationDtos;
		emailVerificationDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.REGISTER_TEST_DATA_PATH,
				Constant.REGISTER_TEST_DATA_EMAIL_VERIFYCATION_SHEET, EmailVerificationDto.excelTemplate(),
				EmailVerificationDto.class);
		EmailVerificationDto[][] emailVerificationDtosMatrix = new EmailVerificationDto[emailVerificationDtos
				.size()][1];
		for (int i = 0; i < emailVerificationDtos.size(); i++) {
			emailVerificationDtosMatrix[i][0] = emailVerificationDtos.get(
					(i));
		}
		return emailVerificationDtosMatrix;
	}

	@Test(priority = 1)
	public void precondition() {
		extentTest = extentReport.createTest("precondition");

		this.driver.get(UrlConstant.REGISTER_PAGE);
		registerPageModel = new RegisterPageModel(driver);
		registerPageModel.inputDataAndRegister(RegisterDto.getExample());
	}


	@Test(priority = 2, dataProvider = "emailVerificationDataProvider")
	public void emailVerification(EmailVerificationDto emailVerificationDto) {
		extentTest = extentReport.createTest(emailVerificationDto.getId()+" "+emailVerificationDto.getTitle());
		extentTest.info(emailVerificationDto.toString());
		log(emailVerificationDto.getTitle(), "(");
		log(emailVerificationDto.getId());
		
		if (emailVerificationDto.getExpectedResult().equals(Constant.SUCCESS)) {
			// go to email
			googlePageModel = new GooglePageModel(driver);
			this.driver.get(UrlConstant.GMAIL_PAGE);
			boolean verifySuccess = googlePageModel.verifyInEmail();
			if (!verifySuccess) {
				extentTest.fail("verify unsuccessfull");
				Assert.assertTrue(false, "verify unsuccessfull");
			}
			
			emailVarificationPageModel = new EmailVarificationPageModel(driver);
			emailVarificationPageModel.action();
			dashboardPageModel = new DashboardPageModel(driver);
			String dashboardPageModelGetTitle = dashboardPageModel.getTitle();
			extentTest.info("current web page "+dashboardPageModelGetTitle);
			extentTest.info("Expected web page "+ Constant.DASHBOARD);
			extentTest.pass("passed");
			Assert.assertTrue(dashboardPageModelGetTitle.contains("Dashboard"));
		}

		// validate
		if (emailVerificationDto.getExpectedResult().equals(Constant.VALIDATION)) {
			// set page model
			emailVarificationPageModel = new EmailVarificationPageModel(driver);

			// input data
			
			if(emailVerificationDto.getId().equals("EV_007")) {
				emailVarificationPageModel.inputDataAndRegister(emailVerificationDto);
			}else {
				emailVarificationPageModel.inputData(emailVerificationDto);
			}

			boolean isValiMailVerify = emailVarificationPageModel.isValidUniquePin(emailVerificationDto)
					&& emailVarificationPageModel.isValidButtonVerify(emailVerificationDto);
			log("assert "+ isValiMailVerify + " ",")");
			if(isValiMailVerify) {
				extentTest.pass("passed");
			}else {
				extentTest.fail("fail");
			}
			Assert.assertTrue(isValiMailVerify);
		}

	}




	

}
