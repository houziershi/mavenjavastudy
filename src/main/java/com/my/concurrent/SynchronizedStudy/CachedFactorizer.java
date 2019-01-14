package com.my.concurrent.SynchronizedStudy;

import java.math.BigInteger;

public class CachedFactorizer implements Runnable {

    private BigInteger lastNumber;
    private BigInteger[] lastFactors;
    private long hits;
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    @Override
    public void run() {
        BigInteger i = extractFromRequest();
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factor(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
    }

    void encodeIntoResponse(BigInteger[] factors) {
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }

    BigInteger extractFromRequest() {
        return new BigInteger("7");
    }

    public static void main(String[] args) {
        CachedFactorizer cachedFactorizer1 = new CachedFactorizer();
        CachedFactorizer cachedFactorizer2 = new CachedFactorizer();

        new Thread(cachedFactorizer1).start();
        new Thread(cachedFactorizer2).start();
    }
}
