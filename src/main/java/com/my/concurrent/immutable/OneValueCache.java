package com.my.concurrent.immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Description: 不可变对象的示例
 * @author: guokun
 * @data: 2018/9/12
 */
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactors) {
        this.lastNumber = lastNumber;
        this.lastFactors = Arrays.copyOf(lastFactors, lastFactors.length);
    }

    public BigInteger[] getLastFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors, lastFactors.length);
    }
}
