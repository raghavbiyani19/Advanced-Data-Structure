class Node{
    boolean leafis;
    int[] key;
    Node[] child;
    int numberofkey;

    Node(int t) {
        key=new int[2*t-1];
        child=new Node[2*t];
    }
}