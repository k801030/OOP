class Line{
		public String type;
		public int id;
		public String name;
}
public class POODirectory {

	//public String[] type = new String [max];
	//public int[] num = new int [max];
	private static int NumOfDir = 0; // the number of directories
	
	private String name ;
	private int id; //the sequence of directories
	
	private final int max = 1024;
	private Line[] line = new Line[max]; 
		
	private int NumOfLine = 0; //the number of lines

	// method
	public  POODirectory(String name){
		this.name = String.valueOf(name);
		id = NumOfDir;
		NumOfDir ++;
		init();
	}
	
	public void add(POOBoard board){
		if(checkLine()){
			line[NumOfLine].type = String.valueOf("board");
			line[NumOfLine].id = board.getId();
			line[NumOfLine].name = board.getName();
			NumOfLine++;
		}
	}
	
	public void add(POODirectory dir){
		if(checkLine()){
			line[NumOfLine].type = String.valueOf("dir");
			line[NumOfLine].id = dir.getId();
			line[NumOfLine].name = dir.getName();
			NumOfLine++;
		}
	}
	
	public void add_split(){
		if(checkLine()){
			line[NumOfLine].type = String.valueOf("split");
			NumOfLine++;
		}
	}
	
	public void del(int pos){
		Line tmpLine = new Line();
		for(int i = pos; i<NumOfLine-1; i++){
			tmpLine = line[i];
			line[i] = line[i+1];
			line[i+1] = tmpLine;
		}
		NumOfLine--;
	}
	
	public void move(int src, int dest){
		Line tmpLine = new Line();
		for(int i = src; i<dest-1; i++){
			tmpLine = line[i];
			line[i] = line[i+1];
			line[i+1] = tmpLine;
		}
	}
	
	public int length(){
		return NumOfLine;
	}
	
	public void show(){
		System.out.println("[DIR] "+name+" [DIR]");
		printShow("0","Home","dir");
		for(int i=0;i<NumOfLine;i++){
			if(line[i].type.equals("board")){
				printShow(Integer.toString(i+1),line[i].name, line[i].type);
			}else if(line[i].type.equals("dir")){
				printShow(Integer.toString(i+1),line[i].name, line[i].type);
			}else if(line[i].type.equals("split")){
				printShow(Integer.toString(i+1),"------------", null);
			}
		}
	}
	/////////////////////////////////////////////////////////////////////////
	//                        Other Method                                 //
	private void init(){ // initialization 
		for(int i=0;i<max;i++){
			line[i] = new Line();
			line[i].type = null;
			line[i].id = 0;
			line[i].name = null;
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
	private boolean checkLine(){
		if(NumOfLine==max){
			System.out.print("The directory is full. Fail to add anything!");
			return false;
		}else {
			return true;
		}
	}
	public static void finish(){
		NumOfDir = 0; 
	}
	
	// GET series
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int getLineId(int i){
		if(i>0)
			return line[i-1].id;
		else 	// back to home page
			return 0;   
	}
}
