package at.tfuerer.sample.bowling;

import java.util.ArrayList;
import java.util.List;

public final class Game {
	private final List<Frame> frames = new ArrayList<>(10);

	/**
	 * Hide the default constructor to not allow creating a Game object without
	 * scoreboard.
	 */
	Game() {
	}

	Game add(Frame frame) throws BowlingException {
		if (frames.size() > 10) {
			throw new BowlingException("Too many frames in a game. Max ten frames.");
		}
		frames.add(frame);

		return this;
	}

	public Game addTry(int pins) throws BowlingException {
		Frame lastFrame = this.frames.isEmpty() ? null : this.frames.get(this.frames.size() - 1);
		if (lastFrame != null && lastFrame.isIncomplete()) {
			lastFrame.add(new Try(pins));
			if (this.frames.size() > 1 && this.frames.get(this.frames.size()-2).isStrike()) {
				this.frames.get(this.frames.size()-2).extraPins(pins);
			}
		} else {
			if (lastFrame != null) {
				if (lastFrame.isStrike()) {
					lastFrame.extraPins(pins);
					if (this.frames.size() > 1 && pins == 10) { // at least a double strike, jippi
						this.frames.get(this.frames.size()-2).extraPins(pins);
					}
				} else if (lastFrame.isSplit()) {
					lastFrame.extraPins(pins);
				}				
			}
			this.add(new Frame().add(new Try(pins)));
		}
		return this;
	}

	public int calculate() {
		return frames.stream().mapToInt(f -> f.calculate()).sum();
	}

}
