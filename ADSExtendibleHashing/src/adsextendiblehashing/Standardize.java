package adsextendiblehashing;

import java.util.ArrayList;

public class Standardize {
    public static ArrayList<String> getKeys(int gf){
        ArrayList<String> keys = new ArrayList();
        //String keys[] = new String[Math.pow(2,gf)];
        for(int z=0; z<Math.pow(2,gf); z++){
            String temp = Integer.toBinaryString(z);
            int toAdd = gf-temp.length();
            for(int x=0; x<toAdd; x++){
                temp = "0"+temp;
            }
            keys.add(temp);
        }
        return keys;
    }
}
