package org.example;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scenario1Test {

    @BeforeTest
    void beforeTestMethod() {
        System.out.println("before test");
    }

    @Test
    public void TestCaseOne() {
        System.out.println("Test case one executed");
    }
}
