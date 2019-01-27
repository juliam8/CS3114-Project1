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
        return key().compareTo(b.key());
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

	public T key() {
		return key;
	}
	
	public void set_key(T k) {
		key = k;
	}
	
	public BST_node<T> right() {
		return right;
	}
	
	public BST_node<T> left() {
		return left;
	}

	public void print() {
		//integer[] a = { 2, 3, 4, 5 }; 
        //Rectangle c1 = new Rectangle("me", a); 
        //System.out.println(c1); 
		System.out.print(this.right.key + "\n");
	}
	
	private BST_node<T> left, right;
	T key;
	
}
