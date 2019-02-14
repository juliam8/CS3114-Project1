/**
 * @author juliam8 && abbym1
 *
 */
public class BST_Rectangle<K, D> extends BST<RectKey, RectData> {

	BST_Rectangle() {
		root = null;
		nodeCount = 0;
	}

	/**
     * Determines if node with designated key exists, if so it removes it
     * @param key the key value of the node to remove
     * @return the node that was deleted
     */
	public BST_node<RectKey, RectData> remove(RectKey key) { // maybe should be made null
		if (root != null) {
			BST_node<RectKey, RectData> temp = findHelper(root, key); // First find it
			if (temp != null) {
				root = removeHelper(root, key);
				nodeCount--;
			}
			return temp;
		}
		return null; // return null
	}

    /**
     * Determines if node with designated data exists, if so it removes it
     * @param data the data value of the node to remove
     * @return the node that was deleted
     */
	public BST_node<RectKey, RectData> remove(RectData data) {
		if (root != null) {
			BST_node<RectKey, RectData> temp = findHelperData(root, data);
			if (temp != null) {
				root = removeHelper(root, temp.key());
				nodeCount--;
			}
			return temp;
		}
		return null;
	}

	/**
     * Finds the node with the corresponding data value
     * @param rt the root node of the BST
     * @param data the data value of the node to find
     * @return the node that holds the corresponding data value
     */
	private BST_node<RectKey, RectData> findHelperData(BST_node<RectKey, RectData> rt, RectData data) {
		if (rt == null)
			return null;
		if (rt.data().compareTo(data) == 1)
			return rt;
		else if (rt.left() != null)
			return findHelperData(rt.left(), data);
		else
			return findHelperData(rt.right(), data);
	}

	/**
     * Calls region search helper and traverses through BST
     * @param rt the root node of the BST
     * @param data the region in which to search for other rectangles
     */
	public void regionSearch(BST_node<RectKey, RectData> rt, RectData data) {
		if (rt != null) {
		    regionSearch(rt.left(), data);
		    regionSearchCheck(rt, data);
			regionSearch(rt.right(), data);
		}
	}

	/**
     * Determines if the node data is within the region of the input data
     * @param node the node to check if it is within the region
     * @param data the region in which to search for other rectangles
     */
	private void regionSearchCheck(BST_node<RectKey, RectData> node, RectData d) {
		int n_x1 = node.data().x();// left
		int n_x2 = node.data().x() + node.data().w();// right
		int n_y1 = node.data().y();// top
		int n_y2 = node.data().y() + node.data().h();// bottom
		int d_x1 = d.x();
		int d_x2 = d.x() + d.w();
		int d_y1 = d.y();
		int d_y2 = d.y() + d.h();

		if (n_x1 > d_x2 || d_x1 > n_x2 || n_y1 > d_y2 || d_y1 > n_y2) {
		} else
			System.out.println(node);
	}

	/**
     * Uses the BST iterator class to check if any nodes in the BST intersect
     */
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

	/**
     * Determines if the iterated node intersects the other iterated node
     * @param a the first node to compare
     * @param b the second node to compare
     */
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
