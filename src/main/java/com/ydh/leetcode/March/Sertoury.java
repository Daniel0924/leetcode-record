package com.ydh.leetcode.March;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Sertoury {

    private final int V;
    private int E;

    private List<Integer>[] adj;

    public Sertoury(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
}
