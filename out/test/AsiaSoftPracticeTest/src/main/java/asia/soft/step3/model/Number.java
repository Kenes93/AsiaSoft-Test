package main.java.asia.soft.step3.model;

public class Number {
    private long value;
    private boolean isEven;

    public Number(long value) {
        this.value = value;
        isEven = (value % 2 == 0);
    }

    public long getValue() {
        return value;
    }

    public boolean isEven() {
        return isEven;
    }

    @Override
    public String toString() {
        return "number value is "+value+" and number is "
                + (isEven?"even":"odd");
    }
}
