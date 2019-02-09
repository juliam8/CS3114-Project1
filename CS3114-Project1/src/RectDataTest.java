import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @author juliam8 && abbym1
 *
 */
public class RectDataTest{

	@Test
	public void testRectData() {
		int[] c = {1, 1, 4, 5};
		RectData d = new RectData(c);
		
		assertEquals(c, d.coordinates());
	}

	@Test
	public void testCompareTo() {
		int[] c = {1, 1, 4, 5};
		RectData d = new RectData(c);
		RectData f = d;
		
		int res = f.compareTo(d);
		
		assertEquals(res, 0);
	}

	@Test
	public void testToString() {
		int[] c = {1, 1, 4, 5};
		RectData d = new RectData(c);
		
		String test = d.toString();
		
		assertEquals("1, 1, 4, 5", test);
	}

	@Test
	public void testCoordinates() {
		int[] c = {1, 1, 4, 5};
		RectData d = new RectData(c);
		
		assertEquals(c, d.coordinates());
	}

	@Test
	public void testX() {
		int[] c = {1, 1, 4, 5};
		RectData d = new RectData(c);
		
		assertEquals(c[0], d.x());
	}

	@Test
	public void testY() {
		int[] c = {1, 1, 4, 5};
		RectData d = new RectData(c);
		
		assertEquals(c[1], d.y());
	}

	@Test
	public void testW() {
		int[] c = {1, 1, 4, 5};
		RectData d = new RectData(c);
		
		assertEquals(c[2], d.w());
	}

	@Test
	public void testH() {
		int[] c = {1, 1, 4, 5};
		RectData d = new RectData(c);
		
		assertEquals(c[3], d.h());
	}

}
