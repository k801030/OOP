class Arti{
	public int id;
	public String title;
}

public class POOBoard {
	private static int NumOfBoard = 0; // the number of boards

	private String name;
	private int id; //the sequence of boards
	
	private final int max = 1024;
	private Arti[] arti = new Arti[1024]; 
	private int NumOfArti = 0; //the number of items

	//method
	public POOBoard(String name){
		this.name = String.valueOf(name);
		id = NumOfBoard;
		NumOfBoard++;
	}
	public void add(POOArticle article){
		if(checkArti()){
			arti[NumOfArti].id = article.getId(); 
			arti[NumOfArti].title = String.valueOf(article.getTitle());
		}
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
	
	private boolean checkArti(){
		if(NumOfArti==max){
			System.out.print("The board is full. Fail to add anything!");
			return false;
		}else {
			return true;
		}
	}
	// GET series
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
}
