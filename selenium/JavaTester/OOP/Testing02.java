package JavaTester.OOP;

public class Testing02 {
    public static void main(String[]args){
        Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();
        // happy case
        topic.setPersonName("Thao");
        System.out.println(topic.getPersonName());
        // unhappy case
//        topic.setPersonName(null);
//        System.out.println(topic.getPersonName());
//        topic.setPersonName("");
//        System.out.println(topic.getPersonName());
        topic.setPersonAge(20);
        System.out.println(topic.getPersonAge());
        topic.setPersonPhone(0);
        System.out.println(topic.getPersonPhone());





    }
}
