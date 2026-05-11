package javaTester.JavaOOP.inheritance;

public class Test_Inheritance {
    public static void main(String[] args) {
        HuskyDog dog = new HuskyDog();
        dog.eat();
        dog.run();
        dog.hun();
        dog.setAge(15);
        System.out.println(dog.getAge());
    }
}
