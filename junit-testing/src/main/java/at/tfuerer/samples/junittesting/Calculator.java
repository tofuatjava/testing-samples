package at.tfuerer.samples.junittesting;

public final class Calculator {
	public int add(int v1, int v2) {
		return v1+v2;
	}
	
	public String toHex(int value) {
		return Integer.toHexString(value);
	}
}
