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

    @Test
    public void testDescEvenList(){
        assertEquals("2, 4, 6, 8, 10, 12", toTest("12,10,8,6,4,2"));
    }

    @Test
    public void testDescSeqRange(){
        assertEquals("1-13", toTest("13,12,11,10,9,8,7,6,5,4,3,2,1"));
    }
    public String toTest(String input){
        NumberSummarizer numSum = new NumberSummarizer();
        String result = numSum.summarizeCollection(numSum.collect(input));
        return result;
    }
}
