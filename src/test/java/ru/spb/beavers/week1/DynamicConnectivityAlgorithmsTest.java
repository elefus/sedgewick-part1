package ru.spb.beavers.week1;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor
class DynamicConnectivityAlgorithmsTest {

    private static Stream<Arguments> getImplementations() {
        return Stream.of(
                Arguments.of((IntFunction<?>)QuickUnionAlgorithm::new, "QuickUnionAlgorithm"),
                Arguments.of((IntFunction<?>)QuickFindAlgorithm::new, "QuickFindAlgorithm"),
                Arguments.of((IntFunction<?>)WeightedQuickUnionAlgorithm::new, "WeightedQuickUnionAlgorithm"),
                Arguments.of((IntFunction<?>)WeightedQuickUnionOOPAlgorithm::new, "WeightedQuickUnionOOPAlgorithm"),
                Arguments.of((IntFunction<?>)QuickUnionWithCompressionToRootAlgorithm::new, "QuickUnionWithCompressionToRootAlgorithm"),
                Arguments.of((IntFunction<?>)QuickUnionWithCompressionToGrandparentAlgorithm::new, "QuickUnionWithCompressionToGrandparentAlgorithm")
        );
    }

    @ParameterizedTest(name = "[{index}] - {1}")
    @MethodSource("getImplementations")
    void connectTwoNodesAndCheckConnection(IntFunction<DynamicConnectivityAlgorithm> algorithmCreator, @SuppressWarnings("unused") String testName) {
        DynamicConnectivityAlgorithm algorithm = algorithmCreator.apply(2);

        algorithm.union(0, 1);

        assertTrue(algorithm.isConnected(0, 1));
        assertTrue(algorithm.isConnected(1, 0));
    }

    @ParameterizedTest(name = "[{index}] - {1}")
    @MethodSource("getImplementations")
    void testFromVideo(IntFunction<DynamicConnectivityAlgorithm> algorithmCreator, @SuppressWarnings("unused") String testName) {
        DynamicConnectivityAlgorithm algorithm = algorithmCreator.apply(10);

        algorithm.union(4, 3);
        algorithm.union(3, 8);
        algorithm.union(5, 6);
        algorithm.union(9, 4);
        algorithm.union(2, 1);
        algorithm.union(8, 9);

        assertTrue(algorithm.isConnected(1, 2));
        assertTrue(algorithm.isConnected(2, 1));

        assertTrue(algorithm.isConnected(3, 4));
        assertTrue(algorithm.isConnected(3, 8));
        assertTrue(algorithm.isConnected(3, 9));

        assertTrue(algorithm.isConnected(4, 3));
        assertTrue(algorithm.isConnected(4, 8));
        assertTrue(algorithm.isConnected(4, 9));

        assertTrue(algorithm.isConnected(5, 6));

        assertTrue(algorithm.isConnected(6, 5));

        assertTrue(algorithm.isConnected(8, 3));
        assertTrue(algorithm.isConnected(8, 4));
        assertTrue(algorithm.isConnected(8, 9));

        assertTrue(algorithm.isConnected(9, 3));
        assertTrue(algorithm.isConnected(9, 4));
        assertTrue(algorithm.isConnected(9, 8));

        assertFalse(algorithm.isConnected(5, 0));
        assertFalse(algorithm.isConnected(0, 5));
    }

    @ParameterizedTest(name = "[{index}] - {1}")
    @MethodSource("getImplementations")
    void unionFind10(IntFunction<DynamicConnectivityAlgorithm> algorithmCreator, @SuppressWarnings("unused") String testName) {
        try (Scanner source = openLocalFileAsScanner("DynamicConnectivity_10.txt");
             Scanner result = openLocalFileAsScanner("DynamicConnectivity_10_result.txt")) {
            int numberNodes = source.nextInt();
            DynamicConnectivityAlgorithm algorithm = algorithmCreator.apply(numberNodes);

            while (source.hasNext()) {
                algorithm.union(source.nextInt(), source.nextInt());
            }

            while (result.hasNext()) {
                assertTrue(algorithm.isConnected(result.nextInt(), result.nextInt()));
            }
        }
    }

    private static Scanner openLocalFileAsScanner(String fileName) {
        return new Scanner(new InputStreamReader(DynamicConnectivityAlgorithmsTest.class.getResourceAsStream(fileName)));
    }
}