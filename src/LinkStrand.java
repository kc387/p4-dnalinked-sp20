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
        myFirst = new Node(source, myLast);
        myLast = myFirst;
        mySize = source.length();
        myAppends = 0;
        myCurrent = myFirst;
        myIndex = 0;
        myLocalIndex = 0;
    }

    /**
     * @return the number of string characters in the LinkStrand
     */
    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node(dna, null);
        myLast = myLast.next;
        mySize = mySize + dna.length();
        myAppends += 1;
        return this;
    }

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

    @Override
    public String toString() {
        StringBuilder strand = new StringBuilder();
        Node list = myFirst;
        while(list != null){
            strand.append(list.info);
            list = list.next;
        }
        return strand.toString();
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        if(index < myIndex){
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

}
