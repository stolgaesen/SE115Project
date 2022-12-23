import java.util.Scanner;
public class Game{
	Scanner sc = new Scanner(System.in);
	public static Deck a = new Deck();
	public static int deckLastIndex = 51; //remaining cards
	public static Deck[] userCards = new Deck[4];
	public static Deck[] pcCards = new Deck[4];
	public static Deck[] boardCards = new Deck[4];
	public void firstRound(){
		for(int i=0;i<8;i++){
			if(i % 2 ==0){
				userCards[i] = a.cut;
			} else {
				pcCards[i] = a.cut;
			}
		}
	}
}