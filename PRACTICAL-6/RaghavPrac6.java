/*
Digital Library Management System
Assuming in a library a book has 5 copies.
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class Library{
ArrayList<PHPBook> Copies = new ArrayList<>();
//List<PHPBook> Copies = new CopyOnWriteArrayList<>();
ArrayList<String> ReturendCopies = new ArrayList<>();
PHPBook book;

public void bookIssue(String Idate,String CopyNo,String Sname){
book = new PHPBook(Idate,CopyNo,Sname);
book.IssueFlag =true;
Copies.add(book);
System.out.println("Copy Number "+CopyNo+" is issued to "+Sname+" .");
}
public void bookReturn(String CopyNo){
ReturendCopies.add(CopyNo);
}

public void Mark(){
Iterator<PHPBook> iter = Copies.listIterator();
Iterator<String> cn = ReturendCopies.listIterator();
String no;

// Marking all the values which are returned copy as IssueFlag is marked as False
while(cn.hasNext()){
no = (String)cn.next();
iter = Copies.listIterator();
while(iter.hasNext()){
book = (PHPBook)iter.next();
if(book.CopyNo.equals(no)){
book.IssueFlag=false;
System.out.println("Returend "+book.CopyNo);
break;
}
}
}
ReturendCopies.removeAll(ReturendCopies);

}

public void Sweep(){
//Sweeping al the marked value by removing all the details of people who have returned the book.

Iterator<PHPBook> iter = Copies.listIterator();
int f =0;
while(iter.hasNext()){
book = (PHPBook)iter.next();
if(book.IssueFlag==false){
f=1;
System.out.println("Copy Number "+book.CopyNo+" is avaliable");
Copies.remove(book);
iter = Copies.listIterator();
}
}

if(f==0)
System.out.println("No copies of PHP Book is avaliable !!!");

}
}

class PHPBook{
String Idate, CopyNo , Sname;
Boolean IssueFlag;

PHPBook(String Idate,String CopyNo,String Sname){
this.Idate = Idate;
this.CopyNo = CopyNo;
this.Sname = Sname;
}
}

public class RaghavPrac6{
public static void main(String arg[]){
Library lib = new Library();
lib.bookIssue("5-04-2020","01","Sam");
lib.bookIssue("10-04-2020","02","Juli");
lib.bookIssue("13-04-2020","03","Den");
lib.bookIssue("6-03-2020","04","Max");
lib.bookIssue("1-04-2020","05","George");

lib.bookReturn("02");
lib.bookReturn("01");
lib.bookReturn("05");

if(lib.Copies.size()==5){
//Calling mark and sweep

lib.Mark();
lib.Sweep();
}
if(lib.Copies.size()!=5)
lib.bookIssue("11-04-2020","05","Jina");
else
System.out.println("Error");

}
}