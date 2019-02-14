/**
 * @author juliam8 && abbym1
 *
 */
public class BST_Rectangle<K, D> extends BST<RectKey, RectData> {

	BST_Rectangle() {
		root = null;
		nodeCount = 0;
	}

	public BST_node<RectKey, RectData> remove(RectKey k) { // maybe should be made null
		if (root != null) {
			BST_node<RectKey, RectData> temp = findHelper(root, k); // First find it
			if (temp != null) {
				root = removeHelper(root, k);
				nodeCount--;
			}
			return temp;
		}
		return null; // return null
	}

	public BST_node<RectKey, RectData> remove(RectData d) {
		if (root != null) {
			BST_node<RectKey, RectData> temp = findHelperData(root, d);
			if (temp != null) {
				root = removeHelper(root, temp.key());
				nodeCount--;
			}
			return temp;
		}
		return null;
	}

	private BST_node<RectKey, RectData> findHelperData(BST_node<RectKey, RectData> rt, RectData d) {
		if (rt == null)
			return null;

		if (rt.data().compareTo(d) == 1)
			return rt;
		else if (rt.left() != null)
			return findHelperData(rt.left(), d);
		else
			return findHelperData(rt.right(), d);
	}

	public void regionSearch(BST_node<RectKey, RectData> rt, RectData d) {
		if (rt == null)
			return;

		if (rt != null) {
		    regionSearch(rt.left(), d);
		    regionSearchCheck(rt, d);
			regionSearch(rt.right(), d);
		}
	}

	private void regionSearchCheck(BST_node<RectKey, RectData> rt, RectData d) {
		int n_x1 = rt.data().x();// left
		int n_x2 = rt.data().x() + rt.data().w();// right
		int n_y1 = rt.data().y();// top
		int n_y2 = rt.data().y() + rt.data().h();// bottom
		int d_x1 = d.x();
		int d_x2 = d.x() + d.w();
		int d_y1 = d.y();
		int d_y2 = d.y() + d.h();

		if (n_x1 > d_x2 || d_x1 > n_x2 || n_y1 > d_y2 || d_y1 > n_y2) {
		} else
			System.out.println(rt);
	}

	// Work in progress! ? maybe done
	public void intersection() {
		BST_Iterator outer = new BST_Iterator(root);
		BST_node<RectKey, RectData> cur = null;
		for (int i = 0; i < nodeCount; ++i) {
			cur = outer.next();
			BST_Iterator inner = new BST_Iterator(root);
			for (int k = 0; k < i; ++k) // goes forward the amount of times on outside
				inner.next();
			for (int j = 0; j < nodeCount - i; ++j) {
				iteratorCheck(cur, inner.next());
			}
		}

	}

	private void iteratorCheck(BST_node<RectKey, RectData> a, BST_node<RectKey, RectData> b) {
		int n_x1 = a.data().x();// left
		int n_x2 = a.data().x() + a.data().w();// right
		int n_y1 = a.data().y();// top
		int n_y2 = a.data().y() + a.data().h();// bottom
		int d_x1 = b.data().x();
		int d_x2 = b.data().x() + b.data().w();
		int d_y1 = b.data().y();
		int d_y2 = b.data().y() + b.data().h();

		if (n_x1 > d_x2 || d_x1 > n_x2 || n_y1 > d_y2 || d_y1 > n_y2 || a == b) {
		} else
			System.out.println("\t" + a + " : " + b);
	}
}
