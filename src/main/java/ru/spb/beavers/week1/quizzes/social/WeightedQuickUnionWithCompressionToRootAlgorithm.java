package ru.spb.beavers.week1.quizzes.social;

import java.util.stream.IntStream;

/**
 * Alternative solution:
 * Define a counter of components.
 * At the initial state counter equals to N.
 * When the union operation performed - we need to decrement counter.
 * Final state - counter become equal to zero (all nodes joined to one component).
 */
public class WeightedQuickUnionWithCompressionToRootAlgorithm {

    private final int[] weights;
    private int[] nodes;

    public WeightedQuickUnionWithCompressionToRootAlgorithm(int numberNodes) {
        nodes = IntStream.range(0, numberNodes)
                         .toArray();

        weights = IntStream.generate(() -> 1)
                           .limit(numberNodes)
                           .toArray();
    }

    public boolean union(int node1, int node2) {
        int node1root = root(node1);
        int node2root = root(node2);

        if (node1root != node2root) {
            if (weights[node1root] < weights[node2root]) {
                nodes[node1root] = node2root;
                weights[node2root] += weights[node1root];
                return weights[node2root] == nodes.length;
            } else {
                nodes[node2root] = node1root;
                weights[node1root] += weights[node2root];
                return weights[node1root] == nodes.length;
            }
        }
        return false;
    }

    private int root(int node) {
        int parent = nodes[node];
        if (node == parent) {
            return node;
        } else {
            return nodes[node] = root(parent);
        }
    }
}
