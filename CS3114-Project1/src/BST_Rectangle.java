/**
 * @author juliam8
 *
 */
public class BST_Rectangle<K, D> extends BST<RectKey, RectData> {
	
	//BST_Rectangle(){ root = null; node_count = 0; }
	
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
		//RectData d = new RectData(coordinates);
		if (root != null) {
			BST_node<RectKey, RectData> temp = find_helper_data(root, d);
		    if (temp != null) {
			     // remove_helper_data(temp, k); // removed "root = "
			      node_count--;
			      return temp;
		    }
		    return null;
		}
		return null;
	}
	
	BST_node<RectKey, RectData> find_helper_data(BST_node<RectKey, RectData> rt, RectData d) {	//FIX
		if (rt != null) { 
			find_helper_data(rt.left(), d);
			if (rt.data().compareTo(d) == 1)
				return rt;
			find_helper_data(rt.right(), d);
		}
		return null;
	}
	
	
	BST_node<RectKey, RectData> search(String node_name) {
		RectKey k = new RectKey(node_name);
		BST_node<RectKey, RectData> temp = find_helper(root, k);
		return temp;
	}
	

	
	void regionsearch(int[] coordinates) {
		
	}
	
	void intersection() {
		
	}

}
