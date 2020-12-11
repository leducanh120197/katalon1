from src.opcbiz.fxprimus.pages.base_page import BasePage
from selenium.common import exceptions

class GooglePage(BasePage):

    def __init__(self, driver):
        super().__init__(driver)
        # xpath
        self.sign_in_xpath = "//div[@class='h-c-header__cta']//a[contains(text(),'Sign in')]"
        self.welcome_mail_xpath = "(//span[contains(text(),'Welcome to FXPRIMUS! Please Verify')])[2]"
        self.goToMemArea_xpath = "//a[contains(text(),'GO TO MEMBERS AREA')]"
        self.goToArea_xpath = "//a[contains(text(),'GO TO') and contains(text(),'AREA')]"
        self.pin_xpath = "//h2[contains(text(),'Welcome to FXPRIMUS! Please Verify Your Email Address. Unique PIN')]"
        self.uniquePin_xpath = "//*[@id='digitCode']"
        self.verifyButton_xpath = "//div/foself.rm/button"
        # id
        self.email_id = 'identifierId'
        self.password_id = 'password'
        self.next_id = 'identifierNext'
        self.password_next_id = 'passwordNext'

    def click_sign_in(self):
        sign_in_element = self.find_element_by_xpath(self.sign_in_xpath)
        self.click_wait(sign_in_element, 1)

    # def select_2nd_chrome_tab(self, driver):



    def sendkey_to_email(self, email):
        email_element = self.find_element_by_id(self.email_id)
        self.send_key(email_element, email)

    def sendkey_to_password(self, password):
        password_element = self.find_element_by_id(self.password_id)
        self.send_key(password_element, password)

    def click_next(self):
        next_element = self.find_element_by_id(self.next_id)
        self.click_wait(next_element, 1)

    def click_password_next(self):
        password_next_element = self.find_element_by_id(self.password_next_id)
        self.click_wait(password_next_element, 1)

    def select_welcome_mail(self):
        try:
            welcome_mail_element = self.find_element_by_xpath(self.welcome_mail_xpath)
            self.click_wait(welcome_mail_element, 1)
        except exceptions:
            print('exceptions: select_welcome_mail')

    def get_pin(self):
        pin_element = self.find_element_by_xpath(self.pin_xpath)
        pin_field = self.get_text(pin_element)
        content = str(pin_field).split('Unique PIN: ')
        pin = content[1]
        return pin