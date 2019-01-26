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
	 * describe the main here
	 * @param args the arguments
	 * @throws FileNotFoundException 
	 *also do @return if needed
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
<<<<<<< HEAD
		System.out.println("Abby!!");
=======
		System.out.println("Julia");
		
		Scanner scan = new Scanner(new File(args[0]));
		String command = scan.next();
		
		while (scan.hasNext()) {
			String temp = scan.next();
			if (temp.equals("hi")) {
				
			}
		}
		scan.close();
>>>>>>> 7361c27173e739eff7b414eaccaccc08cbeaa6f7
		

	}

}
