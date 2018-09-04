package ru.spb.beavers.week1.quizzes.successor;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SuccessorWithDeleteTaskSolverTest {

    @Test
    void test1() {
        SuccessorWithDeleteTaskSolver solver = new SuccessorWithDeleteTaskSolver(5);

        solver.remove(1);

        assertEquals(Optional.of(0), solver.findSuccessor(0));
        assertEquals(Optional.of(2), solver.findSuccessor(1));
        assertEquals(Optional.of(2), solver.findSuccessor(2));
        assertEquals(Optional.of(3), solver.findSuccessor(3));
    }

    @Test
    void test2() {
        SuccessorWithDeleteTaskSolver solver = new SuccessorWithDeleteTaskSolver(5);

        assertThrows(NoSuchElementException.class, () -> solver.remove(5));
    }

    @Test
    void test3() {
        SuccessorWithDeleteTaskSolver solver = new SuccessorWithDeleteTaskSolver(5);

        solver.remove(4);
        solver.remove(3);

        assertFalse(solver.findSuccessor(3).isPresent());
        assertFalse(solver.findSuccessor(4).isPresent());
    }
}
