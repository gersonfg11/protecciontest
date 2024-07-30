package com.example.fibonacci.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciServiceTest {

    private FibonacciService fibonacciService = new FibonacciService();

    @Test
    public void testGenerateFibonacciSeries() {
        List<Integer> result = fibonacciService.generateFibonacciSeries(2, 3, 4);
        List<Integer> expected = List.of(13, 8, 5, 3, 2);
        assertEquals(expected, result);
    }
}
