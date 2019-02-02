/**
 * 
 */

/**
 * @author juliam8 && abbym1
 *
 */

/*public class BST_node<T extends Comparable<T>> implements Comparable<BST_node<T>>{
	//constructors
	BST_node(){ left = right = null; }
	BST_node(T n){
		this.key = n; //it is setting the key as the entire rectangle
		this.left = this.right = null;
	}

	BST_node(T n, BST_node<T> l, BST_node<T> r){
		this.key = n;
		this.left = l;
		this.right = r;
	}*/
	
public class BST_node<K, D>{// implements BinNode<D>{
	//constructors
	BST_node(){ left = right = null; }
	BST_node(K k, D d){
		key = k; //it is setting the key as the entire rectangle
		data = d;
		left = right = null;
	}

	BST_node(K k, D d, BST_node<K, D> l, BST_node<K, D> r){
		key = k;
		data = d;
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
	public K key() { return key; }
	public void set_key(K k) { key = k; }
	
	//Get and set the data value
	public D data() { return data; }
	public void set_data(D d) { data = d; }
	
	//get and set the left and right child nodes
	public BST_node<K, D> right() { return right; }
	public void set_r(BST_node<K, D> r) { right = r; }
	
	public BST_node<K, D> left() { return left; }
	public void set_l(BST_node<K, D> l) { left = l; }
	
	//return true IFF this is a leaf node
	public boolean isLeaf() { return (left == null && right == null); }
	

	@Override
	public String toString() {
        return key.toString();
    }
	
	//@Override
   // public int compareTo(BST_node<K, D> b) {
     //   return key().compareTo(b.key());
//	}
	
	//private data members
	private BST_node<K, D> left, right;
	private K key;
	private D data;
	
	//Get and set the key value
	/*public T key() { return key; }
	public void set_key(T k) { key = k; }
	
	//get and set the left and right child nodes
	public BST_node<T> right() { return right; }
	public void set_r(BST_node<T> r) { right = r; }
	
	public BST_node<T> left() { return left; }
	public void set_l(BST_node<T> l) { left = l; }
	
	//return true IFF this is a leaf node
	public boolean isLeaf() { return (left == null && right == null); }
	

	@Override
	public String toString() {
        return key.toString();
    }
	
	@Override
    public int compareTo(BST_node<T> b) {
        return key().compareTo(b.key());
	}
	
	//private data members
	private BST_node<T> left, right;
	private K key;*/
}
