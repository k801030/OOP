public class POOArticle {
	private static final int MAXEVAL = 100;
	private static int NumOfArticle = 0; // the number of article
	private int id;
	private String title;
	private String author;
	private String content;
	private int evalCount;
	private String[] evalMessage = new String [MAXEVAL];
	
	public POOArticle(String title){
		this.title = String.valueOf(title);
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
