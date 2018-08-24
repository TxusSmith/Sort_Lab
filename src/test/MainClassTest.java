package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.MainClass;

public class MainClassTest {

private MainClass main;
	
	private void setupStage1(){
		main = new MainClass();
	}

	@Test
	public void testMergeSort1() {
		setupStage1();
		double[] list = {2, 4, 6, 8, 1, 0, 3, 1, 5, 8, 7, 6, 9, 11, 10};
		main.mergeSort(list, 0, list.length-1);
		assertTrue(list[0] == 0 && list[list.length-1] == 11);
	}
	
	@Test
	public void testMergeSort2() {
		setupStage1();
		double[] list = {20, 45, 263, 42, 8, 132, 456, 321, 485};
		main.mergeSort(list, 0, list.length-1);
		assertTrue(list[0] == 8 && list[list.length-1] == 485);
	}
	
	@Test
	public void testMergeSort3() {
		setupStage1();
		double[] list = {321, 123, 456, 654, 789, 987, 147, 741, 258, 852, 369, 963};
		main.mergeSort(list, 0, list.length-1);
		assertTrue(list[0] == 123 && list[list.length-1] == 987);
	}
	
	@Test
	public void testHeapSort1() {
		setupStage1();
		double[] list = {2, 4, 6, 8, 1, 0, 3, 1, 5, 8, 7, 6, 9, 11, 10};
		main.HeapSort(list);
		assertTrue(list[0] == 0 && list[list.length-1] == 11);
	}
	
	@Test
	public void testHeapSort2() {
		setupStage1();
		double[] list = {20, 45, 263, 42, 8, 132, 456, 321, 485};
		main.HeapSort(list);
		assertTrue(list[0] == 8 && list[list.length-1] == 485);
	}
	
	@Test
	public void testHeapSort3() {
		setupStage1();
		double[] list = {321, 123, 456, 654, 789, 987, 147, 741, 258, 852, 369, 963};
		main.HeapSort(list);
		assertTrue(list[0] == 123 && list[list.length-1] == 987);
	}
	
	@Test
	public void testRadixSort1() {
		setupStage1();
		int[] list = {2, 4, 6, 8, 1, 0, 3, 1, 5, 8, 7, 6, 9, 11, 10};
		main.radixSort(list, list.length);
		assertTrue(list[0] == 0 && list[list.length-1] == 11);
	}
	
	@Test
	public void testRadixSort2() {
		setupStage1();
		int[] list = {20, 45, 263, 42, 8, 132, 456, 321, 485};
		main.radixSort(list, list.length);
		assertTrue(list[0] == 8 && list[list.length-1] == 485);
	}
	
	@Test
	public void testRadixSort3() {
		setupStage1();
		int[] list = {321, 123, 456, 654, 789, 987, 147, 741, 258, 852, 369, 963};
		main.radixSort(list, list.length);
		assertTrue(list[0] == 123 && list[list.length-1] == 987);
	}
}
