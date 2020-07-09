package com.example.coding.array;

import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		System.out.println(new RegularExpression().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
		//System.out.println(Pattern.matches("*", "aa")); // runtime exception
		System.out.println(Pattern.matches("a", "aa"));//false
		System.out.println(Pattern.matches("a*", "aa"));//true
		System.out.println(Pattern.matches(".*", "ab"));//true
		System.out.println(Pattern.matches("c*a*b*", "aab"));//true
		System.out.println(Pattern.matches("mis*is*p*.", "mississippi"));//true
	}
	 public int maxArea(int[] height) {
	        if(height.length == 0 || height.length ==1) return 0;
	        int l=0, r=height.length-1, maxArea = Integer.MIN_VALUE;
	        while(l<r){
	            int area = Math.min(height[l], height[r]) * (r-l);
	            maxArea = area > maxArea ? area : maxArea;
	            
	            if(height[l] < height[r]) l++;
	            else r--;
	        }
	        return maxArea;
	    }

}
