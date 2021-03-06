package dev.pushparaj.sorting;

import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dev.pushparaj.BaseTest;

public class SortingTest extends BaseTest {

    int[] one, two, three, four, five, six;
    int[] sortedOne, sortedTwo, sortedThree, sortedFour, sortedFive, sortedSix;
    
    @BeforeEach
    public void setup() {
        one = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        two = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        three = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        four = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        five = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        six = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        sortedOne = one.clone();
        sortedTwo = two.clone();
        sortedThree = three.clone();
        sortedFour = four.clone();
        sortedFive = five.clone();
        sortedSix = six.clone();
        Arrays.sort(one);
        Arrays.sort(two);
        Arrays.sort(three);
        Arrays.sort(four);
        Arrays.sort(five);
        Arrays.sort(six);
    }

    @AfterEach
    public void test() {
        assertTrue(Arrays.equals(sortedOne, one));
        assertTrue(Arrays.equals(sortedTwo, two));
        assertTrue(Arrays.equals(sortedThree, three));
        assertTrue(Arrays.equals(sortedFour, four));
        assertTrue(Arrays.equals(sortedFive, five));
        assertTrue(Arrays.equals(sortedSix, six));
    }

    @Test
    public void selectionSort() {
        SelectionSort.sort(sortedOne);
        SelectionSort.sort(sortedTwo);
        SelectionSort.sort(sortedThree);
        SelectionSort.sort(sortedFour);
        SelectionSort.sort(sortedFive);
        SelectionSort.sort(sortedSix);
    }

    @Test
    public void insertionSort() {
        InsertionSort.sort(sortedOne);
        InsertionSort.sort(sortedTwo);
        InsertionSort.sort(sortedThree);
        InsertionSort.sort(sortedFour);
        InsertionSort.sort(sortedFive);
        InsertionSort.sort(sortedSix);
    }

    @Test
    public void bubbleSort() {
        BubbleSort.sort(sortedOne);
        BubbleSort.sort(sortedTwo);
        BubbleSort.sort(sortedThree);
        BubbleSort.sort(sortedFour);
        BubbleSort.sort(sortedFive);
        BubbleSort.sort(sortedSix);
    }

    @Test
    public void shellSort() {
        ShellSort.sort(sortedOne);
        ShellSort.sort(sortedTwo);
        ShellSort.sort(sortedThree);
        ShellSort.sort(sortedFour);
        ShellSort.sort(sortedFive);
        ShellSort.sort(sortedSix);
    }

    @Test
    public void mergeSort() {
        MergeSort.sort(sortedOne);
        MergeSort.sort(sortedTwo);
        MergeSort.sort(sortedThree);
        MergeSort.sort(sortedFour);
        MergeSort.sort(sortedFive);
        MergeSort.sort(sortedSix);
    }

    @Test
    public void quickSort() {
        QuickSort.sort(sortedOne);
        QuickSort.sort(sortedTwo);
        QuickSort.sort(sortedThree);
        QuickSort.sort(sortedFour);
        QuickSort.sort(sortedFive);
        QuickSort.sort(sortedSix);
    }

    @Test
    public void heapSort() {
        HeapSort.sort(sortedOne);
        HeapSort.sort(sortedTwo);
        HeapSort.sort(sortedThree);
        HeapSort.sort(sortedFour);
        HeapSort.sort(sortedFive);
        HeapSort.sort(sortedSix);
    }
    
}