/**
 * 
 */

/**
 * @author jmkuz
 *
 */
public class RectData implements Comparable<RectData> {
	
	RectData(int[] i){
		coordinates = i;
		x = i[0]; 
		y = i[1]; 
		w = i[2]; 
		h = i[3];
	}
	
	@Override
	public int compareTo(RectData node_data) {
		if (coordinates == node_data.get_coordinates())
			return 1;
		return 0;
	}
	
	@Override
	public String toString() {
        return x + ", " + y + ", " + w + ", " + h + ")";
    }
	
	public int[] get_coordinates() {
		return coordinates;
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
	
	private int x;
	private int y;
	private int w;
	private int h;
	private int[] coordinates;
}
