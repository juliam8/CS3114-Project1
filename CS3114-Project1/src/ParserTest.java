import java.io.File;
import student.TestCase;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 *
 */
public class ParserTest extends TestCase {
      
    /**
     * Test method for {@link Parser#execute()}.
     */
    public void executeTest() {
        BSTRectangle<RectKey, RectData> tBST;
        tBST = new BSTRectangle<RectKey, RectData>();
        
        assertEquals(tBST.nodeCount(), 0);
        assertEquals(tBST.root(), null);
        
        File tFile = new File("src//ParserTestFile.txt");
        
        assertNotNull(tFile);
        
        Parser myParse = new Parser(tFile, tBST);
        
        myParse.execute();
        
        assertEquals(tBST.nodeCount(), 1);
    }
}
