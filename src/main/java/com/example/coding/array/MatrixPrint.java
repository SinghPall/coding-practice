package com.example.coding.array;

public class MatrixPrint {
	public static void main(String[] args) throws InterruptedException {
		int matrix[][] = {
				{ 1, 2, 3, 4, 5, 6 }, 
                { 7, 8, 9, 10, 11, 12 }, 
                { 13, 14, 15, 16, 17, 18 } }; // o/p:- 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
		Util.printMatrix(matrix);
		System.out.println();
		spiralPrint(matrix);
	}

	public static void spiralPrint(int[][] mat){
		if(null != mat && mat.length > 1){
			int row = mat.length, col = mat[0].length;
			int irow = 0, jcol = 0, i = 0;

			while(irow<row && jcol<col){
				for(i=jcol; i<col; i++)
					System.out.print(mat[irow][i]+" ");
				irow++;
				for(i=irow; i<row; i++)
					System.out.print(mat[i][col-1]+" ");
				col--;
				if(irow<row){
					for(i=col-1; i>=jcol; i--)
						System.out.print(mat[row-1][i]+" ");
					row--;
				}
				if(jcol<col){
					for(i=row-1; i>=irow; i--)
						System.out.print(mat[i][jcol]+" ");
					jcol++;
				}

			}
		}
	}
}
