package tech.codingclub;

public class ElectricCar extends Car{
    double battery=100;

    public ElectricCar(){
        super();//calls constructor of inherited class.
    }

    public ElectricCar(String numberPlate){
        super(numberPlate);
    }

    public ElectricCar(String numberPlate,int currentSpeed){
        super(numberPlate,currentSpeed);
    }

    public void accelerate(){
        //polymorphism - overiding
        super.accelerate();
        battery=battery-0.05;
    }

    public static void main(String[] args) {
        ElectricCar tesla=new ElectricCar("TESLA 2378",200);
        tesla.accelerate();
        tesla.printWheels();
        System.out.println("TESLA currentspeed : " + tesla.getSpeed() + " Battery : " + tesla.battery);
    }

}
