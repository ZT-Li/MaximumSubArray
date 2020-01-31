package cs146F19.Li.Project2;

import java.util.*;
import java.io.*;

public class tester {
	public static void main(String args[]) {
		int[] a100 = new int[100];
		int[] a200 = new int[200];
		int[] a500 = new int[500];
		int[] a1000 = new int[1000];
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			a100[i] = r.nextInt(100) - 50;
		}
		for (int i = 0; i < 200; i++) {
			a200[i] = r.nextInt(100) - 50;
		}
		for (int i = 0; i < 500; i++) {
			a500[i] = r.nextInt(100) - 50;
		}
		for (int i = 0; i < 1000; i++) {
			a1000[i] = r.nextInt(100) - 50;
		}

		for (int i = 0; i < 10; i++) {
			long t1 = System.nanoTime();
			MaxSubArray.func2(a100, 0, 99);
			long t2 = System.nanoTime();

			long t3 = System.nanoTime();
			MaxSubArray.func2(a200, 0, 199);
			long t4 = System.nanoTime();

			long t5 = System.nanoTime();
			MaxSubArray.func2(a500, 0, 499);
			long t6 = System.nanoTime();

			long t7 = System.nanoTime();
			MaxSubArray.func2(a1000, 0, 999);
			long t8 = System.nanoTime();

			System.out.println("size100: " + (t2 - t1) + ", size200: " + (t4 - t3) + ", size500: " + (t6 - t5)
					+ ", size1000: " + (t8 - t7));
		}
	}
}
