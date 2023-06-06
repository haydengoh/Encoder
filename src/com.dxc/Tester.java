package com.dxc;

public class Tester {
	public static void main(String[] args) {
		// encode with offset char 'G'
		Encode e = new Encode('G');
		String test1 = e.encode("HELLO WORLD");
		
		// encode with offset char 'K'
		Encode e2 = new Encode('K');
		String test2 = e2.encode("BEAUTIFUL DAY");
		
		// decode
		String test3 = e.decode("GB.FFI QILF-"); // offset char 'G'
		String test4 = e.decode("CFCJJM UMPJB"); // offset char 'C'
		String test5 = e.decode("K9*8KJ.+KB )8O"); // offset char 'K'
		String test6 = e.decode("O584GF*9G- 74K"); // offset char 'O'
		
		
		System.out.println("ENCODE:");
		System.out.println(test1);
		System.out.println(test2);
		
		System.out.println("\nDECODE:");
		System.out.println(test3);
		System.out.println(test4);
		System.out.println(test5);
		System.out.println(test6);
	}
}
