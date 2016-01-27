package at.tfuerer.sample.bowling;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class BowlingTest {

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
	
	@Test
	public void calculateFrameWithTwoTries() throws Exception {
		assertThat(new Frame().add(new Try(1)).add(new Try(1)).display(), Matchers.equalTo(2));
	}
	
	@Test
	public void calculateFrameWithSplit() throws Exception {
		assertThat(new Frame().add(new Try(9)).add(new Try(1)).extraPinsForSplit(new Try(1)).display(),
				Matchers.equalTo(11));
		
	}
	
	@Test
	public void calculateGameWithTenFrames() throws Exception {
		assertThat(new Game().add(new Frame().add(new Try(1)).add(new Try(1)))
			          .add(new Frame().add(new Try(1)).add(new Try(1)))
			          .add(new Frame().add(new Try(1)).add(new Try(1)))
			          .add(new Frame().add(new Try(1)).add(new Try(1)))
			          .add(new Frame().add(new Try(1)).add(new Try(1)))
		    		  .add(new Frame().add(new Try(1)).add(new Try(1)))
			          .add(new Frame().add(new Try(1)).add(new Try(1)))
			          .add(new Frame().add(new Try(1)).add(new Try(1)))
			          .add(new Frame().add(new Try(1)).add(new Try(1)))
			          .add(new Frame().add(new Try(1)).add(new Try(1)))
			          .display(),
		          Matchers.equalTo(20));
	}
	
	@Test
	public void calculateGameWithASplit() throws Exception {
		assertThat(new Game().add(new Frame().add(new Try(9)).add(new Try(1)))
		          .add(new Frame().add(new Try(1)).add(new Try(1)))
		          .add(new Frame().add(new Try(1)).add(new Try(1)))
		          .add(new Frame().add(new Try(1)).add(new Try(1)))
		          .add(new Frame().add(new Try(1)).add(new Try(1)))
	    		  .add(new Frame().add(new Try(1)).add(new Try(1)))
		          .add(new Frame().add(new Try(1)).add(new Try(1)))
		          .add(new Frame().add(new Try(1)).add(new Try(1)))
		          .add(new Frame().add(new Try(1)).add(new Try(1)))
		          .add(new Frame().add(new Try(1)).add(new Try(1)))
		          .display(),
	          Matchers.equalTo(31));
	}

}
