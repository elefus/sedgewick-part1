package ru.spb.beavers.week1.lectures;

public interface DynamicConnectivityAlgorithm {

    void union(int node1, int node2);

    boolean isConnected(int node1, int node2);
}
