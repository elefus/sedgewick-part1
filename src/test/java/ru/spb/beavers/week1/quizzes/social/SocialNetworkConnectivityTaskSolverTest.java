package ru.spb.beavers.week1.quizzes.social;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SocialNetworkConnectivityTaskSolverTest {

    @Test
    void fourPeoplesWithConnections() {
        SocialNetworkConnectivityTaskSolver solver = new SocialNetworkConnectivityTaskSolver();

        long result = solver.analyze(4, Arrays.asList(
                new FriendshipAgreement(0, 0, 1),
                new FriendshipAgreement(1, 1, 3),
                new FriendshipAgreement(2, 3, 0),
                new FriendshipAgreement(3, 2, 3),
                new FriendshipAgreement(4, 0, 2)
        ));

        assertEquals(3, result);
    }
}