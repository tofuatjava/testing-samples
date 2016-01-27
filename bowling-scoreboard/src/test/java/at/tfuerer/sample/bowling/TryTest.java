package at.tfuerer.sample.bowling;

import org.junit.Test;

public class TryTest {

	@Test
	public void validTry() throws BowlingException {
		new Try(0);
		new Try(10);
	}
	
	@Test(expected=BowlingException.class)
	public void tryWithNegativeValue() throws Exception {
		new Try(-1);
	}
	
	@Test(expected=BowlingException.class)
	public void tryWithTooManyPins() throws Exception {
		new Try(11);
	}

}
