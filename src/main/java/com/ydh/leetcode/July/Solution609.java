package com.ydh.leetcode.July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution609 {

    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : paths) {
            String[] item = s.split(" ");

            String path = item[0];

            for (int i = 1; i < item.length; i++) {
                String[] content = item[i].split("\\(");
                String total = path + "/" + content[0];
                String value = content[1];

                if (map.containsKey(value)) {
                    map.get(value).add(total);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(total);
                    map.put(value, list);
                }

            }
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1){
                res.add(entry.getValue());
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }

}
