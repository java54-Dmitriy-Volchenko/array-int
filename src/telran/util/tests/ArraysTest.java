package telran.util.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.util.ArraysInt.*;

import java.util.Arrays;





class ArraysTest {
	int [] array = {10, 25, 30, 40, 100};
	
	
	@Test
	void addNumberTest() {
		int[] arrayExpected = {10, 25, 30, 40, 100, -2};
		
		int[] arrayActual = addNumber(array, -2);

		assertArrayEquals(arrayExpected, arrayActual);
	}
	@Test
	void insertNumberTest() {
		int[] arrayExpectedLast = {10, 25, 30, 40, 100, 25};
		int[] arrayExpectedFirst = { 25, 10, 25, 30, 40, 100};
		int[] arrayExpectedMiddle = { 10, 25, 30, 25, 40, 100};
		int[] arrayActualLast = insertNumber(array, 5, 25);
		int[] arrayActualFirst = insertNumber(array,0, 25);
		int[] arrayActualMiddle = insertNumber(array,3, 25);
		
		assertArrayEquals (arrayExpectedLast, arrayActualLast);
		assertArrayEquals (arrayExpectedFirst, arrayActualFirst);
		assertArrayEquals (arrayExpectedMiddle, arrayActualMiddle);
	}
	@Test
	void removeNumberTest() {
		int[] arrayExpectedLast = {10, 25, 30, 40};
		int[] arrayExpectedFirst = { 25, 30, 40, 100};
		int[] arrayExpectedMiddle = { 10, 25, 40, 100};
		int[] arrayActualLast = removeNumber(array,array.length-1);
		int[] arrayActualFirst = removeNumber(array,0);
		int[] arrayActualMiddle = removeNumber(array,2);
	
		assertArrayEquals (arrayExpectedLast, arrayActualLast);
		assertArrayEquals (arrayExpectedFirst, arrayActualFirst);
		assertArrayEquals (arrayExpectedMiddle, arrayActualMiddle);
	
	}
	@Test
	void insertSortedTest() {
		int[] arrayExpectedLast = {10, 25, 30, 40, 100, 150};
		int[] arrayExpectedFirst = { 10,10, 25, 30, 40, 100};
		int[] arrayExpectedMiddle = { 10, 25, 30, 35, 40, 100};
		int[] arrayActualLast = insertSorted(array, 150);
		int[] arrayActualFirst = insertSorted(array,10);
		int[] arrayActualMiddle = insertSorted(array,35);
		assertArrayEquals (arrayExpectedLast, arrayActualLast);
		assertArrayEquals (arrayExpectedFirst, arrayActualFirst);
		assertArrayEquals (arrayExpectedMiddle, arrayActualMiddle);
	
	}
	
	@Test
	void copyOfTest() {
		int[] arrayExpectedSameLength = {10, 25, 30, 40, 100};
		int[] arrayExpectedLessLength = {10, 25, 30};
		int[] arrayExpectedGraterLength = {10, 25, 30, 40, 100, 0};
		int[] arrayActualSameLength = Arrays.copyOf(array,  array.length );
		int[] arrayActualLessLength = Arrays.copyOf(array, array.length -2);
		int[] arrayActualGraterLength = Arrays.copyOf(array, array.length +1);
		assertArrayEquals(arrayExpectedSameLength, arrayActualSameLength);
		assertArrayEquals(arrayExpectedLessLength, arrayActualLessLength);
		assertArrayEquals(arrayExpectedGraterLength, arrayActualGraterLength);
	}
	
	@Test
	void arraycopyTest() {
		int [] array1 = {3, 10, 20, 15};
		int [] expected = {10, 25, 10, 20, 100};
		int [] arrayCopy = Arrays.copyOf (array, array.length);
		System.arraycopy(array1, 1, arrayCopy, 2, 2);
		assertArrayEquals(expected, arrayCopy);
	}
	@Test
	void binarySearchIntTest() {
		int [] unsortedArray = {25,17,14,38,21,88};
		int key = 25;
		assertFalse(Arrays.binarySearch(unsortedArray, key)==0);
		assertTrue(Arrays.binarySearch(array, key)==1);
		key=101;
		assertEquals(-6, Arrays.binarySearch(array, key));
		key=99;
		assertEquals(-5, Arrays.binarySearch(array, key));
		key=35;
		assertEquals(-4, Arrays.binarySearch(array, key));
		key=-35;
		assertEquals(-1, Arrays.binarySearch(array, key));
		key=-1;
		assertEquals(-1, Arrays.binarySearch(array, key));
	}
	}
	
	

