package com.ydh.leetcode.October;

public class Solution318 {

    public int maxProduct2(String[] words) {
        int maxLen = 0;

        if (words == null || words.length == 0) return 0;

        int len = words.length;

        int[] value = new int[len];

        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxLen))
                    maxLen = words[i].length() * words[j].length();
            }
        }

        return maxLen;
    }

    public int maxProduct(String[] words) {

        if (words == null || words.length == 0) {
            return 0;
        }
        int len = words.length;

        int res = 0;
        for (int i = 0; i < len; i++) {
            int pro = words[i].length();
            for (int j = i + 1; j < len; j++) {
                if (!isDuplicate(words[i], words[j])) {

                    res = res > pro * words[j].length() ? res : pro * words[j].length();
                }
            }

        }
        return res;
    }

    public boolean isDuplicate(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] test = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};

        Solution318 solution = new Solution318();

        solution.maxProduct(test);
    }
}
