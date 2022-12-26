import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Deck{
	private String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades" };
	private String[] RANKS={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	
	Scanner sc = new Scanner(System.in);
    int n = SUITS.length * RANKS.length; //n is 52 
    String[] deck = new String[n];// string array for the hold the all of the cards
    // It's deck constructor
	Deck(){
        for (int i = 0; i < RANKS.length; i++) { // loop to set all cards
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
	}
	// to shuffle the deck	
	public void shuffle(){
		for (int i = 0; i < n; i++) { //loop to shuffle all cards
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
    String[] cutdeck = new String[52];// for hold the cutted deck
	int cutpoint; //this would be an input form the user
	boolean cutpointcontrol = true;// control variable for the input has to between 1 and 51
	boolean cutcontrol =true;// control variable for the try and catch
    // Cut function for the deck	
	public void cut(){
		while(cutcontrol){
		    try{
			    while(cutpointcontrol){
				  cutpoint = sc.nextInt(); //input from the user
				  if(cutpoint >=1 && cutpoint <=51){
			      System.out.println("Cutting is doing");
			      cutpointcontrol =false;
				  cutcontrol = false;
				    } else System.out.println("Not a valid number! Try again");
			    }
			  String[] copying1 = new String[cutpoint];
		      String[] copying2 = new String[52-cutpoint];
		      System.arraycopy(deck, 0 , copying1, 0 ,cutpoint);
		      System.arraycopy(deck,copying1.length,copying2,0,copying2.length);
		      System.arraycopy(copying2,0,cutdeck,0,copying2.length);
		      System.arraycopy(copying1,0,cutdeck,copying2.length,copying1.length);
		      // loop for the printing the cutted deck
		      for(int i =0;i<cutdeck.length;i++){
			  System.out.println(cutdeck[i]);
                }
		    }// catch the possible not integer inputs
			catch (InputMismatchException e){
                    System.out.println("Not a valid number! Try again");
                    sc.nextLine();
            }
		}
	}	
	public static boolean control = true; //boolean variable for end the game
	public static int deckLastIndex = 52; //all of the cards
	public static int userPoint = 0; // User's point	
	public static int pcPoint = 0; // 
	public static String[] userCards = new String[52];// to store the user's cards
	public static String[] pcCards = new String[52];// to store the pc's cards
	public static String[] boardCards = new String[52]; //to store the board's cards
	// wrote a separate function for the first round to start and continue the game
	public void Round(){
		while(control){
			//for loop to identify first 4 cards of board
		for(int i=0;i<4;i++){
				boardCards[i]= cutdeck[i];
				System.out.println("The boards's " + (i+1) + ". card is : " + cutdeck[i] );
				deckLastIndex--;
			}
		//for loop to identify first 4 cards of user and pc
		for(int i=4;i<12;i++){
			// used switch for the distribute the cards 1 by 1 for user and pc
			switch(i){
				case 4:
				System.out.println("The user's 1. card is : " + cutdeck[i]);
				userCards[0]=cutdeck[i];
				deckLastIndex--;
				break;
				case 5: 
				System.out.println("The pc's 1. card is : " + cutdeck[i]);
				pcCards[0] = cutdeck[i];
				deckLastIndex--;
				break;
				case 6:
				System.out.println("The user's 2. card is : " + cutdeck[i]);
				userCards[1]=cutdeck[i];
				deckLastIndex--;
				break;
				case 7: 
				System.out.println("The pc's 2. card is : " + cutdeck[i]);
				pcCards[1] = cutdeck[i];
				deckLastIndex--;
				break;
				case 8:
				System.out.println("The user's 3. card is : " + cutdeck[i]);
				userCards[2]=cutdeck[i];
				deckLastIndex--;
				break;
				case 9: 
				System.out.println("The pc's 3. card is : " + cutdeck[i]);
				pcCards[2] = cutdeck[i];
				deckLastIndex--;
				break;
				case 10:
				System.out.println("The user's 4. card is : " + cutdeck[i]);
				userCards[3]=cutdeck[i];
				deckLastIndex--;
				break;
				case 11: 
				System.out.println("The pc's 4. card is : " + cutdeck[i]);
				pcCards[3] = cutdeck[i];
				deckLastIndex--;
				break;
			}		
        }
	     //loop for the playing cards and controlling the collected points
		for(int i=0;i<4;i++){
			for(int k=0;k<4;k++){
		if(userCards[i].charAt(0) == boardCards[k].charAt(0) || pcCards[i].charAt(0) == boardCards[k].charAt(0) ){
			if(userCards[i].charAt(0) == boardCards[k].charAt(0)){
				// if for the number is 10, because 10 is 3 point
				if(userCards[k].charAt(0) == '1'){
					System.out.println("User used 10 and earned 3 point");
					userPoint +=3;
					break;
				  }
				//else if for the number is 2, because any 2 ise 2 point
				else if(userCards[k].charAt(0)== '2'){
					System.out.println("User used 2 and earned 2 point");
					userPoint +=2;
					break;
				  }
				//else if for the jack of any cards,because jack is allowed to collect every card on the board
				else if(userCards[k].charAt(0) == 'J'){
					System.out.println("User used jack and collected all the cards on the board");
					userPoint++;
					break;
				}
			System.out.println("you did a point ");
			userPoint++;
			break;
			} else if(pcCards[i].charAt(0) == boardCards[k].charAt(0)){
				// if for the number is 10 because 10 is 3 point
				if(userCards[k].charAt(0) == '1'){
					System.out.println("Pc used 10 and earned 3 point");
					pcPoint +=3;
					break;
					}
				}//else if for the number is 2, because any 2 ise 2 point
				else if(pcCards[k].charAt(0) == '2'){
					System.out.println("Pc used 2 and earned 2 point");
					userPoint +=2;
					break;
					}
				//else if for the jack of any cards,because jack is allowed to collect every card on the board
				else if(pcCards[k].charAt(0) == 'J'){
					System.out.println("Pc used jack and collected all the cards on the board");
					pcPoint++;
				    break;
				    }
				System.out.println("Pc did a point ");
			    pcPoint++;
				break;  
		    }
		  }
		}
		 //for loop to identify second 4 cards of user and pc
		for(int i=12;i<20;i++){
			// used switch for the distribute the cards 1 by 1 for user and pc
			switch(i){
				case 12:
				System.out.println("The user's 5. card is : " + cutdeck[i]);
				userCards[4]=cutdeck[i];
				deckLastIndex--;
				break;
				case 13: 
				System.out.println("The pc's 5. card is : " + cutdeck[i]);
				pcCards[4] = cutdeck[i];
				deckLastIndex--;
				break;
				case 14:
				System.out.println("The user's 6. card is : " + cutdeck[i]);
				userCards[5]=cutdeck[i];
				deckLastIndex--;
				break;
				case 15: 
				System.out.println("The pc's 6. card is : " + cutdeck[i]);
				pcCards[5] = cutdeck[i];
				deckLastIndex--;
				break;
				case 16:
				System.out.println("The user's 7. card is : " + cutdeck[i]);
				userCards[6]=cutdeck[i];
				deckLastIndex--;
				break;
				case 17: 
				System.out.println("The pc's 7. card is : " + cutdeck[i]);
				pcCards[6] = cutdeck[i];
				deckLastIndex--;
				break;
				case 18:
				System.out.println("The user's 8. card is : " + cutdeck[i]);
				userCards[7]=cutdeck[i];
				deckLastIndex--;
				break;
				case 19: 
				System.out.println("The pc's 8. card is : " + cutdeck[i]);
				pcCards[7] = cutdeck[i];
				deckLastIndex--;
				break;
			}		
        }
		 //loop for the playing cards and controlling the collected points
		for(int i=4;i<8;i++){
			for(int k=4;k<8;k++){
		        if(userCards[i].charAt(0) == pcCards[k].charAt(0)){
				// if for the number is 10, because 10 is 3 point
				  if(userCards[k].charAt(0) == '1'){
					System.out.println("User used 10 and earned 3 point");
					userPoint +=3;
					break;
					}
				  //else if for the number is 2, because any 2 ise 2 point
				  else if(userCards[k].charAt(0)== '2'){
					System.out.println("User used 2 and earned 2 point");
					userPoint +=2;
					break;
					}
				  //else if for the jack of any cards,because jack is allowed to collect every card on the board without doubt
				  else if(userCards[k].charAt(0) == 'J'){
					System.out.println("User used jack and collected all the cards on the board");
					userPoint++;
			        break;
				}
			System.out.println("you did a point ");
			userPoint++;
			break;
			// else pc's card is not equal to user's card
			    } else {
					for(int a=0;a<4;a++){
			           userCards[k]=boardCards[a];
					}
			  }  
		    }
		}
        	 // for loop to identify third 4 cards of user and pc
		for(int i=20;i<28;i++){
			// used switch for the distribute the cards 1 by 1 for user and pc
			switch(i){
				case 20:
				System.out.println("The user's 9. card is : " + cutdeck[i]);
				userCards[8]=cutdeck[i];
				deckLastIndex--;
				break;
				case 21: 
				System.out.println("The pc's 9. card is : " + cutdeck[i]);
				pcCards[8] = cutdeck[i];
				deckLastIndex--;
				break;
				case 22:
				System.out.println("The user's 10. card is : " + cutdeck[i]);
				userCards[9]=cutdeck[i];
				deckLastIndex--;
				break;
				case 23: 
				System.out.println("The pc's 10. card is : " + cutdeck[i]);
				pcCards[9] = cutdeck[i];
				deckLastIndex--;
				break;
				case 24:
				System.out.println("The user's 11. card is : " + cutdeck[i]);
				userCards[10]=cutdeck[i];
				deckLastIndex--;
				break;
				case 25: 
				System.out.println("The pc's 11. card is : " + cutdeck[i]);
				pcCards[10] = cutdeck[i];
				deckLastIndex--;
				break;
				case 26:
				System.out.println("The user's 12. card is : " + cutdeck[i]);
				userCards[11]=cutdeck[i];
				deckLastIndex--;
				break;
				case 27: 
				System.out.println("The pc's 12. card is : " + cutdeck[i]);
				pcCards[11] = cutdeck[i];
				deckLastIndex--;
				break;
			}		
        }
		 //loop for the playing cards and controlling the collected points
		for(int i=8;i<12;i++){
			for(int k=8;k<12;k++){
		        if(userCards[i].charAt(0) == pcCards[k].charAt(0)){
				// if for the number is 10, because 10 is 3 point
				  if(userCards[k].charAt(0) == '1'){
					System.out.println("User used 10 and earned 3 point");
					userPoint +=3;
					break;
					}
				  //else if for the number is 2, because any 2 ise 2 point
				  else if(userCards[k].charAt(0)== '2'){
					System.out.println("User used 2 and earned 2 point");
					userPoint +=2;
					break;
					}
				  //else if for the jack of any cards,because jack is allowed to collect every card on the board without doubt
				  else if(userCards[k].charAt(0) == 'J'){
					System.out.println("User used jack and collected all the cards on the board");
					userPoint++;
			        break;
				}
			System.out.println("you did a point ");
			userPoint++;
			break;
			//else pc's card is not equal to user's card
			    } else {
					for(int a=0;a<4;a++){
			           userCards[k]=boardCards[a];
					}
			  }  
		    }
		} // for loop to identify third 4 cards of user and pc
		for(int i=28;i<36;i++){
			// used switch for the distribute the cards 1 by 1 for user and pc
			switch(i){
				case 28:
				System.out.println("The user's 13. card is : " + cutdeck[i]);
				userCards[12]=cutdeck[i];
				deckLastIndex--;
				break;
				case 29: 
				System.out.println("The pc's 13. card is : " + cutdeck[i]);
				pcCards[12] = cutdeck[i];
				deckLastIndex--;
				break;
				case 30:
				System.out.println("The user's 14. card is : " + cutdeck[i]);
				userCards[13]=cutdeck[i];
				deckLastIndex--;
				break;
				case 31: 
				System.out.println("The pc's 14. card is : " + cutdeck[i]);
				pcCards[13] = cutdeck[i];
				deckLastIndex--;
				break;
				case 32:
				System.out.println("The user's 15. card is : " + cutdeck[i]);
				userCards[14]=cutdeck[i];
				deckLastIndex--;
				break;
				case 33: 
				System.out.println("The pc's 15. card is : " + cutdeck[i]);
				pcCards[14] = cutdeck[i];
				deckLastIndex--;
				break;
				case 34:
				System.out.println("The user's 16. card is : " + cutdeck[i]);
				userCards[15]=cutdeck[i];
				deckLastIndex--;
				break;
				case 35: 
				System.out.println("The pc's 16. card is : " + cutdeck[i]);
				pcCards[15] = cutdeck[i];
				deckLastIndex--;
				break;
			}		
        }
		 //loop for the playing cards and controlling the collected points
		for(int i=12;i<16;i++){
			for(int k=12;k<16;k++){
		        if(userCards[i].charAt(0) == pcCards[k].charAt(0)){
				// if for the number is 10, because 10 is 3 point
				  if(userCards[k].charAt(0) == '1'){
					System.out.println("User used 10 and earned 3 point");
					userPoint +=3;
					break;
					}
				  //else if for the number is 2, because any 2 ise 2 point
				  else if(userCards[k].charAt(0)== '2'){
					System.out.println("User used 2 and earned 2 point");
					userPoint +=2;
					break;
					}
				  //else if for the jack of any cards,because jack is allowed to collect every card on the board without doubt
				  else if(userCards[k].charAt(0) == 'J'){
					System.out.println("User used jack and collected all the cards on the board");
					userPoint++;
			        break;
				}
			System.out.println("you did a point ");
			userPoint++;
			break;
			//else pc's card is not equal to user's card
			    } else {
					for(int a=0;a<4;a++){
			           userCards[k]=boardCards[a];
					}
			  }  
		    }
		}
		if(userPoint == 0 && pcPoint == 0){ //if nobody has a point
			System.out.println("Nobody have a point right now");
		} else if(userPoint ==0){ //if only pc has a point
			System.out.println("User has no point right now");
			System.out.println("Pc has " + pcPoint + " point right now");
		} else if(pcPoint ==0){ //if only user has a point
			System.out.println("Pc has no point right now");
			System.out.println("User has " + userPoint + " point right now");
			
		}else if(pcPoint !=0 && userPoint !=0){ //if both are not equal to 0 
			System.out.println("User has " + userPoint + " point right now");
			System.out.println("Pc has " + pcPoint + " point right now");
		}
		System.out.println(deckLastIndex);//
		 control = false;	
    }
  }
}