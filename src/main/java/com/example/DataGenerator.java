package com.example;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<Integer> generateFibonacciList() {
        ArrayList<Integer> returnList = new ArrayList<>();
        returnList.add(1);
        returnList.add(2);
        returnList.add(3);
        returnList.add(5);
        returnList.add(8);
        returnList.add(13);
        returnList.add(21);
        returnList.add(34);

        return returnList;
    }

    public static Integer[] generateFibonacciArray() {
        Integer[] returnArray =  new Integer[8];
        returnArray[0] = 1;
        returnArray[1] = 2;
        returnArray[2] = 3;
        returnArray[3] = 5;
        returnArray[4] = 8;
        returnArray[5] = 13;
        returnArray[6] = 21;
        returnArray[7] = 34;
        return returnArray;
    }
}
