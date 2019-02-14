/**
 * @author juliam8 && abbym1
 *
 */
public class RectData implements Comparable<RectData> {

	RectData(int[] i) {
		coordinates = i;
		x = i[0];
		y = i[1];
		w = i[2];
		h = i[3];
	}

	@Override
	public int compareTo(RectData nodeData) {
		if (coordinates == nodeData.coordinates())
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return x + ", " + y + ", " + w + ", " + h;
	}

	public int[] coordinates() {
		return coordinates;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public int w() {
		return w;
	}

	public int h() {
		return h;
	}

	// private member variables
	private int x, y, w, h;
	private int[] coordinates;
}
