package com.opcbiz.fxprimus.dto.pendCompleteRegis;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class AccountDetailDto {
	String id;
	String title;
	String link;
	String accountType;
	String leverage;
	String depositCurrency;
	String proccedTaButton;
	String buttonProceedValidation;
	String dashboardIconValidation;
	String expected;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LINK", "link", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ACCOUNT_TYPE", "accountType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LEVERAGE", "leverage", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("DEPOSIT_CURRENCY", "depositCurrency", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("PROCCED_TA_BUTTON", "proccedTaButton", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("BUTTON_PROCEED_VALIDATION", "buttonProceedValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("DASHBOARD_ICON_VALIDATION", "dashboardIconValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EXPECTED", "expected", ExcelFieldDto.DataType.STRING, "STRING"));

		return excelFieldDtoList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getLeverage() {
		return leverage;
	}

	public void setLeverage(String leverage) {
		this.leverage = leverage;
	}

	public String getDepositCurrency() {
		return depositCurrency;
	}

	public void setDepositCurrency(String depositCurrency) {
		this.depositCurrency = depositCurrency;
	}

	public String getProccedTaButton() {
		return proccedTaButton;
	}

	public void setProccedTaButton(String proccedTaButton) {
		this.proccedTaButton = proccedTaButton;
	}

	public String getButtonProceedValidation() {
		return buttonProceedValidation;
	}

	public void setButtonProceedValidation(String buttonProceedValidation) {
		this.buttonProceedValidation = buttonProceedValidation;
	}

	public String getDashboardIconValidation() {
		return dashboardIconValidation;
	}

	public void setDashboardIconValidation(String dashboardIconValidation) {
		this.dashboardIconValidation = dashboardIconValidation;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public AccountDetailDto(String id, String title, String link, String accountType, String leverage,
			String depositCurrency, String proccedTaButton, String buttonProceedValidation,
			String dashboardIconValidation, String expected) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.accountType = accountType;
		this.leverage = leverage;
		this.depositCurrency = depositCurrency;
		this.proccedTaButton = proccedTaButton;
		this.buttonProceedValidation = buttonProceedValidation;
		this.dashboardIconValidation = dashboardIconValidation;
		this.expected = expected;
	}

	public AccountDetailDto() {
		super();
	}
}
