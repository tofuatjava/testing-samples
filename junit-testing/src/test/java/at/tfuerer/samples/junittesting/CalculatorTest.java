package at.tfuerer.samples.junittesting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void addPositiveValues() {
		assertThat(calculator.add(1, 1), Matchers.equalTo(2));
	}
	
	@Test
	public void addOneToMaxInt() {
		assertThat(calculator.add(1, Integer.MAX_VALUE), Matchers.allOf(
				Matchers.equalTo(Integer.MAX_VALUE+1),
				Matchers.greaterThan(0)));
	}
	
	@Test
	public void convertDecToHex() throws Exception {
		assertThat(calculator.toHex(Integer.MAX_VALUE), Matchers.stringContainsInOrder(Arrays.asList("7","f","f","f","f","f","f")));
	}

}
