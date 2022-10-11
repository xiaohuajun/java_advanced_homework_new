package graph;

import base.PriorityQueueNew;

import java.util.LinkedList;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/9/28 下午5:02
 * @description DijkstraImpl 迪杰斯特拉-图的最短路径算法
 */
public class DijkstraImpl {


    /**
     * 图的顶点数量
     */
    private static final int v = 4;


    /**
     * 初始化图-有向图
     */
    private static DirectionGraphWithWeight graph = new DirectionGraphWithWeight(v);


    /**
     * 迪杰斯特拉算法实现
     * 1、初始化所有顶点到起始顶点的距离为无穷大、路径数组
     * 2、初始化一个小顶堆（最短的路径，因此是小顶堆）
     * 3、初始化顶点是否被访问过的标识，访问过不被放入小顶堆
     * 4、从起始顶点遍历,距离设置为0，并访问可达的顶点，并计算各个顶点距离
     * 5、判断顶点是否被访问过，访问过更新重新计算的距离，并放入队列（更新小顶堆）
     * 6、重复第5步，直到访问到终点或者队列为空
     * 7、输出路径
     *
     * @param s 起点
     * @param t 终点
     */
    public void dijkstra(int s, int t) {
        //输出路径数组
        int[] prev = new int[v];
        //初始化每个顶点到起点的距离为无穷大
        Vertex[] vertices = new Vertex[v];
        for (int i = 0; i < v; i++) {
            vertices[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        //构建小顶堆-每次都能取最小
        PriorityQueueNew priorityQueueNew = new PriorityQueueNew(v);
        //顶点是否被访问过：是否需要放如队列
        boolean[] inQueue = new boolean[v];
        //从起点开始遍历，放入队列，设置起点的距离为0
        vertices[s].dist = 0;
        priorityQueueNew.add(vertices[s]);
        inQueue[s] = true;
        while (!priorityQueueNew.isEmpty()) {
            //获取堆中最小的顶点-并且删除
            Vertex minVertex = priorityQueueNew.poll();
            //到终点结束
            if (minVertex.id == t) {
                break;
            }
            //获取minVertex顶点的可达顶点、计算起点到各个可达顶点的距离
            //一个顶点可能存在多条相连的边
            LinkedList<Edge> adj = graph.getAdj()[minVertex.id];
            for (int i = 0; i < adj.size(); i++) {
                //获取当前的顶点的连着的边
                Edge edge = adj.get(i);
                //顶点之间距离-边的权重
                int w = edge.getW();
                //获取当前的顶点
                int tId = edge.gettId();
                //获取当前顶点的距离
                Vertex vertex = vertices[tId];
                int calDist = minVertex.dist + w;
                if (calDist < vertex.dist) {
                    //更新tId这个顶点的距离
                    vertex.dist = calDist;
                    //存储最小的路径
                    prev[vertex.id] = minVertex.id;
                    if (inQueue[vertex.id]) {
                        //更新当前顶点计算的新的距离-保持最小堆的结构
                        priorityQueueNew.update(vertex);
                    } else {
                        priorityQueueNew.add(vertex);
                        inQueue[vertex.id] = true;
                    }
                }
            }
        }
        System.out.println(s);
        print(s, t, prev);
    }


    private void print(int s, int t, int[] prev) {
        //递归找到终点
        if (s == t) {
            print(s, prev[t], prev);
        }
        System.out.println("---->" + t);

    }


}
