package com.example.coding.array;

public class WordSearchInTwoDArray {
	boolean visited[][];
	public static void main(String[] args) {
		WordSearchInTwoDArray obj = new WordSearchInTwoDArray();
		char board[][] = {	{'A','B','C','E'},
							{'S','F','C','S'},
							{'A','D','E','E'} };
		System.out.println(obj.exist(board, "ABCCED")); // true
		System.out.println(obj.exist(board, "SEE")); // true
		System.out.println(obj.exist(board, "ABCB")); // false
	}

	public boolean exist(char[][] board, String word) {
		int rows = board.length;
		int cols = board[0].length;
		if(rows <=0 || cols <= 0 || word.length() <= 0)
			return false;
		visited = new boolean[rows][cols];
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(word.charAt(0) == board[i][j] && wordSearch(i, j, 0, board, word))
					return true;
			}
		}
		return false;
	}
	public boolean wordSearch(int i, int j, int wordIndex, char[][] board, String word){
		if(word.length() == wordIndex)
			return true;
		if(i<0 || i>=board.length || j<0 || j>=board[i].length 
				|| word.charAt(wordIndex) != board[i][j] || visited[i][j])
			return false;
		visited[i][j] = true;
		if(wordSearch(i+1, j, wordIndex+1, board, word)
				|| wordSearch(i-1, j, wordIndex+1, board, word)
				|| wordSearch(i, j+1, wordIndex+1, board, word)
				|| wordSearch(i, j-1, wordIndex+1, board, word))
			return true;
		visited[i][j] = false;
		return false;
	}
}
