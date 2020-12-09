from collections import namedtuple
from src.opcbiz.fxprimus.dto import ExcelFieldDto


class NCB530Dto:
    def __init__(self, id, title, name, payment_method, payment_channel, virtual, mt4_id, referral_id, mt4_currency,
                 amount, psp_currency, conversion_rate, psp_amount, additional_psp_parameters):
        self.__id = id
        self.__title = title
        self.__name = name
        self.__payment_method = payment_method
        self.__payment_channel = payment_channel
        self.__virtual = virtual
        self.__mt4_id = mt4_id
        self.__referral_id = referral_id
        self.__mt4_currency = mt4_currency
        self.__amount = amount
        self.__psp_currency = psp_currency
        self.__conversion_rate = conversion_rate
        self.__psp_amount = psp_amount
        self.__additional_psp_parameters = additional_psp_parameters

    # getter method
    def get_id(self):
        return self.__id

    def get_title(self):
        return self.__title

    def get_name(self):
        return self.__name

    def get_payment_method(self):
        return self.__payment_method

    def get_payment_channel(self):
        return self.__payment_channel

    def get_virtual(self):
        return self.__virtual

    def get_mt4_id(self):
        return self.__mt4_id

    def get_referral_id(self):
        return self.__referral_id

    def get_mt4_currency(self):
        return self.__mt4_currency

    def get_amount(self):
        return self.__amount

    def get_psp_currency(self):
        return self.__psp_currency

    def get_conversion_rate(self):
        return self.__conversion_rate

    def get_psp_amount(self):
        return self.__psp_amount

    def get_additional_psp_parameters(self):
        return self.__additional_psp_parameters

    # setter method
    def set_id(self, id):
        self.__id = id

    def set_title(self, title):
        self.__title = title

    def set_name(self, name):
        self.__name = name

    def set_payment_method(self, payment_method):
        self.__payment_method = payment_method

    def set_payment_channel(self, payment_channel):
        self.__payment_channel = payment_channel

    def set_virtual(self, virtual):
        self.__virtual = virtual

    def set_mt4_id(self, mt4_id):
        self.__mt4_id = mt4_id

    def set_referral_id(self, referral_id):
        self.__referral_id = referral_id

    def set_mt4_currency(self, mt4_currency):
        self.__mt4_currency = mt4_currency

    def set_amount(self, amount):
        self.__amount = amount

    def set_psp_currency(self, psp_currency):
        self.__psp_currency = psp_currency

    def set_conversion_rate(self, conversion_rate):
        self.__conversion_rate = conversion_rate

    def set_psp_amount(self, psp_amount):
        self.__psp_amount = psp_amount

    def set_additional_psp_parameters(self, additional_psp_parameters):
        self.__additional_psp_parameters = additional_psp_parameters

    def custom_dto_decoder(self):
        return namedtuple('NCB530Dto', self.keys())(*self.values())

    @staticmethod
    def excel_template():
        excel_field_dto_list = [ExcelFieldDto.ExcelFieldDto('ID', 'id'),
                                ExcelFieldDto.ExcelFieldDto('TITLE', 'title'),
                                ExcelFieldDto.ExcelFieldDto('NAME', 'name'),
                                ExcelFieldDto.ExcelFieldDto('PAYMENT_METHOD', 'payment_method'),
                                ExcelFieldDto.ExcelFieldDto('PAYMENT_CHANNEL', 'payment_channel'),
                                ExcelFieldDto.ExcelFieldDto('VIRTUAL', 'virtual'),
                                ExcelFieldDto.ExcelFieldDto('MT4_ID', 'mt4_id'),
                                ExcelFieldDto.ExcelFieldDto('REFERRAL_ID', 'referral_id'),
                                ExcelFieldDto.ExcelFieldDto('MT4_CURRENCY', 'mt4_currency'),
                                ExcelFieldDto.ExcelFieldDto('AMOUNT', 'amount'),
                                ExcelFieldDto.ExcelFieldDto('PSP_CURRENCY', 'psp_currency'),
                                ExcelFieldDto.ExcelFieldDto('CONVERSION_RATE', 'conversion_rate'),
                                ExcelFieldDto.ExcelFieldDto('PSP_AMOUNT', 'psp_amount'),
                                ExcelFieldDto.ExcelFieldDto('ADDITIONAL_PSP_PARAMETERS', 'additional_psp_parameters')]
        return excel_field_dto_list

# if __name__ == '__main__':
#     x = NCB530Dto()
#     x.get_addition_psp_parameters()
