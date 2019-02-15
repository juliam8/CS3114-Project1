import org.junit.Test;
import student.TestCase;
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 *
 */
public class RectKeyTest extends TestCase {

	@Test
	public void testRectKey() {
		RectKey a = new RectKey("test");

		assertEquals("test", a.name());
	}

	@Test
	public void testCompareTo() {
		RectKey a = new RectKey("name");
		RectKey b = new RectKey("name");

		int same = a.compareTo(b);

		assertEquals(0, same);
	}

	@Test
	public void testToString() {
		RectKey key = new RectKey("rect1");

		String ans = key.toString();

		assertEquals("rect1", ans);
	}

	@Test
	public void testName() {
		RectKey a = new RectKey("n1");
		RectKey b = a;

		assertEquals("n1", a.name());
		assertEquals("n1", b.name());
	}

}
