package InterviewQnAPractice;

//ref: https://www.browserstack.com/guide/verify-and-assert-in-selenium
/*
    In selenese langauge, there were two types of assertions, 1. Assert, 2. Verify.
    In webdriver, we are using Assertions from jUnit or TestNG, which solves the purpose

    But Verify was the assertion type, where Test will not break, it will just throw error.
    on contraray in Assertions, Test will break when assertion fails and mark the test as fail.

    So, to get alternate to Verify, we can use Soft Assert, and then the original assert was known as hard assert.

    This class demonstrates soft assert and how to use it.

    //find out - in your application testcases, where we can use SOFT assertion,
        ex: When you verify many elements displayed or not in a home page, soft assert can be used.

 */

public class SoftAssertDemo {

}
