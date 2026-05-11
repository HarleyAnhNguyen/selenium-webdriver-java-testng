package javaTester.JavaOOP;

public class Topic_07_Overloading {
    private int firstNumber;
    private int secondNumber;

    public void sumNumber(){
        System.out.println(this.firstNumber+this.secondNumber);
    }

    public void sumNumber(int firstNumber, int secondNumber){
        System.out.println(firstNumber + secondNumber);
    }

    public void sumNumber(float firstNumber, float secondNumber){
            System.out.println(firstNumber + secondNumber);
        }

    public void sumNumber(int firstNumber, float secondNumber){
            System.out.println(firstNumber + secondNumber );
        }

    public static void main(String[] args) {
            Topic_07_Overloading topic = new Topic_07_Overloading();
            topic.firstNumber = 5;
            topic.secondNumber = 10;
            topic.sumNumber();
            topic.sumNumber(15, 20);
            topic.sumNumber(1.5f, 2.5f);
            topic.sumNumber(5, 10.5f);
        }
}
