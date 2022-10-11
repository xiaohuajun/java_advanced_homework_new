package graph;

import base.PriorityQueueNew;

import java.util.LinkedList;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/10/4 下午4:57
 * @description AstarSearch A*启发搜索，优化了Dijkstra，可能会走绕路，走偏路的问题
 * 运用两个函数综合值判断：
 * n顶点到起点的距离：g(n)
 * n顶点到终点的距离：h(h)，这个函数是个估价函数，也就是启发函数，两个点直接的距离运用，欧几里得距离计算，需要平方开根号，复杂
 * 因此使用曼哈顿距离计算公式计算到终点的距离:d=|x1-x2| + |y1-y2|
 */
public class AstarSearch {


    /**
     * 订单个数
     */
    private int v = 5;

    /**
     * 图
     */
    private DirectionGraphWithWeight graph = new DirectionGraphWithWeight(v);


    /**
     * 利用A*启发搜索最短路径
     * 和Dijkstra区别：
     * 1、最小堆的计算依据：f(n),不再是dist
     * 2、计算顶点dist的同时，需要计算、更新f(n)综合值
     * 3、循环不一样，dijkstra 终点出队才结束（终点的距离在上一轮已经计算过），A*到终点就结束
     *
     * @param s 起点
     * @param t 终点
     */
    public void aStarSearch(int s, int t) {
        //存储所有的顶点
        VertexMap[] vertexMaps = new VertexMap[v];
        //路径
        int[] prev = new int[v];
        //以f(综合代价值)构建的最小堆
        PriorityQueueNew minQueue = new PriorityQueueNew(v);
        //标识每个顶点是否已经被计算过（进入过队列），计算过，再次被访问过更新堆队列中的计算过的值，
        //没被访问过，直接调整队列
        boolean[] inQueue = new boolean[v];
        //初始化起点的距离、综合值
        vertexMaps[s].dist = 0;
        vertexMaps[s].f = 0;
        minQueue.add(vertexMaps[s]);
        inQueue[s] = true;
        //遍历图中的顶点-每次取最小的
        while (!minQueue.isEmpty()) {
            //堆顶元素
            Vertex minVertex = minQueue.poll();
            //获取最小的顶点可达的顶点-邻接表存储
            LinkedList<Edge> edges = graph.getAdj()[minVertex.id];
            for (int i = 0; i < edges.size(); i++) {
                //取条与minVertex 相邻的边
                Edge edge = edges.get(i);
                //边连接的顶点
                VertexMap nextVertex = vertexMaps[edge.gettId()];
                //minVertex to nextVertex is distance
                int calDist = minVertex.dist + edge.getW();
                if (calDist < nextVertex.dist) {
                    //g(i)：nextVertex顶点到起点的距离
                    nextVertex.dist = calDist;
                    //h(i)：nextVertex顶点到终点的距离-曼哈顿公式计算
                    int manhattanDist = calManhattanDist(nextVertex, vertexMaps[t]);
                    //f(i) = h(i) + g(i)
                    nextVertex.f = nextVertex.dist + manhattanDist;
                    prev[nextVertex.id] = minVertex.id;
                    if (inQueue[nextVertex.id]) {
                        //访问过重新调整堆
                        minQueue.update(nextVertex);
                    } else {
                        minQueue.add(nextVertex);
                    }
                }
                //到达终点就结束
                if (nextVertex.id == t) {
                    minQueue.clear();
                    break;
                }
            }
            System.out.println("--" + s);
            print(s, t, prev);
        }
    }

    private void print(int s, int t, int[] prev) {
        //递归找到终点
        if (s == t) {
            print(s, prev[t], prev);
        }
        System.out.println("---->" + t);

    }


    /**
     * 运用曼哈顿距离计算公式，计算顶点到终点的距离
     *
     * @param v1 顶点1
     * @param v2 顶点2
     * @return 两个顶点的距离
     */
    private int calManhattanDist(VertexMap v1, VertexMap v2) {
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }

}
