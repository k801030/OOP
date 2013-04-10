class Article{
	public int seq;
	public String title;
}

public class POOBoard {
	private static int NumOfBoard = 0; // the number of boards

	private String name;
	private int seq; //the sequence of boards
	
	private Article[] item = new Article[1024]; 
	private int NumOfitem = 0; //the number of items

	//method
	public POOBoard(String nametmp){
		name = String.valueOf(nametmp);
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
		return 0;
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
