package dev.pushparaj.arrays;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dev.pushparaj.BaseTest;

public class NextPermutationTest extends BaseTest {

    @Test
    public void testExampleCases() {
        NextPermutation obj = new NextPermutation();
        int[] output = new int[]{1,2,3};
        obj.nextPermutation(output);
        System.out.println(Arrays.toString(output));
        assertTrue(Arrays.equals(new int[]{1,3,2}, output));
        output = new int[]{3,2,1};
        obj.nextPermutation(output);
        assertTrue(Arrays.equals(new int[]{1,2,3}, output));
        output = new int[]{1,1,5};
        obj.nextPermutation(output);
        assertTrue(Arrays.equals(new int[]{1,5,1}, output));
    }
}