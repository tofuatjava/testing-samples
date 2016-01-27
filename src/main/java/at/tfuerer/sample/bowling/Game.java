package at.tfuerer.sample.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public final List<Frame> frames = new ArrayList<>(10);
	
	public Game add(Frame frame) throws BowlingException {
		if (frames.size() > 10)
			throw new BowlingException("Too many frames in a game. Max ten frames.");
		frames.add(frame);
		
		return this;
	}

	public int display() {
		return frames.stream().mapToInt(f -> f.display()).sum();
	}

}
