import java.util.Scanner;

public class Cards {
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (String s : suits) {
            for (String r : ranks) {
                deck[index++] = r + " of " + s;
            }
        }

        for (int i = 0; i < numOfCards; i++) {
            int random = i + (int)(Math.random() * (numOfCards - i));
            String temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();

        if (players * n > numOfCards) {
            System.out.println("Not enough cards!");
            return;
        }

        for (int i = 0; i < players; i++) {
            System.out.println("\nPlayer " + (i+1) + ":");
            for (int j = 0; j < n; j++) {
                System.out.println(deck[i*n + j]);
            }
        }
    }
}
