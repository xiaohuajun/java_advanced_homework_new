package graph;

import java.util.LinkedList;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/6/4 上午11:12
 * @description Graph 图的定义-使用的是邻接表来存储-链表
 *
 */
public class Graph {

    /**
     * 顶点个数
     */
    private int v;


    /**
     * 使用邻接表存储图：每个顶点连接的订单组织成一个链表
     */
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 为图中的顶点添加一条边
     * 因为边是连接连个顶点，需要两个顶点都存储-无向图
     *
     * 有向图，就存一次
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }

}
