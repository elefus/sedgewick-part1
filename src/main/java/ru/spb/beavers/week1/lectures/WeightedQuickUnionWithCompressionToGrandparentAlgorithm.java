package ru.spb.beavers.week1.lectures;

import java.util.stream.IntStream;

public class WeightedQuickUnionWithCompressionToGrandparentAlgorithm implements DynamicConnectivityAlgorithm {

    private final int[] weights;
    private int[] nodes;

    public WeightedQuickUnionWithCompressionToGrandparentAlgorithm(int numberNodes) {
        nodes = IntStream.range(0, numberNodes)
                         .toArray();

        weights = IntStream.generate(() -> 1)
                           .limit(numberNodes)
                           .toArray();
    }

    @Override
    public void union(int node1, int node2) {
        int node1root = root(node1);
        int node2root = root(node2);

        if (node1root != node2root) {
            if (weights[node1root] < weights[node2root]) {
                nodes[node1root] = node2root;
                weights[node2root] += weights[node1root];
            } else {
                nodes[node2root] = node1root;
                weights[node1root] += weights[node2root];
            }
        }
    }

    @Override
    public boolean isConnected(int node1, int node2) {
        return root(node1) == root(node2);
    }

    private int root(int node) {
        while (node != nodes[node]) {
            nodes[node] = nodes[nodes[node]];
            node = nodes[node];
        }
        return node;
    }
}
