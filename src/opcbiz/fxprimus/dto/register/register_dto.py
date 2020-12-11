from collections import namedtuple
from src.opcbiz.fxprimus.dto import excel_field_dto


class RegisterDto:
    def __init__(self, id, title, account_type, first_name, last_name, email, country, phone_number, password,
                 checkbox_agreement, checkbox_kid, checkbox_marketing, checkbox_understand):
        self.id = id
        self.title = title

        self.account_type = account_type
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.country = country
        self.phone_number = phone_number
        self.password = password

        self.checkbox_agreement = checkbox_agreement
        self.checkbox_kid = checkbox_kid
        self.checkbox_marketing = checkbox_marketing
        self.checkbox_understand = checkbox_understand

    def custom_dto_decoder(self):
        return namedtuple('RegisterDto', self.keys())(*self.values())

    @staticmethod
    def set_email(self, email):
        self.email = email

    @staticmethod
    def excel_template():
        excel_field_dto_list = [excel_field_dto.ExcelFieldDto('ID', 'id'),
                                excel_field_dto.ExcelFieldDto('TITLE', 'title'),
                                excel_field_dto.ExcelFieldDto('ACCOUNT_TYPE', 'account_type'),
                                excel_field_dto.ExcelFieldDto('FIRST_NAME', 'first_name'),
                                excel_field_dto.ExcelFieldDto('LAST_NAME', 'last_name'),
                                excel_field_dto.ExcelFieldDto('EMAIL', 'email'),
                                excel_field_dto.ExcelFieldDto('COUNTRY', 'country'),
                                excel_field_dto.ExcelFieldDto('PHONE_NUMBER', 'phone_number'),
                                excel_field_dto.ExcelFieldDto('PASSWORD', 'password'),

                                excel_field_dto.ExcelFieldDto('CHECKBOX_AGREEMENT', 'checkbox_agreement'),
                                excel_field_dto.ExcelFieldDto('CHECKBOX_KID', 'checkbox_kid'),
                                excel_field_dto.ExcelFieldDto('CHECKBOX_MARKETING', 'checkbox_marketing'),
                                excel_field_dto.ExcelFieldDto('CHECKBOX_UNDERSTAND', 'checkbox_understand')]
        return excel_field_dto_list

