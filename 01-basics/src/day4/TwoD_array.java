package day4;

import java.util.Arrays;

public class TwoD_array {
	
	public static void main(String[] args) {
		int[][] marks = {
				{62,63,76,78,81,72},
				{45,66,55,77,54,47},
				{76,78,90,97,89,79}
		}; 
		String[] names = {"Jone", "Yuri", "Cherry"};
		// output
		for(var r = 0; r < 3; r++) {
			for(var c = 0; c < 6; c++) {
				System.out.print(marks[r][c] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n------ for each ------");
		for(int[] row : marks) {
			for(int col : row) {
				System.out.print(col + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n------ just string -------");
		System.out.print(Arrays.deepToString(marks));
		
		System.out.println("\n\n------ Students' Marks ---------\n");
		int row = marks.length;
		int col = marks[0].length;
		for(var i = 0; i < row; i++) {
			int total = 0;
			for(var j = 0; j < col; j++) {
				total += marks[i][j];
			}
			System.out.println("Total mark obtained by student " + names[i] + " : " + total);
			System.out.println("Averade mark : " + (float)total/6);
			System.out.println();
		}
	}

}
