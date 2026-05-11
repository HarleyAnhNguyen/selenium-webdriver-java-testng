package javaTester.JavaOOP.overriding;

public class Student extends Person implements IWork{
    @Override
    public void workingTime() {
        System.out.println("Number of hours working: 4 hours");
    }

    @Override
    public void eat() {
        System.out.println("Pay for food: 15.000VND");
    }
    public void sleep() {
        System.out.println("Number of hours sleep: 12 hours");
    }
}
