package JavaTester.OOP;

public class FindDuplicate {
    public static void main(String[] args) {
        int [] numbers = {1,10,12,30,1,10};
        for (int i = 0; i<numbers.length; i++){
            for (int j = i +1; j<numbers.length; j++){
                if (numbers[i] == numbers[j]) {
                    System.out.println(numbers[i]);
                    break;
                }
            }
        }
    }
}
