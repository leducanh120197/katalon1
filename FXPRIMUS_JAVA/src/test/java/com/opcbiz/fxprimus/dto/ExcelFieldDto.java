package com.opcbiz.fxprimus.dto;

public class ExcelFieldDto {
	/* The header name. */
	private String headerName;

	/* The field name. */
	private String fieldName;

	/* The data format. */
	private String dataFormat;

	/* The data type. */
	private DataType dataType;

	/* The Enum DataType. */
	public enum DataType {
		/* The string. */
		STRING,

		/* The date. */
		DATE,

		/* The integer. */
		INTEGER,

		/* The double. */
		DOUBLE,

		/* The long. */
		LONG
	}

	/**
	 * Instantiates a new excel field VO.
	 */
	public ExcelFieldDto() {
	}

	/**
	 * Instantiates a new excel field VO.
	 *
	 * @param headerName the header name
	 * @param fieldName  the field name
	 * @param dataType   the data type
	 * @param dataFormat the data format
	 */
	public ExcelFieldDto(String headerName, String fieldName, DataType dataType, String dataFormat) {
		this.headerName = headerName;
		this.fieldName = fieldName;
		this.dataType = dataType;
		this.dataFormat = dataFormat;
	}

	/**
	 * Gets the header name.
	 *
	 * @return the header name
	 */
	public String getHeaderName() {
		return headerName;
	}

	/**
	 * Sets the header name.
	 *
	 * @param headerName the new header name
	 */
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	/**
	 * Gets the field name.
	 *
	 * @return the field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Sets the field name.
	 *
	 * @param fieldName the new field name
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * Gets the data format.
	 *
	 * @return the data format
	 */
	public String getDataFormat() {
		return dataFormat;
	}

	/**
	 * Sets the data format.
	 *
	 * @param dataFormat the new data format
	 */
	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	/**
	 * Gets the data type.
	 *
	 * @return the data type
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * Sets the data type.
	 *
	 * @param dataType the new data type
	 */
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
}
