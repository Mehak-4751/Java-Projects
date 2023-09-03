package tech.codingclub;

import java.util.Date;

public class Car implements CarInteface {
    public static final int maxSpeed=300;
    private int currentSpeed;
    static int wheelCount=4;
    String numberPlate;

    public Car(){
        currentSpeed=0;
    }

    public Car(String numberPlate){
        this.numberPlate=numberPlate;
    }

    public Car(String numberPlate,int currentSpeed){
        this.numberPlate=numberPlate;
        this.currentSpeed=currentSpeed;
    }

    public void accelerate(){
        System.out.println("Speeding up!");
        currentSpeed+=10;
    }

    @Override
    public void applyBrakes() {
        currentSpeed=0;
    }

    public int getSpeed(){
        return currentSpeed;
    }

    public void increaseSpeed(int x){
        if(x<0) return;

        currentSpeed+=x;
        if(currentSpeed>=maxSpeed){
            currentSpeed=maxSpeed;
        }
    }

    public static void printWheels(){
        System.out.println("Car has " + wheelCount + " wheels.");
    }

    public static void main(String[] args) {
        /*System.out.println("This is Mehak Garg");
        System.out.println("Car class running at " + new Date().toString() + " sharp.");

        Car audi=new Car("AUDI 0098",50);
        audi.accelerate();
        System.out.println("AUDI Current speed : " + audi.currentSpeed);
        System.out.println("AUDI Wheels : " + audi.wheelCount);

        Car bmw=new Car("BMW 3456",100);
        bmw.accelerate();
        bmw.currentSpeed+=100;
        System.out.println("BMW Current speed : " + bmw.currentSpeed);

        bmw.wheelCount=8;
        System.out.println("AUDI Wheels : " + audi.wheelCount);
        System.out.println("BMW wheels : " + bmw.wheelCount);
        System.out.println("Static variable Wheelcount independent of the object : " + Car.wheelCount);
        Car.printWheels();
        bmw.printWheels();*/
    }

}
