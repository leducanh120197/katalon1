package com.opcbiz.fxprimus.dto.migration;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class MigrationValidationDto {
	String id;
	

	String title;
	String regulatorType;
	String username;
	String password;
	String url;
	String migrationValidation;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("REGULATOR_TYPE", "regulatorType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("USERNAME", "username", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("PASSWORD", "password", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("URL", "url", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("MIGRATION_VALIDATION", "migrationValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));

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

	public String getRegulatorType() {
		return regulatorType;
	}

	public void setRegulatorType(String regulatorType) {
		this.regulatorType = regulatorType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMigrationValidation() {
		return migrationValidation;
	}

	public void setMigrationValidation(String migrationValidation) {
		this.migrationValidation = migrationValidation;
	}
}
