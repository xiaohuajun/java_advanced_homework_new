package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/9/25 下午2:34
 * @description TopoLogicalSort 拓扑排序
 * 1、针对于有向无环图才能使用
 * 2、拓扑排序可以用于检测一个图中是否存在环
 * 3、拓扑排序的序列不是唯一的
 * 4、全局依赖关系存在局部依赖关系
 */
public class TopoLogicalSort {


    /**
     * 图的顶点数量
     */
    private static final int V = 4;


    /**
     * 初始化图-有向图
     */
    private static DirectionGraph graph = new DirectionGraph(V);


    /**
     * 拓扑排序-kahn 算法
     * 1、找一个入度为0的顶点开始放入输出序列
     * 2、图中删除这个顶点（把这个顶点可达的入度顶点减1、实际上就是删除边）
     * 3、循环1、2，直到输出所有顶点
     */
    public static void topoLogicalSort() {
        //计算每个顶点入度
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            LinkedList<Integer> adjPoints = graph.getAdj()[i];
            for (int j = 0; j < adjPoints.size(); j++) {
                Integer w = adjPoints.get(j);
                //i -> w:w的入度+1
                inDegree[w]++;
            }
        }
        Queue<Integer> outQueue = new LinkedList<>();
        //使用一个队列存储存储入度为0的顶点，作为输出使用
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                outQueue.add(i);
            }
        }
        while (!outQueue.isEmpty()) {
            int poll = outQueue.poll();
            System.out.println("->" + poll);
            //可达的顶点（出度）
            LinkedList<Integer> rePoints = graph.getAdj()[poll];
            for (int i = 0; i < rePoints.size(); i++) {
                int k = rePoints.get(i);
                //顶点相邻的可达顶点的入度减1
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    outQueue.add(k);
                }
            }
        }
    }


    /**
     * 使用dfs实现拓扑排序
     * 1、由于dfs遍历完一个顶点是会一直遍历的与这个顶点可达的顶点
     * 2、对于一个顶点W 先输出 与W可达的顶点，再输出自己
     * 综上所述
     * 1、需要构建逆邻接表
     */
    public static void topoLogicalSortForDfs() {
        //构建逆邻接表
        LinkedList<Integer>[] inverseAdj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < V; i++) {
            //顶点的邻接表
            LinkedList<Integer> iPoints = graph.getAdj()[i];
            for (int j = 0; j < iPoints.size(); j++) {
                //i -> w
                int w = iPoints.get(j);
                // w -> i
                inverseAdj[w].add(i);
            }
        }
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            //没有被访问过
            if (!visited[i]) {
                visited[i] = true;
                dfsInverseAdj(i, visited, inverseAdj);
            }
        }


    }

    private static void dfsInverseAdj(int i, boolean[] visited, LinkedList<Integer>[] inverseAdj) {
        LinkedList<Integer> integers = inverseAdj[i];
        for (int k = 0; k < integers.size(); k++) {
            int h = integers.get(k);
            //已经被访问过，继续遍历其他可达的顶点
            if (visited[h]) {
                continue;
            }
            dfsInverseAdj(h, visited, inverseAdj);
        }
        System.out.println("->" + i);

    }


    public static void main(String[] args) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        topoLogicalSortForDfs();
    }

}
