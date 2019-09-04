package ua.lviv.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {
	
	private  Schedule  schedule;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};
	};
	
	@Before
	public void beforeTest() {
		schedule = new Schedule();
	}

	@After
	public void afterTest() {
		schedule = null;
	}
	
	@Test
	public void addTest() {
		schedule.addSeance(new Seance(new Movie("Test",120),new Time(10,10)));
		String str1 = schedule.getSeanceMovie("Test").getMovie().getTitle();
		String str2 = "Test";
		Assert.assertEquals(str1, str2);
	}
	

}
