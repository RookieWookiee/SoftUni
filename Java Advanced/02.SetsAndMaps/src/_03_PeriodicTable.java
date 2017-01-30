import java.util.*;

public class _03_PeriodicTable {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        TreeSet<String> tset = new TreeSet();
        int n = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split("\\s+");
            for(String str: s)
                tset.add(str);
        }
        
        for(String s: tset) 
            System.out.print(s + " ");
    }
}