package days;

import java.util.ArrayList;
import java.util.Collections;

import Basics.AoCReader;

public class day1 {
	// main class
	public static void main(String[] args) {
		try {
			// Obtain the list
			ArrayList<ArrayList<Integer>> input;
			input = AoCReader.readNumbersInColumns("H:\\AoC\\1a.txt");
			//System.out.println(""+input);
			challenge_01(input.get(0), input.get(1));
			challenge_02(input.get(0), input.get(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void challenge_01(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		Collections.sort(list1);
		Collections.sort(list2);
		int summedAbsoluteDifference = 0;
		for (int i = 0; i < list1.size(); i++) {
			summedAbsoluteDifference = summedAbsoluteDifference + Math.abs(list1.get(i)-list2.get(i));
		}
		System.out.println(" The solution for the first problem of day 1 is " + summedAbsoluteDifference);
	}
	
	private static void challenge_02(ArrayList<Integer> originalNumbersList, ArrayList<Integer> amountOfAppearancesList) {
		int endResult = 0;
		for (int i = 0; i < originalNumbersList.size(); i++) {
			int occurences = Collections.frequency(amountOfAppearancesList, originalNumbersList.get(i));
			endResult = endResult + occurences* originalNumbersList.get(i);
		}
		System.out.println(" The solution for the second problem of day 1 is " + endResult);
	}
}
