package main.java.asia.soft.step5.repository;

import main.java.asia.soft.step5.model.Number;

import java.util.List;

public abstract class NumberRepository {

// полимормизм
    public abstract void saveAll(List<Number> squaresArray, String fileName);



}
