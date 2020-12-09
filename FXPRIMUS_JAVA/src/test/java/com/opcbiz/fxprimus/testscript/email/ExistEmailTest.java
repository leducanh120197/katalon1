package com.opcbiz.fxprimus.testscript.email;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.register.RegisterDto;
import com.opcbiz.fxprimus.dto.uniqueuser.EmailVerificationDto;
import com.opcbiz.fxprimus.dto.uniqueuser.ExistEmailCheckIdDto;
import com.opcbiz.fxprimus.dto.uniqueuser.ExistEmailDto;
import com.opcbiz.fxprimus.page.authentication.AffiliateRegisterPageModel;
import com.opcbiz.fxprimus.page.authentication.EmailVarificationPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.email.GooglePageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;

public class ExistEmailTest extends BaseTest {
	RegisterPageModel registerPageModel;
	AffiliateRegisterPageModel affiliateRegisterPageModel;
	GooglePageModel googlePageModel;
	DashboardPageModel dashboardPageModel;
	EmailVarificationPageModel emailVarificationPageModel;
	List<ExistEmailCheckIdDto> existEmailCheckIdDtos;

	class Vecto {
		ExistEmailDto existEmailDto;
		ExistEmailCheckIdDto existEmailCheckIdDto;

		public Vecto(ExistEmailDto existEmailDto, ExistEmailCheckIdDto existEmailCheckIdDto) {
			this.existEmailDto = existEmailDto;
			this.existEmailCheckIdDto = existEmailCheckIdDto;
		}
	}

	@DataProvider(name = "existEmailDto")
	public Object[][] dataProviderExistEmailDto() {
		List<ExistEmailDto> existEmailDtos;
		// get data from excel
		existEmailDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.EXIST_EMAIL_DATA_PATH,
				Constant.NEW_EMAIL_DATA_SHEET, ExistEmailDto.excelTemplate(), ExistEmailDto.class);

		// covert data to dataProvider
		ExistEmailDto[][] existEmailDtoMatrix = new ExistEmailDto[existEmailDtos.size()][1];
		for (int i = 0; i < existEmailDtos.size(); i++) {
			existEmailDtoMatrix[i][0] = existEmailDtos.get((i) % existEmailDtos.size());

		}

		existEmailCheckIdDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.EXIST_EMAIL_DATA_PATH,
				Constant.CHECK_DATA_SHEET, ExistEmailCheckIdDto.excelTemplate(), ExistEmailCheckIdDto.class);

		return existEmailDtoMatrix;
	}

	@Test(dataProvider = "existEmailDto")
	public void precondition(ExistEmailDto existEmailDto) {
		//extentTest = extentReport.createTest("precondition");
		String newEmail = Constant.GMAIL_HEAD + (System.currentTimeMillis() / 10000) + Constant.GMAIL_TAIL;
		existEmailDto.setEmail(newEmail);
		
		affiliateRegisterPageModel = new AffiliateRegisterPageModel(driver);
		registerPageModel = new RegisterPageModel(driver);
		dashboardPageModel = new DashboardPageModel(driver);
		emailVarificationPageModel = new EmailVarificationPageModel(driver);
		
		if(existEmailDto.getTypeAccount().equals("Client")) {
			registerPageModel.load();
			registerPageModel.inputDataForExistEmail(existEmailDto);
			if (dashboardPageModel.isDisplayed(Constant.FIVESEC) || 
					emailVarificationPageModel.isDisplayed(Constant.FIVESEC)) {
				dashboardPageModel.logoutDashboard();
			}
		}
		else if(existEmailDto.getTypeAccount().contains("Partner")) {
			affiliateRegisterPageModel.load();
			affiliateRegisterPageModel.inputData(existEmailDto);
			if (dashboardPageModel.isDisplayed(Constant.FIVESEC) || 
					emailVarificationPageModel.isDisplayed(Constant.FIVESEC)) {
			
				dashboardPageModel.logoutDashboard();
			}
		}
		
		
		for (int index = 0; index < existEmailCheckIdDtos.size(); index++) {
			
			ExistEmailCheckIdDto emailCheckIdDto = existEmailCheckIdDtos.get(index);
			extentTest = extentReport.createTest(existEmailDto.getId() +" "+ emailCheckIdDto.getId()+
					" "+ emailCheckIdDto.getTitle());
			extentTest.info(emailCheckIdDto.getCountry()) ;
			extentTest.info(emailCheckIdDto.getEmail());
			emailCheckIdDto.setEmail(newEmail);
			boolean resultForEachCase = false; 
			if(index < 9) {
				extentTest.info("Client");
				registerPageModel.load();
				registerPageModel.inputDataForCheck(emailCheckIdDto);
				resultForEachCase = registerPageModel.checkExistEmail(
						emailCheckIdDto.getUniqueEmailValidation());
			}else {
				extentTest.info("Partner");
				affiliateRegisterPageModel.load();
				affiliateRegisterPageModel.inputDataForCheck(emailCheckIdDto);
				resultForEachCase  = affiliateRegisterPageModel.checkExistEmail(
						emailCheckIdDto.getUniqueEmailValidation());
			}
			if(resultForEachCase) {
				extentTest.pass("pass");
			}else {
				extentTest.fail("fail");
			}
			extentReport.flush();
			
			
			System.out.println(resultForEachCase);
		}
	}

}
