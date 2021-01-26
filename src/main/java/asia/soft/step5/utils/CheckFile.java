package main.java.asia.soft.step5.utils;

import main.java.asia.soft.step5.exception.SizeException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CheckFile {
    public static void checkSize(String fileName) throws SizeException {
         FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            long maxFileSize = Integer.parseInt(property.getProperty("file.maxSize"));
            long fileSize = new File(fileName).length();
            if (fileSize > maxFileSize) {
                throw new SizeException("File cannot be more than " + maxFileSize + " bytes");
            }

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

    }

}
