package com.example.coding.array;

public class FindMinEleInSortedAndRotatedArray {

	public static void main(String[] args) {
		int arr[] = /*{2, 3, 4, 5, 6, 7, 8, 9, 10, 1};*/{8, 9, 11, 2, 3, 4, 5,6,7};
		System.out.println(findMin(arr, 0, arr.length-1));
	}
	public static int findMin(int arr[], int l, int h){
		if(l>h) return arr[0];
		if(l == h) return arr[l];
		int mid = (l+h)/2;
		if(mid > l && arr[mid] < arr[mid - 1])
			return arr[mid];
		else if(mid < h && arr[mid+1] < arr[mid])
			return mid+1;
		if(arr[mid] > arr[h])
			return findMin(arr, mid+1, h);
		return findMin(arr, l, mid-1);
		
	}
}
