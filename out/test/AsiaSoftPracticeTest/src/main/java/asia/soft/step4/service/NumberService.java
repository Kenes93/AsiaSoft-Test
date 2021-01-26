package main.java.asia.soft.step4.service;

import main.java.asia.soft.step4.model.Number;

import java.util.ArrayList;
import java.util.List;

public class NumberService {
    public static List<Number> printArraySquares(int limit) {
        List<Number> squaresArray = new ArrayList<>();
        for (int i = 0; i <= limit; i++) {
            squaresArray.add(new Number(i * i));
        }
        return squaresArray;
    }
}
