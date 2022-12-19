public class Card {
	// definening the variables
    private String type;
    private String num;
    //Constructor that have a 2 parameters
    public Card(String type,String num){
        this.type=type;
        this.num=num;
    }
	//For get the suits and numbers
    public String getType(){
		return type;
    }
    public String getNum(){
		return num;
	}
	//For setting the number and suits
	public void setType(String Type){
		this.type=type;
	}
	public void setNum(String Num){
		this.num=num
	}
	public String toCardInfo(){
		return type + " " + num;
	}
}