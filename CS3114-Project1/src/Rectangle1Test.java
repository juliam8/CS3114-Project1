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
	    //String[] in = {"C:\\Users\\amalone46\\git\\CS3114-Project1\\p1\\CS3114-Project1\\src\\GeneralTest.txt" };
		String[] in = {"GeneralTest.txt"};
		try {
			Rectangle1.main(in);
		} catch (FileNotFoundException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testSyntax() {
        //String[] in = {"C:\\Users\\amalone46\\git\\CS3114-Project1\\p1\\CS3114-Project1\\src\\SyntaxTest.txt" };
        String[] in = {"SyntaxTest.txt"};
        try {
            Rectangle1.main(in);
        } catch (FileNotFoundException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }
}
