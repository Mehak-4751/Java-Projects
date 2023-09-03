package tech.codingclub;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class Task8 {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Task6 running at " + new Date().toString() + " sharp.");

        LinkedList<String> linkedList=new LinkedList<String>();
        linkedList.add("This");
        linkedList.add("is");
        linkedList.add("a");
        linkedList.add("Java");
        linkedList.add("Program");

        //We can't use get() function because it takes more complexity O(n^2) while iterator takes O(n)
        Iterator<String> itr=linkedList.iterator();
        System.out.println("Linked list elements : ");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        String first=linkedList.getFirst();
        String last=linkedList.getLast();
        int size=linkedList.size();
        System.out.println(first + " : " + last + " : " + size);
    }
}
