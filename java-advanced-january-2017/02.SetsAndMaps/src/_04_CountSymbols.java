
import java.util.*;

public class _04_CountSymbols {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Character, Integer> thm = new TreeMap();
        char[] s = sc.nextLine().toCharArray();

        for (Character c : s) {
            if (!thm.containsKey(c)) {
                thm.put(c, 1);
            } else {
                thm.replace(c, thm.get(c) + 1);
            }
        }
        thm.keySet().forEach((c) -> {
            System.out.println(c + ": " + thm.get(c) + " time/s");
        });
    }
}
