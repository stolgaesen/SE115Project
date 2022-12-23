import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
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
    //Cut function for the deck	
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
		//For loop for the printing the cutted deck
		for(int i =0;i<cutdeck.length;i++){
			System.out.println(cutdeck[i]);
		}
	}	
	public static int deckLastIndex = 51; //remaining cards
	public static String[] userCards = new String[52];
	public static String[] pcCards = new String[52];
	public static String[] boardCards = new String[52];
	public void firstRound(){
		for(int i=0;i<8;i++){
			switch(i){
				case 0:
				System.out.println("The user's first card is : " + cutdeck[i]);
				userCards[0]=cutdeck[i];
				break;
				case 1: 
				System.out.println("The pc's first card is : " + cutdeck[i]);
				pcCards[0] = cutdeck[i];
				break;
				case 2:
				System.out.println("The user's second card is : " + cutdeck[i]);
				userCards[1]=cutdeck[i];
				break;
				case 3: 
				System.out.println("The pc's second card is : " + cutdeck[i]);
				pcCards[1] = cutdeck[i];
				break;
				case 4:
				System.out.println("The user's third card is : " + cutdeck[i]);
				userCards[2]=cutdeck[i];
				break;
				case 5: 
				System.out.println("The pc's third card is : " + cutdeck[i]);
				pcCards[2] = cutdeck[i];
				break;
				case 6:
				System.out.println("The user's fourth card is : " + cutdeck[i]);
				userCards[3]=cutdeck[i];
				break;
				case 7: 
				System.out.println("The pc's fourth card is : " + cutdeck[i]);
				pcCards[3] = cutdeck[i];
				break;
			}		
        }
    }
}