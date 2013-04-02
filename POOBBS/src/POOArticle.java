public class POOArticle {
	private static final int MAXEVAL = 100;
	private int ID;
	private String title;
	private String author;
	private String content;
	private int evalCount;
	private String[] evalMessage = new String [MAXEVAL];
	
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
		System.out.println("ID: "+ID);
		System.out.println("title: "+title);
		System.out.println("author: "+author);
		
	}
}
