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
public class BST<K extends Comparable<? super K>, D> implements Iterable<BST_node<K, D>> {
    
    /**
     * Constructor for the BST class 
     * Sets the private member variables root and nodeCount
     */
    BST() {
        root = null;
        nodeCount = 0;
    }

    @Override
    public Iterator<BST_node<K, D>> iterator() {
        return new BST_Iterator(root);
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
    public void insert(BST_node<K, D> node) {
        root = insertHelper(root, node);
        nodeCount++;
    }

    /**
     * Inserts a node into BST by comparing the key value
     * @param BST_node<K, D> rt the root node of the BST
     * @param BST_node<K, D> node the node to insert
     * @return BST_node<K, D> the altered BST node, which 
     * the root will be set to
     */
    public BST_node<K, D> insertHelper(BST_node<K, D> rt, BST_node<K, D> node) {
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
     * @param BST_node<K, D> rt the root node of the BST
     * @param K key the key value of the node to remove
     * @return BST_node<K, D> the node to replace the 
     * removed BST node
     */
    protected BST_node<K, D> removeHelper(BST_node<K, D> rt, K key) {
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
                BST_node<K, D> temp = getMin(rt.right());
                rt.setData(temp.data());
                rt.setKey(temp.key());
                rt.setRight(deleteMin(rt.right()));
            }
        }
        return rt;
    }

    /**
     * Gets the node with minimum value, used in insertHelper
     * @param BST_node<K, D> rt the root node of the BST
     * @return BST_node<K, D> the node holding the minimum
     *  key value
     */
    protected BST_node<K, D> getMin(BST_node<K, D> rt) {
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
     * @param BST_node<K, D> rt the root node of the BST
     * @return BST_node<K, D> the node holding the minimum 
     * key value
     */
    protected BST_node<K, D> deleteMin(BST_node<K, D> rt) {
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
        System.out.print("    BST size is: " + nodeCount + "\n");
    }

    /**
     * Prints out the nodes in the BST using inorder traversal
     * @param BST_node<K, D> rt the root node of the BST
     * @param int depth the depth of the node being printed
     */
    private void dumpHelper(BST_node<K, D> rt, int depth) { 
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
    BST_node<K, D> findHelper(BST_node<K, D> rt, K key) {
        if (rt == null) {
            return null;
        }
        if (rt.key().compareTo(key) > 0) {
            return findHelper(rt.left(), key);
        }
        else if (rt.key().compareTo(key) < 0) {
            return findHelper(rt.right(), key);
        }
        else {
            return rt;
        }
    }

    /**
     * Calls search helper and prints if node is not found
     * @param key the key value of the node to find
     */
    public void search(String key) {
        boolean found = searchHelper(root, key, false);
        if (!found) {
            System.out.print("Rectangle not found: " + key + "\n");
        } 
        return;
    }           

    /**
     * Searches for all nodes in BST tree that have the key value
     * @param rt the root node of the BST
     * @param key the key value of the node to insert
     * @param b the boolean value to track throughout recursive function calls
     * @return the boolean to represent if any node has been found with the key value
     */
    public boolean searchHelper(BST_node<K, D> rt, String key, boolean b) {
        if (rt == null) {
            return b || false;
        }
        else if (rt.key().toString().compareTo(key) > 0) {
            return searchHelper(rt.left(), key, b);
        }
        else if (rt.key().toString().compareTo(key) < 0) {
            return searchHelper(rt.right(), key, b);
        }
        else {
            searchHelper(rt.left(), key, true);
            System.out.print("Rectangle found: " + rt + "\n");
            b = true;
            searchHelper(rt.right(), key, true);
        }
        return false;
    }

    /**
     * Returns the root of the BST
     * @return the root of the BST
     */
    public BST_node<K, D> root() {
        return root;
    }

    /**
     * Returns the node count of the BST
     * @return the number of nodes in the BST
     */
    public int nodeCount() {
        return nodeCount;
    }

    // data members
    protected BST_node<K, D> root;
    protected int nodeCount;    
    
    // Iterator subclass for our BST implemented using a stack
    public class BST_Iterator implements Iterator<BST_node<K, D>> {

    BST_Iterator(BST_node<K, D> root) {
        nodeStack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }

    @Override
    public BST_node<K, D> next() {
        BST_node<K, D> cur = null;
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

    protected Stack<BST_node<K, D>> nodeStack = new Stack<BST_node<K, D>>();
    
    }
}
