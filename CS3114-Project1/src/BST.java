import java.util.Iterator;
import java.util.Stack;


/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 * Generic BST class storing
 * @param <K> generic Key type
 * @param <D> generic Data type
 */
public class BST<K extends Comparable<? super K>, D> 
            implements Iterable<BSTNode<K, D>> {
    
    /**
     * Constructor for the BST class 
     * Sets the private member variables root and nodeCount
     */
    BST() {
        root = null;
        nodeCount = 0;
    }

    @Override
    public Iterator<BSTNode<K, D>> iterator() {
        return new BSTIterator(root);
    }

    /**
     * Clears the elements of the binary search tree
     */
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    /**
     * Calls insert helper and to increment node count 
     * @param node the node to insert
     */
    public void insert(BSTNode<K, D> node) {
        root = insertHelper(root, node);
        nodeCount++;
    }

    /**
     * Inserts a node into BST by comparing the key value
     * @param rt BSTNode<K, D> the root node of the BST
     * @param node BSTNode<K, D> the node to insert
     * @return BSTNode<K, D> the altered BST node, which 
     * the root will be set to
     */
    public BSTNode<K, D> insertHelper(BSTNode<K, D> rt, BSTNode<K, D> node) {
        if (rt == null) {
            return node;
        }
        if (rt.key().compareTo(node.key()) >= 0) {
            rt.setLeft(insertHelper(rt.left(), node));
        }
        else {
            rt.setRight(insertHelper(rt.right(), node));
        }
        return rt;
    }

    /**
     * Removes a node from the BST by the key value
     * @param rt type BSTNode<K, D> the root node of the BST
     * @param key the key value of the node to remove
     * @return BSTNode<K, D> the node to replace the 
     * removed BST node
     */
    protected BSTNode<K, D> removeHelper(BSTNode<K, D> rt, K key) {
        if (rt == null) {
            return null;
        }
        if (rt.key().compareTo(key) > 0) {
            rt.setLeft(removeHelper(rt.left(), key));
        }
        else if (rt.key().compareTo(key) < 0) {
            rt.setRight(removeHelper(rt.right(), key));
        }
        else {
            if (rt.left() == null) {
                return rt.right();
            }
            else if (rt.right() == null) {
                return rt.left();
            }
            else { // two children
                BSTNode<K, D> temp = getMin(rt.right());
                rt.setData(temp.data());
                rt.setKey(temp.key());
                rt.setRight(deleteMin(rt.right()));
            }
        }
        return rt;
    }

    /**
     * Gets the node with minimum value, used in insertHelper
     * @param rt type BSTNode<K, D> the root node of the BST
     * @return BSTNode<K, D> the node holding the minimum
     *  key value
     */
    protected BSTNode<K, D> getMin(BSTNode<K, D> rt) {
        //directly find the corresponding
        //generate another help function remove help that carries name x y w h
        if (rt.left() == null) {
            return rt;
        }
        else {
            return getMin(rt.left());
        }
    }

    /**
     * Removes the node with minimum value, used in insertHelper
     * @param rt type BSTNode<K, D> the root node of the BST
     * @return BSTNode<K, D> the node holding the minimum 
     * key value
     */
    protected BSTNode<K, D> deleteMin(BSTNode<K, D> rt) {
        if (rt.left() == null) {
            return rt.right();
        }
        else {
            rt.setLeft(deleteMin(rt.left()));
            return rt;
        }
    }

    /**
     * Calls dump helper and prints out words for dump 
     */
    public void dump() {
        System.out.print("BST dump:\n");
        if (root != null) {
            dumpHelper(root, 0);
        }
        else {
            System.out.println("    Node has depth 0, Value (null)");
        }
        System.out.println("    BST size is: " + nodeCount);
    }

    /**
     * Prints out the nodes in the BST using inorder traversal
     * @param rt type BSTNode<K, D> the root node of the BST
     * @param depth the depth of the node being printed
     */
    private void dumpHelper(BSTNode<K, D> rt, int depth) { 
        if (rt != null) {
            dumpHelper(rt.left(), depth + 1);
            System.out.print("    Node has depth " + depth + ", Value ");
            System.out.print(rt + "\n");
            dumpHelper(rt.right(), depth + 1);
        }
    }

    /**
     * Finds a node in the BST by comparing the key value
     * @param rt the root node of the BST
     * @param key the key value of the node to insert
     * @return the BST node with the corresponding key value
     */
    BSTNode<K, D> findHelper(BSTNode<K, D> rt, K key) {
        if (rt == null) {
            return null;
        }
        if (rt.key().compareTo(key) > 0) {
            return findHelper(rt.left(), key);
        }
        else if (rt.key().compareTo(key) == 0) {
            return rt;
        }
        else {
            return findHelper(rt.right(), key);
        }
    }

    /**
     * Calls search helper and prints if node is not found
     * @param key the key value of the node to find
     */
    public void search(K key) {
        BSTNode<K, D> temp = findHelper(root, key); // First find it
        //BSTNode<K, D> findHelper(BSTNode<K, D> rt, K key) {
        if (temp == null) {
            System.out.println("Rectangle not found: " + key);
        }
        else {
            searchHelper(root, key);
        }
    }           

    /**
     * Searches for all nodes in BST tree that have the key value
     * @param rt the root node of the BST
     * @param key the key value of the node to insert
     */
    public void searchHelper(BSTNode<K, D> rt, K key) {
        if (rt != null) {        
            if (rt.key().compareTo(key) > 0) {
                searchHelper(rt.left(), key);
            }
            else if (rt.key().compareTo(key) < 0) {
                searchHelper(rt.right(), key);
            }
            else {
                searchHelper(rt.left(), key);
                System.out.println("Rectangle found: " + rt);
                searchHelper(rt.right(), key);
            }
        }
    }

    /**
     * Returns the root of the BST
     * @return the root of the BST
     */
    public BSTNode<K, D> root() {
        return root;
    }

    /**
     * Returns the node count of the BST
     * @return the number of nodes in the BST
     */
    public int nodeCount() {
        return nodeCount;
    }

    /**
     * The root of the BST
     */
    protected BSTNode<K, D> root;
    
    /**
     * The number of nodes in the BST
     */
    protected int nodeCount;    
    
    /**
     * Iterator subclass for our BST implemented using a stack
     */
    public class BSTIterator implements Iterator<BSTNode<K, D>> {

        /**
         * Constructor for iterator subclass 
         * @param root the node to be put onto the stack
         */
        BSTIterator(BSTNode<K, D> root) {
            nodeStack.push(root);
        }
    
        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty();
        }
    
        @Override
        public BSTNode<K, D> next() {
            BSTNode<K, D> cur = null;
            if (!nodeStack.empty()) {
                cur = nodeStack.peek();
                nodeStack.pop();
    
                if (cur.right() != null) {
                    nodeStack.push(cur.right());
                }
                if (cur.left() != null) {
                    nodeStack.push(cur.left());
                }
            }
            return cur;
        }

        /**
         * The stack that holds the BST
         */
        protected Stack<BSTNode<K, D>> nodeStack = new Stack<BSTNode<K, D>>();
    
    }
}
