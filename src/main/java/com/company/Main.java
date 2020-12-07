package com.company;

import java.io.Console;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Console con = System.console();
        if(con == null) {
            System.err.println("System.console() returned null.");
            System.exit(1);
        }
        con.flush();
        String numInput;
        while((numInput = con.readLine("Input String?")) != null) {
            NumberSummarizer summarizer = new NumberSummarizer();
            Collection<Integer> col = summarizer.collect(numInput);
            String range = summarizer.summarizeCollection(col);

            System.out.println(range);
        }
    }
}
