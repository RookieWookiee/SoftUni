
import java.util.*;

public class _06_MinerTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> lhmap = new LinkedHashMap();
        ArrayList<String> out = new ArrayList();

        String s, key = null;
        int val;
        boolean odd = true;

        while (!(s = sc.nextLine()).equals("stop")) {
            if (odd) {
                key = s;
                odd = false;
            } else {
                if (lhmap.containsKey(key)) {
                    lhmap.replace(key, lhmap.get(key) + Integer.parseInt(s));
                } else {
                    lhmap.put(key, Integer.parseInt(s));
                }
                odd = true;
            }
        }
        lhmap.keySet().forEach((String _item) -> {
            System.out.printf("%s -> %d\n", _item, lhmap.get(_item));
        });
    }
}
