package main.java.asia.soft.step4;

import main.java.asia.soft.step4.model.Number;
import main.java.asia.soft.step4.repository.NumberRepository;
import main.java.asia.soft.step4.repository.impl.NumberRepositoryTxtImol;
import main.java.asia.soft.step4.repository.impl.NumberRepositoryXmlImol;

import java.util.List;

import static main.java.asia.soft.step4.service.NumberService.printArraySquares;

public class Step4 {
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            try {
                int limit = Integer.parseInt(args[0]);
               /*
                      в задаче ничего не сказано про сами числа поэтому я взял целые неотрицательные.
               */
                List<Number> squaresArray = printArraySquares(limit);
                String fileName = "textStep4.xml";
                NumberRepository numberRepository = NumberRepositoryXmlImol.getInstance();
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
