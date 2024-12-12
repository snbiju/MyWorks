package com.app.test.MS.poker;

import java.util.Arrays;
import java.util.List;

/*


Poker Hand Rankings:


Royal Flush: A, K, Q, J, 10, all the same suit
Straight Flush: Five consecutive cards of the same suit
Four of a Kind: Four cards of the same rank
Full House: Three cards of one rank and two of another
Flush: Five cards of the same suit, not in sequence
Straight: Five consecutive cards of different suits
Three of a Kind: Three cards of the same rank
Two Pair: Two different pairs
One Pair: Two cards of the same rank
High Card: The highest card in the hand if no other hand qualifies
Exercise 1: Identify the Poker Hand
For each set of hands below, identify the correct poker hand rank.

5♠, 5♦, 5♣, 5♥, 10♣
A♠, K♠, Q♠, J♠, 10♠
9♣, 9♦, 9♠, 2♥, 2♣
10♥, J♥, Q♥, K♥, A♥
4♠, 4♣, 6♥, 6♠, 10♦
Exercise 2: Order the Hands
Given the following hands, order them from strongest to weakest:

6♠, 7♠, 8♠, 9♠, 10♠
A♣, A♠, A♦, 3♠, 3♦
J♦, 10♣, 9♠, 8♥, 7♠
4♥, 4♠, 4♣, 2♦, 8♠
K♠, K♦, Q♥, J♠, 10♠


 */

public class PokerTest {
    public static void main(String[] args) {
        List<Card> hand = Arrays.asList(
                new Card(Suit.HEARTS, Rank.TEN),
                new Card(Suit.HEARTS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.KING),
                new Card(Suit.HEARTS, Rank.ACE)
        );

        PokerHandEvaluator evaluator = new PokerHandEvaluator();
        HandRanking ranking = evaluator.evaluateHand(hand);
        System.out.println("Hand ranking: " + ranking);
    }
}
