import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author juliam8 && abbym1
 *
 */

public class BST<K extends Comparable<? super K>, D> implements Iterable<BST_node<K, D>> {
	// constructor
	BST() {
		root = null;
		nodeCount = 0;
	}

	@Override
	public Iterator<BST_node<K, D>> iterator() {
		return new BST_Iterator(root);
	}

	/**
	 * Clears the elements of the binary search tree
	 */
	public void clear() {
		root = null;
		nodeCount = 0;
	}

	/**
	 * Calls insert helper and to increment node count 
     * @param k the key value of the node to insert
     * @param d the data value of the node to insert
	 */
	public void insert(K k, D d) {
		root = insertHelper(root, k, d);
		nodeCount++;
	}

	/**
	 * Inserts a node into BST by comparing the key value
	 * @param rt the root node of the BST
	 * @param k the key value of the node to insert
	 * @param d the data value of the node to insert
	 * @return the altered BST node, which the root will be set to
	 */
	public BST_node<K, D> insertHelper(BST_node<K, D> rt, K k, D d) {
		if (rt == null)
			return new BST_node<K, D>(k, d);
		if (rt.key().compareTo(k) >= 0)
			rt.setLeft(insertHelper(rt.left(), k, d));
		else
			rt.setRight(insertHelper(rt.right(), k, d));
		return rt;
	}
	
	/**
	 * Removes a node from the BST by the key value
	 * @param rt the root node of the BST
	 * @param k the key value of the node to remove
	 * @return the node to replace the removed BST node
	 */
	protected BST_node<K, D> removeHelper(BST_node<K, D> rt, K key) {
		if (rt == null)
			return null;
		if (rt.key().compareTo(key) > 0)
			rt.setLeft(removeHelper(rt.left(), key));
		else if (rt.key().compareTo(key) < 0)
			rt.setRight(removeHelper(rt.right(), key));
		else {		
			if (rt.left() == null)
				return rt.right();
			else if (rt.right() == null)
				return rt.left();
			else { // two children
				BST_node<K, D> temp = getMin(rt.right());
				rt.setData(temp.data());
				rt.setKey(temp.key());
				rt.setRight(deleteMin(rt.right()));
			}
		}
		return rt;
	}

	/**
     * Gets the node with minimum value, used in insertHelper
     * @param rt the root node of the BST
     * @return the node to replace the removed BST node
     */
	protected BST_node<K, D> getMin(BST_node<K, D> rt) {
	  //directly find the corresponding
	    //generate another help function remove help that carries name x y w h
		if (rt.left() == null)
			return rt;
		else
			return getMin(rt.left());
	}

	/**
     * Removes the node with minimum value, used in insertHelper
     * @param rt the root node of the BST
     * @return the node to replace the removed BST node
     */
	protected BST_node<K, D> deleteMin(BST_node<K, D> rt) {
		if (rt.left() == null)
			return rt.right();
		else {
			rt.setLeft(deleteMin(rt.left()));
			return rt;
		}
	}

	public void dump() {
		System.out.print("BST dump:\n");
		if (root != null) {
			dumpHelper(root, 0);
		}
		System.out.print("\tBST size is: " + nodeCount + "\n");
	}

	private void dumpHelper(BST_node<K, D> rt, int count) { // in order traversal
		if (rt != null) {
			dumpHelper(rt.left(), count + 1);
			System.out.print("\tNode has depth " + count + ", Value (");
			System.out.print(rt.key().toString() + " ");
			System.out.print(rt.data().toString() + ")\n");
			dumpHelper(rt.right(), count + 1);
		}
	}

	BST_node<K, D> findHelper(BST_node<K, D> rt, K key) {
		if (rt == null)
			return null;
		if (rt.key().compareTo(key) > 0)
			return findHelper(rt.left(), key);
		else if (rt.key().compareTo(key) < 0)
			return findHelper(rt.right(), key);
		else
			return rt;
	}

	public void search(String nodeName) {
		boolean found = searchHelper(root, nodeName, false);
		if (!found)
			System.out.print("Rectangle not found: " + nodeName + "\n");
		return;
	}           

	public boolean searchHelper(BST_node<K, D> rt, String key, boolean b) {
		if (rt == null)
			return b || false;
		if (rt.key().toString().compareTo(key) > 0)
			searchHelper(rt.left(), key, b);
		else if (rt.key().toString().compareTo(key) < 0)
			searchHelper(rt.right(), key, b);
		else {
			searchHelper(rt.left(), key, true);
			System.out.print("Rectangle found: " + rt + "\n");
			searchHelper(rt.right(), key, true);
			b = true;
		}
		return b;
	}

	public BST_node<K, D> root() {
		return root;
	}

	public int nodeCount() {
		return nodeCount;
	}

	// data members
	protected BST_node<K, D> root;
	protected int nodeCount;

	// Iterator subclass for our BST implemented using a stack
	public class BST_Iterator implements Iterator<BST_node<K, D>> {

		BST_Iterator(BST_node<K, D> root) {
			nodeStack.push(root);
		}

		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty();
		}

		@Override
		public BST_node<K, D> next() {
			BST_node<K, D> cur = null;
			if (!nodeStack.empty()) {
				cur = nodeStack.peek();
				nodeStack.pop();

				if (cur.right() != null)
					nodeStack.push(cur.right());

				if (cur.left() != null)
					nodeStack.push(cur.left());
			}
			return cur;
		}

		protected Stack<BST_node<K, D>> nodeStack = new Stack<BST_node<K, D>>();
	}
}
