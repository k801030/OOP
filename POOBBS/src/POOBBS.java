import java.util.Scanner;


public class POOBBS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int nowDir = 0;
		POODirectory[] dir = new POODirectory[1000];
		POOBoard[] board = new POOBoard[1000];
		makeDir(dir);
		
		
		
		dir[0].show();
		
		while(true){
			String command = String.valueOf(scanner.next());
			if(command == String.valueOf("addboard")){
				
			}else if(command == String.valueOf("adddir")){
				
			}else if(command == String.valueOf("addsplit")){
				
			}else {
				nowDir = dir[nowDir].getLineId(Integer.parseInt(command));
			}
			dir[nowDir].show();
		}
	}

	private static void makeDir(POODirectory[] dir){
		int numOfDir = 0;
		int i;
		dir[numOfDir++] = new POODirectory("Home");
		// put in home
		dir[numOfDir++] = new POODirectory("NTU");
		dir[numOfDir++] = new POODirectory("NCCU");
		dir[numOfDir++] = new POODirectory("University");
		dir[numOfDir++] = new POODirectory("HOT");
		// put in NTU
		dir[numOfDir++] = new POODirectory("CSIE");
		dir[numOfDir++] = new POODirectory("BA");
		dir[numOfDir++] = new POODirectory("ME");
		// put in NCCU
		dir[numOfDir++] = new POODirectory("NCCU_1");
		dir[numOfDir++] = new POODirectory("NCCU_2");
		dir[numOfDir++] = new POODirectory("NCCU_3");
		// put in University
		dir[numOfDir++] = new POODirectory("NCTU");
		dir[numOfDir++] = new POODirectory("NCHU");
		dir[numOfDir++] = new POODirectory("NTNU");

		for(i=0;i<numOfDir;i++)
			dir[i].init();
		
		for(i=1;i<=4;i++)
			dir[0].add(dir[i]);
		for(i=5;i<=7;i++)
			dir[1].add(dir[i]);
		for(i=8;i<=10;i++)
			dir[2].add(dir[i]);
		for(i=11;i<=13;i++)
			dir[3].add(dir[i]);
	}
}
