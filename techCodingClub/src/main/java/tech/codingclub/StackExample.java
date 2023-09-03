package tech.codingclub;

import java.util.Date;
import java.util.Iterator;
import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Task6 running at " + new Date().toString() + " sharp.");

        Stack<Integer> stackInteger=new Stack<Integer>();
        stackInteger.push(1);
        stackInteger.push(2);
        stackInteger.push(5);
        stackInteger.push(101);

        int topElement=stackInteger.peek();
        System.out.println("TopMost element of stack : " + topElement);
        int topMostPoppedElement=stackInteger.pop();
        System.out.println("TopMost popped Element : " + topMostPoppedElement);

        Iterator<Integer> itr=stackInteger.iterator();
        System.out.println("Using iterator printing stack elements");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("Index of 1 : " + stackInteger.search(1));
        System.out.println("Index of 100 : " + stackInteger.search(100));

        System.out.println("Using pop function printing stack elements");
        while(!stackInteger.empty()){
            System.out.println(stackInteger.pop());
        }
    }

}
