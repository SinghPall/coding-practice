package com.example.coding.array;

public class NoOfIsland {

	public static void main(String[] args) {
		int grid[][] = new int[][] { 
			{ 1, 1, 0, 0, 0 }, 
            { 0, 1, 0, 0, 1 }, 
            { 1, 0, 0, 1, 1 }, 
            { 0, 0, 0, 0, 0 }, 
            { 1, 0, 1, 0, 1 } };
            System.out.println("Number of island " + numberOfIsland(grid));
	}

	public static int numberOfIsland(int grid[][]){ //time complexity : m x n)
		if(grid.length <= 0) return 0;
		int count = 0;
		for(int i= 0; i< grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(grid[i][j] == 1){
					count++;
					searchByBFS(grid, i, j);
				}
			}
		}
		return count;
	}
	public static void searchByBFS(int grid[][], int i, int j){
		if(i<0 || i>= grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0)
			return;
		grid[i][j] = 0; // replacing 1 with 0 so that it cant be counted again
		searchByBFS(grid, i-1, j); // up by 1 row
		searchByBFS(grid, i+1, j); // down by 1 row
		searchByBFS(grid, i, j-1); // left by 1 col
		searchByBFS(grid, i, j+1); // right by 1 col
	}
}
