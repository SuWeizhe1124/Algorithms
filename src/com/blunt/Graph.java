package com.blunt;

import java.util.Vector;

/**
 * @Description: 无向图
 * @author: maxiaodong     
 * @date: 2018年1月3日 下午5:55:52
 */
public class Graph {
	public Vector<Node> s=new Vector<>();//查找过的节点
	private Vector<Node> u=new Vector<>();//带查找节点
	
	public Graph(Node[] nodes) {
		for (Node node : nodes) 
			u.add(node);	
	}

	public static void main(String[] args) {
		Node a=new Node("a");
		Node b=new Node("b");
		Node c=new Node("c");
		Node d=new Node("d");
		Node e=new Node("e");
		Node f=new Node("f");
		//添加边
		a.addLine(b, 6);
		a.addLine(c, 3);
		
		b.addLine(c, 2);
		b.addLine(d, 5);
		
		c.addLine(d, 3);
		c.addLine(e, 4);
		
		d.addLine(f, 3);
		d.addLine(e, 2);
		
		e.addLine(f, 5);
		Graph graph=new Graph(new Node[] {a,b,c,d,e,f});
		graph.caculate(a, f);
	}
	public void caculate(Node a,Node b) {
		eachNode(a);
	}
	
	private void eachNode(Node node) {
		if(u.size()==0)
			return;
		s.add(node);
		u.remove(node);
		Node sort=node.getSortNode(this);
		eachNode(sort);
	}
	public Integer getDistance() {
		int d=0;
		Node f=s.get(0);
		Node se=null;
		for (int i = 1; i < this.s.size(); i++) {
			se=s.get(i);
			d+=f.siblings.get(se);
			f=s.get(i);
		}
		return d;
	}
}
