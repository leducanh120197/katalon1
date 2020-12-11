import unittest

from src.opcbiz.fxprimus.webdriverfactory.web_driver_factory import WebDriverFactory
from src.opcbiz.fxprimus.constant.constant import Constant
from src.opcbiz.fxprimus.constant.url_constant import UrlConstant
from src.opcbiz.fxprimus.pages.register_page import RegisterPage
from src.opcbiz.fxprimus.pages.google_page import GooglePage
from src.opcbiz.fxprimus.utils.excel_utils import ExcelUtils
from src.opcbiz.fxprimus.dto import account_dto
from src.opcbiz.fxprimus.dto.register.register_dto import RegisterDto
from src.opcbiz.fxprimus.testscripts.base_test import BaseTest


class VerifyEmail(unittest.TestCase, BaseTest):

    def setUp(self):
        print('setUp')
        self.driver = WebDriverFactory.get_driver(Constant.CHROME)

    def test_verify_email(self):
        print('test_verify_email')
        driver = self.driver

        driver.maximize_window()
        driver.get(UrlConstant.GMAIL_PAGE)
        google_page = GooglePage(driver)
        google_page.click_sign_in()

        driver.switch_to.window(driver.window_handles[1])

        google_page.sendkey_to_email(Constant.GMAIL_USERNAME)
        google_page.click_next()
        google_page.sendkey_to_password(Constant.GMAIL_PASSWORD)
        google_page.click_password_next()
        google_page.waiting(15)



    def tearDown(self):
        print('tearDown')


if __name__ == '__main__':
    unittest.main()