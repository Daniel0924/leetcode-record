package com.ydh.leetcode.March;

import java.util.LinkedList;
import java.util.List;

public class Solution127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord == null || endWord == null ||
                beginWord.length() == 0 || endWord.length() == 0
                || beginWord.length() != endWord.length()) {
            return 0;
        }

        //hit
        //cog
        //hot,dot,dog,lot,log
        //hit -> hot -> dot,lot, -> cog
        LinkedList<String> wordQueue = new LinkedList<>();

        int level = 1;      //表示当前替换到第几个字母了，也就是第几层
        int curnum = 1;     //表示当前层有多少个可用单词
        int nextnum = 0;    //表示下一层有多少个可用单词

        wordQueue.add(beginWord);
        while (wordQueue != null) {
            String word = wordQueue.poll();
            curnum--;

            for (int i = 0; i < word.length(); i++) {
                char[] wordunit = word.toCharArray();

                for (char j = 'a'; j < 'z'; j++) {
                    wordunit[i] = j;

                    String temp = new String(wordunit);

                    if (temp.equals(endWord) && wordList.contains(temp)) {
                        return level + 1;
                    }
                    if (wordList.contains(temp)) {
                        wordQueue.add(temp);
                        nextnum++;
                        wordList.remove(temp);
                    }
                }
            }

            if (curnum == 0) {
                curnum = nextnum;
                nextnum = 0;
                level++;
            }

        }

        return 0;
    }

    public static void main(String[] args) {

        String start = "hit";
        String end = "cog";

        String[] dict = {"hot", "dot", "dog", "lot", "log"};

        List<String> list = new LinkedList<>();


        for (String s : dict) {
            list.add(s);
        }

        System.out.println(
                new Solution127().ladderLength(start, end, list));

    }
}
