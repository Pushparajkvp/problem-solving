package dev.pushparaj.arrays;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dev.pushparaj.BaseTest;

public class SearchInsertPositionTest extends BaseTest {

    @Test
    public void testExampleCases() {
        SearchInsertPosition obj = new SearchInsertPosition();
        assertEquals(2, obj.searchInsert(new int[]{1,3,5,6}, 5));
        assertEquals(1, obj.searchInsert(new int[]{1,3,5,6}, 2));
        assertEquals(4, obj.searchInsert(new int[]{1,3,5,6}, 7));
        assertEquals(0, obj.searchInsert(new int[]{1,3,5,6}, 0));
    }
}