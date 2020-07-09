package com.example.coding.array;

public class KMPAlgorithm {

	public static void main(String[] args) {
		String str = "AABAACAADAABAABA"; 
        String pat = "AABA";
		searchPattern(str, pat);
	}
	
	public static void searchPattern(String str, String pat){
		if(str.length() < pat.length()){
			System.out.println("Not possible");
			return;
		}
		int lps[] = new int[pat.length()];
		fillLPSarray(pat, lps);
		Util.print(lps, lps.length);
		
		int lpat = pat.length();
		int lstr = str.length();
		int i = 0, j=0;
		while(i < lstr){
			if(str.charAt(i) == pat.charAt(j)){
				i++; j++;
				if(j == lpat){
					System.out.println("Found at : "+ (i-j));
					j = lps[j-1];
				}
			}else{
				if(j == 0){
					i++;
				}else
					j = lps[j-1];
			}
		}
	}
	public static void fillLPSarray(String pat, int[] lps){
		int patLen = pat.length();
		if(patLen > 0){
			int len = 0, i = 1;
			lps[0] = 0;
			while(i < patLen){
				if(pat.charAt(i) == pat.charAt(len)){
					len++;
					lps[i++] = len;
					if(len == patLen){
						System.out.println("Pattern : "+ (len - i));
						len = len - 1;
					}
				}else{
					if(len == 0){
						lps[i++] = 0;
					}
					else
						len--;
				}
			}
		}
	}
	
}
