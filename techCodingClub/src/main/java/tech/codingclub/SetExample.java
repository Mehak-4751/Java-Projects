package tech.codingclub;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Task6 running at " + new Date().toString() + " sharp.");

        ArrayList<String> emails=new ArrayList<String>();
        emails.add("contact@codingclub.com");
        emails.add("admin@linkedin.com");
        emails.add("admin@tictok.com");
        emails.add("admin@linkedin.com");
        emails.add("admin@tictok.com");
        emails.add("admin@google.com");

        Set<String> uniquemails=new HashSet<String>();
        uniquemails.add("hr@google.com");
        uniquemails.addAll(emails);

        System.out.println("Size of set : " + uniquemails.size());
        Iterator<String> itr=uniquemails.iterator();
        System.out.println("Set elements using iterator ");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        ArrayList<String> blackLists=new ArrayList<String>();
        blackLists.add("admin@linkedin.com");
        blackLists.add("admin@tictok.com");
        uniquemails.remove("admin@google.com");
        uniquemails.removeAll(blackLists);
        System.out.println("Size of set : " + uniquemails.size());
        System.out.println("Set elements using for loop ");
        for(String x:uniquemails){
            System.out.println(x);
        }

        System.out.println("Email can be sent to : " + uniquemails.contains("contact@codingclub.com"));
    }

}
