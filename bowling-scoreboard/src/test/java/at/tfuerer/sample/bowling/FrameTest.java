package at.tfuerer.sample.bowling;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class FrameTest {

	@Test
	public void calculateFrameWithTwoTries() throws Exception {
		assertThat(new Frame().add(new Try(1)).add(new Try(1)).calculate(), Matchers.equalTo(2));
	}
	
	@Test
	public void calculateFrameWithSplit() throws Exception {
		assertThat(new Frame().add(new Try(9)).add(new Try(1)).extraPins(1).calculate(),
				Matchers.equalTo(11));
		
	}
	
}
