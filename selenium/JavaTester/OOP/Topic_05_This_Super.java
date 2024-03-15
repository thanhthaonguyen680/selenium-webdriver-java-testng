package JavaTester.OOP;

public class Topic_05_This_Super {
    private int firstNumber;
    private int secondNumber;
    // tạo hàm khởi tạo ( constructor)
    public Topic_05_This_Super(int firstNumber , int secondNumber ) {
        this.firstNumber = firstNumber ;
       this. secondNumber = secondNumber ;
    }
    public void sumNUmber(){

        System.out.println(firstNumber+secondNumber);

    }
    public static void main(String[] args){
        // khi hàm chạy sẽ nhảy vô constructor được tạo ở trên
        Topic_05_This_Super topic = new Topic_05_This_Super(15,7);
        // từ topic gọi sumNumber
        topic.sumNUmber();
    }
}
