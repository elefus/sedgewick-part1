package ru.spb.beavers.week1.quizzes.canonical;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickUnionWithCompressionMaxToRootAlgorithmTest {

    @Test
    void test1() {
        QuickUnionWithCompressionMaxToRootAlgorithm algorithm = new QuickUnionWithCompressionMaxToRootAlgorithm(6);

        algorithm.union(2, 3);
        algorithm.union(1, 2);
        algorithm.union(4, 5);
        algorithm.union(1, 4);

        assertTrue(algorithm.isConnected(1, 2));
        assertTrue(algorithm.isConnected(1, 3));
        assertTrue(algorithm.isConnected(1, 4));
        assertTrue(algorithm.isConnected(1, 5));

        assertTrue(algorithm.isConnected(2, 1));
        assertTrue(algorithm.isConnected(2, 3));
        assertTrue(algorithm.isConnected(2, 4));
        assertTrue(algorithm.isConnected(2, 5));

        assertTrue(algorithm.isConnected(3, 1));
        assertTrue(algorithm.isConnected(3, 2));
        assertTrue(algorithm.isConnected(3, 4));
        assertTrue(algorithm.isConnected(3, 5));

        assertTrue(algorithm.isConnected(4, 1));
        assertTrue(algorithm.isConnected(4, 2));
        assertTrue(algorithm.isConnected(4, 3));
        assertTrue(algorithm.isConnected(4, 5));

        assertTrue(algorithm.isConnected(5, 1));
        assertTrue(algorithm.isConnected(5, 2));
        assertTrue(algorithm.isConnected(5, 3));
        assertTrue(algorithm.isConnected(5, 4));

        assertFalse(algorithm.isConnected(0, 1));
        assertFalse(algorithm.isConnected(0, 2));
        assertFalse(algorithm.isConnected(0, 3));
        assertFalse(algorithm.isConnected(0, 4));
        assertFalse(algorithm.isConnected(0, 5));

        assertEquals(5, algorithm.find(1));
        assertEquals(5, algorithm.find(2));
        assertEquals(5, algorithm.find(3));
        assertEquals(5, algorithm.find(4));
        assertEquals(5, algorithm.find(5));
    }

    @Test
    void test2() {
        QuickUnionWithCompressionMaxToRootAlgorithm algorithm = new QuickUnionWithCompressionMaxToRootAlgorithm(5);

        algorithm.union(0, 1);
        algorithm.union(1, 0);
        algorithm.union(0, 2);

        assertTrue(algorithm.isConnected(0, 1));
        assertTrue(algorithm.isConnected(0, 2));

        assertTrue(algorithm.isConnected(1, 0));
        assertTrue(algorithm.isConnected(1, 2));

        assertTrue(algorithm.isConnected(2, 0));
        assertTrue(algorithm.isConnected(2, 1));

        assertEquals(2, algorithm.find(0));
        assertEquals(2, algorithm.find(1));
        assertEquals(2, algorithm.find(2));
    }
}