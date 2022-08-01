package day17.Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment1 {
	
	public static void main(String[] args) {
		
		List<Salepeople> list = Arrays.asList(
					new Salepeople("Peel", "London", 0.12),
					new Salepeople("Serres", "San Joes", 0.13),
					new Salepeople("Motika", "London", 0.11),
					new Salepeople("Rifkin", "Barcelona", 0.15),
					new Salepeople("Axelrod", "New York", 0.10)
				);
		
		System.out.println("-- 1. Salepeople who stay in London and get comm above 0.10 --");
		List<String> ans1 = list.stream()
							.filter(sale_p -> sale_p.getCity().equals("London") && sale_p.getComm() > 0.10)
							.map(sp -> sp.getName())
							.toList();
							//.collect(Collectors.toList());
		System.out.println(ans1);
		
		System.out.println("\n-- 2. Saleperson detail not having commission 0.10, 0.13 or 0.15 --");
		Map<Double, List<Salepeople>> ans2 = list.stream()
											.filter(sp -> !(sp.getComm()== 0.10 || sp.getComm() == 0.13 || sp.getComm() == 0.15))
											.collect(Collectors.groupingBy(Salepeople::getComm));
		System.out.println("Name\tCity\tComm");
		System.out.println("----------------------");
		ans2.forEach((k, v) -> {
			v.forEach(sp -> {
				System.out.println(sp.getName() + "\t" + sp.getCity() + "\t" + sp.getComm());
			});
		});
		
		System.out.println("\n-- 3. Different city names --");
		List<String> distinctCities = list.stream()
				.map(c -> c.getCity())
				.distinct()
				.toList();
				
		System.out.println(distinctCities);
		
		System.out.println("\n-- 4. The top of(salepeople 3) record --");
		System.out.println("Name\tCity\t\tComm");
		System.out.println("-----------------------------");
		Stream<Salepeople> ans4 = list.stream().limit(3);
		ans4.forEach(sp -> {
			System.out.println(sp.getName()+ "\t" + sp.getCity() + "\t" + sp.getComm());
		});
		
		System.out.println("\n-- 5. Detail of the salepeople who live in 'Rome' --");
		System.out.println("Name\tCity\t\tComm");
		System.out.println("-----------------------------");
		Stream<Salepeople> ans5 = list.stream()
									.filter(sp -> sp.getCity().equals("Rome"));
		ans5.forEach(sp -> 
				System.out.println(sp.getName()+ "\t" + sp.getCity() + "\t" + sp.getComm())
			);
		
		long ans6 = list.stream()
							.filter(sp -> sp.getCity().equals("London"))
							.count();
		System.out.println("\n6. The number of salepeople who stay in 'London': " + ans6);
		
		System.out.println("\n-- 7. List of salepeople in descending order of commision --");
		Map<Double, String> ans7 = list.stream()
										.collect(Collectors.toMap(
												Salepeople::getComm, // key
												Salepeople::getName)
											); // value
		
		System.out.println("Comm\tName");
		System.out.println("----------------");
		ans7.forEach((k, v) -> {
			System.out.println(k + "\t" + v);
		});
	}
}
