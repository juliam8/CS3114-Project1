/**
 * 
 */

/**
 * @author juliam8
 *
 */
public class BST<T extends Comparable<T>> {
	//constructor
	BST(){ root = null; count = 0; }
	
	//clear, apparently
	public void clear() { root = null; count = 0; }
	
	//insert a node into the BST
	//input must be a comparable data type
	public void insert(T t) {
		root = insert_helper(root, t);
		count++;
	}
	
	public BST_node<T> insert_helper(BST_node<T> rt, T n){
		if(rt == null) return new BST_node<T>(n);
		if(rt.key().compareTo(n) >= 0)
			rt.set_l(insert_helper(rt.left(), n));
		else
			rt.set_r(insert_helper(rt.right(), n));
		return rt;	
	}	

	
	public void dump() {
		if (root != null) {
			dump_helper(root);
		}
	}
	private void dump_helper(BST_node<T> root) {
		if (root != null) {
			dump_helper(root.left());
			System.out.print(root.key + "\n");
			//root.print();
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


