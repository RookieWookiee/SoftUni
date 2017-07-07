
import java.util.*;
import java.util.function.ToDoubleFunction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class _14_DragonArmy {
		
	public static void main(String[] args) {
		_14_DragonArmy obj = new _14_DragonArmy();
		obj.run(args);
	}
	public void run(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedHashMap<String, TreeSet<Dragon>> dragons = new LinkedHashMap(); 
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < n; ++i) {
			String[] input = sc.nextLine().split("\\s+");
			if(!dragons.containsKey(input[0]))
				dragons.put(input[0], new TreeSet());
			Dragon d = new Dragon(input);
			if(!dragons.get(input[0]).contains(d)) {
				dragons.get(input[0]).add(new Dragon(input));
			} else {
				dragons.get(input[0]).remove(d);
				dragons.get(input[0]).add(d);
			}
			
		}
		
		dragons.entrySet().forEach(x -> {
			System.out.format("%s::(%s)\n", x.getKey(), avgStats(x.getValue()));
			x.getValue().forEach(d -> System.out.println(d));
		});
		
	}
	
	public static String avgStats(TreeSet<Dragon> dragons) {
		double dmg = dragons.stream().mapToDouble(Dragon::getDmg)
			.average()
			.getAsDouble();
		double hp = dragons.stream().mapToDouble(Dragon::getHp)
			.average()
			.getAsDouble();
		double armor = dragons.stream().mapToDouble(Dragon::getArmor)
			.average()
			.getAsDouble();
		
		return String.format("%.2f/%.2f/%.2f", dmg, hp, armor);
	}
	
	public class Dragon implements Comparable<Dragon>{
		
		public static final int DEFAULT_DMG = 45;
		public static final int DEFAULT_HP = 250;
		public static final int DEFAULT_ARMOR = 10;
		
		private String name;
		private int damage;
		private int hp;
		private int armor;
		
		private Dragon(String name) {
			this.name = name;
			this.damage = DEFAULT_DMG;
			this.hp = DEFAULT_HP;
			this.armor = DEFAULT_ARMOR;
		}
		
		public int getDmg() { return this.damage; }
		public int getHp() { return this.hp; }
		public int getArmor() { return this.armor; }
		
		private Dragon(String[] args) {
			this(args[1]);
			if(!args[2].equals("null")) damage = Integer.parseInt(args[2]);
			if(!args[3].equals("null")) hp = Integer.parseInt(args[3]);
			if(!args[4].equals("null")) armor = Integer.parseInt(args[4]);
		}

		@Override
		public int compareTo(Dragon t) {
			return this.name.compareTo(t.name);
		}
		
		@Override
		public String toString() {
			return String.format("-%s -> damage: %d, health: %d, armor: %d",
				name, damage, hp, armor);
		}
	}
}
