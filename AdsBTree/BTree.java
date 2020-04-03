class BTree {

    int t;
    int minkeys, maxkeys, minchild, maxchild;
    Node root;

    BTree(int t) {
        this.t = t;
        minkeys = t - 1;
        maxkeys = 2 * t - 1;

    }

    void CreateEmpty() {
        Node x = new Node(t);
        x.leafis = true;
        x.numberofkey = 0;
        root = x;
    }

    void SplitChild(Node x, int i) {
        Node z = new Node(t);
        Node y = x.child[i];
        z.leafis = y.leafis;
        z.numberofkey = t - 1;

        for (int j = 0; j <= t - 2; j++) {
            z.key[j] = y.key[j + t];
        }
        if (!y.leafis) {
            for (int j = 0; j <= t - 1; j++) {
                z.child[j] = y.child[j + t];
            }
        }
        y.numberofkey = t - 1;
        for (int j = x.numberofkey; j >= i+1; j--) {
            x.child[j + 1] = x.child[j];
        }
        x.child[i + 1] = z;
        for (int j = x.numberofkey - 1; j >= i ; j--) {
            x.key[j + 1] = x.key[j];
        }
        x.key[i] = y.key[t-1];
        x.numberofkey = x.numberofkey + 1;
    }

    void Insert(int k) {
        Node r = root;

        if (r.numberofkey == 2 * t - 1) {
            Node s = new Node(t);
            root = s;
            s.leafis = false;
            s.numberofkey = 0;
            s.child[0] = r;
            SplitChild(s, 0);
            InsertNonFull(s, k);
        } else {
            InsertNonFull(r, k);
        }
    }

    void InsertNonFull(Node x, int k) {
        int i = x.numberofkey -1;
        if (x.leafis) {
            while (i >= 0 && k < x.key[i]) {
                x.key[i + 1] = x.key[i];
                i--;
            }
            x.key[i + 1] = k;
            x.numberofkey = x.numberofkey + 1;
        } else {

            while (i >= 0 && k < x.key[i]) {
                i--;
                // System.out.println(i);
            }
            i++;
            //System.out.println(i);
            if (x.child[i].numberofkey == 2 * t - 1) {
                SplitChild(x, i);
                if (k > x.key[i]) {
                    i++;
                }
            }
            InsertNonFull(x.child[i], k);
        }
    }

    int[] Search(Node x, int k) {
        int i = 0;
        while (i <= x.numberofkey && k > x.key[i]) {
            i++;
        }
        if (i <= x.numberofkey && k == x.key[i]) {
            return x.key;
        } else if (x.leafis) {
            return null;
        } else {
            return Search(x.child[i], k);
        }
    }

    void traverse(Node r) {
        int i=0;
        System.out.println("Node "+r);
        for (i = 0; i < r.numberofkey; i++) {
            System.out.println(" key--> " + r.key[i]);
        }
        for (i = 0; i < r.numberofkey; i++) {
            if (r.leafis == false) {
                traverse(r.child[i]);
            }
        }

        if (r.leafis == false)
            traverse(r.child[i]);
    }

}