package dev.pushparaj.arrays;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dev.pushparaj.BaseTest;

public class CombinationSumWithRepetitionTest extends BaseTest {

    @Test
    public void testExampleCases() {
        CombinationSumWithRepetition obj = new CombinationSumWithRepetition();
        List<Integer> one = new ArrayList<>();
        one.add(7);
        List<Integer> two = new ArrayList<>();
        two.add(2);
        two.add(2);
        two.add(3);
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(one);
        expectedOutput.add(two);
        isEqual(expectedOutput, obj.combinationSum(new int[]{2,3,6,7}, 7));
        one.clear(); two.clear(); expectedOutput.clear();
        one.add(2);one.add(2);one.add(2);one.add(2);
        two.add(2);two.add(3);two.add(3);
        List<Integer> three = new ArrayList<>();
        three.add(3); three.add(5);
        expectedOutput.add(one); expectedOutput.add(two); expectedOutput.add(three);
        isEqual(expectedOutput, obj.combinationSum(new int[]{2,3,5}, 8));
    }
}