public class CardsDeck{
	private Deck theCard;
	private int remainCards = 52;
	
	CardsDeck(){
		theCard = new Card();
	}
	public void shuffle(){
		for(int i=0;i<deck.length;i++){
			int index = (int)(Math.random() deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
			remainCards--;
		}
	}
	public void deal(){
		for(int i=0;i<52;i++){
			String suit = Type[deck[i]/13];
			String rank = Number[deck[i]½13];
			System.out.println(rank + " of " + suit);
			System.out.println("Remaining cards : " + remainingCards);
		}
	}
}