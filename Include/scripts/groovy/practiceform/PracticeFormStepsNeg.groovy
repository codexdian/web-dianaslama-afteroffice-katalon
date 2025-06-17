package practiceform
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class PracticeFormNegativeSteps {
	
		@Given("User navigates to the Practice Form page for negative tc")
		def openForm() {
			WebUI.openBrowser('')
			WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')
			WebUI.maximizeWindow()
			WebUI.scrollToElement(findTestObject('Object Repository/Form/input_firstName'), 10)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Form/input_firstName'), 10)
			WebUI.takeScreenshot()
		}
	
		@When("User submits form with required fields empty")
		def submitEmptyForm() {
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Form/button_Submit'))
			
		}
	
		@Then("The required fields should show red borders")
		def verifyRedBorderOnRequiredFields() {
			// List required field objects
			def requiredFields = [
				'Object Repository/Form/input_firstName',
				'Object Repository/Form/input_lastName',
				'Object Repository/Form/input_userNumber'
			]
	
			for (def fieldPath : requiredFields) {
				def borderColor = WebUI.getCSSValue(findTestObject(fieldPath), 'border-color')
				println("Border color of ${fieldPath}: ${borderColor}")
	
				// Validasi jika warna merah: #dc3545 = rgb(220, 53, 69)
				assert borderColor == 'rgb(220, 53, 69)' : "Expected red border but got ${borderColor} on ${fieldPath}"
				WebUI.takeScreenshot()
			}
	
			WebUI.closeBrowser()
		}
	}