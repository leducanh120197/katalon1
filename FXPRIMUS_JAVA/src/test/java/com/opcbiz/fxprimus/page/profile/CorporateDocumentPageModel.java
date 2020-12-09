package com.opcbiz.fxprimus.page.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opcbiz.fxprimus.constant.Constant;
import com.opcbiz.fxprimus.page.BaseModel;

/**
 * @author toannl
 *
 */
public class CorporateDocumentPageModel extends BaseModel {

	String imagePath = (System.getProperty("user.dir") + "\\" + Constant.CAPTURE_PATH).replace("\\", "/");

	@FindBy(xpath = "//*[contains(text(),'Account Opening Questionnaire')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileAccountOpeningQuestionnaire;

	@FindBy(xpath = "//*[contains(text(),'Account Opening Questionnaire')]/..//input")
	// *[contains(text(),'Account Opening
	// Questionnaire')]/..//span[contains(text(),'Add your
	// files')]/../../../../input
	// *[contains(text(),'Account Opening Questionnaire')]/..//input
	WebElement inputFileAddFileAccountOpeningQuestionnaire;

	@FindBy(xpath = "//*[contains(text(),'Account Opening Questionnaire')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadAccountOpeningQuestionnaire;

	@FindBy(xpath = "//*[contains(text(),'Resolution from the board of directors')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileResolutionAccount;

	@FindBy(xpath = "//*[contains(text(),'Resolution from the board of directors')]/..//input")
	WebElement inputFileAddFileResolutionAccount;

	@FindBy(xpath = "//*[contains(text(),'Resolution from the board of directors')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadResolutionAccount;

	@FindBy(xpath = "//*[contains(text(),'Scanned copy of the audit report')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileScannedEquivalent;
	@FindBy(xpath = "//*[contains(text(),'Scanned copy of the audit report')]/..//input")
	WebElement inputFileAddFileScannedEquivalent;

	@FindBy(xpath = "//*[contains(text(),'Scanned copy of the audit report')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadScannedEquivalent;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Incumbency or Good Standing')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileGoodStanding;
	@FindBy(xpath = "//*[contains(text(),'Certificate of Incumbency or Good Standing')]/..//input")
	WebElement inputFileAddFileGoodStanding;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Incumbency or Good Standing')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadGoodStanding;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Incorporation')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileIncorporation;
	@FindBy(xpath = "//*[contains(text(),'Certificate of Incorporation')]/..//input")
	WebElement inputFileAddFileIncorporation;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Incorporation')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadIncorporation;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Directors')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileDirectors;
	@FindBy(xpath = "//*[contains(text(),'Certificate of Directors')]/..//input")
	WebElement inputFileAddFileDirectors;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Directors')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadDirectors;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Shareholders')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileShareholders;
	@FindBy(xpath = "//*[contains(text(),'Certificate of Shareholders')]/..//input")
	WebElement inputFileAddFileShareholders;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Shareholders')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadShareholders;

	@FindBy(xpath = "//*[contains(text(),'Memorandum and Articles of Association')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileArticles;
	@FindBy(xpath = "//*[contains(text(),'Memorandum and Articles of Association')]/..//input")
	WebElement inputFileAddFileArticles;

	@FindBy(xpath = "//*[contains(text(),'Memorandum and Articles of Association')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadArticles;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Registered Address')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileRegisteredAddress;
	@FindBy(xpath = "//*[contains(text(),'Certificate of Registered Address')]/..//input")
	WebElement inputFileAddFileRegisteredAddress;

	@FindBy(xpath = "//*[contains(text(),'Certificate of Registered Address')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadRegisteredAddress;

	@FindBy(xpath = "//*[contains(text(),'Declaration of trust (for the authorised person) funds')]/..//span[contains(text(),'Add your files')]/../..")
	WebElement buttonAddFileDeclaration;
	@FindBy(xpath = "//*[contains(text(),'Declaration of trust (for the authorised person) funds')]/..//input")
	WebElement inputFileAddFileDeclaration;

	@FindBy(xpath = "//*[contains(text(),'Declaration of trust (for the authorised person) funds')]/..//span[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadDeclaration;

	@FindBy(xpath = "//*[contains(text(),'copy of your Proof of Identification')]/../../..//*[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadKycIdentification;

	@FindBy(xpath = "//*[contains(text(),'Add POR Front')]/../..")
	WebElement buttonAddPorFront;

	@FindBy(xpath = "//*[contains(text(),'Add POR Front')]/../../../input")
	WebElement inputFileAddPorFront;

	@FindBy(xpath = "//*[contains(text(),'Add POR Back')]/../..")
	WebElement buttonAddPorBack;

	@FindBy(xpath = "//*[contains(text(),'Add POR Back')]/../../../input")
	WebElement inputFileAddPorBack;

	@FindBy(xpath = "//*[contains(text(),'Add POR Front')]/../../../../..//*[contains(text(),'SUBMIT')]/../..")
	WebElement buttonUploadKycResidence;

	@FindBy(xpath = "//*[contains(text(),'copy of your Proof of Identification')]/../../..//*[contains(text(),'Add Driving Licence')]")
	WebElement buttonAddDrivingLicenceC;

	@FindBy(xpath = "//*[contains(text(),'copy of your Proof of Identification')]/../../..//input")
	WebElement inputFileAddDrivingLicenceC;

	// TODO Element set for account holder 1

	@FindBy(id = "docType")
	private WebElement selectDocumentType;

	@FindBy(xpath = "//mat-option[@value='National ID Card']")
	private WebElement optionNation;

	@FindBy(xpath = "//mat-option[@value='driving licence']")
	private WebElement optionDriving;

	@FindBy(xpath = "//mat-option[@value='passport']")
	private WebElement optionPassport;

	@FindBy(xpath = "//*[contains(text(),'ACCOUNT HOLDER 1')]/../../..//*[contains(text(),'Add ID Front')]/../..")
	private WebElement buttonAddIdFront;

	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[1]/div[3]/div[2]/div[1]/div/input[1]")
	private WebElement inputFileAddIdFront;

	@FindBy(xpath = "//*[contains(text(),'ACCOUNT HOLDER 1')]/../../..//*[contains(text(),'Add ID Back')]/../..")
	private WebElement buttonAddIdBack;

	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[1]/div[3]/div[2]/div[1]/div/input[2]")
	private WebElement inputFileAddIdBack;

	@FindBy(xpath = "//*[contains(text(),'ACCOUNT HOLDER 1')]/../../..//*[contains(text(),'Add Driving Licence')]/../..")
	private WebElement buttonAddDrivingLicence;

	@FindBy(xpath = "//*[contains(text(),'ACCOUNT HOLDER 1')]/../../..//*[contains(text(),'Add Driving Licence')]/../../../input")
	private WebElement inputFileAddDrivingLicence;
	// *[@id='left-card']/div[2]/div[1]/div[2]/div[1]/button
	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[1]/div[3]/div[1]/button")
	private WebElement buttonUploadFilesIdentification;

	@FindBy(xpath = "(//*[contains(text(),'Add Proof of Residence Front')]/../..)[1]")
	private WebElement buttonAddProofResidenceFront;

	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[3]/div/div[2]/input[1]")
	private WebElement inputFileAddProofResidenceFront;

	@FindBy(xpath = "(//*[contains(text(),'Add Proof of Residence Back')]/../..)[1]")
	private WebElement buttonAddProofResidenceBack;

	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[3]/div/div[2]/input[2]")
	private WebElement inputFileAddProofResidenceBack;

	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[3]/div/div[1]/button")
	private WebElement buttonUploadFilesResidence;

	// End element set for account holder 1

	// TODO Element set for account holder 2

	@FindBy(xpath = "(//*[@id='docType'])[2]")
	WebElement selectDocumentType2;

	// same 1
	// WebElement optionNation;

	// same 1
	// WebElement optionDriving;

	// same 1
	// WebElement optionPassport;

	@FindBy(xpath = "//*[contains(text(),'ACCOUNT HOLDER 2')]/../../..//*[contains(text(),'Add Driving Licence')]/../..")
	WebElement buttonAddDrivingLicence2;

	@FindBy(xpath = "//*[contains(text(),'ACCOUNT HOLDER 2')]/../../..//*[contains(text(),'Add Driving Licence')]/../../../input")
	WebElement inputFileAddDrivingLicence2;

	// TODO
	@FindBy(xpath = "//*[contains(text(),'ACCOUNT HOLDER 2')]/../../..//*[contains(text(),'Add ID Front')]/../..")
	WebElement buttonAddIdFront2;

	@FindBy(xpath = "//*[@id=\"left-card\"]/div[2]/div[4]/div[3]/div[2]/div[1]/div/input[1]")
	WebElement inputFileAddIdFront2;

	@FindBy(xpath = "//*[contains(text(),'ACCOUNT HOLDER 2')]/../../..//*[contains(text(),'Add ID Back')]/../..")
	WebElement buttonAddIdBack2;

	@FindBy(xpath = "//*[@id=\"left-card\"]/div[2]/div[4]/div[3]/div[2]/div[1]/div/input[2]")
	WebElement inputFileAddIdBack2;

	// 1 *[@id='left-card']/div[2]/div[1]/div[3]/div[1]/button
	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[4]/div[3]/div[1]/button")
	WebElement buttonUploadFilesIdentification2;

	@FindBy(xpath = "//*[contains(text(),'ACCOUNT HOLDER 2')]/../../..//*[contains(text(),'Add Passport')]/../..")
	WebElement buttonAddPassport2;

	@FindBy(xpath = "//*[@id=\"left-card\"]/div[2]/div[4]/div[3]/div[2]/div[1]/div/input")
	WebElement inputFileAddPassport2;

	@FindBy(xpath = "(//*[contains(text(),'Add Proof of Residence Front')]/../..)[2]")
	WebElement buttonAddProofResidenceFront2;
	//
	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[4]/div[5]/div[2]/input[1]")
	WebElement inputFileAddProofResidenceFront2;

	@FindBy(xpath = "(//*[contains(text(),'Add Proof of Residence Back')]/../..)[2]")
	WebElement buttonAddProofResidenceBack2;

	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[4]/div[5]/div[2]/input[2]")
	WebElement inputFileAddProofResidenceBack2;

	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[4]/div[5]/div[1]/button")
	WebElement buttonUploadFilesResidence2;

	// End element set for account holder 2

	// TODO Elemen set for indi

	// same joint
	// private WebElement selectDocumentType;

	// same joint
	// private WebElement optionPassport;

	@FindBy(xpath = "//*[contains(text(),'Add ID Front')]/../..")
	private WebElement buttonAddIdFrontIndividual;

	@FindBy(xpath = "//*[@id=\"left-card\"]/div[2]/div[1]/div[2]/div[2]/div[1]/div/input[1]")
	private WebElement inputFileAddIdFrontIndividual;

	@FindBy(xpath = "//*[contains(text(),'Add ID Back')]/../..")
	private WebElement buttonAddIdBackIndividual;

	@FindBy(xpath = "	//*[@id=\"left-card\"]/div[2]/div[1]/div[2]/div[2]/div[1]/div/input[2]")
	private WebElement inputFileAddIdBackIndividual;

	@FindBy(xpath = "//*[contains(text(),'Add Passport')]/../..")
	private WebElement buttonAddPassport;

	@FindBy(xpath = "//*[contains(text(),'Add Passport')]/../../../input")
	private WebElement inputFileAddPassport;

	@FindBy(xpath = "//*[contains(text(),'colour copy of your Proof of Identification')]/../..//*[contains(text(),'UPLOAD FILES')]/../..")
	private WebElement buttonUploadFilesProofIdentification;

	@FindBy(xpath = "//*[@id='left-card']/div[2]/div[3]/div/div[1]/button")
	private WebElement buttonUploadFilesProofResidence;

	public CorporateDocumentPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public void load() {
		webDriver.get("https://client-area-ui.staging.k8s.fxprimus.tech/en/profile/documents");
		if (isWaitDisplay(Constant.DOCUMENTS)) {
		}
	}

	public void loadCorporate() {
		webDriver.get("https://client-area-ui.staging.k8s.fxprimus.tech/en/profile/corporate-documents");
	}

	public void loadPartnerKYC() {
		webDriver.get("https://partners-area-ui.staging.k8s.fxprimus.tech/en/profile/documents");
	}

	public void fillData(
	// KycDocumentsDto kycDocumentsDto
	) {

//		addFileAndUpload(buttonAddFileAccountOpeningQuestionnaire, inputFileAddFileAccountOpeningQuestionnaire,
//				buttonUploadAccountOpeningQuestionnaire);
//
//		addFileAndUpload(buttonAddFileResolutionAccount, inputFileAddFileResolutionAccount,
//				buttonUploadResolutionAccount);
//		addFileAndUpload(buttonAddFileScannedEquivalent, inputFileAddFileScannedEquivalent,
//				buttonUploadScannedEquivalent);
//		addFileAndUpload(buttonAddFileGoodStanding, inputFileAddFileGoodStanding, buttonUploadGoodStanding);
//		addFileAndUpload(buttonAddFileIncorporation, inputFileAddFileIncorporation, buttonUploadIncorporation);
//		addFileAndUpload(buttonAddFileDirectors, inputFileAddFileDirectors, buttonUploadDirectors);
//		addFileAndUpload(buttonAddFileShareholders, inputFileAddFileShareholders, buttonUploadShareholders);
//		addFileAndUpload(buttonAddFileArticles, inputFileAddFileArticles, buttonUploadArticles);
//		addFileAndUpload(buttonAddFileRegisteredAddress, inputFileAddFileRegisteredAddress,
//				buttonUploadRegisteredAddress);
//		addFileAndUpload(buttonAddFileDeclaration, inputFileAddFileDeclaration, buttonUploadDeclaration);

		click(selectDocumentType);
		click(optionDriving);
		click(buttonAddDrivingLicenceC);
		type(inputFileAddDrivingLicenceC, imagePath);
		click(buttonUploadKycIdentification);
		iwait(999);

		click(buttonAddPorFront);
		type(inputFileAddPorFront, imagePath);

		click(buttonAddPorBack);
		type(inputFileAddPorBack, imagePath);

		click(buttonUploadKycResidence);
		iwait(999);
	}

	void addFileAndUpload(WebElement buttonAddFile, WebElement inputFile, WebElement buttonUpload) {
		click(buttonAddFile);
		type(inputFile, imagePath);
		iwait(555);
		click(buttonUpload);
		iwait(999);
	}

//	@FindBy(xpath = "//*[@id='left-card']/div[1]")
//	WebElement body;

	public void fillDataIndividual() { // And fill Data Corporate

		// PROOF OF IDENTIFICATION
		uploadImageThroughMacosWindow();

		if (onMacSafari) {
			clickJs(buttonAddIdFrontIndividual);
		} else {
			click(buttonAddIdFrontIndividual);
		}
		typeJs(imagePath, inputFileAddIdFrontIndividual);

		iwait(999);

		if (onMacSafari) {
			clickJs(buttonAddIdBackIndividual);
		} else {
			click(buttonAddIdBackIndividual);
		}
		type(inputFileAddIdBackIndividual, imagePath);

		iwait(999);

		if (onMacSafari) {
			clickJs(selectDocumentType);
		} else {
			click(selectDocumentType);
		}
		if (onMacSafari) {
			clickJs(optionPassport);
		} else {
			click(optionPassport);
		}
		click(optionPassport);

		if (onMacSafari) {
			clickJs(buttonAddPassport);
		} else {
			click(buttonAddPassport);
		}
		type(inputFileAddPassport, imagePath);

		if (onMacSafari) {
			clickJs(buttonUploadFilesProofIdentification);
		} else {
			click(buttonUploadFilesProofIdentification);
		}
		iwait(999);

		// PROOF OF RESIDENCE
		if (onMacSafari) {
			clickJs(buttonAddProofResidenceFront);
		} else {
			click(buttonAddProofResidenceFront);
		}
		type(inputFileAddProofResidenceFront, imagePath);

		iwait(999);

		if (onMacSafari) {
			clickJs(buttonAddProofResidenceBack);
		} else {
			click(buttonAddProofResidenceBack);
		}
		type(inputFileAddProofResidenceBack, imagePath);

		if (onMacSafari) {
			clickJs(buttonUploadFilesProofResidence);
		} else {
			click(buttonUploadFilesProofResidence);
		}
		iwait(1999);

	}

	public void fillDataJoit() {
		// joint

		// ACCOUNT HOLDER 1

		// PROOF OF IDENTIFICATION
		click(selectDocumentType);
		click(optionNation);

		click(buttonAddIdFront);
		type(inputFileAddIdFront, imagePath);
		click(buttonUploadFilesIdentification);
		iwait(999);

		click(buttonAddIdBack);
		type(inputFileAddIdBack, imagePath);
		click(buttonUploadFilesIdentification);
		iwait(999);

		click(selectDocumentType);
		click(optionPassport);

		click(buttonAddPassport);
		type(inputFileAddPassport, imagePath);
		click(buttonUploadFilesProofIdentification);
		iwait(999);

		// PROOF OF RESIDENCE
		click(buttonAddProofResidenceFront);
		type(inputFileAddProofResidenceFront, imagePath);
		click(buttonUploadFilesResidence);
		iwait(999);

		click(buttonAddProofResidenceBack);
		type(inputFileAddProofResidenceBack, imagePath);
		click(buttonUploadFilesResidence);
		iwait(999);

		// ACCOUNT HOLDER 2

		// PROOF OF IDENTIFICATION
		// click(selectDocumentType2);

		click(buttonAddIdFront2);
		type(inputFileAddIdFront2, imagePath);
		click(buttonUploadFilesIdentification2);

		click(buttonAddIdBack2);
		type(inputFileAddIdBack2, imagePath);
		click(buttonUploadFilesIdentification2);

		click(selectDocumentType2);
		click(optionPassport);

		click(buttonAddPassport2);
		type(inputFileAddPassport2, imagePath);
		click(buttonUploadFilesIdentification2);
		iwait(999);

		// PROOF OF RESIDENCE
		click(buttonAddProofResidenceFront2);
		type(inputFileAddProofResidenceFront2, imagePath);
		click(buttonUploadFilesResidence2);
		iwait(999);

		click(buttonAddProofResidenceBack2);
		type(inputFileAddProofResidenceBack2, imagePath);
		click(buttonUploadFilesResidence2);

		click(buttonAddProofResidenceBack2);
		type(inputFileAddProofResidenceBack2, imagePath);
		click(buttonUploadFilesResidence2);
		iwait(3000);

	}

	public void fillDataWithImageType(String typeAccount, String imageType) {
//		imagePath = imagePath.replace("png", imageType);
		 System.out.println(imagePath);
		if (typeAccount.equals("Individual")) {
			// PROOF OF IDENTIFICATION
//			uploadImageThroughMacosWindow();
			
			click(buttonAddIdFrontIndividual);
			typeJs(imagePath, inputFileAddIdFrontIndividual);
			iwait(999);
			
			click(buttonAddIdBackIndividual);
			type(inputFileAddIdBackIndividual, imagePath);
//			typeJs(imagePath, inputFileAddIdBackIndividual);
			iwait(999);
			
			click(buttonUploadFilesProofIdentification);
			
			click(selectDocumentType);
			click(optionPassport);
			
			click(buttonAddPassport);
			typeJs(imagePath, inputFileAddPassport);
			click(buttonUploadFilesProofIdentification);
			iwait(999);
			
			// PROOF OF RESIDENCE
			click(buttonAddProofResidenceFront);
			typeJs(imagePath, inputFileAddProofResidenceFront);
			iwait(999);
			
			click(buttonAddProofResidenceBack);
			typeJs(imagePath, inputFileAddProofResidenceBack);
			click(buttonUploadFilesProofResidence);
			iwait(1999);
		} else {
			// joint

			// ACCOUNT HOLDER 1

			// PROOF OF IDENTIFICATION
			click(selectDocumentType);
			click(optionNation);

			click(buttonAddIdFront);
			type(inputFileAddIdFront, imagePath);
			click(buttonUploadFilesIdentification);
			iwait(999);

			click(buttonAddIdBack);
			type(inputFileAddIdBack, imagePath);
			click(buttonUploadFilesIdentification);
			iwait(999);

			click(selectDocumentType);
			click(optionPassport);

			click(buttonAddPassport);
			type(inputFileAddPassport, imagePath);
			click(buttonUploadFilesProofIdentification);
			iwait(999);

			// PROOF OF RESIDENCE
			click(buttonAddProofResidenceFront);
			type(inputFileAddProofResidenceFront, imagePath);
			click(buttonUploadFilesResidence);
			iwait(999);

			click(buttonAddProofResidenceBack);
			type(inputFileAddProofResidenceBack, imagePath);
			click(buttonUploadFilesResidence);
			iwait(999);

			// ACCOUNT HOLDER 2

			// PROOF OF IDENTIFICATION
			// click(selectDocumentType2);

			click(buttonAddIdFront2);
			type(inputFileAddIdFront2, imagePath);
			click(buttonUploadFilesIdentification2);

			click(buttonAddIdBack2);
			type(inputFileAddIdBack2, imagePath);
			click(buttonUploadFilesIdentification2);

			click(selectDocumentType2);
			click(optionPassport);

			click(buttonAddPassport2);
			type(inputFileAddPassport2, imagePath);
			click(buttonUploadFilesIdentification2);
			iwait(999);

			// PROOF OF RESIDENCE
			click(buttonAddProofResidenceFront2);
			type(inputFileAddProofResidenceFront2, imagePath);
			click(buttonUploadFilesResidence2);
			iwait(999);

			click(buttonAddProofResidenceBack2);
			type(inputFileAddProofResidenceBack2, imagePath);
			click(buttonUploadFilesResidence2);

			click(buttonAddProofResidenceBack2);
			type(inputFileAddProofResidenceBack2, imagePath);
			click(buttonUploadFilesResidence2);
			iwait(3000);
		}
	}

}
