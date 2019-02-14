import java.io.FileNotFoundException;

/**
 * @author abbym1
 *
 */
import student.TestCase;

public class Rectangle1Test extends TestCase {

	/**
	 * Test method for {@link Rectangle1#main(java.lang.String[])}.
	 */
	public void testMain() {
		String[] in = {"SyntaxTest.txt"};// "C:\\Users\\amalone46\\git\\CS3114-Project1\\p1\\CS3114-Project1\\src\\SyntaxTest.txt" };
		try {
			Rectangle1.main(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
