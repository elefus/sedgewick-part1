package ru.spb.beavers.week1.lectures;

import lombok.*;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WeightedQuickUnionOOPAlgorithm implements DynamicConnectivityAlgorithm {

    private final Node[] nodes;

    public WeightedQuickUnionOOPAlgorithm(int numberNodes) {
        nodes = IntStream.range(0, numberNodes)
                         .mapToObj(Node::new)
                         .toArray(Node[]::new);
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void union(int node1, int node2) {
        Stream.of(nodes[node1], nodes[node2])
              .map(Node::getRoot)
              .distinct()
              .sorted(Comparator.comparingInt(Node::getSize))
              .reduce(Node::joinTo);
    }

    @Override
    public boolean isConnected(int node1, int node2) {
        return Stream.of(nodes[node1], nodes[node2])
                     .map(Node::getRoot)
                     .distinct()
                     .count() == 1;
    }

    @Getter
    @RequiredArgsConstructor
    @EqualsAndHashCode(exclude = {"root", "size"})
    private static class Node {
        private final int index;
        private Node root = this;
        private int size = 1;

        Node getRoot() {
            Node prev = this;
            Node curr = this.root;
            while (prev != curr) {
                prev = curr;
                curr = curr.getRoot();
            }
            return curr;
        }

        Node joinTo(Node root) {
            root.size += this.size;
            this.root = root;
            return this;
        }

        @Override
        public String toString() {
            return index + " (" + size + ")" + (this == root ? "" : "-> " + root.toString());
        }
    }
}
