package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explore extends BasePage {

	// constructor
	public Explore(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	
	@FindBy(xpath="//button[@aria-label='Explore our catalog']")
	WebElement ExploreButton;
	
	@FindBy(xpath = "//button[@id='language-learning~menu-item' and @data-e2e='megamenu-item~language-learning']")
	WebElement languageLearningButton;
	
	// extracting Get Started and Popular Skills list in the Explore Button
	@FindBy(xpath = "//ul[@aria-labelledby='Language-Learning-tab-Get-started-title' and @class='css-l7iry6']/li")
	List<WebElement> getStartedLevelsList;

	@FindBy(xpath = "//ul[@aria-labelledby='Language-Learning-tab-Popular-skills-title' and @class='css-l7iry6']/li")
	List<WebElement> popularSkillsListLocator;
	
	Actions act = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	public void accessExploreButton() throws InterruptedException {
		act.moveToElement(ExploreButton).perform();
		Thread.sleep(2000);
		
		languageLearningButton.click();
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElements(getStartedLevelsList));

		System.out.println("\nList of Get started levels  \n");

		for (int i = 0; i < getStartedLevelsList.size(); i++) {
			System.out.println(getStartedLevelsList.get(i).getText());
		}

		System.out.println("Size of Get Started Levels : " + getStartedLevelsList.size());
		

		// extracting the list of Popular Skills
		System.out.println("\nList of Popular Skills  \n");

		for (int i = 1; i <= (popularSkillsListLocator.size() - 2); i++) {
			System.out.println(popularSkillsListLocator.get(i).getText());
		}

		System.out.println("Size of Popular Skills List: " + (popularSkillsListLocator.size() - 2));
		System.out.println();
	}
	

}
