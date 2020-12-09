from collections import namedtuple
from src.opcbiz.fxprimus.dto import ExcelFieldDto


class SubFiledDto:
    def __init__(self, id, data):
        self.id = id
        self.data = data

    # getter method
    def get_id(self):
        return self.id

    def get_data(self):
        return self.data

    # setter method
    def set_id(self, id):
        self.id = id

    def set_data(self, data):
        self.data = data

    def custom_dto_decoder(self):
        return namedtuple('FieldForMixDto', self.keys())(*self.values())

    @staticmethod
    def excel_template():
        excel_field_dto_list = [ExcelFieldDto.ExcelFieldDto('ID', 'id'),
                                ExcelFieldDto.ExcelFieldDto('DATA', 'data')]
        return excel_field_dto_list
