/*
A C program file is given as input.
A C program consist of tokens that are strings that appear between successive occurences of a delimiting character given by: 
F = {!,",#,%,&,*,+,-,;,<,>,=,?,[,],{,},space}
If a string has less than 10 char, make it upto 10 characters by adding an appropriate number of trailing *.
On the other hand, if a string has more than 10 char then truncate it to have the first 10 characters only.
From the individual char strings, generate a positive integer by summing up the ASCII values of the characters in the particular token. Use this integer p in the hashing functions.
Store the original token in the hash table.
---> LINEAR PROBING
*/

package ads1;

import java.util.ArrayList;
import java.util.Scanner;

public class ADS1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int option = 0,optionFunction=0;
        
        System.out.println("CHOOSE: 1. LINEAR PROBING 2.EXIT");
        option = sc.nextInt();
        switch(option){
            case 1:
                ArrayList<String> mytokens = new ArrayList<>();
                ArrayList<String> standardizedtoken = new ArrayList<>();
                ArrayList<Integer> keys = new ArrayList<>();
                
                ArrayList<Integer> temp = new ArrayList<>();
                String answer[] = new String[1000];
                String finalAnswer[] = new String[1000];

                mytokens = MyReader.readerfunction();
                standardizedtoken = Standardize.standardize(mytokens);
                keys = Keys.getKeys(standardizedtoken);

                System.out.println("TOKENS:");
                System.out.println(mytokens);
                System.out.println("STANDARD TOKENS:");
                System.out.println(standardizedtoken);
                System.out.println("KEYS:");
                System.out.println(keys);

                finalAnswer = HashTable.hashValues(keys,mytokens,temp,answer);
                
                System.out.println("SELECT: 1.INSERT    2.SEARCH    3.DELETE");
                optionFunction = sc.nextInt();
                switch(optionFunction){
                    case 1:
                        String element1 = "switch";
                        String element2 = "case";
                        ArrayList<String> insertelements = new ArrayList<>();
                        insertelements.add(element1);
                        insertelements.add(element2);
                        ArrayList<Integer> insertkey = new ArrayList<>();
                        insertkey = Keys.getKeys(insertelements);
                        finalAnswer = HashTable.hashValues(insertkey,insertelements,temp,answer);
                        for(int v=0; v<100; v++){
                            System.out.println(v+"------------------------>"+finalAnswer[v]);
                        }
                        break;
                    case 2:
                        String searchElement="void";
                        int searchVerify;
                        searchVerify = HashTable.searchToken(searchElement,finalAnswer);
                        if(searchVerify == -1){
                            System.out.println("ELEMENT NOT PRESENT");
                        }
                        else{
                            System.out.println("ELEMENT PRESENT AT INDEX "+searchVerify);
                        }
                        break;
                    case 3:
                        String deleteElement="printf";
                        int deleteVerify = HashTable.searchToken(deleteElement, finalAnswer);
                        if(deleteVerify==-1){
                            System.out.println("ELEMENT NOT PRESENT");
                        }
                        else{
                            HashTable.deleteToken(deleteVerify,finalAnswer);
                        }
                        break;
                    case 4:
                        break;
                }
            case 2:
                break;
        }
    }
}