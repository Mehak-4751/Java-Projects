package tech.codingclub;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {

    public static void main(String[] args){
        int x=100;
        Scanner scan=new Scanner(System.in);
        try{
            int y=scan.nextInt();
            int  ans=x/y;
            System.out.println("Ans is : " + ans);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Hello World");

        try{
            int arr[]={1,2,3,4};
            System.out.println(arr[100]);
        }catch(InputMismatchException e){
            System.out.println("InputMismatchException !");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException !" + e.getClass());
        }catch (Exception e){
            System.out.println("Exception Handling " +e.getClass());
        }finally {
            System.out.println("Everything goes good");//it runs everytime either catch block runs or not.
        }
    }

}
