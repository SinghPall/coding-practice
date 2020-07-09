package com.example.coding.array;

public class EleInArraywithEqualRightAndLeftSum {

	public static void main(String[] args) {
		int a[] = new int[]{-1,-1,-1,0,1,1};
		System.out.println(equalSumInLeftAndRight(a)); //{1,3,-2,3} => 1th index
	}

	/* It will return the pos of ele whoose left and right sum of element will be equal
	 */
	public static int equalSumInLeftAndRight(int a[]){
		if(null == a || a.length <= 1)return -1;
		int n = a.length, rightSum = 0, leftSum = 0;
		for(int i=0; i<n; i++) // calculating postfix sum || i/n : 1,3,-2,3 || rightSum : 4
			rightSum += a[i];
		for(int i=0; i<n; i++){
			if(i >0)
				leftSum += a[i-1];
			rightSum -= a[i];
			if(rightSum == leftSum)
				return i;
		}
		return -1;
	}
}
