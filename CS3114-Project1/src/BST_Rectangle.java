/**
 * @author juliam8 && abbym1
 *
 */
public class BST_Rectangle<K, D> extends BST<RectKey, RectData> {
	
	BST_Rectangle(){ root = null; node_count = 0; }
	
	public BST_node<RectKey, RectData> remove(RectKey k) {	//maybe should be made null
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
	
	public BST_node<RectKey, RectData> remove(RectData d){		
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

	private BST_node<RectKey, RectData> find_helper_data(BST_node<RectKey, RectData> rt, RectData d) {
		if (rt == null) return null;
		
		if (rt.data().compareTo(d) == 1)
			return rt;
		else if (rt.left() != null)
			return find_helper_data(rt.left(), d);
		else
			return find_helper_data(rt.right(), d);
	}
	
	public void regionsearch(BST_node<RectKey, RectData> rt, RectData d) {
		if (rt == null) return;
		
		if (rt != null) {
			regionsearch(rt.left(), d);
			regionsearch_check(rt, d);
			regionsearch(rt.right(), d);
		}
	}
	
	private void regionsearch_check(BST_node<RectKey, RectData> rt, RectData d) {
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
		
	//Work in progress! ? maybe done
	public void intersection() {
		BST_Iterator outer = new BST_Iterator(root);
		BST_node<RectKey, RectData> cur = null;
		for(int i = 0; i < node_count; ++i) {
			cur = outer.next();
			BST_Iterator inner = new BST_Iterator(root);
			for(int k = 0; k < i; ++k)
				inner.next();
			for(int j = 0; j < node_count-i; ++j) {
				iterator_check(cur, inner.next());
			}
		}
		
	}
	
	private void iterator_check(BST_node<RectKey, RectData> a, BST_node<RectKey, RectData> b) {
		int n_x1 = a.data().x();//left 
		int n_x2 = a.data().x() + a.data().w();//right
		int n_y1 = a.data().y();//top
		int n_y2 = a.data().y() + a.data().h();//bottom
		int d_x1 = b.data().x(); int d_x2 = b.data().x() + b.data().w();
		int d_y1 = b.data().y(); int d_y2 = b.data().y() + b.data().h();
		
		if (n_x1 > d_x2 || d_x1 > n_x2 || n_y1 > d_y2 || d_y1 > n_y2 || a == b) {}
		else
			System.out.println("\t" + a + " : " + b);
	}
	
	

}
