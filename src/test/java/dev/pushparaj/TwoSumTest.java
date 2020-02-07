package dev.pushparaj;

import org.junit.Test;
import static org.junit.Assert.*;

public class TwoSumTest {
    @Test 
    public void testTwoSumExampleCases() {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(new int[]{ 2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{ 0, 1}, result);
    }
}
