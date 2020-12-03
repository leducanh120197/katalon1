from src.opcbiz.fxprimus.constant.UrlConstant import UrlConstant
from src.opcbiz.fxprimus.pages.BasePage import BasePage

# input fields
account_type_id = 'mat-select-0'
account_individual_xpath = '//*[@id="mat-option-0"]//span[contains(text(), "Individual")]'
account_joint_xpath = '//*[@id="mat-option-1"]//span[contains(text(), "Joint")]'
account_corporate_xpath = '//*[@id="mat-option-2"]//span[contains(text(), "Corporate")]'
first_name_id = 'firstName'
last_name_id = 'lastName'
email_id = 'email'
country_id = 'mat-select-1'
country_search_field_xpath = "//*[@placeholder='Search Country ']"
phone_number_id = 'phoneNumber'
password_id = 'password'
checkbox_agreement_id = 'clientAgreement'
checkbox_kid_id = 'kid_policy'
checkbox_marketing_id = 'newsletter'
checkbox_understand_id = 'hungary_policy'

register_now_xpath = "//form/button"

continue_register_xpath = "//span[contains(text(),'CONTINUE')]"


class RegisterPage(BasePage):

    def __init__(self, driver):
        super().__init__(driver)
        self.account_type_element = self.find_element_by_id(account_type_id)
        self.first_name_element = self.find_element_by_id(first_name_id)
        self.last_name_element = self.find_element_by_id(last_name_id)
        self.email_element = self.find_element_by_id(email_id)
        self.country_element = self.find_element_by_id(country_id)
        self.phone_element = self.find_element_by_id(phone_number_id)
        self.password_element = self.find_element_by_id(password_id)

        self.register_now_element = self.find_element_by_xpath(register_now_xpath)

        # if self.is_element_present_by_id(checkbox_agreement_id):
        #     self.checkbox_agreement_element = self.find_element_by_id(checkbox_agreement_id)
        #     self.has_checkbox_agreement_id = True
        # self.checkbox_kid_element = self.find_element_by_id(checkbox_kid_id)
        # self.checkbox_marketing_element = self.find_element_by_id(checkbox_marketing_id)
        # self.checkbox_understand_element = self.find_element_by_id(checkbox_understand_id)

    def load_register_page(self):
        self.driver.get(UrlConstant.MA_REGISTER_PAGE)

    # actions
    def click_continue_register(self, xpath):
        if self.is_element_present_by_xpath(xpath):
            self.click_wait(self.find_element_by_xpath(xpath), 1)
        # if self.is_element_present_by_xpath(xpath):
        #     self.click_wait(self.find_element_by_xpath(xpath), 1)

    def select_account_type(self, account_type):
        self.click_wait(self.account_type_element, 1)
        if account_type == 'Individual':
            account_individual_element = self.find_element_by_xpath(account_individual_xpath)
            self.click_wait(account_individual_element, 1)
        if account_type == 'Joint':
            account_joint_element = self.find_element_by_xpath(account_joint_xpath)
            self.click_wait(account_joint_element, 1)
        if account_type == 'Corporate':
            account_corporate_element = self.find_element_by_xpath(account_corporate_xpath)
            self.click_wait(account_corporate_element, 1)

    def send_key_first_name(self, first_name):
        self.send_key(self.first_name_element, first_name)

    def send_key_last_name(self, last_name):
        self.send_key(self.last_name_element, last_name)

    def send_key_email(self, email):
        self.send_key(self.email_element, email)

    def set_country(self, country_name):
        self.click_wait(self.country_element, 1)
        country_search_field_element = self.find_element_by_xpath(country_search_field_xpath)
        self.send_key(country_search_field_element, country_name)
        country_element = self.find_element_by_xpath("//span[contains(text(),'" + country_name + "')]")
        self.click_wait(country_element, 1)
        self.click_continue_register(continue_register_xpath)

    def send_key_to_phone(self, phone_number):
        self.send_key(self.phone_element, phone_number)

    def send_key_to_password(self, password):
        self.send_key(self.password_element, password)

    def select_checkbox_agreement(self, checkbox_agreement):
        if checkbox_agreement == 'YES':
            if self.is_element_present_by_id(checkbox_agreement_id):
                checkbox_agreement_element = self.find_element_by_id(checkbox_agreement_id)
                self.click_wait(checkbox_agreement_element, 1)

    def select_checkbox_kid(self, checkbox_understand):
        if checkbox_understand == 'YES':
            if self.is_element_present_by_id(checkbox_kid_id):
                checkbox_kid_element = self.find_element_by_id(checkbox_kid_id)
                self.click_wait(checkbox_kid_element, 1)

    def select_checkbox_marketing(self, checkbox_marketing):
        if checkbox_marketing == 'YES':
            if self.is_element_present_by_id(checkbox_marketing_id):
                checkbox_marketing_element = self.find_element_by_id(checkbox_marketing_id)
                self.click_wait(checkbox_marketing_element, 1)

    def select_checkbox_understand(self, checkbox_understand):
        if checkbox_understand == 'YES':
            if self.is_element_present_by_id(checkbox_understand_id):
                checkbox_understand_element = self.find_element_by_id(checkbox_understand_id)
                self.click_wait(checkbox_understand_element, 1)

    def click_register(self):
        self.click(self.register_now_element)

    # def input_data(self, account_type, first_name, last_name, email, country, phone_number, checkbox_agreement,
    #                checkbox_kid, checkbox_marketing, checkbox_understand):
    #     print("input_date: working...")
    #     self.select_account_type(account_type)
    #     self.send_key_first_name(first_name)
    #     self.send_key_last_name(last_name)
    #     self.send_key_email(email)
    #     self.set_country(country)
    #     self.send_key_to_phone(phone_number)
    #
    #     self.select_checkbox_agreement(checkbox_agreement)
    #     self.select_checkbox_kid(checkbox_kid)
    #     self.select_checkbox_marketing(checkbox_marketing)
    #     self.select_checkbox_understand(checkbox_understand)
    #     print("input_date: finished...")

    def input_data(self, register_dto):
        print("input_date: working...")
        self.select_account_type(register_dto.account_type)
        self.send_key_first_name(register_dto.first_name)
        self.send_key_last_name(register_dto.last_name)
        self.send_key_email(self.create_new_email())
        self.set_country(register_dto.country)
        self.send_key_to_phone(register_dto.phone_number)
        self.send_key_to_password(register_dto.password)

        self.select_checkbox_agreement(register_dto.checkbox_agreement)
        # self.select_checkbox_marketing(register_dto.checkbox_marketing)

        self.select_checkbox_kid(register_dto.checkbox_kid)
        self.select_checkbox_understand(register_dto.checkbox_understand)
        print("input_date: finished...")
