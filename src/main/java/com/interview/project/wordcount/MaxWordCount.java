package com.interview.project.wordcount;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Write a method or function in the major programming language of your choice that returns the longest word in a
 * sentence and its length. For example, “The cow jumped over the moon.” should return “jumped” and 6.
 * <p>
 * Assumptions:
 * 1. Special characters needs to be removed before processing.
 * 2. As the return type in java can return one type from the method I will use a string with space so the result will be "jumped 6".
 * 3. On Duplicates - Assuming first largest and first minimum string. Code can be modified to handle both.
 * 4. Total length of group of words assuming it to be iterable.
 */
public class MaxWordCount {

    /**
     * Brute Force to iterate over the String once. Comparing each word with the last found max
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param data - String or Group of words
     * @return Word with maximum length in a given string.
     */
    public String findMaxBruteForce(String data) {
        // Check for Null and Empty
        if (data == null || data.trim().length() == 0) {
            return "0";
        }

        int maxLength = 0;
        String maxWord = "";

        // Split the string into String array
        String[] dataArray = data.split(" ");

        // Loop the array to get the max word and its count.
        for (int i = 0; i < dataArray.length; i++) {
            String current = dataArray[i];

            // Remove Non Alphanumeric Character from the string
            current = current.replaceAll("[^a-zA-Z0-9]", "");

            // If current is bigger than maxWord replace it.
            if (current.length() > maxLength) {
                maxLength = current.length();
                maxWord = current;
            }
        }

        // For future use if we want to return all the max words of same count
        StringBuffer result = new StringBuffer();
        result.append(maxWord)
                .append(" ")
                .append(maxLength);

        return result.toString();
    }

    /**
     * Method to find max/ min word in a group of words using Priority Queue as Max or Min Heap
     * <p>
     * Time Complexity to Add records to Heap: O(N)
     * Time Complexity to Get result: O(1)
     * Space Complexity: O(N)
     *
     * @param data - String/ Group of words
     * @return String with max/ min word with its count
     */
    public String findMaxOrMinOptimizedUsingHeap(String data, boolean isMax) {

        // Check for Null and Empty
        if (data == null || data.trim().length() == 0) {
            return "0";
        }

        PriorityQueue<String> word = null;
        // If Maximum word length then use Comparator with Priority Queue as Max Heap
        if (isMax) {
            word = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    return b.length() - a.length();
                }
            }
            );
        } else {
            // If Minimum word length then use Priority Queue as Min Heap
            word = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    return a.length() - b.length();
                }
            });
        }

        int start = 0;

        // Iterate over the string and find the space and then add the word to the heap.
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == ' ') {
                String current = data.substring(start, i);
                word.add(current.replaceAll("[^a-zA-Z0-9]", ""));
                start = i + 1;
            }
        }

        // For future use if we want to return all the max words of same count
        StringBuffer result = new StringBuffer();
        result.append(word.peek())
                .append(" ")
                .append(word.peek().length());

        return result.toString();
    }
}
