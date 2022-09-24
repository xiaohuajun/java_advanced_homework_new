package graph;

import java.util.LinkedList;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/6/4 上午11:12
 * @description Graph 图的定义-使用的是邻接表来存储-数组+链表---无向图
 * 邻接矩阵存储：
 * 1、缺点：在无向图、稀疏图中表示会浪费存储空间，因为即使没有顶点的边也会用0标识
 * 2、优点：存储简单，自然是很方便计算；基于数组存储，获取顶点之间关系时非常高效
 * 3、数组的存储对缓存友好
 * 邻接表存储（每个顶点相邻的顶点的边组成链表）：
 * 1、节省存储空间
 * 2、获取两个两个顶点关系比较耗时（就相当于链表和数组区别）
 * 3、链表存储对于缓存不友好
 * 对于查询顶点之间关系优化：
 * 可以优化链表：
 * 1）使用红黑树
 * 2）二叉查找树
 * 3）动态数据结构
 * 3.1)跳表
 * 3.2)动态有序数组，加上二分查找
 */
public class NotDirectionGraph {

    /**
     * 顶点个数
     */
    private int v;


    /**
     * 使用邻接表存储图：每个顶点连接的是关联顶点的一个链表（类似与散列表）
     */
    private LinkedList<Integer>[] adj;

    public NotDirectionGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
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
