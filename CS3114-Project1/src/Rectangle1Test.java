import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * 
 */

/**
 * @author abbym1
 *
 */
public class Rectangle1Test {

	/**
	 * Test method for {@link Rectangle1#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
		String[] in =  {"C:\\Users\\amalone46\\git\\CS3114-Project1\\p1\\CS3114-Project1\\src\\SyntaxTest.txt"};
		try {
			Rectangle1.main(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
