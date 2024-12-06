package days;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Basics.AoCReader;
import Basics.Checkers;

public class day3 {
	public static void main(String[] args) {
		try {
			// Obtain the list
			ArrayList<String> input;
			input = AoCReader.readLines("H:\\AoC\\3.txt");
			challenge_01(input);
			challenge_02(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void challenge_01(ArrayList<String> lists) {
		// Create a pattern
		Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
		int sum = 0;
		// turn it into one string
		String fullstring = "";
		for (String  str: lists) {
			fullstring=fullstring+str;
		}

		Matcher matcher = pattern.matcher(fullstring);
		while (matcher.find()) {
			matcher.start();
			int num1 = Integer.parseInt(matcher.group(1));
			int num2 = Integer.parseInt(matcher.group(2));
			sum = sum + (num1 * num2);
		}

		System.out.println(" The result of the multiplications is " + sum);
	}

	private static void challenge_02(ArrayList<String> lists) {
		// Create a pattern
		Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
		int sum = 0;
		// turn it into one string
		String fullstring = "";
		for (String  str: lists) {
			fullstring=fullstring+str;
		}

		Matcher matcher = pattern.matcher(fullstring);
		while (matcher.find()) {
			matcher.start();
			int num1 = Integer.parseInt(matcher.group(1));
			int num2 = Integer.parseInt(matcher.group(2));
			int index = matcher.start();
			if (fullstring.lastIndexOf("don't()", index) <= fullstring.lastIndexOf("do()", index)) {
				sum = sum + (num1 * num2);
			}
		}

		System.out.println(" The result of the multiplications is " + sum);
	}
}
