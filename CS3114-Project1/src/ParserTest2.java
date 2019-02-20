import java.io.File;

import org.junit.Test;

import student.TestCase;

/**
 * @author abbym1
 * @author juliam8
 * @version 2019-02-14
 */
public class ParserTest2 extends TestCase {

    /**
     * Test method for {@link Parser#Parser(java.io.File, BSTRectangle)}.
     */
    @Test
    public void testParser() {
        BSTRectangle<RectKey, RectData> tBST;
        tBST = new BSTRectangle<RectKey, RectData>();
        
        assertEquals(tBST.nodeCount(), 0);
        assertEquals(tBST.root(), null);
        
        File tFile = new File("src//ParserTestFile.txt");
        
        assertNotNull(tFile);
        
        Parser myParse = new Parser(tFile, tBST);
        
        assertEquals(tBST.nodeCount(), 0);
        assertEquals(myParse.mBST.root(), null);
    }

    /**
     * Test method for {@link Parser#execute()}.
     */
    @Test
    public void testExecute() {
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
