package ads1;

import java.util.ArrayList;

public class Standardize {
    public static ArrayList standardize(ArrayList<String> mytokens){
        ArrayList standardizedtokens = new ArrayList<>();
        for(String token : mytokens){
            int len = token.length();
            //System.out.println(""+token);
            if(len<=10){
                int toadd=10-len;
                for(int j=toadd;j>0;j--){
                    token+="*";
                }
            }
            else{
                token = token.substring(0,9);
            }
            //System.out.println(""+token);
            standardizedtokens.add(token);
        }
        return standardizedtokens;
    }
}
