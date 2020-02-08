package dev.pushparaj;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ThreeSumClosestTests extends BaseTest {

    @Test
    public void testExampleCases() {
        ThreeSumClosest obj = new ThreeSumClosest();
        assertEquals(2, obj.threeSumClosest(new int[]{-1, 2, 1, -4},1));
    }
}