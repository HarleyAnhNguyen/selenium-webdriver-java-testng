package javaTester.JavaOOP;

public class Topic02_Class_Object_Student {
    private long studentID;
    private String studentName;
    private float studentTheoreticalPoint;
    private float studentPracticalPoint;


    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getStudentTheoreticalPoint() {
        return studentTheoreticalPoint;
    }

    public void setStudentTheoreticalPoint(float studentTheoreticalPoint) {
        this.studentTheoreticalPoint = studentTheoreticalPoint;
    }

    public float getStudentPracticalPoint() {
        return studentPracticalPoint;
    }

    public void setStudentPracticalPoint(float studentPracticalPoint) {
        this.studentPracticalPoint = studentPracticalPoint;
    }

     public float getStudentAveragePoint(){
        return (studentTheoreticalPoint + studentPracticalPoint*2)/3;
     }

     public Topic02_Class_Object_Student(long studentID, String studentName, float studentTheoreticalPoint, float studentPracticalPoint){
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentTheoreticalPoint = studentTheoreticalPoint;
        this.studentPracticalPoint = studentPracticalPoint;
     }
     public Topic02_Class_Object_Student(){

     }
     public void displayStudentInfo(){
        System.out.println("-----Student Information-----");
         System.out.println("Student ID: "+studentID);
         System.out.println("Student Name: "+studentName);
         System.out.println("Student Average Point: "+getStudentAveragePoint());
     }

}
