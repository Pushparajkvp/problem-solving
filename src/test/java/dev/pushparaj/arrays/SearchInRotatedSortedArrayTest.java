package dev.pushparaj.arrays;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dev.pushparaj.BaseTest;

public class SearchInRotatedSortedArrayTest extends BaseTest {

    @Test
    public void testExampleCases() {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        assertEquals(4, obj.search(new int[]{4,5,6,7,0,1,2}, 0));
        assertEquals(-1, obj.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}