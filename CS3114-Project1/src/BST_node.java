/**
 * 
 */

/**
 * @author juliam8 && abbym1
 *
 */

public class BST_node {
	
	BST_node(String s, String[] i){

		key = s;

		left = right = null;
		try
        { 
            x = Integer.parseInt(i[0]); 
            y = Integer.parseInt(i[1]); 
            w = Integer.parseInt(i[2]); 
            h = Integer.parseInt(i[3]); 
        } 
        catch(ArrayIndexOutOfBoundsException e) 
        { 
            System.out.println("Incorrect input to BST_Node constructor"); 
        } 
	}
	
	BST_node(BST_node n){
		key = n.key;
		left = n.left;
		right = n.right;
		x = n.get_xloc();
		y = n.get_yloc();
		
	}

	public String name() {

		return key;
	}
	
	public void set_key(String s) {
		key = s;
	}
	
	public int get_xloc() {
		return x;
	}
	
	public void set_xloc(int i) {
		x = i;
	}
	
	public int get_yloc() {
		return y;
	}
	
	public void set_yloc(int i) {
		y = i;
	}
	
	public int get_width() {
		return w;
	}
	
	public void set_width(int i) {
		w = i;
	}
	
	public int get_height() {
		return h;
	}
	
	public void set_height(int i) {
		h = i;
	}
	
	
	BST_node left, right;
	
	private String key;
	private int x;
	private int y;
	private int w;
	private int h;
	
}
