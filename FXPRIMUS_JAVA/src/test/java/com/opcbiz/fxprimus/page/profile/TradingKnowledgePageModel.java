package com.opcbiz.fxprimus.page.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.dto.pendCompleteRegis.QuestionnaireDto;
import com.opcbiz.fxprimus.page.BaseModel;
import com.opcbiz.fxprimus.utils.elements.Option;
import com.opcbiz.fxprimus.utils.elements.Select;

public class TradingKnowledgePageModel extends BaseModel {

	Select selectAnsKnowledgeGoogle;
	Option optionsAnsKnowledgeGoogle;

	// 10 | click | xpath=//span[contains(.,'Select your answer')] |
	@FindBy(xpath = "//span[contains(.,\'Select your answer\')]")
	WebElement optionSelect;
	// 11 | click | xpath=//mat-option[@id='mat-option-1']/span/span |
	@FindBy(xpath = "//span[contains(.,\'opposite \')] and @class='mat-option-text'")
	WebElement optionMove;
	// 12 | click | xpath=//mat-option[@id='mat-option-3']/span/span |
	@FindBy(xpath = "//span[contains(.,\'Only \')] and @class='mat-option-text'")
	WebElement optionOnly;
	// 13 | click | xpath=//span[contains(.,'Both of the above')] |
	@FindBy(xpath = "//span[contains(.,\'Both of the above\')] and @class='mat-option-text'")
	WebElement optionBoth;
	// 14 | click | xpath=//mat-option[@id='mat-option-10']/span/span |
	@FindBy(xpath = "//span[contains(.,\'Leverage\')] and @class='mat-option-text'")
	WebElement optionLeverage;
	// 15 | click | xpath=//span[contains(.,'USD 5,000')] |
	@FindBy(xpath = "//span[contains(.,\'USD 5,000\')] and @class='mat-option-text'")
	WebElement optionUsd5k;
	// 16 | click | xpath=//span[contains(.,'University / College')] |
	@FindBy(xpath = "//span[contains(.,\'University / College\')] and @class='mat-option-text'")
	WebElement optionUniversity;
	// 17 | click | xpath=//mat-option[@id='mat-option-22']/span/span |
	@FindBy(xpath = "//span[contains(.,\'shares, bonds, indices\')] and @class='mat-option-text'")
	WebElement optionIHaveTrade;
	// 18 | click | xpath=//div[@id='cdk-overlay-7']/div/mat-option[2] |
	@FindBy(xpath = "//span[contains(.,\'Monthly\')] and @class='mat-option-text'")
	WebElement optionMonthly;
	// 19 | click | xpath=//mat-option[@id='mat-option-30']/span/span |
	@FindBy(xpath = "//span[contains(.,\'USD 1,000 - USD 50,000\')] and @class='mat-option-text'")
	WebElement optionUsd1k50k;
	// 20 | click | xpath=//mat-option[@id='mat-option-33']/span/span |
	@FindBy(xpath = "//span[contains(.,\'Worked\')] and @class='mat-option-text'")
	WebElement optionWorked;

	@FindBy(id = "btnProceed")
	WebElement btnProceed;

	public TradingKnowledgePageModel(WebDriver webDriver) {
		super(webDriver);
		// selectAnsKnowledgeGoogle = new Select(webDriver, "", "Ans Know ledge
		// Google");
		// optionsAnsKnowledgeGoogle = new Option(webDriver);
	}

	public void clickBtnProceed() {
		if(onMacSafari) {
			clickJs(btnProceed);
		}
		else {
			click(btnProceed);
		}
		
		waitPageLoad("Financial Background");
	}

	public Select getSelectAnsKnowledgeGoogle() {
		selectAnsKnowledgeGoogle = new Select(webDriver, "(//mat-select)[1]", "Get Ans Know ledge Google");
		return selectAnsKnowledgeGoogle;
	}

	public Option getOptionAnsKnowledgeGoogle() {
		return optionsAnsKnowledgeGoogle;
	}

	public void setSelectAnsKnowledgeGoogle() {
		selectAnsKnowledgeGoogle.setByXpath("(//mat-select)[1]");
	}

	public void setOptionQuestionnaireDtoWithStringXpath(String xPath) {
		optionsAnsKnowledgeGoogle.setByXpath(xPath);
	}

	public void load() {
		webDriver.get("https://client-area-ui.staging.k8s.fxprimus.tech/en/profile/trading-knowledge");
		for (int i = 0; i < 22; i++) {
			if (webDriver.getTitle().contains("Trading Knowledge")) {
				return;
			} else {
				iwait(555);
			}
		}

	}

	public void fillData() {
		click(optionSelect);
		click(optionMove);
		click(optionOnly);
		click(optionBoth);
		click(optionLeverage);
		click(optionUsd5k);
		click(optionUniversity);
		click(optionIHaveTrade);
		click(optionMonthly);
		click(optionUsd1k50k);
		click(optionWorked);
	}

	public void fillData(QuestionnaireDto questionnaireDto) {
		click(optionSelect);
		// TRADING KNOWLEDGE
		selectAnyOption(questionnaireDto.getTradingKnowledgeQusGo());
		selectAnyOption(questionnaireDto.getTradingKnowledgeQusEx());
		selectAnyOption(questionnaireDto.getTradingKnowledgeQusCfd());
		selectAnyOption(questionnaireDto.getTradingKnowledgeQusLev());
		selectAnyOption(questionnaireDto.getTradingKnowledgeQusUsd());
		// TRADING EXPERIENCE
		selectAnyOption(questionnaireDto.getTradingExperienceQusEdu());
		selectAnyOption(questionnaireDto.getTradingExperienceQusExp());
		selectAnyOption(questionnaireDto.getTradingExperienceQusTra());
		selectAnyOption(questionnaireDto.getTradingExperienceQusTran());
		selectAnyOption(questionnaireDto.getTradingExperienceQusHave());
	}

	public void selectAnyOption(String contains) {
		WebElement elementOption = null;
		String xpath = "//span[contains(.,\'" + contains + "\') and @class='mat-option-text']";
		elementOption = webDriver.findElement(By.xpath(xpath));
		
		click(elementOption);
		for(int i=0;i<10;i++) {
			if(isElementPresent(xpath)) {
				clickJs(elementOption);
				iwait(200);
			}else {
				break;
			}
		}
	}
}
