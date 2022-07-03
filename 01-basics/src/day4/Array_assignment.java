package day4;

//import java.util.Arrays;
import java.util.Scanner;

public class Array_assignment {
	public static void main(String[] args) {
		String[] brands = {"lenovo", "hp", "samsung", "acer", "dell", "asus"};
		String[] core = {"i3", "i5", "i7", "i9"};
		Double[][] price = {
				{230.21, 400.21, 294.20, 693.33, 340.44, 691.99},
				//{529.483, 920.483, 676.66, 1594.659, 783.012, 1591.577},
				{529.48, 920.48, 676.66, 1594.7, 783.01, 1591.6},
				//{552.504, 960.504, 706.08, 1663.992, 817.056, 1660.776},
				{552.50, 960.50, 706.08, 1664.0, 817.06, 1660.8},
				//{690.63, 1200.63, 882.6, 2079.99, 1021.32, 2075.97}
				{690.63, 1200.60, 882.6, 2080.0, 1021.3, 2076.0}
		};
		//System.out.println(Arrays.deepToString(brands));
		//display brands and computer
		System.out.print("\t|");
		for(var name : brands) {
			System.out.print(name + "\t\t");
		}
		System.out.println();
		System.out.println("--------+-----------------------------------------------------------------------------------------");
		var i = 0;
		for(var row : price) {
			System.out.print(" core " + core[i] + "|");
			for(var item_price : row) {
				System.out.print(item_price + "\t\t");
			}
			System.out.println("\n\t|");
			i++;
		}
		//search brands
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter brand name that you want to search : ");
		String search_name = sc.next();
		int l = brands.length;
		int result = -1;
		for(var j = 0; j < l; j++) {
			if(brands[j].equalsIgnoreCase(search_name)) {
				result = j;
				break;
			}
		}
		if(result == -1) {
			System.err.println("\n" + search_name + " is not exit!");
		}
		else {
			System.out.println("\n" + search_name + " is exit!\n");
			//search core
			System.out.print("Enter type of core : ");
			String search_core = sc.next();
			int core_l = core.length;
			int flap = -1;
			for(var k = 0; k < core_l; k++) {
				if(core[k].equalsIgnoreCase(search_core)) {
					flap = k;
					break;
				}
			}
			if(flap == -1) {
				System.err.println("\n" + search_name + " core " + search_core + " is not exit!");
			}
			else {
				System.out.println("\n" + search_name + " core " + search_core + " is exit!\n");
				System.out.println("Price in dolla : " + price[flap][result] + " $\n");
				//display mmk
				System.out.print("Enter currency exchange rate(MMK) : ");
				int mmk = sc.nextInt();
				double total_mmk = price[flap][result] * mmk;
				System.out.println("\nTotal amount of " + search_name + " core " + search_core  +" in MMK : " + Math.round(total_mmk) + " kyat");
			}
		}
		//close
		sc.close();
	}
}
