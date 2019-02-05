import java.util.Vector;
/**
 * @author juliam8
 *
 */
public class BST_Rectangle<K, D> extends BST<RectKey, RectData> {
	
	BST_Rectangle(){ root = null; node_count = 0; }
	
	BST_node<RectKey, RectData> remove(RectKey k) {	//maybe should be made null
		//RectKey k = new RectKey(node_name);
		if (root != null) {	
		    BST_node<RectKey, RectData> temp = find_helper(root, k); // First find it
		    if (temp != null) {
		      root = remove_helper(temp, k); // removed "root = "
		      node_count--;
		    }
		    return temp;
		}
		return null;	//return null
	}
	
	BST_node<RectKey, RectData> remove(RectData d){		///Ah I don't know if it should be void or not
		if (root != null) {
			BST_node<RectKey, RectData> temp = find_helper_data(root, d);
		    if (temp != null) {
			      root = remove_helper(temp, temp.key()); // removed "root = "
			      node_count--;
		    }
		    return temp;
		}
		return null;
	}
			
	BST_node<RectKey, RectData> find_helper_data(BST_node<RectKey, RectData> rt, RectData d) {
		if (rt == null) return null;
		
		if (rt.data().compareTo(d) == 1)
			return rt;
		else if (rt.left() != null)
			return find_helper_data(rt.left(), d);
		else
			return find_helper_data(rt.right(), d);
	}
	
	
	public Vector<BST_node<RectKey, RectData>> search(String node_name) {
		RectKey k = new RectKey(node_name);
		Vector<BST_node<RectKey, RectData>> result = new Vector<BST_node<RectKey, RectData>>();
		search_helper(root, k, result);
		return result;
	}
	
	public void search_helper(BST_node<RectKey, RectData> rt, RectKey key, Vector<BST_node<RectKey, RectData>> r) {
		if (rt == null) return;
		if (rt.key().compareTo(key) > 0)
			search_helper(rt.left(), key, r);
		else if (rt.key().compareTo(key) < 0)
			search_helper(rt.right(), key, r);
		else {
			r.addElement(rt);
			return;
		}
	}

	
	void regionsearch(int[] coordinates) {
		System.out.print("regionsearch yo");
	}
	
	void intersection() {
		
	}

}
