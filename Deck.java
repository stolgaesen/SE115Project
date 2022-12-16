public class Deck{
	int decknumber = 52;
	String[] Type = { "♠" , "♣" , "♥" , "♦"};
	String[] Number={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	int[] deck = new int[decknumber];
	
	Card(){
		for(int i=0;i<deck.length;i++){
			deck[i] = i;
			return deck[i];
		}
		
	}
}