/**
 * 
 */

/**
 * @author juliam8
 *
 */
public class BST<T extends Comparable<T>> {
	
	BST(){
		root = null;
	}
	
	BST(BST_node<T> n){
		root = n;
	}
	
	void insert(T t) {
		if(root == null) {
			root = new BST_node<T>(t);
		}
		else
			root.insert(t);
		count++;
	}
	
	public void dump(BST_node<T> node) {
		if (node != null) {
			dump(node.left());
			node.print();
			dump(node.right());
		}
	}
	
	void remove(String node_name) {
		
	}
	
	void remove(int[] coordinates) {
		
	}
	
	void regionsearch(int[] coordinates) {
		
	}
	
	void search(String node_name) {
		
	}
	
	void intersection() {}
	
	public BST_node<T> root() {
		return root;
	}
	
	public int node_count() {
		return count;
	}
	
	private BST_node<T> root;
	private int count;
}


