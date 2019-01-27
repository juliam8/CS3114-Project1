/**
 * 
 */

/**
 * @author juliam8 && abbym1
 *
 */

public class BST_node<T extends Comparable<T>> {
	
	BST_node(T n){
		key = n;
		left = right = null;
		
	}
	
	/*BST_node(BST_node n){
		key = n.get_key();
		left = n.left;
		right = n.right;

		
	}*/

	public T get_key() {
		return key;
	}
	
	public void set_key(T k) {
		key = k;
	}
	
	
	BST_node<T> left, right;
	private T key;
	
}
