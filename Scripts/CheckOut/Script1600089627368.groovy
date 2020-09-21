import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://automationpractice.com/index.php')

WebUI.click(findTestObject('Object Repository/Page_My Store/a_Sign in'))

WebUI.setText(findTestObject('Object Repository/Page_Login - My Store/input_Email address_email'), 'katalon@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login - My Store/input_Password_passwd'), 'GmIEYDA9fbJDouHIkUzbBw==')

WebUI.click(findTestObject('Object Repository/Page_Login - My Store/span_Sign in'))

WebUI.click(findTestObject('Object Repository/Page_My account - My Store/img_Call us now_logo img-responsive'))

WebUI.click(findTestObject('Object Repository/Page_My Store/span_Add to cart'))

WebUI.click(findTestObject('Object Repository/Page_My Store/span_Continue shopping'))

WebUI.click(findTestObject('Object Repository/Page_My Store/span_Add to cart'))

WebUI.click(findTestObject('Object Repository/Page_My Store/span_Continue shopping'))

WebUI.mouseOver(findTestObject('Object Repository/Page_My Store/a_Cart2ProductProducts4351(empty)'))

WebUI.click(findTestObject('Object Repository/Page_Order - My Store/span_Check out'))

'summary'
WebUI.click(findTestObject('Object Repository/Page_Order - My Store/span_Proceed to checkout'))

'address'
WebUI.click(findTestObject('Page_Order - My Store/button_Proceed to checkout Address'))

WebUI.click(findTestObject('Object Repository/Page_Order - My Store/input_200_cgv'))

WebUI.click(findTestObject('Object Repository/Page_Order - My Store/span_Proceed to checkout_1'))

WebUI.click(findTestObject('Object Repository/Page_Order - My Store/a_Pay by bank wire (order processing will b_e7efad'))

WebUI.click(findTestObject('Object Repository/Page_My Store/span_I confirm my order'))

WebUI.closeBrowser()

