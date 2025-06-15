package practiceform

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys



class PracticeFormSteps {

	@Given("User navigates to the Practice Form page")
	def openForm() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')
		WebUI.maximizeWindow()
	}

	@When("User fills in the form with valid data")
	def fillForm() {
		WebUI.setText(findTestObject('Object Repository/Form/input_firstName'), 'John')
		WebUI.setText(findTestObject('Object Repository/Form/input_lastName'), 'Doe')
		WebUI.setText(findTestObject('Object Repository/Form/input_userEmail'), 'john.doe@example.com')
		WebUI.click(findTestObject('Object Repository/Form/input_radio_gender_1'))
		
		WebUI.setText(findTestObject('Object Repository/Form/input_userNumber'), '081234567890')
		
		WebUI.click(findTestObject('Object Repository/Form/input_date'))
		WebUI.sendKeys(findTestObject('Object Repository/Form/input_date'), Keys.chord(Keys.CONTROL, 'a')) // Select all
		WebUI.sendKeys(findTestObject('Object Repository/Form/input_date'), '01 Jan 2000')
		WebUI.sendKeys(findTestObject('Object Repository/Form/input_date'), Keys.chord(Keys.ENTER))
		
		WebUI.click(findTestObject('Object Repository/Form/input_English'))
		WebUI.sendKeys(findTestObject('Object Repository/Form/input_English'), 'e')
		WebUI.delay(3)
		WebUI.sendKeys(findTestObject('Object Repository/Form/input_English'), Keys.chord(Keys.ENTER))
		
		WebUI.click(findTestObject('Object Repository/Form/input_check_music'))
		
//		WebUI.click(findTestObject('Object Repository/Form/input_upload'))
		
		WebUI.uploadFile(findTestObject('Object Repository/Form/input_upload'), 'C:\\Users\\HRD SHARING VISION\\Katalon Studio\\web-niar-afteroffice-katalon\\fileupload.jpg')
		
		WebUI.setText(findTestObject('Object Repository/Form/input_address'), 'Jl. After Office No. 123')
		
		WebUI.click(findTestObject('Object Repository/Form/input_state'))
		WebUI.click(findTestObject('Object Repository/Form/input_state_ncr'))
		
		WebUI.click(findTestObject('Object Repository/Form/input_city'))
		WebUI.click(findTestObject('Object Repository/Form/input_city_delhi'))
		
	}


	@When("User submits the form")
	def submitForm() {
		WebUI.click(findTestObject('Object Repository/Form/button_Submit'))
	}

	@Then("The form should be submitted successfully")
	def verifySubmission() {
		WebUI.verifyElementText(findTestObject('Object Repository/Form/verify_sukses_submit'), 'Thanks for submitting the form')
		WebUI.closeBrowser()
	}
}
