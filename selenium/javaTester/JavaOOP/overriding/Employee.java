package javaTester.JavaOOP.overriding;

public class Employee extends Person implements IWork{
    @Override
    public void eat() {
        System.out.println("Pay for food: 35.000VND");
    }

    @Override
    public void sleep() {
        System.out.println("Number of hours sleep: 7 hours");
    }

    public void workingTime() {
        System.out.println("Number of hours working: 8 hours");
    }
}
