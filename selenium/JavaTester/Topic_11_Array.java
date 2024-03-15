package JavaTester;

import java.util.ArrayList;

public class Topic_11_Array {
    public static void main(String[] args) {
        int[] student = {1, 3, 5, 7};
        System.out.println(student[0]);
        String[] studentName = {"Thao", " Long", " An"};
        System.out.println(studentName[0]);
        for(int i=0 ;i < studentName.length; i++) {
            if (studentName[i].equals("Thao")) {
                System.out.println(studentName[i]);
            }
            }
        ArrayList<String> stdName = new ArrayList<>();
        for (String std:studentName){
            stdName.add(std);
        }


    }
    // khi chạy code mới add


    }

