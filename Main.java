import java.util.Scanner;
public class Main{
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Deck a = new Deck();
	System.out.println("Please enter your name! ");
	Player b = new Player();
	System.out.println("Hello! Welcome to the my first pişti(pishti) Game");
	a.shuffle();
	System.out.println("Please enter a number and cut the deck");
	a.cut();
	
 }
}