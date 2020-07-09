package com.example.coding.array;

import java.util.HashMap;
import java.util.Map;

public class StringsExmples {

	public static void main(String[] args) {
		String str = new String("Pallavi");
		//Util.findOccurance(str, str.length());
		String s = "abbc";
		//Util.permutation(s, s.length());

		int a[]=new int[]{-10,-1,-18,-19};
		int t[] = twoSum(a, -19);
		System.out.println();
		Util.print(t, t.length);
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int t = target - nums[i];
			if(null != map.get(t))
				return new int[]{map.get(t), i};
			else
				map.put(nums[i], i);
		}
		return null;
	}

}
