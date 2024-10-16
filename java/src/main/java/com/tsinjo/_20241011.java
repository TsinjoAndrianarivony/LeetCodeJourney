package com.tsinjo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Tsinjo Andrianarivony, 2024-10-11 at 10:53 AM
 * 1942. The Number of the Smallest Unoccupied Chair
 */
public class _20241011 {

    Queue<Integer> availableChairs;

    public int smallestChair(int[][] times, int targetFriend) {
        Map<Integer, List<Double>> eventOrder = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            eventOrder.computeIfAbsent(times[i][0], k -> new ArrayList<>()).add(i + 0.0001);
            eventOrder.computeIfAbsent(times[i][1], k -> new ArrayList<>()).add(0, i - 0.0001);
        }

        Set<Integer> sortedChairs = new TreeSet<>();
        for (int i = 0; i < times.length; i++) {
            sortedChairs.add(i);
        }
        availableChairs = new PriorityQueue<>(sortedChairs);

        // order timeline
        int[] seated = new int[times.length];
        List<Integer> timeline = new ArrayList<>(eventOrder.keySet());
        Collections.sort(timeline);

        // loop through each event on each timeline
        for(int time: timeline) {
            List<Double> events = eventOrder.get(time);
            for (Double event: events) {
                int person = (int) Math.round(event);
                if (person - event < 0) {
                    int newPlacement = availableChairs.poll();
                    seated[person] = newPlacement;
                    if (person == targetFriend) {
                        return newPlacement;
                    }
                }
                else {
                    availableChairs.add(seated[person]);
                }
            }
        };

        return -1;
    }


}
