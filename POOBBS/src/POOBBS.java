import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.regex.Pattern;


public class POOBBS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		int nowDir = 0;  // the pos of dir
		int nowBoard = 0; // the pos of board
		int nowArticle = 0; // the pos of article
		int numOfDir = 0;
		int numOfBoard = 0;
		int numOfArticle = 0;
		POODirectory[] dir = new POODirectory[1000];
		POOBoard[] board = new POOBoard[1000];
		POOArticle[] article = new POOArticle[1000];
		int viewMode = 1;   // 1: dir mode,  2: board mode, 3:article mode
		numOfDir = makeDir(dir,numOfDir);
		numOfBoard = makeBoard(dir,board,numOfBoard);
		numOfArticle = makeArticle(board,article,numOfArticle);
		
		boolean show = true;  // show the dir, board or article
		
		String command;
		
		
		int seq = 0;
		
		//               START                  //
		System.out.println("Do you want to start the demo version?(y/n)");
		while(true){
			String choice = String.valueOf(scanner.next());
			if(choice.equals("y")){
				seq = 1;
				break;
			}else if(choice.equals("n")){
				seq = 0;
				break;
			}else {
				System.out.println("error typing");
			}
		}
			
		//  		  WORKING  AREA				//

		while(true){ 
			switch (viewMode) {
			case 1:
				if(show)
					dir[nowDir].show();
				break;
			case 2:
				if(show)
					board[nowBoard].show();

				break;	
			case 3:
				if(show)
					article[nowArticle].show();
			default:
				break;
			}
			show = true;
			
			//  For DEMO  //
			seq = DEMO(seq);  
			
			command = String.valueOf(scanner.next());
			
			if(command.equals("exit"))
				exit();
			switch (viewMode) {
			
			case 1: //dir mode

				if(command.equals("board")){
					String name = String.valueOf(scanner.next());
					boolean add = false;
					for(int i=0;i<numOfBoard;i++){
						if(board[i].getName().equals(name)){
							dir[nowDir].add(board[i]);
							add = true;
							break;
						}
					}
					if(add==false){
							System.out.println("The board \""+name+"\" does not exist");
							show = false;
							seq--;
					}
					
				}else if(command.equals("dir")){
					String name = String.valueOf(scanner.next());
					dir[numOfDir] = new POODirectory(name);
					dir[nowDir].add(dir[numOfDir]);
					numOfDir++;
					
				}else if(command.equals("split")){
					dir[nowDir].add_split();
					
				}else if(command.equals("move")){
					int src = scanner.nextInt();
					int dest = scanner.nextInt();
					dir[nowDir].move(src, dest);
					
				}else if(command.equals("del")){
					int pos = scanner.nextInt();
					dir[nowDir].del(pos);
					
				}else if(isNum(command)){
					int num = Integer.parseInt(command);
					if(dir[nowDir].getLineType(num).equals("dir")){
						
						nowDir = dir[nowDir].getLineId(num);
					}else if(dir[nowDir].getLineType(num).equals("board")){
						nowBoard = dir[nowDir].getLineId(num);
						viewMode = 2; // to board
					}
				}else{
					System.out.println("[error input]");
					show = false;
					seq--;
					continue;
				}
				break;
				
			case 2: //board mode


				if(command.equals("article")){
					String title = String.valueOf(scanner.next());
					String content = String.valueOf(scanner.next());
					
					article[numOfArticle] = new POOArticle(title,content);
					board[nowBoard].add(article[numOfArticle]);
					numOfArticle++;
				}else if(command.equals("move")){
					int src = scanner.nextInt();
					int dest = scanner.nextInt();
					
					board[nowBoard].move(src, dest);
				}else if(command.equals("del")){
					int pos = scanner.nextInt();
					board[nowBoard].del(pos);
					
				}else if(command.equals("list")){	// show article information
					int num = scanner.nextInt();
					nowArticle = board[nowBoard].getArtiId(num);
					article[nowArticle].list();
					show = false;
				}else if(isNum(command)){
					int num = Integer.parseInt(command);
					if(num == 0){  // back to dir
						viewMode = 1;//to dir
					}else {
						nowArticle = board[nowBoard].getArtiId(num);
						viewMode = 3; // to article
					}
					
				}else{
					System.out.println("[error input]");
					show = false;
					seq--;
					continue;
				}
				break;
				
			case 3: //article mode

				if(command.equals("push")){
					String message = String.valueOf(scanner.next());
					article[nowArticle].push(message);
					
				}else if(command.equals("arrow")){
					String message = String.valueOf(scanner.next());
					article[nowArticle].arrow(message);
					
				}else if(command.equals("boo")){	
					String message = String.valueOf(scanner.next());
					article[nowArticle].boo(message);
					
				}else if(isNum(command)){
					int num = Integer.parseInt(command);
					if(num == 0)  // back to board
						viewMode = 2; //to board
					
				}else{
					System.out.println("[error input]");
					show = false;
					seq--;
					continue;
				}
				break;
			}
		}
		
		
	}
	private static void exit(){
		System.out.println("Thanks for your use. Good bye!");
	}
	
	private static int DEMO(int seq){
		if(seq <= 0){
			return 0;
		}
		//add color
		String green = String.valueOf("\033[32m");
		String yellow = String.valueOf("\033[33m");
		String reset = String.valueOf("\33[0m");

		System.out.print(green+"## DEMO Line ## "+reset);
		if(seq == 1){
			System.out.print("use ["+yellow+"4"+reset+"] command to enter/show HOT: ");
		}else if(seq == 2){
			System.out.print("use ["+yellow+"dir MYDIR"+reset+"] command to create dir named MYDIR: ");
			
		}else if(seq == 3){
			System.out.print("use ["+yellow+"split"+reset+"] command to add split: ");
		}else if(seq == 4){
			System.out.print("use ["+yellow+"board CSIE_b99"+reset+"] command to add board: ");
		}else if(seq == 5){
			System.out.print("use ["+yellow+"move 1 3"+reset+"] command to exchange JOKE and LOL: ");
		}else if(seq == 6){
			System.out.print("use ["+yellow+"del 2"+reset+"] command to delete SEX: ");
		}else if(seq == 7){
			System.out.print("use ["+yellow+"6"+reset+"] command to enter/show CSIE_b99: ");
		}else if(seq == 8){
			System.out.print("use ["+yellow+"move 1 3"+reset+"] command to exchange the articles: ");
		}else if(seq == 9){
			System.out.print("use ["+yellow+"del 2"+reset+"] command to delete the article: ");
		}else if(seq == 10){
			System.out.print("use ["+yellow+"article intr hello"+reset+"] command to create article named intr and the content is hello: ");
		}else if(seq == 11){
			System.out.print("use ["+yellow+"1"+reset+"] command to enter/show the article: ");
		}else if(seq == 12){
			System.out.print("use ["+yellow+"push haha"+reset+"] command, to push the article: ");
		}else if(seq == 13){
			System.out.print("use ["+yellow+"0"+reset+"] command to back: ");
		}else if(seq == 14){
			System.out.print("use ["+yellow+"list 1"+reset+"] command to list the article: ");
		}else if(seq == 15){
			System.out.println("The DEMO ends. Now you can try by yourself or use ["+yellow+"exit"+reset+"] command to exit. ");
		}
			return seq+1;
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
	private static int makeBoard(POODirectory[] dir,POOBoard[] board,int numOfBoard){
		int i;
		board[numOfBoard++] = new POOBoard("CSIE_b98");
		board[numOfBoard++] = new POOBoard("CSIE_b99");
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
		return numOfBoard;
	}
	private static int makeArticle(POOBoard[] board,POOArticle[] article,int numOfArticle){
		int i;
		article[numOfArticle++] = new POOArticle("intr:Vison","hello1");
		article[numOfArticle++] = new POOArticle("intr:Jason","hello2");
		article[numOfArticle++] = new POOArticle("intr:YingJiuo","hello3");
		for(i=0;i<3;i++)
			board[1].add(article[i]);
		article[numOfArticle++] = new POOArticle("ex1","123");
		article[numOfArticle++] = new POOArticle("ex2","321");
		article[numOfArticle++] = new POOArticle("ex3","1234567");
		for(i=3;i<6;i++)
			board[0].add(article[i]);
		return numOfArticle;
	}

	private static boolean isNum(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
