class Main{
    public static void main(String[] args) {
        BTree tryBtree=new BTree(3);
        tryBtree.CreateEmpty();
        tryBtree.Insert(40);
        tryBtree.Insert(80);
        tryBtree.Insert(90);
        tryBtree.Insert(20);
        tryBtree.Insert(10);
        tryBtree.Insert(55);
        tryBtree.Insert(66);
        tryBtree.Insert(22);
        tryBtree.Insert(33);

        System.out.println("Traversal of BTree\n");

        tryBtree.traverse(tryBtree.root);
    }
}