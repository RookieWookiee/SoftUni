
import java.util.*;

public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, String> lhmap = new LinkedHashMap();

        String s, key = null;
        boolean odd = true;

        while (!(s = sc.nextLine()).equals("stop")) {
            if (odd) {
                key = s;
                odd = false;
            } else {
                if (!s.toLowerCase().endsWith(".uk")
                        && !s.toLowerCase().endsWith(".us")
                        && !s.toLowerCase().endsWith(".com")) {
                    lhmap.put(key, s);
                }
                odd = true;
            }
        }
        lhmap.keySet().forEach((String _item) -> {
            System.out.printf("%s -> %s\n", _item, lhmap.get(_item));
        });
    }
}