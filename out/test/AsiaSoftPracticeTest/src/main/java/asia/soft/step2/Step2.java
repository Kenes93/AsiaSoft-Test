package main.java.asia.soft.step2;

import java.util.ArrayList;
import java.util.List;

public class Step2 {
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            try {
                int limit = Integer.parseInt(args[0]);
               /*
                      в задаче ничего не сказано про сами числа поэтому я взял целые неотрицательные.
               */
                List<Number> squaresArray = printArraySquares(limit);
                for (Number square : squaresArray) {
                    System.out.println(square);
                }
            } catch (Exception e) {
                System.out.println("Некорректная запись числа: " + args[0]);

            }
        } else {
            System.out.println("Укажите верхний предел");
            System.out.println("Добавьте аргумент в параметрах main()");
            System.out.println("Если выполняете в ИДЕА, то меню Run -> Edit Configuration -> " +
                    "Application в поле Program Arguments указываете аргумент");
        }
    }

    private static List<Number> printArraySquares(int limit) {
        List<Number> squaresArray = new ArrayList<>();
        for (int i = 0; i <= limit; i++) {
            squaresArray.add(new Number(i * i));
        }
        return squaresArray;
    }
}
