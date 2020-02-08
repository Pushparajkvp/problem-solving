package dev.pushparaj.arrays;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dev.pushparaj.BaseTest;

public class RemoveElementInPlaceTest extends BaseTest {

    @Test
    public void testExampleCases() {
        RemoveElementInPlace obj = new RemoveElementInPlace();
        assertEquals(2, obj.removeElement(new int[]{3,2,2,3}, 3));
        assertEquals(5, obj.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}