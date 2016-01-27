package at.tfuerer.sample.bowling;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class BowlingScoreboardTest {

	private BowlingScoreboard bowlingScoreboard;

	@Before
	public void setup() {
		bowlingScoreboard = new BowlingScoreboard();
	}
	
	@Test
	public void startAGame() {
		assertThat(bowlingScoreboard.start(), Matchers.isA(Game.class));
		assertThat(bowlingScoreboard.start().calculate(), Matchers.equalTo(0));
	}

}
