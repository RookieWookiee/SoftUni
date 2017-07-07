
import java.util.*;

public class _11_LogsAggregator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		TreeMap<String, TreeMap<String, Integer>> users = new TreeMap();
		for(int i = 0; i < n; ++i) {
			String[] input = sc.nextLine().split(" ");
			String ip = input[0];
			String name = input[1];
			Integer dur = Integer.parseInt(input[2]);
			if(!users.containsKey(name)) {
				users.put(name, new TreeMap());
				users.get(name).put(ip, dur);
		 	} else {
				if(users.get(name).containsKey(ip)) {
					users.get(name).replace(ip, users.get(name).get(ip)+dur);
				} else {
					users.get(name).put(ip, dur);
				}
			}
		}
		users.keySet().forEach((user) -> {
			System.out.printf("%s: %d [%s]\n", 
				user, 
				totalDuration(users.get(user)), 
				String.join(", ", users.get(user).keySet()));
		});
	}

	public static Integer totalDuration(TreeMap<String, Integer> ips) {
		Integer total = 0;
		for(Map.Entry<String, Integer> entry: ips.entrySet()) {
			total += entry.getValue();
		}
		return total;
	}
}