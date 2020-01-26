package ads1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MyReader{
    public static ArrayList readerfunction(){
        ArrayList<String> tokenlist = new ArrayList<>();
        String st;
        String regex = "[\\n{}\\s+#&=/,%\"*+-<>.();]";
        try{
            File file = new File("C:\\Users\\RV\\Documents\\NetBeansProjects\\ADS1\\src\\ads1\\abc.txt");
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            while ((st = br.readLine()) != null){
                    String[] tokens = st.split(regex);
                    Collections.addAll(tokenlist,tokens);
                }
        }
        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND!!");
            }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        for(int j=0; j<tokenlist.size(); j++){
            tokenlist.remove("");
        }
        return tokenlist;
    }
}