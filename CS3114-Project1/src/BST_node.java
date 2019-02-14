/**
 * @author juliam8 && abbym1
 *
 */

public class BST_node<K, D> {
	// constructors
	BST_node() {
		left = right = null;
	}

	BST_node(K k, D d) {
		key = k;
		data = d;
		left = right = null;
	}

	BST_node(K k, D d, BST_node<K, D> l, BST_node<K, D> r) {
		key = k;
		data = d;
		left = l;
		right = r;
	}

	// Get and set the key value
	public K key() {
		return key;
	}

	public void setKey(K k) {
		key = k;
	}

	// Get and set the data value
	public D data() {
		return data;
	}

	public void setData(D d) {
		data = d;
	}

	// get and set the left and right child nodes
	public BST_node<K, D> right() {
		return right;
	}

	public void setRight(BST_node<K, D> r) {
		right = r;
	}

	public BST_node<K, D> left() {
		return left;
	}

	public void setLeft(BST_node<K, D> l) {
		left = l;
	}

	// return true IFF this is a leaf node
	public boolean isLeaf() {
		return (left == null && right == null);
	}

	@Override
	public String toString() {
		return "(" + key.toString() + " " + data.toString() + ")";
	}

	// private data members
	private BST_node<K, D> left, right;
	private K key;
	private D data;
}
