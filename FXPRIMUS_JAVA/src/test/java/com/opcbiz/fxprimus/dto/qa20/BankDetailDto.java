package com.opcbiz.fxprimus.dto.qa20;

public class BankDetailDto {
	String bankName;
	String bankAddress;
	String bankAccountNumber;
	String bankSwiftCode;
	String bankIban;
	String bankCountry;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankSwiftCode() {
		return bankSwiftCode;
	}

	public void setBankSwiftCode(String bankSwiftCode) {
		this.bankSwiftCode = bankSwiftCode;
	}

	public String getBankIban() {
		return bankIban;
	}

	public void setBankIban(String bankIban) {
		this.bankIban = bankIban;
	}

	public String getBankCountry() {
		return bankCountry;
	}

	public void setBankCountry(String bankCountry) {
		this.bankCountry = bankCountry;
	}

	public BankDetailDto(String bankName, String bankAddress, String bankAccountNumber, String bankSwiftCode,
			String bankIban, String bankCountry) {
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.bankAccountNumber = bankAccountNumber;
		this.bankSwiftCode = bankSwiftCode;
		this.bankIban = bankIban;
		this.bankCountry = bankCountry;
	}

}
