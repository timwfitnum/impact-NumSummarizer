package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberSummarizer implements NumberRangeSummarizer{

//Create Col of integers from string input. Works for negatives.
    public Collection<Integer> collect(String input) {
       String[] split = input.split(",");
       List<Integer> array = new ArrayList<Integer>();
       for(int i = 0; i < split.length; i++){
           array.add(Integer.parseInt(split[i]));
       }
       Collections.sort(array);
       Collection<Integer> col = array;
       return col;
    }

// Works for negative numbers but doesnt look as pretty
    public String summarizeCollection(Collection<Integer> input) {
        StringBuilder str = new StringBuilder();
        Integer[] array = input.toArray(new Integer[0]);
        int temp = 0;
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1){
                str.append(array[i] +", ");
            }
            else if(array[i] == (array[i+1] - 1) ) {
                temp = array[i];
                while(i != array.length-1) {
                    if(array[i] == (array[i+1] - 1)) i++;
                    else break;
                }
                str.append(temp + "-" + array[i] +", ");
            } else {
                str.append(array[i] +", ");
            }
        }
        str.deleteCharAt(str.length()-2);
        String range = str.toString();
        return range;
    }
}
