package com.ydh.leetcode.niuke;

import java.util.*;
import java.util.stream.Collectors;

public class Solution54 {

    //记录所有只出现一次的字符
    List<Character> list = new LinkedList<>();
    //记录已经废掉的字符
    List<Character> stopList = new LinkedList<>();

    public void Insert(char ch) {

        if (!list.contains(ch) && !stopList.contains(ch)) {
            list.add(ch);
        } else if (list.contains(ch) && !stopList.contains(ch)) {
            stopList.add(ch);

            Iterator<Character> iterator = list.iterator();

            list = list.stream().filter(s -> s!= ch).collect(Collectors.toList());
        }

    }

    public char FirstAppearingOnce() {
        return list.size() > 0 ? list.get(0) : '#';
    }


    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();

        solution54.Insert('g');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('o');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('o');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('g');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('l');
        System.out.println(solution54.FirstAppearingOnce());
        solution54.Insert('e');
        System.out.println(solution54.FirstAppearingOnce());
    }
}
