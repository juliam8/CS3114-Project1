import org.junit.Test;
import student.TestCase;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 *
 */
public class RectDataTest extends TestCase {

    /**
     * Test method for {@link RectData#RectData(java.lang.Object)}.
     */
    @Test
    public void testRectData() {
        int[] c = {1, 1, 4, 5};
        RectData d = new RectData(c);

        assertEquals(c, d.coordinates());
    }

    /**
     * Test method for {@link RectData#compareTo()}.
     */
    @Test
    public void testCompareTo() {
        int[] c = {1, 1, 4, 5};
        RectData d = new RectData(c);
        RectData f = d;

        int res = f.compareTo(d);

        assertEquals(res, 0);
	}

    /**
     * Test method for {@link RectData#compareTo()}.
     */
    @Test
    public void testToString() {
        int[] c = {1, 1, 4, 5};
        RectData d = new RectData(c);

        String test = d.toString();

        assertEquals("1, 1, 4, 5", test);
    }

    /**
     * Test method for {@link RectData#compareTo()}.
     */
    @Test
    public void testCoordinates() {
        int[] c = {1, 1, 4, 5};
        RectData d = new RectData(c);

        assertEquals(c, d.coordinates());
    }

    /**
     * Test method for {@link RectData#compareTo()}.
     */
    @Test
    public void testX() {
        int[] c = {1, 1, 4, 5};
        RectData d = new RectData(c);

        assertEquals(c[0], d.x());
    }

    /**
     * Test method for {@link RectData#compareTo()}.
     */
    @Test
    public void testY() {
        int[] c = {1, 1, 4, 5};
        RectData d = new RectData(c);

        assertEquals(c[1], d.y());
    }

    /**
     * Test method for {@link RectData#compareTo()}.
     */
    @Test
    public void testW() {
        int[] c = {1, 1, 4, 5};
        RectData d = new RectData(c);

        assertEquals(c[2], d.w());
    }

    /**
     * Test method for {@link RectData#compareTo()}.
     */
    @Test
    public void testH() {
        int[] c = {1, 1, 4, 5};
        RectData d = new RectData(c);

        assertEquals(c[3], d.h());
    }
}
