package com.opcbiz.fxprimus.dto.qa19;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class AccountDto {
	String mt4;
	String id;
	String email;
	String passWord;
	String type;
	String refId;
	String accountInfor;

	public String getAccountInfor() {
		return accountInfor;
	}

	public void setAccountInfor(String accountInfor) {
		this.accountInfor = accountInfor;
	}

	public String getMt4() {
		return mt4;
	}

	public void setMt4(String mt4) {
		this.mt4 = mt4;
	}

	public AccountDto(String mt4, String id, String email, String passWord, String type, String accountInfor, String refId) {
		this.id = id;
		this.email = email;
		this.passWord = passWord;
		this.type = type;
		this.accountInfor = accountInfor;
		this.refId = refId;
		this.mt4 = mt4;
	}

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("MT4", "mt4", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EMAIL", "email", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PASSWORD", "passWord", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TYPE", "type", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("REFERRAL_ID", "refId", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ACCOUNT_INFOR", "accountInfor", ExcelFieldDto.DataType.STRING, "STRING"));

		return excelFieldDtoList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getWithIndex(int index) {
		switch (index) {
		case 1:
			return getMt4();
		case 2:
			return getID();
		case 3:
			return getEmail();
		case 4:
			return getPassWord();
		case 5:
			return getType();
		case 6:
			return getAccountInfor();
		case 7:
			return getRefId();

		}
		return "";

	}

	@Override
	public String toString() {
		return "AccountDto [email=" + email + ", passWord=" + passWord + ", ID=" + id + "]";
	}

}
