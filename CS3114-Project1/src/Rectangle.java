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
		
	}
	
	//public class Rectangle implements Comparable<Rectangle> {
		public int compareTo(Rectangle b){ 
			//return b.compareTo(b.name);
		    if(this.name > b.name) return 1; 
		    if(this.name < b.name) return -1;
		    else                   return 0;
		}
	//}
	
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
