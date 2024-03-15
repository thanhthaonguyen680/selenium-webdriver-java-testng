package JavaTester;

import org.testng.annotations.Test;

public class Topic_08_For_Foreach {
    @Test
    public void TC_01_For(){
        for(int i=1;i<=10;i++){
            System.out.println(i);

        }
        //Array
        String[] cityName ={"Ha Noi","Ho chi Minh","Da Nang", "Can Tho"};
        for(int i =0;i<cityName.length; i++ ){
            if (cityName[i].equals("Da Nang")){
            System.out.println("do action");
            break;
        }
    }
}
    @Test
    public void TC_02_For_Each(){
        String[] cityName ={"Ha Noi","Ho chi Minh","Da Nang", "Can Tho"};
        for (String city: cityName){
            System.out.println(city);
        }

    }

}
