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
     * Precondition: the key is valid
     * Postcondition: the node with the key is removed
     * @param key the key value of the node to remove
     * @return the node that was deleted
     */
    public BSTNode<RectKey, RectData> remove(RectKey key) {
        if (root != null) {
            BSTNode<RectKey, RectData> temp = findHelper(root, key); 
            if (temp != null) {
                root = removeHelper(root, key);
                nodeCount--;
            }
            return temp;
        }
        return null;
    }

    /**
     * Determines if node with designated data exists, if so it removes it
     * Precondition: the data is valid
     * Postcondition: the node with the data is removed
     * @param data the data value of the node to remove
     */
    public void remove(RectData data) {
        if (root == null) {
            System.out.println("Rectangle rejected (" + data + ")");
        }
        else {
            // variable 'before' is used to check if a node was removed
            int before = nodeCount;
            root = findAndRemoveHelperData(root, data);

            if (nodeCount != before - 1) {
                System.out.println("Rectangle rejected (" + data + ")");
            }
        }
    }

    /**
     * Finds and deletes the node with the corresponding data value
     * Precondition: the tree isn't empty and data is valid
     * Postcondition: the node with the data is removed
     * @param rt the root node of the BST
     * @param data the data value of the node to find
     * @return the node that holds the corresponding data value
     */
    private BSTNode<RectKey, RectData> findAndRemoveHelperData(
                BSTNode<RectKey, RectData> rt, 
                RectData data) {
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
            else { // there are two children of node to remove
                BSTNode<RectKey, RectData> temp = getMin(rt.right());
                rt.setData(temp.data());
                rt.setKey(temp.key());
                rt.setRight(deleteMin(rt.right()));
            }
            return rt;
        }
        if (rt.left() != null) {
            rt.setLeft(findAndRemoveHelperData(rt.left(), data));
        }
        if (rt.right() != null) {
            rt.setRight(findAndRemoveHelperData(rt.right(), data));
        }
        return rt;
    }

    /**
     * Calls region search helper and traverses through BST
     * Precondition: the data is valid
     * Postcondition: the tree is traversed with the regionsearch data
     * @param rt the root node of the BST
     * @param data the region in which to search for other rectangles
     */
    public void regionSearch(BSTNode<RectKey, RectData> rt, RectData data) {
        if (rt != null) {
            regionSearch(rt.left(), data);
            regionSearchCheck(rt, data);
            regionSearch(rt.right(), data);
        }
    }

    /**
     * Determines if the node data is within the region of the input data
     * Precondition: the node is not null and region is valid
     * Postcondition: nodes within region are printed out
     * @param node the node to check if it is within the region
     * @param d the region in which to search for other rectangles
     */
    private void regionSearchCheck(BSTNode<RectKey, RectData> node, 
                                    RectData region) {
        int nodex1 = node.data().x(); // lower x value of rect
        int nodex2 = node.data().x() + node.data().w(); // upper x value
        int nodey1 = node.data().y(); // lower y value
        int nodey2 = node.data().y() + node.data().h(); // upper y value
        int regionx1 = region.x(); // lower x value of region
        int regionx2 = region.x() + region.w(); // upper x value
        int regiony1 = region.y(); // lower y value
        int regiony2 = region.y() + region.h(); // upper y value

        // logic to check if the rectangle is within the region
        if (!(nodex1 > regionx2 || regionx1 > nodex2 
                || nodey1 > regiony2 || regiony1 > nodey2)) {
            System.out.println(node);
        }
    }

    /**
     * Uses the BST iterator class to check if any nodes in the BST intersect
     * Precondition: BST iterator is implemented
     * Postcondition: Each node is compared to the other
     */
    public void intersection() {
        // outer is the outer Iterator loop
        BSTIterator outer = new BSTIterator(root);
        // cur is the outer node being compared
        BSTNode<RectKey, RectData> cur = null;
        for (int i = 0; i < nodeCount; ++i) {
            cur = outer.next();
            // inner is the inner Iterator loop
            BSTIterator inner = new BSTIterator(root);
            for (int k = 0; k < i; ++k) { // goes forward the outside amount 
                inner.next();
            }
            for (int j = 0; j < nodeCount - i; ++j) {
                //comparison to see if the two intersect
                iteratorCheck(cur, inner.next());
            }
        }
    }

    /**
     * Determines if the iterated node intersects the other iterated node
     * Precondition: Both nodes are valid
     * Postcondition: The intersecting nodes are printed out
     * @param a the first node to compare
     * @param b the second node to compare
     */
    private void iteratorCheck(BSTNode<RectKey, RectData> a, 
                               BSTNode<RectKey, RectData> b) { 
        int ax1 = a.data().x(); // lower x value of the first rectangle
        int ax2 = a.data().x() + a.data().w(); // upper x value
        int ay1 = a.data().y();  // lower y value
        int ay2 = a.data().y() + a.data().h(); // upper y value of second rect
        int bx1 = b.data().x(); // upper x value
        int bx2 = b.data().x() + b.data().w(); // upper x value
        int by1 = b.data().y(); // lower y value
        int by2 = b.data().y() + b.data().h(); // upper y value

        // logic to check if the two rectangles intersect
        if (!(ax1 >= bx2 || bx1 >= ax2 || ay1 >= by2 || by1 >= ay2) &&
            (a != b)) {
            System.out.println("    " + a + " : " + b);
        }
    }
}
