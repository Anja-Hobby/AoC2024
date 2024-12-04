package Basics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class AoCReader {

	/**
	 * Get the file from disk ready for use.
	 * @param filePath
	 * @return The contents of the files, with every line as a separate string in an ArrayList<String>.
	 * @throws Exception
	 */
	public static ArrayList<String> readLines(String filePath) throws Exception {
		File file = new File(filePath); 
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> lines = new ArrayList<>();
		String ss;
		while ((ss=(String) br.readLine())!= null) {
			lines.add(ss);
		}
		br.close();
		return lines;
	}
	
	/**
	 * Get the numbers (not digits!) from every line in a separate ArrayList.
	 * @param filePath
	 * @return The digits in the file, with every digit as a separate number, and every line as a separate ArrayList of numbers.
	 * @throws Exception
	 */
	public static ArrayList<ArrayList<Integer>> readNumbers(String filePath) throws Exception {
		ArrayList<String> lines = readLines(filePath);
		ArrayList<ArrayList<Integer>> allNumbers = new ArrayList<>();
		for (String line : lines) {
			ArrayList<Integer> numbersInThisLine = new ArrayList<>();
			String[] parts = line.split("\\D+"); // split the string at non digit parts
			for (String part : parts) {
				if (!part.isEmpty()) {
					numbersInThisLine.add(Integer.parseInt(part));
				}
			}
			allNumbers.add(numbersInThisLine);
		}
		return allNumbers;
	}
	
	/**
	 * Get the numbers (not digits!) from every column in a separate ArrayList. (Assumes the same amount of datapoints in every line)
	 * @param filePath
	 * @return The digits in the file, with every digit as a separate number, and every column as a separate ArrayList of numbers.
	 * @throws Exception
	 */
	public static ArrayList<ArrayList<Integer>> readNumbersInColumns(String filePath) throws Exception {
		ArrayList<ArrayList<Integer>> numbersAsLines = readNumbers(filePath);
		ArrayList<ArrayList<Integer>> numbersAsColumns = new ArrayList<>();
		// generate the array lists
		for (Integer number: numbersAsLines.get(0)) {
			ArrayList<Integer> column = new ArrayList<>();
			numbersAsColumns.add(column);
		}
		// sort the numbers into the array lists.
		for (ArrayList<Integer> numbersInLine: numbersAsLines) {
			for (int i = 0; i < numbersAsColumns.size(); i++ ) {
				numbersAsColumns.get(i).add(numbersInLine.get(i));
			}
		}
		return numbersAsColumns;
	}

}