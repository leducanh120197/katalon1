package com.opcbiz.fxprimus.dto.api;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class QA24TestDataDto {
	String id;
	String title;
	String key;
	String currency;
	String spread;
	String memberType;
	String regulator;
	String country;
	String referral;
	String termsAda;
	String userId;
	String swap;
	String promo;
	String adaAgreement;
	String electiveProfessional;
	String termination;
	String TerminationServer;
	String stp;
	String vip;
	String expect;

	// new update
	String ibAccess;
	String fiveday;
	String server;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("KEY", "key", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CURRENCY", "currency", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("SPREAD", "spread", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("MEMBER_TYPE", "memberType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("REGULATOR", "regulator", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COUNTRY", "country", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("REFERRAL", "referral", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TERMS_ADA", "termsAda", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("USER_ID", "userId", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("SWAP", "swap", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PROMO", "promo", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ADA_AGREEMENT", "adaAgreement", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ELECTIVE_PROFESSIONAL", "electiveProfessional",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TERMINATION", "termination", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("TERMINATION_SERVER", "TerminationServer", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("STP", "stp", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("VIP", "vip", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EXPECT", "expect", ExcelFieldDto.DataType.STRING, "STRING"));
		
		//new update
		excelFieldDtoList.add(new ExcelFieldDto("IB_ACCESS", "ibAccess", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FIVEDAY", "fiveday", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("SERVER", "server", ExcelFieldDto.DataType.STRING, "STRING"));
		
		return excelFieldDtoList;
	}

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSpread() {
		return spread;
	}

	public void setSpread(String spread) {
		this.spread = spread;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getRegulator() {
		return regulator;
	}

	public void setRegulator(String regulator) {
		this.regulator = regulator;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}

	public String getTermsAda() {
		return termsAda;
	}

	public void setTermsAda(String termsAda) {
		this.termsAda = termsAda;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSwap() {
		return swap;
	}

	public void setSwap(String swap) {
		this.swap = swap;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public String getAdaAgreement() {
		return adaAgreement;
	}

	public void setAdaAgreement(String adaAgreement) {
		this.adaAgreement = adaAgreement;
	}

	public String getElectiveProfessional() {
		return electiveProfessional;
	}

	public void setElectiveProfessional(String electiveProfessional) {
		this.electiveProfessional = electiveProfessional;
	}

	public String getTermination() {
		return termination;
	}

	public void setTermination(String termination) {
		this.termination = termination;
	}

	public String getTerminationServer() {
		return TerminationServer;
	}

	public void setTerminationServer(String terminationServer) {
		TerminationServer = terminationServer;
	}

	public String getStp() {
		return stp;
	}

	public void setStp(String stp) {
		this.stp = stp;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getIbAccess() {
		return ibAccess;
	}

	public void setIbAccess(String ibAccess) {
		this.ibAccess = ibAccess;
	}

	public String getFiveday() {
		return fiveday;
	}

	public void setFiveday(String fiveday) {
		this.fiveday = fiveday;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getWithIndex(int index) {
		switch (index) {
		case 1:
			return getKey();
		case 2:
			return getCurrency();
		case 3:
			return getSpread();
		case 4:
			return getMemberType();
		case 5:
			return getRegulator();
		case 6:
			return getCountry();
		case 7:
			return getReferral();
		case 8:
			return getTermsAda();
		case 9:
			return getUserId();
		case 10:
			return getSwap();
		case 11:
			return getPromo();
		case 12:
			return getAdaAgreement();
		case 13:
			return getElectiveProfessional();
		case 14:
			return getTermination();
		case 15:
			return getTerminationServer();
		case 16:
			return getStp();
		case 17:
			return getVip();
		case 18:
			return getIbAccess();
		case 19:
			return getFiveday();
		case 20:
			return getServer();
		}
		return null;
	}

	public void setWithIndex(int index, String value) {
		switch (index) {
		case 1:
			setKey(value);
			break;
		case 2:
			setCurrency(value);
			break;
		case 3:
			setSpread(value);
			break;
		case 4:
			setMemberType(value);
			break;

		case 5:
			setRegulator(value);
			break;
		case 6:
			setCountry(value);
			break;
		case 7:
			setReferral(value);
			break;
		case 8:
			setTermsAda(value);
			break;
		case 9:
			setUserId(value);
			break;
		case 10:
			setSwap(value);
			break;
		case 11:
			setPromo(value);
			break;
		case 12:
			setAdaAgreement(value);
			break;
		case 13:
			setElectiveProfessional(value);
			break;
		case 14:
			setTermination(value);
			break;
		case 15:
			setTerminationServer(value);
			break;
		case 16:
			setStp(value);
			break;
		case 17:
			setVip(value);
			break;
		case 18:
			setIbAccess(value);
			break;
		case 19:
			setFiveday(value);
			break;
		case 20:
			setServer(value);
			break;
		}
	}
}
