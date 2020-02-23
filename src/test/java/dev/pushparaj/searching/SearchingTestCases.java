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
    public void sequentialSearchTest() {
        int randomSearchItem = getRandomNumber(0, 50);
        assertEquals(SequentialSearch.search(one, randomSearchItem), Arrays.asList(one).indexOf(randomSearchItem));
        assertEquals(SequentialSearch.search(two, randomSearchItem), Arrays.asList(two).indexOf(randomSearchItem));
        assertEquals(SequentialSearch.search(three, randomSearchItem), Arrays.asList(three).indexOf(randomSearchItem));
        assertEquals(SequentialSearch.search(four, randomSearchItem), Arrays.asList(four).indexOf(randomSearchItem));
        assertEquals(SequentialSearch.search(five, randomSearchItem), Arrays.asList(five).indexOf(randomSearchItem));
        assertEquals(SequentialSearch.search(six, randomSearchItem), Arrays.asList(six).indexOf(randomSearchItem));
    }
    
}