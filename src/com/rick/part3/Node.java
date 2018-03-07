package com.rick.part3;

import java.util.Vector;
/**
 * @Description: 节点
 * @author: maxiaodong     
 * @date: 2018年3月7日 上午00:56:42
 */
public class Node {
	public String name;//节点名称
	public int weight;//权重
	public Vector<Node> out=new Vector<>();;//出度
	public Vector<Node> in=new Vector<>();;//入度
	public Vector<Node> path=new Vector<>();;//达到该节点最优路径
	public int distance=Integer.MAX_VALUE;//起点到达当前节点所需距离   初始为无穷大（暂时无法到达该节点）
	public Node(String name,int weight) {
		this.name = name;
		this.weight=weight;
	}
	public void addLineOut(Node node) {
		out.add(node);
	}
	public void addLineIn(Node node) {
		in.add(node);
	}
}
