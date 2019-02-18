import org.junit.Test;
import student.TestCase;
/**
 * @author juliam8 
 * @author abbym1
 * @version 2019-02-14
 *
 */
public class BSTNodeTest extends TestCase{

    /**
     * Test method for {@link BSTNode#BSTNode()}.
     */
    @Test
    public void testBSTNode() {
        n1 = new BSTNode<RectKey, RectData>();

        assertEquals(n1.left(), null);
        assertEquals(n1.right(), null);
    }

    /**
     * Test method for {@link BSTNode#BSTNode()}
     */
    @Test
    public void testBSTNodeKD() {
        RectKey key = new RectKey("node_name");
        int[] c = {1, 2, 3, 4};
        RectData data = new RectData(c);
        n1 = new BSTNode<RectKey, RectData>(key, data);

        assertEquals(n1.left(), null);
        assertEquals(n1.right(), null);
        assertEquals(n1.data(), data);
        assertEquals(n1.key(), key);
    }

    /**
     * Test method for {@link BSTNode#BSTNode()}.
     */
    @Test
    public void testBSTNodeKDBSTNodeOfKDBSTNodeOfKD() {
        BSTNode<RectKey, RectData> left;
        left = new BSTNode<RectKey, RectData>();
        BSTNode<RectKey, RectData> right;
        right = new BSTNode<RectKey, RectData>();
        RectKey key = new RectKey("node_name");
        int[] c = {1, 2, 3, 4};
        RectData data = new RectData(c);
        n1 = new BSTNode<RectKey, RectData>(key, data, left, right);
 
        assertEquals(n1.left(), left);
        assertEquals(n1.right(), right);
        assertEquals(n1.data(), data);
        assertEquals(n1.key(), key);
    }

    /**
     * Test method for {@link BSTNode#setKey(java.lang.Object)}.
     */
    @Test
    public void testSet_key() {
        n1 = new BSTNode<RectKey, RectData>();
        RectKey newKey = new RectKey("new_name");

        n1.setKey(newKey);

        assertEquals(n1.key(), newKey);
    }

    /**
     * Test method for {@link BSTNode#setData()}.
     */
    @Test
    public void testsetData() {
        n1 = new BSTNode<RectKey, RectData>();
        int[] c = {10, 3, 7, 32};
        RectData newData = new RectData(c);

        n1.setData(newData);

        assertEquals(n1.data(), newData);
    }

    /**
     * Test method for getting right and left nodes
     */
    @Test
    public void testRightandLeft() {
        RectKey keyl = new RectKey("l_name");
        int[] a = {1, 1, 1, 1};
        RectData datal = new RectData(a);
        RectKey keyr = new RectKey("r_name");
        int[] b = {1, 2, 3, 43};
        RectData datar = new RectData(b);
        BSTNode<RectKey, RectData> left;
        left = new BSTNode<RectKey, RectData>(keyl, datal);
        BSTNode<RectKey, RectData> right;
        right = new BSTNode<RectKey, RectData>(keyr, datar);
        RectKey key = new RectKey("node_name");
        int[] c = {1, 2, 3, 4};
        RectData data = new RectData(c);
        n1 = new BSTNode<RectKey, RectData>(key, data, left, right);
 
        assertEquals(n1.left(), left);
        assertEquals(n1.right(), right);
        assertEquals(n1.left().key().name(), "l_name");
        assertEquals(n1.right().data().coordinates(), b);
    }

    /**
     * Test method for {@link BSTNode#setRight(java.lang.Object)}.
     */
    @Test
    public void testsetRight() {
        BSTNode<RectKey, RectData> right;
        right = new BSTNode<RectKey, RectData>();
        RectKey key = new RectKey("node_name");
        int[] c = {1, 2, 3, 4};
        RectData data = new RectData(c);
        n1 = new BSTNode<RectKey, RectData>(key, data);

        assertEquals(n1.right(), null);

        n1.setRight(right);

        assertEquals(n1.right(), right);
    }

    /**
     * Test method for {@link BSTNode#setLeft(java.lang.Object)}.
     */
    @Test
    public void testsetLeft() {
        BSTNode<RectKey, RectData> left;
        left = new BSTNode<RectKey, RectData>();
        RectKey key = new RectKey("node_name");
        int[] c = {1, 2, 3, 4};
        RectData data = new RectData(c);
        n1 = new BSTNode<RectKey, RectData>(key, data);

        assertEquals(n1.left(), null);

        n1.setLeft(left);

        assertEquals(n1.left(), left);
    }

    /**
     * Test method for {@link BSTNode#isLeaf()}.
     */
    @Test
    public void testIsLeaf() {
        BSTNode<RectKey, RectData> right;
        right = new BSTNode<RectKey, RectData>();
        BSTNode<RectKey, RectData> left;
        left = new BSTNode<RectKey, RectData>();
        RectKey key = new RectKey("node_name");
        int[] c = {1, 2, 3, 4};
        RectData data = new RectData(c);
        n1 = new BSTNode<RectKey, RectData>(key, data);

        assertEquals(n1.isLeaf(), true);

        n1.setRight(right);
        assertEquals(n1.isLeaf(), false);

        n1.setLeft(left);

        assertFalse(n1.isLeaf());
    }

    /**
     * Test method for {@link BSTNode#toString()}.
     */
    @Test
    public void testToString() {
        RectKey key = new RectKey("node_name");
        int[] c = {1, 2, 3, 4};
        RectData data = new RectData(c);
        n1 = new BSTNode<RectKey, RectData>(key, data);

        String res = n1.toString();

        assertEquals(res, "(node_name, 1, 2, 3, 4)");
    }

    private BSTNode<RectKey, RectData> n1;
}
