import java.util.Iterator;
import java.util.Vector;
/**
 * @author juliam8 && abbym1
 *
 */
public class BST<K extends Comparable<? super K>, D> implements Iterable<K>{
	//constructor
	BST(){ root = null; node_count = 0; }
	
    @Override
    public Iterator<K> iterator() {
        return new BST_Iterator(root);
    }
	
	//clear, apparently
	public void clear() { root = null; node_count = 0; }
	
	//insert a node into the BST
	//input must be a comparable data type
	public void insert(K k, D d) {
		root = insert_helper(root, k, d);
		node_count++;
	}
	
	public BST_node<K, D> insert_helper(BST_node<K, D> rt, K k, D d){
		if(rt == null) return new BST_node<K, D>(k, d);
		if(rt.key().compareTo(k) >= 0)
			rt.set_l(insert_helper(rt.left(), k, d));
		else
			rt.set_r(insert_helper(rt.right(), k, d));
		return rt;	
	}	
	
	protected BST_node<K, D> remove_helper(BST_node<K, D> rt, K key) {	//remove the temp found by find_helper
		if (rt == null) return null;
		if (rt.key().compareTo(key) > 0)
			rt.set_l(remove_helper(rt.left(), key));
		else if (rt.key().compareTo(key) < 0)
			rt.set_r(remove_helper(rt.left(), key));
		else {		
			if (rt.left() == null)
				return rt.right();
			else if (rt.right() == null)
				return rt.left();
			else {	//two children
				BST_node<K, D> temp = get_min(rt.right());
				rt.set_data(temp.data());
				rt.set_key(temp.key());
				rt.set_r(delete_min(rt.right()));
			}
		}
		return rt;
	}
	
	protected BST_node<K, D> get_min(BST_node<K, D> rt){
		if (rt.left() == null)
			return rt;
		else 
			return get_min(rt.left());
	}
	
	protected BST_node<K, D> delete_min(BST_node<K, D> rt){
		if (rt.left() == null)
			return rt.right();
		else {
			rt.set_l(delete_min(rt.left()));
			return rt;
		}
	}

	public void dump() {
		System.out.print("BST dump:\n");
		if (root != null) {
			dump_helper(root, 0);
		}
		System.out.print("BST size is " + node_count + "\n");
	}

	private void dump_helper(BST_node<K, D> rt, int count) {	//in order traversal
		if (rt != null) {
			dump_helper(rt.left(), count + 1);
			System.out.print("Node has depth " + count + ", Value (");
			System.out.print(rt.key().toString() + " ");
			System.out.print(rt.data().toString() + ")\n");
			dump_helper(rt.right(), count + 1);
		}
	}
	
	BST_node<K, D> find_helper(BST_node<K, D> rt, K key) {
		if (rt == null) return null;
		if (rt.key().compareTo(key) > 0)
			return find_helper(rt.left(), key);
		else if (rt.key().compareTo(key) < 0)
			return find_helper(rt.right(), key);
		else
			return rt;	
	}
	
	public void search(String node_name) {
		boolean found = search_helper(root, node_name, false);
		if(!found)
			System.out.print("Rectanlge not found: " + node_name + "\n");
		return;
	}
	
	public boolean search_helper(BST_node<K, D> rt, String key, boolean b) {
		if (rt == null) return b || false;
		if (rt.key().toString().compareTo(key) > 0)
			search_helper(rt.left(), key, b);
		else if (rt.key().toString().compareTo(key) < 0) 
			search_helper(rt.right(), key, b);
		else {
			search_helper(rt.left(), key, true);
			System.out.print("Rectangle found: " + rt + "\n");
			search_helper(rt.right(), key, true);
			b = true;
		}
		return b;
	}
	
	public BST_node<K, D> root() {
		return root;
	}
	
	public int node_count() {
		return node_count;
	}
	
	protected BST_node<K, D> root;
	protected int node_count;

	public class BST_Iterator implements Iterator<K> {
		//i know this is wrong but it's a start
		BST_Iterator(BST_node<K, D> root){ root = null;}//root = null; node_count = 0; }

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return null;
		}

	}
}


