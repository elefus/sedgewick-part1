package ru.spb.beavers.week1.quizzes.social;

/**
 * Social network connectivity.
 * <br/><br/>
 * Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships.
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * <br/><br/>
 * Design an algorithm to determine the earliest time at which all members are connected.
 * <br/><br/>
 * The running time of your algorithm should be m * log(n) or better and use extra space proportional to n.
 */
public class SocialNetworkConnectivityTaskSolver {

    public long analyze(int numberUsers, Iterable<FriendshipAgreement> history) {
        WeightedQuickUnionWithCompressionToRootAlgorithm algorithm = new WeightedQuickUnionWithCompressionToRootAlgorithm(numberUsers);
        for (FriendshipAgreement agreement : history) {
            if (algorithm.union(agreement.getUserId1(), agreement.getUserId2())) {
                return agreement.getTimestamp();
            }
        }
        throw new IllegalStateException("There is no connection between all users!");
    }
}
