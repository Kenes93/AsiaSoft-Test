package main.java.asia.soft.step5;

import main.java.asia.soft.step5.exception.SizeException;
import main.java.asia.soft.step5.model.Number;
import main.java.asia.soft.step5.repository.NumberRepository;
import main.java.asia.soft.step5.repository.impl.NumberRepositoryXmlImol;

import java.util.List;

import static main.java.asia.soft.step5.service.NumberService.printArraySquares;
import static main.java.asia.soft.step5.utils.CheckFile.checkSize;

public class Step5 {
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            try {
                int limit = Integer.parseInt(args[0]);
               /*
                      в задаче ничего не сказано про сами числа поэтому я взял целые неотрицательные.
               */
                List<Number> squaresArray = printArraySquares(limit);
                String fileName = "textStep5.xml";
                NumberRepository numberRepository = NumberRepositoryXmlImol.getInstance();
                numberRepository.saveAll(squaresArray, fileName);
                checkSize(fileName);
            } catch (SizeException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
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
