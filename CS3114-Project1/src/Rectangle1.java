/**
 * 
 */

/**
 * @author juliam8 && abbym1
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Rectangle1 {
	
	/**
	 * Constructor for main file
	 */
	public Rectangle1() {}
	
	/**
	 * describe the main here
	 * @param args the arguments
	 * @throws FileNotFoundException 
	 *also do @return if needed
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//BST<BST_node<Rectangle>> BST = new BST<BST_node<Rectangle>>();
		BST<RectKey, RectData> BST = new BST<RectKey, RectData>();
		Parser myparse = new Parser(new File(args[0]), BST);
		myparse.execute();
	}

	
	
}