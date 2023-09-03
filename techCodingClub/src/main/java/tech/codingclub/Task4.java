package tech.codingclub;

import java.util.Date;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Program running at " + new Date().toString() + " sharp.");

        int arr[] = {1,2,3,4,5};
        arr[arr.length-1]=7;
        System.out.println("Last value of array : " + arr[arr.length-1]);

        int a[][]={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Multidimensional Array element at (1,1) index : " + a[1][1]);

        Scanner scan=new Scanner(System.in);
        System.out.print("Enter x : ");
        int x=scan.nextInt();
        System.out.print("Enter y : ");
        int y= scan.nextInt();
        System.out.println("Sum of x and y  : " + (x+y));
    }

}
