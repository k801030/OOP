class Arti{
	public int id;
	public String title;
}

public class POOBoard {
	private static int NumOfBoard = 0; // the number of boards

	private String name;
	private int id; //the unique sequence of boards
	
	private final int MAX = 1024;
	private Arti[] arti = new Arti[1024]; 
	private int NumOfArti = 0; //the number of items

	//method
	public POOBoard(String name){
		this.name = String.valueOf(name);
		id = NumOfBoard;
		NumOfBoard++;
		init();
	}
	public void add(POOArticle article){
		if(checkArti()){
			arti[NumOfArti].id = article.getId(); 
			arti[NumOfArti].title = String.valueOf(article.getTitle());
			NumOfArti++;
		}
	}
	public void del(int pos){
		Arti tmpArti = new Arti();
		pos--;
		for(int i = pos; i<NumOfArti-1; i++){
			tmpArti = arti[i];
			arti[i] = arti[i+1];
			arti[i+1] = tmpArti;
		}
		NumOfArti--;
	}
	public void move(int src, int dest){
		Arti tmpArti = new Arti();
		src--;
		dest--;
		tmpArti = arti[src];
		arti[src] = arti[dest];
		arti[dest] = tmpArti;
	}
	public int length(){
		return NumOfArti;
	}
	public void show(){
		System.out.println("[BOARD] "+name+" [BOARD]");
		printShow("0","..","back");
		for(int i=0;i<NumOfArti;i++){
			printShow(Integer.toString(i+1), arti[i].title, Integer.toString(arti[i].id));
		}
	}
	/////////////////////////////////////////////////////////////////////////
	//                        Other Method                                 //
	
	private void init(){ // initialization 
		for(int i=0;i<MAX;i++){
			arti[i] = new Arti();
			arti[i].id = 0;
			arti[i].title = null;
		}
	}
	private void printShow(String a,String b,String c){
	   	int i;
	   	System.out.print(a);
	   	for(i=a.length();i<3;i++)
	   		System.out.print(" ");
	   	System.out.print(b);
	   	for(i=b.length();i<14;i++)
	   		System.out.print(" ");
	   	System.out.print(c);
	   	for(i=c.length();i<7;i++)
	    	System.out.print(" ");
	    System.out.println("");
	}
	private boolean checkArti(){
		if(NumOfArti==MAX){
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
