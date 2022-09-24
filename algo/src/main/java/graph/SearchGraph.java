package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/6/4 上午11:11
 * @description SearchBfs 广度优先搜索：按照层次从起点开始搜索
 */
public class SearchGraph {

    /**
     * 图的顶点数量
     */
    private static final int V = 8;

    /**
     * 初始化图-无向图
     */
    private static NotDirectionGraph graph = new NotDirectionGraph(V);

    /**
     * dfs判断是否找到终点
     */
    private static boolean isFound = false;


    /**
     * 从起点开始搜索到终点；输出路径
     * 1、三个变量存储：visited数组记录访问过的顶点，使用队列：记录下个层次需要遍历的节点
     * prev数组：存储访问过的路径：是反向存储的，输出路径反向输出
     * <p>
     * 重点：
     * 队列的特性来：存储下一个层次需要遍历的顶点
     * 路径是反向存储的
     *
     * @param s 起点
     * @param t 终点
     */
    public static void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //记录被访问过的节点
        boolean[] visited = new boolean[V];
        //记录起点被访问过
        visited[s] = true;
        //使用一个队列存储下一层次的需要遍历的顶点-没有访问过的
        Queue<Integer> queue = new LinkedList<>();
        //放入起点
        queue.add(s);
        //存储路径(初始化：-1):反向存储
        int[] prev = new int[V];
        for (int i = 0; i < V; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            //获取顶点
            int vertex = queue.poll();
            //获取顶点相邻的顶点（邻接表里存储的）并遍历
            LinkedList<Integer> adjList = graph.getAdj()[vertex];
            for (int i = 0; i < adjList.size(); i++) {
                //依次获取顶点的相邻节点
                int adjPoint = adjList.get(i);
                //判断是否被访问过
                if (!visited[adjPoint]) {
                    //存储当前顶点的路径：表示当前节点所属的是vertex顶点
                    prev[adjPoint] = vertex;
                    if (adjPoint == t) {
                        //到终点，打印路径
                        print(prev, s, t);
                        return;
                    }
                    visited[adjPoint] = true;
                    queue.add(adjPoint);
                }
            }
        }
    }


    /**
     * 深度优先搜索：从起点开始，一直往下找，直到没有顶点可以找了，回到上个顶点，继续寻找当前顶点的边，重复直到走不了就返回
     * 1、寻找问题重复性：
     * 1）从起点开始，遍历起点的邻接表的顶点
     * 2）已经被访问过或者没有顶点可访问return回到上个顶点
     * 2、得出终止条件
     * 1）已经找到终点就跳出递归
     * 3、根据问题重复性得出递推公式
     * 见第1点
     *
     * @param s 起点
     * @param t 终点
     */
    public static void dfs(int s, int t) {
        isFound = false;
        //记录被访问过的节点
        boolean[] visited = new boolean[V];
        //存储路径(初始化：-1):反向存储
        int[] prev = new int[V];
        for (int i = 0; i < V; i++) {
            prev[i] = -1;
        }
        recurFound(s, t, visited, prev);
        print(prev, s, t);

    }

    private static void recurFound(int s, int t, boolean[] visited, int[] prev) {
        //找到终点-终止条件
        if(isFound){
            return;
        }
        visited[s] = true;
        //找到终点
        if(s == t){
            isFound = true;
            return;
        }
        //获取顶点s的相邻顶点，并遍历
        LinkedList<Integer> adj = graph.getAdj()[s];
        for (int i = 0; i < adj.size(); i++) {
            int adjPoint = adj.get(i);
            if(!visited[adjPoint]){
                //顶点的路径
                prev[adjPoint] = s;
                //重复遍历下个顶点
                recurFound(adjPoint,t,visited,prev);
            }
        }
    }


    private static void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && s != t) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + "--->");
    }


    public static void main(String[] args) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        //bfs(0, 6);
        dfs(0,6);
    }


}
