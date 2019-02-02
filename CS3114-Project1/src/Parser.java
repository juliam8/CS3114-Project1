import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author juliam8 && abbym1
 *
 */
public class Parser {
	
	Parser(File f, BST<BST_node<Rectangle>> BST) {
		try {
			my_bst = BST;
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void execute() {
		
		while (scan.hasNext()) {
			String command = scan.next();

			if (command.equals("insert")) { insert(); }
			else if (command.equals("remove")) { remove(); }
			else if (command.equals("regionsearch")) { region_search(); }
			else if (command.equals("search")) { my_bst.search(scan.nextLine()); }
			else if (command.equals("intersection")) { my_bst.intersection(); }
			else if (command.equals("dump")) { my_bst.dump(); }
		}
		scan.close();		
	}
	
	private void insert() {
		String name = scan.next();
		int[] nums = new int[4];
		for (int i = 0; i < 4; i++) {
			nums[i] = Integer.parseInt(scan.next());
		}
		Rectangle my_rect = new Rectangle(name, nums);
		BST_node<Rectangle> mynode = new BST_node<Rectangle>(my_rect);
		my_bst.insert(mynode);
	}
	private void region_search() {
		int[] nums = new int[4];
		for (int i = 0; i < 4; i++) {
			nums[i] = Integer.parseInt(scan.next());
		}
		my_bst.regionsearch(nums); //send in array of integers
	}

	private void remove() {
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
	
	private Scanner scan;
	private BST<BST_node<Rectangle>> my_bst;
}
