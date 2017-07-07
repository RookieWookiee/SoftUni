
import java.util.*;

public class _13_SrubskoUnleashed {
	
	private static final int MAX_FIELDS = 8;
	private static final int MIN_FIELDS = 4;
	private static final String VENUE_DELIM = " @";
	private static final String DELIM = " ";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();
		String s;
		
		while(!(s = sc.nextLine()).equals("End")) {
			String[] input = s.split(DELIM);
			if(!isInputValid(input)) 
				continue;
			String singer = s.substring(0, s.indexOf(VENUE_DELIM));
			Integer ticketsCount = Integer.parseInt(input[input.length-1]);
			Integer ticketsPrice = Integer.parseInt(input[input.length-2]);
			String venue = s.substring(
				s.indexOf(VENUE_DELIM)+VENUE_DELIM.length(),
				s.indexOf(ticketsPrice.toString())-1);
			
			if(!venues.containsKey(venue)) {
				venues.put(venue, new LinkedHashMap());
				venues.get(venue).put(singer, ticketsCount * ticketsPrice);
			} else {
				if(!venues.get(venue).containsKey(singer)) {
					venues.get(venue).put(singer, ticketsCount * ticketsPrice);
				} else {
					venues.get(venue).replace(singer, 
						venues.get(venue).get(singer) + 
							ticketsCount * ticketsPrice);
				}
			}
		}
		
		venues.entrySet().forEach(v -> {
			System.out.println(v.getKey());
			v.getValue().entrySet().stream()
			.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.forEach(x -> {
					System.out.printf("#  %s -> %d\n", x.getKey(), x.getValue());
				});
		});
	}

	private static boolean isInputValid(String[] input) {
		if(input.length < MIN_FIELDS) return false;
		if(input.length > MAX_FIELDS) return false;
		
		try{
			Integer.parseInt(input[input.length-1]);
			Integer.parseInt(input[input.length-2]);
		} catch(NumberFormatException e) {
			return false;
		}
		
		return String.join(DELIM, input).contains(VENUE_DELIM);
	}
}
