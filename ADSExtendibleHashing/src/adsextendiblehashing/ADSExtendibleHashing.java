package adsextendiblehashing;

import java.util.ArrayList;

public class ADSExtendibleHashing {
    public static void main(String[] args) {
        Directory d = new Directory(2);
        ArrayList<Integer> elements = new ArrayList();
        ArrayList<Integer> elements2 = new ArrayList();
        elements.add(16);
        /*elements.add(32);
        elements.add(48);
        elements.add(64);
        elements.add(80);
        elements.add(12);
        elements.add(20);
        
        elements.add(23);
        elements.add(31);
        elements.add(15);
        elements.add(7);
        elements.add(3);
        elements.add(63);
        */
        d.insert(elements);
        //System.out.println("------------------------------------------------------------------------");
        //d.search(16);
        //elements2.add(127);
        //d.insert(elements2);
        d.search(16);
        d.delete(16);
        //System.out.println("/*/*/*/*/*//*/*/*/**/*/*/*/*//*/*/*/**/*/*/*/*//*/*/*/**/*/*/*/*//*/*/*/*");
        //d.search(3);
    }
}
