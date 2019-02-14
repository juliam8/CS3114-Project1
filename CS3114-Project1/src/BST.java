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
		node_count = 0;
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
		node_count = 0;
	}

	/**
	 * Calls insert helper and to increment node count 
	 * @param args the arguments
	 * @throws FileNotFoundException 
	 *also do @return if needed
	 */
	public void insert(K k, D d) {
		root = insert_helper(root, k, d);
		node_count++;
	}


	/**
	 * Inserts a node into BST by comparing the key value
	 * @param rt the root node of the BST
	 * @param k the key value of the node to insert
	 * @param d the data value of the node to insert
	 * @throws FileNotFoundException 
	 * @return the altered BST node, which the root will be set to
	 */
	public BST_node<K, D> insert_helper(BST_node<K, D> rt, K k, D d) {
		if (rt == null)
			return new BST_node<K, D>(k, d);
		if (rt.key().compareTo(k) >= 0)
			rt.set_l(insert_helper(rt.left(), k, d));
		else
			rt.set_r(insert_helper(rt.right(), k, d));
		return rt;
	}
	
	/**
	 * Removes a node from the BST by 
	 * @param rt the root node of the BST
	 * @param k the key value of the node to insert
	 * @param d the data value of the node to insert
	 * @throws FileNotFoundException 
	 * @return the altered BST node, which the root will be set to
	 */
	protected BST_node<K, D> remove_helper(BST_node<K, D> rt, K key) {
		if (rt == null)
			return null;
		if (rt.key().compareTo(key) > 0)
			rt.set_l(remove_helper(rt.left(), key));
		else if (rt.key().compareTo(key) < 0)
			rt.set_r(remove_helper(rt.right(), key));
		else {		
			if (rt.left() == null)
				return rt.right();
			else if (rt.right() == null)
				return rt.left();
			else { // two children
				BST_node<K, D> temp = get_min(rt.right());
				rt.set_data(temp.data());
				rt.set_key(temp.key());
				rt.set_r(delete_min(rt.right()));
			}
		}
		return rt;
	}

	protected BST_node<K, D> get_min(BST_node<K, D> rt) {
		if (rt.left() == null)
			return rt;
		else
			return get_min(rt.left());
	}

	protected BST_node<K, D> delete_min(BST_node<K, D> rt) {
		if (rt.left() == null)
			return rt.right();
		else {
			rt.set_l(delete_min(rt.left()));
			return rt;
		}
	}

	public void dump() {
		System.out.print("BST dump:\n");
		if (root != null) {
			dump_helper(root, 0);
		}
		System.out.print("\tBST size is: " + node_count + "\n");
	}

	private void dump_helper(BST_node<K, D> rt, int count) { // in order traversal
		if (rt != null) {
			dump_helper(rt.left(), count + 1);
			System.out.print("\tNode has depth " + count + ", Value (");
			System.out.print(rt.key().toString() + " ");
			System.out.print(rt.data().toString() + ")\n");
			dump_helper(rt.right(), count + 1);
		}
	}

	BST_node<K, D> find_helper(BST_node<K, D> rt, K key) {
		if (rt == null)
			return null;
		if (rt.key().compareTo(key) > 0)
			return find_helper(rt.left(), key);
		else if (rt.key().compareTo(key) < 0)
			return find_helper(rt.right(), key);
		else
			return rt;
	}

	public void search(String node_name) {
		boolean found = search_helper(root, node_name, false);
		if (!found)
			System.out.print("Rectangle not found: " + node_name + "\n");
		return;
	}

	public boolean search_helper(BST_node<K, D> rt, String key, boolean b) {
		if (rt == null)
			return b || false;
		if (rt.key().toString().compareTo(key) > 0)
			search_helper(rt.left(), key, b);
		else if (rt.key().toString().compareTo(key) < 0)
			search_helper(rt.right(), key, b);
		else {
			search_helper(rt.left(), key, true);
			System.out.print("Rectangle found: " + rt + "\n");
			search_helper(rt.right(), key, true);
			b = true;
		}
		return b;
	}

	public BST_node<K, D> root() {
		return root;
	}

	public int node_count() {
		return node_count;
	}

	// data members
	protected BST_node<K, D> root;
	protected int node_count;

	// Iterator subclass for our BST implemented using a stack
	public class BST_Iterator implements Iterator<BST_node<K, D>> {

		BST_Iterator(BST_node<K, D> root) {
			node_stack.push(root);
		}

		@Override
		public boolean hasNext() {
			return !node_stack.isEmpty();
		}

		@Override
		public BST_node<K, D> next() {
			BST_node<K, D> cur = null;
			if (!node_stack.empty()) {
				cur = node_stack.peek();
				node_stack.pop();

				if (cur.right() != null)
					node_stack.push(cur.right());

				if (cur.left() != null)
					node_stack.push(cur.left());
			}
			return cur;
		}

		protected Stack<BST_node<K, D>> node_stack = new Stack<BST_node<K, D>>();
	}
}
