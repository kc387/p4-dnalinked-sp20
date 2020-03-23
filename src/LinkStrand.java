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
     * Initialize this strand so that it represents the value of source. No
     * error checking is performed.
     *
     * @param source
     *            is the source of this enzyme
     */

    @Override
    public long size() {
        return 0;
    }

    @Override
    public void initialize(String source) {

    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        return null;
    }

    @Override
    public IDnaStrand reverse() {
        return null;
    }

    @Override
    public int getAppendCount() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }
}
