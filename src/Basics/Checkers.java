package Basics;

import java.util.ArrayList;
import java.util.Collections;

public class Checkers {
	public static boolean strictAscending(ArrayList<Integer> list) {
		if (list.isEmpty()) {
			return false;
		} else if (list.size()==1) { // solve edge case of only 1 number.
			return true;
		}
		int before;
		int after;
		for (int i = 1; i<list.size(); i++) {
			before = list.get(i-1);
			after = list.get(i);
			if (before >= after) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean strictDescending(ArrayList<Integer> list) {
		Collections.reverse(list);
		return strictAscending(list);
	}
	
	public static boolean maxDistanceBetweenNumbers(int max, ArrayList<Integer> list) {
		if (list.isEmpty()) {
			return false;
		} else if (list.size()==1) {
			return true;
		}
		int before;
		int after;
		for (int i = 1; i<list.size(); i++) {
			before = list.get(i-1);
			after = list.get(i);
			if (Math.abs(before-after)>max) {
				return false;
			}
		}
		return true;
	}
}
