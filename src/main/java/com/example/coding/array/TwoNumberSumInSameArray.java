package com.example.coding.array;

import java.util.Arrays;

public class TwoNumberSumInSameArray {

	public static void main(String[] args) {
		int a[] = new int[]{5, 32, 1, 7, 10, 50, 19, 21, 2};
		System.out.println(findTripletTwoSumEqualToThirdNum(a));
	}
	public static int findTripletTwoSumEqualToThirdNum(int a[]){
		int i=0, j=0, res = 0, sum = 0;
		Arrays.sort(a);
		for(int k=a.length-1; k>=0; k--){
			i=0; j = k-1;
			while(i<j){
				sum = a[i] + a[j]; 
				if(sum == a[k]){
					System.out.println(a[i] +", "+ a[j] +", "+ a[k]);
					res++; i++; j--;
				}else if(sum > a[k]) j--;
				else i++;
			}
		}
		return res;
	}
}
