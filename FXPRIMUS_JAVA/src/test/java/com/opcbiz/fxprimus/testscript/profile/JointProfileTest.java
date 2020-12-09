package com.opcbiz.fxprimus.testscript.profile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.OpcDto;
import com.opcbiz.fxprimus.dto.register.JointPersonDetailDto;
import com.opcbiz.fxprimus.dto.register.RegisterDto;
import com.opcbiz.fxprimus.page.authentication.EmailVarificationPageModel;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.page.profile.PersonalDetailsJointPageModel;
import com.opcbiz.fxprimus.page.profile.TradingAccountPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.utils.ReportUtil;
import com.opcbiz.fxprimus.webdriver.WebDriverFactory;

public class JointProfileTest extends BaseTest {
	
	private RegisterPageModel registerPageModel;
	private EmailVarificationPageModel emailVarificationPageModel;
	private DashboardPageModel dashboardPageModel;
	private PersonalDetailsJointPageModel personalDetailsJointPageModel;
	private LoginPageModel loginPageModel;
	private TradingAccountPageModel tradingAccountPageModel;

	@BeforeClass
	void beforeClass() {
//		ExcelUtils.getInstance().convertToCsv(Constant.MA_225_JOINT_DATA_PATH, Constant.CSV);
		driver = WebDriverFactory.getDriver(Constant.CHROME_MAC);

//		driver = WebDriverFactory.getDriver(Constant.FIREFOX);
//		driver = WebDriverFactory.getDriver(Constant.EDGE);	
		registerPageModel = new RegisterPageModel(this.driver);
		
		emailVarificationPageModel = new EmailVarificationPageModel(driver);
		dashboardPageModel = new DashboardPageModel(driver);
		personalDetailsJointPageModel = new PersonalDetailsJointPageModel(driver);
		loginPageModel = new LoginPageModel(driver);
		tradingAccountPageModel = new TradingAccountPageModel(driver);
		
		
	}
	
	
	
	
	@DataProvider(name = "opc")
	public Object[][] dataProviderOpc() {
		
		String[] sheetNames = { 
//				Constant.FIRST_NAME,
//				Constant.LAST_NAME,
//				Constant.EMAIL,
//				Constant.ADDRESS,
//				Constant.CITY_TOWN,
//				Constant.ZIP_POSTALCODE,
//				Constant.STATE,
//				Constant.DATE_OF_BIRTH, 
//				Constant.GENDER,
//				Constant.PHONE_NUMBER,
//				Constant.QUESTION_POLITICALLY_ACC2,
//				Constant.QUESTION_US_CITIZENSHIP_ACC2,
				Constant.COUNTRY,
				Constant.LANGUAGE,
				};
		int totalSize = 0;
		List<List<OpcDto>> opcDtoMatrix = new ArrayList<List<OpcDto>>();
		for (String sheetName : sheetNames) {
			List<OpcDto> opcDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_JOINT_DATA_PATH,
					sheetName,OpcDto.excelTemplate(),OpcDto.class);
			
			for (OpcDto opcDto : opcDtos) {
				opcDto.setSheetName(sheetName);
			}
			
			opcDtoMatrix.add(opcDtos);
			totalSize += opcDtos.size();
		}
		OpcDto[][] dtoMatrix = new OpcDto[totalSize][1];
		int iDtoMatrix = 0;
		
