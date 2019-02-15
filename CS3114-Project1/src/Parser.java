import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 *
 * This object parses a file and interprets the contents according to
 * CS3114 Project 1 requirements
 */
public class Parser {
    /**
     * Parameterized constructor for the Parser class Sets the private member
     * variables mBST and mScan
     * 
     * @param inputFile     Path to the input file containing the commands
     * @param rectBST       Binary Search tree associated with the parser object
     *                      and input file upon which the commands will be run
     */
    Parser(File inputFile, BSTRectangle<RectKey, RectData> rectBST) {
        try {
            mBST = rectBST;
            mScan = new Scanner(inputFile);
        } 
        catch (FileNotFoundException e) {
            //Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Parses each command from the input file using a Scanner 
     * calls the appropriate helper function(s) to execute each command
     */
    public void execute() {

        while (mScan.hasNext()) {
            String command = mScan.next();

            if (command.equals("insert")) {
                insert();
            } 
            else if (command.equals("remove")) {
                remove();
            } 
            else if (command.equals("regionsearch")) {
                regionSearch();
            } 
            else if (command.equals("search")) {
                mBST.search(mScan.next());
            } 
            else if (command.equals("intersections")) {
                intersections();
            } 
            else if (command.equals("dump")) {
                mBST.dump();
            }
        }
        mScan.close();
    }

    /**
     * Checks input rectangle data for validity
     * @param i     Input array representing x y w h
     * @return      True for a valid rectangle, else False
     * A rectangle is valid if it lies within (0,0) and (1024, 1024)
     * and has non-negative w and h
     */
    private boolean valid(int[] i) {
        return !((i[0] < 0 || i[1] < 0) ||
                (i[2] <= 0 || i[3] <= 0) ||
                (i[0] + i[2] > 1024) ||
                (i[0] + i[2] < 0) ||
                (i[1] + i[3] > 1024) ||
                (i[1] + i[3] < 0));
    }
    
    /**
     * Method to execute the BST insert command 
     * Accepts or rejects the input rectangle based on 0,0 1024,1024 bounds
     */
    private void insert() {
        String name = mScan.next();
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(mScan.next());
        }
        RectKey nodeKey = new RectKey(name);
        RectData nodeData = new RectData(nums);
        BST_node<RectKey, RectData> n;
        n = new BST_node<RectKey, RectData>(nodeKey, nodeData);
        
        if (valid(nums)) {
            mBST.insert(n);
            System.out.print("Rectangle accepted: " + n + "\n");
        } 
        else {
            System.out.print("Rectangle rejected: " + n + "\n");
        }
    }

    /**
     * Check if the given x y w h represents a valid region
     * Call the BST regionSearch method if so
     */
    private void regionSearch() {
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(mScan.next());
        }
        // command rejected if width/height is <= 0
        if (nums[2] <= 0 || nums[3] <= 0) { 
            System.out.print("Rectangles command rejected.");
        }
        else {
            RectData d = new RectData(nums);
            System.out.print("Rectangles intersecting region (" + d + "):\n");
            mBST.regionSearch(mBST.root(), d);
        }
    }

    /**
     * Determines whether remove by key or remove
     * by data is appropriate
     */
    private void remove() {
        if (mScan.hasNextInt()) {
            removeData();
        } 
        else {
            removeKey();
        }
    }

    /**
     * Removes a node with the given Key value
     */
    private void removeKey() {
        RectKey nodeKey = new RectKey(mScan.next());
        BST_node<RectKey, RectData> temp = mBST.remove(nodeKey);
        if (temp == null) {
            System.out.print("Rectangle rejected (" + nodeKey + ")\n");
        }
    }

    /**
     * Removes a node with the given Data value
     */
    private void removeData() {
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(mScan.next());
        }
        RectData d = new RectData(nums);
        
        // send in array of integers
        BST_node<RectKey, RectData> temp = mBST.remove(d);
        if (temp == null) {
            System.out.print("Rectangle rejected (" + d + ")\n");
        }
    }

    /**
     * Calls the BST method to report all intersecting
     * rectangles
     */
    private void intersections() {
        System.out.print("Intersection pairs:\n");
        mBST.intersection();
    }

    private Scanner mScan;
    private BSTRectangle<RectKey, RectData> mBST;
}
