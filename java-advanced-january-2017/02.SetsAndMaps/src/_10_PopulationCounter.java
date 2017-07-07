
import java.util.*;

public class _10_PopulationCounter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, HashMap<String, Long>> countries = new LinkedHashMap();
		String s;

		while (!(s = sc.nextLine()).equals("report")) {
			String[] in = s.split("\\|");
			String city = in[0];
			String country = in[1];
			Long population = Long.parseLong(in[2]);
			if (!countries.containsKey(country)) {
				HashMap<String, Long> cities = new LinkedHashMap();
				cities.put(city, population);
				countries.put(country, cities);
			} else {
				countries.get(country).put(city, population);
			}
		}
		countries.entrySet().stream().sorted((c1, c2) -> (totalPopulation(c2.getValue()))
			.compareTo(totalPopulation(c1.getValue())))
			.forEach(c -> {
				System.out.printf("%s (total population: %d)\n", c.getKey(), totalPopulation(c.getValue()));
				c.getValue().entrySet().stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(t -> {
					System.out.printf("=>%s: %d\n", t.getKey(), t.getValue());
				});
			});
	}

	public static Long totalPopulation(HashMap<String, Long> cities) {
		Long total = 0L;
		for (String _s : cities.keySet()) {
			total += cities.get(_s);
		}
		return total;
	}
}
