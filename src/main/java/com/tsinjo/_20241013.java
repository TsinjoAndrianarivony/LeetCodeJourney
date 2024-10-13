package com.tsinjo;

import java.util.*;

/**
 * @author Tsinjo Andrianarivony, 2024-10-13 at 10:28 AM
 * 632. Smallest Range Covering Elements from K Lists
 */
class _20241013 {

    class Position implements Comparable<Position> {
        int value;
        int listIndex;
        int elementIndex;

        public Position(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(Position o) {
            return value - o.value;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        // Priority Queue to store elements as {value, list index, element index}
        PriorityQueue<Position> minHeap = new PriorityQueue<>();

        int lj = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;
        int[] result = new int[2];

        // Initialize the heap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new Position(value, i, 0));
            lj = Math.max(lj, value);
        }

        // Process the heap
        while (true) {
            Position position = minHeap.poll();  // Get the smallest element from the heap
            int li = position.value;

            int currRange = lj - li;

            // Update the smallest range if a smaller one is found
            if (currRange < minRange) {
                minRange = currRange;
                result = new int[]{li, lj};
            }

            // Move to the next element of the list with the smallest value
            int nextIndex = position.elementIndex + 1;
            List<Integer> nextList = nums.get(position.listIndex);

            // loop end
            if (nextIndex >= nextList.size()) return result;

            int nextValue = nextList.get(nextIndex);
            minHeap.offer(new Position(nextValue, position.listIndex, nextIndex));
            lj = Math.max(lj, nextValue);
        }
    }

}