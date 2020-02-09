package dev.pushparaj.arrays;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dev.pushparaj.BaseTest;

public class FirstAndLastPositionInSortedArrayTest extends BaseTest {

    @Test
    public void testExampleCases() {
        FirstAndLastPositionInSortedArray obj = new FirstAndLastPositionInSortedArray();
        assertTrue(Arrays.equals(new int[]{3,4}, obj.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        assertTrue(Arrays.equals(new int[]{-1,-1}, obj.searchRange(new int[]{5,7,7,8,8,10}, 6)));
    }
}