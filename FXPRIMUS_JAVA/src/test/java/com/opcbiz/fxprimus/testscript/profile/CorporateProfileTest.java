package com.opcbiz.fxprimus.testscript.profile;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.OpcDto;
import com.opcbiz.fxprimus.dto.register.CorpPersonDetailDto;
import com.opcbiz.fxprimus.dto.register.RegisterDto;
import com.opcbiz.fxprimus.page.BaseModel;
import com.opcbiz.fxprimus.page.authentication.EmailVarificationPageModel;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.page.profile.PersonalDetailsCorporationPageModel;
import com.opcbiz.fxprimus.page.profile.PersonalDetailsPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.utils.ReportUtil;
import com.opcbiz.fxprimus.webdriver.WebDriverFactory;

public class CorporateProfileTest extends BaseTest {

	private LoginPageModel loginPageModel;
	private PersonalDetailsPageModel personalDetailsPageModel;
	private DashboardPageModel dashboardPageModel;
	private RegisterPageModel registerPageModel;
	private EmailVarificationPageModel emailVarificationPageModel;
	String browser;

	@Test(priority = 1
//			,enabled = false
			)
	@Parameters("pass")
	public void precondition(//) {
			String pass) {
				this.pass = pass;
		browser = Constant.SAFARI_MAC;
		browser = Constant.CHROME_MAC;

		driver = WebDriverFactory.getDriver(browser);
		loginPageModel = new LoginPageModel(driver);
		dashboardPageModel = new DashboardPageModel(driver);
		emailVarificationPageModel = new EmailVarificationPageModel(driver);
		registerPageModel = new RegisterPageModel(driver);


		RegisterDto registerDtoCor = RegisterDto.getExampleCorpCy();
		registerPageModel.load();
		registerPageModel.inputDataAndRegister(registerDtoCor);
//		dashboardPageModel.logoutDashboard();//		//prepareNewAccount();
//		loginPageModel.load();//		loginPageModel.login(registerDtoCor.getEmail(), "Testauto01@");
		emailVarificationPageModel.isDisplayed(Constant.FIFTEENS);
		dashboardPageModel.load();
		dashboardPageModel.isDisplayed();
		dashboardPageModel.setButtonPersonalDetails();
	}



