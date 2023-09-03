package tech.codingclub;

import java.util.Date;

public class SingletonAndExceptionExample {
    public static void main(String[] args){
        System.out.println("This is Mehak Garg");
        System.out.println("This program running at " + new Date().toString() + " sharp.");

        SingletonExample.main(null);
        ExceptionExample.main(null);
    }
}
