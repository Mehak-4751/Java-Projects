package tech.codingclub;

import java.util.Date;

public class Task2 {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Program running at " + new Date().toString() + " sharp.");

        int a=10;
        int b=20;
        int c=a+b;
        System.out.println("Sum : " + a + " + " + b + " = " + c);

        double wideningVariable=a;
        System.out.println("Widening Variable : " + wideningVariable);
        wideningVariable+=0.1;
        System.out.println("Modified Widening Variable : " + wideningVariable);

        int narrowingVariable=(int) wideningVariable;
        System.out.println("Narrowing Varaible " + narrowingVariable);

        int maxval=Integer.MAX_VALUE;
        System.out.println("Maximum Value : " + maxval);
        maxval+=1;
        System.out.println("Modified Maximum Value : " + maxval);

        int minval=Integer.MIN_VALUE;
        System.out.println("Min Value : " + minval);
        minval-=1;
        System.out.println("Modified Minimum Value : " + minval);
    }

}
