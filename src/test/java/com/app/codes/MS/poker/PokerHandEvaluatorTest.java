package com.app.codes.MS.poker;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
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

 */
public class PokerHandEvaluatorTest {

    private final PokerHandEvaluator evaluator = new PokerHandEvaluator();

    @Test
    public void testRoyalFlush() {
        List<Card> royalFlush = Arrays.asList(
                new Card(Suit.HEARTS, Rank.TEN),
                new Card(Suit.HEARTS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.QUEEN),
                new Card(Suit.HEARTS, Rank.KING),
                new Card(Suit.HEARTS, Rank.ACE)
        );
        assertEquals("Failed Royal Flush Test", HandRanking.ROYAL_FLUSH, evaluator.evaluateHand(royalFlush));
    }

    @Test
    public void testStraightFlush() {
        List<Card> straightFlush = Arrays.asList(
                new Card(Suit.CLUBS, Rank.FIVE),
                new Card(Suit.CLUBS, Rank.SIX),
                new Card(Suit.CLUBS, Rank.SEVEN),
                new Card(Suit.CLUBS, Rank.EIGHT),
                new Card(Suit.CLUBS, Rank.NINE)
        );
        assertEquals("Failed Straight Flush Test", HandRanking.STRAIGHT_FLUSH, evaluator.evaluateHand(straightFlush));
    }

    @Test
    public void testFourOfAKind() {
        List<Card> fourOfAKind = Arrays.asList(
                new Card(Suit.DIAMONDS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.JACK),
                new Card(Suit.SPADES, Rank.JACK),
                new Card(Suit.CLUBS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.THREE)
        );
        assertEquals("Failed Four of a Kind Test", HandRanking.FOUR_OF_A_KIND, evaluator.evaluateHand(fourOfAKind));
    }

    @Test
    public void testFullHouse() {
        List<Card> fullHouse = Arrays.asList(
                new Card(Suit.HEARTS, Rank.TEN),
                new Card(Suit.SPADES, Rank.TEN),
                new Card(Suit.DIAMONDS, Rank.TEN),
                new Card(Suit.CLUBS, Rank.THREE),
                new Card(Suit.HEARTS, Rank.THREE)
        );
        assertEquals("Failed Full House Test", HandRanking.FULL_HOUSE, evaluator.evaluateHand(fullHouse));
    }

    @Test
    public void testFlush() {
        List<Card> flush = Arrays.asList(
                new Card(Suit.SPADES, Rank.TWO),
                new Card(Suit.SPADES, Rank.FIVE),
                new Card(Suit.SPADES, Rank.NINE),
                new Card(Suit.SPADES, Rank.JACK),
                new Card(Suit.SPADES, Rank.KING)
        );
        assertEquals("Failed Flush Test", HandRanking.FLUSH, evaluator.evaluateHand(flush));
    }

    @Test
    public void testStraight() {
        List<Card> straight = Arrays.asList(
                new Card(Suit.HEARTS, Rank.FOUR),
                new Card(Suit.SPADES, Rank.FIVE),
                new Card(Suit.CLUBS, Rank.SIX),
                new Card(Suit.DIAMONDS, Rank.SEVEN),
                new Card(Suit.SPADES, Rank.EIGHT)
        );
        assertEquals("Failed Straight Test", HandRanking.STRAIGHT, evaluator.evaluateHand(straight));
    }

    @Test
    public void testThreeOfAKind() {
        List<Card> threeOfAKind = Arrays.asList(
                new Card(Suit.HEARTS, Rank.NINE),
                new Card(Suit.SPADES, Rank.NINE),
                new Card(Suit.CLUBS, Rank.NINE),
                new Card(Suit.DIAMONDS, Rank.FOUR),
                new Card(Suit.HEARTS, Rank.SIX)
        );
        assertEquals("Failed Three of a Kind Test", HandRanking.THREE_OF_A_KIND, evaluator.evaluateHand(threeOfAKind));
    }

    @Test
    public void testTwoPair() {
        List<Card> twoPair = Arrays.asList(
                new Card(Suit.HEARTS, Rank.KING),
                new Card(Suit.SPADES, Rank.KING),
                new Card(Suit.CLUBS, Rank.FIVE),
                new Card(Suit.DIAMONDS, Rank.FIVE),
                new Card(Suit.HEARTS, Rank.TWO)
        );
        assertEquals("Failed Two Pair Test", HandRanking.TWO_PAIR, evaluator.evaluateHand(twoPair));
    }

    @Test
    public void testOnePair() {
        List<Card> onePair = Arrays.asList(
                new Card(Suit.HEARTS, Rank.EIGHT),
                new Card(Suit.SPADES, Rank.EIGHT),
                new Card(Suit.CLUBS, Rank.THREE),
                new Card(Suit.DIAMONDS, Rank.FOUR),
                new Card(Suit.HEARTS, Rank.TEN)
        );
        assertEquals("Failed One Pair Test", HandRanking.ONE_PAIR, evaluator.evaluateHand(onePair));
    }

    @Test
    public void testHighCard() {
        List<Card> highCard = Arrays.asList(
                new Card(Suit.HEARTS, Rank.TWO),
                new Card(Suit.SPADES, Rank.SIX),
                new Card(Suit.CLUBS, Rank.NINE),
                new Card(Suit.DIAMONDS, Rank.JACK),
                new Card(Suit.HEARTS, Rank.KING)
        );
        assertEquals("Failed High Card Test", HandRanking.HIGH_CARD, evaluator.evaluateHand(highCard));
    }
}
