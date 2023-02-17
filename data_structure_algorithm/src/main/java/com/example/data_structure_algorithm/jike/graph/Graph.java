package com.example.data_structure_algorithm.jike.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图有两种主要存储方法, 邻接表和邻接矩阵
 * 这里是基于领接矩阵
 */
public class Graph { // 无向图
    private int v; // 顶点的个数
    private LinkedList<Integer>[] adj; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * 广度优先搜索
     * 最短路径
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // visited是用来记录已经被访问的顶点，用来避免顶点被重复访问。
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // queue是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // prev用来记录搜索路径。
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * 广度优先搜索三度好友代码实现
     */
    public void bfsDeep(int s, int n) {
        boolean[] visited = new boolean[v];
        int[] deep = new int[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    deep[q] = deep[w] + 1;
                    visited[q] = true;
                    if (deep[q] == n) {
                        System.out.println(q);
                        break;
                    }
                    queue.add(q);
                }
            }
        }
    }


    boolean found = false; // 全局变量或者类成员变量

    private void myDfs(int s, int d) {
        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        dos(s, d, visited, pre);
        print(pre, s, d);
    }

    void dos(int pos, int destination, boolean[] visited, int[] pre) {
        LinkedList<Integer> integers = adj[pos];
        for (Integer integer : integers) {
            if (found) {
                return;
            }
            if (!visited[integer]) {
                pre[integer] = pos;
                if (destination == integer) {
                    // find
                    found = true;
                    return;
                }
                // 标记已经访问
                visited[integer] = true;
                dos(integer, destination, visited, pre);
            }
        }
    }


    /**
     * 深度优先搜索
     * 得到的不一定是最短路径
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
//        graph.bfs(0,6);

        // 深度优先
        graph.myDfs(0, 7);

    }
}