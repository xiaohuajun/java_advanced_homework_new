package graph;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/9/28 下午4:56
 * @description Edge 图的边
 */
public class Edge {


    /**
     * 一条边的起点id
     */
    public int sId;

    /**
     * 终点的id
     */
    public int tId;

    /**
     * 边的权重
     */
    public int w;

    public Edge(int sId, int tId, int w) {
        this.sId = sId;
        this.tId = tId;
        this.w = w;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
