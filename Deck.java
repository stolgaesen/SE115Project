import java.util.Random;
public class Deck{
	private String[] SUITS = { "♠" , "♣" , "♥" , "♦"};
	private String[] RANKS={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	
        int n = SUITS.length * RANKS.length;
        String[] deck = new String[n];
		Deck(){
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
	}
		
	public void shuffle(){
		for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
		}		
		 for (int i = 0; i < n; i++) {
            System.out.println(deck[i]);
		}
    }
}