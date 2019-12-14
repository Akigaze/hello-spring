package com.aop.helloproxy;

public class IntegerCalculator implements Calculator<Integer, Integer> {

    private IntegerCalculator() {
        System.out.println("new integer calculator");
    }

    @Override
    public Integer add(Integer augend, Integer addend) {
        Integer result = augend + addend;
        return result;
    }

    @Override
    public Integer subtract(Integer minuend, Integer subtrahend) {
        Integer result = minuend - subtrahend;
        return result;
    }

    @Override
    public Integer multiply(Integer multiplicand, Integer multiplier) {
        Integer result = multiplicand * multiplier;
        return result;
    }

    @Override
    public Integer divide(Integer dividend, Integer divisor) {
        Integer result = dividend / divisor;
        return result;
    }

    @Override
    public void square(Integer cardinality) {
        System.out.println(cardinality * cardinality);
    }

    public static void main(String[] args) {
        Calculator calculator = new IntegerCalculatorProxy(new IntegerCalculator()).getProxy();
        System.out.println("100 + 200 = " + calculator.add(100, 200));
        System.out.println("500 - 230 = " + calculator.subtract(500, 230));
        System.out.println("23 * 56 = " + calculator.multiply(23, 56));
        System.out.println("100 / 20 = " + calculator.divide(100, 20));
    }

}
