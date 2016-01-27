package at.tfuerer.sample.bowling;

public class Try {

	private final int pins;

	public Try(int pins) throws BowlingException {
		if (pins < 0)
			throw new BowlingException("Illegal number of pins. Must be positive or zero.");
		else if (pins > 10)
			throw new BowlingException("Illegal number of pins. Must be less or equal to ten.");
		else
			this.pins = pins;
	}

	public int getPins() {
		return pins;
	}
}
