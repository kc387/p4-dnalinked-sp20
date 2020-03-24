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

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;

    /*public LinkStrand(){
        this("");
    }*/
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

    public LinkStrand(){
        this("");
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
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        myLast = new Node(dna, myFirst);
        mySize = mySize + dna.length();
        myAppends += 1;
        return this;
    }

    @Override
    public IDnaStrand reverse() {
        return null;
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }
}
