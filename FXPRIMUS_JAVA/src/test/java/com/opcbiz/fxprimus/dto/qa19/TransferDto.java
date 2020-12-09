package com.opcbiz.fxprimus.dto.qa19;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class TransferDto {
	String id;
	String title;
	String transferFrom;
	String userType;
	String partnerType;
	String transferTo;
	String amount;
	String comments;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("TRANSFER_FROM", "transferFrom", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("USER_TYPE", "userType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("PARTNER_TYPE", "partnerType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRANSFER_TO", "transferTo", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("AMOUNT", "amount", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("COMMENTS", "comments", ExcelFieldDto.DataType.STRING, "STRING"));

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

	public String getTransferFrom() {
		return transferFrom;
	}

	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	public String getTransferTo() {
		return transferTo;
	}

	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "TransferDto [id=" + id + ", title=" + title + ", transferFrom=" + transferFrom + ", userType="
				+ userType + ", partnerType=" + partnerType + ", transferTo=" + transferTo + ", amount=" + amount
				+ ", comments=" + comments + "]";
	}

}
