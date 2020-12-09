package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Assuming there can be negative numbers in the list, will display as example -1, so -1,0,1 = -1-1
 * Assuming the list can be unordered, made use of sorting in that case
 * Assuming the list will be never be missing a number between commas.
 **/


public class NumberSummarizer implements NumberRangeSummarizer{

//Create Col of integers from string input. Works for negatives.
    public Collection<Integer> collect(String input) {
        //Split String into comma separated strings
       String[] split = input.split(",");
       List<Integer> array = new ArrayList<Integer>();
       // Convert strings to integers and insert into arrayList
       for(String s: split){
           array.add(Integer.parseInt(s));
       }
       //Make sure array list is sorted in corrected order for appropriate range calculations
       Collections.sort(array);

        //Return collection of integers
       return array;
    }

// Works for negative numbers but doesnt look as pretty
    public String summarizeCollection(Collection<Integer> input) {
        // Create String for building our range
        StringBuilder str = new StringBuilder();
        // Transform Collection of Integers into array of Integers
        Integer[] array = input.toArray(new Integer[0]);
        int temp;
        
        //Iterate through array building Range String
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1){
                str.append(array[i] +", ");
            }
            // If sequential
            else if(array[i] == (array[i+1] - 1) ) {
                temp = array[i];
                while(i != array.length-1) {
                    if(array[i] == (array[i+1] - 1)) i++;
                    else break;
                }
                str.append(temp + "-" + array[i] +", ");
            }
            //If not sequential
            else {
                str.append(array[i] +", ");
            }
        }
        //Remove space and comma at end.
        str.delete(str.length()-2, str.length());
        return str.toString();
    }
}
