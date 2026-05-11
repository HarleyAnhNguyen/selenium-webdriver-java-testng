package javaTester.JavaOOP;

public class Topic_06_Getter_Setter {

    private String personName;
    private int personAge;
    private int personPhone;
    private float personBankAccountAmount;


    public void setPersonName(String personName){
        if(personName == null || personName.isEmpty()){
            throw new IllegalArgumentException("Person name cannot be null or empty");

        }else {
            this.personName = personName;
        }
    }
    public String getPersonName(){
        return this.personName;
    }
}
