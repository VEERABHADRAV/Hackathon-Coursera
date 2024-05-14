package testCases;

import org.testng.annotations.Test;

import pageObject.IdentifyCourses;
import testBase.BaseClass;

public class TC_001_IdentifyCourses extends BaseClass {

	@Test
	public void IdentifyCoursesValidation() throws InterruptedException {
		IdentifyCourses ic = new IdentifyCourses(driver);
		
		ic.handlingPopup();
		ic.searchCourse();
		ic.filterCourse();
		ic.getCourseDetails();
	}
}
