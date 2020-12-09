package com.opcbiz.fxprimus.dto.pendCompleteRegis;

import java.util.ArrayList;
import java.util.List;

import com.opcbiz.fxprimus.dto.ExcelFieldDto;

public class KycDocumentsDto {
	String id;
	String title;
	String link;
	String documentType;
	String addIdFrontValidation;
	String addIdBack;
	String addDrivingLicence;
	String addPassport;
	String identificationUploadFiles;
	String identificationUploadFilesValidation;
	String addProofOfResidenceFront;
	String addProofOfResidenceBack;
	String addPorFront;
	String addPorBack;
	String residenceUploadFiles;
	String residenceUploadFilesValidation;
	String documentTypeAcc2;
	String addIdFrontValidationAcc2;
	String addIdBackAcc2;
	String addDrivingLicenceAcc2;
	String addPassportAcc2;
	String identificationUploadFilesAcc2;
	String identificationUploadFilesValidationAcc2;
	String addProofOfResidenceFrontAcc2;
	String addProofOfResidenceBackAcc2;
	String residenceUploadFilesAcc2;
	String residenceUploadFilesValidationAcc2;
	String opqAddYourFiles;
	String traacAddYourFiles;
	String auditReportAddYourFiles;
	String certificateOfIncumbencyAddYourFiles;
	String certificateOfIncorporationAddYourFiles;
	String certificateOfDirectorsAddYourFiles;
	String certificateOfShareAddYourFiles;
	String memorandumAndArticlesAddYourFiles;
	String certificateOfRegisAddYourFiles;
	String declarationOfTrustAddYourFiles;
	String uploadButton;
	String uploadButtonValidation;
	String dashboardIconValidation;
	String expected;

