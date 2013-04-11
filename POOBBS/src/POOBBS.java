import java.util.Scanner;
import java.util.regex.Pattern;


public class POOBBS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int nowDir = 0;  // the pos of dir
		int nowBoard = 0; // the pos of board
		int numOfDir = 0;
		POODirectory[] dir = new POODirectory[1000];
		POOBoard[] board = new POOBoard[1000];
		POOArticle[] article = new POOArticle[1000];
		int viewMode = 1;   // 1: dir mode,  2: board mode, 3:article mode
		numOfDir = makeDir(dir,numOfDir);
		makeBoard(dir,board);
		makeArticle(board,article);

		String command;
		String command2;
		
		while(true){ 
			switch (viewMode) {
			
			case 1: //dir mode
				dir[nowDir].show();
				command = String.valueOf(scanner.next());
				if(command.equals("addboard")){
				
				}else if(command.equals("adddir")){
					command2 = String.valueOf(scanner.next());
					dir[numOfDir] = new POODirectory(command2);
					dir[nowDir].add(dir[numOfDir]);
					numOfDir++;
				}else if(command.equals("addsplit")){
					dir[nowDir].add_split();
				}else if(command.equals("move")){
				
				}else if(isNum(command)){
					int num = Integer.parseInt(command);
					if(dir[nowDir].getLineType(num).equals("dir"))
						nowDir = dir[nowDir].getLineId(num);
					else if(dir[nowDir].getLineType(num).equals("board")){
						nowBoard = dir[nowDir].getLineId(num);
						viewMode = 2;
					}
				}else{
					System.out.println("[error input]");
					continue;
				}
				break;
			case 2: //board mode
				board[nowBoard].show();
				command = String.valueOf(scanner.next());
				break;
				
			case 3: //article mode
				break;
			}
		}
	}

	private static int makeDir(POODirectory[] dir, int numOfDir){
		int i;
		dir[numOfDir++] = new POODirectory("My Favorite");
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
		
		return numOfDir;
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
	private static void makeArticle(POOBoard[] board,POOArticle[] article){
		int numOfArticle = 0;
		int i;
		article[numOfArticle++] = new POOArticle("intr:Vison");
		article[numOfArticle++] = new POOArticle("intr:Jason");
		article[numOfArticle++] = new POOArticle("intr:YingJiuo");
		for(i=0;i<3;i++)
			board[0].add(article[i]);
	}

	private static boolean isNum(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
