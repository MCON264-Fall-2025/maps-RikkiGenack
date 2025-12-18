package hashmap_exercises;


import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2260 - Minimum Consecutive Cards to Pick Up
 *
 * You are given an integer array cards where cards[i] represents the value of the i-th card.
 * You need to pick up a sequence of cards (a contiguous subarray) that contains at least
 * two cards with the same value.
 *
 * Return the minimum length of such a subarray, or -1 if it is impossible.
 *
 * Example:
 * cards = [3, 4, 2, 3, 4, 7] -> answer = 4
 * (e.g., subarray [3, 4, 2, 3] from index 0 to 3)
 */
public class MinimumConsecutiveCards {

    /**
     * @param cards array of card values
     * @return minimum length of a contiguous subarray containing two equal cards,
     *         or -1 if no such subarray exists
     */
    public int minimumCardPickup(int[] cards) {
        // TODO: implement using a Map<Integer, Integer> to track last seen indices
        Map<Integer, Integer> map = new HashMap<>(cards.length);
        int cardValue;
        int lastIndexSeen;
        int minLength = Integer.MAX_VALUE;
        //if never saw card before:
        for (int i = 0; i < cards.length; i++) {
            cardValue = cards[i];
            if (map.get(cardValue) == null) {
                map.put(cardValue, i);
            } else {
                lastIndexSeen = map.get(cardValue);
                if (minLength > i - lastIndexSeen) {
                    minLength = i - lastIndexSeen +1;
                }

                map.put(cardValue, i);
            }

        }
        if (minLength == Integer.MAX_VALUE) {//if length was never updated
            return -1;
        }
    return minLength;
    }
}
