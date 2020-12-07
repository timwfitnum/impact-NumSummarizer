package com.test;
import com.company.NumberSummarizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {
    @Test
    public void testingRangeSummarizer() {
        assertEquals("1-3, 5-9, 11", toTest("1,2,3,5,6,7,8,9,11"));
        assertEquals("1, 3, 5, 7, 9, 11", toTest("1,3,5,7,9,11"));
        assertEquals("-1-3, 5-9, 11", toTest("-1,0,1,2,3,5,6,7,8,9,11"));
        assertEquals("1-3, 5-9, 11, 10000001", toTest("1,2,3,5,6,7,8,9,11,10000001"));

    }
    public String toTest(String input){
        NumberSummarizer numSum = new NumberSummarizer();
        String result = numSum.summarizeCollection(numSum.collect(input));
        return result;
    }
}
