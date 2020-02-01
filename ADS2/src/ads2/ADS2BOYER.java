package ads2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Scanner;

public class ADS2BOYER {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        HashMap <String,Integer> badCharTable = new HashMap<>();
        
        System.out.println("Choose: 1.Custom Input  2.File Reader");
        int option = sc.nextInt();
        
        switch(option){
            case 1:
                String searchText = "HELLO WORLD";
                String pattern = "OR";                
                Instant ins1 = Instant.now();
                searchBoyerMoore(searchText,pattern,badCharTable);
                Instant ins2 = Instant.now();
                Duration d = Duration.between(ins1, ins2);
                System.out.println(""+d);
                break;
            case 2:
                String st,storyText = "";
                try{
                    File file = new File("C:\\Users\\RV\\Documents\\NetBeansProjects\\ADS2\\src\\ads2\\story.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    while ((st = br.readLine()) != null){
                            storyText+=st;
                        }
                    }
                catch(FileNotFoundException e){
                    System.out.println("FILE NOT FOUND!!");
                    }
                catch(IOException e){
                    System.out.println("IO Exception");
                }
                String storyPattern = "Smith";
                Instant ins3 = Instant.now();
                searchBoyerMoore(storyText,storyPattern,badCharTable);
                Instant ins4 = Instant.now();
                Duration d2 = Duration.between(ins3, ins4);
                System.out.println(""+d2);
                break;
        }
    }

    private static void searchBoyerMoore(String text, String pattern, HashMap badCharTable) {
        
        for(int z = pattern.length()-1; z>=0; z--){
            if(badCharTable.get(pattern.charAt(z)) == null){
                badCharTable.put(Character.toString(pattern.charAt(z)),z);
            }
        }
        
        int m = pattern.length();
        int n = text.length();
        int i = m-1;
        int j = m-1;
        int flag =0;
        
        do{
            if(Character.toString(pattern.charAt(j)).equals(Character.toString(text.charAt(i)))){
                if(j==0){
                    System.out.println("FOUND AT "+ i);
                    i++;
                    flag++;
                }
                else{
                    i -= 1;
                    j -= 1;
                }
            }
            else{
                i = i + m - Min(j , 1+last(Character.toString(text.charAt(i)) , badCharTable ));
                j = m-1;
            }
        }while(i<n);
        
        if(flag == 0){
            System.out.println("NOT FOUND");
        }
        else{
            System.out.println("TOTAL OCCURENCES = "+flag);
        }
    }

    private static int Min(int element1, int element2) {
        if(element1>element2){
            return element2;
        }
        return element1;
    }

    private static int last(String badChar, HashMap badCharTable) {
        int lastOccr;
        if(badCharTable.get(badChar) == null){
            lastOccr = - 1;
        }
        else{
            lastOccr = (int) badCharTable.get(badChar);
        }
        return lastOccr;
    }
    
}
