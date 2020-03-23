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

    @Override
    public long size() {
        return 0;
    }

    @Override
    public void initialize(String source) {

    }

    @Override
    public IDnaStrand getInstance(String source) {
        return null;
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
