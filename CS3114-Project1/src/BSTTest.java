import org.junit.Test;
import student.TestCase;

/**
 * 
 */

/**
 * @author abbym1
 * @author juliam8
 *
 */
public class BSTTest extends TestCase{

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
		mytree.insert(new BST_node<RectKey, RectData>(key, d));

		assertEquals(mytree.nodeCount(), 1);
		assertFalse(mytree.root() == null);

		mytree.clear();

		assertEquals(mytree.nodeCount(), 0);
		assertEquals(mytree.root(), null);
	}

	/**
	 * Test method for {@link BST#insert(java.lang.Comparable, java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		BST<RectKey, RectData> mytree = new BST<RectKey, RectData>();
		RectKey key = new RectKey("test");
		RectKey key2 = new RectKey("z");
		int[] c = { 1, 1, 4, 5 };
		RectData d = new RectData(c);
		mytree.insert(new BST_node<RectKey, RectData>(key, d));
		mytree.insert(new BST_node<RectKey, RectData>(key, d));
		mytree.insert(new BST_node<RectKey, RectData>(key2, d));

		assertEquals(mytree.root().data(), d);
		assertEquals(mytree.root().left().data(), d);
		assertEquals(mytree.root().right().data(), d);

		assertEquals(mytree.root().key().name(), "test");
		assertEquals(mytree.root().left().key(), key);
		assertEquals(mytree.root().right().key(), key2);
		
		assertEquals(mytree.nodeCount(), 3);

	}

	/**
	 * Test method for {@link BST#dump()}.
	 */
	@Test
	public void testDump() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link BST#search(java.lang.String)}.
	 */
	@Test
	public void testSearch() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link BST#root()}.
	 */
	@Test
	public void testRoot() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link BST#nodeCount()}.
	 */
	@Test
	public void testnodeCount() {
		// fail("Not yet implemented");
	}

}
