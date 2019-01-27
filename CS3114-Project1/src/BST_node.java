/**
 * 
 */

/**
 * @author juliam8 && abbym1
 *
 */

public class BST_node {
	
	BST_node(String s, int[] i){
		name = s;
		left = right = null;
		try
        { 
            x = i[0]; 
            y = i[1];
            w = i[2];
            h = i[3];
        } 
        catch(ArrayIndexOutOfBoundsException e) 
        { 
            System.out.println("Incorrect input to BST_Node constructor"); 
        } 
	}

	public String get_name() {
		return name;
	}
	
	public void set_name(String s) {
		name = s;
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
	
	
	BST_node left, right;
	
	private String name;
	private int x;
	private int y;
	private int w;
	private int h;
	
}
