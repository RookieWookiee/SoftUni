
import java.util.*;

public class _02_SetsOfElements {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<Integer> set1 = new LinkedHashSet();
        LinkedHashSet<Integer> set2 = new LinkedHashSet();
        
        String[] s = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        
        for(int i = 0; i < n; ++i) 
            set1.add(sc.nextInt());
        for(int i = 0; i < m; ++i) 
            set2.add(sc.nextInt());
        
        set1.retainAll(set2);
        
        for(Integer i: set1)
            System.out.print(i + " ");

    }
}
