import unittest
import requests
import json

from src.opcbiz.fxprimus.testscripts.BaseTest import BaseTest
from src.opcbiz.fxprimus.testscripts.api.NCB_530_get_data import GetData
from src.opcbiz.fxprimus.constant.UrlConstant import UrlConstant

from src.opcbiz.fxprimus.dto.api.NCB530Dto import NCB530Dto

endpoint = BaseTest.api_gateway_url + 'transactions/deposit-request'


class RegisterTest(unittest.TestCase, BaseTest):
    test_cases = []
    endpoint = ''

    def get_token(self):
        payload_login = {"username": "bach.nguyen+Ind@opcbiz.com",
                         "password": "Vmo@12345"}
        response = requests.post(UrlConstant.END_POINT_LOGIN, data=payload_login)
        return response.text

    def create_payload(self, dto):
        print(type(dto))
        dto_dict = {'id': dto.get_id(),
                    'title': dto.get_title(),
                    'name': dto.get_name(),
                    'payment_method': dto.get_payment_method(),
                    'payment_channel': dto.get_payment_channel(),
                    'virtual': dto.get_virtual(),
                    'mt4_id': dto.get_mt4_id(),
                    'referral_id': dto.get_referral_id(),
                    'mt4_currency': dto.get_mt4_currency(),
                    'amount': dto.get_amount(),
                    'psp_currency': dto.get_psp_currency(),
                    'conversion_rate': dto.get_conversion_rate(),
                    'psp_amount': dto.get_psp_amount(),
                    'additional_psp_parameters': dto.get_additional_psp_parameters(),

                    }
        payload = json.dumps(dto_dict)
        print(payload)
        return payload

    def setUp(self):
        get_data = GetData()
        global test_cases
        test_cases = get_data.get_test_cases()

    def test_deposit_request_api(self):
        token = self.get_token()

        # payload = self.create_payload(test_cases[0])
        # bearer_auth = "Bearer " + BaseTest.token
        # headers = {"Authorization": bearer_auth}
        # response = requests.post(endpoint, data=payload, headers=headers)
        # print(response.text)


    def tearDown(self):
        print("tearDown")


if __name__ == "__main__":
    unittest.main()
