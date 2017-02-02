
import java.util.*;

public class _07_TruckTour {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayDeque<int[]> stops = new ArrayDeque();
		Long gas = 0l;
		for(int i = 0; i < n; ++i) {
			String[] in = sc.nextLine().split(" ");
			stops.add(new int[]{ 
				Integer.parseInt(in[0]),
				Integer.parseInt(in[1])});
		}
		int[] startStation;
		int[] currStation;
		int index = 0;
		do {
			startStation = stops.pop();
			currStation = startStation;
			Boolean hasMoved = false;
			stops.addLast(currStation);
			ArrayDeque<int[]> temp = stops.clone();
			do {
				if(hasMoved && currStation == startStation)
					break;
				gas += currStation[0];
				gas -= currStation[1];
				if(gas >= 0) {
					currStation = temp.pop();
					temp.addLast(currStation);
					hasMoved = true;
				}
			} while(gas >= 0);
			gas = 0l;
			if(currStation == startStation && hasMoved)
				break;
			index++;
		} while(true);
		System.out.println(index);
	}
}
