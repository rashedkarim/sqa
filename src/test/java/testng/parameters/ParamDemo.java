package testng.parameters;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamDemo {

	public int add(int a, int b) {
		return a + b;
	}

	@DataProvider(name = "dataSet")
	Object[][] dataProvider() {
		Object[][] data = { { 5, 6, 11 }, { 7, 8, 15 } };
		return data;
	}

	@Test
	@Parameters({ "num1", "num2", "num3" })
	public void addTest(int a, int b, int result) {
		int expectedResult = result;
		AssertJUnit.assertEquals(add(a, b), expectedResult);
	}
}
