package main.java.asia.soft.step3punkt1.repository.impl;

import main.java.asia.soft.step3punkt1.model.Number;
import main.java.asia.soft.step3punkt1.repository.NumberRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NumberRepositoryTxtImol extends NumberRepository {
    private static NumberRepositoryTxtImol instance;

    private NumberRepositoryTxtImol() {
    }

    public static NumberRepositoryTxtImol getInstance() {
        if (instance == null) {
            instance = new NumberRepositoryTxtImol();
        }
        return instance;
    }

    @Override
    public void saveAll(List<Number> squaresArray, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Number number : squaresArray) {
                bufferedWriter.write(number.toString());
                bufferedWriter.newLine();
            }
            System.out.println("Сохранение прошло успешно");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
