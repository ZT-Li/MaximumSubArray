package MaxSubArray;

public class MaxSubArray {
	// the first algorithm to find the maximum subarray with a runtime of O(n^2)
	public static Plan func1(int[] a) {
		int max = 0;
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < a.length; i++) {
			int maxTemp = a[i];
			for (int j = i; j < a.length; j++) {
				if (i != j)
					maxTemp += a[j];
				if (maxTemp > max) {
					max = maxTemp;
					index1 = i;
					index2 = j;
				}
			}
		}
		if (index2 == 0)
			index1 = -1;
		return new Plan(max, index1, index2);
	}

	// the second algorithm to find the maximum subarray with a runtime of O(n lg n)
	public static Plan func2(int[] a, int first, int last) {
		if (first == last)
			return new Plan(a[first], first, last);
		else {
			int mid = (first + last) / 2;
			Plan middle = MaxSubArray.midMax(a, first, mid, last);
			Plan left = MaxSubArray.func2(a, first, mid);
			Plan right = MaxSubArray.func2(a, mid + 1, last);
			return MaxSubArray.getMax(left, right, middle);
		}
	}

	// helper for func2, it will return the max sum from three object
	public static Plan getMax(Plan a, Plan b, Plan c) {
		int temp = Math.max(a.getSum(), b.getSum());
		int max = Math.max(temp, c.getSum());
		if (max < 1)
			return new Plan(0, -1, 0);
		else if (max == a.getSum())
			return a;
		else if (max == b.getSum())
			return b;
		else
			return c;
	}

	// helper for func2, get the crossing sum
	public static Plan midMax(int[] a, int low, int mid, int high) {
		int leftIndex = mid;
		int rightIndex = mid;
		int leftMax = a[mid];
		int rightMax = 0;
		int leftTemp = 0;
		int rightTemp = 0;
		for (int i = mid; i >= low; i--) {
			leftTemp += a[i];
			if (leftTemp > leftMax) {
				leftMax = leftTemp;
				leftIndex = i;
			}
		}
		for (int j = mid + 1; j <= high; j++) {
			rightTemp += a[j];
			if (rightTemp > rightMax) {
				rightMax = rightTemp;
				rightIndex = j;
			}
		}
		return new Plan(leftMax + rightMax, leftIndex, rightIndex);
	}

	// the third algorithm to find the maximum subarray with a runtime of O(n)
	public static Plan func3(int[] a) {
		int max = 0;
		int index1 = 0;
		int index2 = 0;
		int maxTemp = 0;
		int index1Temp = 0;
		for (int i = 0; i < a.length; i++) {
			maxTemp += a[i];
			if (maxTemp > max) {
				max = maxTemp;
				index1 = index1Temp;
				index2 = i;
			}
			if (maxTemp < 0) {
				maxTemp = 0;
				index1Temp = i + 1;
			}
		}
		if (index2 == 0)
			index1 = -1;
		return new Plan(max, index1, index2);
	}
}