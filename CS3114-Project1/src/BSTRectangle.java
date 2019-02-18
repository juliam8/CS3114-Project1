
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 * @param <D> Generic Data type 
 * @param <K> Generic Key type
 *  Extension of generic BST class to handle Rectangles
 */
public class BSTRectangle<K, D> extends BST<RectKey, RectData> {
    
    /**
     * Constructor for the BSTRectangle class 
     * Sets the private member variables root and nodeCount
     */
    BSTRectangle() {
        root = null;
        nodeCount = 0;
    }

    /**
     * Determines if node with designated key exists, if so it removes it
     * @param key the key value of the node to remove
     * @return the node that was deleted
     */
    public BST_node<RectKey, RectData> remove(RectKey key) {
        if (root != null) {
            BST_node<RectKey, RectData> temp = findHelper(root, key); 
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
     */
    public void remove(RectData data) {
		if (root == null) {
		    System.out.println("Rectangle rejected (" + data + ")");
		}
		else {
		    int before = nodeCount;
			root = findHelperData(root, data);
			
			if (nodeCount != before - 1) {
			    System.out.println("Rectangle rejected (" + data + ")");
			}
		}
	}

    /**
     * Finds the node with the corresponding data value
     * @param rt the root node of the BST
     * @param data the data value of the node to find
     * @return the node that holds the corresponding data value
     */
    private BST_node<RectKey, RectData> 
	        findHelperData(BST_node<RectKey, RectData> rt, RectData data) {
        if (rt == null) {
            return null;
        }
        if (rt.data().compareTo(data) == 0) {
            nodeCount--;
            if (rt.left() == null) {
                return rt.right();
            }
            else if (rt.right() == null) {
                return rt.left();
            }
            else { // two children
                BST_node<RectKey, RectData> temp = getMin(rt.right());
                rt.setData(temp.data());
                rt.setKey(temp.key());
                rt.setRight(deleteMin(rt.right()));
            }
            return rt;
        }
        else if (rt.left() != null) {
            rt.setLeft(findHelperData(rt.left(), data));
        }
        else {
            rt.setRight(findHelperData(rt.right(), data));
        }
        return rt;
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
     * @param d the region in which to search for other rectangles
     */
    private void regionSearchCheck(BST_node<RectKey, RectData> node, 
                                    RectData d) {
        int nx1 = node.data().x(); // left
        int nx2 = node.data().x() + node.data().w(); // right
        int ny1 = node.data().y(); // top
        int ny2 = node.data().y() + node.data().h(); // bottom
        int dx1 = d.x();
        int dx2 = d.x() + d.w();
        int dy1 = d.y();
        int dy2 = d.y() + d.h();

        if (!(nx1 > dx2 || dx1 > nx2 || ny1 > dy2 || dy1 > ny2)) {
            System.out.println(node);
        }	
    }

    /**
     * Uses the BST iterator class to check if any nodes in the BST intersect
     */
    public void intersection() {
        BSTIterator outer = new BSTIterator(root);
        BST_node<RectKey, RectData> cur = null;
        for (int i = 0; i < nodeCount; ++i) {
            cur = outer.next();
            BSTIterator inner = new BSTIterator(root);
            for (int k = 0; k < i; ++k) { // goes forward the outside amount 
                inner.next();
            }
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
    private void iteratorCheck(BST_node<RectKey, RectData> a, 
                                BST_node<RectKey, RectData> b) {
        int ax1 = a.data().x(); // left
        int ax2 = a.data().x() + a.data().w(); // right
        int ay1 = a.data().y(); // top
        int ay2 = a.data().y() + a.data().h(); // bottom
        int bx1 = b.data().x();
        int bx2 = b.data().x() + b.data().w();
        int by1 = b.data().y();
        int by2 = b.data().y() + b.data().h();

        if (!(ax1 > bx2 || bx1 > ax2 || ay1 > by2 || by1 > ay2 || a == b)) {
            System.out.println("\t" + a + " : " + b);
        }	
    }
}