	public static List<ExcelFieldDto> excelTemplate() {
		List<ExcelFieldDto> excelFieldDtoList = new ArrayList<ExcelFieldDto>();

		excelFieldDtoList.add(new ExcelFieldDto("ID", "id", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TITLE", "title", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("LINK", "link", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("DOCUMENT_TYPE", "documentType", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADD_ID_FRONT_VALIDATION", "addIdFrontValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADD_ID_BACK", "addIdBack", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("ADD_DRIVING_LICENCE", "addDrivingLicence", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ADD_PASSPORT", "addPassport", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("IDENTIFICATION_UPLOAD_FILES", "identificationUploadFiles",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("IDENTIFICATION_UPLOAD_FILES_VALIDATION",
				"identificationUploadFilesValidation", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADD_PROOF_OF_RESIDENCE_FRONT", "addProofOfResidenceFront",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADD_PROOF_OF_RESIDENCE_BACK", "addProofOfResidenceBack",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ADD_POR_FRONT", "addPorFront", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADD_POR_BACK", "addPorBack", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("RESIDENCE_UPLOAD_FILES", "residenceUploadFiles",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("RESIDENCE_UPLOAD_FILES_VALIDATION", "residenceUploadFilesValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("DOCUMENT_TYPE_ACC2", "documentTypeAcc2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADD_ID_FRONT_VALIDATION_ACC2", "addIdFrontValidationAcc2",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("ADD_ID_BACK_ACC2", "addIdBackAcc2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADD_DRIVING_LICENCE_ACC2", "addDrivingLicenceAcc2",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("ADD_PASSPORT_ACC2", "addPassportAcc2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("IDENTIFICATION_UPLOAD_FILES_ACC2", "identificationUploadFilesAcc2",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("IDENTIFICATION_UPLOAD_FILES_VALIDATION_ACC2",
				"identificationUploadFilesValidationAcc2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADD_PROOF_OF_RESIDENCE_FRONT_ACC2", "addProofOfResidenceFrontAcc2",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("ADD_PROOF_OF_RESIDENCE_BACK_ACC2", "addProofOfResidenceBackAcc2",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("RESIDENCE_UPLOAD_FILES_ACC2", "residenceUploadFilesAcc2",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("RESIDENCE_UPLOAD_FILES_VALIDATION_ACC2",
				"residenceUploadFilesValidationAcc2", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(
				new ExcelFieldDto("OPQ_ADD_YOUR_FILES", "opqAddYourFiles", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("TRAAC_ADD_YOUR_FILES", "traacAddYourFiles",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("AUDIT_REPORT_ADD_YOUR_FILES", "auditReportAddYourFiles",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CERTIFICATE_OF_INCUMBENCY_ADD_YOUR_FILES",
				"certificateOfIncumbencyAddYourFiles", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CERTIFICATE_OF_INCORPORATION_ADD_YOUR_FILES",
				"certificateOfIncorporationAddYourFiles", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CERTIFICATE_OF_DIRECTORS_ADD_YOUR_FILES",
				"certificateOfDirectorsAddYourFiles", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CERTIFICATE_OF_SHARE_ADD_YOUR_FILES", "certificateOfShareAddYourFiles",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("MEMORANDUM_AND_ARTICLES_ADD_YOUR_FILES",
				"memorandumAndArticlesAddYourFiles", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("CERTIFICATE_OF_REGIS_ADD_YOUR_FILES", "certificateOfRegisAddYourFiles",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("DECLARATION_OF_TRUST_ADD_YOUR_FILES", "declarationOfTrustAddYourFiles",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList
				.add(new ExcelFieldDto("UPLOAD_BUTTON", "uploadButton", ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("UPLOAD_BUTTON_VALIDATION", "uploadButtonValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("DASHBOARD_ICON_VALIDATION", "dashboardIconValidation",
				ExcelFieldDto.DataType.STRING, "STRING"));
		excelFieldDtoList.add(new ExcelFieldDto("EXPECTED", "expected", ExcelFieldDto.DataType.STRING, "STRING"));

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getAddIdFrontValidation() {
		return addIdFrontValidation;
	}

	public void setAddIdFrontValidation(String addIdFrontValidation) {
		this.addIdFrontValidation = addIdFrontValidation;
	}

	public String getAddIdBack() {
		return addIdBack;
	}

	public void setAddIdBack(String addIdBack) {
		this.addIdBack = addIdBack;
	}

	public String getAddDrivingLicence() {
		return addDrivingLicence;
	}

	public void setAddDrivingLicence(String addDrivingLicence) {
		this.addDrivingLicence = addDrivingLicence;
	}

	public String getAddPassport() {
		return addPassport;
	}

	public void setAddPassport(String addPassport) {
		this.addPassport = addPassport;
	}

	public String getIdentificationUploadFiles() {
		return identificationUploadFiles;
	}

	public void setIdentificationUploadFiles(String identificationUploadFiles) {
		this.identificationUploadFiles = identificationUploadFiles;
	}

	public String getIdentificationUploadFilesValidation() {
		return identificationUploadFilesValidation;
	}

	public void setIdentificationUploadFilesValidation(String identificationUploadFilesValidation) {
		this.identificationUploadFilesValidation = identificationUploadFilesValidation;
	}

	public String getAddProofOfResidenceFront() {
		return addProofOfResidenceFront;
	}

	public void setAddProofOfResidenceFront(String addProofOfResidenceFront) {
		this.addProofOfResidenceFront = addProofOfResidenceFront;
	}

	public String getAddProofOfResidenceBack() {
		return addProofOfResidenceBack;
	}

	public void setAddProofOfResidenceBack(String addProofOfResidenceBack) {
		this.addProofOfResidenceBack = addProofOfResidenceBack;
	}

	public String getAddPorFront() {
		return addPorFront;
	}

	public void setAddPorFront(String addPorFront) {
		this.addPorFront = addPorFront;
	}

	public String getAddPorBack() {
		return addPorBack;
	}

	public void setAddPorBack(String addPorBack) {
		this.addPorBack = addPorBack;
	}

	public String getResidenceUploadFiles() {
		return residenceUploadFiles;
	}

	public void setResidenceUploadFiles(String residenceUploadFiles) {
		this.residenceUploadFiles = residenceUploadFiles;
	}

	public String getResidenceUploadFilesValidation() {
		return residenceUploadFilesValidation;
	}

	public void setResidenceUploadFilesValidation(String residenceUploadFilesValidation) {
		this.residenceUploadFilesValidation = residenceUploadFilesValidation;
	}

	public String getDocumentTypeAcc2() {
		return documentTypeAcc2;
	}

	public void setDocumentTypeAcc2(String documentTypeAcc2) {
		this.documentTypeAcc2 = documentTypeAcc2;
	}

	public String getAddIdFrontValidationAcc2() {
		return addIdFrontValidationAcc2;
	}

	public void setAddIdFrontValidationAcc2(String addIdFrontValidationAcc2) {
		this.addIdFrontValidationAcc2 = addIdFrontValidationAcc2;
	}

	public String getAddIdBackAcc2() {
		return addIdBackAcc2;
	}

	public void setAddIdBackAcc2(String addIdBackAcc2) {
		this.addIdBackAcc2 = addIdBackAcc2;
	}

	public String getAddDrivingLicenceAcc2() {
		return addDrivingLicenceAcc2;
	}

	public void setAddDrivingLicenceAcc2(String addDrivingLicenceAcc2) {
		this.addDrivingLicenceAcc2 = addDrivingLicenceAcc2;
	}

	public String getAddPassportAcc2() {
		return addPassportAcc2;
	}

	public void setAddPassportAcc2(String addPassportAcc2) {
		this.addPassportAcc2 = addPassportAcc2;
	}

	public String getIdentificationUploadFilesAcc2() {
		return identificationUploadFilesAcc2;
	}

	public void setIdentificationUploadFilesAcc2(String identificationUploadFilesAcc2) {
		this.identificationUploadFilesAcc2 = identificationUploadFilesAcc2;
	}

	public String getIdentificationUploadFilesValidationAcc2() {
		return identificationUploadFilesValidationAcc2;
	}

	public void setIdentificationUploadFilesValidationAcc2(String identificationUploadFilesValidationAcc2) {
		this.identificationUploadFilesValidationAcc2 = identificationUploadFilesValidationAcc2;
	}

	public String getAddProofOfResidenceFrontAcc2() {
		return addProofOfResidenceFrontAcc2;
	}

	public void setAddProofOfResidenceFrontAcc2(String addProofOfResidenceFrontAcc2) {
		this.addProofOfResidenceFrontAcc2 = addProofOfResidenceFrontAcc2;
	}

	public String getAddProofOfResidenceBackAcc2() {
		return addProofOfResidenceBackAcc2;
	}

	public void setAddProofOfResidenceBackAcc2(String addProofOfResidenceBackAcc2) {
		this.addProofOfResidenceBackAcc2 = addProofOfResidenceBackAcc2;
	}

	public String getResidenceUploadFilesAcc2() {
		return residenceUploadFilesAcc2;
	}

	public void setResidenceUploadFilesAcc2(String residenceUploadFilesAcc2) {
		this.residenceUploadFilesAcc2 = residenceUploadFilesAcc2;
	}

	public String getResidenceUploadFilesValidationAcc2() {
		return residenceUploadFilesValidationAcc2;
	}

	public void setResidenceUploadFilesValidationAcc2(String residenceUploadFilesValidationAcc2) {
		this.residenceUploadFilesValidationAcc2 = residenceUploadFilesValidationAcc2;
	}

	public String getOpqAddYourFiles() {
		return opqAddYourFiles;
	}

	public void setOpqAddYourFiles(String opqAddYourFiles) {
		this.opqAddYourFiles = opqAddYourFiles;
	}

	public String getTraacAddYourFiles() {
		return traacAddYourFiles;
	}

	public void setTraacAddYourFiles(String traacAddYourFiles) {
		this.traacAddYourFiles = traacAddYourFiles;
	}

	public String getAuditReportAddYourFiles() {
		return auditReportAddYourFiles;
	}

	public void setAuditReportAddYourFiles(String auditReportAddYourFiles) {
		this.auditReportAddYourFiles = auditReportAddYourFiles;
	}

	public String getCertificateOfIncumbencyAddYourFiles() {
		return certificateOfIncumbencyAddYourFiles;
	}

	public void setCertificateOfIncumbencyAddYourFiles(String certificateOfIncumbencyAddYourFiles) {
		this.certificateOfIncumbencyAddYourFiles = certificateOfIncumbencyAddYourFiles;
	}

	public String getCertificateOfIncorporationAddYourFiles() {
		return certificateOfIncorporationAddYourFiles;
	}

	public void setCertificateOfIncorporationAddYourFiles(String certificateOfIncorporationAddYourFiles) {
		this.certificateOfIncorporationAddYourFiles = certificateOfIncorporationAddYourFiles;
	}

	public String getCertificateOfDirectorsAddYourFiles() {
		return certificateOfDirectorsAddYourFiles;
	}

	public void setCertificateOfDirectorsAddYourFiles(String certificateOfDirectorsAddYourFiles) {
		this.certificateOfDirectorsAddYourFiles = certificateOfDirectorsAddYourFiles;
	}

	public String getCertificateOfShareAddYourFiles() {
		return certificateOfShareAddYourFiles;
	}

	public void setCertificateOfShareAddYourFiles(String certificateOfShareAddYourFiles) {
		this.certificateOfShareAddYourFiles = certificateOfShareAddYourFiles;
	}

	public String getMemorandumAndArticlesAddYourFiles() {
		return memorandumAndArticlesAddYourFiles;
	}

	public void setMemorandumAndArticlesAddYourFiles(String memorandumAndArticlesAddYourFiles) {
		this.memorandumAndArticlesAddYourFiles = memorandumAndArticlesAddYourFiles;
	}

	public String getCertificateOfRegisAddYourFiles() {
		return certificateOfRegisAddYourFiles;
	}

	public void setCertificateOfRegisAddYourFiles(String certificateOfRegisAddYourFiles) {
		this.certificateOfRegisAddYourFiles = certificateOfRegisAddYourFiles;
	}

	public String getDeclarationOfTrustAddYourFiles() {
		return declarationOfTrustAddYourFiles;
	}

	public void setDeclarationOfTrustAddYourFiles(String declarationOfTrustAddYourFiles) {
		this.declarationOfTrustAddYourFiles = declarationOfTrustAddYourFiles;
	}

	public String getUploadButton() {
		return uploadButton;
	}

	public void setUploadButton(String uploadButton) {
		this.uploadButton = uploadButton;
	}

	public String getUploadButtonValidation() {
		return uploadButtonValidation;
	}

	public void setUploadButtonValidation(String uploadButtonValidation) {
		this.uploadButtonValidation = uploadButtonValidation;
	}

	public String getDashboardIconValidation() {
		return dashboardIconValidation;
	}

	public void setDashboardIconValidation(String dashboardIconValidation) {
		this.dashboardIconValidation = dashboardIconValidation;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public KycDocumentsDto() {
		super();
	}

	public KycDocumentsDto(String id, String title, String link, String documentType, String addIdFrontValidation,
			String addIdBack, String addDrivingLicence, String addPassport, String identificationUploadFiles,
			String identificationUploadFilesValidation, String addProofOfResidenceFront, String addProofOfResidenceBack,
			String addPorFront, String addPorBack, String residenceUploadFiles, String residenceUploadFilesValidation,
			String documentTypeAcc2, String addIdFrontValidationAcc2, String addIdBackAcc2,
			String addDrivingLicenceAcc2, String addPassportAcc2, String identificationUploadFilesAcc2,
			String identificationUploadFilesValidationAcc2, String addProofOfResidenceFrontAcc2,
			String addProofOfResidenceBackAcc2, String residenceUploadFilesAcc2,
			String residenceUploadFilesValidationAcc2, String opqAddYourFiles, String traacAddYourFiles,
			String auditReportAddYourFiles, String certificateOfIncumbencyAddYourFiles,
			String certificateOfIncorporationAddYourFiles, String certificateOfDirectorsAddYourFiles,
			String certificateOfShareAddYourFiles, String memorandumAndArticlesAddYourFiles,
			String certificateOfRegisAddYourFiles, String declarationOfTrustAddYourFiles, String uploadButton,
			String uploadButtonValidation, String dashboardIconValidation, String expected) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.documentType = documentType;
		this.addIdFrontValidation = addIdFrontValidation;
		this.addIdBack = addIdBack;
		this.addDrivingLicence = addDrivingLicence;
		this.addPassport = addPassport;
		this.identificationUploadFiles = identificationUploadFiles;
		this.identificationUploadFilesValidation = identificationUploadFilesValidation;
		this.addProofOfResidenceFront = addProofOfResidenceFront;
		this.addProofOfResidenceBack = addProofOfResidenceBack;
		this.addPorFront = addPorFront;
		this.addPorBack = addPorBack;
		this.residenceUploadFiles = residenceUploadFiles;
		this.residenceUploadFilesValidation = residenceUploadFilesValidation;
		this.documentTypeAcc2 = documentTypeAcc2;
		this.addIdFrontValidationAcc2 = addIdFrontValidationAcc2;
		this.addIdBackAcc2 = addIdBackAcc2;
		this.addDrivingLicenceAcc2 = addDrivingLicenceAcc2;
		this.addPassportAcc2 = addPassportAcc2;
		this.identificationUploadFilesAcc2 = identificationUploadFilesAcc2;
		this.identificationUploadFilesValidationAcc2 = identificationUploadFilesValidationAcc2;
		this.addProofOfResidenceFrontAcc2 = addProofOfResidenceFrontAcc2;
		this.addProofOfResidenceBackAcc2 = addProofOfResidenceBackAcc2;
		this.residenceUploadFilesAcc2 = residenceUploadFilesAcc2;
		this.residenceUploadFilesValidationAcc2 = residenceUploadFilesValidationAcc2;
		this.opqAddYourFiles = opqAddYourFiles;
		this.traacAddYourFiles = traacAddYourFiles;
		this.auditReportAddYourFiles = auditReportAddYourFiles;
		this.certificateOfIncumbencyAddYourFiles = certificateOfIncumbencyAddYourFiles;
		this.certificateOfIncorporationAddYourFiles = certificateOfIncorporationAddYourFiles;
		this.certificateOfDirectorsAddYourFiles = certificateOfDirectorsAddYourFiles;
		this.certificateOfShareAddYourFiles = certificateOfShareAddYourFiles;
		this.memorandumAndArticlesAddYourFiles = memorandumAndArticlesAddYourFiles;
		this.certificateOfRegisAddYourFiles = certificateOfRegisAddYourFiles;
		this.declarationOfTrustAddYourFiles = declarationOfTrustAddYourFiles;
		this.uploadButton = uploadButton;
		this.uploadButtonValidation = uploadButtonValidation;
		this.dashboardIconValidation = dashboardIconValidation;
		this.expected = expected;
	}
}