	@DataProvider(name = "opc")
	public Object[][] dataProviderOpc() {
		String[] sheetNames = {
				Constant.COMPANY_NAME,
				Constant.ADDRESS,
				Constant.CITY,
				Constant.ZIP_POSTALCODE,
				Constant.COUNTRY,
				Constant.TOTAL_NUMBER_OF_DIRECTORS,
				Constant.TOTAL_NUMBER_OF_SHAREHOLDERS,
				Constant.LICENCES_YOU_HAVE_OBTAINED,
				Constant.BACKGROUND_EXPERIENCE,
				};
		int totalSize = 0;
		List<List<OpcDto>> opcDtoMatrix = new ArrayList<List<OpcDto>>();
		for (String sheetName : sheetNames) {
			List<OpcDto> opcDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.MA_225_CORPORATE_DATA_PATH,
					sheetName,OpcDto.excelTemplate(),OpcDto.class);

			for (OpcDto opcDto : opcDtos) {
				opcDto.setSheetName(sheetName);
			}

			opcDtoMatrix.add(opcDtos);
			totalSize += opcDtos.size();
		}
		OpcDto[][] dtoMatrix = new OpcDto[totalSize][1];
		int iDtoMatrix = 0;
		for (List<OpcDto> iOpcDtos : opcDtoMatrix) {
			for (OpcDto iOpcDto : iOpcDtos) {
				dtoMatrix[iDtoMatrix][0] = iOpcDto;
				iDtoMatrix++;
			}
		}
		return dtoMatrix;
	}
	@Test(priority = 2, dataProvider = "opc"
//					, enabled = false
			)
	public void opc(OpcDto opcDto) {
		if(xaviReturn(opcDto.getId())) {
			//run
		}else {
			return;
		}
			


		System.out.println("at "+System.nanoTime()+" start opc");
		extentTest = extentReport
				.createTest(opcDto.getId() + " " + opcDto.getTitle().replace("[INPUT_DATA]", opcDto.getInputData()));
		personalDetailsPageModel = new PersonalDetailsPageModel(driver, extentTest);
		boolean result = personalDetailsPageModel.validateField(opcDto);
		ReportUtil.log(extentTest, result);
		extentReport.flush();
		System.out.println("at "+System.nanoTime()+" end opc");
	}

	@DataProvider(name = "buttonProceed")
	public Object[][] dataProviderButtonProceed() {
		List<CorpPersonDetailDto> corpPersonDetailDtos = ExcelUtils.getInstance().getDataFromExcel(
				Constant.MA_225_CORPORATE_DATA_PATH, Constant.BUTTON_PROCEED_CORPORATE,
				CorpPersonDetailDto.excelTemplate(), CorpPersonDetailDto.class);

		CorpPersonDetailDto[][] corpPersonDetailDtoMatrix = new CorpPersonDetailDto[corpPersonDetailDtos.size()][1];
		for (int i = 0; i < corpPersonDetailDtos.size(); i++) {
			corpPersonDetailDtoMatrix[i][0] = corpPersonDetailDtos.get( (i)% corpPersonDetailDtos.size() );

		}
		return corpPersonDetailDtoMatrix;

	}

	PersonalDetailsCorporationPageModel personalDetailsCorporationPageModel;

	 @Test(priority = 3, dataProvider = "buttonProceed"
//			 ,enabled = false
			 )
	public void buttonProceed(CorpPersonDetailDto corpPersonDetailDto) {
		if (xaviReturn(corpPersonDetailDto.getId())) {
			// run
		} else {
			return;
		}
		extentTest = extentReport.createTest(corpPersonDetailDto.getId() + " " + corpPersonDetailDto.getTitle());

		personalDetailsCorporationPageModel = new PersonalDetailsCorporationPageModel(driver, extentTest);
		personalDetailsCorporationPageModel.load();
		boolean result = personalDetailsCorporationPageModel.validateButtonProceed(corpPersonDetailDto);
		ReportUtil.log(extentTest, result);
		extentReport.flush();
	}
	@Test(priority = 4
//				,enabled = false
			)
	public void after() {
		driver.quit();
	}
	public void prepareNewAccount() {
		browser = Constant.CHROME_MAC;
		com.opcbiz.fxprimus.dto.register.RegisterDto registerDto = com.opcbiz.fxprimus.dto.register.RegisterDto
				.getExampleCorpCy();
		driver = WebDriverFactory.getDriver(browser);
		dashboardPageModel = new DashboardPageModel(driver);

		loginPageModel = new LoginPageModel(driver);
		loginPageModel.load();
//		loginPageModel.login("qa_automation+1589852901929@fxprimus.tech",
//				"Testauto01@");
//
//		EmailVarificationPageModel e = new EmailVarificationPageModel(driver);
//		if(!e.isDisplayed(Constant.FIFTEENS)) {
//			return;
//		}
//		dashboardPageModel.load();
//		driver.findElement(By.xpath("//app-sidebar//*[contains(text(),'Profile')]")).click();
//		driver.findElement(By.xpath("//app-sidebar//*[contains(text(),'Corporate Profile')]")).click();//app-sidebar//*[contains(text(),'')]

		loginPageModel.clickOpenAccount();

		registerPageModel = new RegisterPageModel(this.driver);
		registerPageModel.inputDataAndRegister(registerDto);

		EmailVarificationPageModel e = new EmailVarificationPageModel(driver);
		if(!e.isDisplayed(Constant.FIFTEENS)) {
			return;
		}

		personalDetailsPageModel = new PersonalDetailsPageModel(driver);

//		loginPageModel.load();
//		dashboardPageModel.setButtonPersonalDetails();

	}

	@Test(priority = 11, dataProvider = "buttonProceed"
//			, enabled = false
			)
	public void buttonProceedFunction(CorpPersonDetailDto corpPersonDetailDto) {
		if (xaviReturn(corpPersonDetailDto.getId())) {
			// run
		} else {
			return;
		}
		if(corpPersonDetailDto.getButtonProceedValidation().equals("active")) {
//			if(!corpPersonDetailDto.getId().equals("CO_PR_020")) {
//				return;
//			}
			prepareNewAccount();
			extentTest = extentReport.createTest(corpPersonDetailDto.getId() + " " + corpPersonDetailDto.getTitle());
			personalDetailsCorporationPageModel = new PersonalDetailsCorporationPageModel(driver, extentTest);
			personalDetailsCorporationPageModel.load();
			boolean result = personalDetailsCorporationPageModel.validateButtonProceedFunction(corpPersonDetailDto);

			ReportUtil.log(extentTest,result);
			extentReport.flush();
			if(corpPersonDetailDto.getId().equals("CO_PR_020")) {
				corporateProfileSubmitButton();
			}
			driver.quit();
		}
	}



	// test
	public void corporateProfileSubmitButton() {
		// select director

		extentTest = extentReport.createTest("Check SUBMIT_BUTTON_VALIDATION with DIRECTOR1");

		driver.findElement(By.xpath("//mat-expansion-panel-header//mat-panel-title/span[contains(text(),'DIRECTOR')]"
				)).click();

		// 20 | click | id=firstName |
		driver.findElement(By.id("firstName")).click();
		// 23 | type | id=firstName | ab
		driver.findElement(By.id("firstName")).sendKeys("ab");
		// 24 | click | id=lastName |
		driver.findElement(By.id("lastName")).click();
		// 27 | type | id=lastName | cd
		driver.findElement(By.id("lastName")).sendKeys("cd");

		driver.findElement(By.xpath("//button[@aria-label='Open calendar']")).click();
		driver.findElement(By.xpath("//mat-month-view//tr[1]/td[2]/div")).click();

		driver.findElement(By.id("gender")).click();
		driver.findElement(By.xpath("//mat-option/span[1]/..")).click();

		driver.findElement(By.id("country")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Afghanistan')]")).click();

		System.out.println("43 | click | id=city |");
		driver.findElement(By.id("city")).click();
		System.out.println("44 | type | id=city | ef");
		driver.findElement(By.id("city")).sendKeys("ef");
		System.out.println("46 | type | id=state | gh");
		driver.findElement(By.id("state")).sendKeys("gh");
		System.out.println("47 | click | id=address |");
		driver.findElement(By.id("address")).click();
		System.out.println("48 | type | id=address | ij");
		driver.findElement(By.id("address")).sendKeys("ij");
		System.out.println("49 | click | id=zip |");
		driver.findElement(By.id("zip")).click();
		System.out.println("50 | type | id=zip | kl");
		driver.findElement(By.id("zip")).sendKeys("kl");
		System.out.println("51 | click | id=phoneNumber |");
		driver.findElement(By.id("phoneNumber")).click();
		System.out.println("52 | type | id=phoneNumber | 34598542");
		driver.findElement(By.id("phoneNumber")).sendKeys("34598542");
		System.out.println("53 | click | id=email |");
	    driver.findElement(By.id("email")).click();
		System.out.println("54 | type | id=email | abc@abc.abc");
	    driver.findElement(By.id("email")).sendKeys("abc@abc.abc");
		System.out.println("55 | click | id=license | ");
	    driver.findElement(By.id("license")).click();
		System.out.println("56 | type | id=license | mn");
	    driver.findElement(By.id("license")).sendKeys("mn");
		System.out.println("57 | click | id=background | ");
	    driver.findElement(By.id("background")).click();
		System.out.println("58 | type | id=background | op");
	    driver.findElement(By.id("background")).sendKeys("op");

	    driver.findElement(By.xpath("//app-director//button[@type='submit']")).click();
	    extentReport.flush();
	    BaseModel.iwait(5000);
//	    WebElement we = driver.findElement(By.xpath("(//app-director-documents//input)[1]"));
//	    personalDetailsCorporationPageModel.removeAttributeByJs(we,"hidden");

//	    driver.findElement(By.xpath("(//app-director-documents//input)[1]")).sendKeys("D:/logo.png");
//	    driver.findElement(By.xpath("//app-director-documents//*[(text()='Add ID Front')]/../.."
//	    		)).click();
//	    driver.findElement(By.xpath("(//app-director-documents//input)[1]")).sendKeys("D:/logo.png");
//	    RobotUtils.altF4();
//
//	    we  = driver.findElement(By.xpath("(//app-director-documents//*[contains(text(),'UPLOAD FILES')])[1]"));
//	    personalDetailsCorporationPageModel.removeAttributeByJs(we,"disabled");
//	    we.click();
//
//	    driver.findElement(By.xpath("//app-director-documents//*[(text()='Add ID Back ')]/../.."
//	    		)).click();
//	 	we = driver.findElement(By.xpath("(//app-director-documents//input)[2]"));
//	    personalDetailsCorporationPageModel.removeAttributeByJs(we,"hidden");
//    	driver.findElement(By.xpath("(//app-director-documents//input)[2]"
//	    		)).sendKeys("D:/logo.png");
//    	RobotUtils.altF4();
//
//	    driver.findElement(By.xpath("(//app-director-documents//*[contains(text(),'UPLOAD FILES')])[2]"
//	    		)).click();
//
//	    driver.findElement(By.xpath("//app-director-documents//*[(text()='Add Proof of Residence Front ')]/../.."
//	    		)).click();
//	    we = driver.findElement(By.xpath("(//app-director-documents//input)[3]"));
//	    personalDetailsCorporationPageModel.removeAttributeByJs(we,"hidden");
//	    driver.findElement(By.xpath("(//app-director-documents//input)[3]"
//	    		)).sendKeys("D:/logo.png");
//	    RobotUtils.altF4();
//
//	    driver.findElement(By.xpath("(//app-director-documents//*[contains(text(),'UPLOAD FILES')])[3]"
//	    		)).click();
//
//	    driver.findElement(By.xpath("//app-director-documents//*[(text()='Add Proof of Residence Back ')]/../.."
//	    		)).click();
//	    we = driver.findElement(By.xpath("(//app-director-documents//input)[4]"));
//	    personalDetailsCorporationPageModel.removeAttributeByJs(we,"hidden");
//
//	    driver.findElement(By.xpath("(//app-director-documents//input)[4]"
//	    		)).sendKeys("D:/logo.png");
//	    RobotUtils.altF4();
//
//	    driver.findElement(By.xpath("(//app-director-documents//*[contains(text(),'UPLOAD FILES')])[4]"
//	    		)).click();

	    extentTest = extentReport.createTest("Check SUBMIT_BUTTON_VALIDATION with SHAREHOLDER1");
		driver.findElement(
		By.xpath("//mat-expansion-panel-header//mat-panel-title/span[contains(text(),'SHAREHOLDER')]")).click();


		// 20 | click | id=firstName |
 		driver.findElement(By.id("firstName")).click();
		// 23 | type | id=firstName | ab
		driver.findElement(By.id("firstName")).sendKeys("ab");
		// 24 | click | id=lastName |
		driver.findElement(By.id("lastName")).click();
		// 27 | type | id=lastName | cd
		driver.findElement(By.id("lastName")).sendKeys("cd");

		driver.findElement(By.xpath("//app-share-holder//button[@aria-label='Open calendar']")).click();
		driver.findElement(By.xpath("//mat-month-view//tr[1]/td[2]/div")).click();

		driver.findElement(By.xpath("//app-share-holder//*[@id='gender']")).click();
		driver.findElement(By.xpath("//mat-option/span[1]/..")).click();

		driver.findElement(By.xpath("//app-share-holder//*[@id='country']")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Afghanistan')])[2]")).click();

		System.out.println("43 | click | id=city |");
		driver.findElement(By.xpath("//app-share-holder//*[@id='city']")).click();
		System.out.println("44 | type | id=city | ef");
		driver.findElement(By.xpath("//app-share-holder//*[@id='city']")).sendKeys("ef");
		System.out.println("46 | type | id=state | gh");
		driver.findElement(By.xpath("//app-share-holder//*[@id='state']")).sendKeys("gh");
		System.out.println("47 | click | id=address |");
		driver.findElement(By.xpath("//app-share-holder//*[@id='address']")).click();
		System.out.println("48 | type | id=address | ij");
		driver.findElement(By.xpath("//app-share-holder//*[@id='address']")).sendKeys("ij");
		System.out.println("49 | click | id=zip |");
		driver.findElement(By.xpath("//app-share-holder//*[@id='zip']")).click();
		System.out.println("50 | type | id=zip | kl");
		driver.findElement(By.xpath("//app-share-holder//*[@id='zip']")).sendKeys("kl");
		System.out.println("51 | click | id=phoneNumber |");
		driver.findElement(By.xpath("//app-share-holder//*[@id='phoneNumber']")).click();
		System.out.println("52 | type | id=phoneNumber | 34598542");
		driver.findElement(By.xpath("//app-share-holder//*[@id='phoneNumber']")).sendKeys("34598542");
		System.out.println("53 | click | id=email |");
		driver.findElement(By.xpath("//app-share-holder//*[@id='email']")).click();
		System.out.println("54 | type | id=email | abc@abc.abc");
		driver.findElement(By.xpath("//app-share-holder//*[@id='email']")).sendKeys("abc@abc.abc");

		driver.findElement(By.xpath("//app-share-holder//button[@type='submit']")).click();
		extentTest.info("pass");
		extentReport.flush();

	}

}
