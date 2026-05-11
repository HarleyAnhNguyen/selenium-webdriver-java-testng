package javaTester.JavaOOP.inheritance;

public class Animal {
    public Animal() {
        System.out.println("This is Animal constructor");
    }

    public Animal(String name) {
        System.out.println("This is Animal constructor with name: " + name);
    }

    public Animal(String name, String age) {
        System.out.println("This is Animal constructor with name: " + name);
        System.out.println("This is Animal constructor with age: " + age);
    }
    protected void eat() {
        System.out.println("Animal is eating");
    }
}
