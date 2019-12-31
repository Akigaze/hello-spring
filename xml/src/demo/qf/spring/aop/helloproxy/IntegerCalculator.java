package demo.qf.spring.aop.helloproxy;

import demo.qf.spring.aop.universal.Calculator;

public class IntegerCalculator implements Calculator<Integer> {

  private IntegerCalculator() {
    System.out.println("new integer calculator");
  }

  @Override
  public Integer add(Integer augend, Integer addend) {
    return augend + addend;
  }

  @Override
  public Integer subtract(Integer minuend, Integer subtrahend) {
    return minuend - subtrahend;
  }

  @Override
  public Integer multiply(Integer multiplicand, Integer multiplier) {
    return multiplicand * multiplier;
  }

  @Override
  public Integer divide(Integer dividend, Integer divisor) {
    return dividend / divisor;
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
