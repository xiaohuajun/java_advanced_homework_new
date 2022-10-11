package base;

import graph.Vertex;
import graph.VertexMap;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/9/28 下午4:16
 * @description PriorityQueueNew 优先队列-后面用堆实现一遍（小顶堆）
 */
public class PriorityQueueNew {


    private Vertex[] node;

    /**
     * 队列大小
     */
    private int count;


    public PriorityQueueNew(int v) {
        this.count = v;
        this.node = new Vertex[v + 1];
    }


    public Vertex poll() {
        //todo 后面实现
        return null;
    }

    public void add(Vertex vertex) {
        //todo  后面实现
    }

    public void add(VertexMap vertexMap) {
        //todo  后面实现
    }

    public void update(Vertex vertex) {
        //todo  后面实现
    }

    public void update(VertexMap vertexMap) {
        //todo  后面实现
    }

    public boolean isEmpty() {
        return false;
    }


    public void clear() {
        node = null;
    }
}
