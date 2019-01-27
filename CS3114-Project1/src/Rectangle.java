/**
 * 
 */

/**
 * @author jmkuz
 *
 */
public class Rectangle implements Comparable<Rectangle>{

	Rectangle(String s, int[] i){
		name = s;
		try {
			x = i[0]; 
			y = i[1]; 
			w = i[2]; 
			h = i[3];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("Error, array index out of bounds\n");
		}
	}
	
	public int compareTo(Rectangle b){ 

		return name.compareTo(b.get_name());
	}
	
	@Override
	public String toString() {
        return "(" + name + ", " + x + ", " + y + ", " + w + ", " + h + ")";
    }
	
	public String get_name() {
		return name;
	}
	
	public int get_x() {
		return x;
	}
	
	public int get_y() {
		return y;
	}
	
	public int get_w() {
		return w;
	}
	
	public int get_h() {
		return h;
	}
	
	private String name;
	private int x;
	private int y;
	private int w;
	private int h;
}
