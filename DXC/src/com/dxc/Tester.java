package com.dxc;

public class Tester {
	public static void main(String[] args) {
		Conversion c = new Conversion('G');
		String test1 = c.encode("HELLO WORLD");
		String test2 = c.decode("BGDKKN VNQKC");
		System.out.println(test1);
		System.out.println(test2);
		
		Conversion c2 = new Conversion('K');
		String test3 = c2.encode("BEAUTIFUL DAY");
		String test4 = c2.decode("BAD/TSHETK C/X");
		System.out.println(test3);
		System.out.println(test4);
	}
}
