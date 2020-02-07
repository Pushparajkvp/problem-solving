package dev.pushparaj;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    protected int[] getRandomNumberArray(int min, int max, int size) {
        int[] randomArray = new int[size];
        for(int it = 0; it < size; it++) randomArray[it] = getRandomNumber(min, max);
        return randomArray; 
    }

    protected long[] getRandomNumberArray(long min, long max, int size) {
        long[] randomArray = new long[size];
        for(int it = 0; it < size; it++) randomArray[it] = getRandomNumber(min, max);
        return randomArray; 
    }
    protected double[] getRandomNumberArray(double min, double max, int size) {
        double[] randomArray = new double[size];
        for(int it = 0; it < size; it++) randomArray[it] = getRandomNumber(min, max);
        return randomArray; 
    }

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