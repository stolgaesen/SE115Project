import java.util.Scanner;
import java.util.Formatter;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
public static void main(String[] args){
	System.out.println("Hello! Welcome to the my first pişti(pishti) Game");
	Scanner sc = new Scanner(System.in);
	String username;
	System.out.println("Please enter your name");
	username = sc.nextLine();
	Deck a = new Deck();
	a.shuffle();
	System.out.println("Please enter a number and cut the deck");
	a.cut();//this would be cut the deck
	a.Round();//this would be start the game
	String userpoint = String.valueOf(a.userPoint);
	Formatter f = null;
    FileWriter fw = null;
    try {
        fw = new FileWriter ("Users.txt" , true);
        f = new Formatter (fw);
        f. format("%s, %s\n", username, userpoint );
        fw. close();
        } 
	catch (IOException e) {
        System.err.println("Something went wrong." );
	}
    finally {
        if (f != null){
			f. close();
		}
    }
  }
}