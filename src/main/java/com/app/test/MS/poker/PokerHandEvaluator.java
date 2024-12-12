package com.app.test.MS.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
 */

class PokerHandEvaluator {

    public HandRanking evaluateHand(List<Card> hand) {
        if (isRoyalFlush(hand)) return HandRanking.ROYAL_FLUSH;
        if (isStraightFlush(hand)) return HandRanking.STRAIGHT_FLUSH;
        if (isFourOfAKind(hand)) return HandRanking.FOUR_OF_A_KIND;
        if (isFullHouse(hand)) return HandRanking.FULL_HOUSE;
        if (isFlush(hand)) return HandRanking.FLUSH;
        if (isStraight(hand)) return HandRanking.STRAIGHT;
        if (isThreeOfAKind(hand)) return HandRanking.THREE_OF_A_KIND;
        if (isTwoPair(hand)) return HandRanking.TWO_PAIR;
        if (isOnePair(hand)) return HandRanking.ONE_PAIR;
        return HandRanking.HIGH_CARD;
    }

    private boolean isRoyalFlush(List<Card> hand) {
        return isStraightFlush(hand) && hand.stream().anyMatch(card -> card.getRank() == Rank.ACE);
    }

    private boolean isStraightFlush(List<Card> hand) {
        return isFlush(hand) && isStraight(hand);
    }

    private boolean isFourOfAKind(List<Card> hand) {
        Map<Rank, Long> frequencyMap = getFrequencyMap(hand);
        return frequencyMap.containsValue(4L);
    }

    private boolean isFullHouse(List<Card> hand) {
        Map<Rank, Long> frequencyMap = getFrequencyMap(hand);
        return frequencyMap.containsValue(3L) && frequencyMap.containsValue(2L);
    }

    private boolean isFlush(List<Card> hand) {
        Suit suit = hand.get(0).getSuit();
        for (Card card : hand) {
            if (card.getSuit() != suit) return false;
        }
        return true;
    }

    private boolean isStraight(List<Card> hand) {
        List<Integer> ranks = new ArrayList<>();
        for (Card card : hand) {
            ranks.add(card.getRank().ordinal());
        }
        Collections.sort(ranks);
        for (int i = 1; i < ranks.size(); i++) {
            if (ranks.get(i) - ranks.get(i - 1) != 1) return false;
        }
        return true;
    }

    private boolean isThreeOfAKind(List<Card> hand) {
        Map<Rank, Long> frequencyMap = getFrequencyMap(hand);
        return frequencyMap.containsValue(3L);
    }

    private boolean isTwoPair(List<Card> hand) {
        Map<Rank, Long> frequencyMap = getFrequencyMap(hand);
        return frequencyMap.values().stream().filter(count -> count == 2).count() == 2;
    }

    private boolean isOnePair(List<Card> hand) {
        Map<Rank, Long> frequencyMap = getFrequencyMap(hand);
        return frequencyMap.containsValue(2L);
    }

    private Map<Rank, Long> getFrequencyMap(List<Card> hand) {
        return hand.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
    }

    private Map<Rank, Integer> getFrequencyMap1(List<Card> hand) {
        return hand.stream()
                .collect(Collectors.groupingBy(
                        Card::getRank,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }
}
