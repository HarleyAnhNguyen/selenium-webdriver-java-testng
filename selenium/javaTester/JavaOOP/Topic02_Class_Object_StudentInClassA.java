package javaTester.JavaOOP;

public class Topic02_Class_Object_StudentInClassA {
    public static void main(String[] args) {
       Topic02_Class_Object_Student student1 = new Topic02_Class_Object_Student(100001, "Harley", 8.5f, 9.6f);

       Topic02_Class_Object_Student student2 = new Topic02_Class_Object_Student(100002, "Cody", 8.0f, 8.5f);

       Topic02_Class_Object_Student student3 = new Topic02_Class_Object_Student(100003, "Avocado", 5.0f, 6.0f);
       student1.displayStudentInfo();
       student2.displayStudentInfo();
       student3.displayStudentInfo();

    }
}
