package main.java.asia.soft.step1;

public class Step1 {
    public static void main(String[] args) {
        if (args != null&&args.length>0) {
            try {
                int limit = Integer.parseInt(args[0]);
               /*
                      в задаче ничего не сказано про сами числа поэтому я взял целые неотрицательные.
               */
                long[] squaresArray = printArraySquares(limit);
                for (long square: squaresArray) {
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

    private static long[] printArraySquares(int limit) {
        long[] squaresArray = new long[limit+1];
        for (int i = 0; i <= limit; i++) {
            squaresArray[i] = i * i;
        }
        return squaresArray;
    }

}
