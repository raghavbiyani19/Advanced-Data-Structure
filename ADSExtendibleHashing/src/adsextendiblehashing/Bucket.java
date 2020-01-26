package adsextendiblehashing;

import java.util.ArrayList;

public class Bucket {
    
    int localDepth;
    ArrayList<Integer> values;
    String address;
    int BucketSize;
    
    Bucket(String address){
        this.address = address;
        BucketSize = 5;
        localDepth = 2;
        values = new ArrayList();
    }

    int searchElement(int element1) {
        //System.out.println("SEARCHING IN BUCKET.");
        for(int val : values){
            System.out.println("BUCKET ELEMENTS:  "+val);
            if(val==element1){
                return 1;
            }
        }
        return -1;
    }

    boolean putInBucket(int element1) {
        if(values.size()<5){
        System.out.println("INSERTING THE ELEMENT "+element1);
        values.add(element1);
        return true;
        }
        //System.out.println("BUCKET: "+address);
        //System.out.println("LOCAL DEPTH: "+localDepth);
        //System.out.println("Trying next bucket.");
        return false;
    }
    
}