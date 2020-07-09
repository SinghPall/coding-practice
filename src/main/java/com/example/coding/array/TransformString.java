package com.example.coding.array;

public class TransformString {

	public static void main(String[] args) {
		System.out.println(transformCharIntoNumberOfOccurance("aabbbc"));//a2b3c1
		System.out.println(transformCharIntoNumberOfOccurance(""));//" "
		System.out.println(transformCharIntoNumberOfOccurance("a"));//a1
		System.out.println(transformCharIntoNumberOfOccurance("abc"));//a1b1c1
	}
	public static String transformCharIntoNumberOfOccurance(String str){
		if(null == str || str.length() < 1) return "";
		if(str.trim().length() == 0) return "";
		StringBuffer res = new StringBuffer();
		res.append(str.charAt(0));
		int count = 1;
		for(int i=1; i< str.length(); i++){
			if(str.charAt(i) == str.charAt(i-1))
				count++;
			else{
				res.append(count);
				res.append(str.charAt(i));
				count = 1;
			}
		}res.append(count);
		return res.toString();
	}
}
