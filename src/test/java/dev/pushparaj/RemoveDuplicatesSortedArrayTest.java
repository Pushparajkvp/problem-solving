package dev.pushparaj;

import java.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesSortedArrayTest extends BaseTest{

    @Test
    public void testSampleCases() {
        RemoveDuplicatesSortedArray obj = RemoveDuplicatesSortedArray();
        assertEquals(2, obj.removeDuplicates(new int[]{1,1,2}));
        assertEquals(5, obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}