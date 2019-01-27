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
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println("Julia");
		
		Scanner scan = new Scanner(new File(args[0]));
		//String command = scan.next();
		
		while (scan.hasNext()) {
			String temp = scan.next();
			if (temp.equals("insert")) {
				
			}
			else if (temp.equals("regionsearch")) {
				
			}
			else if (temp.equals("search")) {
				
			}
			else if (temp.equals("remove")) {
				
			}
			else if (temp.equals("intersection")) {
				
			}
			else if (temp.equals("dump")) {
				
			}
		}
		scan.close();
	}
	
	public void parser() {
		
	}
}