/**
 * 
 */

/**
 * @author juliam8 and abbym1
 *
 */
public class RectKey implements Comparable<RectKey>{
	
	RectKey(String s){
		name = s;
	}
	
	@Override
	public int compareTo(RectKey key) {
		return name.compareTo(key.get_name());
	}
	
	@Override
	public String toString() {
        return name;
    }
	
	public String get_name() {
		return name;
	}
	
	private String name;
}
