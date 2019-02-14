import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author abbym1
 * @author juliam8
 * @version 2019-02-14
 * This is the main class for CS3114 P1
 */
public class Rectangle1 {

    /**
     * Constructor for main file
     */
    public Rectangle1() {
        //never instantiated, so nothing is needed here
    }
    
    /**
     * This is the main function of project 1
     * @param args  input string array
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        BSTRectangle<RectKey, RectData> bstRect;
        bstRect = new BSTRectangle<RectKey, RectData>();
        Parser p = new Parser(new File(args[0]), bstRect);
        p.execute();
    }
}