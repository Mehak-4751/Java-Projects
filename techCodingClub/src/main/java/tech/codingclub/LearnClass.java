package tech.codingclub;

public class LearnClass {

    public static void main(String[] args) {
        Car audi=new Car("AUDI 0098",50);
        audi.accelerate();
        System.out.println("AUDI Current speed : " + audi.getSpeed());
        System.out.println("AUDI Wheels : " + audi.wheelCount);

        Car bmw=new Car("BMW 3456",100);
        bmw.accelerate();
        bmw.increaseSpeed(100);
        System.out.println("BMW Current speed : " + bmw.getSpeed());

        bmw.wheelCount=8;
        System.out.println("AUDI Wheels : " + audi.wheelCount);
        System.out.println("BMW wheels : " + bmw.wheelCount);
        System.out.println("Static variable Wheelcount independent of the object : " + Car.wheelCount);
        Car.printWheels();
        //bmw.printWheels();

        DummyCar car= new DummyCar() {
            @Override
            public void move() {
                //x,y coordinate change
            }
        };
    }

}
