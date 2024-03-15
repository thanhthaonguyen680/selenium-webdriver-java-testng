package JavaTester.selenium.JavaTester.OOP;

public class MaxNumber {
    public static void main(String[] args) {
        int [] numbers = {3,10,40,60,20};
        int max = 0;
        for (int i = 0; i< numbers.length; i++){
            if(max < numbers[i]){
                max = numbers[i];
            }
        }
        System.out.println(max);
    }
}
