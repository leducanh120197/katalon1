import unittest
import requests

from src.opcbiz.fxprimus.utils.ExcelUtils import ExcelUtils
from src.opcbiz.fxprimus.testscripts.BaseTest import BaseTest


class RegisterTest(unittest.TestCase, BaseTest):
    endpoint = BaseTest.api_gateway_url + 'transactions/deposit-request'


    def setUp(self):
        print("setUp")

    def test_deposit_request_api(self):


        # for test_case in test_cases:
        #     payload = self.create_test_case_from_test_cases(test_case)
        #     bearer_auth = "Bearer " + BaseTest.token
        #     headers = {"Authorization": bearer_auth}
        #     response = requests.post(endpoint, data=payload, headers=headers)
        #     print(response.text)
        #     break

    def tearDown(self):
        print("tearDown")


if __name__ == "__main__":
    unittest.main()
