/**
 * 
 */

/**
 * @author juliam8 && abbym1
 *
 */

public class BST_node<T extends Comparable<T>> implements Comparable<BST_node<T>>{
	
	BST_node(T n){
		key = n;
		left = right = null;
		
	}
	
	/*BST_node(BST_node n){
		key = n.get_key();
		left = n.left;
		right = n.right;

		
	}*/
	
	@Override
    public int compareTo(BST_node<T> b) {
        return get_key().compareTo(b.get_key());
	}
	
	public void insert(T r) {
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
	}

	public T get_key() {
		return key;
	}
	
	public void set_key(T k) {
		key = k;
	}
	

	public void print() {
		System.out.print(this.key + "\n");
	}
	
	BST_node<T> left, right;
	private T key;
	
}
