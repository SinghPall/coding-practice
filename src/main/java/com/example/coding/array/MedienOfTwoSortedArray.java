package com.example.coding.array;

public class MedienOfTwoSortedArray {

	public static void main(String[] args) {
		int a1[]={1,3};
		int a2[]={2};
		System.out.println(merging(a1, a2));
	}
	public static double merging(int num1[], int num2[]){
	 int l1 = num1.length, l2=num2.length;
	 if(l1 == 0 && l2 == 0)
		 return 0;
	 int res[] = new int[l1+l2];
	 int i=0, j=0, k=0;
	 while(l1 > 0 && l2 > 0){
		 if(num1[i] < num2[j]){
			 res[k] = num1[i++]; l1--; 
		 }else if(num1[i] > num2[j]){
			 res[k] = num2[j++]; l2--;
		 }else{
			 res[k++] = num1[i++]; l1--;
			 res[k] = num2[j++]; l2--;
		 }
		 k++;
	 }
	 while(l1>0){
		 res[k++] = num1[i++]; l1--;
	 }
	 while(l2>0){
		 res[k++] = num2[j++]; l2--;
	 }
	 int midIndex=-1;double median = 0.0;
	 if(res.length % 2 ==0){
		 midIndex = res.length/2;
		 median = (res[midIndex] + res[midIndex-1])/2.0;
	 }else{
		 midIndex = res.length/2;
		 median = res[midIndex]/1;
	 }
	 return median;
	}
}
