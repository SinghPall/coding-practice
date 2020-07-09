package com.example.coding.array;

public class FindPairForGivenSumInSortedRotatedArray {

	public static void main(String[] args) {
		int arr[] = /*{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};*/{15, 6, 8, 9, 10, 11};
		int sum = 120;
		System.out.println(findSumInSortedRotatedArray(arr, arr.length, sum));
 	}
	public static boolean findSumInSortedRotatedArray(int a[], int l, int sum){
		if(l == 0 || l<0) return false;
		int pivot = findStartOfArrayInRotatedArray(a, 0, l-1);
		int s = pivot, e = pivot-1;
		if(e<0) e = l-1;
		
		while(s != e){
			if((a[s] + a[e]) > sum) e = (l+e-1)%l;
			else if((a[s] + a[e]) < sum) s = (s+1)%l;
			else{
				System.out.println(a[s]+", "+a[e]);
				return true;
			}
		}
		return false;
	}
	public static int findStartOfArrayInRotatedArray(int a[], int s, int e){
		if(s < 0) return -1;
		if(s == e) return s;
		int mid = (s+e)/2;
		if(mid > s && a[mid] < a[mid - 1]) return mid;
		else if(mid < e && a[mid+1] < a[mid]) return mid+1;
		else if(a[mid] > a[e]){ // left part is sorted
			return findStartOfArrayInRotatedArray(a, mid+1, e);
		} else
			return findStartOfArrayInRotatedArray(a, s, mid-1);
	}
}
