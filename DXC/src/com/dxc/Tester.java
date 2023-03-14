package com.dxc;

// DXC tech interview
class Conversion {
	static String ref = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
	static char offsetChar = 'B';

	public static int findIndex(char offsetChar) {
		// finding the index of the offset char
		int offsetIndex = 0;
		for (int i = 0; i < ref.length(); i++) {
			if (offsetChar == ref.charAt(i)) {
				offsetIndex = i;
			}
		}
		return offsetIndex;
	}

	public static String shiftTable(int offsetIndex) {
		// re-arrange ref string using StringBuilder
		StringBuilder sb = new StringBuilder();
		for (int i = ref.length() - offsetIndex; i < ref.length(); i++) {
			sb.append(ref.charAt(i));
		}
		for (int i = 0; i < ref.length() - offsetIndex; i++) {
			sb.append(ref.charAt(i));
		}
		return sb.toString();
	}

	public static String encode(String plainText) {
		// find offset char index
		int offsetIndex = findIndex(offsetChar);

		// re-arrange ref by offset character
		String newRef = shiftTable(offsetIndex);

		// encode
		StringBuilder encodedSB = new StringBuilder();
		encodedSB.append(ref.charAt(offsetIndex)); // append offset char
		for (int i = 0; i < plainText.length(); i++) {
			for (int j = 0; j < newRef.length(); j++) {
				// if plainText is space
				if (plainText.charAt(i) == ' ') {
					encodedSB.append(" ");
					break;
					// if plainText char == ref char
				} else if (plainText.charAt(i) == ref.charAt(j)) {
					encodedSB.append(newRef.charAt(j)); // append encoded char
				}
			}
		}
		return encodedSB.toString();
	}

	public static String decode(String encodedText) {
		// set offset char as first index of encodedText
		char offsetChar = encodedText.charAt(0);

		// find offset char index
		int offsetIndex = findIndex(offsetChar);

		// re-arrange ref by offset character
		String newRef = shiftTable(offsetIndex);

		// decode
		StringBuilder decodedSB = new StringBuilder();
		for (int i = 1; i < encodedText.length(); i++) {
			for (int j = 0; j < newRef.length(); j++) {
				// if encodedText is space
				if (encodedText.charAt(i) == ' ') {
					decodedSB.append(" ");
					break;
					// if encodedText char == new ref char
				} else if (encodedText.charAt(i) == newRef.charAt(j)) {
					decodedSB.append(ref.charAt(j)); // append decoded char
				}
			}
		}
		return decodedSB.toString();
	}
}

public class Tester {
	public static void main(String[] args) {
		System.out.println("Encode: " + Conversion.encode("HELLO WORLD"));
		System.out.println("Decode: " + Conversion.decode("FC/GGJ RJMG."));

		System.out.println("Encode: " + Conversion.encode("BEAUTIFUL DAY"));
		System.out.println("Decode: " + Conversion.decode("BAD/TSHETK C/X"));

	}
}
