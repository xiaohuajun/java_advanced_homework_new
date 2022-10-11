package graph;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/10/4 下午5:02
 * @description VertexMap 从真实的地图中的顶点抽象程序图的顶点结构
 */
public class VertexMap {


    /**
     * 顶点编号
     */
    public int id;

    /**
     * 顶点到起点的距离-g(n)
     */
    public int dist;

    /**
     * f(n)=g(n) + h(n)
     */
    public int f;

    /**
     * 顶点的横坐标
     */
    public int x;

    /**
     * 顶点的纵坐标
     */
    public int y;

    public VertexMap(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        dist = Integer.MAX_VALUE;
        f = Integer.MAX_VALUE;
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

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
