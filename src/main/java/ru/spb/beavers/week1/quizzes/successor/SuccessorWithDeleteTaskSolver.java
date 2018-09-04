package ru.spb.beavers.week1.quizzes.successor;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

/**
 * Successor with delete.
 * <br/><br/>
 * Given a set of n integers S={0, 1, ..., n−1} and a sequence of requests of the following form:
 * <li>Remove x from S</li>
 * <li>Find the successor of x: the smallest y in S such that y ≥ x.</li>
 * <br/>
 * Design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */
public class SuccessorWithDeleteTaskSolver {

    private final NavigableSet<Integer> values;

    public SuccessorWithDeleteTaskSolver(int numberValues) {
        values = IntStream.range(0, numberValues)
                          .boxed()
                          .collect(toCollection(TreeSet::new));
    }

    public void remove(int value) {
        if (!values.remove(value)) {
            throw new NoSuchElementException("Set doesn't contains value " + value);
        }
    }

    public Optional<Integer> findSuccessor(int value) {
        return Optional.ofNullable(values.ceiling(value));
    }
}
