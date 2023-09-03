package tech.codingclub;

import java.util.Date;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Program running at " + new Date().toString() + " sharp.");

        int a=10;
        int b=20;
        System.out.println("Addition of a and b : " + (a+b));
        System.out.println("Subtracion of a and b : " + (a-b));
        System.out.println("Multiplication of a and b : " + (a*b));
        System.out.println("Division of a and b : " + (a/b));

        int x=-10;
        System.out.println("Math.abs() : " + Math.abs(x));
        double y=2.34;
        System.out.println("Math.ceil() : " + Math.ceil(y));
        System.out.println("Math.floor() : " + Math.floor(y));
        System.out.println("Math.min() : " + Math.min(2,3));
        System.out.println("Math.max() : " + Math.max(2,3));
        System.out.println("PI value : " + Math.PI);
        System.out.println("Random values between 0 and 1 : " + Math.random());
        int z = 10+(int)(Math.random()*90);
        System.out.println("Random values between 10 and 100 : " + z);

        int c=100;
        System.out.println("Post increment : " + c++);
        System.out.println("Pre increment : " + ++c);

        int i=1,ans=1;
        while(i<=5){
            ans*=i;
            i++;
        }
        System.out.println("Factorial 5! : " + ans);
    }

}
