package cs146F19.Li.Project2;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import java.io.*;

public class MaxSubArrayTest {

	@Test
	public void functionTest() {
		int[] a1 = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] a2 = new int[] { -3, -4, -5, -6, -7, -8, -9, -10 };
		assertTrue(MaxSubArray.func1(a1).equals(MaxSubArray.func2(a1, 0, a1.length - 1)));
		assertTrue(MaxSubArray.func3(a1).equals(MaxSubArray.func2(a1, 0, a1.length - 1)));
		assertTrue(MaxSubArray.func1(a1).equals(MaxSubArray.func3(a1)));
		assertTrue(MaxSubArray.func1(a2).equals(MaxSubArray.func2(a2, 0, a2.length - 1)));
		assertTrue(MaxSubArray.func3(a2).equals(MaxSubArray.func2(a2, 0, a2.length - 1)));
		assertTrue(MaxSubArray.func1(a2).equals(MaxSubArray.func3(a2)));
	}

	@Test
	public void getMaxTest() {
		Plan p1 = new Plan(10, 1, 1);
		Plan p2 = new Plan(1, 2, 3);
		Plan p3 = new Plan(2, 3, 4);
		assertTrue(MaxSubArray.getMax(p1, p2, p3).equals(p1));

		Plan p4 = new Plan(-10, 1, 1);
		Plan p5 = new Plan(-1, 2, 3);
		Plan p6 = new Plan(-2, 3, 4);
		assertFalse(MaxSubArray.getMax(p4, p5, p6).equals(p5));
	}

	@Test
	public void midMaxTest() {
		int[] a1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		assertTrue(MaxSubArray.midMax(a1, 0, 5, 9).equals(new Plan(55, 0, 9)));
		int[] a2 = new int[] { 1, 1, 1, 1, -10, 1, 1, 1, 1 };
		assertTrue(MaxSubArray.midMax(a2, 0, 4, 8).equals(new Plan(-2, 0, 8)));
	}

	@Test
	public void fileTest() throws FileNotFoundException {
		Scanner in = new Scanner(new File("maxSumtest.txt"));
		ArrayList<String> str = new ArrayList<String>();
		
		//store each line into a ArrayList
		while (in.hasNextLine())
			str.add(in.nextLine());
		
		//turn each line into a int array
		for (String s : str) {
			if (s.length() > 0) {
				String[] a = s.trim().split("\\s+");
				int[] arr = new int[a.length - 3];
				for (int i = 0; i < a.length - 3; i++) {
					arr[i] = Integer.parseInt(a[i]);
				}
				
				//get the result with all three algorithm
				Plan result1 = MaxSubArray.func1(arr);
				Plan result2 = MaxSubArray.func2(arr, 0, arr.length - 1);
				Plan result3 = MaxSubArray.func3(arr);
				
				//redeem the correct answer from the file data
				int sum=Integer.parseInt(a[a.length-3]);
				int first=Integer.parseInt(a[a.length-2]);
				int last=Integer.parseInt(a[a.length-1]);
				
				//check the answer with the outcome of the algorithm
				assertTrue(result1.equals(new Plan(sum, first, last)));
				assertTrue(result2.equals(new Plan(sum, first, last)));
				assertTrue(result3.equals(new Plan(sum, first, last)));
			}
		}
	}

}
