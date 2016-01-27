package at.tfuerer.sample.bowling;

import java.util.ArrayList;
import java.util.List;

class Frame {
    private final List<Try> tries = new ArrayList<>(3);
	private int extraPinsForSplit = 0;
	
	public Frame add(Try trie) throws BowlingException {
		if (tries.size() > 3)
			throw new BowlingException("Too many tries for a frame.");
		tries.add(trie);
		
		return this;
	}

	public int calculate() {
		return tries.stream().mapToInt(t -> t.getPins()).sum() + this.extraPinsForSplit;
	}

	public Frame extraPins(int pins) {
		this.extraPinsForSplit += pins;
		return this;
	}

	public boolean isSplit() {
		return calculate() >= 10 && tries.size() == 2;
	}
	
	public boolean isStrike() {
		return calculate() >= 10 && tries.size() == 1;
	}

	public boolean isIncomplete() {
		return tries.size() < 2 && (tries.size() == 1 && tries.get(0).getPins() < 10);
	}

}
