package Basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class checkersTest {
	private ArrayList<Integer> ascendingList, descendingList, randomList, emptyList, singleList;
	@BeforeEach
	void setUp() throws Exception{
		ascendingList = new ArrayList<>();
		ascendingList.addAll(Arrays.asList(1,2,3,4,5));
		descendingList = new ArrayList<>();
		descendingList.addAll(Arrays.asList(5,4,3,2,1,0));
		randomList = new ArrayList<>();
		randomList.addAll(Arrays.asList(3, 6, 2, 1, 7));
		emptyList = new ArrayList<>();
		singleList = new ArrayList<>();
		singleList.add(1);
	}

	@Test
	void testStrictAscending() {
		assertEquals(true, Checkers.strictAscending(ascendingList));
		assertEquals(false, Checkers.strictAscending(descendingList));
		assertEquals(false, Checkers.strictAscending(randomList));
		assertEquals(false, Checkers.strictAscending(emptyList));
		assertEquals(true, Checkers.strictAscending(singleList));
	}
	
	@Test
	void testStrictDescending() {
		assertEquals(false, Checkers.strictDescending(ascendingList));
		assertEquals(true, Checkers.strictDescending(descendingList));
		assertEquals(false, Checkers.strictDescending(randomList));
		assertEquals(false, Checkers.strictDescending(emptyList));
		assertEquals(true, Checkers.strictDescending(singleList));
	}
	
	@Test
	void testMaxDistanceBetweenNumbers() {
		assertEquals(false, Checkers.maxDistanceBetweenNumbers(0, ascendingList));
		assertEquals(true, Checkers.maxDistanceBetweenNumbers(1, ascendingList));
		assertEquals(true, Checkers.maxDistanceBetweenNumbers(2, ascendingList));
		assertEquals(false, Checkers.maxDistanceBetweenNumbers(0, descendingList));
		assertEquals(true, Checkers.maxDistanceBetweenNumbers(1, descendingList));
		assertEquals(true, Checkers.maxDistanceBetweenNumbers(2, descendingList));
		assertEquals(false, Checkers.maxDistanceBetweenNumbers(5, randomList));
		assertEquals(true, Checkers.maxDistanceBetweenNumbers(6, randomList));
		assertEquals(false, Checkers.maxDistanceBetweenNumbers(1000, emptyList));
		assertEquals(true, Checkers.maxDistanceBetweenNumbers(0, singleList));
	}

}
