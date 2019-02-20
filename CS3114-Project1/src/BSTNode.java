/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 * @param <D> the data
 * @param <K> the key
 *
 * Binary Search Tree Node Object
 * Holds a generic key and data value for each node
 * as well as the right and left "child" nodes
 */
public class BSTNode<K, D> implements Comparable<BSTNode<K, D>> {
    
    /**
     * Defualt Constructor 
     * Initializes the child nodes
     */
    BSTNode() {
        left = null;
        right = null;
    }

    /**
     * Parameterized Constructor
     * Sets the private member variables key, data, left, and right
     * @param inputKey the key value used to set private member key
     * @param inputData the data value used to set pivate member data
     */
    BSTNode(K inputKey, D inputData) {
        key = inputKey;
        data = inputData;
        left = null;
        right = null;
    }

    /**
     * Parameterized Constructor
     * Sets the private member variables key, data, left, and right
     * to the corresponding input parameter values
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
     * Provides access to the node's key value
     * @return the key value
     */
    public K key() {
        return key;
    }

    /**
     * Sets the node's key to input parameter value
     * @param inputKey the key value to set
     */
    public void setKey(K inputKey) {
        key = inputKey;
    }

    /**
     * Provides access to the node's data value
     * @return the data value
     */
    public D data() {
        return data;
    }

    /**
     * Sets the node's data to input parameter value
     * @param inputData the data value to set
     */
    public void setData(D inputData) {
        data = inputData;
    }

    /**
     * Provides access to the node's right child
     * @return the right child node
     */
    public BSTNode<K, D> right() {
        return right;
    }

    /**
     * Sets the node's right child to input value
     * @param inputNode the node used to set right child
     */
    public void setRight(BSTNode<K, D> inputNode) {
        right = inputNode;
    }

    /**
     * Provides access to the node's left child
     * @return the left child node
     */
    public BSTNode<K, D> left() {
        return left;
    }

    /**
     * Sets the node's left child to input value
     * @param inputNode the node used to set left child
     */
    public void setLeft(BSTNode<K, D> inputNode) {
        left = inputNode;
    }

    /**
     * Helper function to check if the node is a leaf
     * leaf meaning both left and right children are null
     * @return true if node is a leaf, else false
     */
    public boolean isLeaf() {
        return !(left || right);
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
