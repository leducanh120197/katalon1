package com.opcbiz.fxprimus.testscript.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.constant.UrlConstant;
import com.opcbiz.fxprimus.dto.api.QA24ATestCaseReportDto;
import com.opcbiz.fxprimus.dto.api.QA24FieldDto;
import com.opcbiz.fxprimus.dto.api.QA24TestDataDto;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.utils.LogUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class QA24 {
	List<QA24TestDataDto> dataQA24;

	List<QA24FieldDto> dataKey;
	List<QA24FieldDto> dataCurrency;
	List<QA24FieldDto> dataSpread;
	List<QA24FieldDto> dataMemberType;
	List<QA24FieldDto> dataRegulator;
	List<QA24FieldDto> dataCountry;
	List<QA24FieldDto> dataReferral;
	List<QA24FieldDto> dataTermsAda;
	List<QA24FieldDto> dataUserId;
	List<QA24FieldDto> dataSwap;
	List<QA24FieldDto> dataPromo;
	List<QA24FieldDto> dataAdaAgreement;
	List<QA24FieldDto> dataElectiveProfessional;
	List<QA24FieldDto> dataTermination;
	List<QA24FieldDto> dataTerminationServer;
	List<QA24FieldDto> dataStp;
	List<QA24FieldDto> dataVip;
	// new update
	List<QA24FieldDto> dataIbAccess;
	List<QA24FieldDto> dataFiveday;
	List<QA24FieldDto> dataServer;

	List<List<QA24FieldDto>> listSheet = new ArrayList<List<QA24FieldDto>>();
	
	@DataProvider(name = "QA24")
	public Object[] dataProviderField() {
		dataQA24 = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.QA_24_DATA_SHEET,
				QA24TestDataDto.excelTemplate(), QA24TestDataDto.class);

		List<List<QA24FieldDto>> listOfListFieldDtoFromDataSheet = getFieldDtoDatasFromExcel();
		for (List<QA24FieldDto> listFieldDto : listOfListFieldDtoFromDataSheet) {
			listSheet.add(listFieldDto);
		}

		int numBerOfRowNeedTestInExcel = dataQA24.size();
		int rowStartTestInExcel = 0;

		List<QA24TestDataDto> qa24TestDataDtosLegacy = new ArrayList<QA24TestDataDto>();
		for (int rowQA24 = rowStartTestInExcel; rowQA24 < numBerOfRowNeedTestInExcel; rowQA24++) {
			List<List<String>> matrixLegacy = getMatrixDataLegacy(rowQA24);
			List<QA24TestDataDto> listQA24TestDataDto = convertMatrixToObjectListMultiLoop(rowQA24, matrixLegacy);
			for (QA24TestDataDto qa24TestDataDto : listQA24TestDataDto) {
				qa24TestDataDtosLegacy.add(qa24TestDataDto);
			}
		}

		List<QA24TestDataDto> qa24TestDataDtosNew = new ArrayList<QA24TestDataDto>();
		for (int rowQA24 = rowStartTestInExcel; rowQA24 < numBerOfRowNeedTestInExcel; rowQA24++) {
			List<List<String>> matrixNew = getMatrixDataNew(rowQA24);
			System.out.println("rowQA24:  " + rowQA24);
			List<QA24TestDataDto> listQA24TestDataDto = convertMatrixToObjectListMultiLoop(rowQA24, matrixNew);
			for (QA24TestDataDto qa24TestDataDto : listQA24TestDataDto) {
				qa24TestDataDtosNew.add(qa24TestDataDto);
			}
		}

		int qa24TestDataDtosLegacySize = qa24TestDataDtosLegacy.size();
		Object[] mapStringObjectArray = new Object[qa24TestDataDtosLegacySize];
		for (int iSize = 0; iSize < qa24TestDataDtosLegacySize; iSize++) {
			Map<String, Object> mapLegacyNew = new HashMap<String, Object>();
			mapLegacyNew.put("legacy", qa24TestDataDtosLegacy.get(iSize));
			mapLegacyNew.put("new", qa24TestDataDtosNew.get(iSize));
			mapStringObjectArray[iSize] = mapLegacyNew;
		}
		noTestCase = 0;
		testNGResults = new ArrayList<QA24ATestCaseReportDto>();
		return mapStringObjectArray;
	}

	int noTestCase;
	List<QA24ATestCaseReportDto> testNGResults;
	int startTestCase = 0;
	int endTestCase = 0;
	long startTime;
	long endTime;
	String browserForTest;

	@Test(dataProvider = "QA24")
	public void compareResponseDataLegacyAndNew(Object fieldDto) {
		
//		mvn install
		
//		startTestCase = 0; endTestCase = 200;
//		startTestCase = 200; endTestCase = 400;
//		startTestCase = 400; endTestCase = 600;
//		startTestCase = 600; endTestCase = 800;
//		startTestCase = 800; endTestCase = 1000;
		
//		startTestCase = 1000; endTestCase = 1200;
//		startTestCase = 1200; endTestCase = 1400;
//		startTestCase = 1400; endTestCase = 1600;
//		startTestCase = 1600; endTestCase = 1800;
//		startTestCase = 1800; endTestCase = 2000;
		
//		startTestCase = 2000; endTestCase = 2200;
//		startTestCase = 2200; endTestCase = 2400;
//		startTestCase = 2400; endTestCase = 2600;
//		startTestCase = 2600; endTestCase = 2800;
//		startTestCase = 2800; endTestCase = 3000;
		
//		startTestCase = 3000; endTestCase = 3200;
		
		startTestCase = 3200; endTestCase = 3400;
		
	
		if(noTestCase < startTestCase || noTestCase >= endTestCase) { ++noTestCase; return; }

		System.out.println("noTestCase: " + noTestCase);

		startTime = System.currentTimeMillis();
		LogUtils.infoLine("start at: " + startTime);
		QA24ATestCaseReportDto aTestCaseReportDto = new QA24ATestCaseReportDto();

		@SuppressWarnings("unchecked")
		Map<String, Object> mso = (Map<String, Object>) fieldDto;
		QA24TestDataDto msoLegacy = (QA24TestDataDto) mso.get("legacy");
		QA24TestDataDto msoNew = (QA24TestDataDto) mso.get("new");
		++noTestCase;

		//TODO
		if (msoNew.getExpect().equals("NULL")) {
			Map<String, String> resultCompareApiResponse = new HashMap<String, String>();
			try {
				resultCompareApiResponse = compareApiResponse(msoLegacy, msoNew);
			} catch (Exception e) {
				System.out.println(noTestCase + "Exception");
				e.printStackTrace();
			}
			extentTestGetJsonResponseNewSystem(aTestCaseReportDto, msoNew);
			extentTestGetJsonResponseLegacySystem(aTestCaseReportDto, msoLegacy);
			aTestCaseReportDto.setId(msoNew.getId() + (noTestCase));
			aTestCaseReportDto.setTitle(msoNew.getTitle());
			aTestCaseReportDto.setJsonOutputLegacy(resultCompareApiResponse.get("jsonOutputLegacy"));
			aTestCaseReportDto.setJsonOutputNew(resultCompareApiResponse.get("jsonOutputNew"));
			aTestCaseReportDto.setJsonExpect("");
			aTestCaseReportDto.setResult(resultCompareApiResponse.get("resultCompare"));
			testNGResults.add(aTestCaseReportDto);
		} else {
			Map<String, String> resultCompareExpect = new HashMap<String, String>();
			try {
				resultCompareExpect = compareExpect(msoNew);
			} catch (Exception e) {
				System.out.println(noTestCase + "Exception");
				e.printStackTrace();
			}
			extentTestGetJsonResponseNewSystem(aTestCaseReportDto, msoNew);
			aTestCaseReportDto.setId(msoNew.getId() + (noTestCase));
			aTestCaseReportDto.setTitle(msoNew.getTitle());
			aTestCaseReportDto.setJsonOutputNew(resultCompareExpect.get("jsonOutputNew"));
			aTestCaseReportDto.setJsonExpect(msoNew.getExpect());
			aTestCaseReportDto.setResult(resultCompareExpect.get("resultCompare"));
			aTestCaseReportDto.setJsonOutputLegacy("");
			testNGResults.add(aTestCaseReportDto);
		}
		LogUtils.infoLine("Extent Report flush");
		endTime = System.currentTimeMillis();
		LogUtils.infoLine("end at " + endTime);
		LogUtils.infoLine("Duration " + (endTime - startTime));

	}

	@AfterTest
	void after() {
		System.out.println();
		String filePath = System.getProperty("user.dir") + "\\" + "QA24_report_" + (startTestCase+1) + "_"+ endTestCase + ".xlsx";
		ExcelUtils.writeExcelReportFromListQA24ATestCaseDto(testNGResults, filePath);
	}

	public Map<String, String> compareApiResponse(QA24TestDataDto msoLegacy, QA24TestDataDto msoNew) {
		LogUtils.infoLine("compare api response");

		Response jsonResponseNewSystem = GetJsonResponseNewSystem(msoNew);
		Response jsonResponseLegacySystem = GetJsonResponseLegacySystem(msoLegacy);
		
		Map<String, String> resultCompareJsonPathGetToString = new HashMap<String, String>();
		try {
			boolean flag = false;
			String jsonResponseLegacySystemJsonPathGet = jsonResponseLegacySystem.jsonPath().get().toString();
			String jsonResponseNewSystemJsonPathGet = jsonResponseNewSystem.jsonPath().get().toString();
			if (jsonResponseLegacySystemJsonPathGet.equals("[]")
					&& jsonResponseNewSystemJsonPathGet.equals("{error=NO GROUPS FOUND}")) {
				flag = true;
				resultCompareJsonPathGetToString.put("jsonOutputLegacy", jsonResponseLegacySystemJsonPathGet);
				resultCompareJsonPathGetToString.put("jsonOutputNew", jsonResponseNewSystemJsonPathGet);
			} else {
				try {
					String jsonResponseLegacySystemJsonPathGetmt4Group = jsonResponseLegacySystem.jsonPath()
							.get("mt4_group").toString();
					String jsonResponseNewSystemJsonPathGetmt4Group = jsonResponseNewSystem.jsonPath().get("mt4_group")
							.toString();
					flag = jsonResponseLegacySystemJsonPathGetmt4Group.equals(jsonResponseNewSystemJsonPathGetmt4Group);
					resultCompareJsonPathGetToString.put("jsonOutputLegacy", jsonResponseLegacySystemJsonPathGet);
					resultCompareJsonPathGetToString.put("jsonOutputNew", jsonResponseNewSystemJsonPathGet);
				} catch (Exception e) {
					resultCompareJsonPathGetToString.put("jsonOutputLegacy", jsonResponseLegacySystemJsonPathGet);
					resultCompareJsonPathGetToString.put("jsonOutputNew", jsonResponseNewSystemJsonPathGet);
				}
			}
			if(flag) {
				resultCompareJsonPathGetToString.put("resultCompare", "PASS");
			}else {
				resultCompareJsonPathGetToString.put("resultCompare", "FAIL");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultCompareJsonPathGetToString;
		
	}

	public Map<String, String> compareExpect(QA24TestDataDto msoNew
//			, QA24ATestCaseReportDto aTestCaseReportDto
			) {
		LogUtils.infoLine("compare Expect");
		Map<String, String> resultCompareExpect = new HashMap<String, String>();
		
		Response jsonResponseNewSystem = GetJsonResponseNewSystem(msoNew);
		boolean flag = false;

		String jsonExpect = msoNew.getExpect();
		String jsonResponseNewSystemJsonPathGet = jsonResponseNewSystem.jsonPath().get().toString();
		try {
			String jsonResponseLegacySystemJsonPathGetmt4Group = jsonExpect;
			String jsonResponseNewSystemJsonPathGetmt4Group = jsonResponseNewSystem.jsonPath().get("mt4_group")
					.toString();
			flag = jsonResponseLegacySystemJsonPathGetmt4Group.equals(jsonResponseNewSystemJsonPathGetmt4Group);
			
			resultCompareExpect.put("jsonExpect", jsonExpect);
			resultCompareExpect.put("jsonOuputNew", jsonResponseNewSystemJsonPathGet);

		} catch (Exception e) {

			resultCompareExpect.put("jsonExpect", jsonExpect);
			resultCompareExpect.put("jsonOuputNew", jsonResponseNewSystemJsonPathGet);
		}
		
		if(flag) {
			resultCompareExpect.put("resultCompare", "PASS");
		}else {
			resultCompareExpect.put("resultCompare", "FAIL");
		}
		return resultCompareExpect;
	}
	
	public Response GetJsonResponseLegacySystem(QA24TestDataDto msoLegacy) {
		Response jsonResponseLegacySystem = RestAssured.given()
				.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
				.queryParam("key", msoLegacy.getKey())
				.queryParam("currency", msoLegacy.getCurrency())
				.queryParam("spread", msoLegacy.getSpread())
				.queryParam("member_type", msoLegacy.getMemberType())
				.queryParam("regulator", msoLegacy.getRegulator())
				.queryParam("country", msoLegacy.getCountry())
				.queryParam("referral", msoLegacy.getReferral())
				.queryParam("terms_ada", msoLegacy.getTermsAda())
				.when().get(UrlConstant.URL_LEGACY_SYSTEM).then().contentType(ContentType.JSON).extract().response();
		return jsonResponseLegacySystem;
	}

	public Response GetJsonResponseNewSystem(QA24TestDataDto msoNew) {
		Response jsonResponseNewSystem = null;
		try {
			jsonResponseNewSystem = RestAssured.given()
					.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
					.queryParam("user_id", msoNew.getUserId())
					.queryParam("currency", msoNew.getCurrency())
					.queryParam("account_type", msoNew.getSpread())
					.queryParam("user_type", msoNew.getMemberType())
					.queryParam("regulator", msoNew.getRegulator())
					.queryParam("ref", msoNew.getReferral())
			
//				.queryParam("swap", msoNew.getSwap())
//				.queryParam("promo", msoNew.getPromo())
//				.queryParam("ada_agreement", msoNew.getAdaAgreement())
//				.queryParam("elective_professional", msoNew.getElectiveProfessional())
//				.queryParam("termonation", msoNew.getTermination())
//				.queryParam("termonation_server", msoNew.getTerminationServer())
//				.queryParam("stp", msoNew.getStp())
//				.queryParam("vip", msoNew.getVip())
//				
//				.queryParam("ib_access", msoNew.getIbAccess())
//				.queryParam("fiveday", msoNew.getFiveday())
//				.queryParam("server", msoNew.getServer())
					
					.when().get(UrlConstant.URL_NEW_SYSTEM).then()
					.contentType(ContentType.JSON).extract().response();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jsonResponseNewSystem;
	}

	public List<String> getListInputData(QA24TestDataDto rowDataQA24, int indexSheet) {
		List<String> result = new ArrayList<String>();
		String typeData = rowDataQA24.getWithIndex(indexSheet);
		List<QA24FieldDto> dataSheet = listSheet.get(indexSheet - 1);
		if (typeData.equals("ALL")) {
			for (int i = 0; i < dataSheet.size(); i++) {
				if (dataSheet.get(i).getInputData().equals("NULL")) {
					result.add("");
				} else {
					result.add(dataSheet.get(i).getInputData());
				}
			}
		} else if (typeData.equals("NULL")) {
			result.add("");
		} else {
			String[] ids = typeData.split("/");
			for (int i = 0; i < dataSheet.size(); i++) {
				for (String id : ids) {
					if (dataSheet.get(i).getId().contains(id)) {
						if (dataSheet.get(i).getInputData().equals("NULL")) {
							result.add("");
						} else {
							result.add(dataSheet.get(i).getInputData());
						}
					}
				}
			}
		}
		return result;
	}

	public List<String> getListInputDataNew(QA24TestDataDto rowDataQA24, int indexSheet) {
		List<String> result = new ArrayList<String>();
		String typeData = rowDataQA24.getWithIndex(indexSheet);
		List<QA24FieldDto> dataSheet = listSheet.get(indexSheet - 1);
		if (typeData.equals("ALL")) {
			for (int i = 0; i < dataSheet.size(); i++) {
				if (dataSheet.get(i).getInputDataNew().equals("NULL")) {
					result.add("");
				} else {
					result.add(dataSheet.get(i).getInputDataNew());
				}
			}
		} else if (typeData.equals("NULL")) {
			result.add("");
		} else {
			String[] ids = typeData.split("/");
			for (int i = 0; i < dataSheet.size(); i++) {
				for (String id : ids) {
					if (dataSheet.get(i).getId().contains(id)) {
						if (dataSheet.get(i).getInputDataNew().equals("NULL")) {
							result.add("");
						} else {
							result.add(dataSheet.get(i).getInputDataNew());
						}
					}
				}
			}
		}
		return result;
	}

	private static List<Integer> next(List<Integer> maxs, List<Integer> at) {
		int length = maxs.size();
		for (int i = length - 1; i >= 0; i--) {
			if (at.get(i) < maxs.get(i) - 1) {
				int t = at.get(i);
				t++;
				at.set(i, t);
				break;
			} else {
				at.set(i, 0);
				continue;// no need but want
			}
		}
		return at;
	}

	public List<List<String>> getMatrixDataNew(int rowQA24) {
		List<List<String>> matrix = new ArrayList<List<String>>();
		for (int iSheet = 1; iSheet <= 20; iSheet++) {
			try {
				List<String> listInput = getListInputDataNew(dataQA24.get(rowQA24), iSheet);
				matrix.add(listInput);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("__iSheet__ "+iSheet);
			}
		}
		return matrix;
	}

	public List<List<String>> getMatrixDataLegacy(int rowQA24) {
		List<List<String>> matrix = new ArrayList<List<String>>();
		for (int iSheet = 1; iSheet <= 20; iSheet++) {
			List<String> listInput = getListInputData(dataQA24.get(rowQA24), iSheet);
			matrix.add(listInput);
		}
		return matrix;
	}

	public List<QA24TestDataDto> convertMatrixToObjectListMultiLoop(int rowQA24, List<List<String>> matrixInput) {
		List<QA24TestDataDto> qa24TestDataDtos = new ArrayList<QA24TestDataDto>();
		List<Integer> sizes = new ArrayList<Integer>();
		for (List<String> integers : matrixInput) {
			sizes.add(integers.size());
		}
		int total = 1;
		List<Integer> sizeOfSheet = new ArrayList<Integer>();
		for (int i = 0; i < sizes.size(); i++) {
			sizeOfSheet.add(sizes.get(i));
			total *= sizes.get(i);
		}
		List<Integer> at = new ArrayList<Integer>();
		for (@SuppressWarnings("unused")
		List<String> integers : matrixInput) {
			at.add(0);
		}
		for (int i = 0; i < total; i++) {
			QA24TestDataDto qa24TestDataDto = new QA24TestDataDto();
			for (int index = 0; index < matrixInput.size(); index++) {
				qa24TestDataDto.setWithIndex(index + 1, matrixInput.get(index).get(at.get(index)));
			}
			qa24TestDataDto.setId(dataQA24.get(rowQA24).getId());
			qa24TestDataDto.setTitle(dataQA24.get(rowQA24).getTitle());
			qa24TestDataDto.setExpect(dataQA24.get(rowQA24).getExpect());
			qa24TestDataDtos.add(qa24TestDataDto);
			at = next(sizes, at);
		}
		return qa24TestDataDtos;
	}

	public void extentTestGetJsonResponseNewSystem(QA24ATestCaseReportDto aTestCaseReportDto, QA24TestDataDto msoNew) {
		aTestCaseReportDto.setNewSystemUser_id(msoNew.getUserId());
		aTestCaseReportDto.setNewSystemCurrency(msoNew.getCurrency());
		aTestCaseReportDto.setNewSystemAccount_type(msoNew.getSpread());
		aTestCaseReportDto.setNewSystemUser_type(msoNew.getMemberType());
		aTestCaseReportDto.setNewSystemRegulator(msoNew.getRegulator());
		aTestCaseReportDto.setNewSystemRef(msoNew.getReferral());
		
//		aTestCaseReportDto.setNewSystemSwap(msoNew.getSwap());
//		aTestCaseReportDto.setNewSystemPromo(msoNew.getPromo());
//		aTestCaseReportDto.setNewSystemAda_agreement(msoNew.getAdaAgreement());
//		aTestCaseReportDto.setNewSystemElective_professional(msoNew.getElectiveProfessional());
//		aTestCaseReportDto.setNewSystemTermonation(msoNew.getTermination());
//		aTestCaseReportDto.setNewSystemTermonation_server(msoNew.getTerminationServer());
//		aTestCaseReportDto.setNewSystemStp(msoNew.getStp());
//		aTestCaseReportDto.setNewSystemVip(msoNew.getVip());
//		aTestCaseReportDto.setNewSystemIbAccess(msoNew.getIbAccess());
//		aTestCaseReportDto.setNewSystemFiveday(msoNew.getFiveday());
//		aTestCaseReportDto.setNewSystemServer(msoNew.getServer());
	}

	public void extentTestGetJsonResponseLegacySystem(QA24ATestCaseReportDto aTestCaseReportDto,
			QA24TestDataDto msoLegacy) {
		aTestCaseReportDto.setLegacySystemKey(msoLegacy.getKey());
		aTestCaseReportDto.setLegacySystemCurrency(msoLegacy.getCurrency());
		aTestCaseReportDto.setLegacySystemSpread(msoLegacy.getSpread());
		aTestCaseReportDto.setLegacySystemMember_type(msoLegacy.getMemberType());
		aTestCaseReportDto.setLegacySystemRegulator(msoLegacy.getRegulator());
		aTestCaseReportDto.setLegacySystemCountry(msoLegacy.getCountry());
		aTestCaseReportDto.setLegacySystemReferral(msoLegacy.getReferral());
		aTestCaseReportDto.setLegacySystemTerms_ada(msoLegacy.getTermsAda());
	}

	public List<List<QA24FieldDto>> getFieldDtoDatasFromExcel() {
		dataKey = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.KEY_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataCurrency = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.CURRENCY_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataSpread = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.SPREAD_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataMemberType = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH,
				Constant.MEMBER_TYPE_DATA_SHEET, QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataRegulator = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH,
				Constant.REGULATOR_DATA_SHEET, QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataCountry = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.COUNTRY_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataReferral = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.REFERRAL_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataTermsAda = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.TERMS_ADA_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataUserId = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.USER_ID_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataSwap = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.SWAP_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataPromo = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.PROMO_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataAdaAgreement = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH,
				Constant.ADA_AGREEMENT_DATA_SHEET, QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataElectiveProfessional = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH,
				Constant.ELECTIVE_PROFESSIONAL_DATA_SHEET, QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataTermination = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH,
				Constant.TERMINATION_DATA_SHEET, QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataTerminationServer = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH,
				Constant.TERMINATION_SERVER_DATA_SHEET, QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataStp = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.STP_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataVip = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.VIP_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		// new update
		dataIbAccess = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.IB_ACCESS_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataFiveday = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.FIVEDAY_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);
		dataServer = ExcelUtils.getInstance().getDataFromExcel(Constant.QA24_DATA_PATH, Constant.SERVER_DATA_SHEET,
				QA24FieldDto.excelTemplate(), QA24FieldDto.class);

		List<List<QA24FieldDto>> listFieldDtoFromDataSheet = new ArrayList<List<QA24FieldDto>>();
		listFieldDtoFromDataSheet.add(dataKey);
		listFieldDtoFromDataSheet.add(dataCurrency);
		listFieldDtoFromDataSheet.add(dataSpread);
		listFieldDtoFromDataSheet.add(dataMemberType);
		listFieldDtoFromDataSheet.add(dataRegulator);
		listFieldDtoFromDataSheet.add(dataCountry);
		listFieldDtoFromDataSheet.add(dataReferral);
		listFieldDtoFromDataSheet.add(dataTermsAda);
		listFieldDtoFromDataSheet.add(dataUserId);
		listFieldDtoFromDataSheet.add(dataSwap);
		listFieldDtoFromDataSheet.add(dataPromo);
		listFieldDtoFromDataSheet.add(dataAdaAgreement);
		listFieldDtoFromDataSheet.add(dataElectiveProfessional);
		listFieldDtoFromDataSheet.add(dataTermination);
		listFieldDtoFromDataSheet.add(dataTerminationServer);
		listFieldDtoFromDataSheet.add(dataStp);
		listFieldDtoFromDataSheet.add(dataVip);

		// new update
		listFieldDtoFromDataSheet.add(dataIbAccess);
		listFieldDtoFromDataSheet.add(dataFiveday);
		listFieldDtoFromDataSheet.add(dataServer);
		return listFieldDtoFromDataSheet;

	}
}
