import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author jmkuz
 *
 */
public class Parser {
	
	Parser(File f, BST<RectKey, RectData> BST) {
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

			if 		(command.equals("insert")) { insert(); }
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
		RectKey node_key = new RectKey(name);
		RectData node_data = new RectData(nums);
		//Rectangle my_rect = new Rectangle(name, nums);
		if ((nums[2] <= 0 || nums[3] <= 0) ||
		(nums[0]+nums[2] > 1024 || nums[0]+nums[2] < 0 || nums[1]+nums[3] > 1024 || nums[1]+nums[3] < 0)) {
			System.out.print("Rectangle rejected: ");
			System.out.print(node_key);
			System.out.print(node_data + "\n");
		}
		else {
			BST_node<RectKey, RectData> mynode = new BST_node<RectKey, RectData>(node_key, node_data);
			my_bst.insert(node_key, node_data);
		}
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
	
	//can I search through the BST here to get the rectangle corresponding
	//	to the coordinates or the name and then send that rectangle into the BST?
	
	private Scanner scan;
	private BST<RectKey, RectData> my_bst;
}
