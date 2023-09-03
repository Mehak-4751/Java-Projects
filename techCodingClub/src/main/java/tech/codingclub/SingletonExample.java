package tech.codingclub;

public class SingletonExample {
    public static void main(String[] args) {
        Singleton obj1=Singleton.getinstance(23);
        Singleton obj2= Singleton.getinstance(45);
        obj1.data=23;
        obj2.data=45;
        //Not a singleton till now.
        System.out.println(obj1.data + " " + obj2.data);
    }
}
