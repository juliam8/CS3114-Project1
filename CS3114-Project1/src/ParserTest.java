import static org.junit.Assert.*;

import java.io.File;


import org.junit.Test;

/**
 * 
 */

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 *
 */
public class ParserTest {
      
    /**
     * Test method for {@link Parser#execute()}.
     */
    @Test
    public void executeTest() {
        BSTRectangle<RectKey, RectData> tBST;
        tBST= new BSTRectangle<RectKey, RectData>();
        File tFile = new File("src//ParserTestFile.txt");
        assertNotNull(tFile);
        
        Parser myParse = new Parser(tFile, tBST);
        
        myParse.execute();
    }
}
