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
    
}