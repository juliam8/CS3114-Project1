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
		//String command = scan.next();
		
		Parser myparse = new Parser();
		//BST <BST_node> my_bst= new BST<BST_node>();

		System.out.println("Lets make a conflict");
		
		while (scan.hasNext()) {
			String command = scan.next();

			if (command.equals("insert")) {
				String name = scan.next();
				String[] nums = scan.nextLine().split(" ");
				BST_node mynode = new BST_node(scan.next(), nums);
				my_bst.insert(mynode, name);
			}
			else if (command.equals("remove")) {
				if (scan.hasNextInt()) {
					my_bst.remove(scan.nextLine().split(" ")); //send in array of strings
				}
				else {
					my_bst.remove(scan.nextLine());
				}
			}
			else if (command.equals("regionsearch")) {
				my_bst.regionsearch(scan.nextLine().split(" ")); //send in array of strings
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