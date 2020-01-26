package ads1;

import java.util.ArrayList;

public class Keys {

    public static ArrayList<Integer> getKeys(ArrayList<String> standardizedtoken) {
        
        int key = 0;
        ArrayList<Integer> keys = new ArrayList<>();
        
        for(String token : standardizedtoken){
           for(int k=0; k<token.length(); k++){
               char c = token.charAt(k);
               int value = c;
               key+=value;
           }
           keys.add(key);
           key = 0;
        }
        return keys;
    }
    
}
