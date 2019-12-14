package com.aop.helloproxy;

public interface Calculator<O, I> {
    O add(I augend, I addend);
    O subtract(I minuend, I subtrahend);
    O multiply(I multiplicand, I multiplier);
    O divide(I dividend, I divisor);
    void square(I cardinality);

}

