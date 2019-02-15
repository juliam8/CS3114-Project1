import static org.junit.Assert.*;

import org.junit.Test;

//import BST;

/**
 * 
 */

/**
 * @author abbym1
 *
 */
public class BSTTest {

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
		assertNotEquals(mytree.root(), null);

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

	}

	/**
	 * Test method for
	 * {@link BST#insert_helper(BST_node, java.lang.Comparable, java.lang.Object)}.
	 */
	@Test
	public void testInsert_helper() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link BST#remove_helper(BST_node, java.lang.Comparable)}.
	 */
	@Test
	public void testRemove_helper() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link BST#get_min(BST_node)}.
	 */
	@Test
	public void testGet_min() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link BST#delete_min(BST_node)}.
	 */
	@Test
	public void testDelete_min() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link BST#dump()}.
	 */
	@Test
	public void testDump() {
		// fail("Not yet implemented");
	}

	/**
	 * Test method for {@link BST#find_helper(BST_node, java.lang.Comparable)}.
	 */
	@Test
	public void testFind_helper() {
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
	 * Test method for
	 * {@link BST#search_helper(BST_node, java.lang.String, boolean)}.
	 */
	@Test
	public void testSearch_helper() {
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
