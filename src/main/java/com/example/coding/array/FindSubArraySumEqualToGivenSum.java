package com.example.coding.array;

import java.util.HashMap;
import java.util.Map;

public class FindSubArraySumEqualToGivenSum {
	// int arr[] to set : Arrays.stream.colect(Collectors.toSet())
	public static void main(String args[]){
		//int array[] = { 1, 4, 5, 2, 3, 15, 5}; int k=5; //o/p : 4 
		//int array[] = {-1, -1, 1};int k = 0;// o/p=> 1
		//int array[] = {1,1,1}; int k = 2; //o/p=> 2
		int array[] = {1}; int k = 0; //o/p=> 0
		//int array[] = {0,0,0,0,0,0,0,0,0,0}; int k = 0; // op=> 55
		int size = array.length; 
		int count = countSubArray(array, size, k); 
		System.out.println(count); 
	}
	public static int countSubArray(int a[], int n, int k){
		if(n>0){
			Map<Integer, Integer> map = new HashMap<>();
			int sum = 0, res  = 0;
			map.put(0,  1);
			for(int i=0; i<n; i++){
				sum += a[i];

				if(map.containsKey(sum - k))
					res += map.get(sum - k);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
			return res;
		}
		return -1;
	}
}
