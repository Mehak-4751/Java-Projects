package tech.codingclub;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Debugging {

    public static void main(String[] args) throws IOException {
        int n=10;
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        System.out.println("Sum till N numbers : " + sum);

        Singleton o1=Singleton.getinstance(23);
        Singleton o2=Singleton.getinstance(45);
        System.out.println((o2.data+sum));

        int x=sum;
        int y=45; //45
        System.out.println((x+y) + " must be 100");

        FileInputStream fstream = new FileInputStream("C:\\Users\\hp\\IdeaProjects\\TechCodingMafia\\src\\main\\java\\tech\\codingclub\\Debugging.java");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

//Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console - do what you want to do
            System.out.println (strLine);
        }

//Close the input stream
        fstream.close();
    }

}
