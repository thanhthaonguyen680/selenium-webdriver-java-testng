package JavaTester;

import org.testng.annotations.Test;

public class Topic_11_Array_Execerise {
    int[] number = {5, 7, 8, 10, 5, 4, 1};

    @Test
    public void TC_01_Find_Max() {
        int x = 0;
        for (int i = 0; i < number.length; i++) {
            if (x < number[i]) {
                x = number[i];
            }
        }
        System.out.println(x);
    }
    @Test
    public void TC_02_Sum_First_And_Last(){
        int x =0;
        x = number[0] + number[number.length-1];
        System.out.println(x);
    }
    @Test
    public void TC_03_Even(){
        for (int i = 0; i<number.length; i++){
            if (number[i]%2==0){
                System.out.println(number[i]);
            }
        }

    }
    @Test
    public void TC_04(){
        for (int i = 0; i<number.length; i++){
            if (number[i]>0 && number[i]<10){
                System.out.println(number[i]);
            }

        }

    }
    @Test
    public void TC_05_Sum_Average(){
        int sum =0;
        for (int i =0; i<number.length; i++){
            sum += number[i];
        }
        System.out.println(sum);
        System.out.println(sum/number.length);

    }

}




