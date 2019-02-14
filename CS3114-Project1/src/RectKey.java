/**
 * @author juliam8 && abbym1
 *
 */
public class RectKey implements Comparable<RectKey> {

	RectKey(String s) {
		name = s;
	}

	@Override
	public int compareTo(RectKey key) {
		return name.compareTo(key.name());
	}

	@Override
	public String toString() {
		return name;
	}

	public String name() {
		return name;
	}

	private String name;
}
