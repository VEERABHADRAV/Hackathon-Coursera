package testCases;

import org.testng.annotations.Test;

import pageObject.Explore;
import testBase.BaseClass;

public class TC_002_Explore extends BaseClass {

	@Test
	public void exploreValidation() throws InterruptedException {
		Explore e = new Explore(driver);
		e.accessExploreButton();
	}
}
