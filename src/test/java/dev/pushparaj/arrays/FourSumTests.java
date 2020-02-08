package dev.pushparaj.arrays;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dev.pushparaj.BaseTest;

public class FourSumTests extends BaseTest {

    @Test
    public void testSampleCases() {
        FourSum obj = new FourSum();
        //-1,  0, 0, 1
        ArrayList<Integer> one = new ArrayList();
        one.add(-1);
        one.add(0);
        one.add(0);
        one.add(1);
        //-2, -1, 1, 2
        ArrayList<Integer> two = new ArrayList();
        two.add(-2);
        two.add(-1);
        two.add(1);
        two.add(2);
        //-2,  0, 0, 2
        ArrayList<Integer> three = new ArrayList();
        three.add(-2);
        three.add(0);
        three.add(0);
        three.add(2);
        ArrayList<ArrayList<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(one);
        expectedOutput.add(two);
        expectedOutput.add(three);
        List<List<Integer>> actualOutput = obj.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        assertTrue(isEqual(expectedOutput, actualOutput));
    }
}