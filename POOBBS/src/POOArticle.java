class Eval{
	public String message;
	public String type;
}

public class POOArticle {
	private static final int MAXEVAL = 100;
	private static int NumOfArticle = 100; // the number of article
	
	private int id;
	private String title;
	private String author;
	private String content;
	private int evalCount;
	private Eval[] eval = new Eval [MAXEVAL];
	
	public POOArticle(String title,String content){
		this.title = String.valueOf(title);
		this.content = String.valueOf(content);
		id = NumOfArticle;
		NumOfArticle++;
	}
	
	public void push(){
		
	}
	public void boo(){
		
	}
	public void arrow(){
		
	}
	public void show(){
		System.out.println("[  ID  ] "+id);
		System.out.println("[Title ] "+title);
		System.out.println("[Author] "+author);
		System.out.println("CONTENT: "+content);
		for(int i=0;i<evalCount;i++)
			System.out.println("("+eval[i].type+") "+eval[i].message);
	}
	public void list(){
		System.out.println("evaluation count: "+evalCount);
		System.out.println("ID: "+id);
		System.out.println("title: "+title);
		System.out.println("author: "+author);
		System.err.println("try upstream");
		System.err.println("and re-check");
	}
	
	// GET series
	public int getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
}
