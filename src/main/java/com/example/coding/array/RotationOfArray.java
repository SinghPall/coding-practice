package com.example.coding.array;

public class RotationOfArray {

	public static void main(String[] args) {
		 int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		// rotateLeftByGivenNumber(arr, arr.length, 7);
		//rotateLeftByReversalAlgo(arr, arr.length, 2);
		// rightRotate(arr, arr.length, 2);
		 Util.print(arr, arr.length);
		// rotateLeftOptimizedSol(arr, arr.length, 12); // will efficient even k is larger than len of arr
		 rotateRightOptimizedSol(arr, arr.length, 1);
		// Util.print(arr, arr.length);
		 // rotation of String by given number
		/* String s = "GeeksforGeeks";
		 System.out.println(rotateStringUsingReversalAlgo(s, s.length(), 2));*/
	}
	public static void rotateLeftByGivenNumber(int a[], int length, int d){
		if(length <= 0 || d > length) return;
		for(int i=0; i<d; i++){
			shiftLeft(a, length);
		}
	}
	public static void shiftLeft(int a[], int l){
		int k = a[0];
		for(int i=0; i<l-1; i++){
			a[i] = a[i+1];
		}
		a[l-1] = k;
	}
	public static void rotateLeftByReversalAlgo(int a[], int l, int d){
		reverse(a, l, 0, d-1);
		reverse(a, l, d, l-1);
		reverse(a, l, 0, l-1);
	}
	public static void reverse(int a[], int l, int s, int e){
		if(s <0 || e >l-1) return;
		while(s<e || s> l-1 || e<0){
			int t = a[s];
			a[s] = a[e];
			a[e] = t;
			s++; e--;
		}
	}
	public static void rotateLeftOptimizedSol(int a[], int l, int d){ // when k's value is greater than len of arr
		for(int i=d; i< (l+d); i++){
			System.out.print(a[i%l]+ " ");
		}System.out.println();
	}
	public static void rotateRightOptimizedSol(int a[], int n, int d){ // when k's value is greater than len of arr
		/*for(int i=d; i>(d-n); i--){
			int index = Math.abs(n - (i%n));
			if(index == n) index = 0;
			System.out.print(a[index%n]+ " ");
		}*/int i = -1;
		if((d/n) > 0){
			i = (d/n)+1; // =8
			int m = (i*n)-d;
			for(int j=m; j<(n+m); j++)
				System.out.print(a[j%n]+ " ");
		}else{
			
		}
		
		
		System.out.println();
	}
	public static String rotateStringUsingReversalAlgo(String str, int l , int d){
		if(l <0 || d>l-1) return null;
		System.out.println(str);
		char s[] = str.toCharArray();
		reverseString(s, l, 0, d-1);
		reverseString(s, l, d, l-1);
		reverseString(s, l, 0, l-1);
		str = new String(s);
		return str;
	}
	public static void reverseString(char str[], int l, int s, int e){
		while(s<e){
			char c= str[s];
			str[s] = str[e];
			str[e] = c;
			s++; e--;
		}
	}
	public static void rightRotate(int a[], int l, int d){
		for(int i=0; i<d; i++){
			shiftRight(a, l);
		}
	}
	public static void shiftRight(int a[], int l){
		int k = a[l-1];
		for(int i=l-1; i>0; i--){
			a[i] = a[i-1];
		}
		a[0] = k;
	}
}
