package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Stream_API {
	
	public static void main(String[] args) {
		
		//without_stream_api();
		with_stream_api();
	}

	private static void with_stream_api() {
		int[] prices = {7000, 4500, 1800, 5500, 1400};
		// create stream
		IntStream streams = Arrays.stream(prices);
		
		streams.filter(p -> p > 5000) // inter op1
			.sorted() // inter op2
			.forEach(p -> System.out.println(p)); // terminal op
	}

	private static void without_stream_api() {
		int[] prices = {7000, 4500, 1800, 5500, 1400};
		
		List<Integer> list = new ArrayList<>();
		
		for(var p : prices) {
			if(p > 5000) {
				list.add(p);
			}
		}
		//sort
		Collections.sort(list);
		
		//display
		for(var p : list) {
			System.out.println(p);
		}
	}
}
