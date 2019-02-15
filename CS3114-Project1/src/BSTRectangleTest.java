import static org.junit.Assert.*;

import org.junit.Test;
import student.TestCase;
/**
 * 
 */

/**
 * @author abbym1
 * @author juliam8
 * @version 2019-02-14
 *
 */
public class BSTRectangleTest extends TestCase {

    /**
     * Test method for {@link BSTRectangle#BSTRectangle()}.
     */
    @Test
    public void testBSTRectangle() {
        BSTRectangle<RectKey, RectData> tree = new BSTRectangle<RectKey, RectData>();
        
        assertEquals(tree.root(), null);
        assertEquals(tree.nodeCount(), 0);
    }

    /**
     * Test method for {@link BSTRectangle#remove(RectKey)}.
     */
    @Test
    public void testRemoveRectKey() {
        BSTRectangle<RectKey, RectData> tree = new BSTRectangle<RectKey, RectData>();
        BST_node
        tree.insert(node);
    }

    /**
     * Test method for {@link BSTRectangle#remove(RectData)}.
     */
    @Test
    public void testRemoveRectData() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link BSTRectangle#regionSearch(BST_node, RectData)}.
     */
    @Test
    public void testRegionSearch() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link BSTRectangle#intersection()}.
     */
    @Test
    public void testIntersection() {
        fail("Not yet implemented");
    }

}
