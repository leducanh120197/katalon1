import unittest

from src.opcbiz.fxprimus.webdriverfactory.web_driver_factory import WebDriverFactory
from src.opcbiz.fxprimus.constant.constant import Constant
from src.opcbiz.fxprimus.constant.url_constant import UrlConstant
from src.opcbiz.fxprimus.pages.register_page import RegisterPage
from src.opcbiz.fxprimus.utils.excel_utils import ExcelUtils
from src.opcbiz.fxprimus.dto import account_dto
from src.opcbiz.fxprimus.dto.register.register_dto import RegisterDto
from src.opcbiz.fxprimus.testscripts.base_test import BaseTest


class RegisterTest(unittest.TestCase, BaseTest):

    def setUp(self):
        self.driver = WebDriverFactory.get_driver(Constant.CHROME)
        print("setUp(self)")

    def test_register_test(self):
        print((type(account_dto.AccountDto)))
        file_path = BaseTest.create_file_path_input("Register.xlsx")
        data_test = ExcelUtils.get_data_from_excel(file_path, "Register", RegisterDto.excel_template(),
                                                   RegisterDto)
        print(data_test[0])
        driver = self.driver
        driver.maximize_window()
        for register_dto in data_test:
            driver.get(UrlConstant.MA_REGISTER_PAGE)
            register_page = RegisterPage(driver)
            register_page.input_data(register_dto)
            register_page.click_register()
            register_page.logout()
            register_page.waiting(5)

    def tearDown(self):
        print("self.driver.close()")
        self.driver.stop_client()


if __name__ == "__main__":
    unittest.main()
