

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 *
 */
public class RectKey implements Comparable<RectKey> {

    /**
     * Constructor for the RectData class 
     * Sets the private member variables coordinates, x, y, w, and h
     * @param s the name of the key
     */
    RectKey(String s) {
        name = s;
    }

    /**
     * Overwritten comparison function for RectKey
     * @param key the key sent in to compare
     * @return the integer value to determine the comparison
     */
    @Override
    public int compareTo(RectKey key) {
        return name.compareTo(key.name());
    }

    /**
     * Overwritten function to print out the key
     * @return the string of the name to print
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Returns the name of the key
     * @return the private member variable key
     */
    public String name() {
        return name;
    }

    private String name;
}
