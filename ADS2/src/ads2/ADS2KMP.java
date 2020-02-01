package ads2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ADS2KMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose: 1.Custom input  2.Customer review analysis ");
        int option = sc.nextInt();
        switch(option){
            case 1:
                String text="";
                try{
                    File file = new File("C:\\Users\\RV\\Documents\\NetBeansProjects\\ADS2\\src\\ads2\\kmpTestCase.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file)); 
                    String st;
                    while ((st = br.readLine()) != null){
                        text+=st;
                        }
                    }
                catch(FileNotFoundException e){
                    System.out.println("FILE NOT FOUND!!");
                    }
                catch(IOException e){
                    System.out.println("IO Exception");
                }
                String pattern="gggccgactgtcttccgtccctatgtaatga";
                int totalOcc = searchKMP(text,pattern);
                System.out.println("TOTAL OCCURENCES: "+totalOcc);
                break;
            case 2:
                String goodWords[] ={"Good","Great","fabulous"};
                String badWords[] ={"TERRIBLE","bad","hate"};
                String text1="";
                try{
                    text1= new String(Files.readAllBytes(Paths.get("C:\\Users\\RV\\Documents\\NetBeansProjects\\ADS2\\src\\ads2\\customer.csv")));
                }
                catch(Exception e){
                    System.out.println(""+e);
                }
                int good=0;
                int bad=0;
                for (String goodWord : goodWords) {
                    good += searchKMP(text1, goodWord);
                }
                for (String badWord : badWords) {
                    bad += searchKMP(text1, badWord);
                }
                System.out.println("TOTAL GOOD = "+good);
                System.out.println("TOTAL GOOD = "+bad); 
                if(good>bad){
                    System.out.println("SENTIMENT: GOOD");
                }
                else{
                    System.out.println("SENTIMENT: BAD");
                }
                break;
        }
        
    }

    private static int searchKMP(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] pie = computePieTable(pattern);
        int q=0;
        int counter=0;
        for(int i = 0; i<n; i++){
            while(q>0 && !Character.toString(pattern.charAt(q)).equals(Character.toString(text.charAt(i)))){
                q=pie[q];
            }
            if(Character.toString(pattern.charAt(q)).equals(Character.toString(text.charAt(i)))){
                q++;
            }
            if(q==m){
                System.out.println("Pattern: "+ pattern+" found at shift: "+ (i-m+1));
                q = pie[q];
                counter++;
            }
        }
        return counter;
    }

    private static int[] computePieTable(String pattern) {
        int m = pattern.length();
        int pie[] = new int[1000];
        pie[1]=0;
        int k = 0;
        for(int q=2; q<m; q++){
            while(k>0 && !Character.toString(pattern.charAt(k+1)).equals(Character.toString(pattern.charAt(q)))){
                k = pie[k];
            }
            if(Character.toString(pattern.charAt(k+1)).equals(Character.toString(pattern.charAt(q)))){
                k++;
            }
            pie[q]=k;
        }
        return pie;
    }
}