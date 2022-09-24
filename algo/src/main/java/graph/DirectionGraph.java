package graph;

import java.util.LinkedList;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/9/24 下午3:18
 * @description Graph 有向图-邻接表存储
 */
public class DirectionGraph {


    /**
     * 图的顶点个数
     */
    private int V;

    /**
     * 声明邻接表
     */
    private LinkedList<Integer>[] adj;


    public DirectionGraph(int v) {
        this.V = v;
        //初始化，邻接表大小
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            //初始化每个顶点空的邻接表
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 为无向图中的顶点添加一条边
     * <p>
     * 无向图:因为边是连接两个顶点，需要两个顶点都存储
     * adj[s].add(t);
     * adj[t].add(s);
     * <p>
     * <p>
     * 有向图:就存一次  adj[s].add(t); s -> t
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) {
        //顶点s的链表中添加t：s -> t
        adj[s].add(t);
    }


    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }
}
