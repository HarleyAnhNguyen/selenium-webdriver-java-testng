package javaTester.JavaOOP.inheritance;

public class Dog extends Animal{

    private int age;
    public Dog() {
        super("Bo Thui","7 years old");
        System.out.println("This is Dog constructor");
    }
    public  void run() {
        System.out.println("Dog is running");
    }

    public void setAge(int age){
        if(age > 0){
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
    }

    public int getAge() {
        return this.age;
    }
}
