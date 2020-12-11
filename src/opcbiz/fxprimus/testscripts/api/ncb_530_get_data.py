from src.opcbiz.fxprimus.dto.api import ncb_530_dto, sub_filed_dto
from src.opcbiz.fxprimus.utils.excel_utils import ExcelUtils as EU
from src.opcbiz.fxprimus.testscripts.base_test import BaseTest

class GetData:
    # @staticmethod
    def get_all_data_sheet_from_excel(self):
        excel_path = BaseTest.create_file_path_input('NCB_530.xlsx')

        list_ncb_530_dto = EU.get_data_from_excel(excel_path, "NCB_530", ncb_530_dto.NCB530Dto.excel_template(),
                                                  ncb_530_dto.NCB530Dto)
        name = EU.get_data_from_excel(excel_path, "NAME", sub_filed_dto.SubFiledDto.excel_template(),
                                      sub_filed_dto.SubFiledDto)
        payment_method = EU.get_data_from_excel(excel_path, "PAYMENT_METHOD",
                                                sub_filed_dto.SubFiledDto.excel_template(), sub_filed_dto.SubFiledDto)
        payment_channel = EU.get_data_from_excel(excel_path, "PAYMENT_CHANNEL",
                                                 sub_filed_dto.SubFiledDto.excel_template(), sub_filed_dto.SubFiledDto)
        virtual = EU.get_data_from_excel(excel_path, "VIRTUAL", sub_filed_dto.SubFiledDto.excel_template(),
                                         sub_filed_dto.SubFiledDto)
        mt4_id = EU.get_data_from_excel(excel_path, "MT4_ID", sub_filed_dto.SubFiledDto.excel_template(),
                                        sub_filed_dto.SubFiledDto)
        referral_id = EU.get_data_from_excel(excel_path, "REFERRAL_ID", sub_filed_dto.SubFiledDto.excel_template(),
                                             sub_filed_dto.SubFiledDto)
        mt4_currency = EU.get_data_from_excel(excel_path, "MT4_CURRENCY", sub_filed_dto.SubFiledDto.excel_template(),
                                              sub_filed_dto.SubFiledDto)
        amount = EU.get_data_from_excel(excel_path, "AMOUNT", sub_filed_dto.SubFiledDto.excel_template(),
                                        sub_filed_dto.SubFiledDto)
        psp_currency = EU.get_data_from_excel(excel_path, "PSP_CURRENCY", sub_filed_dto.SubFiledDto.excel_template(),
                                              sub_filed_dto.SubFiledDto)
        conversion_rate = EU.get_data_from_excel(excel_path, "CONVERSION_RATE",
                                                 sub_filed_dto.SubFiledDto.excel_template(), sub_filed_dto.SubFiledDto)
        psp_amount = EU.get_data_from_excel(excel_path, "PSP_AMOUNT", sub_filed_dto.SubFiledDto.excel_template(),
                                            sub_filed_dto.SubFiledDto)
        additional_psp_parameters = EU.get_data_from_excel(excel_path, "ADDITIONAL_PSP_PARAMETERS",
                                                           sub_filed_dto.SubFiledDto.excel_template(),
                                                           sub_filed_dto.SubFiledDto)
        sheets = {"list_ncb_530_dto": list_ncb_530_dto,
                  "name": name,
                  "payment_method": payment_method,
                  "payment_channel": payment_channel,
                  "virtual": virtual,
                  "mt4_id": mt4_id,
                  "referral_id": referral_id,
                  "mt4_currency": mt4_currency,
                  "amount": amount,
                  "psp_currency": psp_currency,
                  "conversion_rate": conversion_rate,
                  "psp_amount": psp_amount,
                  "additional_psp_parameters": additional_psp_parameters}
        return sheets

    def get_list_value_from_sheet(self, ids_need_get, a_sheet):
        list_value = []
        ids_need_get = str(ids_need_get)
        if ids_need_get == 'NULL':
            list_value.append('NULL')
            return list_value
        elif ids_need_get == 'ALL':
            for row in a_sheet:
                list_value.append(row.data)
            return list_value
        elif ids_need_get.__contains__('/'):
            ids = ids_need_get.split('/')
            for id in ids:
                for row in a_sheet:
                    if str(row.id) == id:
                        list_value.append(row.data)
            return list_value
        else:
            for row in a_sheet:
                if str(row.id) == ids_need_get:
                    list_value.append(row.data)
            return list_value

    def get_matrix_from_all_data_sheet(self, row_main, data_sheets):
        list_id = [row_main.id]
        list_title = [row_main.title]
        list_name_values = self.get_list_value_from_sheet(row_main.name, data_sheets['name'])
        list_payment_method_values = self.get_list_value_from_sheet(row_main.payment_method,
                                                                    data_sheets['payment_method'])
        list_payment_channel_values = self.get_list_value_from_sheet(row_main.payment_channel,
                                                                     data_sheets['payment_channel'])
        list_virtual_values = self.get_list_value_from_sheet(row_main.virtual, data_sheets['virtual'])
        list_mt4_id_values = self.get_list_value_from_sheet(row_main.mt4_id, data_sheets['mt4_id'])
        list_referral_id_values = self.get_list_value_from_sheet(row_main.referral_id, data_sheets['referral_id'])
        list_mt4_currency_values = self.get_list_value_from_sheet(row_main.mt4_currency, data_sheets['mt4_currency'])
        list_amount_values = self.get_list_value_from_sheet(row_main.amount, data_sheets['amount'])
        list_psp_currency_values = self.get_list_value_from_sheet(row_main.psp_currency, data_sheets['psp_currency'])
        list_conversion_rate_values = self.get_list_value_from_sheet(row_main.conversion_rate,
                                                                     data_sheets['conversion_rate'])
        list_psp_amount_values = self.get_list_value_from_sheet(row_main.psp_amount, data_sheets['psp_amount'])
        list_additional_psp_parameters_values = self.get_list_value_from_sheet(row_main.additional_psp_parameters,
                                                                               data_sheets['additional_psp_parameters'])

        matrix = [list_id, list_title, list_name_values, list_payment_method_values, list_payment_channel_values,
                  list_virtual_values, list_mt4_id_values, list_referral_id_values, list_mt4_currency_values,
                  list_amount_values, list_psp_currency_values, list_conversion_rate_values, list_psp_amount_values,
                  list_additional_psp_parameters_values]
        return matrix

    # @staticmethod
    def convert_data(self, data_sheets):
        list_test_cases = []
        for row_main in data_sheets['list_ncb_530_dto']:
            # print(row_main)
            matrix = self.get_matrix_from_all_data_sheet(row_main, data_sheets)
            list_test_case_per_row_main = EU.convert_two_dimensional_to_one_dimensional(matrix)
            list_test_cases += list_test_case_per_row_main
        return list_test_cases

    @staticmethod
    def get_test_cases():
        get_data = GetData()
        data_sheet_dict = get_data.get_all_data_sheet_from_excel()
        list_test_cases = get_data.convert_data(data_sheet_dict)
        test_cases = []
        for test_case in list_test_cases:
            test_cases.append(ncb_530_dto.NCB530Dto(test_case[0], test_case[1], test_case[2], test_case[3], test_case[4],
                                                    test_case[5], test_case[6], test_case[7], test_case[8], test_case[9],
                                                    test_case[10], test_case[11], test_case[12], test_case[13]))
        return test_cases

# if __name__ == "__main__":
#     x = GetData.get_test_cases()
#     print(x[0].)
