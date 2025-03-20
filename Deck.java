package SE115Project;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Deck{
	private String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades" };
	private String[] RANKS={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	
	Scanner sc = new Scanner(System.in);
    int n = SUITS.length * RANKS.length; //n is 52 
    String[] deck = new String[n];// string array for the hold the all of the cards
    // It's a deck constructor
	Deck(){
        for (int i = 0; i < RANKS.length; i++) { // loop for to set all cards
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
	}
	public void shuffle(){ // to shuffle the deck	
		for (int i = 0; i < n; i++) { //loop to shuffle all cards
            int a = i + (int) (Math.random() * (n-i));
            String temp = deck[a]; // creating a temporary string variable
            deck[a] = deck[i];
            deck[i] = temp;
		}	
		for (int i = 0; i < n; i++) { //loop for printing the shuffled deck	
            System.out.println(deck[i]);
		}
	}	
    String[] cutdeck = new String[52];// for hold the cutted deck
	int cutpoint; //this would be an input form the user
	boolean cutpointcontrol = true;// control variable for the input because input has to between 1 and 52
	boolean cutcontrol =true;// control variable for the try and catch
	public void cut(){ // Cut function for the deck
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
		      for(int i =0;i<cutdeck.length;i++){ // loop for the printing the cutted deck
			  System.out.println(cutdeck[i]);
                }
		    }// catch the possibility for the not integer inputs
			catch (InputMismatchException e){
                    System.err.println("Not a valid number! Try again");
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
		  for(int i=0;i<4;i++){ //for loop to identify first 4 cards of board
				boardCards[i]= cutdeck[i];
				System.out.println("The boards's " + (i+1) + ". card is : " + cutdeck[i] );
				deckLastIndex--;
			}
		
		for(int i=4;i<12;i++){ //for loop to identify first 4 cards of user and pc
			switch(i){ // switch for the distribute the cards 1 by 1 for user and pc
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
			    } 
		    }
		}
		for(int i=20;i<28;i++){// for loop to identify third 4 cards of user and pc
			switch(i){ // used switch for the distribute the cards 1 by 1 for user and pc
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
		for(int i=8;i<12;i++){//loop for the playing cards and controlling the collected points
			for(int k=8;k<12;k++){
		        if(userCards[i].charAt(0) == pcCards[k].charAt(0)){ // if for the number is 10, because 10 is 3 point
				  if(userCards[k].charAt(0) == '1'){
					System.out.println("User used 10 and earned 3 point");
					userPoint +=3;
					break;
					}
				  else if(userCards[k].charAt(0)== '2'){ // else if for the number is 2, because any 2 ise 2 point
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
			    }  
		    }
		} 
		for(int i=28;i<36;i++){ // for loop to identify fourth 4 cards of user and pc
			switch(i){ // used switch for the distribute the cards 1 by 1 for user and pc
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
		for(int i=12;i<16;i++){ // loop for the playing cards and controlling the collected points
			for(int k=12;k<16;k++){
		        if(userCards[i].charAt(0) == pcCards[k].charAt(0)){
				  if(userCards[k].charAt(0) == '1'){ // if for the number is 10, because 10 is 3 point
					System.out.println("User used 10 and earned 3 point");
					userPoint +=3;
					break;
					}
				  else if(userCards[k].charAt(0)== '2'){ // else if for the number is 2, because any 2 ise 2 point
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
			    } 
		    }
		}
		for(int i=36;i<44;i++){ // for loop to identify fifth 4 cards of user and pc
			switch(i){ // used switch for the distribute the cards 1 by 1 for user and pc
				case 36:
				System.out.println("The user's 17. card is : " + cutdeck[i]);
				userCards[16]=cutdeck[i];
				deckLastIndex--;
				break;
				case 37: 
				System.out.println("The pc's 17. card is : " + cutdeck[i]);
				pcCards[16] = cutdeck[i];
				deckLastIndex--;
				break;
				case 38:
				System.out.println("The user's 18. card is : " + cutdeck[i]);
				userCards[17]=cutdeck[i];
				deckLastIndex--;
				break;
				case 39: 
				System.out.println("The pc's 18. card is : " + cutdeck[i]);
				pcCards[17] = cutdeck[i];
				deckLastIndex--;
				break;
				case 40:
				System.out.println("The user's 19. card is : " + cutdeck[i]);
				userCards[18]=cutdeck[i];
				deckLastIndex--;
				break;
				case 41: 
				System.out.println("The pc's 19. card is : " + cutdeck[i]);
				pcCards[18] = cutdeck[i];
				deckLastIndex--;
				break;
				case 42:
				System.out.println("The user's 20. card is : " + cutdeck[i]);
				userCards[19]=cutdeck[i];
				deckLastIndex--;
				break;
				case 43: 
				System.out.println("The pc's 20. card is : " + cutdeck[i]);
				pcCards[19] = cutdeck[i];
				deckLastIndex--;
				break;
			}		
        }
		for(int i=16;i<20;i++){ // loop for the playing cards and controlling the collected points
			for(int k=16;k<20;k++){
		        if(userCards[i].charAt(0) == pcCards[k].charAt(0)){
				  if(userCards[k].charAt(0) == '1'){ // if for the number is 10, because 10 is 3 point
					System.out.println("User used 10 and earned 3 point");
					userPoint +=3;
					break;
					}
				  else if(userCards[k].charAt(0)== '2'){ // else if for the number is 2, because any 2 ise 2 point
					System.out.println("User used 2 and earned 2 point");
					userPoint +=2;
					break;
					}
				  // else if for the jack of any cards,because jack is allowed to collect every card on the board without doubt
				  else if(userCards[k].charAt(0) == 'J'){
					System.out.println("User used jack and collected all the cards on the board");
					userPoint++;
			        break;
				}
			System.out.println("you did a point ");
			userPoint++;
			break;
			    }  
		    }
		}
		 // for loop to identify sixth 4 cards of user and pc
		for(int i=44;i<52;i++){
			// used switch for the distribute the cards 1 by 1 for user and pc
			switch(i){
				case 44:
				System.out.println("The user's 21. card is : " + cutdeck[i]);
				userCards[20]=cutdeck[i];
				deckLastIndex--;
				break;
				case 45: 
				System.out.println("The pc's 21. card is : " + cutdeck[i]);
				pcCards[20] = cutdeck[i];
				deckLastIndex--;
				break;
				case 46:
				System.out.println("The user's 22. card is : " + cutdeck[i]);
				userCards[21]=cutdeck[i];
				deckLastIndex--;
				break;
				case 47: 
				System.out.println("The pc's 22. card is : " + cutdeck[i]);
				pcCards[21] = cutdeck[i];
				deckLastIndex--;
				break;
				case 48:
				System.out.println("The user's 23. card is : " + cutdeck[i]);
				userCards[22]=cutdeck[i];
				deckLastIndex--;
				break;
				case 49: 
				System.out.println("The pc's 23. card is : " + cutdeck[i]);
				pcCards[22] = cutdeck[i];
				deckLastIndex--;
				break;
				case 50:
				System.out.println("The user's 24. card is : " + cutdeck[i]);
				userCards[23]=cutdeck[i];
				deckLastIndex--;
				break;
				case 51: 
				System.out.println("The pc's 24. card is : " + cutdeck[i]);
				pcCards[23] = cutdeck[i];
				deckLastIndex--;
				break;
			}		
        }
		for(int i=20;i<24;i++){ //loop for the playing cards and controlling the collected points
			for(int k=20;k<24;k++){
		        if(userCards[i].charAt(0) == pcCards[k].charAt(0)){
				  if(userCards[k].charAt(0) == '1'){ // if for the number is 10, because 10 is 3 point
					System.out.println("User used 10 and earned 3 point");
					userPoint +=3;
					break;
					}
				  else if(userCards[k].charAt(0)== '2'){ //else if for the number is 2, because any 2 ise 2 point
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
		} control = false;	// end of the game
    }
  }
}