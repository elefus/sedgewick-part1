package ru.spb.beavers.week1.quizzes.social;

import lombok.Value;

@Value
public class FriendshipAgreement {
    long timestamp;
    int userId1;
    int userId2;
}
