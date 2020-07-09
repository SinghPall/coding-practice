package com.example.coding.array;

import java.util.LinkedHashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {

	public static void main(String[] args) {
		int a[] = {15, -2, 2, -8, 1, 7, 10, 23};/*{1,3,-1,2,-4,1}; null; */
		int l = (null != a ? a.length : 0);
		Util.print(a, l);
		int res[] = findSubArrayWithSumZero(a);
		Util.print(res, (null != res ? res.length : 0));
	}

	public static int[] findSubArrayWithSumZero(int a[]){
		int start = -1, endIn = -1;
		if(null != a && a.length == 1 && a[0] == 0) return new int[]{0,0};
		if(null != a && a.length > 1){ // 1,3,-1,2,-4,1
			//converting given array into prefix sum array
			for(int i=1; i<a.length; i++)
				a[i] = a[i] + a[i-1];
			Util.print(a, a.length);
			
			Map<Integer, Integer> map = new LinkedHashMap<>();
			map.put(a[0], 0);
			int key=0, max = -1, end = 0;
			for(int i=1; i<a.length; i++){ //creating prefix sum in same array
				key = a[i];
				end = i;
				if(map.containsKey(key)){
					if(max < (end - map.get(key))){
						start = map.get(key) + 1;
						endIn = i;
						max = endIn - map.get(key);
					}
				}else
					map.put(key, i);
			} 
			// converting prefixsum array in its original state
			for(int i=a.length-1; i>0; i--)
				a[i] = a[i] - a[i-1];
			Util.print(a, a.length);
		}
		return new int[]{start, endIn};
	}
}
