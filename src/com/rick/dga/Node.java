package com.rick.dga;

import java.util.Vector;
/**
 * @Description: 节点
 * @author: maxiaodong     
 * @date: 2018年3月7日 下午6:36:44
 */
public class Node {
	public String name;
	public int weight;
	public Vector<Node> out=new Vector<>();;//出度
	public Vector<Node> in=new Vector<>();;//入度
	public Vector<Node> temp=new Vector<>();;//入度
	public int distance=Integer.MAX_VALUE;
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
