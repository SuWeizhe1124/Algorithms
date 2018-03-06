package com.rick.dga;

import java.util.Vector;

public class Node {
	public String name;
	public int weight;
	public Vector<Node> out=new Vector<>();;//出度
	public Vector<Node> in=new Vector<>();;//入度
	public Node(String name) {
		this.name = name;
	}
	public void addLineOut(Node node) {
		out.add(node);
	}
	public void addLineIn(Node node) {
		in.add(node);
	}
}
