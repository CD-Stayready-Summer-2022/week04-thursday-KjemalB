package com.codedifferently.problem01;

import java.util.*;

public class Solution {
    /**
     * You will be given an array of numbers, search the array and return the longest
     * set of consecutive numbers
     * example input - {1,3,2,10,6,5,7,8}
     * return the String "Longest Set: {5 6 7 8}"
     * Even though 1,2,3 would the first consecutive set 5,6,7,8 is longer
     * @param allNumbers
     * @return
     */
    public String findLongestConsecutiveSet(Integer[] allNumbers) {
        int count = 0;
        int largest = 0;
        Set<Integer> consecutive = new HashSet<>();
        Set<Integer> largestSet = new HashSet<>();
        Map<Integer, Set<Integer>> hashmap = new HashMap<>();
        Arrays.sort(allNumbers);

        for (int i = 0; i < allNumbers.length; i++) {
            if (i > 0 && allNumbers[i] == allNumbers[i - 1] + 1) {
                count++;
                consecutive.add(allNumbers[i - 1]);
                consecutive.add(allNumbers[i]);
            } else {
                hashmap.put(consecutive.size(), consecutive);
                consecutive = new HashSet<>();
                count = 1;
            }
            largestSet = largestSet.size() >= consecutive.size() ? largestSet : consecutive;
            largest = Math.max(largest, count);

            if (i == allNumbers.length - 1) {
                hashmap.put(largest, consecutive);
            }
        }
        largestSet = hashmap.get(largest);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : largestSet) {
            stringBuilder.append(num).append(" ");
        }
        String answer = stringBuilder.toString();
        answer = answer.trim();
        answer = answer + "}";
        return answer;
    }
}
