package com.app.test.MS.poker;

enum HandRanking {
    HIGH_CARD,//High Card: The highest card in the hand if no other hand qualifies
    ONE_PAIR,//One Pair: Two cards of the same rank
    TWO_PAIR,//Two Pair: Two different pairs
    THREE_OF_A_KIND,//Three of a Kind: Three cards of the same rank
    STRAIGHT,//Straight: Five consecutive cards of different suits
    FLUSH,//Flush: Five cards of the same suit, not in sequence
    FULL_HOUSE,//Full House: Three cards of one rank and two of another
    FOUR_OF_A_KIND,//Four of a Kind: Four cards of the same rank
    STRAIGHT_FLUSH,//Straight Flush: Five consecutive cards of the same suit
    ROYAL_FLUSH //Royal Flush: A, K, Q, J, 10, all the same suit
}
