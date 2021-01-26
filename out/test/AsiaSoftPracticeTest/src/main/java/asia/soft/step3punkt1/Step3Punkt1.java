package main.java.asia.soft.step3punkt1;

import main.java.asia.soft.step3punkt1.model.Number;
import main.java.asia.soft.step3punkt1.repository.NumberRepository;
import main.java.asia.soft.step3punkt1.repository.impl.NumberRepositoryTxtImol;

import java.util.List;

import static main.java.asia.soft.step3punkt1.service.NumberService.printArraySquares;

public class Step3Punkt1 {
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            try {
                int limit = Integer.parseInt(args[0]);
               /*
                      в задаче ничего не сказано про сами числа поэтому я взял целые неотрицательные.
               */
                List<Number> squaresArray = printArraySquares(limit);
                String fileName = "textStep3Part1.txt";
                NumberRepository numberRepository = NumberRepositoryTxtImol.getInstance();
                numberRepository.saveAll(squaresArray, fileName);

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
}
