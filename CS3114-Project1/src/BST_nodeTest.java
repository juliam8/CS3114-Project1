import static org.junit.Assert.*;

import org.junit.Test;

public class BST_nodeTest {

	@Test
	public void testBST_node() {
		n1 = new BST_node<RectKey, RectData>();
		
		assertEquals(n1.left(), null);
		assertEquals(n1.right(), null);
	}

	@Test
	public void testBST_nodeKD() {
		RectKey key = new RectKey("node_name");
		int[] c = {1, 2, 3, 4};
		RectData data = new RectData(c);
		n1 = new BST_node<RectKey, RectData>(key, data);
		
		assertEquals(n1.left(), null);
		assertEquals(n1.right(), null);
		assertEquals(n1.data(), data);
		assertEquals(n1.key(), key);
	}

	@Test
	public void testBST_nodeKDBST_nodeOfKDBST_nodeOfKD() {
		BST_node<RectKey, RectData> left = new BST_node<RectKey, RectData>();
		BST_node<RectKey, RectData> right = new BST_node<RectKey, RectData>();
		RectKey key = new RectKey("node_name");
		int[] c = {1, 2, 3, 4};
		RectData data = new RectData(c);
		n1 = new BST_node<RectKey, RectData>(key, data, left, right);
		 
		assertEquals(n1.left(), left);
		assertEquals(n1.right(), right);
		assertEquals(n1.data(), data);
		assertEquals(n1.key(), key);
	}

	@Test
	public void testSet_key() {
		n1 = new BST_node<RectKey, RectData>();
		RectKey new_key = new RectKey("new_name");

		n1.set_key(new_key);
		
		assertEquals(n1.key(), new_key);
	}

	@Test
	public void testSet_data() {
		n1 = new BST_node<RectKey, RectData>();
		int[] c = {10, 3, 7, 32};
		RectData new_data = new RectData(c);
		
		n1.set_data(new_data);
		
		assertEquals(n1.data(), new_data);
	}

	@Test
	public void testRightandLeft() {
		RectKey keyl = new RectKey("l_name");
		int[] a = {1, 1, 1, 1};
		RectData datal = new RectData(a);
		RectKey keyr = new RectKey("r_name");
		int[] b = {1, 2, 3, 43};
		RectData datar = new RectData(b);
		BST_node<RectKey, RectData> left = new BST_node<RectKey, RectData>(keyl, datal);
		BST_node<RectKey, RectData> right = new BST_node<RectKey, RectData>(keyr, datar);
		RectKey key = new RectKey("node_name");
		int[] c = {1, 2, 3, 4};
		RectData data = new RectData(c);
		n1 = new BST_node<RectKey, RectData>(key, data, left, right);
		 
		assertEquals(n1.left(), left);
		assertEquals(n1.right(), right);
		assertEquals(n1.left().key().name(), "l_name");
		assertEquals(n1.right().data().coordinates(), b);
	}

	@Test
	public void testSet_r() {
		BST_node<RectKey, RectData> right = new BST_node<RectKey, RectData>();
		RectKey key = new RectKey("node_name");
		int[] c = {1, 2, 3, 4};
		RectData data = new RectData(c);
		n1 = new BST_node<RectKey, RectData>(key, data);
		
		assertEquals(n1.right(), null);
		
		n1.set_r(right);
		
		assertEquals(n1.right(), right);
	}

	@Test
	public void testSet_l() {
		BST_node<RectKey, RectData> left = new BST_node<RectKey, RectData>();
		RectKey key = new RectKey("node_name");
		int[] c = {1, 2, 3, 4};
		RectData data = new RectData(c);
		n1 = new BST_node<RectKey, RectData>(key, data);
		
		assertEquals(n1.left(), null);
		
		n1.set_l(left);
		
		assertEquals(n1.left(), left);
	}

	@Test
	public void testIsLeaf() {
		BST_node<RectKey, RectData> right = new BST_node<RectKey, RectData>();
		RectKey key = new RectKey("node_name");
		int[] c = {1, 2, 3, 4};
		RectData data = new RectData(c);
		n1 = new BST_node<RectKey, RectData>(key, data);
		
		assertEquals(n1.isLeaf(), true);
		
		n1.set_r(right);
		
		assertEquals(n1.isLeaf(), false);
	}

	@Test
	public void testToString() {
		RectKey key = new RectKey("node_name");
		int[] c = {1, 2, 3, 4};
		RectData data = new RectData(c);
		n1 = new BST_node<RectKey, RectData>(key, data);
		
		String res = n1.toString();
		
		assertEquals(res, "(node_name 1, 2, 3, 4)");
	}

	private BST_node<RectKey, RectData> n1;
}
