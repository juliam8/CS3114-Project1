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
	 int count;
	
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
			dump(node.left);
			node.print();
			dump(node.right);
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
	void dump() {}
}


