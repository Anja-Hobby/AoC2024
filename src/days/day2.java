package days;

import java.util.ArrayList;

import Basics.AoCReader;
import Basics.Checkers;

public class day2 {
	public static void main(String[] args) {
		try {
			// Obtain the list
			ArrayList<ArrayList<Integer>> input;
			input = AoCReader.readNumbers("H:\\AoC\\2.txt");
			challenge_01(input);
			challenge_02(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void challenge_01(ArrayList<ArrayList<Integer>> lists) {
		int safeReports=0;
		for (ArrayList<Integer> list : lists) {
			if (Checkers.maxDistanceBetweenNumbers(3, list) && (Checkers.strictAscending(list) || Checkers.strictDescending(list))) {
				safeReports++;
			} 
		}
		System.out.println(" The number of safe reports are: " + safeReports);
	}
	
	private static void challenge_02(ArrayList<ArrayList<Integer>> lists) {
		int safeReports = 0;
		for (ArrayList<Integer> list : lists) {
			if (Checkers.maxDistanceBetweenNumbers(3, list) && (Checkers.strictAscending(list) || Checkers.strictDescending(list))) {
				safeReports++;
			} else {
				for (int i = 0; i < list.size(); i++) {
					ArrayList<Integer> listWithOneRemoved = ((ArrayList<Integer>)list.clone());
					listWithOneRemoved.remove(i);
					if (Checkers.maxDistanceBetweenNumbers(3, listWithOneRemoved) && (Checkers.strictAscending(listWithOneRemoved) || Checkers.strictDescending(listWithOneRemoved))) {
						safeReports++;
						break;
					}
				}
			}
		}
		System.out.println(" The number of safe reports are: " + safeReports);
	}
}
