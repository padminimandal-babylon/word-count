package com.interview.project.wordcount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxWordCountTest {

    @ParameterizedTest
    @CsvSource(value = {"The cow jumped over the moon.|jumped 6"
            , "|0"
            , "The cow jumped over the moon. The little Dog laughed, To see such sport, And the Dish ran away with the Spoon |laughed 7"}, delimiter = '|')
    void findMaxBruteForce(String input, String expected) {
        // Given
        MaxWordCount subject = new MaxWordCount();

        // When
        String result = subject.findMaxBruteForce(input);

        // Then
        assertEquals(expected, result);
    }

    @Test
    void findMaxBruteForceForParagraph() {
        String input = "T.RowePrice - OUR PEOPLE ARE OUR GREATEST ASSET\n" +
                "We thrive because our company culture is based on collaboration and diversity of thought.\n" +
                "We invest in our people.\n" +
                "We strive for equality in our workforce and are continuously working  to maintain an environment and culture our associates are proud to be a part of.\n" +
                "People are treated with respect, and the firm is good at putting people in positions to maximize their strengths.";

        // Given
        MaxWordCount subject = new MaxWordCount();

        // When
        String result = subject.findMaxBruteForce(input);

        // Then
        String expected = "collaboration 13";
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"The cow jumped over the moon.|jumped 6"
            , "Testing is always good. Testing is always good. | Testing 7"
            , "|0"
            , "The cow jumped over the moon. The little Dog laughed, To see such sport, And the Dish ran away with the Spoon |laughed 7"}, delimiter = '|')
    void findMaxOptimized(String input, String expected) {
        // Given
        MaxWordCount subject = new MaxWordCount();

        // When
        String result = subject.findMaxOrMinOptimizedUsingHeap(input, true);

        // Then
        assertEquals(expected, result);
    }

    @Test
    void findMaxOptimizedForParagraph() {
        String input = "T.RowePrice - OUR PEOPLE ARE OUR GREATEST ASSET\n" +
                "We thrive because our company culture is based on collaboration and diversity of thought.\n" +
                "We invest in our people.\n" +
                "We strive for equality in our workforce and are continuously working  to maintain an environment and culture our associates are proud to be a part of.\n" +
                "People are treated with respect, and the firm is good at putting people in positions to maximize their strengths.";

        // Given
        MaxWordCount subject = new MaxWordCount();

        // When
        String result = subject.findMaxOrMinOptimizedUsingHeap(input, true);

        // Then
        String expected = "collaboration 13";
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"The cow jumped over the moon.|The 3"
            , "Testing is always good. Testing is always good. | is 2"
            , "|0"
            , "The cow jumped over the moon. The little Dog laughed, To see such sport, And the Dish ran away with the Spoon |To 2"}, delimiter = '|')
    void findMinOptimized(String input, String expected) {
        // Given
        MaxWordCount subject = new MaxWordCount();

        // When
        String result = subject.findMaxOrMinOptimizedUsingHeap(input, false);

        // Then
        assertEquals(expected, result);
    }
}