from src.opcbiz.fxprimus.constant import constant
from selenium import webdriver


class WebDriverFactory:

    @staticmethod
    def get_driver(browser):
        if browser == constant.Constant.CHROME:
            driver = webdriver.Chrome(
                executable_path=r'C:\Users\LQA\Desktop\FXPRIMUS_AUTO\webdriver\chromedriver_win32_87.exe')
        if browser == constant.Constant.FIREFOX:
            driver = webdriver.Chrome(
                executable_path=r'C:\Users\LQA\Desktop\FXPRIMUS_AUTO\webdriver\chromedriver_win32_87.exe')
        driver.implicitly_wait(30)
        return driver
