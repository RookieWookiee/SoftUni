
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yavor
 */
public class _06_Robotics {

    public static void main(String[] args) {
        int sec = 0;
        LocalTime currentTime;
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Bot> deck = getBots(sc.nextLine().split(";"));
        ArrayDeque<String> productsDeck = new ArrayDeque();
        
        LocalTime startTime = LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("H:m:s"));
        currentTime = startTime;
        String cmd;
        ArrayList<String> output = new ArrayList();

        do {
            cmd = sc.nextLine();
            if (cmd.equals("End")) {
                break;
            }
            productsDeck.addLast(cmd);
            currentTime = currentTime.plusSeconds(1);
            int iter = 0;
            int deckSize = deck.size();
            while (!productsDeck.isEmpty()) {
                
                Bot curr = deck.removeLast();
                String product = productsDeck.removeFirst();
                if (deckSize == iter) {
                    productsDeck.addFirst(product); break;
                }
                
                if (curr.takeOrder(product, currentTime)) {
                    output.add(String.format("%s - %s [%02d:%02d:%02d]",
                            curr.name,
                            product,
                            currentTime.getHour(),
                            currentTime.getMinute(),
                            currentTime.getSecond())
                    );
                    productsDeck.addLast(product);
                    deck.addFirst(curr);
                    break;
                }

                iter++;
                productsDeck.addLast(product);
                deck.addFirst(curr);
            }
        } while(!cmd.equals("End") && !productsDeck.isEmpty());
        for (String s : output) {
            System.out.println(s);
        }

    }

    private static ArrayDeque getBots(String[] args) {
        ArrayDeque<Bot> deck = new ArrayDeque();
        for (int i = 0; i < args.length; ++i) {
            deck.addFirst(new Bot(args[i].split("-")));
        }

        return deck;
    }

}

class Bot {

    String name;
    int processTime;
    String product;
    LocalTime workingUntil;

    public Bot(String name, int processTime) {
        this.name = name;
        this.processTime = processTime;
        this.workingUntil = LocalTime.parse("0:00:00", DateTimeFormatter.ofPattern("H:m:s"));
    }

    public boolean takeOrder(String product, LocalTime currentTime) {
        boolean tookOrder = false;

        if (currentTime.isAfter(workingUntil) || currentTime.equals(workingUntil)) {
            this.product = product;
            tookOrder = true;
            this.workingUntil = currentTime.plus(Duration.parse("PT" + this.processTime + "S"));
        }

        return tookOrder;
    }

    public Bot(String[] tokens) {
        this(tokens[0], Integer.parseInt(tokens[1]));
    }
}
