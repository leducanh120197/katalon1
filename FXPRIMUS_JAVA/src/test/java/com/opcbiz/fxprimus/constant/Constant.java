package com.opcbiz.fxprimus.constant;

public class Constant {
	// Web Drivers
	public static final String BROWSER_DRIVER_CHROME_WIN = "webdrivers/chromedriver.exe";
	public static final String BROWSER_DRIVER_CHROME_MAC = "webdrivers/chromedrivermac";
	public static final String BROWSER_DRIVER_FIREFOX_WIN = "webdrivers/geckodriver.exe";
	public static final String BROWSER_DRIVER_FIREFOX_MAC = "";
	public static final String BROWSER_DRIVER_SAFARI_WIN = "";
	public static final String BROWSER_DRIVER_SAFARI_MAC = "";
	public static final String BROWSER_DRIVER_EDGE_WIN = "webdrivers/msedgedriver.exe";
	public static final String BROWSER_DRIVER_EDGE_MAC = "";

	// Base Path
	public static final String BASE_SOURCE_PATH = "inputData/";

	// Data Sources for Register
	public static final String REGISTER_TEST_DATA_PATH = BASE_SOURCE_PATH + "MA_221.xlsx";
	public static final String REGISTER_TEST_DATA_SHEET = "Registration_Testdata";// Registration_Testdata registration

	// Data Sources for Register
	// registration
	public static final String REGISTER_TEST_DATA_FUNCTION_SHEET = "Registration_function";
	public static final String REGISTER_TEST_DATA_EMAIL_VERIFYCATION_SHEET = "Email_Verification";

	public static final String EXIST_EMAIL_DATA_PATH = BASE_SOURCE_PATH + "MA_223.xlsx";
	public static final String MIGRATION_DATA_PATH = BASE_SOURCE_PATH + "MA_224.xlsx";
	public static final String MA_225_DATA_PATH = BASE_SOURCE_PATH + "MA_225_Individual.xlsx";
	public static final String MA_225_CORPORATE_DATA_PATH = BASE_SOURCE_PATH + "MA_225_Corporate.xlsx";
	public static final String MA_225_JOINT_DATA_PATH = BASE_SOURCE_PATH + "MA_225_Joint.xlsx";
	public static final String MA_226 = BASE_SOURCE_PATH + "MA_226.xlsx";

	public static final String CSV = BASE_SOURCE_PATH + "test.csv";

	public static final String ACCOUNT_DETAILS = "Account_Details";
	public static final String NEW_EMAIL_DATA_SHEET = "Register";
	public static final String CHECK_DATA_SHEET = "Check_unique_email_exist";
	public static final String MIGRATION_DATA_SHEET = "Migration_validation";
	public static final String VALIDATION_TYPE_IS_SELECTED = "is_selected";
	public static final String VALIDATION_TYPE_IS_SINGLE_CHOICE = "single_choice";
	public static final String VALIDATION_TYPE_IS_ERROR = "error";
	public static final String PREFERRED_LANGUAGE = "PREFERRED_LANGUAGE";
	public static final String ADDRESS = "ADDRESS";
	public static final String CITY_TOWN = "CITY_TOWN";
	public static final String ZIP_POSTALCODE = "ZIP_POSTALCODE";
	public static final String STATE_PROVINCE = "STATE_PROVINCE";
	public static final String DATE_OF_BIRTH = "DATE_OF_BIRTH";
	public static final String GENDER = "GENDER";
	public static final String BUTTON_PROCEED = "BUTTON_PROCEED";
	public static final String PROCEED_BUTTON_FUNCTION = "PROCEED_BUTTON_FUNCTION";
	public static final String COMPANY_NAME = "COMPANY_NAME";
	public static final String CITY = "CITY";
	public static final String COUNTRY = "COUNTRY";
	public static final String TOTAL_NUMBER_OF_DIRECTORS = "TOTAL_NUMBER_OF_DIRECTORS";
	public static final String TOTAL_NUMBER_OF_SHAREHOLDERS = "TOTAL_NUMBER_OF_SHAREHOLDERS";
	public static final String LICENCES_YOU_HAVE_OBTAINED = "LICENCES_YOU_HAVE_OBTAINED";
	public static final String BACKGROUND_EXPERIENCE = "BACKGROUND_EXPERIENCE";
	public static final String BUTTON_PROCEED_CORPORATE = "BUTTON_PROCEED_CORPORATE";
	public static final String FIRST_NAME = "FIRST_NAME";
	public static final String LAST_NAME = "LAST_NAME";
	public static final String EMAIL = "EMAIL";

	public static final String STATE = "STATE";
	public static final String LANGUAGE = "LANGUAGE";
	public static final String PHONE_NUMBER = "PHONE_NUMBER";
	public static final String QUESTION_POLITICALLY_ACC2 = "QUESTION_POLITICALLY_ACC2";
	public static final String QUESTION_US_CITIZENSHIP_ACC2 = "QUESTION_US_CITIZENSHIP_ACC2";
	public static final String BUTTON_PROCEED_FUNCTION = "BUTTON_PROCEED_FUNCTION";

	public static final String QUESTIONNAIRE_DATA_SHEET = "Questionnaire";

