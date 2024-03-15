package JavaTester.OOP;

public class Topic_01_Class_Object_Student {
    private int  studentID;
    private String studentName;
    private Float knowledgePoint;
    private Float  praticePoint;

    private int getStudentID() {
        return studentID;
    }

    private void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    private String getStudentName() {
        return studentName;
    }

    private void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private Float getKnowledgePoint() {
        return knowledgePoint;
    }

    private void setKnowledgePoint(Float knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }

    private Float getPraticePoint() {
        return praticePoint;
    }

    private void setPraticePoint(Float praticePoint) {
        this.praticePoint = praticePoint;
    }


    private Float getAveragePoint(){
        return(this.knowledgePoint + this.praticePoint*2)/3;

    }
    private void showStudentInfor(){
        System.out.println(getStudentID());
        System.out.println(getStudentName());
        System.out.println((getKnowledgePoint()));
        System.out.println(getPraticePoint());
        System.out.println(getAveragePoint());



    }


    public static void main(String[] args) {
        Topic_01_Class_Object_Student firstStusent = new Topic_01_Class_Object_Student();
        firstStusent.setStudentID(20004);
        firstStusent.setStudentName("Nguyen Van A");
        firstStusent.setKnowledgePoint(7.5f);
        firstStusent.setPraticePoint(8.6f);
        firstStusent.showStudentInfor();


    }
}
