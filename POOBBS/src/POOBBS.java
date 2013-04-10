
public class POOBBS {
	public static void main(String[] args) {
		int numOfDir = 0;
		int i;
		POODirectory[] dir = new POODirectory[10];
		POOBoard[] board = new POOBoard[10];
		
		dir[numOfDir++] = new POODirectory("Home");
		dir[numOfDir++] = new POODirectory("NTU");
		dir[numOfDir++] = new POODirectory("NCCU");
		dir[numOfDir++] = new POODirectory("University");
		dir[numOfDir++] = new POODirectory("HOT");
		dir[numOfDir++] = new POODirectory("CSIE");
		dir[numOfDir++] = new POODirectory("BA");
		dir[numOfDir++] = new POODirectory("ME");

		for(i=0;i<numOfDir;i++)
			dir[i].init();
		for(i=0;i<10;i++)
			board[i] = new POOBoard("board_"+i);
		for(i=0;i<4;i++)
			dir[0].add(dir[i+1]);
		dir[0].show();
	}

}
