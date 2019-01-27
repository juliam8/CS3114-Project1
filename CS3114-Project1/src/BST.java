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
	
	 BST_node<T> root;
	
	void insert(T t) {
		if(root == null) {
			root = new BST_node<T>(t);
		}
		else
			root.insert(t);
	}
	
	public void dump(BST_node<T> node) {
		if (node != null) {
			dump(node.left);
			node.print();
			dump(node.right);
		}
	}
	
	void remove(T node_name) {
		
	}
	
	void remove(String[] coordinates) {
		
	}
	
	void regionsearch(String[] coordinates) {
		
	}
	
	void search(String node_name) {
		
	}
	
	void intersection() {}
	void dump() {}
}


