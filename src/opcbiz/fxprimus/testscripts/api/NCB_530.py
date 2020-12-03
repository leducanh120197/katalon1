import unittest

import requests


from src.opcbiz.fxprimus.utils.ExcelUtils import ExcelUtils
from src.opcbiz.fxprimus.testscripts.BaseTest import BaseTest

name = ['Praxis', 'Yaarpay', 'Emerchantpay']
payment_method = ['']
payment_channel = ['cdc', 'bc', 'ew', 'lbt', 'bw']
virtual = ['false']
mt4_id = ['10000116']
referral_id = ['']
mt4_currency = ['USD', 'EUR', 'GBP', 'SGD', 'ZAR', 'PLN', 'BRL', 'AUD']
amount = ['100']
psp_currency = ['USD', 'EUR', 'GBP', 'SGD', 'ZAR', 'PLN', 'BRL', 'MYR', 'VND', 'AUD', 'THB', 'IDR', 'CNY', 'INR', 'CLP',
                'COP', 'MXN', 'PEN', 'UYU', 'GHS', 'KES', 'TZS', 'NGN', 'PHP']
conversion_rate = ['1']
psp_amount = ['100']
additional_psp_parameters = ['{"channelId": 8035 }']

keys = ['name', 'payment_method', 'payment_channel', 'virtual', 'mt4_id', 'referral_id', 'mt4_currency', 'amount',
        'psp_currency', 'conversion_rate', 'psp_amount', 'additional_psp_parameters']


input_data = [name, payment_method, payment_channel, virtual, mt4_id, referral_id, mt4_currency, amount, psp_currency,
              conversion_rate, psp_amount, additional_psp_parameters]
number_keys = len(input_data)
test_data = []



class RegisterTest(unittest.TestCase, BaseTest):

    def setUp(self):
        print("setUp")

    def create_test_case_from_test_cases(self, test_case):
        str_test_case = '{'
        for index in range(0, number_keys):
            if keys[index] == 'name':
                if test_case[index] == 'Praxis':
                    test_case[index + 1] = 'prx'
                if test_case[index] == 'Yaarpay':
                    test_case[index + 1] = 'yp'
                if test_case[index] == 'emp':
                    test_case[index + 1] = 'prx'
            if keys[index] in ['referral_id', 'additional_psp_parameters']:
                continue
            str_test_case += '"' + keys[index] + '":"' + test_case[index] + '"'
            if index < number_keys - 1:
                str_test_case += ','
            # else:
        str_test_case = str_test_case.rstrip(',')
        str_test_case += '}'
        print(str_test_case)
        return str_test_case

    def test_deposit_request_api(self):
        test_cases = ExcelUtils.convert_two_dimensional_to_one_dimensional(input_data)

        print(test_cases[0])

        endpoint = BaseTest.api_gateway_url + 'transactions/deposit-request'
        for test_case in test_cases:
            payload = self.create_test_case_from_test_cases(test_case)
            bearer_auth = "Bearer " + BaseTest.token
            headers = {"Authorization": bearer_auth}
            response = requests.post(endpoint, data=payload, headers=headers)
            print(response.text)
            break

    def tearDown(self):
        print("tearDown")


if __name__ == "__main__":
    unittest.main()
