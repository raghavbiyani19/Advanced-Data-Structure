package ads1;

import java.util.ArrayList;

public class HashTable {
    public static String[] hashValues(ArrayList<Integer> allKeys, ArrayList<String> mytokens, ArrayList<Integer> temp,String answer[]) {
        
        ArrayList<Integer> address = new ArrayList<>();
        int flag = 0;
        
        for(int key : allKeys){
            //System.out.println("IN---1");
            int addr = key%97;
            if(!temp.contains(addr)){
                //System.out.println("IN---2");
                temp.add(addr);
                address.add(addr);
            }
            else{
                //System.out.println("IN---3");
                while(flag!=1){
                    //System.out.println("IN---4");
                    int z = addr+1;
                    if(!temp.contains(addr)){
                        //System.out.println("IN---5");
                        temp.add(addr);
                        address.add(addr);
                        flag=1;
                    }
                    else{
                        //System.out.println("IN---6");
                        z++;
                    }
                }
            }
        }
        //System.out.println("HOLAAAAAAAAAAAAAA");
        System.out.println("ADDRESSES:");
        System.out.println(address);
        //System.out.println("ADDRESSES DONE");
        
        int l = 0;
        for(int myind : address){
            //System.out.println(mytokens.get(l));
            answer[myind] = mytokens.get(l);
            l++;
        }
        
        System.out.println("HASH TABLE:");
        for(int x=0; x<100; x++){
            System.out.println(x+"------->"+answer[x]);
        }
        
        return answer;
    }
    
    public static int searchToken(String searchElement,String[] finalAnswer){
        int key=0;
        String cloneSearch = searchElement;
        int len = searchElement.length();
        //System.out.println(""+token);
        if(len<=10){
            int toadd=10-len;
            for(int j=toadd;j>0;j--){
                searchElement+="*";
            }
        }
        else{
            searchElement = searchElement.substring(0,9);
        }
        /*for(int v=0; v<100; v++){
            System.out.println(v+"------------------------>"+finalAnswer[v]);
        }*/
        for(int k=0; k<searchElement.length(); k++){
               char c = searchElement.charAt(k);
               int value = c;
               key+=value;
           }
        int attempts=0;
        int searchAddr = key%97;
        System.out.println("SEARCHING AT......."+searchAddr);
        if(finalAnswer[searchAddr] == null || !cloneSearch.equalsIgnoreCase(finalAnswer[searchAddr])){
            attempts++;
            int searchFlag=0;
            searchAddr = searchAddr+1;
            while(searchFlag!=1){
                if(finalAnswer[searchAddr] != null && finalAnswer[searchAddr].equalsIgnoreCase(cloneSearch)){
                    return searchAddr;
                }
                else{
                    if(searchAddr<finalAnswer.length-1){
                    System.out.println("SEARCHING AT......."+searchAddr);
                    attempts++;
                    searchAddr++;   
                    }
                    else{
                        searchFlag=1;
                        return -1;
                    }
                }
            }
        }
        else{
            return searchAddr;
        }
        return -1;
    }

    static void deleteToken(int deleteVerify, String[] finalAnswer) {
        finalAnswer[deleteVerify] = null;
        for(int v=0; v<100; v++){
            System.out.println(v+"------------------------>"+finalAnswer[v]);
        }
    }
}