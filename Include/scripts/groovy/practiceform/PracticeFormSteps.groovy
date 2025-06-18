package practiceform

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testdata.TestData


class PracticeFormSteps {

	TestData data = TestDataFactory.findTestData('dataForms')
	int rowCount = data.getRowNumbers()

	@Given("User navigates to the Practice Form page")
	def openForm() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
	}

	@When("User fills and submits the form for each data")
	def fillAndSubmitForms() {
		for (int i = 1; i <= rowCount; i++) {
			WebUI.navigateToUrl('https://demoqa.com/automation-practice-form')

			String firstName = data.getValue('firstName', i)
			String lastName = data.getValue('lastName', i)
			String email = data.getValue('userEmail', i)
			String mobile = data.getValue('userNumber', i)
			String dob = data.getValue('date', i)
			String address = data.getValue('address', i)
			String gender = data.getValue('gender', i)
			String hobby = data.getValue('hobby', i)
			String state = data.getValue('state', i)
			String city = data.getValue('city', i)

			WebUI.setText(findTestObject('Object Repository/Form/input_firstName'), firstName)
			WebUI.setText(findTestObject('Object Repository/Form/input_lastName'), lastName)

			WebUI.scrollToElement(findTestObject('Object Repository/Form/input_userEmail'), 10)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Form/input_userEmail'), 10)
			WebUI.setText(findTestObject('Object Repository/Form/input_userEmail'), email)

			WebUI.click(findTestObject('Object Repository/Form/input_radio_gender_1', ['index': gender]))
			WebUI.setText(findTestObject('Object Repository/Form/input_userNumber'), mobile)

			WebUI.scrollToElement(findTestObject('Object Repository/Form/input_date'), 10)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Form/input_date'), 10)
			WebUI.click(findTestObject('Object Repository/Form/input_date'))
			WebUI.sendKeys(findTestObject('Object Repository/Form/input_date'), Keys.chord(Keys.CONTROL, 'a'))
			WebUI.sendKeys(findTestObject('Object Repository/Form/input_date'), dob)
			WebUI.sendKeys(findTestObject('Object Repository/Form/input_date'), Keys.chord(Keys.ENTER))

			WebUI.click(findTestObject('Object Repository/Form/input_English'))
			WebUI.sendKeys(findTestObject('Object Repository/Form/input_English'), 'en')
			WebUI.delay(1)
			WebUI.sendKeys(findTestObject('Object Repository/Form/input_English'), Keys.chord(Keys.ENTER))

			WebUI.click(findTestObject('Object Repository/Form/input_check_music', ['hobby': hobby]))

			WebUI.uploadFile(findTestObject('Object Repository/Form/input_upload'),
					'C:\\Users\\HRD SHARING VISION\\Katalon Studio\\web-dianaslama-afteroffice-katalon\\fileupload.jpg')

			WebUI.setText(findTestObject('Object Repository/Form/input_address'), address)

			WebUI.click(findTestObject('Object Repository/Form/input_state'))
			WebUI.click(findTestObject('Object Repository/Form/input_state_ncr'))
			WebUI.click(findTestObject('Object Repository/Form/input_city'))
			WebUI.click(findTestObject('Object Repository/Form/input_city_delhi'))

			WebUI.click(findTestObject('Object Repository/Form/button_Submit'))

			WebUI.verifyElementText(findTestObject('Object Repository/Form/verify_sukses_submit'), 'Thanks for submitting the form')
		}
	}

	@Then("Each form submission should show success message")
	def endTest() {
		WebUI.closeBrowser()
	}
}
