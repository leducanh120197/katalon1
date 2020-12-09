package com.opcbiz.fxprimus.dto.pendCompleteRegis;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class QuestionnaireDto {
	String id;
	String title;
	String link;
	String tradingKnowledgeQusGo;
	String tradingKnowledgeQusEx;
	String tradingKnowledgeQusCfd;
	String tradingKnowledgeQusLev;
	String tradingKnowledgeQusUsd;
	String tradingExperienceQusEdu;
	String tradingExperienceQusExp;
	String tradingExperienceQusTra;
	String tradingExperienceQusTran;
	String tradingExperienceQusHave;
	String traProccedButtonValidation;
	String financialBackgroundQusPur;
	String financialBackgroundQusSta;
	String financialBackgroundQusInd;
	String financialBackgroundQusNetw;
	String financialBackgroundQusAnn;
	String financialBackgroundQusAmo;
	String financialBackgroundQusFun;
	String financialBackgroundQusWea;
	String financialBackgroundQusExp;
	String financialBackgroundQusAge;
	String financialBackgroundQusDeri;
	String finProccedButtonValidation;
	String dashboardIconValidation;
	String expected;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LINK", "link", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_KNOWLEDGE_QUS_GO", "tradingKnowledgeQusGo",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_KNOWLEDGE_QUS_EX", "tradingKnowledgeQusEx",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_KNOWLEDGE_QUS_CFD", "tradingKnowledgeQusCfd",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_KNOWLEDGE_QUS_LEV", "tradingKnowledgeQusLev",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_KNOWLEDGE_QUS_USD", "tradingKnowledgeQusUsd",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_EXPERIENCE_QUS_EDU", "tradingExperienceQusEdu",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_EXPERIENCE_QUS_EXP", "tradingExperienceQusExp",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_EXPERIENCE_QUS_TRA", "tradingExperienceQusTra",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_EXPERIENCE_QUS_TRAN", "tradingExperienceQusTran",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRADING_EXPERIENCE_QUS_HAVE", "tradingExperienceQusHave",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRA_PROCCED_BUTTON_VALIDATION", "traProccedButtonValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_PUR", "financialBackgroundQusPur",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_STA", "financialBackgroundQusSta",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_IND", "financialBackgroundQusInd",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_NETW", "financialBackgroundQusNetw",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_ANN", "financialBackgroundQusAnn",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_AMO", "financialBackgroundQusAmo",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_FUN", "financialBackgroundQusFun",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_WEA", "financialBackgroundQusWea",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_EXP", "financialBackgroundQusExp",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_AGE", "financialBackgroundQusAge",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FINANCIAL_BACKGROUND_QUS_DERI", "financialBackgroundQusDeri",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FIN_PROCCED_BUTTON_VALIDATION", "finProccedButtonValidation",
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

	public String getTradingKnowledgeQusGo() {
		return tradingKnowledgeQusGo;
	}

	public void setTradingKnowledgeQusGo(String tradingKnowledgeQusGo) {
		this.tradingKnowledgeQusGo = tradingKnowledgeQusGo;
	}

	public String getTradingKnowledgeQusEx() {
		return tradingKnowledgeQusEx;
	}

	public void setTradingKnowledgeQusEx(String tradingKnowledgeQusEx) {
		this.tradingKnowledgeQusEx = tradingKnowledgeQusEx;
	}

	public String getTradingKnowledgeQusCfd() {
		return tradingKnowledgeQusCfd;
	}

	public void setTradingKnowledgeQusCfd(String tradingKnowledgeQusCfd) {
		this.tradingKnowledgeQusCfd = tradingKnowledgeQusCfd;
	}

	public String getTradingKnowledgeQusLev() {
		return tradingKnowledgeQusLev;
	}

	public void setTradingKnowledgeQusLev(String tradingKnowledgeQusLev) {
		this.tradingKnowledgeQusLev = tradingKnowledgeQusLev;
	}

	public String getTradingKnowledgeQusUsd() {
		return tradingKnowledgeQusUsd;
	}

	public void setTradingKnowledgeQusUsd(String tradingKnowledgeQusUsd) {
		this.tradingKnowledgeQusUsd = tradingKnowledgeQusUsd;
	}

	public String getTradingExperienceQusEdu() {
		return tradingExperienceQusEdu;
	}

	public void setTradingExperienceQusEdu(String tradingExperienceQusEdu) {
		this.tradingExperienceQusEdu = tradingExperienceQusEdu;
	}

	public String getTradingExperienceQusExp() {
		return tradingExperienceQusExp;
	}

	public void setTradingExperienceQusExp(String tradingExperienceQusExp) {
		this.tradingExperienceQusExp = tradingExperienceQusExp;
	}

	public String getTradingExperienceQusTra() {
		return tradingExperienceQusTra;
	}

	public void setTradingExperienceQusTra(String tradingExperienceQusTra) {
		this.tradingExperienceQusTra = tradingExperienceQusTra;
	}

	public String getTradingExperienceQusTran() {
		return tradingExperienceQusTran;
	}

	public void setTradingExperienceQusTran(String tradingExperienceQusTran) {
		this.tradingExperienceQusTran = tradingExperienceQusTran;
	}

	public String getTradingExperienceQusHave() {
		return tradingExperienceQusHave;
	}

	public void setTradingExperienceQusHave(String tradingExperienceQusHave) {
		this.tradingExperienceQusHave = tradingExperienceQusHave;
	}

	public String getTraProccedButtonValidation() {
		return traProccedButtonValidation;
	}

	public void setTraProccedButtonValidation(String traProccedButtonValidation) {
		this.traProccedButtonValidation = traProccedButtonValidation;
	}

	public String getFinancialBackgroundQusPur() {
		return financialBackgroundQusPur;
	}

	public void setFinancialBackgroundQusPur(String financialBackgroundQusPur) {
		this.financialBackgroundQusPur = financialBackgroundQusPur;
	}

	public String getFinancialBackgroundQusSta() {
		return financialBackgroundQusSta;
	}

	public void setFinancialBackgroundQusSta(String financialBackgroundQusSta) {
		this.financialBackgroundQusSta = financialBackgroundQusSta;
	}

	public String getFinancialBackgroundQusInd() {
		return financialBackgroundQusInd;
	}

	public void setFinancialBackgroundQusInd(String financialBackgroundQusInd) {
		this.financialBackgroundQusInd = financialBackgroundQusInd;
	}

	public String getFinancialBackgroundQusNetw() {
		return financialBackgroundQusNetw;
	}

	public void setFinancialBackgroundQusNetw(String financialBackgroundQusNetw) {
		this.financialBackgroundQusNetw = financialBackgroundQusNetw;
	}

	public String getFinancialBackgroundQusAnn() {
		return financialBackgroundQusAnn;
	}

	public void setFinancialBackgroundQusAnn(String financialBackgroundQusAnn) {
		this.financialBackgroundQusAnn = financialBackgroundQusAnn;
	}

	public String getFinancialBackgroundQusAmo() {
		return financialBackgroundQusAmo;
	}

	public void setFinancialBackgroundQusAmo(String financialBackgroundQusAmo) {
		this.financialBackgroundQusAmo = financialBackgroundQusAmo;
	}

	public String getFinancialBackgroundQusFun() {
		return financialBackgroundQusFun;
	}

	public void setFinancialBackgroundQusFun(String financialBackgroundQusFun) {
		this.financialBackgroundQusFun = financialBackgroundQusFun;
	}

	public String getFinancialBackgroundQusWea() {
		return financialBackgroundQusWea;
	}

	public void setFinancialBackgroundQusWea(String financialBackgroundQusWea) {
		this.financialBackgroundQusWea = financialBackgroundQusWea;
	}

	public String getFinancialBackgroundQusExp() {
		return financialBackgroundQusExp;
	}

	public void setFinancialBackgroundQusExp(String financialBackgroundQusExp) {
		this.financialBackgroundQusExp = financialBackgroundQusExp;
	}

	public String getFinancialBackgroundQusAge() {
		return financialBackgroundQusAge;
	}

	public void setFinancialBackgroundQusAge(String financialBackgroundQusAge) {
		this.financialBackgroundQusAge = financialBackgroundQusAge;
	}

	public String getFinancialBackgroundQusDeri() {
		return financialBackgroundQusDeri;
	}

	public void setFinancialBackgroundQusDeri(String financialBackgroundQusDeri) {
		this.financialBackgroundQusDeri = financialBackgroundQusDeri;
	}

	public String getFinProccedButtonValidation() {
		return finProccedButtonValidation;
	}

	public void setFinProccedButtonValidation(String finProccedButtonValidation) {
		this.finProccedButtonValidation = finProccedButtonValidation;
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

	public QuestionnaireDto() {
		super();
	}

	public QuestionnaireDto(String id, String title, String link, String tradingKnowledgeQusGo,
			String tradingKnowledgeQusEx, String tradingKnowledgeQusCfd, String tradingKnowledgeQusLev,
			String tradingKnowledgeQusUsd, String tradingExperienceQusEdu, String tradingExperienceQusExp,
			String tradingExperienceQusTra, String tradingExperienceQusTran, String tradingExperienceQusHave,
			String traProccedButtonValidation, String financialBackgroundQusPur, String financialBackgroundQusSta,
			String financialBackgroundQusInd, String financialBackgroundQusNetw, String financialBackgroundQusAnn,
			String financialBackgroundQusAmo, String financialBackgroundQusFun, String financialBackgroundQusWea,
			String financialBackgroundQusExp, String financialBackgroundQusAge, String financialBackgroundQusDeri,
			String finProccedButtonValidation, String dashboardIconValidation, String expected) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.tradingKnowledgeQusGo = tradingKnowledgeQusGo;
		this.tradingKnowledgeQusEx = tradingKnowledgeQusEx;
		this.tradingKnowledgeQusCfd = tradingKnowledgeQusCfd;
		this.tradingKnowledgeQusLev = tradingKnowledgeQusLev;
		this.tradingKnowledgeQusUsd = tradingKnowledgeQusUsd;
		this.tradingExperienceQusEdu = tradingExperienceQusEdu;
		this.tradingExperienceQusExp = tradingExperienceQusExp;
		this.tradingExperienceQusTra = tradingExperienceQusTra;
		this.tradingExperienceQusTran = tradingExperienceQusTran;
		this.tradingExperienceQusHave = tradingExperienceQusHave;
		this.traProccedButtonValidation = traProccedButtonValidation;
		this.financialBackgroundQusPur = financialBackgroundQusPur;
		this.financialBackgroundQusSta = financialBackgroundQusSta;
		this.financialBackgroundQusInd = financialBackgroundQusInd;
		this.financialBackgroundQusNetw = financialBackgroundQusNetw;
		this.financialBackgroundQusAnn = financialBackgroundQusAnn;
		this.financialBackgroundQusAmo = financialBackgroundQusAmo;
		this.financialBackgroundQusFun = financialBackgroundQusFun;
		this.financialBackgroundQusWea = financialBackgroundQusWea;
		this.financialBackgroundQusExp = financialBackgroundQusExp;
		this.financialBackgroundQusAge = financialBackgroundQusAge;
		this.financialBackgroundQusDeri = financialBackgroundQusDeri;
		this.finProccedButtonValidation = finProccedButtonValidation;
		this.dashboardIconValidation = dashboardIconValidation;
		this.expected = expected;
	}
}
