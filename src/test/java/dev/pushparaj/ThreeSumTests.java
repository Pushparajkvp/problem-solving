package dev.pushparaj;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ThreeSumTests extends BaseTest {

    @Test
    public void testExampleCases() {
        ThreeSum obj = new ThreeSum();
        ArrayList<Integer> one = new ArrayList<Integer>(); 
        one.add(-1);
        one.add(0);
        one.add(1);
        ArrayList<Integer> two = new ArrayList<Integer>();
        two.add(-1);
        two.add(-1);
        two.add(2);
        ArrayList<ArrayList<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(one);
        expectedOutput.add(two);
        List<List<Integer>> actualOutput = obj.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertTrue(isEqual(expectedOutput, actualOutput));
    }
}