package ru.spb.beavers.week1.quizzes.canonical;

import java.util.stream.IntStream;

/**
 * Union-find with specific canonical element.
 * Add a method {@code find()} to the union-find data type so that {@code find(i)} returns
 * the largest element in the connected component containing ii.
 * <br/><br/>
 * The operations, {@code union()}, {@code connected()}, and {@code find()}
 * should all take logarithmic time or better.
 * <br/><br/>
 * For example, if one of the connected components is {1,2,6,9},
 * then the {@code find()} method should return 99
 * for each of the four elements in the connected components.
 */
public class QuickUnionWithCompressionMaxToRootAlgorithm {

    private int[] nodes;

    public QuickUnionWithCompressionMaxToRootAlgorithm(int numberNodes) {
        nodes = IntStream.range(0, numberNodes).toArray();
    }

    public void union(int node1, int node2) {
        int node1root = root(node1);
        int node2root = root(node2);

        nodes[Integer.min(node1root, node2root)] = Integer.max(node1root, node2root);
    }

    public boolean isConnected(int node1, int node2) {
        return root(node1) == root(node2);
    }

    public int find(int node) {
        return root(node);
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
