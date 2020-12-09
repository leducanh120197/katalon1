package com.opcbiz.fxprimus.page.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.pendCompleteRegis.QuestionnaireDto;
import com.opcbiz.fxprimus.page.BaseModel;

public class FinancialBackgroundPageModel extends BaseModel {

	@FindBy(xpath = "//span[contains(.,\'Select your answer\')]")
	WebElement optionSelect;

	@FindBy(id = "btnProceed")
	WebElement btnProceed;

	public void load() {
		webDriver.get("https://client-area-ui.staging.k8s.fxprimus.tech/en/profile/financial-background");
		waitPageLoad("Financial Background");
	}

	public void fillData(QuestionnaireDto questionnaireDto) {
		click(optionSelect);
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusPur());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusSta());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusInd());

		selectAnyOption(questionnaireDto.getFinancialBackgroundQusNetw());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusAnn());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusAmo());

		selectAnyOption(questionnaireDto.getFinancialBackgroundQusFun());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusWea());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusExp());
//		selectAnyOption(questionnaireDto.getFinancialBackgroundQusAge());	

		selectAnyOption(questionnaireDto.getFinancialBackgroundQusDeri());
	}

	public void fillDataIndividual(QuestionnaireDto questionnaireDto) {
		click(optionSelect);
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusPur());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusSta());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusInd());

		selectAnyOption(questionnaireDto.getFinancialBackgroundQusNetw());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusAnn());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusAmo());

		selectAnyOption(questionnaireDto.getFinancialBackgroundQusFun());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusWea());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusExp());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusAge());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusDeri());
	}

	public void fillDataCorporate(QuestionnaireDto questionnaireDto) {
		click(optionSelect);
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusPur());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusSta());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusInd());

		selectAnyOption(questionnaireDto.getFinancialBackgroundQusNetw());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusAnn());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusAmo());

		selectAnyOption(questionnaireDto.getFinancialBackgroundQusFun());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusWea());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusExp());

//		selectAnyOption(questionnaireDto.getFinancialBackgroundQusAge());
		selectAnyOption(questionnaireDto.getFinancialBackgroundQusDeri());
	}

	public void clickBtnProceed() {
		if(onMacSafari) {
			clickJs(btnProceed);
		}
		else {
			click(btnProceed);
		}
		
		waitPageLoad(Constant.DOCUMENTS);
	}

	public void selectAnyOption(String contains) {
		WebElement elementOption = null;
		String xpath = "//span[contains(.,\'" + contains + "\') and @class='mat-option-text']";
		System.out.println(xpath);
		// xpath = "//span[text()='"+contains+"
		// ']/../../span[@class='mat-option-text']";
		elementOption = webDriver.findElement(By.xpath(xpath));
		try {
			click(elementOption);
			if(isElementPresent(xpath)) {
				iwait(200);
				clickJs(elementOption);
			}
		} catch (Exception e) {
			log("this option is disappeared");
			log(e.getMessage());
		}

		iwait(333);
	}

	public FinancialBackgroundPageModel(WebDriver webDriver) {
		super(webDriver);
	}

}
//span[contains(.,'Credit / Debit card') and @class='mat-option-text']