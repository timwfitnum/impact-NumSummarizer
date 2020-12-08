package com.company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {
    @Test
    public void testingRangeSummarizer() {
        assertEquals("1-3, 5-9, 11", toTest("1,2,3,5,6,7,8,9,11"));

    }

    @Test
    public void testOdds(){
        assertEquals("1, 3, 5, 7, 9, 11", toTest("1,3,5,7,9,11"));
    }

    @Test
    public void testNegRange(){
        assertEquals("-1-3, 5-9, 11", toTest("-1,0,1,2,3,5,6,7,8,9,11"));
    }

    @Test
    public void testLargeNum(){
        assertEquals("1-3, 5-9, 11, 10000001", toTest("1,2,3,5,6,7,8,9,11,10000001"));
    }

    @Test
    public void testLongList(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 1001; i++){
            str.append(i+",");
        }
        String testStr = str.toString();
        assertEquals("0-1000", toTest(testStr));
    }

    public String toTest(String input){
        NumberSummarizer numSum = new NumberSummarizer();
        String result = numSum.summarizeCollection(numSum.collect(input));
        return result;
    }
}
