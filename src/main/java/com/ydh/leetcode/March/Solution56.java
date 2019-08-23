package com.ydh.leetcode.March;

import java.util.List;
import java.util.Map;

public class Solution56 {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval temp = intervals.get(j);

                if (temp.end > interval.start || temp.start < interval.end) {
                    Interval newInterval =
                            new Interval(Math.max(temp.start, interval.start),
                                    Math.max(temp.end, interval.end));
                    intervals.remove(j);
                    intervals.remove(i);
                    intervals.add(newInterval);
                }
            }

        }
        return intervals;

    }

    public static void main(String[] args) {


    }
}
