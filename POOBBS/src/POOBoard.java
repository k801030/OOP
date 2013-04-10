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
		Arti tmpArti = new Arti();
		for(int i = pos; i<NumOfArti-1; i++){
			tmpArti = arti[i];
			arti[i] = arti[i+1];
			arti[i+1] = tmpArti;
		}
		NumOfArti--;
	}
	public void move(int src, int dest){
		Arti tmpArti = new Arti();
		for(int i = src; i<dest-1; i++){
			tmpArti = arti[i];
			arti[i] = arti[i+1];
			arti[i+1] = tmpArti;
		}
		NumOfArti--;
	}
	public int length(){
		return NumOfArti;
	}
	public void show(){
		System.out.println("[BOARD] "+name+" [BOARD]");
		printShow("0","Home page","");
		for(int i=0;i<NumOfArti;i++){
			printShow(Integer.toString(i), Integer.toString(arti[i].id), arti[i].title);
		}
	}
	private void printShow(String a,String b,String c){
	   	int i;
	   	System.out.print(a);
	   	for(i=a.length();i<3;i++)
	   		System.out.print(" ");
	   	System.out.print(b);
	   	for(i=b.length();i<5;i++)
	   		System.out.print(" ");
	   	System.out.print(c);
	   	for(i=c.length();i<7;i++)
	    	System.out.print(" ");
	    System.out.println("");
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
