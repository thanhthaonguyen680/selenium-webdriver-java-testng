package JavaTester.selenium.JavaTester.OOP;

public class SumArrayElement {
    public static void main(String[] args) {
        int[] numbers = {1,5,7,10,11};
        int sum  = 0;
        for ( int i = 0; i<numbers.length; i++){
            sum +=numbers[i];
        }

        System.out.println(sum);
    }

    }

