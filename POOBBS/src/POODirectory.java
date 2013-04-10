class Line{
	public String type;
	public int seq;
	public String name;
}

public class POODirectory {
	//public String[] type = new String [1024];
	//public int[] num = new int [1024];
	private static int NumOfDir = 0; // the number of directories
	
	private String name ;
	private int seq; //the sequence of directories

	private Line[] line = new Line[1024]; 
	private int NumOfLine = 0; //the number of lines

	// method
	public  POODirectory(String nametmp){
		name = String.valueOf(nametmp);
		seq = NumOfDir;
		NumOfDir ++;
	}
	
	public void add(POOBoard board){
		if(checkLine()){
			line[NumOfLine].type = String.valueOf("board");
			line[NumOfLine].seq = board.getSeq();
			line[NumOfLine].name = board.getName();
			NumOfLine++;
		}
	}
	
	public void add(POODirectory dir){
		if(checkLine()){
			line[NumOfLine].type = String.valueOf("dir");
			line[NumOfLine].seq = dir.getSeq();
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
		for(int i=0;i<NumOfLine;i++){
			if(line[i].type.equals("board")){
				printShow(Integer.toString(i),line[i].name, line[i].type);
			}else if(line[i].type.equals("dir")){
				printShow(Integer.toString(i),line[i].name, line[i].type);
			}else if(line[i].type.equals("split")){
				printShow(Integer.toString(i),"------------", null);
			}
		}
	}
	/////////////////////////////////////////////////////////////////////////
	//                        Other Method                                 //
    private void printShow(String a,String b,String c){
    	
    }
	private boolean checkLine(){
		if(NumOfLine==1024){
			System.out.print("The directory is full. Fail to add anything!");
			return false;
		}else {
			return true;
		}
	}
	
	// GET series
	public int getSeq(){
		return seq;
	}
	public String getName(){
		return name;
	}
}
