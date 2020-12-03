import unittest

from src.opcbiz.fxprimus.webdriverfactory.WebDriverFactory import WebDriverFactory
from src.opcbiz.fxprimus.constant.Constant import Constant
from src.opcbiz.fxprimus.constant.UrlConstant import UrlConstant
from src.opcbiz.fxprimus.pages.RegisterPage import RegisterPage
from src.opcbiz.fxprimus.utils.ExcelUtils import ExcelUtils
from src.opcbiz.fxprimus.dto import ExcelFieldDto, AccountDto
from src.opcbiz.fxprimus.dto.register import RegisterDto
from src.opcbiz.fxprimus.testscripts.BaseTest import BaseTest


# @ddt
class RegisterTest(unittest.TestCase, BaseTest):

    def setUp(self):
        self.driver = WebDriverFactory.get_driver(Constant.CHROME)
        print("setUp(self)")

    # @ddt.data(*get_data())
    # @ddt.unpack
    def test_register_test(self):
        print((type(AccountDto.AccountDto)))
        file_path = BaseTest.create_file_path("Register.xlsx")
        data_test = ExcelUtils.get_data_from_excel(file_path, "Register", RegisterDto.RegisterDto.excel_template(),
                                                   RegisterDto.RegisterDto)
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
