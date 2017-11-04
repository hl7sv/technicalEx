import java.util.*;
public class HW1 {

	public static void main(String[] args) {
		//print out pi with 5 digits after the decimal point
		System.out.println(pi(5) + " should equal 3.14159");
		//print out pi with 2 digits after the decimal point
		System.out.println(pi(2) + " should equal 3.14");
		//print out the date of Easter in 2015
		System.out.println("Easter in 2015 should have been on April 5 and according to the program it was on " +easter(2015));
		//print out the date of Easter in 2000
		System.out.println("Easter in 2000 should have been on April 23 and according to the program it was on " +easter(2000));
		//Lets the user know if jumping on Hailey's comet at 1000000 mph will allow an astronaut to escape its gravitational field 
		System.out.println(escape(1000000));
		//Lets the user know if jumping on Hailey's comet at 1 mph will allow an astronaut to escape its gravitational field 
		System.out.println(escape(1));
		//outputs 25 random integers
		System.out.println(Arrays.toString(random(5,500,1000,499))); //should output [7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49, 51, 53, 55]
		//outputs 25 random integers
		System.out.println(Arrays.toString(random(8,70,10,99))); //should output [75, 13, 29, 60, 52, 86, 90, 73, 71, 30, 31, 2, 51, 16, 41, 9, 46, 62, 93, 85, 20, 24, 7, 5, 63]
	}
	public static double pi(int n) {
		double pi = 1;
		int counter = 0;
		double denom = 3;
		while (counter < 1000000) {
			if (counter % 2 == 0) {
				pi -= 1/denom;
				counter++;
				denom += 2;
			} else {
				pi += 1/denom;
				counter++;
				denom += 2;
			}
		}
		String piString = Double.toString(pi * 4);
		String rightLength = piString.substring(0, 2 + n);
		return Double.parseDouble(rightLength);	
	}
	public static String easter(int y) {
		int a = y % 19;
		int b = y / 100;
		int c = y % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = (19 * a + b - d - g + 15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2* j - k - h + m + 32) % 7;
		int n = (h - m + r + 90) / 25;
		int p = (h - m + r + n + 19) % 32;
		if (n == 3) {
			return "March " + p;
		}
		return "April " + p;
	}
	public static String escape(double v) {
		double metersPerSec = (v * 1609.34) * (1 / 3600.0);
		double escape = Math.sqrt((2 * 6.67 * Math.pow(10.0,  -11.0) * 1.3 * Math.pow(10.0, 22.0)) / (1.153 * Math.pow(10.0,  6.0)));
		if (metersPerSec >= escape) {
			double massToPreventEscape = (Math.pow(metersPerSec, 2) * 1.153 * Math.pow(10,  6)) / (2 * 6.67 * Math.pow(10,  -11));
			return "If the astonaut jumps at " + v + " mph, the astronaut will not return to Hailey’s Comet. In order to return, the comet would need to have a mass larger than " + massToPreventEscape + " kg";	
		}
		return "If the astonaut jumps at " + v + " mph, the astronaut will return to Hailey’s Comet.";
	}
	public static int[] random(int r, int a, int b, int m) {
		int [] result = new int[25];
		int rNew = 0;
		for (int i = 0; i < 25; i++) {
			rNew = (a * r + b) % m;
			result[i] = rNew;
			r = rNew;
		}	
		return result;
	}
}
