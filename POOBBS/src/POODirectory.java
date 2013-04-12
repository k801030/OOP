class Line{
		public String type;
		public int id;
		public String name;
}
public class POODirectory {

	private static int NumOfDir = 0; // the number of directories
	
	private String name ;
	private int id; //the unique sequence of directories
	
	private final int MAX = 1024;
	private Line[] line = new Line[MAX]; 
	
	private int NumOfLine = 0; //the number of lines
	private int pre_dir = 0;  // the pre one of dir; in order to "go back"
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
		dir.pre_dir = getId();
	}
	
	public void add_split(){
		if(checkLine()){
			line[NumOfLine].type = String.valueOf("split");
			NumOfLine++;
		}
	}
	
	public void del(int pos){
		Line tmpLine = new Line();
		pos--;
		for(int i = pos; i<NumOfLine; i++){
			tmpLine = line[i];
			line[i] = line[i+1];
			line[i+1] = tmpLine;
		}
		NumOfLine--;
	}
	
	public void move(int src, int dest){
		Line tmpLine = new Line();
		src--;
		dest--;
		tmpLine = line[src];
		line[src] = line[dest];
		line[dest] = tmpLine;
	}
	
	public int length(){
		return NumOfLine;
	}
	
	public void show(){
		System.out.println("[DIR] "+name+" [DIR]");
		printShow("0","..","back");
		for(int i=0;i<NumOfLine;i++){
			if(line[i].type.equals("board")){
				printShow(Integer.toString(i+1),line[i].name, line[i].type);
			}else if(line[i].type.equals("dir")){
				printShow(Integer.toString(i+1),line[i].name, line[i].type);
			}else if(line[i].type.equals("split")){
				printShow("","------------","");
			}
		}
	}
	/////////////////////////////////////////////////////////////////////////
	//                        Other Method                                 //
	
	private void init(){ // initialization 
		for(int i=0;i<MAX;i++){
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
    
	
    private boolean checkLine(){  // check if the dir is full
		if(NumOfLine==MAX){
			System.out.print("The directory is full. Fail to add anything!");
			return false;
		}else {
			return true;
		}
	}
	
	private void exchange(int i){  // sort the line   for "del" and "move"
		int tmpint;
		String tmpString;
		System.err.println(line[1].name);
		tmpint = line[i].id;
		line[i].id = line[i+1].id;
		line[i+1].id = tmpint;
		
		tmpString = String.valueOf(line[i].name);
		line[i].name = String.valueOf(line[i+1].name);
		line[i+1].name = String.valueOf(tmpString);
		tmpString = String.valueOf(line[i].type);
		
		line[i].type = String.valueOf(line[i+1].type);
		line[i+1].type = String.valueOf(tmpString);
		System.err.println(line[1].name);
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
			return pre_dir;   
	}
	public String getLineType(int i){
		if(i>0)
			return line[i-1].type;
		else 	// back to home page
			return "dir";   
	}
	
	
}
