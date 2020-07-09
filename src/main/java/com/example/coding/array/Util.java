package com.example.coding.array;

public class Util {
	public static void print(int arr[], int l){
		if(l == 0) { System.out.println("empty"); return; }
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public static void shiftRight(int a[], int l, int s, int e){
		int k = a[e];
		for(int i=e-1; i>=s; i--){
			a[i+1] = a[i];
		}
		a[s] = k;
	}
	/*WHAT'S FOR: arranging num in alternate way of -ve then +ve
	 *i/p :4 -3 -2 6 7 8 -6, 1st step: -3 -2 -6 6 7 8 4, then 2nd step: -3 6 -2 8 -6 7 4
	 *time complexity : O(n*n) || Algo : Modified version of insertion sort */
	public static void rearrangePosNegNumInAlternateOrder(int a[], int l){
		int indexOfFirstPosNum = reArrangePosNegWithoutChangingtheOrder(a, l) + 1;//reArrangePosNeg(a, l);
		if(indexOfFirstPosNum == l){
			System.out.println("Array has no pos num"); return;
		}
		int negIndex = 1, k = -1, j=-1;
		for(int i=indexOfFirstPosNum; i<l; i++){
			if(a[negIndex] > 0) continue;
			
			k = a[i]; j = i-1;
			while(j >= negIndex){
				a[j+1] = a[j]; j--;
			}
			a[j+1] = k;
			negIndex += 2;
		}Util.print(a, l);
	}
	public static void rearrangePosNegNumInAlternateOrder2(int a[], int l){
		int indexOfFirstPosNum = reArrangePosNegWithoutChangingtheOrder(a, l);//reArrangePosNeg(a, l);
		int negIndex = 1;
		for(int i=indexOfFirstPosNum; i<l; i+=2){
			Util.shiftRight(a, l, negIndex, i);
			negIndex +=2;
		}Util.print(a, l);
	}
	/* WHAT'S FOR: Placing all -ve Num before all +ve num.
	 * i/p : 4 -3 -2 6 7 8 -6 || o/p : -3 -2 -6 4 6 7 8
	 * this is modified version of insertion sort, it wll not change order of num from array
	 * time complexity : O(n*n) */
	public static int reArrangePosNegWithoutChangingtheOrder(int arr[], int n) { 
		int key = -1, j = -1; 
		for (int i = 1; i < n; i++) { 
			key = arr[i]; 
			if (key > 0) 
				continue; 
			j = i - 1; 
			while (j >= 0 && arr[j] > 0) { 
				arr[j + 1] = arr[j]; 
				j = j - 1; 
			} 
			arr[j + 1] = key; 
		} Util.print(arr, n);
		System.out.println("End index of -ve num :" + (j+1));
		return j+1;
	}
	/* WHAT'S FOR: Placing all -ve Num before all +ve num.
	 * i/p : 4 -3 -2 6 7 8 -6 || o/p : -3 -2 -6 6 7 8 4 (changed oreder of 4 here)
	 * time complexity : O(n) */
	public static int reArrangePosNeg(int a[], int l){
		if(l < 0 || l == 0 || l == 1) return -1;
		int i = -1, tmp = -1;
		for(int j=0; j<l; j++){
			if(a[j] <0){
				i++;
				tmp = a[i];	a[i] = a[j]; a[j] = tmp; //swap ele of ith and jth posi
			}
		}Util.print(a, l);
		return i+1;
	}
	public static void rearrangeOddEvenNUmAlternatively(int a[], int l){
		rearrangingOddEven(a, l);
	}
	public static void rearrangingOddEven(int a[], int l){
		int k = -1, j=-1;
		for(int i =1; i< l; i++){
			k = a[i];
			if( Math.abs(k) % 2 == 0)
				continue;
			j = i-1;
			while(j >= 0 && a[j]%2 == 0){
				a[j+1] = a[j]; j--;
			}
			a[j+1] = k;
		} Util.print(a, l);
	}
	public static void findOccurance(String str, int n){
		int len = 0, cache[] = new int[26];
		String strDup = str.toLowerCase(); StringBuffer res = new StringBuffer();
		findOccurencesUtil(strDup, n, len, cache);
		for(int i=0; i<n; i++){
			char c = strDup.charAt(i);
			if(cache[c-'a'] >0){
				res.append(c); res.append(cache[c-'a']);
				System.out.println(c+" : "+cache[c-'a']);
				cache[c-'a'] = 0;
			}
		}System.out.println(res.toString());
	}
	public static void findOccurencesUtil(String str, int n, int len, int cache[]){
		if(len == n || len > n) return;
		cache[str.charAt(len++) - 'a'] +=1;
		
		findOccurencesUtil(str, n, len, cache);
	}
	public static void permutation(String str, int n){
		String ans = "";
		permute(str, ans);
	}
	public static void permute(String str, String res){
		if(str.length() == 0){
			System.out.print(res+" ");
			return;
		}
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			String remaining = str.substring(0,i) + str.substring(i+1);
			permute(remaining, res+ch);
		}
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}System.out.println();
		}
	}
}
