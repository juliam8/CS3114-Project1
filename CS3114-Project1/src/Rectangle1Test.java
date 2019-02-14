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
	    //String[] in1 = {"C:\\Users\\amalone46\\git\\CS3114-Project1\\p1\\CS3114-Project1\\src\\GeneralTest.txt" };
		String[] in1 = {"src//GeneralTest.txt"};
		try {
			Rectangle1.main(in1);
		} catch (FileNotFoundException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		//String in2[] = {"C:\\Users\\amalone46\\git\\CS3114-Project1\\p1\\CS3114-Project1\\src\\CoverageTest.txt" };
        /*String[] in2 = {"CoverageTest.txt"};
        try {
            Rectangle1.main(in2);
        } catch (FileNotFoundException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }*/
	}
}
