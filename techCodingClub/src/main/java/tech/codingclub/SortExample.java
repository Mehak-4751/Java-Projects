package tech.codingclub;

import java.util.*;

public class SortExample {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Task6 running at " + new Date().toString() + " sharp.");

        int arr[] = {100,34,50,23,45};
        Arrays.sort(arr);
        System.out.println("Array after sorting : ");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

        ArrayList<String> emails=new ArrayList<String>();
        emails.add("contact@codingclub.com");
        emails.add("admin@linkedin.com");
        emails.add("admin@google.com");
        Collections.sort(emails);
        System.out.println("ArrayList after sorting : ");
        for(String x:emails){
            System.out.println(x);
        }
    }
}
