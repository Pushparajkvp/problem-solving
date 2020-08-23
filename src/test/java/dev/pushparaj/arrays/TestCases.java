package dev.pushparaj.arrays;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dev.pushparaj.BaseTest;
import java.util.*;

public class TestCases extends BaseTest{
    @Test 
    public void twoSum() {
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(new int[]{ 2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{ 0, 1}, result);
    }

    @Test
    public void threeSum() {
        ThreeSum obj = new ThreeSum();
        ArrayList<Integer> one = new ArrayList<Integer>(); 
        one.add(-1);
        one.add(0);
        one.add(1);
        ArrayList<Integer> two = new ArrayList<Integer>();
        two.add(-1);
        two.add(-1);
        two.add(2);
        ArrayList<ArrayList<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(one);
        expectedOutput.add(two);
        List<List<Integer>> actualOutput = obj.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertTrue(isEqual(expectedOutput, actualOutput));
    }

    @Test
    public void threeSumClosest() {
        ThreeSumClosest obj = new ThreeSumClosest();
        assertEquals(2, obj.threeSumClosest(new int[]{-1, 2, 1, -4},1));
    }

     @Test
    public void searchAndInsert() {
        SearchInsertPosition obj = new SearchInsertPosition();
        assertEquals(2, obj.searchInsert(new int[]{1,3,5,6}, 5));
        assertEquals(1, obj.searchInsert(new int[]{1,3,5,6}, 2));
        assertEquals(4, obj.searchInsert(new int[]{1,3,5,6}, 7));
        assertEquals(0, obj.searchInsert(new int[]{1,3,5,6}, 0));
    }
    
    @Test
    public void combinationSumWithRepetitionTest() {
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

    @Test
    public void containerWithMostWaterTests() {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        assertEquals(49, obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    @Test
    public void firstAndLastPositionInSortedArrayTest() {
        FirstAndLastPositionInSortedArray obj = new FirstAndLastPositionInSortedArray();
        assertTrue(Arrays.equals(new int[]{3,4}, obj.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        assertTrue(Arrays.equals(new int[]{-1,-1}, obj.searchRange(new int[]{5,7,7,8,8,10}, 6)));
    }
    
    @Test
    public void fourSumTests() {
        FourSum obj = new FourSum();
        //-1,  0, 0, 1
        ArrayList<Integer> one = new ArrayList();
        one.add(-1);
        one.add(0);
        one.add(0);
        one.add(1);
        //-2, -1, 1, 2
        ArrayList<Integer> two = new ArrayList();
        two.add(-2);
        two.add(-1);
        two.add(1);
        two.add(2);
        //-2,  0, 0, 2
        ArrayList<Integer> three = new ArrayList();
        three.add(-2);
        three.add(0);
        three.add(0);
        three.add(2);
        ArrayList<ArrayList<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(one);
        expectedOutput.add(two);
        expectedOutput.add(three);
        List<List<Integer>> actualOutput = obj.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        assertTrue(isEqual(expectedOutput, actualOutput));
    }

    @Test
    public void medianOfArrayExampleTests() {
        MedianOfArray obj = new MedianOfArray();
        assertEquals(2.0, obj.findMedianSortedArrays(new int[]{ 1, 3}, new int[]{ 2}));
        assertEquals(2.5, obj.findMedianSortedArrays(new int[]{ 1, 2}, new int[]{ 3, 4}));
    }

    @Test
    public void nextPermutationTest() {
        NextPermutation obj = new NextPermutation();
        int[] output = new int[]{1,2,3};
        obj.nextPermutation(output);
        assertTrue(Arrays.equals(new int[]{1,3,2}, output));
        output = new int[]{3,2,1};
        obj.nextPermutation(output);
        assertTrue(Arrays.equals(new int[]{1,2,3}, output));
        output = new int[]{1,1,5};
        obj.nextPermutation(output);
        assertTrue(Arrays.equals(new int[]{1,5,1}, output));
    }

    @Test
    public void removeDuplicatesSortedArrayTest() {
        RemoveDuplicatesSortedArray obj = new RemoveDuplicatesSortedArray();
        assertEquals(2, obj.removeDuplicates(new int[]{1,1,2}));
        assertEquals(5, obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    @Test
    public void removeElementInPlaceTest() {
        RemoveElementInPlace obj = new RemoveElementInPlace();
        assertEquals(2, obj.removeElement(new int[]{3,2,2,3}, 3));
        assertEquals(5, obj.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    @Test
    public void searchInRotatedSortedArrayTest() {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        assertEquals(4, obj.search(new int[]{4,5,6,7,0,1,2}, 0));
        assertEquals(-1, obj.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
    
    @Test
    public void combinationSumTest() {
        int[] arr = {2, 4, 8, 6, 6, 2};
        CombinationSum.find(arr, 8);
    }
}
