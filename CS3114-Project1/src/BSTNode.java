

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 * @param <D> the data
 * @param <K> the key
 *
 * This object executes functions for the node of the BST and holds
 * a key value a data value or each node
 */
public class BSTNode<K, D> implements Comparable<BSTNode<K, D>> {
    
    /**
     * Constructor for the BSTNode class 
     * Sets the private member variables left and right
     */
    BSTNode() {
        left = null;
        right = null;
    }

    /**
     * Parameterized constructor for the BSTNode class 
     * Sets the private member variables key, data, left, and right
     * 
     * @param k the key value in the created node
     * @param d the data value in the created node
     */
    BSTNode(K k, D d) {
        key = k;
        data = d;
        left = null;
        right = null;
    }

    /**
     * Parameterized constructor for the BSTNode class 
     * Sets the private member variables key, data, left, and right
     * 
     * @param k the key value in the created node
     * @param d the data value in the created node
     * @param l the left node of the created node
     * @param r the right node of the created node
     */
    BSTNode(K k, D d, BSTNode<K, D> l, BSTNode<K, D> r) {
        key = k;
        data = d;
        left = l;
        right = r;
    }

    /**
     * Get the key value
     * @return the key value
     */
    public K key() {
        return key;
    }

    /**
     * Sets the key value
     * @param k the key value to set
     */
    public void setKey(K k) {
        key = k;
    }

    /**
     * Get the data value
     * @return the data value
     */
    public D data() {
        return data;
    }

    /**
     * Set the data
     * @param d the data value to set
     */
    public void setData(D d) {
        data = d;
    }

    /**
     * Returns the right node
     * @return the right node
     */
    public BSTNode<K, D> right() {
        return right;
    }

    /**
     * Sets the right node
     * @param r the right node to set
     */
    public void setRight(BSTNode<K, D> r) {
        right = r;
    }

    /**
     * Returns the left node
     * @return the left node
     */
    public BSTNode<K, D> left() {
        return left;
    }

    /**
     * Sets the left node
     * @param l the left node to set
     */
    public void setLeft(BSTNode<K, D> l) {
        left = l;
    }

    /**
     * Checks if the node has no children
     * @return the boolean that is set if the node is a leaf node
     */
    public boolean isLeaf() {
        return (left == null && right == null);
    }

    @Override
    public int compareTo(BSTNode<K, D> o) {
        if (key == o.key() && data == o.data()) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "(" + key.toString() + ", " + data.toString() + ")";
    }

    // private data members
    private BSTNode<K, D> left;
    private BSTNode<K, D> right;
    private K key;
    private D data;
}
