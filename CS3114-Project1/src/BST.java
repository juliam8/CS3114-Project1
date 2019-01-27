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
	
	void insert(BST_node<T> t) {
		if(root == null) {
			//root = new BST_node<T>(t);
		}
		else
			//root.insert(t);
		count++;
	}
	
	public void dump() {
		if (root != null) {
			dump_helper(root);
		}
	}
	private void dump_helper(BST_node<T> root) {
		if (root != null) {
			dump_helper(root.left());
			root.print();
			dump_helper(root.right());
			System.out.println("hola");
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


