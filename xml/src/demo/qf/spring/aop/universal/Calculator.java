package demo.qf.spring.aop.universal;

public interface Calculator<T> {
  T add(T augend, T addend);

  T subtract(T minuend, T subtrahend);

  T multiply(T multiplicand, T multiplier);

  T divide(T dividend, T divisor);

  void square(T cardinality);

}
