import java.util.Vector;
/**
 * @author juliam8
 *
 */
public class BST_Rectangle<K, D> extends BST<RectKey, RectData> {
	
	BST_Rectangle(){ root = null; node_count = 0; }
	
	BST_node<RectKey, RectData> remove(RectKey k) {	//maybe should be made null
		if (root != null) {	
		    BST_node<RectKey, RectData> temp = find_helper(root, k); // First find it
		    if (temp != null) {
		      root = remove_helper(root, k);
		      node_count--;
		    }
		    return temp;
		}
		return null;	//return null
	}
	
	BST_node<RectKey, RectData> remove(RectData d){		
		if (root != null) {
			BST_node<RectKey, RectData> temp = find_helper_data(root, d);
		    if (temp != null) {
			      root = remove_helper(root, temp.key()); 
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
	

	//height and width must be greater than 0
	//can be outside 0 1024 range
	void regionsearch(RectData d) {
		regionsearch_traverse(root, d);
	}
	
	//how about we just get the top left coordi
	//l1 top left
	//r1 bottom right
	void regionsearch_traverse(BST_node<RectKey, RectData> rt, RectData d) {
		if (rt == null) return;
		
		if (rt != null) {
			regionsearch_traverse(rt.left(), d);
			regionsearch_check(rt, d);
			regionsearch_traverse(rt.right(), d);
		}
	}
	
	void regionsearch_check(BST_node<RectKey, RectData> rt, RectData d) {
		int n_x1 = rt.data().x();//left 
		int n_x2 = rt.data().x() + rt.data().w();//right
		int n_y1 = rt.data().y();//top
		int n_y2 = rt.data().y() + rt.data().h();//bottom
		int d_x1 = d.x(); int d_x2 = d.x() + d.w();
		int d_y1 = d.y(); int d_y2 = d.y() + d.h();
		
		if (n_x1 > d_x2 || d_x1 > n_x2 || n_y1 > d_y2 || d_y1 > n_y2) {}
		else
			System.out.println(rt);
	}
		
	void intersection() {
		
	}

}
