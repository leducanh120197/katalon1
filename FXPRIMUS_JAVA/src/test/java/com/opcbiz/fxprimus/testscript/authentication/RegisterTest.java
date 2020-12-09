package com.opcbiz.fxprimus.testscript.authentication;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.register.RegisterDto;
import com.opcbiz.fxprimus.dto.register.RegisterDtoFunction;
import com.opcbiz.fxprimus.page.authentication.EmailVarificationPageModel;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.email.GooglePageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.webdriver.WebDriverFactory;

public class RegisterTest extends BaseTest {

	RegisterPageModel registerPageModel;
	GooglePageModel googlePageModel;
	EmailVarificationPageModel emailVarificationPageModel;
	DashboardPageModel dashboardPageModel;
	LoginPageModel loginPageModel;

	@BeforeClass
	void beforeClass() {
		driver = WebDriverFactory.getDriver(Constant.CHROME);
		registerPageModel = new RegisterPageModel(driver);
		loginPageModel = new LoginPageModel(driver);
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@DataProvider(name = "registerDto")
	public Object[][] dataProviderregisterDto() {
		List<RegisterDto> registerDtoList;
		// get data from excel
		registerDtoList = ExcelUtils.getInstance().getDataFromExcel(Constant.REGISTER_TEST_DATA_PATH,
				Constant.REGISTER_TEST_DATA_SHEET, RegisterDto.excelTemplate(), RegisterDto.class);

		// covert data to dataProvider
		RegisterDto[][] registerDtoMatrix = new RegisterDto[registerDtoList.size()][1];
		for (int i = 0; i < registerDtoList.size(); i++) {
			registerDtoMatrix[i][0] = registerDtoList.get((i + 0) % registerDtoList.size());
		}
		// registerDtoMatrix[0][0] = registerDtoList.get(3);
		return registerDtoMatrix;

	}
	@Test(enabled = true, priority = 1)
	public void openRegisterPage() {
		loginPageModel.load();
		loginPageModel.clickOpenAccount();
	}

	@Test(dataProvider = "registerDto", enabled = true, priority = 2)
	public void validateRegister(RegisterDto registerDto) throws InterruptedException {
		extentTest = extentReport.createTest(registerDto.getId() + " " + registerDto.getTitle());
		extentTest.info(registerDto.toString());
		log(registerDto.getId() + registerDto.getTitle());
		registerPageModel.load();
		// Input Data
		registerPageModel.inputData(registerDto);
		// Validate
		boolean isValidateRegister = registerPageModel.isValid(registerDto);
		if (isValidateRegister) {
			extentTest.pass("passed");
		} else {
			extentTest.fail("fail");
		}
		extentReport.flush();
//		driver.quit();
		// Assert.assertTrue(isValidateRegister);

	}
	
	 
	@DataProvider(name = "registerDtoFunction")
	public Object[][] dataProviderRegisterDtoFunction() throws ClassNotFoundException {
		List<RegisterDtoFunction> registerDtoList;
		registerDtoList = ExcelUtils.getInstance().getDataFromExcel(Constant.REGISTER_TEST_DATA_PATH,
				Constant.REGISTER_TEST_DATA_FUNCTION_SHEET, RegisterDtoFunction.excelTemplate(), RegisterDtoFunction.class);

		RegisterDtoFunction[][] registerDtoMatrix = new RegisterDtoFunction[1][1];
		 registerDtoMatrix[0][0] = registerDtoList.get(3);
		return registerDtoMatrix;
	}

	@Test(dataProvider = "registerDtoFunction", enabled = true, priority = 3)
	public void registerFunction(RegisterDtoFunction registerDto) {
		extentTest = extentReport.createTest(registerDto.getId()+" "+registerDto.getTitle());
		extentTest.info(registerDto.toString());
		registerPageModel = new RegisterPageModel(driver); 
		registerPageModel.inputData(registerDto);
		
		googlePageModel = new GooglePageModel(driver);
		this.driver.get(UrlConstant.GMAIL_PAGE);
		boolean verifySuccess = googlePageModel.verifyInEmail();
		if(!verifySuccess) {
			extentTest.fail("fail");
			Assert.assertTrue(false, "verify unsuccessfull");
		}
		
		
		emailVarificationPageModel = new EmailVarificationPageModel(driver);
		if(emailVarificationPageModel.isDisplayed())
			emailVarificationPageModel.action();
		else {
			extentTest.fail("fail");			
			Assert.assertTrue(false, "don't show varification page");
		}
		
		dashboardPageModel = new DashboardPageModel(driver);
		
		extentTest.pass("passed");
		Assert.assertTrue(dashboardPageModel.isDisplayed());
		
	}
	
	
	//2 cases
	
}
