package com.opcbiz.fxprimus.dto.qa19;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class QA19Dto {
	String id;
	String title;
	String json;
	String jsonNetWork;

	public String getJsonNetWork() {
		return jsonNetWork;
	}

	public void setJsonNetWork(String jsonNetWork) {
		this.jsonNetWork = jsonNetWork;
	}

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("JSON", "json", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("JSON_NETWORK", "jsonNetWork", ExcelFieldDto.DataType.STRING, "STRING"));
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

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
}
