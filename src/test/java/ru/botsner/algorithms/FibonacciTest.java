package ru.botsner.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void fibNaive() {
        long expected = 6765;
        long actual = Fibonacci.fibNaive(20);

        assertEquals(expected, actual);
    }

    @Test
    void fibNaiveMem() {
        long expected = 6765;
        long actual = Fibonacci.fibNaiveMem(20);

        assertEquals(expected, actual);
    }

    @Test
    void fibEffective() {
        long expected = 6765;
        long actual = Fibonacci.fibEffective(20);

        assertEquals(expected, actual);
    }
}