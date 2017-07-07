
import java.util.*;

public class _09_UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        TreeMap<String, LinkedHashMap<String, Integer>> treeMap = new TreeMap();
        
        while(!(s = sc.nextLine()).equals("end")) {
            String[] data = s.split(" ");
            String ip = data[0].split("=")[1];
            String msg = data[1].split("=")[1];
            String user = data[2].split("=")[1];
            
            if(!treeMap.containsKey(user)) {
                LinkedHashMap<String, Integer> hmap = new LinkedHashMap();
                hmap.put(ip, 1);
                treeMap.put(user, hmap);
            } else {
                LinkedHashMap<String, Integer> childMap = treeMap.get(user);
                if(!childMap.containsKey(ip)) {
                    childMap.put(ip, 1);
                } else {
                    childMap.replace(ip, childMap.get(ip) + 1);
                }
            }
        }
        
        for(String _user: treeMap.keySet()) {
            System.out.println(_user + ": ");
            LinkedHashMap<String, Integer> _IPs = treeMap.get(_user);
            Iterator<Map.Entry<String, Integer>> entries = treeMap.get(_user).entrySet().iterator();
            Map.Entry<String, Integer> entry = null;
            while(entries.hasNext()) {
                entry = entries.next();
                if(!entries.hasNext())
                    break;
                System.out.print(entry.getKey() + " => " + entry.getValue() + ", ");
            }
            System.out.println(entry.getKey() + " => " + entry.getValue() + ".");
        }
    }
}