// On my honor:
//
// -I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// -All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// -I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
//
//Signed: Abagale Rane Malone, Julia Mahon Kuzin


import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author abbym1 - Abagale Malone (abbym1@vt.edu)
 * @author juliam8 - Julia Mahon Kuzin (juliam8@vt.edu)
 * @version 2019-02-19
 * This is the main class for CS3114 P1
 */
public class Rectangle1 {    
    /**
     * This is the main function of project 1
     * Compiler: javac
     * JDK: 11.0.2
     * OS: Windows 10
     * Completed: 02/19/2019
     * @param args  input string array
     * @throws FileNotFoundException
     * 
     * This program runs commands that operate on a BST
     * The BST stores rectangle objects that have names
     * and data (x, y, w, h). Valid commands are insert, 
     * remove (name), remove (data), search, and dump
     * which all operate as expected with a generic tree 
     * data structure. Two additional commands that are 
     * more specialized to rectangle objects are
     * intersections (find rectangles that intersect) and 
     * regionsearch (find all rectangles in a given region)
     * The valid "world" for rectangles is a grid starting
     * at (0, 0) and ending at (1024, 1024). BSTRectangle 
     * inherits from the generic BST to implement these
     * specialized commands
     */
    public static void main(String[] args) throws FileNotFoundException {
        // bstRect is the binary search tree used 
        // to store nodes containing rectangle information
        BSTRectangle<RectKey, RectData> bstRect;
        bstRect = new BSTRectangle<RectKey, RectData>();
        
        // parse is a Parser object used to interpret the 
        // input file contents and execute commands
        Parser parse = new Parser(new File(args[0]), bstRect);
        parse.execute();
    }
}