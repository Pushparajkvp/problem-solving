package dev.pushparaj.searching;

import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dev.pushparaj.BaseTest;

public class SearchingTestCases extends BaseTest {

    int[] one, two, three, four, five, six;
    
    @BeforeEach
    public void setup() {
        one = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        two = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        three = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        four = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        five = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
        six = getRandomNumberArray(-200, 200, getRandomNumber(0, 50));
    }

    @Test
    public void sequentialAndBinarySearchTest() {
        int randomSearchItem = getRandomNumber(0, 50);
        assertEquals(SequentialSearch.search(one, randomSearchItem), BinarySearch.search(one, randomSearchItem));
        assertEquals(SequentialSearch.search(two, randomSearchItem), BinarySearch.search(two, randomSearchItem));
        assertEquals(SequentialSearch.search(three, randomSearchItem), BinarySearch.search(three, randomSearchItem));
        assertEquals(SequentialSearch.search(four, randomSearchItem), BinarySearch.search(four, randomSearchItem));
        assertEquals(SequentialSearch.search(five, randomSearchItem), BinarySearch.search(five, randomSearchItem));
        assertEquals(SequentialSearch.search(six, randomSearchItem), BinarySearch.search(six, randomSearchItem));
    }

    @Test
    public void hashTableTest() {
        int randomSearchItem = getRandomNumber(0, 50);
        assertEquals(SequentialSearch.search(one, randomSearchItem), HashTableSeperateChaining.search(one, randomSearchItem));
        assertEquals(SequentialSearch.search(two, randomSearchItem), HashTableSeperateChaining.search(two, randomSearchItem));
        assertEquals(SequentialSearch.search(three, randomSearchItem), HashTableSeperateChaining.search(three, randomSearchItem));
        assertEquals(SequentialSearch.search(four, randomSearchItem), HashTableSeperateChaining.search(four, randomSearchItem));
        assertEquals(SequentialSearch.search(five, randomSearchItem), HashTableSeperateChaining.search(five, randomSearchItem));
        assertEquals(SequentialSearch.search(six, randomSearchItem), HashTableSeperateChaining.search(six, randomSearchItem));
    }

    @Test
    public void binarySearchTreeTest() {
        int randomSearchItem = getRandomNumber(0, 50);
        assertEquals(SequentialSearch.search(one, randomSearchItem), BinarySearchTree.search(one, randomSearchItem));
        assertEquals(SequentialSearch.search(two, randomSearchItem), BinarySearchTree.search(two, randomSearchItem));
        assertEquals(SequentialSearch.search(three, randomSearchItem), BinarySearchTree.search(three, randomSearchItem));
        assertEquals(SequentialSearch.search(four, randomSearchItem), BinarySearchTree.search(four, randomSearchItem));
        assertEquals(SequentialSearch.search(five, randomSearchItem), BinarySearchTree.search(five, randomSearchItem));
        assertEquals(SequentialSearch.search(six, randomSearchItem), BinarySearchTree.search(six, randomSearchItem));
    }
    
}