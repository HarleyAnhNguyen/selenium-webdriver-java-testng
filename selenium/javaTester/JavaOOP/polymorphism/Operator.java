package javaTester.JavaOOP.polymorphism;

public class Operator {
    public void sum(int a, int b){
        System.out.println(a+b);

    }
    public void sum (float a, float b){
        System.out.println(a+b);
    }

    public void sum (long a, long b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        Operator op = new Operator();
        op.sum(1, 2);
        op.sum(1.5f, 2.5f);
        op.sum(10000000000L, 20000000000L);
    }
}
