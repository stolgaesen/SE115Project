import java.util.Random;
public class Deck{
	public Card[] card1 = new Card[52];
	private String[] type = { "♠" , "♣" , "♥" , "♦"};
	private String[] number={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	
	Deck(){
		int indexCards=0;
		for(int i=0;i<type.length;i++){
			for(int k=0;k<number.length;k++){
				card1[indexCard] = new Card(type[i],number[k];
				indexCard +=1;
			}
		}
		
	}
	private Random r = new Random();
	public void shuffle(){
		Card temp;
		for(int i = 0;i < 52;i++){
			int a = r.nextInt(52);
			temp = deck[i];
			deck[i] = deck[a];
			deck[a] = temp;
		}
		for(int i = 0;i<52;i++){
			System.out.println(deck[i]);
		}
	}
	public static void main(String[] args){
		Deck deck1 = new Deck();
		for(int i =0;i<52;i++){
			System.out.println(deck1.Deck[i].getNum());
		}
	}
}