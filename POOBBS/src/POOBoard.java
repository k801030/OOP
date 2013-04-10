class Arti{
	public int seq;
	public String title;
}

public class POOBoard {
	private static int NumOfBoard = 0; // the number of boards

	private String name;
	private int seq; //the sequence of boards
	
	private Arti[] arti = new Arti[1024]; 
	private int NumOfArti = 0; //the number of items

	//method
	public POOBoard(String name){
		this.name = String.valueOf(name);
		seq = NumOfBoard;
		NumOfBoard++;
	}
	public void add(POOArticle article){
		
	}
	public void del(int pos){
		
	}
	public void move(int src, int dest){
		
	}
	public int length(){
		return NumOfArti;
	}
	public void show(){
		
	}
	
	// GET series
	public int getSeq(){
		return seq;
	}
	public String getName(){
		return name;
	}
}
