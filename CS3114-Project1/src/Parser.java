import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 */

/**
 * This object parses a file and interprets the contents
 * according to CS3114 Project 1 requirements
 */
public class Parser {
	/**
	 * Parameterized constructor for the Parser class
	 * Sets the private member variables my_bst and scan
	 * @param f 	Path to the input file containing the commands
	 * @param BST	Binary Search tree associated with 
	 * 				the parser object and input file upon which the 
	 * 				commands will be run
	 */
	Parser(File f, BST_Rectangle<RectKey, RectData> BST) {
		try {
			my_bst = BST;
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void execute() {

		while (scan.hasNext()) {
			String command = scan.next();

			if (command.equals("insert")) {
				insert();
			} else if (command.equals("remove")) {
				remove();
			} else if (command.equals("regionsearch")) {
				region_search();
			} else if (command.equals("search")) {
				my_bst.search(scan.next());
			} else if (command.equals("intersections")) {
				intersections();
			} else if (command.equals("dump")) {
				my_bst.dump();
			}
		}
		scan.close();
	}

	private void insert() {
		String name = scan.next();
		int[] nums = new int[4];
		for (int i = 0; i < 4; i++) {
			nums[i] = Integer.parseInt(scan.next());
		}
		RectKey node_key = new RectKey(name);
		RectData node_data = new RectData(nums);
		my_bst.insert(node_key, node_data);
		if ((nums[2] <= 0 || nums[3] <= 0) || (nums[0] + nums[2] > 1024 || nums[0] + nums[2] < 0
				|| nums[1] + nums[3] > 1024 || nums[1] + nums[3] < 0)) {
			System.out.print("Rectangle rejected: (" + node_key + " " + node_data + ")\n");
		} else {
			System.out.print("Rectangle accepted: (" + node_key + " " + node_data + ")\n");
		}
	}

	private void region_search() {
		int[] nums = new int[4];
		for (int i = 0; i < 4; i++) {
			nums[i] = Integer.parseInt(scan.next());
		}
		if (nums[2] <= 0 || nums[3] <= 0) // command rejected if width/height is <= 0
			System.out.print("Rectangles command rejected.");
		else {
			RectData node_data = new RectData(nums);
			System.out.print("Rectangles intersecting region (" + node_data + "):\n");
			my_bst.regionsearch(my_bst.root(), node_data);
		}
	}

	private void remove() {
		if (scan.hasNextInt()) {
			remove_data();
		} else {
			remove_key();
		}
	}

	private void remove_key() {
		RectKey node_key = new RectKey(scan.next());
		BST_node<RectKey, RectData> temp = my_bst.remove(node_key);
		if (temp == null) {
			System.out.print("Rectangle rejected (" + node_key + ")\n");
		}
	}

	private void remove_data() {
		int[] nums = new int[4];
		for (int i = 0; i < 4; i++) {
			nums[i] = Integer.parseInt(scan.next());
		}
		RectData node_data = new RectData(nums);
		BST_node<RectKey, RectData> temp = my_bst.remove(node_data); // send in array of integers
		if (temp == null) {
			System.out.print("Rectangle rejected (" + node_data + ")\n");
		}
	}

	private void intersections() {
		System.out.print("Intersection pairs:\n");
		my_bst.intersection();
	}

	private Scanner scan;
	private BST_Rectangle<RectKey, RectData> my_bst;
}