		Set<String> s = new HashSet<String>();
		for (List<OpcDto> iOpcDtos : opcDtoMatrix) {
			for (OpcDto iOpcDto : iOpcDtos) {
				
				s.add(iOpcDto.getValidationType());
				dtoMatrix[iDtoMatrix][0] = iOpcDto;
				iDtoMatrix++;
			}
		}
		for (String string : s) {
			System.out.println(string);
		}
		
			
		return dtoMatrix;
	}
	@Test(priority = 1
//			, enabled = false
			)
	@Parameters("pass")
	public void loginAndGoToPersonal(
			String pass
			) {
		this.pass = pass;
		com.opcbiz.fxprimus.dto.register.RegisterDto registerDto = com.opcbiz.fxprimus.dto.register.RegisterDto
				.getExampleJointCy();
//		registerPageModel.load();
		loginPageModel.load();
		loginPageModel.clickOpenAccount();
		registerPageModel.inputDataAndRegister(registerDto);
		loginPageModel.load();
		//loginPageModel.login(registerDto.getEmail(), "Testauto01@");
		personalDetailsJointPageModel.setExtentTest(extentTest);
		dashboardPageModel.load();
		dashboardPageModel.setButtonPersonalDetails();
	}
	
	@Test(priority = 2
			, dataProvider = "opc"
//			, enabled = false
			)
	public void test(OpcDto opcDto) {

		if(xaviReturn(opcDto.getId())) {
			//run
		}else {
			return;
		}
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));
		personalDetailsJointPageModel.setExtentTest(extentTest);
		boolean result = personalDetailsJointPageModel.
				validateJointField(opcDto);
		ReportUtil.log(extentTest, result);
		extentReport.flush();
	}
	
	@DataProvider(name = "buttonProceed")
	public Object[][] buttonProceed() {
		List<JointPersonDetailDto> jointPersonDetailDtos = ExcelUtils.getInstance().getDataFromExcel(
				Constant.MA_225_JOINT_DATA_PATH, Constant.BUTTON_PROCEED,
				JointPersonDetailDto.excelTemplate(), JointPersonDetailDto.class);

		JointPersonDetailDto[][] jointPersonDetailDtoMatrix = new JointPersonDetailDto[jointPersonDetailDtos.size()][1];
		for (int i = 0; i < jointPersonDetailDtos.size(); i++) {
			jointPersonDetailDtoMatrix[i][0] = jointPersonDetailDtos.get(i);
		}
		System.out.println();
		return jointPersonDetailDtoMatrix;

	}
	@Test(priority = 3
			, dataProvider = "buttonProceed"
			, enabled = false
			)
	public void testButtonProoceed(JointPersonDetailDto jointPersonDetailDto) {
//		if(xaviReturn(jointPersonDetailDto.getId())) {
//			//run
//		}else {
//			return;
//		}
		
		extentTest = extentReport
				.createTest(jointPersonDetailDto.getId() + " " + jointPersonDetailDto.getTitle());
		personalDetailsJointPageModel.setExtentTest(extentTest);
		 
		try {
			boolean result = personalDetailsJointPageModel.validateButtonProceed(jointPersonDetailDto);
			ReportUtil.log(extentTest, result);
		} catch (Exception e) {
			ReportUtil.log(extentTest, false);
			e.printStackTrace();
		}
		extentReport.flush();
	}
	@Test(priority = 4
			,enabled = false
			)
	public void afterTestButtonProoceed() {
		dashboardPageModel.logoutDashboard();
	}
	@Test(priority = 5
			, dataProvider = "buttonProceed"
			, enabled = false
			)
	public void testButtonProceedFunction(JointPersonDetailDto jointPersonDetailDto) {
//		if(xaviReturn(jointPersonDetailDto.getId())) {
//			//run
//		}else {
//			return;
//		}
		if(!jointPersonDetailDto.getButtonProceedValidation().equals("active") ) {
			return;
		}
		extentTest = extentReport
				.createTest(jointPersonDetailDto.getId() + " " + jointPersonDetailDto.getTitle() + " active");
		loginPageModel.load();
		loginPageModel.clickOpenAccount();
	 
//		registerPageModel.load();
		//com.opcbiz.fxprimus.dto.register.RegisterDto.getExampleJointCy()
		registerPageModel.inputDataAndRegister(RegisterDto.getExampleJointCy());
		
		if(!emailVarificationPageModel.isDisplayed(Constant.FIFTEENS)) {
			return;
		}
		personalDetailsJointPageModel.setExtentTest(extentTest);
		dashboardPageModel.load();
		dashboardPageModel.setButtonPersonalDetails();
		personalDetailsJointPageModel.validateButtonProceed(jointPersonDetailDto);
		personalDetailsJointPageModel.setButtonSubmit();
		boolean result = tradingAccountPageModel.isDisplayed(Constant.FIFTEENS);
		ReportUtil.log(extentTest, result);
		extentReport.flush();
		dashboardPageModel.logoutDashboard();
	}
	
	//@Test
	public void testt() {
		
		loginPageModel.load();
		loginPageModel.login("qa_automation+1592534851754@fxprimus.tech", "Testauto01@");
		personalDetailsJointPageModel.setExtentTest(extentTest);
		dashboardPageModel.load();
		dashboardPageModel.setButtonPersonalDetails();
		String xpath = "//*[@formcontrolname='politicallyExposed']/mat-radio-button[1]/label";
		WebElement i = driver.findElement(By.xpath(xpath+""));
		dashboardPageModel.click(i);
		dashboardPageModel.clickJs(i);
		
		
	}
	
}
