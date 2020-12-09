package com.opcbiz.fxprimus.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.ExcelFieldDto;
import com.opcbiz.fxprimus.dto.OpcDto;
import com.opcbiz.fxprimus.dto.api.QA24ATestCaseReportDto;
import com.opcbiz.fxprimus.dto.qa19.AccountDto;
import com.opcbiz.fxprimus.dto.register.CorpPersonDetailDto;

public class ExcelUtils {
	private ExcelUtils() {
	}

	private static ExcelUtils instance;

	/**
	 * Gets the single instance of ExcelUtils.
	 *
	 * @return single instance of ExcelUtils
	 */
	public static synchronized ExcelUtils getInstance() {
		if (instance == null) {
			instance = new ExcelUtils();
		}
		return instance;
	}

	@SuppressWarnings("unused")
	public <T> List<T> getDataFromExcel(String Path, String sheetName, List<ExcelFieldDto> columns,
			Class<T> classConvert) {
		// TODO
		// open excel file
		System.out.println("at " + System.nanoTime() + " start getDataFromExcel of " + sheetName);
		Workbook workbook;
		try {
			// Open the Excel file
			if (sheetName.equals(Constant.CLIENT_UPPER)) {
				System.out.println();
			}
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			workbook = new XSSFWorkbook(ExcelFile);
			Gson gson = new Gson();
			JSONArray jsonArray = getJSONArrayFromExcel(workbook, sheetName, columns);
			String jsonArrayToString = jsonArray.toString();
			if (jsonArray != null) {
				List<T> result = gson.fromJson(jsonArrayToString, new ListOfSomething<T>(classConvert));
				System.out.println("at " + System.nanoTime() + " _end_ getDataFromExcel");
				return result;
			} else {
				return null;
			}

		}
		// ClassNotFoundException
		catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	public JSONArray getJSONArrayFromExcel(Workbook excelWorkBook, String sheetName, List<ExcelFieldDto> columns) {
		System.out.println("at " + System.nanoTime() + " start getJSONArrayFromExcel ");
		JSONArray jsonArray = new JSONArray();
		try {
			Map<String, String> headerFieldMap = new HashMap<String, String>();
			for (ExcelFieldDto ExcelFieldDto : columns) {
				headerFieldMap.put(ExcelFieldDto.getHeaderName(), ExcelFieldDto.getFieldName());
			}
			// headerFieldMap: {REGULATOR_TYPE=regulatorType, PASSWORD=password,
			// USERNAME=username, TITLE=title, ID=id,
			// MIGRATION_VALIDATION=migrationValidation, URL=url}
			Sheet sheet = excelWorkBook.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.rowIterator();

			int rowNum = 0;
			Map<Integer, String> columnIndexMap = new HashMap<Integer, String>();
			while (rowIterator.hasNext()) {
				JSONObject jsonObject = new JSONObject();
				Row row = rowIterator.next();

				// Iterator<Cell> cellIterator = row.cellIterator();

				int columnIndex = 0;
				for (int i = 0; i < columns.size(); i++) {
					Cell cell = row.getCell(i);
					Object cellValue = "";
					if (cell != null) {
						cellValue = ExcelUtils.getInstance().printCellValue(cell);
					} else {
						columnIndex++;
						continue;
					}

					if (rowNum == 0) {
						if (headerFieldMap.containsKey(cell.getRichStringCellValue().getString())) {
							columnIndexMap.put(columnIndex,
									headerFieldMap.get(cell.getRichStringCellValue().getString()));
						} else {
							columnIndexMap.put(columnIndex, cell.getRichStringCellValue().getString());
						}
					}
					jsonObject.put(columnIndexMap.get(columnIndex), cellValue);
					columnIndex++;
				}

				// if rownum == 0 jsonObject =
				// {"password":"PASSWORD","regulatorType":"REGULATOR_TYPE","migrationValidation":"MIGRATION_VALIDATION","id":"ID","title":"TITLE","url":"URL","username":"USERNAME"}
				// if rownum == 1 jsonObject =
				// {"password":"}V75nBXEaRgB","regulatorType":"CY","migrationValidation":"https://client-area-ui.staging.k8s.fxprimus.tech/en/dashboard","id":"LOG_001","title":"Check
				// client login to MA with regulator is
				// CY","url":"https://client-area-ui.staging.k8s.fxprimus.tech/en/login","username":"qa_automation+...@fxprimus.tech"}
				// put to json array if not header row
				if (rowNum > 0) {
					jsonArray.put(jsonObject);
				}

				rowNum++;
			}
			excelWorkBook.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		System.out.println("at " + System.nanoTime() + " end getJSONArrayFromExcel");
		return jsonArray;
	}

	public Object printCellValue(Cell cell) {
		Object result;
		switch (cell.getCellTypeEnum()) {
		case BOOLEAN:
			result = cell.getBooleanCellValue();
			break;
		case STRING:
			result = cell.getRichStringCellValue().getString();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				result = cell.getDateCellValue();
			} else {
				result = (long) cell.getNumericCellValue();
			}
			break;
		case FORMULA:
			result = cell.getCellFormula();
			break;
		case BLANK:
			result = "";
			break;
		default:
			result = "";
		}
		return result;
	}

	public static List<String> getAllWorksheets(String fileName) {
		Workbook workbook;
		List<String> sheetNames = new ArrayList<String>();
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(fileName);
			// Access the required test data sheet

			workbook = new XSSFWorkbook(ExcelFile);

			Iterator<Sheet> iteratorSheet = workbook.sheetIterator();
			while (iteratorSheet.hasNext()) {
				String sheetName = iteratorSheet.next().getSheetName();
				sheetNames.add(sheetName);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sheetNames;
	}

	public OpcDto[][] getMatrixDataFromExcel(String Path, String sheetName) {
		List<OpcDto> list = this.getDataFromExcel(Path, sheetName, OpcDto.excelTemplate(), OpcDto.class);
		int listSize = list.size();
		OpcDto[][] dtoMatrix = new OpcDto[listSize][1];
		// open excel file
		for (int i = 0; i < listSize; i++) {
			list.get(i).setSheetName(sheetName);
			dtoMatrix[i][0] = list.get(i);
		}
		return dtoMatrix;
	}

	public List getDataFromExcel() {
		return null;

	}

	public <T> List<T> getDataFromExcel(List<String> paths, Class<T> classConvert) {
		// TODO
		if (classConvert.getClass().equals(CorpPersonDetailDto.class)) {

		}
		String excelFile = "";
		// Workbook workbook = new XSSFWorkbook(excelFile);

		List<Header> headers = new ArrayList<Header>();
		List<ExcelFieldDto> corpPersonDetailDtoExcelTemplate = CorpPersonDetailDto.excelTemplate();
		for (ExcelFieldDto excelFieldDto : corpPersonDetailDtoExcelTemplate) {
			Header header = new Header();
			header.refer = true;
			if (excelFieldDto.equals("id") || excelFieldDto.equals("title")) {
				header.refer = false;
			}
			header.path = "";
			header.sheetName = excelFieldDto.getHeaderName();
			headers.add(header);
		}
//		List<Header> headers = new ArrayList<Header>();
		for (Header header : headers) {
			if (header.refer) {

			} else {

			}
		}
		return null;
	}

	public void convertToCsv(String xlsxFile, String csvFile) {

		try {
			Workbook wb = new XSSFWorkbook(new File(xlsxFile));
			DataFormatter formatter = new DataFormatter();
			PrintStream out = new PrintStream(new FileOutputStream(csvFile), true, "UTF-8");
			for (Sheet sheet : wb) {
				for (Row row : sheet) {
					boolean firstCell = true;
					for (Cell cell : row) {
						if (!firstCell)
							out.print(',');
						String text = formatter.formatCellValue(cell);
						out.print(text);
						firstCell = false;
					}
					out.println();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void writeExcelReportFromListQA24ATestCaseDto(List<QA24ATestCaseReportDto> testNGResults,
			String filePath) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TestNG Result Summary");
		String[] header = { "ID", "TITLE", "New-payload.User_id", "New-payload.Currency", "New-payload.Account_type",
				"New-payload.User_type", "New-payload.Regulator", "New-payload.Ref", "New-payload.Swap",
				"New-payload.Promo", "New-payload.Ada_agreement", "New-payload.Elective_professional",
				"New-payload.Termonation", "New-payload.Termonation_server", "New-payload.Stp", "New-payload.Vip",
				"New-payload.Ib_Access", "New-payload.Fiveday", "New-payload.Server",

				"Legacy-payload.Key", "Legacy-payload.Currency", "Legacy-payload.Spread", "Legacy-payload.Member_type",
				"Legacy-payload.Regulator", "Legacy-payload.Country", "Legacy-payload.Referral",
				"Legacy-payload.Terms_ada", "Legacy-output", "New-output", "Expect", "RESULT" };
		Row rowHeader = sheet.createRow(0);
		int cellNumHeader = 0;
		for (String value : header) {
			Cell cellHeader = rowHeader.createCell(cellNumHeader++);
			cellHeader.setCellValue(value);
		}

		int rownum = 1;
		for (QA24ATestCaseReportDto qA24ATestCaseDto : testNGResults) {
			Row row = sheet.createRow(rownum);
			int cellnum = 0;
			for (int iColumn = 1; iColumn <= 31; iColumn++) {
				Cell cell = row.createCell(cellnum);
				cell.setCellValue((String) qA24ATestCaseDto.getWithIndex(iColumn));
				cellnum += 1;
			}
			rownum += 1;
		}
		try {
			FileOutputStream out = new FileOutputStream(new File(filePath));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeExcelAccountFromListAccountDto(List<AccountDto> listAccountDto, String filePath) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("list_account_");
		String[] header = { "MT4", "ID", "EMAIL", "PASSWORD", "TYPE", "ACCOUNT_INFOR", "REFERRAL_ID" };
		Row rowHeader = sheet.createRow(0);
		int cellNumHeader = 0;
		for (String value : header) {
			Cell cellHeader = rowHeader.createCell(cellNumHeader++);
			cellHeader.setCellValue(value);
		}

		int rownum = 1;
		for (AccountDto accountDto : listAccountDto) {
			Row row = sheet.createRow(rownum);
			int cellnum = 0;
			for (int iColumn = 1; iColumn <= 7; iColumn++) {
				Cell cell = row.createCell(cellnum);
				cell.setCellValue((String) accountDto.getWithIndex(iColumn));
				cellnum += 1;
			}
			rownum += 1;

		}
		try {
			FileOutputStream out = new FileOutputStream(new File(filePath));
			workbook.write(out);
			out.close();
			System.out.println("DONE ListAccount");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
