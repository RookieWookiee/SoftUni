
import java.util.Scanner;
import java.util.ArrayDeque;

//This could be a lot cleaner overall. See comments below. I'm feeling lazy atm.

public class _07_TruckTour {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayDeque<int[]> stops = new ArrayDeque();
		int stopsCount = Integer.parseInt(sc.nextLine());
		Long gas = 0L; //Capital L looks cleaner 
		
		for(int i = 0; i < stopsCount; ++i) {
			String[] tokens = sc.nextLine().split(" ");
			stops.add(new int[]{ 
				Integer.parseInt(tokens[0]),
				Integer.parseInt(tokens[1])});
		}
		
		//Ugly: will look cleaner with while loops and declaration inside
		int[] startStation; //Ugly
		int[] currStation;
		int index = 0;
		
		do { //Possible with using only one Stack.
			startStation = stops.pop();
			currStation = startStation;
			Boolean hasMoved = false;
			stops.addLast(currStation);
			ArrayDeque<int[]> temp = stops.clone();
			
			//Can add additional index to count the inner loop iterations
			//and subsequently add it to the index, because we know that those
			//nodes are infeasible starting points
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
			gas = 0L;
			if(currStation == startStation && hasMoved)
				break;
			index++;
		} while(true);
		System.out.println(index);
	}
}
