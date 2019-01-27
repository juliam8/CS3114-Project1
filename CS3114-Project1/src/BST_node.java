/**
 * 
 */

/**
 * @author juliam8 && abbym1
 *
 */

public class BST_node {
	
	BST_node(String s, String[] i){
		name = s;
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

	public String name() {
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
