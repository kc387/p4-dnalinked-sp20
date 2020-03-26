/*
authors: Kathleen Chen & Samy Boutouis
 */

public class LinkStrand implements IDnaStrand {

    private class Node {
        String info;
        Node next;

        public Node (String s, Node n) {
            info = s;
            next = n;
        }
    }

    private Node myFirst, myLast, myCurrent;
    private long mySize;
    private int myAppends, myIndex, myLocalIndex;

    /**
     * Create an empty strand.
     */
    public LinkStrand(){
        this("");
    }

    /**
     * Create a strand representing s. No error checking is done to see if s
     * represents valid genomic/DNA data.
     *
     * @param s
     *            is the source of cgat data for this strand
     */
    public LinkStrand(String s) {
        initialize(s);
    }

    /**
     * @return the number of string characters in the LinkStrand
     */
    @Override
    public long size() {
        return mySize;
    }

    /**
     * Initialize this strand so that it represents the value of source. No
     * error checking is performed.
     *
     * @param source is the source of this enzyme
     */
    @Override
    public void initialize(String source) {
        myFirst = new Node(source, null);
        myLast = myFirst;
        mySize = source.length();
        myAppends = 0;
        myCurrent = myFirst;
        myIndex = 0;
        myLocalIndex = 0;
    }

    /**
     * Create a new LinkStrand with a specified source of dna
     *
     * @param source is the dna that would be put into the LinkStrand
     *
     * @return a new LinkStrand with the dna specified in the parameter
     */
    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    /**
     * Mutates the LinkStrand by adding the dna to the end of the linked list with the original dna as well
     *
     * @param dna is the string of characters of dna that is to be added to the end of this strand
     *
     * @return the original LinkStrand object with the new dna appended
     */
    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node(dna, null);
        myLast = myLast.next;
        mySize = mySize + dna.length();
        myAppends += 1;
        return this;
    }

    /**
     * Mutates the LinkStrand by reversing all the characters and nodes within the LinkStrand
     *
     * @return a new LinkStrand with the characters of the original LinkStrand reversed
     */
    @Override
    public IDnaStrand reverse() {
        LinkStrand rev = new LinkStrand();
        Node list = myFirst;
        while(list != null){
            StringBuilder copy = new StringBuilder(list.info);
            copy.reverse();
            String reverse = copy.toString();
            rev.myFirst = new Node(reverse, rev.myFirst);
            list = list.next;
        }
        return rev;
    }

    /**
     * Creates a string with the characters from the DNA strand concatenated together
     *
     * @return a string with all the characters of the DNA LinkStrand
     */
    @Override
    public String toString() {
        StringBuilder strand = new StringBuilder();
        Node list = myFirst;
        while(list != null){
            strand.append(list.info);
            list = list.next;
        }
        mySize = strand.toString().length();
        return strand.toString();
    }

    /**
     * Used to return the number of times the append method was performed on the LinkStrand object
     *
     * @return number of appends performed on the object
     */
    @Override
    public int getAppendCount() {
        return myAppends;
    }

    /**
     * Used to return the character at a specific index in the strand and throws an out of bound error if the index
     * is invalid
     *
     * @param index is the index of the character that is desired in the strand
     *
     * @return character at the index in the strand
     */
    @Override
    public char charAt(int index) {
        if(index >= 0 && index < mySize) {
            if (index < myIndex) {
                myCurrent = myFirst;
                myLocalIndex = 0;
                myIndex = 0;
            }
            while (myIndex != index) {
                myIndex++;
                myLocalIndex++;
                if (myLocalIndex >= myCurrent.info.length()) {
                    myLocalIndex = 0;
                    myCurrent = myCurrent.next;
                }
            }
            return myCurrent.info.charAt(myLocalIndex);
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

}
