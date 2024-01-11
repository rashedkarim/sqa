package testng.listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class ListenerDemo {

	@Test
	void testSuccess() {
		System.out.println("testSuccess...");
		Assert.assertEquals(1, 1);
	}
	
	@Test
	void testFail() {
		System.out.println("testFail....");
		Assert.assertEquals(1, 2);
	}
	
	@Test
	void testSkip() {
		System.out.println("testSkip...");
		throw new SkipException("This is skip exception...");
	}
}
