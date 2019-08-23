package com.ydh.leetcode.tencent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {

    public HashMap<Integer, Integer> map;

    public LinkedList<Integer> list;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public void set(int key, int val) {
        if (map.containsKey(key)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == key) {
                    list.remove(i);
                    break;
                }
            }
            list.push(key);
        } else {
            if (list.size() == capacity) {
                map.remove(list.removeLast());
            }
            list.push(key);
        }
        map.put(key, val);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            for (int i = 0; i < list.size(); i++){
                if (list.get(i) == key){
                    list.remove(i);
                    break;
                }
            }
            list.push(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        String s = "aa  aaa asas";
        s.replaceAll("aa","aaa");
        System.out.println(s);
        LRUCache cache = new LRUCache(2);
        cache.set(1,1);
        cache.set(2,2);
        System.out.println(cache.get(1));
        cache.set(3,3);
        System.out.println(cache.get(1));
        cache.set(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
