package dev.pushparaj.arrays;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MedianOfArrayTests {

    @Test
    public void medianOfArrayExampleTests() {
        MedianOfArray obj = new MedianOfArray();
        assertEquals(2.0, obj.findMedianSortedArrays(new int[]{ 1, 3}, new int[]{ 2}));
        assertEquals(2.5, obj.findMedianSortedArrays(new int[]{ 1, 2}, new int[]{ 3, 4}));
    }
}