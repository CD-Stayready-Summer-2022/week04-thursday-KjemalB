package com.codedifferently.problem02;

import java.util.HashMap;

public class Solution {
    public String howManyLettersDoYouSee(String input) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        char[] strArray = input.toCharArray();

        for (char ch : strArray) {
            if(charCount.containsKey(ch)) {
                charCount.put(ch, charCount.get(ch) + 1);
            } else {
                charCount.put(ch,1);
            }
        }
        return charCount.get(input).toString();
    }
}
