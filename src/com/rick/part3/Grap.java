package com.rick.part3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * @Description: 有向无环图 ps:同文件夹下是本题的拓扑排序图
 * @author: maxiaodong
 * @date: 2018年3月7日 上午00:59:51
 */
public class Grap {

    private Vector<Node> u = new Vector<>();//节点集合

    public Grap(Node[] nodes) {
        for (Node node : nodes)
            u.add(node);
    }

    /**
     * @param args 参数
     * @description: 此有向图参考【算法导论】382页第六章图算法中中【有向无环图中的单源最短路径问题】权重为随机。
     * 一开始尝试使用Dijkstra算法，但因为该算法思路是使用贪心算法，当每次选择最长路径不能保证当前
     * 节点是否会被更新导致距离变得更长，因为当前节点一旦加入被选中节点集合便不会再进行更新，所以迪杰斯特拉算法无法进行计算，至少我想了很久没想出来。。
     * 还有一种思路是使用BellmanFord算法对权值取反数应该也可以解出结果
     * @author: maxiaodong
     */
    public static void main(String[] args) {
        Node r = new Node("r", 5);
        Node s = new Node("s", 2);
        Node t = new Node("t", 3);
        Node x = new Node("x", 2);
        Node y = new Node("y", 1);
        Node z = new Node("z", 7);


        r.addLineOut(s);
        r.addLineOut(t);

        s.addLineIn(r);
        s.addLineOut(t);
        s.addLineOut(x);

        t.addLineIn(r);
        t.addLineIn(s);
        t.addLineOut(x);
        t.addLineOut(y);
        t.addLineOut(z);

        x.addLineIn(s);
        x.addLineIn(t);
//		x.addLineOut(s);//加个环做测试
        x.addLineOut(y);
        x.addLineOut(z);

        y.addLineIn(t);
        y.addLineIn(x);
        y.addLineOut(z);

        z.addLineIn(t);
        z.addLineIn(x);
        z.addLineIn(y);

        Grap grap = new Grap(new Node[]{r, s, t, x, y, z});
        grap.topologicalSort(grap);
        grap.findPath(s);

    }

    /**
     * @param grap 参数
     * @description: 进行拓扑排序（针对贵司提出的第三题中的附加题，有向图带环造成死循环的问题），建立一个FIFO队列，先把所有没有入度的节点加入，然后迭代改队列中节点，
     * 删除以当前节点为入度的节点，然后再找出没有入度的节点加入队列进行递归，
     * 直至队列为空，若此时已遍历所有节点则该图无环，否则存在环。
     * @author: maxiaodong
     */
    public void topologicalSort(Grap grap) {
        System.out.println("===========拓扑排序图============");
        Queue<Node> queue = new LinkedList<Node>();
        //先把没有入度的节点加入队列
        for (Node node : grap.u) {
            if (node.in.size() == 0) {
                queue.add(node);
            }
        }
        int counter = 0;//记录递归次数
        while (!queue.isEmpty()) {
            if (counter > u.size())
                throw new RuntimeException("该图中有环~~");
            Node temp = queue.poll();

            System.out.print(temp.name + ">");
            for (Node node : temp.out) {//没有入度节点的所有出度节点
                node.in.remove(temp);//删除出度节点的入度
                if (node.in.size() == 0) {//如果没有入度则加入队列  (说白了就是把相关的边去掉  如果没有入边则加入队列)
                    queue.add(node);
                }
            }
            counter++;
        }
        if (counter != u.size())
            throw new RuntimeException("该图中有环~~");
        System.out.println();
        System.out.println("===========拓扑排序图============");
    }

    /**
     * @param node 参数
     * @description: 查找路径
     * @author: maxiaodong
     */
    public void findPath(Node node) {
        node.distance = 0;//起点距离本身为0
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);//加入选定点为初始点
        recursion(queue);//进行递归
        Node nodeMax = findMaxDistanceNode();
        System.out.print("最长路径距离为：" + nodeMax.distance + "=============路径为:");
        for (Node n : nodeMax.path) {
            System.err.print(n.name + ">");
        }
        System.err.print(nodeMax.name);

    }

    /**
     * @return 参数
     * @description: 找到路径最长的节点, 打印距离 输出路径
     * @author: maxiaodong
     */
    public Node findMaxDistanceNode() {
        int maxPathDistance = 0;
        Node maxPathDistanceNode = null;
        for (Node n : u) {
            if (n.distance != Integer.MAX_VALUE && n.distance > maxPathDistance) {
                maxPathDistance = n.distance;
                maxPathDistanceNode = n;
            }
            System.out.println(n.name + ":" + (n.distance == Integer.MAX_VALUE ? "不可达" : n.distance));
        }
        return maxPathDistanceNode;
    }

    /**
     * @param queue 参数
     * @description: 使用BFS广度优先算法递归运算起点到所有可达点的最优距离
     * @author: maxiaodong
     */
    public void recursion(Queue<Node> queue) {
        Queue<Node> result = new LinkedList<Node>();//下一层需要递归的所有节点
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node n : node.out) {//遍历当前节点所有出度节点
                result.add(n);//加入下一层需要遍历的节点
                if (n.distance == Integer.MAX_VALUE) {//如果当前节点从未到达
                    n.distance = node.weight + n.weight;
                    n.path.add(node);//记录路径
                } else if ((node.distance + n.weight) > n.distance) {//如果当前路径距离大于已有路径距离
                    n.distance = node.distance + n.weight;
                    n.path.clear();
                    n.path.addAll(node.path);
                    n.path.add(node);
                }
            }
        }
        if (result.isEmpty())//已经遍历所有可达节点
            return;
        recursion(result);

    }
}
