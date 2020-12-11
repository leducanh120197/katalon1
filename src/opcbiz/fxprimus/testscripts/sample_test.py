import unittest

from src.opcbiz.fxprimus.webdriverfactory.web_driver_factory import WebDriverFactory
from src.opcbiz.fxprimus.constant.constant import Constant
from src.opcbiz.fxprimus.constant.url_constant import UrlConstant
from src.opcbiz.fxprimus.pages.register_page import RegisterPage
from src.opcbiz.fxprimus.utils.excel_utils import ExcelUtils
from src.opcbiz.fxprimus.dto import excel_field_dto, account_dto
from src.opcbiz.fxprimus.dto.register import register_dto
from src.opcbiz.fxprimus.testscripts.base_test import BaseTest


# @ddt
class SampleTest(unittest.TestCase, BaseTest):

    def setUp(self):
        self.driver = WebDriverFactory.get_driver(Constant.CHROME)
        print("setUp(self)")

    def test_sample(self):
        print('x')

    def tearDown(self):
        print("self.driver.close()")
        self.driver.stop_client()


if __name__ == "__main__":
    unittest.main()
