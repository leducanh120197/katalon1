package com.opcbiz.fxprimus.dto.uniqueuser;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;
import com.opcbiz.fxprimus.dto.register.RegisterDto;

public class ExistEmailDto extends RegisterDto {
	// ID TITLE URL ACCOUNT_TYPE FIRST_NAME LAST_NAME COUNTRY PHONE_NUMBER PASSWORD
	// DISPLAY_CHECKBOX_VALIDATION TYPE_ACCOUNT PARTNERS_REFERRED_ID

	// BUTTON_REGISTER_NOW VERIFY_EMAIL_ADDRESS_VALIDATION unused

	String url;
	String typeAccount;
	String partnersReferredId;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("URL", "url", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ACCOUNT_TYPE", "accountType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("FIRST_NAME", "firstName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LAST_NAME", "lastName", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COUNTRY", "country", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("PHONE_NUMBER", "phoneNumber", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PASSWORD", "password", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("DISPLAY_CHECKBOX_VALIDATION", "displayCheckboxValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("TYPE_ACCOUNT", "typeAccount", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PARTNERS_REFERRED_ID", "partnersReferredId",
				ExcelFieldDto.DataType.STRING, "STRING"));

		return excelFieldDtoList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

	public String getPartnersReferredId() {
		return partnersReferredId;
	}

	public void setPartnersReferredId(String partnersReferredId) {
		this.partnersReferredId = partnersReferredId;
	}
	
}
