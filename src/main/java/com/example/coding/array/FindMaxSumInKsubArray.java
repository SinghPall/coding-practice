package com.example.coding.array;

public class FindMaxSumInKsubArray {

	public static void main(String[] args) {
		int arr[] = new int[]{ 1, 4, 2, 10, 2, 3, 1, 0, 20 }, k = 4;
		System.out.println(maxSumInKSubArray(arr, arr.length, k));
	}
	/* Find max sum in sub array of size k of given array of size n
	 * {5, 2, -1, 0, 3} k = 3 and n = 5
	 * o/p= 6 || how : sum of subarray (5,2,-1), (2,-1,0), (-1,0,3)
	 *  Will calculate sum of K elemnet in CurrSum, then start a for loop again with i=k till n
	 *  each time subtract element form strat of array
	 * */
	public static int maxSumInKSubArray(int[] a, int n, int k){
		if(n <= 0 || n<k) return -1;
		int currSum = 0, maxSum = -1;
		
		for(int i=0; i<k; i++)
			currSum += a[i];
		maxSum = currSum;
		for(int i=k; i<n; i++){
			currSum += a[i] - a[i-k]; // adding last element in k range and subtracting initial ele, by sliding window
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}
}
