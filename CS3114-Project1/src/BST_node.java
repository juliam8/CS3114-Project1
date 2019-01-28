/**
 * 
 */

/**
 * @author juliam8 && abbym1
 *
 */

public class BST_node<T extends Comparable<T>> implements Comparable<BST_node<T>>{
	//constructors
	BST_node(){ left = right = null; }
	BST_node(T n){
		key = n;
		left = right = null;
	}

	BST_node(T n, BST_node<T> l, BST_node<T> r){
		key = n;
		left = l;
		right = r;
	}

	/*public void insert(T r) {
		if (key.compareTo(r) <= 0) {
			if (right == null) {
				right = new BST_node<T>(r);
			} else {
				right.insert(r);
			}
		} else if (key.compareTo(r) > 0) {
			if (left == null) {
				left = new BST_node<T>(r);
			} else {
				left.insert(r);
			}
		}
	}*/
	
	//Get and set the key value
	public T key() { return key; }
	public void set_key(T k) { key = k; }
	
	//get and set the left and right child nodes
	public BST_node<T> right() { return right; }
	public void set_r(BST_node<T> r) { right = r; }
	
	public BST_node<T> left() { return left; }
	public void set_l(BST_node<T> l) { left = l; }
	
	//return true IFF this is a leaf node
	public boolean isLeaf() { return (left == null && right == null); }
	
	public void print() {
		System.out.print(key.toString() + "\n");
	}

	
	@Override
    public int compareTo(BST_node<T> b) {
        return key().compareTo(b.key());
	}
	
	//private data members
	private BST_node<T> left, right;

	public T key;
}
