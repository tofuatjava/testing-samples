package at.tfuerer.sample.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private final List<Try> tries = new ArrayList<>(3);
	private int extraPinsForSplit = 0;
	
	public Frame add(Try trie) throws BowlingException {
		if (tries.size() > 3)
			throw new BowlingException("Too many tries for a frame.");
		tries.add(trie);
		
		return this;
	}

	public int display() {
		return tries.stream().mapToInt(t -> t.getPins()).sum() + this.extraPinsForSplit;
	}

	public Frame extraPinsForSplit(Try trie) {
		this.extraPinsForSplit = trie.getPins();
		
		return this;
	}

}
