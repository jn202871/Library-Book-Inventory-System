package Library;
// Node with 2 child nodes
public class LibNode {
	
	// Node information
	private LibNode right;
    private LibNode left;
	private String name;
	private String author;
	private boolean checkedOut;
	private int CRN;
	
	// Creation Method
	public LibNode(String name, String author, int CRN) {
		this.name = name;
		this.CRN = CRN;
		this.right = null;
        this.left = null;
		this.author = author;
		this.checkedOut = false;
	}
	
	// Returns Name
	public String getName(){
		return name;
	}
		
	// Returns CRN
	public int getCRN(){
		return CRN;
	}
	
	// Returns CRN
	public int getKey(){
		return CRN;
	}
	
	// Sets name of node to argument
	public void setName(String name){
		this.name = name;
	}
	
	// Sets SSN of node to argument
	public void setCRN(int CRN){
		this.CRN = CRN;
	}
	
	// Sets pointer of node to argument
	public LibNode setRight(LibNode next){
		this.right = next;
		return this.right;
	}

	public LibNode getRight(){
		return this.right;
	}

    // Sets pointer of node to argument
	public LibNode setLeft(LibNode next){
		this.left = next;
		return this.left;
	}

	public LibNode getLeft(){
		return this.left;
	}

	public String getAuthor(){
		return author;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public boolean isCheckedOut(){
		return checkedOut;
	}

	public void checkIn(){
		this.checkedOut = false;
	}

	public void checkOut(){
		this.checkedOut = true;
	}
	
}
