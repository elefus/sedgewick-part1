package ru.spb.beavers.week1;

import java.util.stream.IntStream;

public class QuickFindAlgorithm implements DynamicConnectivityAlgorithm {

    private final int[] nodes;

    public QuickFindAlgorithm(int numberNodes) {
        nodes = IntStream.range(0, numberNodes).toArray();
    }

    @Override
    public void union(int node1, int node2) {
        int oldRoot = nodes[node1];
        int newRoot = nodes[node2];
        for (int i = 0; i < nodes.length; ++i) {
            if (nodes[i] == oldRoot) {
                nodes[i] = newRoot;
            }
        }
    }

    @Override
    public boolean isConnected(int node1, int node2) {
        return nodes[node1] == nodes[node2];
    }
}
