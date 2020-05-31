
import java.util.*;  

class CollectionDemo{  
 public static void main(String args[]){  
  ArrayList<String> myList=new ArrayList<String>();//creating arraylist  
  myList.add("Pune");//adding object in arraylist  
  myList.add("Mumbai");  
  myList.add("Delhi");  
  myList.add("Hyderabad");  

   //To get the Index of an Item from arraylist.
 // System.out.println(myList.indexOf("Delhi")); 

   //To remove an Item from arraylist.
 // myList.remove(1);

   //To reset value of an arraylist item. 
  //myList.set(2, "Bangalore");
  
  Iterator<String> itr=myList.iterator();  //getting Iterator from arraylist to traverse elements  
    System.out.println("======"+itr);
  //Printing each elements using Iterator
  while(itr.hasNext()){  
   System.out.println(itr.next());  
  }  
  
  
  
  //Printing Element with for each loop
  for(String obj:myList)  
         System.out.println("+++++++"+obj);  
  }  
} 