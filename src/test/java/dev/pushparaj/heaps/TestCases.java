package dev.pushparaj.heaps;

import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dev.pushparaj.BaseTest;
import dev.pushparaj.utils.*;

public class TestCases extends BaseTest {
    
    @Test
    public void connectRolesTest() {
        int[] arr = {2, 4, 8, 6, 6, 2};
        ConnectRopes.connect(arr);
    }
}