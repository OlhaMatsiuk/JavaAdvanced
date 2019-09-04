package ua.lviv.lgs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {

	private Time time;

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
		time = new Time(122);
	}

	@After
	public void afterTest() {
		time = null;

	}
	
	@Test
	public void getHourTest() {
		Assert.assertEquals(time.getHour(), 2);
	}
	@Test
	public void getMinTest() {
		Assert.assertEquals(time.getHour(), 2);
	}
	
	
}
