
import java.util.*;

public class _12_LegendaryFarming {
	public static void main(String[] args){ 
		Scanner sc = new Scanner(System.in);
		TreeMap<String, Integer> keyItems = new TreeMap();
		TreeMap<String, Integer> junkItems = new TreeMap();
		Boolean legendaryFound = false;
		String legendary = null;
		
		keyItems.put("motes", 0);
		keyItems.put("shards", 0);
		keyItems.put("fragments", 0);

		while(!legendaryFound) {
			if(!sc.hasNextLine())
				break;
			String[] input = sc.nextLine().split("\\s+");
			for(int i = 0; i < input.length; i += 2) {
				Integer quantity = Integer.parseInt(input[i]);
				String name = input[i+1].toLowerCase();

				switch(name) {
					case "motes":
					case "fragments":
					case "shards":
						keyItems.put(name, keyItems.get(name)+quantity);
						break;
					default:
						if(!junkItems.containsKey(name)) junkItems.put(name, quantity);
						else junkItems.put(name, junkItems.get(name)+quantity);
						break;
				}

				if(keyItems.get("motes") >= 250
					|| keyItems.get("fragments") >= 250
					|| keyItems.get("shards") >= 250) {
					legendaryFound = true;
					switch(name) {
						case "motes": legendary = "Dragonwrath"; break;
						case "fragments": legendary = "Valanyr"; break;
						case "shards": legendary = "Shadowmourne"; break;
					}
					keyItems.put(name, keyItems.get(name)-250);
					break;
				}
			}
		}
		System.out.printf("%s obtained!\n", legendary);
		keyItems.entrySet().stream().sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
			.forEach(x -> {
				System.out.printf("%s: %d\n", x.getKey(), x.getValue());
			});
		junkItems.entrySet().forEach(x -> System.out.printf("%s: %d\n", x.getKey(), x.getValue()));
	}
}
