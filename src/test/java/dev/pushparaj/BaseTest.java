package dev.pushparaj;

import java.util.concurrent.ThreadLocalRandom;

public class BaseTest {

    protected int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    protected long getRandomNumber(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    protected double getRandomNumber(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }
}