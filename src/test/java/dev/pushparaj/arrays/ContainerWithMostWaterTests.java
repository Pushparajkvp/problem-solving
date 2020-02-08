package dev.pushparaj.arrays;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerWithMostWaterTests extends BaseTest{

    @Test
    public void testExampleCases() {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        assertEquals(49, obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}