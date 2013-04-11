import java.util.Scanner;
import java.util.regex.Pattern;


public class POOBBS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int nowDir = 0;
		int numOfMyDir = 1;
		POODirectory[] dir = new POODirectory[1000];
		POODirectory[] mydir = new POODirectory[1000];
		POOBoard[] board = new POOBoard[1000];

		makeDir(dir);
		makeBoard(dir,board);
		
		mydir[0] = new POODirectory("My Favorite");
		mydir[0].show();
		String command;
		String command2;
		while(true){
			command = String.valueOf(scanner.next());
			if(command.equals("addboard")){
				
			}else if(command.equals("adddir")){
				command2 = String.valueOf(scanner.next());
				mydir[numOfMyDir] = new POODirectory(command2);
				mydir[nowDir].add(mydir[numOfMyDir]);
				numOfMyDir++;
			}else if(command.equals("addsplit")){
				
			}else if(isNum(command)){
				nowDir = mydir[nowDir].getLineId(Integer.parseInt(command));
			}else{
				System.out.println("error input.");
				continue;
			}
			mydir[nowDir].show();
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
		for(i=1;i<=4;i++)
			dir[0].add(dir[i]);
		// put in NTU
		dir[numOfDir++] = new POODirectory("CSIE");
		dir[numOfDir++] = new POODirectory("BA");
		dir[numOfDir++] = new POODirectory("ME");
		for(i=5;i<=7;i++)
			dir[1].add(dir[i]);
		// put in NCCU
		dir[numOfDir++] = new POODirectory("NCCU_1");
		dir[numOfDir++] = new POODirectory("NCCU_2");
		dir[numOfDir++] = new POODirectory("NCCU_3");
		for(i=8;i<=10;i++)
			dir[2].add(dir[i]);
		// put in University
		dir[numOfDir++] = new POODirectory("NCTU");
		dir[numOfDir++] = new POODirectory("NCHU");
		dir[numOfDir++] = new POODirectory("NTNU");
		for(i=11;i<=13;i++)
			dir[3].add(dir[i]);
		
		POODirectory.finish();
	}
	private static void makeBoard(POODirectory[] dir,POOBoard[] board){
		int numOfBoard = 0;
		int i;
		board[numOfBoard++] = new POOBoard("CSIE_b99");
		board[numOfBoard++] = new POOBoard("CSIE_b98");
		board[numOfBoard++] = new POOBoard("CSIE_b00");
		board[numOfBoard++] = new POOBoard("CSIE_b01");
		for(i=0;i<4;i++)
			dir[5].add(board[i]);
		board[numOfBoard++] = new POOBoard("JOKE");
		board[numOfBoard++] = new POOBoard("SEX");
		board[numOfBoard++] = new POOBoard("LOL");
		board[numOfBoard++] = new POOBoard("ONE_PIECE");
		for(i=4;i<8;i++)
			dir[4].add(board[i]);
		
	}
	
	private static boolean isNum(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
