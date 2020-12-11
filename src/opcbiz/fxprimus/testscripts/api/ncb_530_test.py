import unittest
import requests
import json

from src.opcbiz.fxprimus.testscripts.base_test import BaseTest
from src.opcbiz.fxprimus.testscripts.api.ncb_530_get_data import GetData
from src.opcbiz.fxprimus.constant.url_constant import UrlConstant
from src.opcbiz.fxprimus.utils.excel_utils import ExcelUtils

from src.opcbiz.fxprimus.dto.api.ncb_530_dto import NCB530Dto


class RegisterTest(unittest.TestCase, BaseTest):
    test_cases: list
    test_results: list
    start: int
    end: int

    def create_payload(self, dto):
        dto_dict = {"name": dto.get_name(),
                    "payment_method": dto.get_payment_method(),
                    "payment_channel": dto.get_payment_channel(),
                    "virtual": dto.get_virtual(),
                    "mt4_id": dto.get_mt4_id(),
                    "referral_id": dto.get_referral_id(),
                    "mt4_currency": dto.get_mt4_currency(),
                    "amount": dto.get_amount(),
                    "psp_currency": dto.get_psp_currency(),
                    "conversion_rate": dto.get_conversion_rate(),
                    "psp_amount": dto.get_psp_amount()
                    }
        add = {"additional_psp_parameters": dto.get_additional_psp_parameters()}

        payload = json.dumps(dto_dict)
        return payload

    def create_result_for_excel(self, test_case, response, result):
        result = [test_case.get_id(), test_case.get_title(), test_case.get_name(), test_case.get_payment_method(),
                  test_case.get_payment_channel(), test_case.get_virtual(), test_case.get_mt4_id(),
                  test_case.get_referral_id(), test_case.get_mt4_currency(), test_case.get_amount(),
                  test_case.get_psp_currency(), test_case.get_conversion_rate(), test_case.get_psp_amount(),
                  test_case.get_additional_psp_parameters(), response, result]
        return result

    def export_report(self, results):
        file_path = self.create_file_path_result("NCB_530_report_" + str(start) + "_" + str(end) + ".xls")
        sheet_name = "Test result"
        print(sheet_name)
        ExcelUtils.export_report(results, file_path, sheet_name)

    def setUp(self):
        print("setUp")
        get_data = GetData()
        global test_cases
        global test_results
        global start
        global end

        test_cases = get_data.get_test_cases()
        test_results = []
        start = 0
        end = 3000

    def test_deposit_request_api(self):
        print("test_deposit_request_api")

        token = self.get_token()
        bearer_auth = "Bearer " + BaseTest.token
        headers = {"Authorization": bearer_auth}
        for num_test_case, test_case in enumerate(test_cases):
            if num_test_case not in range(start, end):
                break
            # print(num_test_case)
            payload = self.create_payload(test_cases[num_test_case])
            response = requests.post(UrlConstant.END_POINT_DEPOSIT, data=payload, headers=headers)
            result = self.create_result_for_excel(test_case, response.text, "result")
            test_results.append(result)

            break
        self.export_report(test_results)
        # bearer_auth = "Bearer " + BaseTest.token
        # headers = {"Authorization": bearer_auth}
        # response = requests.post(endpoint, data=payload, headers=headers)
        # print(response.text)

    def tearDown(self):
        print("tearDown")


if __name__ == "__main__":
    unittest.main()
