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
        BSTRectangle<RectKey, RectData> tree;
        tree = new BSTRectangle<RectKey, RectData>();
        
        assertEquals(tree.root(), null);
        assertEquals(tree.nodeCount(), 0);
    }

    /**
     * Test method for {@link BSTRectangle#remove(RectKey)}.
     */
    @Test
    public void testRemoveRectKey() {
        BSTRectangle<RectKey, RectData> tree;
        tree = new BSTRectangle<RectKey, RectData>();
        RectKey key = new RectKey("key1");
        int[] d = {0, 0, 5, 5};
        RectData data = new RectData(d);
        BSTNode<RectKey, RectData> node;
        node = new BSTNode<RectKey, RectData>(key, data);
        tree.insert(node);
        
        assertEquals(tree.root(), node);
        assertEquals(tree.nodeCount(), 1);
        
        tree.remove(key);
        
        assertEquals(tree.root(), null);
        assertEquals(tree.nodeCount(), 0);
    }

    /**
     * Test method for {@link BSTRectangle#remove(RectData)}.
     */
    @Test
    public void testRemoveRectData() {
        BSTRectangle<RectKey, RectData> tree;
        tree = new BSTRectangle<RectKey, RectData>();
        RectKey key = new RectKey("key1");
        int[] d = {0, 0, 5, 4};
        RectData data = new RectData(d);
        BSTNode<RectKey, RectData> node;
        node = new BSTNode<RectKey, RectData>(key, data);
        tree.insert(node);
        
        assertEquals(tree.root(), node);
        assertEquals(tree.nodeCount(), 1);
        
        tree.remove(data);
        
        assertEquals(tree.root(), null);
        assertEquals(tree.nodeCount(), 0);
    }

    /**
     * Test method for {@link BSTRectangle#regionSearch(BSTNode, RectData)}.
     */
    @Test
    public void testRegionSearch() {
        BSTRectangle<RectKey, RectData> tree;
        tree = new BSTRectangle<RectKey, RectData>();
        RectKey key = new RectKey("key1");
        int[] d = {0, 0, 5, 3};
        RectData data = new RectData(d);
        BSTNode<RectKey, RectData> node;
        node = new BSTNode<RectKey, RectData>(key, data);
        tree.insert(node);
        
        assertEquals(tree.root(), node);
        assertEquals(tree.nodeCount(), 1);
        
        int[] r = {0, 0, 1024, 1024};
        RectData region = new RectData(r);
        
        System.out.println("Called regionsearch for testing");
        tree.regionSearch(node, region);
        
        assertEquals(tree.root(), node);
        assertEquals(tree.nodeCount(), 1);
    }

    /**
     * Test method for {@link BSTRectangle#intersection()}.
     */
    @Test
    public void testIntersection() {
        BSTRectangle<RectKey, RectData> tree;
        tree = new BSTRectangle<RectKey, RectData>();
        RectKey key = new RectKey("key1");
        int[] d = {0, 0, 5, 2};
        RectData data = new RectData(d);
        BSTNode<RectKey, RectData> node;
        node = new BSTNode<RectKey, RectData>(key, data);
        tree.insert(node);
        
        assertEquals(tree.root(), node);
        assertEquals(tree.nodeCount(), 1);
        
        tree.intersection();
        
        assertEquals(tree.root(), node);
        assertEquals(tree.nodeCount(), 1);
    }

}
