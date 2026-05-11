package javaTester.JavaOOP.polymorphism;

public class Test {
    public static void main(String[] args) {
        Animal ani = new Animal();
        ani.eat(); // Output: Animal is eating

        ani = new Elephant();
        ani.eat(); // Output: Elephant is eating

        ani = new Fish();
        ani.eat(); // Output: Fish is eating
    }
}
