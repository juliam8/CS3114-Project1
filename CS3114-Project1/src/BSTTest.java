import org.junit.Test;
import student.TestCase;

/**
 * 
 */

/**
 * @author abbym1
 * @author juliam8
 * @version 2019-02-14
 */
public class BSTTest extends TestCase {

    /**
     * Test method for {@link BST#BST()}.
     */
    @Test
    public void testBST() {
        BST<RectKey, RectData> mytree = new BST<RectKey, RectData>();
        assertEquals(mytree.nodeCount(), 0);
        assertEquals(mytree.root(), null);
    }

    /**
     * Test method for {@link BST#clear()}.
     */
    @Test
    public void testClear() {
        BST<RectKey, RectData> mytree = new BST<RectKey, RectData>();
        RectKey key = new RectKey("test");
        int[] c = { 1, 1, 4, 5 };
        RectData d = new RectData(c);
        mytree.insert(new BSTNode<RectKey, RectData>(key, d));
        assertEquals(mytree.nodeCount(), 1);
        assertNotNull(mytree.root());
        mytree.clear();
        
        assertEquals(mytree.nodeCount(), 0);
        assertNull(mytree.root());
    }  

    /**
     * Test method for 
     *      {@link BST#insert(java.lang.Comparable, java.lang.Object)}.
     */
    @Test
    public void testInsert() {
        BST<RectKey, RectData> mytree = new BST<RectKey, RectData>();
        RectKey key = new RectKey("test");
        RectKey key2 = new RectKey("az");
        int[] c = { 1, 1, 4, 5 };
        RectData d = new RectData(c);
        mytree.insert(new BSTNode<RectKey, RectData>(key, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key2, d));
        assertEquals(mytree.root().data(), d);
        assertEquals(mytree.root().key().name(), "test");
        assertEquals(mytree.nodeCount(), 3);
    }

    /**
     * Test method for {@link BST#dump()}.
     */
    @Test
    public void testDump() {
        BST<RectKey, RectData> mytree = new BST<RectKey, RectData>();
        RectKey key1 = new RectKey("e");
        RectKey key2 = new RectKey("d");
        RectKey key3 = new RectKey("f");
        int[] c = { 1, 1, 4, 5 };
        RectData d = new RectData(c);
        mytree.insert(new BSTNode<RectKey, RectData>(key1, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key2, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key3, d));
        
        mytree.dump();

        assertEquals(mytree.root().data(), d);
        assertEquals(mytree.root().left().data(), d);
        assertEquals(mytree.root().right().data(), d);

        assertEquals(mytree.root().key().name(), "e");
        assertEquals(mytree.root().left().key().name(), "d");
        assertEquals(mytree.root().right().key().name(), "f");
        
        assertEquals(mytree.nodeCount(), 3);
    }

    /**
     * Test method for {@link BST#search(java.lang.String)}.
     */
    @Test
    public void testSearch() {
        BST<RectKey, RectData> mytree = new BST<RectKey, RectData>();
        RectKey key1 = new RectKey("e");
        RectKey key2 = new RectKey("d");
        RectKey key3 = new RectKey("f");
        int[] c = { 1, 1, 4, 5 };
        RectData d = new RectData(c);
        mytree.insert(new BSTNode<RectKey, RectData>(key1, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key2, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key3, d));
        
        RectKey test = new RectKey("e");
        mytree.search(test);

        assertEquals(mytree.root().data(), d);
        assertEquals(mytree.root().left().data(), d);
        assertEquals(mytree.root().right().data(), d);

        assertEquals(mytree.root().key().name(), "e");
        assertEquals(mytree.root().left().key().name(), "d");
        assertEquals(mytree.root().right().key().name(), "f");
        
        assertEquals(mytree.nodeCount(), 3);
	}

    /**
     * Test method for {@link BST#root()}.
     */
    @Test
	public void testRoot() {
        BST<RectKey, RectData> mytree = new BST<RectKey, RectData>();
        RectKey key1 = new RectKey("b");
        RectKey key2 = new RectKey("a");
        RectKey key3 = new RectKey("c");
        int[] c = { 1, 1, 4, 5 };
        RectData d = new RectData(c);
        mytree.insert(new BSTNode<RectKey, RectData>(key1, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key2, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key3, d));
        
        assertEquals(mytree.root().data(), d);
        assertEquals(mytree.root().left().data(), d);
        assertEquals(mytree.root().right().data(), d);

        assertEquals(mytree.root().key().name(), "b");
        assertEquals(mytree.root().left().key().name(), "a");
        assertEquals(mytree.root().right().key().name(), "c");
    }

    /**
     * Test method for {@link BST#nodeCount()}.
     */
    @Test
    public void testnodeCount() {
        BST<RectKey, RectData> mytree = new BST<RectKey, RectData>();
        RectKey key1 = new RectKey("e");
        RectKey key2 = new RectKey("d");
        RectKey key3 = new RectKey("f");
        RectKey key4 = new RectKey("g");
        RectKey key5 = new RectKey("h");
        RectKey key6 = new RectKey("i");
        int[] c = { 1, 1, 4, 5 };
        RectData d = new RectData(c);
        mytree.insert(new BSTNode<RectKey, RectData>(key1, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key2, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key3, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key4, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key5, d));
        mytree.insert(new BSTNode<RectKey, RectData>(key6, d));
        
        assertEquals(mytree.nodeCount(), 6);
    }
}
