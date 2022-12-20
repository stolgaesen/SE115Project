import java.util.Random;
import java.util.Scanner;
public class Deck{
	private String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades" };
	private String[] RANKS={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	
	Scanner sc = new Scanner(System.in);
    int n = SUITS.length * RANKS.length;
    String[] deck = new String[n];
    //It's deck constructor
	Deck(){
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
	}
	// to shuffle the deck	
	public void shuffle(){
		for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
		}
         //For printing shuffled deck		
		for (int i = 0; i < n; i++) {
            System.out.println(deck[i]);
		}
	}	
    String[] cutdeck = new String[52];	
	public void cut(){
		int cutpoint = sc.nextInt();
		if(cutpoint >=1 && cutpoint <=51) System.out.println("Cutting is doing");
		else System.out.println("Please enter a valid cutpoint");
		String[] copying1 = new String[cutpoint];
		String[] copying2 = new String[52-cutpoint];
		System.arraycopy(deck, 0 , copying1, 0 ,cutpoint);
		System.arraycopy(deck,copying1.length,copying2,0,copying2.length);
		System.arraycopy(copying2,0,cutdeck,0,copying2.length);
		System.arraycopy(copying1,0,cutdeck,copying2.length,copying1.length);
		for(int i =0;i<cutdeck.length;i++){
			System.out.println(cutdeck[i]);
		}
		 		
    }
}