	// Data Sources for QA24
	public static final String QA24_DATA_PATH = BASE_SOURCE_PATH + "QA_24.xlsx";
	public static final String QA_24_DATA_SHEET = "QA_24";
	public static final String KEY_DATA_SHEET = "key";
	public static final String CURRENCY_DATA_SHEET = "currency";
	public static final String SPREAD_DATA_SHEET = "spread";
	public static final String MEMBER_TYPE_DATA_SHEET = "member_type";
	public static final String REGULATOR_DATA_SHEET = "regulator";
	public static final String COUNTRY_DATA_SHEET = "country";
	public static final String REFERRAL_DATA_SHEET = "referral";
	public static final String TERMS_ADA_DATA_SHEET = "terms_ada";
	public static final String USER_ID_DATA_SHEET = "user_id";
	public static final String SWAP_DATA_SHEET = "swap";
	public static final String PROMO_DATA_SHEET = "promo";
	public static final String ADA_AGREEMENT_DATA_SHEET = "ada_agreement";
	public static final String ELECTIVE_PROFESSIONAL_DATA_SHEET = "elective_professional";
	public static final String TERMINATION_DATA_SHEET = "termination";
	public static final String TERMINATION_SERVER_DATA_SHEET = "termination_server";
	public static final String STP_DATA_SHEET = "stp";
	public static final String VIP_DATA_SHEET = "vip";
	// new update
	public static final String IB_ACCESS_DATA_SHEET = "ib_access";
	public static final String FIVEDAY_DATA_SHEET = "fiveday";
	public static final String SERVER_DATA_SHEET = "server";

	// Data Sources for QA 19
	public static final String QA19_DATA_PATH = BASE_SOURCE_PATH + "QA_19.xlsx";
	public static final String QA_19_DATA_SHEET = "QA_19";

	public static final String QA19_LIST_ACCOUNT_DATA_PATH = BASE_SOURCE_PATH + "QA_19_ListAccount.xlsx";
	public static final String QA19_ACCOUNT_MIX_DATA_SHEET = "MIX";

	public static final String PARTNER_TYPE_AFFILIATE = "AFFI";

	// QA 19 Account root
	public static final String ROOT_MT4_ID = "1532449";
	public static final String ROOT_ID = "50000336";
	public static final String ROOT_EMAIL = "qa_automation+01062020@fxprimus.tech";
	public static final String ROOT_PASSWORD = "Lqa@12345";
	public static final String ROOT_TYPE = "PARTNER_IB_INDIVIDUAL";
	public static final String ROOT_REF_ID = "root";

	// QA 20 + 19 + 24
	public static final String QA_20_DATA_PATH = BASE_SOURCE_PATH + "QA_20.xlsx";
	public static final String QA_20_DATA_SHEET = "QA_20";
	public static final String CLIENT_UPPER = "CLIENT";
	public static final String PARTNER_UPPER = "PARTNER";
	
	// QA 20 Bank detail
	public static final String BANK_NAME = "Deutsche Bank";
	public static final String BANK_ADDRESS = "Mariendorfer Damm 444, 12107 Berlin, Germany";
	public static final String BANK_ACCOUNT_NUMBER = "10095011800000";
	public static final String BANK_SWIFT_CODE = "DEUTDEFF";
	public static final String BANK_IBAN = "DE75500700100950118000";
	public static final String BANK_COUNTRY = "Germany";

	// 226
	public static final String CAPTURE_PATH = BASE_SOURCE_PATH + "Capture001.png";

	//
	public static final String QUESTION_POLITICALLY = "QUESTION_POLITICALLY";
	public static final String QUESTION_US_CITIZENSHIP = "QUESTION_US_CITIZENSHIP";
	public static final String CHECKBOX_ACCEPT = "CHECKBOX_ACCEPT";

	// 227
	public static final String MA_227_DATA_PATH = BASE_SOURCE_PATH + "MA_227.xlsx";
	public static final String MA_227_DATA_SHEET = "MA_227";
	
	
	// Email account
	public static final String GMAIL = "truong.vu@opcbiz.com";
	public static final String GMAIL_HEAD = "truong.vu";
	public static final String GMAIL_TAIL = "@opcbiz.com";
	public static final String GMAIL_PASSWORD = "Mrvu@1102";
	public static final String EXIST_MAIL = "truong.vu+41@opcbiz.com";

	// Email account QA_AUTOMATION
	public static final String GMAIL_QA_AUTOMATION = "qa_automation@fxprimus.tech";
	public static final String GMAIL_QA_AUTOMATION_PASSWORD = "}V75nBXEaRgB";
	// }V75nBXEaRgB

	public static final String ACC_PASSWORD = "Testauto01@";

	public static final String MAIL_H = "qa_automation";
	public static final String MAIL_HEAD = "qa_automation+";
	public static final String MAIL_TAIL = "@fxprimus.tech";

	// Web labels, properties
	public static final String DASHBOARD = "Dashboard";
	public static final String AFFILIATE_REG = "Affiliate Registration";
	public static final String REGISTER = "Register";
	public static final String ACTIVE = "active";
	public static final String INACTIVE = "inactive";
	public static final String VALIDATION = "validation";
	public static final String SUCCESS = "success";
	public static final String VERIFICATION = "Verification";
	public static final String TRADING_ACCOUNT = "Trading Account";
	public static final String DOCUMENTS = "Documents";
	public static final String FINANCIAL = "Financial";
	public static final String TRADING_KNOWLEDGE = "Trading Knowledge";
	public static final String WITHDRAWAL = "Withdrawals";
	public static final String TRANSFER = "MT4 to MT4 Transfer";
	public static final String LOGIN = "Login";

	// time in milisec
	public static final long HALFSEC = 500;
	public static final long ONESEC = 1000;
	public static final long IN01SEC = 1000;
	public static final long TWOSEC = 2000;
	public static final long THREESEC = 3000;
	public static final long FIVESEC = 5000;
	public static final long TENSEC = 10000;
	public static final long FIFTEENS = 15000;
	public static final long THIRTYS = 10000;
	public static final long ONEMIN = 60000;

	// browser
	public static final String CHROME = "Chrome";
	public static final String FIREFOX = "Firefox";
	public static final String EDGE = "Edge";
	public static final String CHROME_MAC = "Chrome Mac";
	public static final String SAFARI_MAC = "Safari";
}
