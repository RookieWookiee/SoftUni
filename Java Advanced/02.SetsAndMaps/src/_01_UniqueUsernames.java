import java.util.*;

public class _01_UniqueUsernames {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> set = new LinkedHashSet();
        
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            set.add(sc.nextLine());
        }
        
        for(String s: set) {
            System.out.println(s);
        }
    }
}