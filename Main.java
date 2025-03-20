import java.io.*;
import java.util.*;

class Card {
    String suit;
    String rank;

    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean isEqual(Card other) {
        return this.rank.equals(other.rank);
    }
}

class Deck {
    List<Card> cards = new ArrayList<>();

    Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cards);
    }

    Card drawCard() {
        return cards.remove(0);
    }

    boolean isEmpty() {
        return cards.isEmpty();
    }
}

class Player {
    String name;
    List<Card> hand = new ArrayList<>();
    List<Card> collected = new ArrayList<>();
    int score = 0;

    Player(String name) {
        this.name = name;
    }

    void drawFromDeck(Deck deck) {
        while (hand.size() < 4 && !deck.isEmpty()) {
            hand.add(deck.drawCard());
        }
    }

    Card playCard(int index) {
        return hand.remove(index);
    }
}

class ScoreManager {
    private final String fileName = "top10.txt";

    void saveScore(String name, int score) {
        try {
            List<String> lines = new ArrayList<>();
            File file = new File(fileName);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                reader.close();
            }
            lines.add(name + "," + score);
            lines.sort((a, b) -> Integer.parseInt(b.split(",")[1]) - Integer.parseInt(a.split(",")[1]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            int limit = Math.min(10, lines.size());
            for (int i = 0; i < limit; i++) {
                writer.write(lines.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void displayTop10() {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                System.out.println("--- Top 10 Scores ---");
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    System.out.println(parts[0] + ": " + parts[1]);
                }
                reader.close();
            } else {
                System.out.println("Top 10 list is empty.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        ScoreManager scoreManager = new ScoreManager();

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        Player computer = new Player("Computer");

        List<Card> pile = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            pile.add(deck.drawCard());
        }

        while (!deck.isEmpty() || !player.hand.isEmpty()) {
            player.drawFromDeck(deck);
            computer.drawFromDeck(deck);

            for (int i = 0; i < 4 && !player.hand.isEmpty(); i++) {
                System.out.println("Pile: " + (pile.isEmpty() ? "Empty" : pile.get(pile.size() - 1)));
                System.out.println("Your hand:");
                for (int j = 0; j < player.hand.size(); j++) {
                    System.out.println(j + 1 + ". " + player.hand.get(j));
                }
                System.out.print("Choose card to play (1-" + player.hand.size() + "): ");
                int choice = scanner.nextInt() - 1;
                Card played = player.playCard(choice);
                System.out.println("You played: " + played);

                if (!pile.isEmpty() && played.isEqual(pile.get(pile.size() - 1))) {
                    System.out.println("Pişti! You collect the pile.");
                    player.collected.addAll(pile);
                    player.collected.add(played);
                    player.score += pile.size() == 1 ? 10 : pile.size();
                    pile.clear();
                } else {
                    pile.add(played);
                }

                Card compPlayed = computer.playCard(0);
                System.out.println("Computer played: " + compPlayed);
                if (!pile.isEmpty() && compPlayed.isEqual(pile.get(pile.size() - 1))) {
                    System.out.println("Computer made pişti!");
                    computer.collected.addAll(pile);
                    computer.collected.add(compPlayed);
                    computer.score += pile.size() == 1 ? 10 : pile.size();
                    pile.clear();
                } else {
                    pile.add(compPlayed);
                }
            }
        }

        if (!pile.isEmpty()) {
            player.collected.addAll(pile);
        }

        System.out.println("Game Over!");
        System.out.println(player.name + " score: " + player.score);
        System.out.println(computer.name + " score: " + computer.score);

        if (player.score > computer.score) {
            System.out.println("You win!");
        } else if (player.score < computer.score) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a draw!");
        }

        scoreManager.saveScore(player.name, player.score);
        scoreManager.displayTop10();
        scanner.close();
    }
}
