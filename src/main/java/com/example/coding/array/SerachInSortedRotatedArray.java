package com.example.coding.array;

public class SerachInSortedRotatedArray {

	public static void main(String[] args) {
		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int key = 6;
		System.out.println("Found at : "+searchInSortedRotatedArray(arr, 0, arr.length-1, key)+"th position");
	}
	public static int searchInSortedRotatedArray(int a[], int l, int h, int key){
		if(l>h) return -1;
		int mid = (l+h)/2;
		if(a[mid] == key) return mid+1;
		// after finding mid index, one part must be sorted part
		if(a[l] <= a[mid]){  //if left part is sorted, then need to check if key is in range of this part
			if(key >= a[l] && key <= a[mid])
				return searchInSortedRotatedArray(a, l, mid-1, key);
			return searchInSortedRotatedArray(a, mid+1, h, key); // if key is not in range then go to right part
		}
		if(key >= a[mid] && key <= a[h]){ //else right part MUST be sorted, so checking if key is in range 
			return searchInSortedRotatedArray(a, mid+1, h, key);
		}
		return searchInSortedRotatedArray(a, mid-1, h, key);
	}
}
