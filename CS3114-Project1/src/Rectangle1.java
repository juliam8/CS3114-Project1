/**
 * 
 */

/**
 * @author jmkuz
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

		
		Scanner scan = new Scanner(new File(args[0]));
		

		BST<BST_node<Rectangle>> my_bst= new BST<BST_node<Rectangle>>();
		
		while (scan.hasNext()) {
			String command = scan.next();

			if (command.equals("insert")) {
				String name = scan.next();
				int[] nums = new int[4];
				for (int i = 0; i < 4; i++) {
					nums[i] = Integer.parseInt(scan.next());
				}
				Rectangle my_rect = new Rectangle(name, nums);
				BST_node<Rectangle> mynode = new BST_node<Rectangle>(my_rect);
				my_bst.insert(mynode);
			}
			else if (command.equals("remove")) {
				if (scan.hasNextInt()) {
					int[] nums = new int[4];
					for (int i = 0; i < 4; i++) {
						nums[i] = Integer.parseInt(scan.next());
					}
					my_bst.remove(nums); //send in array of integers
				}
				else {
					my_bst.remove(scan.nextLine());
				}
			}
			else if (command.equals("regionsearch")) {
				int[] nums = new int[4];
				for (int i = 0; i < 4; i++) {
					nums[i] = Integer.parseInt(scan.next());
				}
				my_bst.regionsearch(nums); //send in array of integers
			}
			else if (command.equals("search")) {
				my_bst.search(scan.nextLine());
			}
			else if (command.equals("intersection")) {
				my_bst.intersection();
			}
			else if (command.equals("dump")) {
				my_bst.dump();
			}
		}

		scan.close();		

	}

	
	
}