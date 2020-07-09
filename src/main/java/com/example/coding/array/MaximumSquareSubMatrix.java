package com.example.coding.array;

public class MaximumSquareSubMatrix {

	public static void main(String[] args) {
		int matrix[][] = {{0, 1, 1, 0, 1},  
                		  {1, 1, 0, 1, 0},  
                		  {0, 1, 1, 1, 0}, 
                		  {1, 1, 1, 1, 0}, 
                		  {1, 1, 1, 1, 1}, 
                		  {0, 0, 0, 0, 0}};
		Util.printMatrix(matrix);
		System.out.println();
		System.out.println(maxSubMatrixWithhAllOnes(matrix));
	}
	
	public static int maxSubMatrixWithhAllOnes(int [][] mat){
		if(null != mat && mat.length > 1){
			int row = mat.length, col = mat[0].length, longest = -1;
			int res[][] = new int[row][col];
			for(int i=0; i<col; i++)
				res[0][i] = mat[0][i];
			for(int i=0; i<row; i++)
				res[i][0] = mat[i][0];
			
			for(int i=1; i< row; i++){
				for(int j=1; j< col; j++){
					if(mat[i][j] == 1)
						res[i][j] = 1 + Math.min(res[i-1][j-1], Math.min(res[i-1][j], res[i][j-1])); // min in direction (\, --, |)
					else
						res[i][j] = 0;
					if(longest < res[i][j])
						longest = res[i][j];
				}
			}
			Util.printMatrix(res);
			return longest;
		}
		return -1;
	}

}
