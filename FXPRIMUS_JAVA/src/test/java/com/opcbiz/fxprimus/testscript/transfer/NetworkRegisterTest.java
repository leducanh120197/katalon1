package com.opcbiz.fxprimus.testscript.transfer;

import org.testng.annotations.Test;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.dto.qa19.AccountDto;
import com.opcbiz.fxprimus.dto.qa19.ClientDto;
import com.opcbiz.fxprimus.dto.qa19.PartnerDto;
import com.opcbiz.fxprimus.dto.qa19.QA19Dto;
import com.opcbiz.fxprimus.page.authentication.LoginPageModel;
import com.opcbiz.fxprimus.page.authentication.RegisterPageModel;
import com.opcbiz.fxprimus.page.email.GooglePageModel;
import com.opcbiz.fxprimus.page.profile.DashboardPageModel;
import com.opcbiz.fxprimus.page.transfer.PartnerRegisterPageModel;
import com.opcbiz.fxprimus.page.transfer.TransferPageModel;
import com.opcbiz.fxprimus.testscript.BaseTest;
import com.opcbiz.fxprimus.utils.ExcelUtils;
import com.opcbiz.fxprimus.webdriver.WebDriverFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class NetworkRegisterTest extends BaseTest{
	LoginPageModel loginPageModel;
	PartnerRegisterPageModel partnerRegisterPageModel;
	RegisterPageModel registerPageModel;
	List<AccountDto> listAccountDto;
	GooglePageModel googlePageModel;
	DashboardPageModel dashboardPageModel;
	TransferPageModel transferPageModel;

	PartnerDto[] arrayPartnerDto;
	ClientDto[] arrayClientDto;
	int noTestCaseQA19;
	int noTestCaseTransfer;
	Map<String, List<AccountDto>> mapListAccountDto = new HashMap<String, List<AccountDto>>();
	AccountDto accountRoot = new AccountDto(Constant.ROOT_MT4_ID, Constant.ROOT_ID, Constant.ROOT_EMAIL,
			Constant.ROOT_PASSWORD, Constant.ROOT_TYPE, "IB_INDI", Constant.ROOT_REF_ID);

	@DataProvider
	public QA19Dto[] dataProviderCreateNetWork() {
		List<QA19Dto> qA19Dtos;
		qA19Dtos = ExcelUtils.getInstance().getDataFromExcel(Constant.QA19_DATA_PATH, Constant.QA_19_DATA_SHEET,
				QA19Dto.excelTemplate(), QA19Dto.class);
		QA19Dto[] arrayQA19Dto = new QA19Dto[qA19Dtos.size()];
		for (int i = 0; i < qA19Dtos.size(); i++) {
			arrayQA19Dto[i] = qA19Dtos.get(i);
		}
		noTestCaseQA19 = 0;
		arrayPartnerDto = getArrayPartnerDtos();
		arrayClientDto = getArrayClientDtos();
		return arrayQA19Dto;
	}

	String strJson = "";

	@Test(dataProvider = "dataProviderCreateNetWork")
	public void createNetworkTest(QA19Dto qA19Dto) {
		noTestCaseQA19++;

		if (noTestCaseQA19 != 1) {
			return;
		}

		listAccountDto = new ArrayList<AccountDto>();
		JSONArray jsonArray = new JSONArray(qA19Dto.getJson());
		recursionCreateAccountWithJSONObject(jsonArray, Constant.ROOT_ID);

		mapListAccountDto.put(noTestCaseQA19 + "", listAccountDto);
		strJson = jsonArray.toString();
		System.out.println();
	}

	@AfterTest
	public void afterClassForNetwork() {
//		String rsStrJson = strJson;

		String filePathExcel = ".\\inputData\\QA_19_ListAccount_CLIENT.xlsx";
		ExcelUtils.writeExcelAccountFromListAccountDto(listAccountDto, filePathExcel);
	}

	public void recursionCreateAccountWithJSONObject(JSONArray jsonArray, String referralId) {
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject) object;
			Map<String, String> mapAccountInfor = createAccountWithJSONObject(jsonObject, referralId);

			System.out.println(listAccountDto.size());

			String strAccountId = mapAccountInfor.get("accountId");
			String email = mapAccountInfor.get("email");
			String passWord = mapAccountInfor.get("passWord");
			String type = jsonObject.getString("type");
			String accountInfor = jsonObject.getString("id");

			jsonObject.put("accountId", strAccountId);
			jsonObject.put("email", email);
			jsonObject.put("passWord", passWord);
			listAccountDto
					.add(new AccountDto("mt4", strAccountId, email, passWord, type, accountInfor, referralId + ""));
			JSONArray child = (JSONArray) jsonObject.get("child");
			if (child.length() != 0) {
				recursionCreateAccountWithJSONObject(child, strAccountId);
			}
		}
	}

	public Map<String, String> createAccountWithJSONObject(JSONObject jsonObject, String referralId) {
		String type = jsonObject.getString("type");
		String id = jsonObject.getString("id");
		if (type.contains(Constant.PARTNER_UPPER)) {
			for (PartnerDto partnerDto : arrayPartnerDto) {
				if (id.equals(partnerDto.getId())) {
					try {
						return createAPartner(type, partnerDto, referralId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			for (ClientDto clientDto : arrayClientDto) {
				if (id.equals(clientDto.getId())) {
					try {
						return createAClient(clientDto, referralId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	public Map<String, String> putMapAccountInfo(String id, String email, String passWord) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("accountId", id);
		map.put("email", email);
		map.put("passWord", passWord);
		return map;
	}

	public Map<String, String> createAPartner(String type, PartnerDto partnerDto, String referralId) {
		driver = WebDriverFactory.getDriver(Constant.CHROME);

		partnerRegisterPageModel = new PartnerRegisterPageModel(driver);
		partnerRegisterPageModel.loadRegisterPartner(type, referralId);
//		partnerRegisterPageModel.shutDownPopupRedirected();
		partnerRegisterPageModel.inputData(partnerDto);
		partnerRegisterPageModel.clickProceed();

		googlePageModel = new GooglePageModel(driver);
		dashboardPageModel = googlePageModel.verifyInEmailWithPin(Constant.GMAIL_QA_AUTOMATION,
				Constant.GMAIL_QA_AUTOMATION_PASSWORD);

		String dashboardPageModelGetId = dashboardPageModel.getId();
		Map<String, String> map = putMapAccountInfo(dashboardPageModelGetId, partnerDto.getEmailAddress(),
				partnerDto.getPassword());
		driver.quit();
		return map;

	}

	public Map<String, String> createAClient(ClientDto clientDtos, String referralId) {
		driver = WebDriverFactory.getDriver(Constant.CHROME);
		registerPageModel = new RegisterPageModel(driver);
		registerPageModel.loadRegisterClient(referralId);
//		registerPageModel.shutDownPopupRedirected();
		registerPageModel.inputDataForClientReferralLink(clientDtos);
		registerPageModel.clickRegisterNow();
//		registerPageModel.iwait(2000);
		googlePageModel = new GooglePageModel(driver);
		dashboardPageModel = googlePageModel.verifyInEmailWithPin(Constant.GMAIL_QA_AUTOMATION,
				Constant.GMAIL_QA_AUTOMATION_PASSWORD);
		String dashboardPageModelGetId = dashboardPageModel.getId();
		Map<String, String> map = putMapAccountInfo(dashboardPageModelGetId, clientDtos.getEmailAddress(),
				clientDtos.getPassword());
//		dashboardPageModel.iwait(1000);
		driver.quit();
		return map;
	}

	public PartnerDto[] getArrayPartnerDtos() {
		List<PartnerDto> partnerDtos;
		partnerDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.QA19_DATA_PATH,
				Constant.PARTNER_UPPER, PartnerDto.excelTemplate(), PartnerDto.class);

		PartnerDto[] arrayPartnerDto = new PartnerDto[partnerDtos.size()];
		for (int i = 0; i < partnerDtos.size(); i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String newEmailCurrentTimeMillis = addCurrentTimeMillisToEmail(partnerDtos.get(i).getEmailAddress(),
					System.currentTimeMillis());
			partnerDtos.get(i).setEmailAddress(newEmailCurrentTimeMillis);
			arrayPartnerDto[i] = partnerDtos.get(i);
		}
		return arrayPartnerDto;
	}

	public ClientDto[] getArrayClientDtos() {
		List<ClientDto> clientDtos;
		clientDtos = ExcelUtils.getInstance().getDataFromExcel(Constant.QA19_DATA_PATH,
				Constant.CLIENT_UPPER, ClientDto.excelTemplate(), ClientDto.class);
		ClientDto[] arrayClientDtos = new ClientDto[clientDtos.size()];
		for (int i = 0; i < clientDtos.size(); i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String newEmailCurrentTimeMillis = addCurrentTimeMillisToEmail(clientDtos.get(i).getEmailAddress(),
					System.currentTimeMillis());
			clientDtos.get(i).setEmailAddress(newEmailCurrentTimeMillis);
			arrayClientDtos[i] = clientDtos.get(i);
		}
		return arrayClientDtos;
	}

	public String addCurrentTimeMillisToEmail(String email, long currentTimeMillis) {
		return email.replace("RANDOM", "qa_automation+" + currentTimeMillis + "@fxprimus.tech");
	}
}
