import java.util.Arrays;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 *
 */
public class RectData implements Comparable<RectData> {

    /**
     * Constructor for the RectData class 
     * Sets the private member variables coordinates, x, y, w, and h
     * @param i the coordinates of the rectangle
     */
    RectData(int[] coordinates) {
        rectCoordinates = coordinates;
        x = coordinates[0];
        y = coordinates[1];
        width = coordinates[2];
        height = coordinates[3];
    }

    /**
     * Overwritten comparison function for RectData
     * @param nodeData the data sent in to compare
     * @return the integer value to determine the comparison
     */
    @Override
    public int compareTo(RectData nodeData) {
        if (Arrays.equals(rectCoordinates, nodeData.coordinates())) {
            return 0;
        }
        else {
            return 1;
        }
    }

    /**
     * Overwritten function to print out the data
     * @return the string of data to print
     */
    @Override
    public String toString() {
        return x + ", " + y + ", " + width + ", " + height;
    }

    /**
     * Returns the coordinates
     * @return the coordinates
     */
    public int[] coordinates() {
        return rectCoordinates;
    }

    /**
     * Returns the x coordinate
     * @return the x coordinate integer
     */
    public int x() {
        return x;
    }

    /**
     * Returns the y coordinate
     * @return the y coordinate integer
     */
    public int y() {
        return y;
    }

    /**
     * Returns the width of the rectangle
     * @return the width value
     */
    public int w() {
        return width;
    }

    /**
     * Returns the height of the rectangle
     * @return the height value
     */
    public int h() {
        return height;
    }

    // private member variables
    private int x;
    private int y;
    private int width;
    private int height;
    private int[] rectCoordinates;
}
