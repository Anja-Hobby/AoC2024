package days;

import java.util.ArrayList;
import Basics.AoCReader;

public class day4 {
	static String fileLocation = "H:\\AoC\\4.txt";
	public static void main(String[] args) {
		try {
			// Obtain the list
			ArrayList<String> input = AoCReader.readLines(fileLocation);
			input.addAll(AoCReader.readDiagonals(fileLocation));
			input.addAll(AoCReader.readColumns(fileLocation));
			System.out.println(" there are " + input.size() + "  lines to read ");
			challenge_01(input);
			ArrayList<String> ch2input = AoCReader.readLines(fileLocation);
			challenge_02(ch2input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void challenge_01(ArrayList<String> lists) {
		int count = 0;
		for (String line: lists) {
			count = count + countMatches(line, "XMAS") + countMatches(line, "SAMX");
		}
		System.out.println(" we've found the word XMAS this many times: " + count);
	}

	private static void challenge_02(ArrayList<String> lists) {
		int count = 0;
		for (int i = 1; i<lists.size()-1;i++) {
			int index = 0;
			while (index >= 0 && index < lists.get(i).length()-1 ) {
				if (index != 0) {
					count = count + checkIfValidXofMAS( lists.get(i-1).charAt(index-1), 
							lists.get(i-1).charAt(index+1), 
							lists.get(i+1).charAt(index-1), 
							lists.get(i+1).charAt(index+1));
				}
				index = lists.get(i).indexOf('A', index+1);
			}
		}

		System.out.println(" The result of the multiplications is " + count);
	}


	private static int checkIfValidXofMAS(char topLeft, char topRight, char bottomLeft, char bottomRight) {
		if ((topLeft == 'M' && bottomRight =='S') || (topLeft == 'S' && bottomRight == 'M')) {
			if ((topRight == 'M' && bottomLeft =='S') || (topRight == 'S' && bottomLeft == 'M')) {
				return 1;
			}

		}
		return 0;
	}

	public static int countMatches(String line, String searchterm){
		int count = 0;
		int i = line.indexOf(searchterm); 
		while (i >= 0) {
			count++;
			i = line.indexOf(searchterm,i+1);
		}
		return count;
	}
}
