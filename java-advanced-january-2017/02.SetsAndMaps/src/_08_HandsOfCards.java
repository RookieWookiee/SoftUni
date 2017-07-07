
import java.util.*;

public class _08_HandsOfCards {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> lhmap = new LinkedHashMap();
        String input;
        
        while (!(input = sc.nextLine()).equals("JOKER")) {
            String[] data = input.split(":");
            String key = data[0];
            String[] values = data[1].split("[^A-Za-z0-9]*[^A-Za-z0-9]+");
            
            if (lhmap.containsKey(key)) {
                lhmap.get(key).addAll(Arrays.asList(values).subList(1, values.length));
            } else {
                //subList is used because there is an empty string entry at the head of the array
                HashSet<String> hset = new HashSet(Arrays.asList(values).subList(1, values.length));
                lhmap.put(key, hset);
            }
        }
        
        evalTotalScores(lhmap);
        
        lhmap.keySet().forEach((String _s) -> {
            System.out.printf("%s: %s\n", _s, lhmap.get(_s).toArray()[0]);
        });
    }

    private static void evalTotalScores(LinkedHashMap<String, HashSet<String>> lhmap) {

        lhmap.keySet().forEach((s) -> {
            int total = 0;
            HashSet<String> hset = lhmap.get(s);
            for(String card: hset) {
                total += parseCard(card);
            }
            hset.clear();
            hset.add(String.valueOf(total));
        });
    }
    
    private static int parseCard(String s) {
        int retVal;
        int switchIndex = 1;
        char[] charSeq = s.toCharArray();
        
        if(s.length() == 2) {
            switch (charSeq[0]) {
                case 'J': retVal = 11; break;
                case 'Q': retVal = 12; break;
                case 'K': retVal = 13; break;
                case 'A': retVal = 14; break;
                default: 
                    retVal = Character.getNumericValue(charSeq[0]);
                    break;
            }
        } else { //Ugly hack can use substrings from the start to len-2 but I'm lazy
            retVal = 10;
            switchIndex = 2;
        }
        switch (charSeq[switchIndex]) {
            case 'C': retVal *= 1; break;
            case 'D': retVal *= 2; break;
            case 'H': retVal *= 3; break;
            case 'S': retVal *= 4; break;
            default: 
        }
        return retVal;
    }

}
