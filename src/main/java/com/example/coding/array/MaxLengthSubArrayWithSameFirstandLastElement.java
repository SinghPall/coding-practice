package com.example.coding.array;

import java.util.HashMap;
import java.util.Map;

class Indexi{
	int first,last;
	public void setLast(int i){last =i;}
	Indexi(int f, int l){first=f; last=l;}
	public String toString(){return "Index("+first+":"+last+")";}
}
public class MaxLengthSubArrayWithSameFirstandLastElement {

	public static void main(String[] args) {
		char arr[] = {'a','b','c','d','a'};//{'g','e','e','k'};
		int a[] = findMaxSubArrayWithSameFirstandLastElem(arr, arr.length);
	}
	public static int[] findMaxSubArrayWithSameFirstandLastElem(char a[], int l){
		Map<Character, Indexi> map = new HashMap<>();
		int max=Integer.MIN_VALUE;
		char key = 0;
		for(int i=0; i<l; i++){
			if(null != map.get(a[i])){
				map.get(a[i]).setLast(i);
				int diff = map.get(a[i]).last - map.get(a[i]).first;
				if(max < diff){
					max = diff; key = a[i];
				}
			}else{
				map.put(a[i], new Indexi(i, i));
			}
		}
		System.out.println(map.get(key).first+" : "+map.get(key).last);
		return new int[]{map.get(key).first,map.get(key).last};
	}
}
