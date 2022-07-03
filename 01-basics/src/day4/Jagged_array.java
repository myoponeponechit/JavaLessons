package day4;

public class Jagged_array {
	
	public static void main(String[] args) {
		int[][] data = {
				{1, 2, 3},
				{1, 2, 3, 4},
				{1, 2}
		};
		
		System.out.println("------- for loop --------");
		int length = data.length;
		for(var r = 0; r < length; r++) {
			int row_length = data[r].length;
			for(var c = 0; c < row_length; c++) {
				System.out.print(data[r][c] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("------- for each loop -------");
		for(var row : data) {
			for(var col : row) {
				System.out.print(col + "\t");
			}
			System.out.println();
		}
	}
}
