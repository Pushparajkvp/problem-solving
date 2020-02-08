package dev.pushparaj.arrays;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dev.pushparaj.BaseTest;

public class TwoSumTest extends BaseTest{
    @Test 
    public void testTwoSumExampleCases() {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(new int[]{ 2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{ 0, 1}, result);
    }
}
