package graph;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/9/28 下午4:55
 * @description Vertex 顶点
 */
public class Vertex {


    /**
     * 顶点的id
     */
    public int id;

    /**
     * 起点到该顶点的距离
     */
    public int dist;

    public Vertex(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

}
