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

		System.out.println("Julia");
		
		Scanner scan = new Scanner(new File(args[0]));
		//String command = scan.next();
		
		Parser myparse = new Parser();
		BST <BST_node> my_bst= new BST<BST_node>();

		System.out.println("Lets make a conflict");
		
		while (scan.hasNext()) {
			String command = scan.next();
			//myparse.parse_string(temp);
			if (command.equals("insert")) {
				String rest = scan.nextLine();
				String[] split_num = rest.split(" ", 4);
				//BST_node mynode = new BST_node(scan.next(), split_num);
						///my_bst.insert(my_bst);
			}
			
			else if (command.equals("regionsearch")) {
				
			}
			else if (command.equals("search")) {
				
			}
			else if (command.equals("remove")) {
				
			}
			else if (command.equals("intersection")) {
				
			}
			else if (command.equals("dump")) {
				
			}
		}

		scan.close();		

	}

	
	
}