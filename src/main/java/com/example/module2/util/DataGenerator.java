package com.example.module2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataGenerator {

    public static List<String> generateGreekAlphabet() {

        String[] greekLetters = {
                "Alpha",
                "Beta",
                "Gamma",
                "Delta",
                "Epsilon",
                "Zeta",
                "Eta",
                "Theta",
                "Iota",
                "Kappa",
                "Lambda",
                "Mu",
                "Nu",
                "Xi",
                "Omicron",
                "Pi",
                "Rho",
                "Sigma",
                "Tau",
                "Upsilon",
                "Phi",
                "Chi",
                "Psi",
                "Omega"
        };

        ArrayList<String> returnList = new ArrayList<>();
        for( String next : greekLetters ) {
            returnList.add(next);
        }
        return returnList;
    }

    public static List<String> generateScrambledAndDuppedGreekAlphabet() {

        ArrayList<String> returnList = new ArrayList<>();

        returnList.addAll(generateGreekAlphabet());
        returnList.addAll(generateGreekAlphabet());
        returnList.addAll(generateGreekAlphabet());

        Collections.shuffle(returnList);

        return returnList;
    }

    public static void emitFibonacciList(List<Integer> emitList) {

        emitList.add(1);
        emitList.add(2);
        emitList.add(3);
        emitList.add(5);
        emitList.add(8);
        emitList.add(13);
        emitList.add(21);
        emitList.add(34);
    }

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

    public static List<Integer> generateBigIntegerList() {
        ArrayList<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            returnList.add(i);
        }
        return returnList;
    }
}
