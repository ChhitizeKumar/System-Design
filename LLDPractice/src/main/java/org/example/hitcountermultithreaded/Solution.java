package org.example.hitcountermultithreaded;

// ****** It's better to write code in your local code editor and paste it back here *********

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// use helper.print("") or helper.println("") for printing logs else logs will not be visible.
public class Solution implements Q06WebpageVisitCounterInterface {
    private Helper06 helper;
    private int totalPages;
    private Map<Integer,Integer> visitCount;
    private final Object lock = new Object();


    public Solution(){}

    public void init(int totalPages, Helper06 helper){
        this.helper=helper;
        // helper.println("restaurant rating module initialized");
        this.totalPages = totalPages;
//        visitCount = new ConcurrentHashMap<>();
        visitCount = new HashMap<>();
    }


    // increment visit count for pageIndex by 1
    public void incrementVisitCount(int pageIndex) {

//        visitCount.put(pageIndex, visitCount.getOrDefault(pageIndex ,0) + 1);
//        visitCount.merge(pageIndex, 1, (oldValue, newValue) -> oldValue + newValue);

        synchronized (lock){
            visitCount.put(pageIndex, visitCount.getOrDefault(pageIndex ,0) + 1);
        }
    }

    // return total visit count for a given page
    public int getVisitCount(int pageIndex) {
        return visitCount.getOrDefault(pageIndex ,0);
    }
}

// uncomment below code in case you are using your local ide like intellij, eclipse etc and
// comment it back again back when you are pasting completed solution in the online CodeZym editor.
// if you don't comment it back, you will get "java.lang.AssertionError: java.lang.LinkageError"
// This will help avoid unwanted compilation errors and get method autocomplete in your local code editor.

 interface Q06WebpageVisitCounterInterface {
 void init(int totalPages, Helper06 helper);
 void incrementVisitCount(int pageIndex);
 int getVisitCount(int pageIndex);
 }

 class Helper06 {
 void print(String s){System.out.print(s);}
 void println(String s){System.out.println(s);}
 }

