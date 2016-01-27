package at.tfuerer.sample.bowling;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class GameTest {
	
	@Test
	public void addNewTryToGame() throws Exception {
		assertThat(new Game().addTry(5).addTry(4).calculate(), Matchers.equalTo(9));
	}

	@Test
	public void calculateGameWithTenFrames() throws Exception {
		Game game = new Game();
		for (int i=1;i<=10*2;i++) {
			game.addTry(1);
		}
		assertThat(game.calculate(), Matchers.equalTo(20));
	}
	
	@Test
	public void calculateGameWithASplit() throws Exception {
		Game game = new Game();
		game.addTry(9).addTry(1).addTry(5).addTry(0);
		assertThat(game.calculate(), Matchers.equalTo(20));
	}
	
	@Test
	public void calculateGameWithAStrike() throws Exception {
		Game game = new Game();
		game.addTry(10).addTry(5).addTry(4);
		assertThat(game.calculate(), Matchers.equalTo(28));
	}
	
	@Test
	public void calculateFullGame() throws Exception {
		Game game = new Game();
		game.addTry(5).addTry(5)
		    .addTry(10)
		    .addTry(10)
		    .addTry(10)
		    .addTry(9).addTry(0)
		    .addTry(0).addTry(8)
		    .addTry(9).addTry(0)
		    .addTry(7).addTry(0)
		    .addTry(1).addTry(8)
		    .addTry(1).addTry(2);
		assertThat(game.calculate(), Matchers.equalTo(143));
	}

}
