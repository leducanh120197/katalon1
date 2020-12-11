from collections import namedtuple
from src.opcbiz.fxprimus.dto import excel_field_dto
from src.opcbiz.fxprimus.utils.excel_utils import ExcelUtils


class AccountDto:
    def __init__(self, id, email, pass_word,
                 account_type, account_status):
        self.id = id
        self.email = email
        self.pass_word = pass_word
        self.account_type = account_type
        self.account_status = account_status

    # getter method
    def get_id(self):
        return self.id

    def get_email(self):
        return self.email

    def get_pass_word(self):
        return self.pass_word

    def get_account_type(self):
        return self.account_type

    def get_account_status(self):
        return self.account_status

    # setter method
    def set_id(self, id):
        self.id = id

    def set_email(self, email):
        self.email = email

    def set_pass_word(self, pass_word):
        self.pass_word = pass_word

    def set_account_type(self, account_type):
        self.account_type = account_type

    def set_account_status(self, account_status):
        self.account_status = account_status

    def custom_dto_decoder(self):
        return namedtuple('AccountDto', self.keys())(*self.values())

    @staticmethod
    def excel_template():
        excel_field_dto_list = [excel_field_dto.ExcelFieldDto('ID', 'id'),
                                excel_field_dto.ExcelFieldDto('EMAIL', 'email'),
                                excel_field_dto.ExcelFieldDto('PASS_WORD', 'pass_word'),
                                excel_field_dto.ExcelFieldDto('ACCOUNT_TYPE', 'account_type'),
                                excel_field_dto.ExcelFieldDto('ACCOUNT_STATUS', 'account_status')]
        return excel_field_dto_list
