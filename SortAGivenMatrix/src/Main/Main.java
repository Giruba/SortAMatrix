package Main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Sort a Matrix");
		System.out.println("-------------");
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the number of rows in the matrix");
			int rowDimension = scanner.nextInt();
			System.out.println("Enter the number of columns in the matrix");
			int columnDimension = scanner.nextInt();
			int[][] matrix = new int[rowDimension][columnDimension];
			for(int index = 0; index < rowDimension; index++) {
				for(int secIndex = 0; secIndex < columnDimension; secIndex++) {
					System.out.println("Enter the element at "+"("+index+","+secIndex+")");
					matrix[index][secIndex] = scanner.nextInt();
				}
			}
			System.out.println("-----Printing the input matrix as follows -----");
			PrintMatrix(matrix);
			matrix = GetSortedMatrix(matrix);
			System.out.println("-----The sorted matrix is as follows -----");
			PrintMatrix(matrix);
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}
	}
	
	public static void PrintMatrix(int[][] matrix) {
		for(int index = 0; index < matrix.length; index++) {
			for(int secIndex = 0; secIndex < matrix[0].length; secIndex++) {
				System.out.print(matrix[index][secIndex]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] GetSortedMatrix(int[][] inputMatrix){
		int length = inputMatrix[0].length * inputMatrix.length;
		int[] intermediateArray = new int[length];
		
		int intermediateIndex = 0;
		for(int index = 0; index < inputMatrix.length; index++) {
			for(int secIndex = 0; secIndex < inputMatrix[0].length; secIndex++) {
				intermediateArray[intermediateIndex++] = inputMatrix[index][secIndex];
			}
		}
		
		Arrays.sort(intermediateArray);
		
		intermediateIndex = 0;
		for(int index = 0; index < inputMatrix.length; index++) {
			for(int secIndex = 0; secIndex < inputMatrix[0].length; secIndex++) {
				inputMatrix[index][secIndex] = intermediateArray[intermediateIndex++];
			}
		}
		return inputMatrix;
	}
}
