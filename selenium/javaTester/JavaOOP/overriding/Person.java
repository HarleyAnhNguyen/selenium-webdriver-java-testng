package javaTester.JavaOOP.overriding;

public abstract class Person {
    public void eat(){
        System.out.println("Pay for food: 20.000VND");
    }

    //Must override this method in subclass, if not, the subclass must be abstract class
    public abstract void sleep();
}
