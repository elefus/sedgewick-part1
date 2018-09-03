package ru.spb.beavers.week1;

import java.util.stream.IntStream;

public class QuickUnionAlgorithm implements DynamicConnectivityAlgorithm {

    private final int[] nodes;

    public QuickUnionAlgorithm(int numberNodes) {
        nodes = IntStream.range(0, numberNodes).toArray();
    }

    @Override
    public void union(int node1, int node2) {
        nodes[root(node1)] = root(node2);
    }

    @Override
    public boolean isConnected(int node1, int node2) {
        return root(node1) == root(node2);
    }

    private int root(int node) {
        while (node != nodes[node]) {
            node = nodes[node];
        }
        return node;
    }
}
