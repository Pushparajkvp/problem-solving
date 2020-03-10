package dev.pushparaj;

import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
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

    protected boolean isEqual(List source, List target) {
        List clonedTarget = new ArrayList<>(target);
        for(int sourceItemIndex = 0; sourceItemIndex < source.size(); sourceItemIndex++) {
            for(int targetItemIndex = 0; targetItemIndex < clonedTarget.size(); targetItemIndex++) {
                
                Object sourceItem = source.get(sourceItemIndex);
                Object targetItem = clonedTarget.get(targetItemIndex);

                if(sourceItem instanceof List && targetItem instanceof List){
                    if (isEqual((List) sourceItem, (List)targetItem)){
                        clonedTarget.remove(targetItemIndex);
                        break;
                    }         
                } else if (sourceItem instanceof List || targetItem instanceof List) {
                    return false;
                } else {
                    if(sourceItem != null && targetItem != null) {
                        if(sourceItem == targetItem){
                            clonedTarget.remove(targetItemIndex);
                            break;
                        }
                    } else if (sourceItem == null || targetItem == null) {
                        return false;
                    } else {
                        clonedTarget.remove(targetItemIndex);
                        break;
                    }
                }
            }
        }
        return clonedTarget.size() == 0;
    }

    protected int[] removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int it = 0; it < arr.length; it++) {
            set.add(arr[it]);
        }
        int[] newArr = new int[set.size()];
        int index = -1;
        Iterator iterator = set.iterator(); 
        while(iterator.hasNext()){
            newArr[++index] = (int) iterator.next();
        }
        return newArr;
    }
}