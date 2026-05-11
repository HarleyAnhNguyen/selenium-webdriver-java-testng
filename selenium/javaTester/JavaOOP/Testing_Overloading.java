package javaTester.JavaOOP;

public class Testing_Overloading {
    public static void main(String[] args) {
        Topic_06_Getter_Setter person = new Topic_06_Getter_Setter();

        //Happy case
        person.setPersonName("Bo Thui");
        System.out.println(person.getPersonName());

        //Unhappy case
        person.setPersonName("");
        System.out.println(person.getPersonName());

    }
}
