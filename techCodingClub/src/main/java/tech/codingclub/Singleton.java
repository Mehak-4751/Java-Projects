package tech.codingclub;

import org.w3c.dom.CDATASection;

//Singleton restricts the initialization to the single instance.
public class Singleton {
    public int data;
    public static Singleton singleton;
    private Singleton(int x){
        data=x;
    }
    public static Singleton getinstance(int x){
        if(singleton==null){
            singleton=new Singleton(x);
        }
        return singleton;
    }
}
