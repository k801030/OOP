class Item{
	public String type;
	public int seq;
}

public class POODirectory {
	//public String[] type = new String [1024];
	//public int[] num = new int [1024];
	public String name ;
	public Item[] item = new Item[1024];
	private int count = 0;
	public  POODirectory(String nametmp){
		name = nametmp;
	}
	public void add(POOBoard board){
		item[count].type = String.valueOf("board");
		item[count].seq = board.getSeq();
	}
	public void add(POODirectory dir){
		
	}
	public void add_split(){
		
	}
	public void del(int pos){
		
	}
	public void move(int src, int dest){
		
	}
	public int length(){
		return 1;
	}
	public void show(){
		
	}
}
