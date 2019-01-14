package com.my.algorithm.design.pattern.chain;

public class MyMain {
    public static void main(String[] args) {
        Number number = new Number(-5);
        PositiveProcessor positiveProcessor = new PositiveProcessor();
        ZeroProcessor zeroProcessor = new ZeroProcessor();
        NegativeProcessor negativeProcessor = new NegativeProcessor();
        positiveProcessor.setNext(zeroProcessor);
        zeroProcessor.setNext(negativeProcessor);

        positiveProcessor.process(number);
    }
}
