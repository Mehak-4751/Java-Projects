package tech.codingclub;

import java.util.Date;
import java.util.Random;

public class Task6 {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Task6 running at " + new Date().toString() + " sharp.");

        Random random = new Random();
        int x = random.nextInt(100);
        System.out.println("Random values b/w 0-99 : " + x);
        int y = 50 + random.nextInt(50);
        System.out.println("Random values b/w 50-99 : " + y);

        String s = "HelloWorld";
        System.out.println("Printing String : " + s);
        s += '!';
        System.out.println("Printing Modified String : " + s);

        System.out.println("Length of the String : " + s.length());
        System.out.println("Substring from 5 to end : " + s.substring(5));
        System.out.println("Substring from 5-6 index : " + s.substring(5, 7));

        System.out.println("String to uppercase : " + s.toUpperCase());
        System.out.println("String to lowercase : " + s.toLowerCase());

        int idx = s.indexOf('W');
        System.out.println("Index of 'W' character in 'HelloWorld' string : " + idx);
        char ch = s.charAt(5);
        System.out.println("Character at index 5 of string 'HelloWorld' : " + ch);
        String s1 = "abc";
        String s2 = "abd";
        System.out.println("Comparing s1 with s2 : " + s1.compareTo(s2));

        Date date=new Date();
        long prevEpochTime=date.getTime();
        for(int i=0;i<1000000;i++){

        }
        long currentEpochTime=new Date().getTime();
        System.out.println("Time taken by loop to run : " + (currentEpochTime-prevEpochTime) + " milliseconds");
        System.out.println("Time at 1642484402329 epoch time : " + new Date(1642484402329L).toString());
    }
}
