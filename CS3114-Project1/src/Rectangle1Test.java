import java.io.FileNotFoundException;
import student.TestCase;

/**
 * @author abbym1
 * @author juliam8
 * @version 2019-02-14
 */

public class Rectangle1Test extends TestCase {

    /**
     * Test method for {@link Rectangle1#main(java.lang.String[])}.
     */
    public void testMain() {
        String[] in1 = {"src//test.txt"};
        assertNotNull(in1);
        try {
            Rectangle1.main(in1);
        } 
        catch (FileNotFoundException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }
}
		
//String in2[] = {"C:\\Users\\amalone46\\git\\CS3114-Project1\\
//p1\\CS3114-Project1\\src\\CoverageTest.txt" };
   // String[] in2 = {"src//CoverageTest.txt"};
   /* try {
    Rectangle1.main(in2);
} catch (FileNotFoundException e) {
    // Auto-generated catch block
    e.printStackTrace();
}*/
