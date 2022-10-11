package graph;

import java.util.LinkedList;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/9/28 下午5:48
 * @description DirectionGraphWithWeight 带着边权重的有向图
 */
public class DirectionGraphWithWeight {

    /**
     * 图的顶点个数
     */
    private int v;


    /**
     * 图中的顶点
     */
    public VertexMap[] vertexMaps;

    /**
     * 声明邻接表-带边
     */
    private LinkedList<Edge>[] adj;

    public DirectionGraphWithWeight(int v) {
        this.v = v;
        //初始化，邻接表大小
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            //初始化每个顶点空的邻接表
            adj[i] = new LinkedList<>();
        }
        vertexMaps = new VertexMap[v];
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
    public void addEdge(int s, int t, int w) {
        //顶点s的链表中添加t：s -> t
        adj[s].add(new Edge(s, t, w));
    }

    public void addVertex(int id, int x, int y) {
        vertexMaps[id] = new VertexMap(id, x, y);
    }


    public LinkedList<Edge>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Edge>[] adj) {
        this.adj = adj;
    }
}
