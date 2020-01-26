package adsextendiblehashing;

import java.util.ArrayList;
import java.util.HashMap;

public class Directory {
    
    HashMap<String,Bucket> dir;
    public static int globalDepth;
    
    Directory(int globalDepth){
        this.dir = new HashMap();
        this.globalDepth = globalDepth;
        ArrayList<String> dirKeys = Standardize.getKeys(globalDepth);
        for(int z=0; z<dirKeys.size(); z++){
            //System.out.println("Putting in"+dirKeys.get(z));
            dir.put(dirKeys.get(z),new Bucket(dirKeys.get(z)));
        }
    }
    
    void insert(ArrayList<Integer> elements) {
        
        ArrayList<Integer> leftElements = new ArrayList();
        
        for(int i=0; i<elements.size(); i++){
            System.out.println("");
            System.out.println("--------------------------------------------------------------------------------");
            //System.out.println("In insert function");
            Bucket searchResult = search(elements.get(i));
            if(searchResult == null){
                System.out.println("Already present");
            }
            else{
                System.out.println("Local depth of Bucket: "+ searchResult.address +" is : "+ searchResult.localDepth);
                boolean insertresult = searchResult.putInBucket(elements.get(i));
                if(insertresult == false){
                    
                    if(searchResult.localDepth==globalDepth){
                    globalDepth+=1;
                    resolveColission1(searchResult,globalDepth,elements.get(i));
                    }
                    
                    else{
                        System.out.println("Splitting the buckets...");
                        searchResult.localDepth+=1;
                        ArrayList<String> newDirkeys2 = Standardize.getKeys(globalDepth);
                        //System.out.println("========================="+searchResult.address);
                        String colAdd = searchResult.address;
                        String colAdd2 = "1"+colAdd;
                        //dir.replace(colAdd,dir.get());
                        dir.put(colAdd2,new Bucket(colAdd2));
                        ArrayList<Integer> zz = new ArrayList();
                        zz.add(elements.get(i));
                        insert(zz);
                    }
                   
                }
            }
        }
    }
    
    Bucket search(int element1) {
        //System.out.println("In search function");
        String identifiers="";
        int Homekey = Hash.doHash(element1);
        String temp = Integer.toBinaryString(Homekey);
        temp = "0000000000000"+temp;
        //System.out.println("GLOBAL DEPTH ISSSS"+globalDepth);
        identifiers=temp.substring((temp.length()-globalDepth),temp.length());
        //System.out.println("BEFOREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"+identifiers);
        if(globalDepth>2){
            if("000".equals(identifiers) || "001".equals(identifiers) || "010".equals(identifiers) || "011".equals(identifiers)){
                //identifiers=temp.substring((temp.length()-globalDepth+1),temp.length());
                identifiers=identifiers.substring(1,identifiers.length());
                //System.out.println("AFTERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"+identifiers);
            }
        }
        //int address = Integer.parseInt(identifiers,2);
        Bucket b = dir.get(identifiers);
        //System.out.println("HOMEKEY: "+Homekey);
        //System.out.println("BINARY: "+temp);
        //System.out.println("IDENTIFIERS: "+identifiers);
        //System.out.println("BUCKET: "+identifiers);
        int result = b.searchElement(element1);
        if(result == -1){
            System.out.println("Element not present");
            return b;
        }
        System.out.println("Element found in bucket "+identifiers);
        return null;
    }

    public void resolveColission1(Bucket colissionBucket, int globalDepth, int elementToInsert) {
        
        int globalDepth1 = globalDepth;
        System.out.println("Expanding directory and splitting the buckets...");
        colissionBucket.localDepth+=1;
        System.out.println("Global depth: "+globalDepth1);
        System.out.println("New local depth of Bucket: "+ colissionBucket.address +" is : "+ colissionBucket.localDepth);
        
        for(int z = (int) Math.pow(2,globalDepth1-1); z< Math.pow(2,globalDepth1); z++){
            System.out.println(""+z+"------>"+Integer.toBinaryString(z));
            dir.put(Integer.toBinaryString(z),new Bucket(Integer.toBinaryString(z)));
        }
        ArrayList<String> dirkeys = Standardize.getKeys(globalDepth1-1);
        ArrayList<String> newDirkeys = Standardize.getKeys(globalDepth1);
        
        newDirkeys.remove("000");
        newDirkeys.remove("001");
        newDirkeys.remove("010");
        newDirkeys.remove("011");
        //String key:newDirkeys
        for(int q=0; q<newDirkeys.size(); q++){
            //System.out.println("KEYYYYYYYYYYYYYYYYYYYY"+newDirkeys.get(q));
            String substr = newDirkeys.get(q).substring(1,newDirkeys.get(q).length());
            //System.out.println("SUBBBBBBBBBBBB"+substr);
            if(substr.equals(colissionBucket.address)){
                //System.out.println("REMOVING BUCKET AT "+newDirkeys.get(q));
                newDirkeys.remove(newDirkeys.get(q));
            }
            else{
                //System.out.println("REPLACING BUCKET AT "+newDirkeys.get(q)+" with bucket at"+substr);
                dir.replace(newDirkeys.get(q),dir.get(substr));
            }
        }
        ArrayList<Integer> elementssssss = new ArrayList();
        elementssssss.add(elementToInsert);
        insert(elementssssss);
        
    }
    
    void delete (int element){
        System.out.println("Deleting element "+element);
        Bucket searchResult = Deletesearch(element);
        System.out.println("BEFORE:--------------->"+searchResult.values);
        System.out.println("Bucket issssssssssssssss----->"+searchResult.address);
        int mn = searchResult.values.indexOf(element);
        System.out.println("lolololololololololol------>"+mn);
        searchResult.values.remove(mn);
        System.out.println("AFTER:---------------->"+searchResult.values);
    }

    private Bucket Deletesearch(int element) {
        System.out.println("In delete search");
        String identifiers="";
        int Homekey = Hash.doHash(element);
        String temp = Integer.toBinaryString(Homekey);
        temp = "0000000000000"+temp;
        //System.out.println("GLOBAL DEPTH ISSSS"+globalDepth);
        identifiers=temp.substring((temp.length()-globalDepth),temp.length());
        System.out.println("------------------------------>"+identifiers);
        Bucket b = dir.get(identifiers);
        System.out.println("******************"+b.address);
        int result = b.searchElement(element);
        if(result == 1){
            return b;
        }
        return null;
        
    }
    
}
