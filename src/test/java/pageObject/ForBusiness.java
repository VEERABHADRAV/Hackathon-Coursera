package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ForBusiness extends BasePage {
	
	// constructor
	public ForBusiness(WebDriver driver) {
		super(driver);
	}
	
	
	// Locators
	// clicking on the For Business tab
		@FindBy(xpath = "//a[@data-track-component='navigation_meta_nav_Business']")
		WebElement forBusinessesButton;

		// Filling out the form
		@FindBy(xpath = "//input[@id='FirstName']")
		WebElement firstNameForm;

		@FindBy(xpath = "//input[@id='LastName']")
		WebElement lastNameForm;

		@FindBy(id = "Email")
		WebElement officeEmailIdForm;

		@FindBy(xpath = "//input[@id='Phone']")
		WebElement phoneNumberForm;

		@FindBy(xpath = "/html/body/div[2]/div/div/main/div/div[9]/div/div[2]/div/div/div[2]/div/div[2]/div/div/form/div[6]/div[1]/div[2]/input")
		WebElement jobTitleForm;

		@FindBy(xpath = "//*[@id='Self_reported_employees_to_buy_for__c']")
		WebElement numberOfLearnersSelectOptionList;

		@FindBy(xpath = "//*[@id='Country']")
		WebElement countryNameSelectOptionList;

		@FindBy(xpath = "//*[@id='State']")
		WebElement stateNameSelectOptionList;

		@FindBy(xpath = "//*[@id='What_the_lead_asked_for_on_the_website__c']")
		WebElement describeNeedsSelectOptionList;

		@FindBy(xpath = "//button[@class='mktoButton']")
		WebElement formSubmitButton;

		@FindBy(className = "mktoErrorMsg")
		WebElement formErrorMessage;
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Action
		public void accessForBusiness() throws InterruptedException {
			forBusinessesButton.click();
			
			js.executeScript("window.scrollBy(0, 3000)");
			
			// filling out the form

			// first name
			firstNameForm.sendKeys("Michael");

			// last name
			lastNameForm.sendKeys("Scott");

			// email id
			officeEmailIdForm.sendKeys("curiosity@helloworld.com");

			// phone number
			phoneNumberForm.sendKeys("1234567890aswdw");
			
			js.executeScript("window.scrollBy(0,300)");

			// job title
			jobTitleForm.sendKeys("Software Developer");

			// accessing the drop down list of Number Of Learners using Select Class
			Select numberOfLearnersList = new Select(numberOfLearnersSelectOptionList);
			numberOfLearnersList.selectByValue("501-1000");

			// country
			Select countryList = new Select(countryNameSelectOptionList);
			countryList.selectByValue("India");

			// state
			Select stateList = new Select(stateNameSelectOptionList);

			stateList.selectByValue("Delhi");

			// describe needs
			Select describeNeedsList = new Select(describeNeedsSelectOptionList);

			describeNeedsList.selectByValue("Courses for myself");

			// submit button

			formSubmitButton.click();

			// Extracting the error message
			String errorMessage = formErrorMessage.getText();
			System.out.println("Captured Error Message: " + errorMessage);
			Thread.sleep(3000);
			
		}
}
