package com.example.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
class MyList extends ArrayList<Integer>{
	MyList list = new MyList();
	@Override
	public boolean add(Integer val){
		if(list.size() == 2)
			return false;
		list.add(val);
		return super.add(val);
	}
}
public class SortArrayOfLargeNumGivenAsString {

	public static void main(String[] args) {
		/*MyList l = new MyList();
		System.out.println(l.add(1)); System.out.println(l.add(2)); System.out.println(l.add(3));
		System.out.println(l.add(4));*/
		/*String arr[] = new String[] {"5", "1237637463746732323", "97987", "12" };
		Arrays.asList(arr).forEach(n -> System.out.print(n+", "));
		sortLargeNumberGivenAsString(arr);
		System.out.println();
		Arrays.asList(arr).forEach(n -> System.out.print(n+", "));*/

		int a[] = new int[]{ 12, 10, 102, 31, 15 };
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		sortArrayByReversingTheArray(a);

		/*int matrix[][] = { { 39, 27, 11, 42 }, 
				{ 10, 93, 91, 90 }, 
				{ 54, 78, 56, 89 }, 
				{ 24, 64, 20, 65 } }; 
		printMatrix(matrix);
		int col = 3; // Sort this matrix by 3rd Column 
		sortbyColumn(matrix, col - 1);*/
	}
	public static void sortLargeNumberGivenAsString(String arr[]){
		if(arr.length == 0 || arr.length ==1)
			return;
		Arrays.sort(arr, (n1,n2) ->{
			if(n1.length() != n2.length())
				return n1.length() - n2.length();
			return n1.compareTo(n2);
		});
	}
	public static void sortArrayByReversingTheArray(int arr[]){
		if(arr.length == 0 || arr.length == 1) return;
		Map<Integer, Integer> revSorted = new HashMap<>();
		int tmp = 0;
		for(int i=0; i<arr.length; i++){
			if(null == revSorted.get(arr[i])){
				tmp = arr[i];
				revSorted.put(arr[i], reverse(tmp));
			}
		}//printMap(revSorted);

		/*List<Entry<Integer, Integer>> valueList = new LinkedList<>(revSorted.entrySet());
		Collections.sort(valueList, (v1, v2) ->{
			return v1.getValue().compareTo(v2.getValue());
		});
		System.out.println(valueList);
		int i=0;
		for(Entry<Integer, Integer> v : valueList){
			arr[i++] = v.getKey();
		}
		for(i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");*/
	}
	public static int reverse(int num){
		boolean flag = false;
		if(num < 0) flag = true;
		int s = 0;
		while(Math.abs(num) > 0){
			s = s*10 + num%10; num = num/10;
		}
		if(flag){
			String neg = String.valueOf(s);
			neg = "-"+s;
			s = Integer.parseInt(neg);
		}
		return s;
	}
	public static void sortbyColumn(int[][] mat, int col){
		if(mat.length == 0 || mat[0].length == 0) return;

		Arrays.sort(mat, (int a[], int b[]) ->{
			return a[col] - b[col];
		});
		System.out.println("------------");
		printMatrix(mat);
	}

	public static void printMap(Map<Integer, Integer> m){
		m.forEach((k, v) -> System.out.print(k+"->"+v+", "));
	}
	public static void printMatrix(int [][]mat){
		for(int i =0; i<mat.length; i++){
			for(int j=0; j<mat[i].length; j++)
				System.out.print(mat[i][j]+" ");
			System.out.println();
		}
	}
}
