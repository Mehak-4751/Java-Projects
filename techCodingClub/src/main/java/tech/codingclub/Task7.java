package tech.codingclub;

import java.util.ArrayList;
import java.util.Date;

public class Task7 {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Task6 running at " + new Date().toString() + " sharp.");

        ArrayList<String> arrayList=new ArrayList<String>();
        //adding elements to arraylist
        arrayList.add("Welcome");
        arrayList.add("to");
        arrayList.add("the");
        arrayList.add("Coders");
        arrayList.add("Family");
        arrayList.add("RemoveMe");

        //accessing elements
        System.out.println("Length of arraylist : " + arrayList.size());
        System.out.println("Last element of arraylist : " + arrayList.get(arrayList.size()-1));

        System.out.println("Arraylist elements : ");
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }

        arrayList.remove(arrayList.size()-1);
        //update
        arrayList.set(arrayList.size()-1,"Coding Club");
        System.out.println("Length of arraylist after removing : " + arrayList.size());
        System.out.println("Arraylist elements : ");
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        arrayList.clear();
        System.out.println("Length after clearing : " + arrayList.size());
    }
}
