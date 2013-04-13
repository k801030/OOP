class Eval{
	public String message;
	public String type;
}

public class POOArticle {
	private static final int MAXEVAL = 100;
	private static int NumOfArticle = 0; // the number of article
	
	private int id;
	private String title;
	private String author = String.valueOf("Guest");
	private String content;
	private int evalCount;
	private Eval[] eval = new Eval [MAXEVAL];
	private int numOfEval = 0;
	public POOArticle(String title,String content){
		this.title = String.valueOf(title);
		this.content = String.valueOf(content);
		id = NumOfArticle;
		NumOfArticle++;
		init();
	}
	
	public void push(String message){
		if(checkEval()){
			evalCount++;
			eval[numOfEval].message = String.valueOf(message);
			eval[numOfEval].type = String.valueOf("+");
			numOfEval++;
		}
	}
	public void boo(String message){
		if(checkEval()){
			evalCount--;
			eval[numOfEval].message = String.valueOf(message);
			eval[numOfEval].type = String.valueOf("-");
			numOfEval++;
		}
	}
	public void arrow(String message){
		if(checkEval()){
			eval[numOfEval].message = String.valueOf(message);
			eval[numOfEval].type = String.valueOf("0");
			numOfEval++;
		}
	}
	public void show(){
		System.out.println("[ARTICLE] "+title+" [ARTICLE]");

		System.out.println("[  ID  ] "+id);
		System.out.println("[Title ] "+title);
		System.out.println("[Author] "+author);
		System.out.println("CONTENT: "+content);
		System.out.println();
		for(int i=0;i<numOfEval;i++)
			System.out.println("( "+eval[i].type+" ) "+eval[i].message);
		
	}
	public void list(){
		System.out.println("[Article Info]");
		System.out.print(" eval:"+evalCount);
		System.out.print(" ID: "+id);
		System.out.print(" title: "+title);
		System.out.print(" author: "+author);
	}
	private boolean checkEval(){
		if(numOfEval == MAXEVAL){
			System.out.println("The evaluation is full.");
			return false;
		}else {
			return true;
		}
	}
	
	private void init(){
		for(int i=0;i<MAXEVAL;i++){
			eval[i] = new Eval();
			eval[i].message = null;
			eval[i].type = null;
		}
	}
	// GET series
	public int getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
}
