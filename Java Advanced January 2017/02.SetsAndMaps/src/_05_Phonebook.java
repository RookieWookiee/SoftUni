
import java.util.*;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> hmap = new HashMap();
        ArrayList<String> out = new ArrayList();
        
        while(true) {
            String s = sc.nextLine();
            switch(s) {
                case "search":
                    while(true){
                        s = sc.nextLine();
                        if(s.equals("stop")) 
                            break;
                        if (hmap.containsKey(s)) {
                            out.add(String.format("%s -> %s", s, hmap.get(s)));
                        } else {
                            out.add(String.format("Contact %s does not exist.", s));
                        }
                    }
                case "stop": 
                    for(String str: out)
                        System.out.println(str);
                    return;
                default:
                    if (s.matches("[a-zA-Z\\s0-9(){}]+-[a-zA-Z\\s0-9+-{}()]+")) {
                        String[] tokens = s.split("-");
                        if(tokens.length >= 2)
                            hmap.put(tokens[0], tokens[1]);
                    }
                    break;
            }
        }
    }
}
        
//        String s = sc.nextLine();
//        do {
//            String[] tokens = s.split("-");
//            hmap.put(tokens[0], tokens[1]);
//            s = sc.nextLine();
//        } while(!s.equals("search") && !s.equals("stop"));
//        
//        if (s.equals("search")) {
//            s = sc.nextLine();
//            do {
//                if (hmap.containsKey(s)) {
//                    out.add(String.format("%s -> %s", s, hmap.get(s)));
//                } else {
//                    out.add(String.format("Contact %s does not exist.", s));
//                }
//                s = sc.nextLine();
//            } while (!s.equals("stop"));
//        }
//        
//        for(String str: out)
//            System.out.println(str);
